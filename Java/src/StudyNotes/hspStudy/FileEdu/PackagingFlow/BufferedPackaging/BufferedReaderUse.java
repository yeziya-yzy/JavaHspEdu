package StudyNotes.hspStudy.FileEdu.PackagingFlow.BufferedPackaging;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @version 1.0
 * @coding: utf-8
 * BufferedReader使用
 */
public class BufferedReaderUse {
    public static void main(String[] args) throws IOException {
        String filePath = "F:\\Java_Learn\\测试目录\\hello.txt";
        //创建 bufferedReader
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        //读取
        String line; //按行读取, 效率高
        //说明(可以看开发文档)
        //1. bufferedReader.readLine() 是按行读取文件
        //2. 当返回 null 时，表示文件读取完毕
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        //关闭流, 这里注意，只需要关闭 BufferedReader ，因为底层会自动的去关闭 节点流
        bufferedReader.close();
    }
}
