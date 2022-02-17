package StudyNotes.hspStudy.project.QQ.QQServer;

import StudyNotes.hspStudy.project.QQ.Message;
import StudyNotes.hspStudy.project.QQ.MessageType;
import StudyNotes.hspStudy.project.QQ.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @version 1.0
 * @coding: utf-8
 * 这是服务端,在监听9999,等待客户端的连接,并保持通信
 */
public class QQServer {

    private ServerSocket ss = null;
    //创建一个集合,存放多个用户
    //ConcurrentHashMap是多线程的
    private static ConcurrentHashMap<String, User> validUsers = new ConcurrentHashMap<>();
    static {  //在静态代码块,初始化validUsers
        validUsers.put("100", new User("100", "123456"));
        validUsers.put("200", new User("200", "123456"));
        validUsers.put("300", new User("300", "123456"));
        validUsers.put("紫霞仙子", new User("紫霞仙子", "123456"));
        validUsers.put("至尊宝", new User("至尊宝", "123456"));
    }
    //验证用户是否有效的方法
    private boolean checkUser(String userId,String passwd){
        User user = validUsers.get(userId);
        if (user==null){  //userId没有在validUsers中
            return false;
        }
        if (!user.getPasswd().equals(passwd)){//userId正确,但是密码错误
            return false;
        }
        return true;
    }
    public QQServer() {
        //端口可以写在配置文件中
        try {

            System.out.println("服务端在9999端口监听");
            ss = new ServerSocket(9999);

            while (true) { //当和某个客户端连接后,会继续监听,因此用while
                Socket socket = ss.accept();
                //得到socket关联的对象输入流
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                //得到socket关联的对象输出流
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                StudyNotes.hspStudy.project.QQ.User u = (StudyNotes.hspStudy.project.QQ.User) ois.readObject();//读取客户端的User对象
                //创建Message对象,回复客户端
                Message message = new Message();
                //验证用户
                if (checkUser(u.getUserId(),u.getPasswd())) {
                    //登录成功
                    message.setMesType(MessageType.MESSAGE_LOGIN_SUCCEED);
                    //将Message对象回复给客户端
                    oos.writeObject(message);
                    //创建一条线程(有一个socket对象)和客户端保持连接进行通信
                    ServerConnectClientThread serverConnectClientThread = new ServerConnectClientThread(socket, u.getUserId());
                    serverConnectClientThread.start();
                    //把该线程对象放到集合中进行管理
                    ManageClientThreads.addClientThread(u.getUserId(), serverConnectClientThread);
                } else {
                    //登录失败
                    System.out.println("用户 id =" + u.getUserId() + "  pwd=" + u.getPasswd() + " 登录失败");
                    message.setMesType(MessageType.MESSAGE_LOGIN_FAIL);
                    oos.writeObject(message);
                    //关闭socket
                    socket.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //如果服务端退出while循环,说明服务器端不再监听,要关闭ServerSocket
            try {
                ss.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
