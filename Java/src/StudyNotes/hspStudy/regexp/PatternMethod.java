package StudyNotes.hspStudy.regexp;

import java.util.regex.Pattern;

/**
 * @version 1.0
 * @coding: utf-8
 * 演示 matches 方法，用于整体匹配, 在验证输入的字符串是否满足条件使用
 */
public class PatternMethod {
    public static void main(String[] args) {
        String content = "hello abc hello, 韩顺平教育";
        //String regStr = "hello";
        String regStr = "hello.*";
        boolean matches = Pattern.matches(regStr, content);
        System.out.println("整体匹配= " + matches);
    }
}
