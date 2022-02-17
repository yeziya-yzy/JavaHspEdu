package StudyNotes.hspStudy.project.TankGame.TankGame06;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Scanner;

/**
 * @version 1.0
 * @coding: utf-8
 */
public class mainGame extends JFrame {
    //定义MyPanel
    public static int RIGHT = 1270;//右边界
    public static int DOWN = 750;//下边界
    Scanner scanner = new Scanner(System.in);
    MyPanel mp = null;

    public static void main(String[] args) throws IOException {
        mainGame game = new mainGame();
    }

    public mainGame() throws IOException {
        System.out.println("请输入选择 1:新游戏 2:继续上局");
        String key = scanner.next();
        mp = new MyPanel(key);
        new Thread(mp).start();
        this.add(mp);//把面板(就是游戏的绘图区域)
        this.setSize(RIGHT, DOWN);//尺寸
        this.addKeyListener(mp);//让 JFrame 监听 mp
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//点击X后终止任务
        this.setVisible(true);

        //在JFrame 中增加相应的关闭窗口的相应
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("正在保存数据");
                try {
                    Recorder.keepRecord();
                    System.out.println("保存数据成功");
                } catch (IOException ioException) {
                    System.out.println("保存数据失败");
                }
                System.out.println("正在退出窗口");
                System.exit(0);
            }
        });
    }
}
