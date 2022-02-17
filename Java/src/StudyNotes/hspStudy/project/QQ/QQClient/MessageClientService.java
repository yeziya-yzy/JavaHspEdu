package StudyNotes.hspStudy.project.QQ.QQClient;

import StudyNotes.hspStudy.project.QQ.Message;
import StudyNotes.hspStudy.project.QQ.MessageType;

import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * @version 1.0
 * @coding: utf-8
 * 该对象提供和消息相关的服务方法
 */
public class MessageClientService {
    public void sendMessageToOne(String content, String senderId, String getterId) {
        //构建message
        Message message = new Message();
        message.setSender(senderId);
        message.setGetter(getterId);
        message.setContent(content);
        message.setMesType(MessageType.MESSAGE_COMM_MES);
        message.setSendTime(new Date().toString());//发送时间
        System.out.println(senderId + "对" + getterId + "说了" + content);
        //发送给服务端
        try {
            ObjectOutputStream oos = new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(senderId).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void  sendMessageToAll(String content,String senderId){
        //构建message
        Message message = new Message();
        message.setSender(senderId);
        message.setContent(content);
        message.setMesType(MessageType.MESSAGE_TO_ALL_MES);//群发消息类型
        message.setSendTime(new Date().toString());//发送时间
        System.out.println(senderId + "对大家说了: " + content);
        //发送给服务端
        try {
            ObjectOutputStream oos = new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(senderId).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
