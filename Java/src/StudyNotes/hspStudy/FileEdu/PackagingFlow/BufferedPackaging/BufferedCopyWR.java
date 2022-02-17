package StudyNotes.hspStudy.FileEdu.PackagingFlow.BufferedPackaging;

import java.io.*;


/**
 * @version 1.0
 * @coding: utf-8
 * 拷贝文本文件
 */
public class BufferedCopyWR {
    public static void main(String[] args) throws IOException {
        String FilePath = "F:\\Java_Learn\\测试目录\\hello.txt";
        String FilePathTo = "F:\\Java_Learn\\测试目录\\hello2.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(FilePath));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FilePathTo));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            //bufferedReader.readLine()是读取一行的内容没有换行符
            bufferedWriter.write(line);
            bufferedWriter.newLine();
        }
        System.out.println("拷贝完毕");
        bufferedReader.close();
        bufferedWriter.close();
    }
}
