package StudyNotes.hspStudy.FileEdu.PackagingFlow.TransformationPackaging;

import java.io.*;

/**
 * @version 1.0
 * @coding: utf-8
 * 使用InputStreamReader 转换流解决中文乱码问题
 * 将字节流FileInputStream转成字符流FileReader
 */
public class Input_TO_Reader {
    public static void main(String[] args) throws IOException {

        String path = "F:\\Java_Learn\\测试目录\\hello.txt";
        //解读
        //1. 把 FileInputStream 转成 InputStreamReader
        //2. 指定编码 gbk
        //InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath), "gbk");
        //3. 把 InputStreamReader 传入 BufferedReader
        //BufferedReader br = new BufferedReader(isr)
        //将 2 和 3 合在一起
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "gbk"));
        //4. 读取
        String s = br.readLine();
        System.out.println("读取内容=" + s);
        //5. 关闭外层流
        br.close();
    }
}
