package StudyNotes.hspStudy.NetWork.Socket;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @version 1.0
 * @coding: utf-8
 * 服务端
 */
public class TCPFileUploadServer {
    public static void main(String[] args) throws IOException {
        //得到客户端发来的内容,回复OK
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socket = serverSocket.accept();
        //读取,写入
        String path = "F:\\Java_Learn\\Java\\src\\学习笔记\\hspStudy\\NetWork\\Socket\\bingbing.jpg";
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(path));
        BufferedInputStream bufferedInputStream = new BufferedInputStream(socket.getInputStream());
        byte[] buf = new byte[1024];
        int readLen;
        while ((readLen = bufferedInputStream.read(buf)) != -1) {
            bufferedOutputStream.write(buf,0,readLen);
        }
        //输出OK
        BufferedOutputStream bufferedOutputStream1 = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream1.write("OK".getBytes());
        bufferedOutputStream1.flush();
        socket.shutdownOutput();
        //关闭
        bufferedOutputStream1.close();
        bufferedOutputStream.close();
        bufferedInputStream.close();
        socket.close();
        serverSocket.close();
    }
}
