package com.datastructure.recursion;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/2/13
 * 递归测试
 */
public class RecursionTest {
    public static void main(String[] args) {
        test(10);
    }

    public static void test(int n) {
        if (n > 2) {
            test(n-1);
        }
        System.out.printf("n=%d\n", n);
    }
}
