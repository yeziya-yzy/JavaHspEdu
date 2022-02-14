package com.datastructure.queue;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/2/10
 */
public class CircleArrayQueue {
    public static void main(String[] args) {
        //空一个空间判读是否是满的
        CircleArrayQueueDemo circleArrayQueueDemo = new CircleArrayQueueDemo(4);
        circleArrayQueueDemo.isEmpty();
        circleArrayQueueDemo.addQueue(123);
        circleArrayQueueDemo.addQueue(1);
        circleArrayQueueDemo.addQueue(2);
        System.out.println(circleArrayQueueDemo.isFull());
        System.out.println(circleArrayQueueDemo.getQueue());
        System.out.println(circleArrayQueueDemo.isFull());
        circleArrayQueueDemo.showQueue();
    }
}

/**
 * 使用一个数组模拟队列
 * 环形队列弥补之前只能用一次的缺陷
 */
class CircleArrayQueueDemo {
    private final int maxSize;//数组的最大容量
    private int front;//指向队列头
    private int rear;//指向队列尾
    private final int[] arr;//用于存放数据,模拟队列

    //创建队列的构造器
    public CircleArrayQueueDemo(int arrMaxSize) {
        this.maxSize = arrMaxSize;
        this.arr = new int[maxSize];
        this.front = 0;
        this.rear = 0;
    }

    //判断队列是否满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
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
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    //获取队列数据
    public int getQueue() {
        //判断队列是否有数据
        if (isEmpty()) {
            throw new RuntimeException("队列为空,不能取数据");
        } else {
            int value = arr[front];
            front = (front + 1) % maxSize;  //其实% maxSize都是为了考虑是否越界
            return value;
        }
    }

    //显示队列的所有数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空,不能取数据");
            return;
        }
        //从front开始取
        for (int i = front; i < front + getDataSize(); i++) {
            System.out.printf("arr[%d] = %d\t", i % maxSize, arr[i % maxSize]);
        }
    }

    //求出当前队列的有效数据
    public int getDataSize() {
        return (rear - front + maxSize) % maxSize;
    }
}