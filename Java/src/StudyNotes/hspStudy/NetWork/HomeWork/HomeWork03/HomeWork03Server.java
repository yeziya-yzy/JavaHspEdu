package StudyNotes.hspStudy.NetWork.HomeWork.HomeWork03;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @version 1.0
 * @coding: utf-8
 */
public class HomeWork03Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket = serverSocket.accept();
        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();
        FileInputStream fileInputStream;
        //4. IO 读取
        byte[] buf = new byte[1024];
        byte[] buf2 = new byte[1024];
        int readLen = 0;
        int readLen2 = 0;
        String pathDown = null;
        String path;
        while ((readLen = inputStream.read(buf)) != -1) {
            pathDown = new String(buf, 0, readLen);//根据读取到的实际长度，显示内容.
        }
        path = "D:\\桌面" + "\\" + pathDown;
        fileInputStream = new FileInputStream(path);
        while ((readLen2 = fileInputStream.read(buf2)) != -1) {
            outputStream.write(buf2,0,readLen2);
        }
        socket.shutdownOutput();
        fileInputStream.close();
        inputStream.close();
        outputStream.close();
        socket.close();
        serverSocket.close();
    }
}
