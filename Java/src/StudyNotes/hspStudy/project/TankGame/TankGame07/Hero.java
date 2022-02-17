package StudyNotes.hspStudy.project.TankGame.TankGame07;

import java.util.Vector;

/**
 * @version 1.0
 * @coding: utf-8
 * 自己的坦克
 */
public class Hero extends Tank {
    //定义一个shot对象,表示一个射击
    Shot shot = null;
    //可以发送多颗子弹
    Vector<Shot> shots = new Vector();
    public Hero(int x, int y) {
        super(x, y);
    }

    public void shotEnemyTank() {
        //控制面板上发射的最大数量子弹
        if (shots.size() == 5) {
            return;
        }
        //创建Shot对象,根据当前Hero的位置和方向来确定Shot
        switch (getDirect()) {//得到坦克的方向
            case 0://向上
                shot = new Shot(getX() + 20, getY(), 0);
                break;
            case 1://向右
                shot = new Shot(getX() + 60, getY() + 20, 1);
                break;
            case 2://向下
                shot = new Shot(getX() + 20, getY() + 60, 2);
                break;
            case 3://向左
                shot = new Shot(getX(), getY() + 20, 3);
                break;
        }

        //把新创建的shot放到shots中
        shots.add(shot);
        //启动Shot线程
        new Thread(shot).start();
    }
}