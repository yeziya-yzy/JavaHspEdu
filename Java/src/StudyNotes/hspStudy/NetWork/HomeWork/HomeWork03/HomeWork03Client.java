package StudyNotes.hspStudy.NetWork.HomeWork.HomeWork03;

import java.io.FileOutputStream;
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
public class HomeWork03Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();
        Scanner scanner = new Scanner(System.in);
        FileOutputStream fileOutputStream;
        System.out.println("请输入要获取的文件");
        String next = scanner.next();
        String path = "F:\\Java_Learn\\Java\\src\\学习笔记\\hspStudy\\NetWork\\HomeWork\\HomeWork03\\" + next;
        outputStream.write(next.getBytes());
        socket.shutdownOutput();
        byte[] buf = new byte[1024];
        int readLen = 0;
        fileOutputStream = new FileOutputStream(path);
        while ((readLen = inputStream.read(buf)) != -1) {
            fileOutputStream.write(buf, 0, readLen);
        }
        fileOutputStream.close();
        inputStream.close();
        outputStream.close();
        socket.close();
    }
}
