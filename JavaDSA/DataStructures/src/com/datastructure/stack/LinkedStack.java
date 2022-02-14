package com.datastructure.stack;


/**
 * @author wyw
 * @coding utf-8
 * @data 2022/2/11
 * 使用链表来模拟栈(用头插法!!!!)
 */
public class LinkedStack {
    public static void main(String[] args) {
        LinkedStackDemo linkedStackDemo = new LinkedStackDemo(4);
        System.out.println(linkedStackDemo.isEmpty());
        linkedStackDemo.push(95);
        linkedStackDemo.push(56);
        linkedStackDemo.push(41);
        linkedStackDemo.push(32);
        System.out.println(linkedStackDemo.isFull());
        System.out.println(linkedStackDemo.pop());
        System.out.println(linkedStackDemo.isFull());
        linkedStackDemo.show();
    }
}

/**
 * 定义一个类LinkedStackDemo来操作栈
 */
class LinkedStackDemo {
    private final StackNode head = new StackNode(0);//头节点
    private final int maxSize;//栈的总长

    public LinkedStackDemo(int maxSize) {
        this.maxSize = maxSize;
    }

    //栈空
    public boolean isEmpty() {
        return head.getNext() == null;
    }

    //栈满
    public boolean isFull() {
        int count = 0;
        StackNode temp = head;
        while (temp.getNext() != null) {
            count++;
            temp = temp.getNext();
        }
        return count == maxSize;
    }

    //入栈
    public void push(int value) {
        if (isFull()) {
            throw new RuntimeException("栈已经满了");
        }
        //头插法
        StackNode toAddNode = new StackNode(value);
        toAddNode.setNext(head.getNext());
        head.setNext(toAddNode);
    }

    //出栈
    public int pop() {
        int data = head.getNext().getData();
        StackNode next = head.getNext().getNext();
        head.setNext(next);
        return data;
    }

    //显示栈的情况[遍历]
    public void show() {
        StackNode temp = head.getNext();
        while (temp != null) {
            System.out.println(temp);
            temp = temp.getNext();
        }
    }
}

/**
 * 定义一个类StackNode表示栈节点
 */
class StackNode {
    private final int data;
    private StackNode next;

    public StackNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public StackNode getNext() {
        return next;
    }

    public void setNext(StackNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "StackNode{" +
                "data=" + data +
                '}';
    }
}