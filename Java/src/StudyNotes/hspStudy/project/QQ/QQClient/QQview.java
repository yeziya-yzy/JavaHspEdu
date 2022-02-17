package StudyNotes.hspStudy.project.QQ.QQClient;

import StudyNotes.hspStudy.project.QQ.Utility;

/**
 * @version 1.0
 * @coding: utf-8
 * 客户端菜单界面
 */
public class QQview {

    private boolean loop = true;//控制是否显示主菜单
    private String key = "";//接收用户输入
    //用于登录服务器和注册用户
    private UserClientService userClientService = new UserClientService();
    //用于用户对象的私聊群聊
    private MessageClientService messageClientService = new MessageClientService();
    public static void main(String[] args) {
        new QQview().mainMenu();
        System.out.println("用户端退出系统");
    }

    //显示主菜单
    private void mainMenu() {
        while (loop) {
            System.out.println("欢迎登录网络通讯系统");
            System.out.println("\t\t 1 登录系统");
            System.out.println("\t\t 9 退出系统");
            System.out.print("请输入你的选择");
            key = Utility.readString(1);

            //根据用户输入来处理不同的逻辑
            switch (key) {
                case "1":
                    System.out.print("请输入你的账号:");
                    String userId = Utility.readString(50);
                    System.out.print("请输入你的密码:");
                    String userPwd = Utility.readString(15);
                    //构建User对象，发送给服务器验证该用户是否合法
                    //编写UserClientService[用户登录,注册]
                    if (userClientService.checkUser(userId, userPwd)) {//合法的情况下
                        System.out.println("==========欢迎(用户" + userId + "登录成功)==========");
                        //进入二级菜单
                        while (loop) {
                            System.out.println("====网络通信系统二级菜单(用户" + userId + ")====");
                            System.out.println("\t\t1 显示在线用户课表");
                            System.out.println("\t\t2 群发消息");
                            System.out.println("\t\t3 私聊消息");
                            System.out.println("\t\t4 发送文件");
                            System.out.println("\t\t9 退出系统");
                            System.out.print("请输入你的选择");
                            key = Utility.readString(1);
                            switch (key){
                                case "1":
                                    //UserClientService中用方法显示在线用户课表
                                    userClientService.onlineFriendList();
                                    break;
                                case "2":
                                    System.out.println("请输入要对大家说的话");
                                    String s = Utility.readString(50);
                                    //调用方法,将消息封装成一个对象
                                    messageClientService.sendMessageToAll(s, userId);
                                    break;
                                case "3":
                                    System.out.print("请输入聊天对象(在线):");
                                    String getterId = Utility.readString(20);
                                    System.out.println("请输入传入内容:");
                                    String content = Utility.readString(20);
                                    //编写一个方法,将消息发给服务器
                                    messageClientService.sendMessageToOne(content,userId,getterId);
                                    break;
                                case "4":
                                    System.out.println("\t\t4 发送文件");
                                    break;
                                case "9":
                                    //调用方法,给服务器发送退出
                                    userClientService.logout();
                                    loop = false;
                                    break;
                            }
                        }
                    } else { //验证不成功
                        System.out.println("登录失败");
                    }
                    break;
                case "9":
                    loop = false;
                    break;
            }
        }
    }
}
