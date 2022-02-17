package StudyNotes.hspStudy.FileEdu.PackagingFlow.PropertiesUse;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * @version 1.0
 * @coding: utf-8
 */
public class Properties01 {
    public static void main(String[] args) throws IOException {
        //使用 Properties 类来读取 mysql.properties 文件
        //1. 创建 Properties 对象
        Properties properties = new Properties();
        //2. 加载指定配置文件
        properties.load(new FileReader("src\\ConfigurationFile\\mysql.properties"));
        //3. 把 k-v 显示控制台
        properties.list(System.out);
        //4. 根据 key 获取对应的值
        String user = properties.getProperty("user");
        String pwd = properties.getProperty("pwd");
        System.out.println("用户名=" + user);
        System.out.println("密码是=" + pwd);
    }
}
