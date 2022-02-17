package StudyNotes.hspStudy.project.QQ.QQClient;

import java.util.HashMap;

/**
 * @version 1.0
 * @coding: utf-8
 * 该类管理客户端连接到服务器端的线程的类
 */
public class ManageClientConnectServerThread {
    //把多个线程放到一个HashMap集合中,key是用户ID,value是线程
    private static HashMap<String, ClientConnectServerThread> hm = new HashMap<>();

    //将某个线程放入到集合中
    public static void addClientConnectServerThread(String userId, ClientConnectServerThread clientConnectServerThread) {
        hm.put(userId, clientConnectServerThread);
    }

    //通过userId得到对应的线程
    public static ClientConnectServerThread getClientConnectServerThread(String userId) {
        return hm.get(userId);
    }
}
