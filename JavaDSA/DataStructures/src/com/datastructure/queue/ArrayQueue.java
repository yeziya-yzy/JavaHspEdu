package com.datastructure.queue;


/**
 * @author wyw
 * @coding utf-8
 * @data 2022/2/10
 * 数组队列
 */
public class ArrayQueue {
    public static void main(String[] args) {
        //测试
        //创建队列
        ArrayQueueDemo arrayQueueDemo = new ArrayQueueDemo(3);
        arrayQueueDemo.isEmpty();
        arrayQueueDemo.addQueue(123);
        arrayQueueDemo.showQueue();
    }
}

/**
 * 使用一个数组模拟队列
 * 不足:队列不是环形队列,不能重复使用
 */
class ArrayQueueDemo {
    private final int maxSize;//数组的最大容量
    private int front;//指向队列头前一个
    private int rear;//指向队列尾前一个
    private final int[] arr;//用于存放数据,模拟队列

    //创建队列的构造器
    public ArrayQueueDemo(int arrMaxSize) {
        this.maxSize = arrMaxSize;
        this.arr = new int[maxSize];
        this.front = -1;
        this.rear = -1;
    }

    //判断队列是否满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return front == rear;
    }

    //添加数据到队列
    public void addQueue(int n) {
        //首先要没满,满就返回
        if (isFull()) {
            throw new RuntimeException("队列已经满,不能加入");
        }
        rear++;
        arr[rear] = n;
    }

    //获取队列数据
    public int getQueue() {
        //判断队列是否有数据
        if (isEmpty()) {
            throw new RuntimeException("队列为空,不能取数据");
        } else {
            front++;
            return arr[front];
        }
    }

    //显示队列的所有数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空,不能取数据");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d] = %d\t", i, arr[i]);
        }
    }
}