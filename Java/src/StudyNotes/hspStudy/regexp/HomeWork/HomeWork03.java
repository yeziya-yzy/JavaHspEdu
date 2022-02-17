package StudyNotes.hspStudy.regexp.HomeWork;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @version 1.0
 * @coding: utf-8
 * 对一个url进行解析
 */
public class HomeWork03 {
    public static void main(String[] args) {
        String content = "http://www.sohu.com:8080/abc/xxx/yyy/////index.htm";
        String regStr = "^(http|https)://([a-zA-Z.]+):(\\d+)[\\w/]*/([\\w.]+)$";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        if (matcher.find()){
            System.out.println("协议为:" + matcher.group(1));
            System.out.println("域名为:"+ matcher.group(2));
            System.out.println("端口为:"+ matcher.group(3));
            System.out.println("文件名为:"+ matcher.group(4));
        }else {
            System.out.println("匹配失败");
        }
    }
}
