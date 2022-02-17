package StudyNotes.hspStudy.NetWork.HomeWork.HomeWork02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @version 1.0
 * @coding: utf-8
 */
public class HomeWork02ReceiverB {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(8887);
        byte[] buf = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length);
        socket.receive(datagramPacket);
        int length = datagramPacket.getLength();//实际接收到的数据字节长度
        byte[] data = datagramPacket.getData();//接收到数据
        String s = new String(data, 0, length);
        System.out.println(s);
        if (s.equals("四大名著是那些")){
            byte[] bytes = "四大名著是《红楼梦》......".getBytes();
            DatagramPacket datagramPacket1 =
                    new DatagramPacket(bytes, 0, bytes.length, InetAddress.getByName("10.150.68.180"),8888);
            socket.send(datagramPacket1);
        }
        //关闭资源
        socket.close();
        System.out.println("B 端退出");
    }
}
