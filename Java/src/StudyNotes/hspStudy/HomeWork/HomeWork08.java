package StudyNotes.hspStudy.HomeWork;

/**
 * coding: utf-8
 *
 * @version 1.0
 */
public class HomeWork08 {
    public static void main(String[] args) {
        String str = "987654321";
        try {
            str = reverse(str, 0, 8);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println(str);
    }

    public static String reverse(String str, int start, int end) {
        //取反!!!
        if (!(start >= 0 && end < str.length() && end > start && str != null)) {
            throw new RuntimeException("输入参数不正确");
        }
        char[] chs = str.toCharArray();
        char temp;
//        for (int i = start, j = 0; i <= (end + start) / 2; i++, j++) {
//            temp = chs[i];
//            chs[i] = chs[end - j];
//            chs[end - j] = temp;
//        }
        for (int i = start, j = end; i < j; i++, j--) {
            temp = chs[i];
            chs[i] = chs[j];
            chs[j] = temp;
        }
        return new String(chs);
    }
}