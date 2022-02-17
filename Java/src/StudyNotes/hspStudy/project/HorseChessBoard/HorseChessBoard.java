package StudyNotes.hspStudy.project.HorseChessBoard;

/**
 * @version 1.0
 * @coding: utf-8
 */
public class HorseChessBoard {

    //定义棋盘属性
    private static int X = 6; //表示col
    private static int Y = 6; //表示row
    static int[][] chessBoard = new int[Y][X];//棋盘
    private static boolean[] visited = new boolean[X*Y]; //记录该点是否走过
    private static boolean finished = false;  //记录是否遍历棋盘

    public static void main(String[] args) {

        //输出棋盘情况
        for ( int[] rows :chessBoard) {
            for (int step : rows) {  //step表示该位置是第几步
                System.out.print(step + "\t");
            }
            System.out.println();
        }
    }


    //编写方法获取当前位置可以走的下一步
}
