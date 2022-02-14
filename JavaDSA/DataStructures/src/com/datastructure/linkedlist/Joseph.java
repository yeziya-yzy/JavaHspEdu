package com.datastructure.linkedlist;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/2/11
 * 约瑟夫环问题
 */
public class Joseph {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        //circleSingleLinkedList.showBoy();
        circleSingleLinkedList.GoOut(1, 2, 5);
    }
}

/**
 * 创建环形单向列表
 */
class CircleSingleLinkedList {
    //创建第一个节点,当前没有编号
    private Boy first = null; //first是不动的

    //添加小孩节点,构建成环形链表
    public void addBoy(int nums) {
        //简单的数据校验
        if (nums < 1) {
            System.out.println("请输入正确的数字");
            return;
        }
        //first是不动的
        Boy temp = null;//辅助指针
        //使用for循环创建环形链表
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i); //创建小孩节点
            //第一个小孩
            if (i == 1) {
                first = boy;
                first.setNext(first); //自己和自己构成环装
                temp = first; //给temp初始化
            } else {
                temp.setNext(boy); //链上去
                boy.setNext(first); //形成环
                temp = boy; //后移
            }
        }
    }

    /**
     * 输出小孩
     *
     * @param start 开始的位置
     * @param n     数几下
     * @param nums  开始有几个小孩
     */
    public void GoOut(int start, int n, int nums) {
        if (first == null || start < 1 || start > nums) {
            System.out.println("数据不合理,参数输入不正确,请从新输入");
            return;
        }
        //first是不动的
        Boy temp = first;//辅助指针
        //开始位置
        for (int i = 1; i < start; i++) {
            temp = temp.getNext();
        }
        //下一个temp
        Boy next;
        while (true) {
            //找到要出去的小孩的前一个
            for (int i = 1; i < n - 1; i++) {
                temp = temp.getNext();
            }
            System.out.printf("出去的小孩的编号为%d\n", temp.getNext().getNo());
            next = temp.getNext().getNext();
            temp.setNext(next);
            temp = next;
            // 下面的不借用next
            // temp.setNext(temp.getNext().getNext());
            // temp = temp.getNext();
            if (temp.getNext() == temp) {
                System.out.printf("出去的小孩的编号为%d\n", temp.getNo());
                break;
            }
        }
    }

    //遍历当前环形所有节点
    public void showBoy() {
        //为空
        if (first == null) {
            System.out.println("队列为空,没有Boy");
            return;
        }
        //first是不动的
        Boy temp = first;//辅助指针
        while (true) {
            System.out.printf("小孩的编号为%d\n", temp.getNo());
            //遍历完毕
            if (temp.getNext() == first) {
                break;
            }
            //后移
            temp = temp.getNext();
        }
    }
}

/**
 * 约瑟夫环中的节点
 */
class Boy {
    private int no; //编号
    private Boy next;   //指向下一个节点

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "no=" + no +
                '}';
    }
}