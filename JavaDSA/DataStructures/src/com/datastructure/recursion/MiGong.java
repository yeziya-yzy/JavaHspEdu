package com.datastructure.recursion;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/2/13
 * 迷宫问题
 */
public class MiGong {
    public static void main(String[] args) {
        //创建二维数组模拟迷宫
        int[][] map = new int[8][7];
        //使用1表示墙体
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 1; i < 7; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        //设置墙
        map[3][1] = 1;
        map[3][2] = 1;
        System.out.println("原map");
        for (int[] ints : map) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        findWay(map, 1, 1);
        System.out.println("走过的map");
        for (int[] ints : map) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }


    /**
     * @param map 传入的地图
     * @param x   开始的X位置
     * @param y   开始的Y位置
     * @return boolean 是否找到路
     * 使用递归来给小球找路
     * 说明:
     * 出发位置为(2,2)  map[1][1]
     * 结束位置为(7,6)  map[6][5]
     * map[i][j] == 0 时表示没有走过,map[i][j] == 1时表示墙  map[i][j] == 2 表示走的了  map[i][j] == 3表示走过走不了
     * 走迷宫的策略:下 => 右 => 上 => 左
     */
    public static boolean findWay(int[][] map, int x, int y) {
        //找到了
        if (map[6][5] == 2) {
            return true;
        } else {
            //没走过
            if (map[x][y] == 0) {
                map[x][y] = 2;
                if (findWay(map, x + 1, y)) {
                    return true;
                } else if (findWay(map, x, y + 1)) {
                    return true;
                } else if (findWay(map, x - 1, y)) {
                    return true;
                } else if (findWay(map, x, y - 1)) {
                    return true;
                } else {
                    map[x][y] = 3;
                    return false;
                }
            } else {
                //map[x][y] == 1,2,3都是不用走了的
                return false;
            }
        }
    }
}
