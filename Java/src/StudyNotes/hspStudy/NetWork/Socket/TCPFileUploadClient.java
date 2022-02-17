package StudyNotes.hspStudy.NetWork.Socket;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @version 1.0
 * @coding: utf-8
 * 客户端
 */
public class TCPFileUploadClient {
    public static void main(String[] args) throws IOException {
        //获取图片，转换为OutputStream,收到服务器的确定,结束
        //获取Socket
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
        //本地获取图片,Socket传输
        String path = "D:\\桌面\\bingbing.jpg";
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(path));
        byte[] buf = new byte[1024];
        int readLen;
        //读取图片写入到管道中
        while ((readLen = bufferedInputStream.read(buf)) != -1) {
            bufferedOutputStream.write(buf, 0, readLen);
        }
        bufferedOutputStream.flush();
        //写入管道结束
        socket.shutdownOutput();
        //得到服务器传来的OK
        int readLen2 = 0;
        byte[] buf2 = new byte[1024];
        BufferedInputStream bufferedInputStream2 = new BufferedInputStream(socket.getInputStream());
        while ((readLen2 = bufferedInputStream2.read(buf2)) != -1) {
            System.out.println(new String(buf2,0,readLen2));
        }
        //关闭
        bufferedInputStream2.close();
        bufferedInputStream.close();
        bufferedOutputStream.close();
        socket.close();
    }
}
