package com.datastructure.linkedlist;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/2/11
 * 单链表
 */
public class SingleLinkedList {
    public static void main(String[] args) {
        SingleLinkedListDemo singleLinkedListDemo = new SingleLinkedListDemo();
        HeroNode heroNode1 = new HeroNode(1, "1", "1");
        HeroNode heroNode2 = new HeroNode(2, "2", "2");
        HeroNode heroNode3 = new HeroNode(3, "3", "3");
        HeroNode heroNode4 = new HeroNode(4, "4", "4");
        // singleLinkedListDemo.add(heroNode1);
        // singleLinkedListDemo.add(heroNode3);
        // singleLinkedListDemo.add(heroNode2);
        singleLinkedListDemo.addOrder(heroNode1);
        singleLinkedListDemo.addOrder(heroNode3);
        singleLinkedListDemo.addOrder(heroNode2);
        singleLinkedListDemo.addOrder(heroNode4);
        System.out.println(singleLinkedListDemo.getNodeNumber());
        System.out.printf("倒数第%d为" + singleLinkedListDemo.getKNode(4) + "\n", 4);
        singleLinkedListDemo.reversalList();
        singleLinkedListDemo.list();
    }
}

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/2/11
 * 定义SingleLinkedListDemo,管理节点
 */
class SingleLinkedListDemo {
    //头结点
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    public void setHead(HeroNode head) {
        this.head = head;
    }

    //添加(尾部添加)
    public void add(HeroNode heroNode) {
        HeroNode temp = head;
        //遍历列表找到列表的最后一个
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(heroNode);
    }

    //添加(按顺序)
    public void addOrder(HeroNode heroNode) {
        HeroNode temp = head;
        while (true) {
            //都没有比他大的
            if (temp.getNext() == null) {
                temp.setNext(heroNode);
                break;
            }
            //找到位置进行添加
            if (temp.getNo() < heroNode.getNo() && temp.getNext().getNo() > heroNode.getNo()) {
                heroNode.setNext(temp.getNext());
                temp.setNext(heroNode);
                break;
            } else if (temp.getNo() == heroNode.getNo()) {
                //已经有这个数了
                throw new RuntimeException(heroNode.getNo() + "已经存在了");
            }
            temp = temp.getNext();
        }
    }

    //查找单链表中的倒数第K个节点[新浪面试题]
    //快慢指针(后面那个在前面的后k-1个位置,到最后之后前面那个就是要找的)  或者  用遍历[总长-k]指向第一个,只要向后移动(总长-k)次
    public HeroNode getKNode(int k) {
        if (k > getNodeNumber()) {
            System.out.printf("%d过大了", k);
            return null;
        }
        HeroNode temp = head.getNext();
        HeroNode tempK;

        for (int i = 0; i < getNodeNumber() - (k - 1); i++) {
            tempK = temp;
            for (int j = 0; j < k - 1; j++) {
                tempK = tempK.getNext();
            }
            if (tempK.getNext() == null) {
                return temp;
            }
            temp = temp.getNext();
        }
        return temp;
    }

    //单链表的反转[腾讯面试题,有点难度](头插法!!!)
    public void reversalList() {
        //当前为空或者是1
        if (head.getNext() == null || head.getNext().getNext() == null) {
            return;
        }
        HeroNode newHead = new HeroNode(0, "", "");
        HeroNode temp = head.getNext();  //辅助指针(操作节点用的),遍历原来的链表
        HeroNode next;   //当前节点的下一节点  用来让辅助指针后移动
        while (temp != null) {
            next = temp.getNext();   //找到下一个节点,后来要拿来后移
            //下面两步就是插入,只是插入点是头部!
            temp.setNext(newHead.getNext());  //和已经接上去的相连接
            newHead.setNext(temp);  //链接到头上
            temp = next;  //后移
        }
        head.setNext(newHead.getNext());
    }

    //获取单链表的节点个数
    public int getNodeNumber() {
        int count = 0;
        HeroNode temp = head;
        while (temp.getNext() != null) {
            count++;
            temp = temp.getNext();
        }
        return count;
    }

    //显示列表[遍历]
    public void list() {
        HeroNode temp = head.getNext();
        //遍历列表找到列表的最后一个
        while (temp != null) {
            System.out.println(temp);
            temp = temp.getNext();
        }
    }
}

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/2/11
 * 定义一个节点,每个对象就是一个节点
 */
class HeroNode {
    private int no;
    private String name;
    private String nickName;
    private HeroNode next;

    public HeroNode(int no, String name, String nickName) {
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

    public HeroNode getNext() {
        return next;
    }

    public void setNext(HeroNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}