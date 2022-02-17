package StudyNotes.hspStudy.FileEdu;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

/**
 * @version 1.0
 * @coding: utf-8
 * 文件创建的三种方式
 */
public class FileCreate {
    public static void main(String[] args) {

    }


    //方式 1 new File(String pathname)
    @Test
    public void create01() {
        String filePath = "F:\\Java_Learn\\news1.txt";
        File file = new File(filePath);
        try {
            file.createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //方式 2 new File(File parent,String child) //根据父目录文件+子路径构建
    //e:\\news2.txt
    @Test
    public void create02() {
        File parentFile = new File("F:\\Java_Learn\\");
        String fileName = "news2.txt";
        //这里的 file 对象，在 java 程序中，只是一个对象
        //只有执行了 createNewFile 方法，才会真正的，在磁盘创建该文件
        File file = new File(parentFile, fileName);
        try {
            file.createNewFile();
            System.out.println("创建成功~");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //方式 3 new File(String parent,String child) //根据父目录+子路径构建
    @Test
    public void create03() {
        //String parentPath = "e:/";
        String parentPath = "F:\\Java_Learn\\";
        String fileName = "news3.txt";
        File file = new File(parentPath, fileName);
        try {
            file.createNewFile();
            System.out.println("创建成功~");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}