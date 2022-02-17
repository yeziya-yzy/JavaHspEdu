package StudyNotes.hspStudy.NetWork.HomeWork.HomeWork02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @version 1.0
 * @coding: utf-8
 * 发送
 */
public class HomeWork02ReceiverA {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(8888);
        byte[] data = "四大名著是那些".getBytes();
        DatagramPacket datagramPacket =
                new DatagramPacket(data, 0, data.length, InetAddress.getByName("10.150.68.180"), 8887);
        socket.send(datagramPacket);
        byte[] buf = new byte[1024];
        DatagramPacket datagramPacket1 = new DatagramPacket(buf, buf.length);
        socket.receive(datagramPacket1);
        int length = datagramPacket1.getLength();//实际接收到的数据字节长度
        data = datagramPacket1.getData();//接收到数据
        String s = new String(data, 0, length);
        System.out.println(s);
        //关闭资源
        socket.close();
        System.out.println("A 端退出");
    }
}
