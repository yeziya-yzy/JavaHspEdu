package StudyNotes.hspStudy.NetWork.HomeWork.HomeWork01;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * @version 1.0
 * @coding: utf-8
 */
public class HomeWork01Client {
    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        char[] chars = new char[1024];
        int read;
        while (flag) {
            System.out.print("请输入要发送的内容");
            String next = scanner.next();
            if (next.equals("退出")) {
                System.out.println("正在退出服务端和客户端");
                flag = false;
            }
            bufferedWriter.write(next);
            bufferedWriter.flush();
            socket.shutdownOutput();
            //接收回应
            while ((read = bufferedReader.read(chars)) != -1) {
                System.out.println(new String(chars, 0, read));
            }
        }
        //退出
        bufferedWriter.close();
        bufferedReader.close();
        socket.close();
    }
}
