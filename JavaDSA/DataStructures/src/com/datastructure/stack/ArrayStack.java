package com.datastructure.stack;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/2/11
 */
public class ArrayStack {
    public static void main(String[] args) {
        ArrayStackDemo stack = new ArrayStackDemo(5);
        System.out.println(stack.isEmpty());
        stack.push(132);
        stack.push(12);
        stack.push(13);
        stack.push(21);
        stack.push(53);
        stack.show();
        System.out.println(stack.isFull());
        System.out.println(stack.pop());
        System.out.println(stack.isFull());
    }
}

/**
 * 定义一个类ArrayStackDemo表示栈
 */
class ArrayStackDemo {
    private int maxSize;//栈的最大值
    private int[] stack;//数组模拟栈,数据就放在该数组中
    private int top = -1;

    //构造器
    public ArrayStackDemo(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈
    public void push(int value) {
        if (isFull()) {
            throw new RuntimeException("栈已经满了");
        }
        top++;
        stack[top] = value;
    }

    //出栈
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        return stack[top--];
    }

    //显示栈的情况[遍历]
    public void show() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        //遍历是从上往下的
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d] = %d\n", i, stack[i]);
        }
    }
}