package StudyNotes.hspStudy.FileEdu.PackagingFlow.BufferedPackaging;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @version 1.0
 * @coding: utf-8
 * 演示BufferedWriter的使用
 */
public class BufferedWriterUse {
    public static void main(String[] args) throws IOException {
        String filePath = "F:\\Java_Learn\\测试目录\\hello.txt";
        //创建BufferedWriter
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath,true));//追加
        bufferedWriter.write("加入演示BufferedWriter的使用");
        bufferedWriter.newLine();//插入一个和系统相关的换行
        //只要关闭外部即可,内部会自动关闭
        bufferedWriter.close();
    }
}
