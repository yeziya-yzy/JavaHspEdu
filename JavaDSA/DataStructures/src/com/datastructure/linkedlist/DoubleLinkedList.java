package com.datastructure.linkedlist;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/2/11
 */
public class DoubleLinkedList {
    public static void main(String[] args) {
        DoubleLinkedListDemo doubleLinkedList = new DoubleLinkedListDemo();
        HeroNode2 heroNode2 = new HeroNode2(1, "1", "1");
        doubleLinkedList.add(heroNode2);
    }
}

class DoubleLinkedListDemo {
    //头结点
    private HeroNode2 head = new HeroNode2(0, "", "");

    //返回头节点
    public HeroNode2 getHead() {
        return head;
    }

    public void setHead(HeroNode2 head) {
        this.head = head;
    }

    //添加(尾部添加)
    public void add(HeroNode2 heroNode2) {
        HeroNode2 temp = head;
        //遍历列表找到列表的最后一个
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(heroNode2);
        heroNode2.setPre(temp);
    }
}

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/2/11
 * 创建双向列表的类
 */
class HeroNode2 {
    private int no;
    private String name;
    private String nickName;
    private HeroNode2 next;
    private HeroNode2 pre;

    public HeroNode2(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public HeroNode2 getNext() {
        return next;
    }

    public HeroNode2 getPre() {
        return pre;
    }

    public void setPre(HeroNode2 pre) {
        this.pre = pre;
    }

    public void setNext(HeroNode2 next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}