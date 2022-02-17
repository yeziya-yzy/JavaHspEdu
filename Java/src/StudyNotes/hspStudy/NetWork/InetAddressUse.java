package StudyNotes.hspStudy.NetWork;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @version 1.0
 * @coding: utf-8
 * 演示InetAddress 类的使用
 */
public class InetAddressUse {
    public static void main(String[] args) throws UnknownHostException {
        //获取本机 InetAddress 对象 getLocalHost
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);//LAPTOP-5FI68JC1/10.150.68.180

        //根据指定主机名/域名获取 ip 地址对应的InetAddress对象 getByName
        InetAddress host2 = InetAddress.getByName("LAPTOP-5FI68JC1");
        System.out.println("host2= " + host2);
        InetAddress host3 = InetAddress.getByName("www.baidu.com");
        System.out.println("百度的InetAddress对象=" + host3);//www.baidu.com/36.152.44.95

        //获取 InetAddress 对象的主机名或者是域名 getHostName
        String host3Name = host3.getHostName();
        System.out.println(host3Name);

        //获取 InetAddress 对象的地址 getHostAddress
        String host3Address = host3.getHostAddress();
        System.out.println(host3Address);
    }
}
