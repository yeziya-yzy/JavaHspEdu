package StudyNotes.hspStudy.FileEdu.NodeFlow;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @version 1.0
 * @coding: utf-8
 * FileWriter一定要记得保存啊fileWriter.close()/flush()+关闭;!!!!!!!
 */
public class FileWriterEdu {
    public static void main(String[] args) {
        String filePath = "F:\\Java_Learn\\测试目录\\hello.txt";
        //创建 FileWriter 对象
        FileWriter fileWriter = null;
        char[] chars = {'a', 'b', 'c'};
        try {
            fileWriter = new FileWriter(filePath);//默认是覆盖写入
            // 3) write(int):写入单个字符
            fileWriter.write('H');
            // 4) write(char[]):写入指定数组
            fileWriter.write(chars);
            // 5) write(char[],off,len):写入指定数组的指定部分
            fileWriter.write("韩顺平教育".toCharArray(), 0, 3);
            // 6) write（string）：写入整个字符串
            fileWriter.write(" 你好北京~");
            fileWriter.write("风雨之后，定见彩虹");
            // 7) write(string,off,len):写入字符串的指定部分
            fileWriter.write("上海天津", 0, 2);
            //在数据量大的情况下，可以使用循环操作.
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //对应 FileWriter , 一定要关闭流，或者 flush 才能真正的把数据写入到文件
            //看源码就知道原因.
            try {
                //fileWriter.flush();
                //关闭文件流，等价 flush() + 关闭
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("程序结束...");
    }
}