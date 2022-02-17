package StudyNotes.hspStudy.HomeWork.hspdeuHomeWork.ClassHomeWork;

/**
 * coding: utf-8
 *
 * @version 1.0
 */
public class HomeWork01 {
    public static void main(String[] args) {
        printName("Han shun Ping");
        countUD("adfsgAASD");
    }

    public static void printName(String str) {
        String[] names = str.split(" ");
        names[1] = names[1].toUpperCase();
        System.out.println(names[2] + "," + names[0] + "." + names[1].charAt(0));
    }

    public static void countUD(String str) {
        if (str == null) {
            System.out.println("输入不正确");
        }
        char[] strs = str.toCharArray();
        int numU = 0;
        int numD = 0;
        for (char i : strs) {
            if ('A' <= i && i <= 'Z') {
                numU += 1;
            } else if ('a' <= i && i <= 'z') {
                numD += 1;
            }
        }
        System.out.println("大写有" + numU + "个小写有" + numD + "个");
    }
}
