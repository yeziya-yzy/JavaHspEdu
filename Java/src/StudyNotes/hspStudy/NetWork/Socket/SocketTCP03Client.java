package StudyNotes.hspStudy.NetWork.Socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @version 1.0
 * @coding: utf-8
 * 客户端(字符流)
 */
public class SocketTCP03Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(),9998);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bufferedWriter.write("hello,server 字符流");
        bufferedWriter.newLine();//表示写入内容的结束,取代socket.shutdownOutput();但是对方要用readLine()接收 (这个好像没什么用..)
        bufferedWriter.flush(); //字符流要手动刷新,否者数据不会写入数据通道
        socket.shutdownOutput();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String readThing;
        while ((readThing = bufferedReader.readLine()) != null) {
            System.out.println(readThing);
        }
        bufferedWriter.close();
        bufferedReader.close();
        socket.close();
    }
}
