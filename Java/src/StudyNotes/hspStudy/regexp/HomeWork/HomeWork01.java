package StudyNotes.hspStudy.regexp.HomeWork;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @version 1.0
 * @coding: utf-8
 */
public class HomeWork01 {
    public static void main(String[] args) {
        //规定电子邮件规则为
        //只能有一个@
        //@前面是用户名,可以是a-z A-Z 0-9 _-字符
        //@后面是域名,并且域名只能是英文字母， 比如 sohu.com 或者 tsinghua.org.cn
        //写出对应的正则表达式, 验证输入的字符串是否为满足规则
        String content = "123@sohu.com";
        String regStr = "^[\\w-]+@([a-zA-Z]+\\.)+[a-zA-Z]+$";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        System.out.println(matcher.find()? "匹配成功":"匹配失败");
    }
}
