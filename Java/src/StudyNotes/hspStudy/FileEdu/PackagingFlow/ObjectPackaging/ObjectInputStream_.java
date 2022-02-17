package StudyNotes.hspStudy.FileEdu.PackagingFlow.ObjectPackaging;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * @version 1.0
 * @coding: utf-8
 * 反序列化
 */
public class ObjectInputStream_ {
    public static void main(String[] args) throws Exception {
        String path = "F:\\Java_Learn\\测试目录\\ObjectOutStream.dat";
        // 1.创建流对象
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
        // 2.读取， 注意顺序(要和保存数据一致)
        System.out.println(ois.readInt());
        System.out.println(ois.readBoolean());
        System.out.println(ois.readChar());
        System.out.println(ois.readDouble());
        System.out.println(ois.readUTF());//字符串
        System.out.println(ois.readObject());//如果要用到Dog类,要把它引入过来要求和序列化保存的那个位置相同
        // 3.关闭
        ois.close();
        System.out.println("以反序列化的方式读取(恢复)ok~");
    }
}