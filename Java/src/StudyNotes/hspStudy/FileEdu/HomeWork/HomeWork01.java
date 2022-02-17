package StudyNotes.hspStudy.FileEdu.HomeWork;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @version 1.0
 * @coding: utf-8
 */
public class HomeWork01 {
    public static void main(String[] args) {

    }
    @Test
    public void m1(){  //这里的代码应该改成过关斩将式,都是判断反的,这样不用写else,代码更加简洁
        String filePath = "F:\\Java_Learn\\测试目录\\mytemp";
        File file = new File(filePath);
        if (file.exists()){
            System.out.println("文件夹存在");
        }else {
            if (file.mkdirs()){
                System.out.println("文件夹创建成功");
            }else {
                System.out.println("文件夹创建失败");
            }
        }
    }
    @Test
    public void m2() throws IOException {
        String filePath = "F:\\Java_Learn\\测试目录\\mytemp\\hello3.txt";
        File file = new File(filePath);
        FileWriter writer = null;
        if(file.exists()){
            System.out.println("文件存在,开始写入");
            writer = new FileWriter(filePath);
            writer.write("hello3,world~");
        }else {
            if (file.createNewFile()) {
                System.out.println("文件创建成功,开始写入");
                writer = new FileWriter(filePath);
                writer.write("hello3,world~");
            }
        }
        if (writer!=null)writer.close();
    }
}
