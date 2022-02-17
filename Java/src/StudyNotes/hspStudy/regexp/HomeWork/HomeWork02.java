package StudyNotes.hspStudy.regexp.HomeWork;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @version 1.0
 * @coding: utf-
 * 要求验证是不是整数或者小数    1  -1  1.1  -1.1  001.1  +0.1都要考虑
 */
public class HomeWork02 {
    public static void main(String[] args) {
        String content = "-11.456";
        //先写出简单的,再逐步完善
        String regStr = "^[-+]?([1-9]\\d*|0)(\\.\\d+)?$";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        System.out.println(matcher.find()? "匹配成功":"匹配失败");
    }
}
