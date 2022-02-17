package StudyNotes.hspStudy.project.QQ.QQServer;

import StudyNotes.hspStudy.project.QQ.Message;
import StudyNotes.hspStudy.project.QQ.MessageType;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @version 1.0
 * @coding: utf-8
 * 该类对应的对象和某个客户端保持通信
 */
public class ServerConnectClientThread extends Thread {

    private Socket socket;
    private String userId;//连接的服务端用户ID

    public ServerConnectClientThread(Socket socket, String userId) {
        this.socket = socket;
        this.userId = userId;
    }

    public Socket getSocket() {
        return socket;
    }

    @Override
    public void run() { //线程运行,发送和接收消息
        while (true) {
            try {
                System.out.println("服务端和客户端" + userId + "保持通信,读取数据...");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                StudyNotes.hspStudy.project.QQ.Message message = (StudyNotes.hspStudy.project.QQ.Message) ois.readObject();
                //使用message,根据message的类型做出相应的处理
                if (message.getMesType().equals(MessageType.MESSAGE_GET_ONLINE_FRIEND)) {
                    //客户端要用户的在线列表
                    System.out.println(message.getSender() + "要用户的在线列表");
                    String onlineUser = ManageClientThreads.getOnlineUser();//调用方法得到用户的在线列表
                    Message message2 = new Message();
                    message2.setMesType(MessageType.MESSAGE_RET_ONLINE_FRIEND);
                    message2.setContent(onlineUser);
                    message2.setGetter(message.getSender());
                    //返回客户端
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject(message2);

                } else if (message.getMesType().equals(MessageType.MESSAGE_CLIENT_EXIT)) {
                    System.out.println(message.getSender() + " 退出");
                    //删除对应的客户端在集合中的线程
                    ManageClientThreads.removeServerConnectClientThread(message.getSender());
                    socket.close();//关闭线程所持有的socket对象
                    //退出线程
                    break;
                } else if (message.getMesType().equals(MessageType.MESSAGE_COMM_MES)) {//私聊
                    //得到ID再得到通信的线程
                    ServerConnectClientThread serverConnectClientThread = ManageClientThreads.ServerConnectClientThread(message.getGetter());
                    ObjectOutputStream oos = new ObjectOutputStream(serverConnectClientThread.getSocket().getOutputStream());
                    oos.writeObject(message);//转发.客户不在线可以保存到数据库,这样可以离线留言
                } else if (message.getMesType().equals(MessageType.MESSAGE_TO_ALL_MES)) {//群发消息
                    //遍历集合,取出socket,发送message
                    ConcurrentHashMap<String ,ServerConnectClientThread> hm = ManageClientThreads.getHm(); //得到集合
                    Iterator iterator = hm.keySet().iterator();//得到迭代器
                    while (iterator.hasNext()) {
                        String ID = iterator.next().toString(); //得到Id
                        if (!ID.equals(message.getSender())) { //得到发送用户
                            ObjectOutputStream oos = new ObjectOutputStream(hm.get(ID).getSocket().getOutputStream());
                            oos.writeObject(message);//转发.客户不在线可以保存到数据库,这样可以离线留言
                        }
                    }
                } else {
                    System.out.println("其他业务");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
