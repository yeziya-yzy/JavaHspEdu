package StudyNotes.hspStudy.NetWork.HomeWork.HomeWork01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * @version 1.0
 * @coding: utf-8
 */
public class HomeWork01Client02 {
    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();
        boolean loop = true;
        byte[] buf = new byte[1024]; //读取用
        int readLen = 0;
        Scanner scanner = new Scanner(System.in);
        while (loop) {
            System.out.print("请输入要发送的内容");
            String next = scanner.next();
            outputStream = socket.getOutputStream();
            System.out.println(socket.isClosed());
            outputStream.write(next.getBytes());
            if (next.equals("退出")) {
                System.out.print("正在退出客户端");
                loop = false;
            }
            outputStream.flush();
            System.out.println(socket.isClosed());
            while ((readLen = inputStream.read(buf)) != -1) {
                System.out.println(new String(buf,0,readLen));
            }
        }
        inputStream.close();
        outputStream.close();
        socket.close();
    }
}
