package 案例.test;

import java.io.*;

/**
 * @version 1.0
 * @coding: utf-8
 */
public class MyServer {
    public static void main(String[] args) throws Exception {
        //获取数据的路径
        File file = new File("D:\\桌面\\新建文本文档.txt");
        //写入文件名字
        //获取file下面的文件名字
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String s = bufferedReader.readLine();
        System.out.println(s);
    }
}