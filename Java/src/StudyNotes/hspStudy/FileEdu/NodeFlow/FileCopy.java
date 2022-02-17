package StudyNotes.hspStudy.FileEdu.NodeFlow;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @version 1.0
 * @coding: utf-8
 */
public class FileCopy {
    public static void main(String[] args) {
        String path = "F:\\鱼皮 - Java 学习路线导图.xmind";
        String pathTo = "F:\\Java_Learn\\测试目录\\鱼皮 - Java 学习路线导图.xmind";
        FileOutputStream fileOutputStream = null;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(path);
            fileOutputStream = new FileOutputStream(pathTo);
            //定义字节数组提高效率
            byte[] buf = new byte[1024];
            int readLen = 0;
            //读取
            while ((readLen = fileInputStream.read(buf)) != -1) {
                //写入
                fileOutputStream.write(buf,0,readLen);
            }
            System.out.println("拷贝成功");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //避免空指针
            try {
                if (fileInputStream!=null){
                    fileInputStream.close();
                }
                if (fileOutputStream!=null){
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
