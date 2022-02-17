package StudyNotes.hspStudy.NetWork.Socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @version 1.0
 * @coding: utf-8
 * 服务端(字符流)
 */
public class SocketTCP03Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9998);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String readThing;
        while ((readThing = bufferedReader.readLine()) != null) {
            System.out.println(readThing);
        }
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hell0,client");
        bufferedWriter.newLine();
        bufferedWriter.flush();
        socket.shutdownOutput();
        bufferedReader.close();
        bufferedWriter.close();
        socket.close();
        serverSocket.close();
    }
}
