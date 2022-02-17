package StudyNotes.hspStudy.HomeWork.hspdeuHomeWork.AggregateHomeWork;

import java.util.ArrayList;

/**
 * coding: utf-8
 *
 * @version 1.0
 */
public class HomeWork01 {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new news("新冠确诊病例超千万,数百万印度教信徒赴恒河\"圣浴\"引起民众担忧"));
        arrayList.add(new news("男子突然想起2个月前钓的鱼还在网兜里,捞起一看赶紧放生"));
//        Collections.reverse(arrayList);
//        Iterator iterator = arrayList.iterator();
//        while (iterator.hasNext()) {
//            Object next =  iterator.next();
//            System.out.println(next);
//        }
        for (int i = arrayList.size() - 1; i >= 0; i--) {
            Object o = arrayList.get(i);
            if (o instanceof news) {
                news s = (news) o;
                if (s.getTitle().length() > 15) {
                    System.out.println(s.getTitle().substring(0, 15) + "...");
                }
            }
        }
    }
}

class news {
    private String title;
    private String content;

    public news(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "news\t" +
                "title='" + title + '\'';
    }
}