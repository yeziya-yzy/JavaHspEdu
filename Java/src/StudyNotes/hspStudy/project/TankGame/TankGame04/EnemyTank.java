package StudyNotes.hspStudy.project.TankGame.TankGame04;

import java.util.Vector;

/**
 * @version 1.0
 * @coding: utf-8
 * 敌人的坦克
 */
public class EnemyTank extends Tank implements Runnable {
    Vector<Shot> shots = new Vector<>();
    boolean isLive = true;

    public EnemyTank(int x, int y) {
        super(x, y);
    }


    //让坦克自己动起来(写完要启动)
    @Override
    public void run() {
        while (isLive) {//坦克还活着才动
            //根据坦克的方向来继续移动
            switch (getDirect()) {
                case 0://向上
                    //只动一下的话会很鬼畜(^-^)
                    //让坦克保持一个方向走
                    for (int i = 0; i < 30; i++) {
                        if (getY() > 0) {//上面还没到边界,控制坦克,不让出界
                            moveUp();
                        }
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 1://向右
                    for (int i = 0; i < 30; i++) {
                        if (getX() + 60 < mainGame.RIGHT) {
                            moveRight();
                        }
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 2://向下
                    for (int i = 0; i < 30; i++) {
                        if (getY() + 60 < mainGame.DOWN) {
                            moveDown();
                        }
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 3://向左
                    for (int i = 0; i < 30; i++) {
                        if (getX() > 0) {
                            moveLeft();
                        }
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
            }
            //随机改变坦克的方向(0-3)
            setDirect((int) (Math.random() * 4));
            //写并发程序一定要考虑线程什么时候结束
        }
    }
}