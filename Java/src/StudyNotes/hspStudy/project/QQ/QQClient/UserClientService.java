package StudyNotes.hspStudy.project.QQ.QQClient;

import StudyNotes.hspStudy.project.QQ.Message;
import StudyNotes.hspStudy.project.QQ.MessageType;
import StudyNotes.hspStudy.project.QQ.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @version 1.0
 * @coding: utf-8
 * 该类完成用户登录注册等等功能
 */
public class UserClientService {
    private User u = new User();//因为我们可能在其他地方要使用user信息,因此做成成员属性
    //其他地方也可能用到Socket所以我们把它做成属性
    private Socket socket;

    //根据userId 和 pwd 到服务器验证该用户是否合法
    public boolean checkUser(String userId, String pwd) {
        boolean b = false;
        //创建User对象
        u.setUserId(userId);
        u.setPasswd(pwd);
        //连接到服务器,发送User对象
        try {
            Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9999);
            //得到ObjectOutputStream
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(u);//发送User对象

            //读取服务端回复的Message对象
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            StudyNotes.hspStudy.project.QQ.Message ms = (StudyNotes.hspStudy.project.QQ.Message) ois.readObject();

            if (ms.getMesType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)) { //登录成功

                //创建一个和服务器保持通信的线程-->创建类 ClientConnectServerThread
                ClientConnectServerThread clientConnectServerThread = new ClientConnectServerThread(socket);
                //启动客户端线程
                clientConnectServerThread.start();
                //为了后面客户端的扩展,我们把线程放到集合中管理
                ManageClientConnectServerThread.addClientConnectServerThread(userId, clientConnectServerThread);
                b = true;
            } else {
                //如果登录失败,就不能和服务器通信,关闭socket
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }

    //向服务器端请求在线用户列表
    public void onlineFriendList() {
        //发送Message,类型为MESSAGE_GET_ONLINE_FRIEND
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_GET_ONLINE_FRIEND);
        message.setSender(u.getUserId());
        //发给服务器
        //得到当前线程的Socket 对应的ObjectOutputStream
        try {
            //得到当前线程的Socket对应的ObjectOutputStream对象
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(u.getUserId()).getSocket().getOutputStream());
            //发送message
            objectOutputStream.writeObject(message);//向服务端发送message,得到在线用户列表
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //编写方法,退出客户端,并给服务器发送一个退出系统的message对象
    public void logout() {
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_CLIENT_EXIT);
        message.setSender(u.getUserId());//指定客户端
        try {
            ObjectOutputStream oos = new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(u.getUserId()).getSocket().getOutputStream());
            oos.writeObject(message);
            System.out.println(u.getUserId()+ "退出系统");
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
