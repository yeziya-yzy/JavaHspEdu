package StudyNotes.hspStudy.project.TankGame.TankGame03;

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
        new Thread(mp).start();
        this.add(mp);//把面板(就是游戏的绘图区域)
        this.setSize(1000, 750);//尺寸
        this.addKeyListener(mp);//让 JFrame 监听 mp
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//点击X后终止任务
        this.setVisible(true);
    }
}
