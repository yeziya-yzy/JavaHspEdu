package StudyNotes.hspStudy.NetWork.HomeWork.HomeWork01;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @version 1.0
 * @coding: utf-8
 */
public class test01 {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket = serverSocket.accept();
        boolean flag = true;
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        String readThing;
        //读取
        while (flag) {
            while ((readThing = bufferedReader.readLine()) != null) {
                if (readThing.equals("name")) {
                    bufferedWriter.write("我是nova");
                } else if (readThing.equals("hobby")) {
                    bufferedWriter.write("编写java程序");
                } else if (readThing.equals("退出")) {
                    bufferedWriter.write("服务器正在退出");
                    flag = false;
                } else {
                    bufferedWriter.write("你说啥呢");
                }
                bufferedWriter.flush();
                socket.shutdownOutput();
                if (!flag) {
                    break;
                }
            }
            while ((readThing = bufferedReader.readLine()) == null) {
                System.out.println("1");
                socket = serverSocket.accept();
                inputStream = socket.getInputStream();
                outputStream = socket.getOutputStream();
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
                if (readThing.equals("name")) {
                    bufferedWriter.write("我是nova");
                } else if (readThing.equals("hobby")) {
                    bufferedWriter.write("编写java程序");
                } else if (readThing.equals("退出")) {
                    bufferedWriter.write("服务器正在退出");
                    flag = false;
                } else {
                    bufferedWriter.write("你说啥呢");
                }
                bufferedWriter.flush();
                socket.shutdownOutput();
                if (!flag) {
                    break;
                }
            }
        }
        //退出
        bufferedReader.close();
        bufferedWriter.close();
        socket.close();
        serverSocket.close();
    }
}
