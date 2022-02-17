package StudyNotes.hspStudy.FileEdu.HomeWork;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @version 1.0
 * @coding: utf-8
 */
public class HomeWork02 {
    @Test
    public void m1() throws IOException {
        String filePath= "F:\\Java_Learn\\测试目录\\hello.txt";
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath),"utf-8"));
        String readThing;
        int i = 1;
        while ((readThing = bufferedReader.readLine())!=null){
            System.out.println("第"+(i++)+"行内容为  "+readThing);
        }
        bufferedReader.close();
    }
}
