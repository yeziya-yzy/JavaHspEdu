package StudyNotes.hspStudy.project.TankGame.TankGame07;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Vector;

/**
 * @version 1.0
 * @coding: utf-8
 * 定义我的画笔,用来画坦克
 * 坦克大战的绘图区域
 */
public class MyPanel extends JPanel implements KeyListener, Runnable {
    private static String recordFile = Recorder.getRecordFile();
    //定义我的坦克
    Hero hero = null;
    //定义敌人坦克，放入到 Vector
    Vector<EnemyTank> enemyTanks = new Vector<>();
    Vector<Node> nodes = new Vector<>();
    int enemyTankSize = 3;
    //定义炸弹
    //说明:当子弹击中敌人的坦克就使用爆炸
    Vector<Bomb> bombs = new Vector();
    //定义三张炸弹图片,用于显示爆炸效果
    Image image1 = null;
    Image image2 = null;
    Image image3 = null;

    public MyPanel(String key) throws IOException {
        nodes = Recorder.getNodesAndEnemyTankNum();
        Recorder.setEnemyTanks(enemyTanks);
        hero = new Hero(700, 500);//初始化自己坦克
        switch (key){
            case "1":
                //初始化敌人坦克
                for (int i = 0; i < enemyTankSize; i++) {
                    //创建一个敌人的坦克
                    EnemyTank enemyTank = new EnemyTank((100 * (i + 1)), 0);
                    //把enemyTanks设置给enemyTank
                    enemyTank.setEnemyTanks(enemyTanks);
                    //设置方向
                    enemyTank.setDirect(2);
                    //启动坦克
                    new Thread(enemyTank).start();
                    //给该enemyTank加入一颗子弹
                    Shot shot = new Shot(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirect());
                    //加入到enemyTank的Vector成员
                    enemyTank.shots.add(shot);
                    //启动 Shot
                    new Thread(shot).start();
                    //加入
                    enemyTanks.add(enemyTank);
                }
                break;
            case "2":
                //初始化敌人坦克(继续游戏)
                for (int i = 0; i < nodes.size(); i++) {
                    Node node = nodes.get(i);
                    //创建一个敌人的坦克
                    EnemyTank enemyTank = new EnemyTank(node.getX(), getY());
                    //把enemyTanks设置给enemyTank
                    enemyTank.setEnemyTanks(enemyTanks);
                    //设置方向
                    enemyTank.setDirect(node.getDirect());
                    //启动坦克
                    new Thread(enemyTank).start();
                    //给该enemyTank加入一颗子弹
                    Shot shot = new Shot(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirect());
                    //加入到enemyTank的Vector成员
                    enemyTank.shots.add(shot);
                    //启动 Shot
                    new Thread(shot).start();
                    //加入
                    enemyTanks.add(enemyTank);
                }
                break;
            default:
                System.out.println("输入有误");
        }
        //初始化图片对象
        image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_1.gif"));
        image2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_2.gif"));
        image3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_3.gif"));

        //播放指定的音乐
        String path ="F:\\Java_Learn\\Java\\src\\StudyNotes\\hspStudy\\project\\TankGame\\TankGame07\\111.wav";
        new AePlayWave(path).start();
    }


    //编写方法,显示我方击毁敌方坦克的信息
    public void showInfo(Graphics g) {
        g.setColor(Color.BLACK);
        Font font = new Font("宋体", Font.BOLD, 25);
        g.setFont(font);
        g.drawString("累计击毁敌方坦克", 1020, 30);
        this.drawTank(1020, 60, g, 0, 0);//画出一个敌方坦克
        g.setColor(Color.BLACK);
        g.drawString(Recorder.getShotNumber() + "", 1080, 100);
    }

