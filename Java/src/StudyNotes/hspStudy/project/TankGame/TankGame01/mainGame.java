package StudyNotes.hspStudy.project.TankGame.TankGame01;

import javax.swing.*;

/**
 * @version 1.0
 * @coding: utf-8
 */
public class mainGame extends JFrame {
    //定义MyPanel
    MyPanel mp = null;
    public static void main(String[] args) {
        mainGame game = new mainGame();
    }
    public mainGame(){
        mp = new MyPanel();
        this.add(mp);//把面板(就是游戏的绘图区域)
        this.setSize(1000, 750);//尺寸
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//点击X后终止任务
        this.setVisible(true);
    }
}
