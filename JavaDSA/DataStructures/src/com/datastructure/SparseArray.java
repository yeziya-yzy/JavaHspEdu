package com.datastructure;

import java.io.*;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/2/9
 * 稀疏数组
 */
public class SparseArray {
    public static void main(String[] args) throws Exception {
        //1.创建原始数组
        int[][] arr1 = new int[11][11];
        arr1[1][2] = 1;
        arr1[2][3] = 2;
        arr1[4][5] = 2;
        System.out.println("原数组");
        for (int[] row : arr1) {
            for (int item : row) {
                System.out.printf("%d\t", item);
            }
            System.out.println("");
        }
        //2.压缩(得到稀疏数组)
        int sum = 0;
        //得到个数
        for (int[] row : arr1) {
            for (int item : row) {
                if (item != 0) {
                    sum++;
                }
            }
        }
        int[][] arrNew = new int[sum + 1][3];
        arrNew[0][0] = 11; //行数
        arrNew[0][1] = 11;  //列数
        arrNew[0][2] = sum; //数值数
        //给第二行到最后一行赋值(存入)
        int count = 1; //记录第几个数
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                int item = arr1[i][j];
                if (item != 0) {
                    arrNew[count][0] = i;
                    arrNew[count][1] = j;
                    arrNew[count][2] = item;
                    count++;
                }
            }
        }
        //保存到磁盘上
        String path = "F:\\Java_Learn\\测试目录\\map.data"; //保存路径
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
        objectOutputStream.writeObject(arrNew);
        //输出下看看结果是否正确
        System.out.println("压缩后的二维数组");
        for (int[] row : arrNew) {
            for (int item : row) {
                System.out.printf("%d\t", item);
            }
            System.out.println("");
        }
        //3.稀疏数组恢复原来的数组
        //从磁盘读取
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
        int[][] arrNew2 = (int[][]) ois.readObject();
        int[][] arr2 = new int[arrNew2[0][0]][arrNew2[0][1]];
        for (int i = 1; i < arrNew.length; i++) {
            arr2[arrNew2[i][0]][arrNew2[i][1]] = arrNew2[i][2];
        }
        //输出下看看结果是否正确
        System.out.println("恢复好的二维数组");
        for (int[] row : arr2) {
            for (int item : row) {
                System.out.printf("%d\t", item);
            }
            System.out.println("");
        }
    }
}