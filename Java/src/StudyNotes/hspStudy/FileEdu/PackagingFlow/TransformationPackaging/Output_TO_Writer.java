package StudyNotes.hspStudy.FileEdu.PackagingFlow.TransformationPackaging;

import java.io.*;

/**
 * @version 1.0
 * @coding: utf-8
 */
public class Output_TO_Writer {
    public static void main(String[] args) throws IOException {
        String path = "F:\\Java_Learn\\测试目录\\hello.txt";
        // 1.创建流对象
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(path), "gbk");
        // 2.写入
        osw.write("Output_TO_Writer");
        // 3.关闭
        osw.close();
        System.out.println("保存成功~");
    }
}