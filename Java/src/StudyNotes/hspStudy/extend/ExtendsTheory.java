package StudyNotes.hspStudy.extend;

/**
 * 讲解继承的本质
 * 从上倒下加载,从下到上寻找
 */

public class ExtendsTheory {
    public static void main(String[] args) {
        Son son = new Son(); //内存的布局
        System.out.println(son.name);
    }
}
class GrandPa{
    String name = "大头爷爷";
    String hobby = "旅游";
}

class Father extends GrandPa{
    String name = "大头爸爸";
    int age = 39;
}

class Son extends Father{
    String name = "大头儿子";
}
