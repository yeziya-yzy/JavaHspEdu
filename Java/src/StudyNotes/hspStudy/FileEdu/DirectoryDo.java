package StudyNotes.hspStudy.FileEdu;

import org.junit.jupiter.api.Test;

import java.io.File;

/**
 * @version 1.0
 * @coding: utf-8
 * 目录操作
 */
public class DirectoryDo {
    public static void main(String[] args) {

    }
    //判断F:\Java_Learn\news1.txt 是否存在,如果存在就删除
    @Test
    public void m1 (){
        String filePath = "F:\\Java_Learn\\news1.txt";
        File file = new File(filePath);
        if (file.exists()){
            if (file.delete()){
                System.out.println(filePath + "该文件删除成功");
            }else {
                System.out.println(filePath + "该文件删除失败");
            }
        }else {
            System.out.println("该文件不存在");
        }
    }

    //判断目录 F:\Java_Learn\测试目录   是否存在
    //目录也被当成文件
    @Test
    public void m2 (){
        String filePath = "F:\\Java_Learn\\测试目录";
        File file = new File(filePath);
        if (file.exists()){
            if (file.delete()){
                System.out.println(filePath + "该目录删除成功");
            }else {
                System.out.println(filePath + "该目录删除失败");
            }
        }else {
            System.out.println("该目录不存在");
        }
    }

    //判断  F:\Java_Learn\测试目录 目录是否存在,如果存在就提示存在,否则就创建
    @Test
    public void m3 (){
        String directoryPath = "F:\\Java_Learn\\测试目录";
        File file = new File(directoryPath);
        if (file.exists()){
            System.out.println("该目录存在");
        }else {
            System.out.println("该目录不存在");
            if(file.mkdirs()){  //创建多级目录用这个,创建单级目录用mkdir();
                System.out.println("该目录创建成功");
            }else {
                System.out.println("该目录创建失败");
            }
        }
    }
}
