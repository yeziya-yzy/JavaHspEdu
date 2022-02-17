package StudyNotes.hspStudy.project.QQ.QQServer;


import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @version 1.0
 * @coding: utf-8
 * 该类用于管理和客户端通信的线程
 */
public class ManageClientThreads {
    private static ConcurrentHashMap<String, ServerConnectClientThread> hm = new ConcurrentHashMap();

    //添加线程到hm中
    public static void addClientThread(String userId, ServerConnectClientThread serverConnectClientThread) {
        hm.put(userId, serverConnectClientThread);
    }
    //返回hm
    public static ConcurrentHashMap getHm(){
        return hm;
    }

    //根据userId返回ServerConnectClientThread线程
    public static ServerConnectClientThread ServerConnectClientThread(String userId) {
        return hm.get(userId);
    }

    //编写方法,返回在线用户列表
    public static String getOnlineUser() {
        //集合的遍历,遍历key
        Iterator<String> iterator = hm.keySet().iterator();
        String onlineUserList = "";
        while (iterator.hasNext()) {
            onlineUserList += iterator.next().toString() + " ";
        }
        return onlineUserList;
    }

    //从集合移除某个线程对象
    public static void removeServerConnectClientThread (String userId) {
        hm.remove(userId);
    }
}
