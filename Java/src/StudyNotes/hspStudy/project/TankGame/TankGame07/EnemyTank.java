package StudyNotes.hspStudy.project.TankGame.TankGame07;

import java.util.Vector;

/**
 * @version 1.0
 * @coding: utf-8
 * 敌人的坦克
 */
public class EnemyTank extends Tank implements Runnable {
    Vector<Shot> shots = new Vector<>();
    boolean isLive = true;
    //增加成员,EnemyTank 可以得到敌人坦克的Vector
    //分析
    //1.Vector<EnemyTank> 在
    Vector<EnemyTank> enemyTanks = new Vector<>();

    public EnemyTank(int x, int y) {
        super(x, y);
    }

    //这里提供一个方法可以将MyPanel的成员Vector<EnemyTank> enemyTanks = new Vector<>();
    //设置到EnemyTank 成员的 enemyTanks
    public void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        this.enemyTanks = enemyTanks;
    }

    //编写方法,判断当前的这个敌人坦克,是否和enemyTanks 中的其他坦克发发生重叠或者碰撞
    public boolean isTouchEnemyTank() {
        //判断当前坦克(this)方向
        switch (this.getDirect()) {
            //顺时针
            case 0://向上
                //让当前坦克和其他敌人坦克循环比较
                for (int i = 0; i < enemyTanks.size(); i++) {
                    //从Vector中取出一个敌人坦克
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //不和自己比较
                    if (enemyTank != this) {
                        //敌人坦克是上\下
                        // 敌人的范围 X<=x<=X+40  Y<=y<=Y+60
                        if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
                            //左上角
                            if (this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 40
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getX() + 60) {
                                return true;
                            }
                            //右上角
                            if (this.getX() + 40 >= enemyTank.getX()
                                    && this.getX() + 40 <= enemyTank.getX() + 40
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getX() + 60) {
                                return true;
                            }
                        }
                        //敌人坦克是左\右
                        // 敌人的范围 X<=x<=X+60  Y<=y<=Y+40
                        if (enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3) {
                            //左上角
                            if (this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 60
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getX() + 40) {
                                return true;
                            }
                            //右上角
                            if (this.getX() + 40 >= enemyTank.getX()
                                    && this.getX() + 40 <= enemyTank.getX() + 60
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getX() + 40) {
                                return true;
                            }
                        }
                    }
                }
                break;
            case 1://向右
                //让当前坦克和其他敌人坦克循环比较
                for (int i = 0; i < enemyTanks.size(); i++) {
                    //从Vector中取出一个敌人坦克
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //不和自己比较
                    if (enemyTank != this) {
                        //敌人坦克是上\下
                        // 敌人的范围 X<=x<=X+40  Y<=y<=Y+60
                        if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
                            //右上角
                            if (this.getX() + 60 >= enemyTank.getX()
                                    && this.getX() + 60 <= enemyTank.getX() + 40
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getX() + 60) {
                                return true;
                            }
                            //右下角
                            if (this.getX() + 60 >= enemyTank.getX()
                                    && this.getX() + 60 <= enemyTank.getX() + 40
                                    && this.getY() + 40 >= enemyTank.getY()
                                    && this.getY() + 40 <= enemyTank.getX() + 60) {
                                return true;
                            }
                        }
                        //敌人坦克是左\右
                        // 敌人的范围 X<=x<=X+60  Y<=y<=Y+40
                        if (enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3) {
                            //右上角
                            if (this.getX() + 60 >= enemyTank.getX()
                                    && this.getX() + 60 <= enemyTank.getX() + 60
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getX() + 40) {
                                return true;
                            }
                            //右下角
                            if (this.getX() + 60 >= enemyTank.getX()
                                    && this.getX() + 60 <= enemyTank.getX() + 60
                                    && this.getY() + 40 >= enemyTank.getY()
                                    && this.getY() + 40 <= enemyTank.getX() + 40) {
                                return true;
                            }
                        }
                    }
                }
                break;
            case 2://向下
                //让当前坦克和其他敌人坦克循环比较
                for (int i = 0; i < enemyTanks.size(); i++) {
                    //从Vector中取出一个敌人坦克
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //不和自己比较
                    if (enemyTank != this) {
                        //敌人坦克是上\下
                        // 敌人的范围 X<=x<=X+40  Y<=y<=Y+60
                        if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
                            //左下角
                            if (this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 40
                                    && this.getY() + 60 >= enemyTank.getY()
                                    && this.getY() + 60 <= enemyTank.getX() + 60) {
                                return true;
                            }
                            //右下角
                            if (this.getX() + 40 >= enemyTank.getX()
                                    && this.getX() + 40 <= enemyTank.getX() + 40
                                    && this.getY() + 60 >= enemyTank.getY()
                                    && this.getY() + 60 <= enemyTank.getX() + 60) {
                                return true;
                            }
                        }
                        //敌人坦克是左\右
                        // 敌人的范围 X<=x<=X+60  Y<=y<=Y+40
                        if (enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3) {
                            //左下角
                            if (this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 60
                                    && this.getY() + 60 >= enemyTank.getY()
                                    && this.getY() + 60 <= enemyTank.getX() + 40) {
                                return true;
                            }
                            //右下角
                            if (this.getX() + 40 >= enemyTank.getX()
                                    && this.getX() + 40 <= enemyTank.getX() + 60
                                    && this.getY() + 60 >= enemyTank.getY()
                                    && this.getY() + 60 <= enemyTank.getX() + 40) {
                                return true;
                            }
                        }
                    }
                }
                break;
            case 3://向左
                //让当前坦克和其他敌人坦克循环比较
                for (int i = 0; i < enemyTanks.size(); i++) {
                    //从Vector中取出一个敌人坦克
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //不和自己比较
                    if (enemyTank != this) {
                        //敌人坦克是上\下
                        // 敌人的范围 X<=x<=X+40  Y<=y<=Y+60
                        if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
                            //左上角
                            if (this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 40
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getX() + 60) {
                                return true;
                            }
                            //左下角
                            if (this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 40
                                    && this.getY() + 40 >= enemyTank.getY()
                                    && this.getY() + 40 <= enemyTank.getX() + 60) {
                                return true;
                            }
                        }
                        //敌人坦克是左\右
                        // 敌人的范围 X<=x<=X+60  Y<=y<=Y+40
                        if (enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3) {
                            //左上角
                            if (this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 60
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getX() + 40) {
                                return true;
                            }
                            //左下角
                            if (this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 60
                                    && this.getY() + 40 >= enemyTank.getY()
                                    && this.getY() + 40 <= enemyTank.getX() + 40) {
                                return true;
                            }
                        }
                    }
                }
                break;
        }
        return false;
    }

    //让坦克自己动起来(写完要启动)
    @Override
    public void run() {
        while (isLive) {//坦克还活着才进行
            //这里我们判断如果shots size() =0
            //创建一颗子弹,放入到shots集合中,并启动
            //shots.size() <= 3控制敌方子弹发射上线
            //如果子弹<=3那么就创建子弹
            if (isLive && shots.size() <= 3) {
                Shot s = null;
                //判断坦克方向,创建对应子弹
                switch (getDirect()) {
                    case 0://上
                        s = new Shot(getX() + 20, getY(), 0);
                        break;
                    case 1://右
                        s = new Shot(getX() + 60, getY() + 20, 1);
                        break;
                    case 2://下
                        s = new Shot(getX() + 20, getY() + 60, 2);
                        break;
                    case 3://左
                        s = new Shot(getX(), getY() + 20, 3);
                        break;
                }
                shots.add(s);
                //启动
                new Thread(s).start();
            }
            //根据坦克的方向来继续移动
            switch (getDirect()) {
                case 0://向上
                    //只动一下的话会很鬼畜(^-^)
                    //让坦克保持一个方向走
                    for (int i = 0; i < 30; i++) {
                        if (getY() > 0 && !isTouchEnemyTank()) {//上面还没到边界,控制坦克,不让出界
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
                        if (getX() + 60 < mainGame.RIGHT && !isTouchEnemyTank()) {
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
                    for (int i = 0; i < 30; i++ ) {
                        if (getY() + 60 < mainGame.DOWN && !isTouchEnemyTank()) {
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
                        if (getX() > 0 && !isTouchEnemyTank()) {
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