package StudyNotes.hspStudy.NetWork.HomeWork.HomeWork01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @version 1.0
 * @coding: utf-8
 */
public class HomeWork01Server02 {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("=======服务器正在等待链接======");
        Socket socket = serverSocket.accept();
        System.out.println("====服务器链接成功====");
        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();
        boolean loop = true;
        byte[] buf = new byte[1024]; //读取用
        int readLen = 0;
        while (loop) {
            while ((readLen = inputStream.read(buf)) != -1) {
                outputStream = socket.getOutputStream();
                String readThing = new String(buf,0,readLen);
                if (readThing.equals("你好")){
                    outputStream.write("你好啊~".getBytes());
                }else if (readThing.equals("hobby")){
                    outputStream.write("编写java程序~".getBytes());
                } else if (readThing.equals("退出")){
                    outputStream.write("正在退出服务器~".getBytes());
                    loop = false;
                } else {
                    outputStream.write("你说什么,我听不懂~".getBytes());
                }
                outputStream.flush();
                socket.shutdownOutput();
            }
        }
        //退出
        inputStream.close();
        outputStream.close();
        socket.close();
        serverSocket.close();
    }
}
