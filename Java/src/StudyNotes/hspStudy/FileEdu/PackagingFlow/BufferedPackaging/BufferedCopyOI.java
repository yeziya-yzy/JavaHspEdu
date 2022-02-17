package StudyNotes.hspStudy.FileEdu.PackagingFlow.BufferedPackaging;

import java.io.*;

/**
 * @version 1.0
 * @coding: utf-8
 * 拷贝图片文件(用BufferedInputStream和BufferedOutputStream)
 * 完成二进制文件的拷贝
 */
public class BufferedCopyOI {
    public static void main(String[] args) throws IOException {
        String FilePath = "F:\\Java_Learn\\测试目录\\阿里巴巴Java开发手册（详尽版）.pdf";
        String FilePathTo = "F:\\Java_Learn\\测试目录\\阿里巴巴Java开发手册（复制版）.pdf";
        //创建BufferedInputStream和BufferedOutputStream
        BufferedInputStream bufferedInput = new BufferedInputStream(new FileInputStream(FilePath));
        BufferedOutputStream bufferedOutput = new BufferedOutputStream(new FileOutputStream(FilePathTo));
        int readLong;
        byte[] buf = new byte[1024];
        while ((readLong = bufferedInput.read(buf)) != -1) {
            //bufferedReader.readLine()是读取一行的内容没有换行符
            bufferedOutput.write(buf, 0, readLong);
        }
        System.out.println("拷贝完毕");
        bufferedInput.close();
        bufferedOutput.close();
    }
}