    //开始画图
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, mainGame.RIGHT - 280, mainGame.DOWN);//填充矩形，默认黑色
        showInfo(g);
        //画出坦克-封装方法
        if (hero != null && hero.isLive) {//自己坦克还活着
            drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 1);
        }
        //画出敌人的坦克, 遍历 Vector
        for (int i = 0; i < enemyTanks.size(); i++) {
            //取出坦克
            EnemyTank enemyTank = enemyTanks.get(i);
            if (enemyTank.isLive) {
                drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirect(), 0);
                //画出enemyTank 所有坦克
                for (int j = 0; j < enemyTank.shots.size(); j++) {
                    //取出子弹
                    Shot shot = enemyTank.shots.get(j);
                    //绘制
                    if (shot.isLive) {
                        g.draw3DRect(shot.x, shot.y, 1, 1, false);
                    } else {
                        //从Vector中移除
                        enemyTank.shots.remove(shot);
                    }
                }
            }
        }
        //画出Hero射击的子弹

        //将hero的子弹集合shots遍历取出
        for (int i = 0; i < hero.shots.size(); i++) {
            Shot shot = hero.shots.get(i);
            if (shot != null && shot.isLive) {
                g.draw3DRect(shot.x, shot.y, 1, 1, false);
            } else {//该shot对象已经无效了,就从shots集合中拿掉
                hero.shots.remove(shot);
            }
        }

        //如果bombs 集合中有内容,就画出炸弹
        for (int i = 0; i < bombs.size(); i++) {
            //取出炸弹
            Bomb bomb = bombs.get(i);
            //根据当前bomb对象的lift值去画出对应的图片
            if (bomb.life > 6) {
                g.drawImage(image1, bomb.x, bomb.y, 60, 60, this);
            } else if (bomb.life > 3) {
                g.drawImage(image2, bomb.x, bomb.y, 60, 60, this);
            } else {
                g.drawImage(image3, bomb.x, bomb.y, 60, 60, this);
            }
            //让炸弹生命值减少
            bomb.lifeDown();
            //如果bomb life 为 0,就从bombs的集合中删除
            if (bomb.life == 0) {
                bombs.remove(bomb);
            }
        }
    }

    public void drawTank(int x, int y, Graphics g, int direct, int type) {
        //根据不同类型坦克，设置不同颜色
        switch (type) {
            case 0: //我们的坦克
                g.setColor(Color.cyan);
                break;
            case 1: //敌人的坦克
                g.setColor(Color.yellow);
                break;
        }

        switch (direct) {
            case 0: //表示向上
                g.fill3DRect(x, y, 10, 60, false);//画出坦克左边轮子
                g.fill3DRect(x + 30, y, 10, 60, false);//画出坦克右边轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//画出坦克盖子
                g.fillOval(x + 10, y + 20, 20, 20);//画出圆形盖子
                g.drawLine(x + 20, y + 30, x + 20, y);//画出炮筒
                break;
            case 1: //表示向右
                g.fill3DRect(x, y, 60, 10, false);//画出坦克上边轮子
                g.fill3DRect(x, y + 30, 60, 10, false);//画出坦克下边轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//画出坦克盖子
                g.fillOval(x + 20, y + 10, 20, 20);//画出圆形盖子
                g.drawLine(x + 30, y + 20, x + 60, y + 20);//画出炮筒
                break;
            case 2: //表示向下
                g.fill3DRect(x, y, 10, 60, false);//画出坦克左边轮子
                g.fill3DRect(x + 30, y, 10, 60, false);//画出坦克右边轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//画出坦克盖子
                g.fillOval(x + 10, y + 20, 20, 20);//画出圆形盖子
                g.drawLine(x + 20, y + 30, x + 20, y + 60);//画出炮筒
                break;
            case 3: //表示向左
                g.fill3DRect(x, y, 60, 10, false);//画出坦克上边轮子
                g.fill3DRect(x, y + 30, 60, 10, false);//画出坦克下边轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//画出坦克盖子
                g.fillOval(x + 20, y + 10, 20, 20);//画出圆形盖子
                g.drawLine(x + 30, y + 20, x, y + 20);//画出炮筒
                break;
            default:
                System.out.println("暂时没有处理");
        }
    }

    //编写方法,判断我方的子弹是否击中敌人的坦克
    //如果我们可以发射多颗子弹
    //在判断是否击中敌人的时候,就要把我们的子弹集合中所有的子弹都要判断
    public void hitEnemyTnak() {
        //遍历我的子弹
        for (int j = 0; j < hero.shots.size(); j++) {
            Shot shot = hero.shots.get(j);
            //判断是否击中敌人坦克
            if (shot != null && shot.isLive) {//子弹还在
                //遍历敌人坦克
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    hitTank(shot, enemyTank);
                }
            }
        }
    }

    public void hitHero() {
        //遍历敌人坦克
        for (int j = 0; j < enemyTanks.size(); j++) {
            //遍历敌人坦克子弹
            for (int i = 0; i < enemyTanks.get(j).shots.size(); i++) {
                Shot shot = enemyTanks.get(j).shots.get(i);
                //判断是否击中自己坦克
                if (shot != null && shot.isLive && hero.isLive) {//子弹和我们还在
                    hitTank(shot, hero);
                }
            }
        }
    }

    public void hitTank(Shot s, Tank Tank) {
        //判断是否击中坦克(进入坦克区域)
        switch (Tank.getDirect()) {
            case 0://向上
            case 2://向下
                if (s.x > Tank.getX()
                        && s.x < Tank.getX() + 40
                        && s.y > Tank.getY()
                        && s.y < Tank.getY() + 60) {
                    s.isLive = false;
                    Tank.isLive = false;
                    if (Tank instanceof EnemyTank) {
                        Recorder.addShotNumber();
                    }
                    //创建Bomb对象,加入到bombs集合
                    Bomb bomb = new Bomb(Tank.getX(), Tank.getY());
                    bombs.add(bomb);
                    //击中之后把敌方坦克移除,不移除会一直打到尸体
                    enemyTanks.remove(Tank);
                }
                break;
            case 1://向右
            case 3://向左
                if (s.x > Tank.getX()
                        && s.x < Tank.getX() + 60
                        && s.y > Tank.getY()
                        && s.y < Tank.getY() + 40) {
                    s.isLive = false;
                    Tank.isLive = false;
                    if (Tank instanceof EnemyTank) {
                        Recorder.addShotNumber();
                    }
                    Bomb bomb = new Bomb(Tank.getX(), Tank.getY());
                    bombs.add(bomb);
                    enemyTanks.remove(Tank);
                }
        }
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {//按下 W 键
            //改变坦克的方向
            hero.setDirect(0);//
            //修改坦克的坐标 y -= 1
            if (hero.getY() > 0) {//上面还没到边界,控制坦克,不让出界
                hero.moveUp();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_D) {//D 键, 向右
            hero.setDirect(1);
            if (hero.getX() + 60 < mainGame.RIGHT) {
                hero.moveRight();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_S) {//S 键
            hero.setDirect(2);
            if (hero.getY() + 60 < mainGame.DOWN) {
                hero.moveDown();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_A) {//A 键
            hero.setDirect(3);
            if (hero.getX() > 0) {
                hero.moveLeft();
            }
        }
        //让面板重绘
        this.repaint();
        //如果用户按下J那么就启动子弹线程
        if (e.getKeyCode() == KeyEvent.VK_J /*&& (hero.shot == null || hero.shot.isLive == false)*/) {
            // /*中的内容是确保只发射一颗子弹的,看需求是不是只能发射一颗,现在的是发射出多颗子弹的
            hero.shotEnemyTank();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {//每隔一定时间重绘.相当于刷新绘图区域,子弹移动
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            hitHero();//敌人坦克是否击中我们坦克
            hitEnemyTnak();//我们坦克是否击中敌人坦克
            this.repaint();
        }
    }
}
