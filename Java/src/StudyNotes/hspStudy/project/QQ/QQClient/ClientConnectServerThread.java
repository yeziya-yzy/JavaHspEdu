package StudyNotes.hspStudy.project.QQ.QQClient;

import StudyNotes.hspStudy.project.QQ.Message;
import StudyNotes.hspStudy.project.QQ.MessageType;

import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * @version 1.0
 * @coding: utf-8
 */
public class ClientConnectServerThread extends Thread {
    //该线程需要持有Socket
    private Socket socket;

    public ClientConnectServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        //线程是要在后台和服务器一直通讯
        while (true) {
            System.out.println("客户端等待读取从服务器端来的内容");
            try {
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                //如果服务器没有发送过来,线程会阻塞在这里
                Message message = (Message)ois.readObject();
                //之后再使用message
                //判断message的类型,做出相应的业务处理
                //读取到服务端返回的用户列表
                if (message.getMesType().equals(MessageType.MESSAGE_RET_ONLINE_FRIEND)) {
                    //取出在线列表信息,并显示
                    String[] onlineUsers = message.getContent().split(" ");
                    System.out.println("\n==========当前在线用户列表==========");
                    for (String onlineUser : onlineUsers) {
                        System.out.println("用户: " + onlineUser);
                    }
                } else if (message.getMesType().equals(MessageType.MESSAGE_COMM_MES)) { //普通的聊天消息
                    //显示
                    System.out.println("\n"+message.getSender()+"对"+message.getGetter()+"说:"+message.getContent()+"时间为:"+message.getSendTime());
                } else if (message.getMesType().equals(MessageType.MESSAGE_TO_ALL_MES)){
                    System.out.println("\n" + message.getSender() + " 对大家说:  " + message.getContent());//显示在客户端的控制台
                }
                else {
                    System.out.println("读取到其他类型......");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //为了方便的得到Socket
    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
}
