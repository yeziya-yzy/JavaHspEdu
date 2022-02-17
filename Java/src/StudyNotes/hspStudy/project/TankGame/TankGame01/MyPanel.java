package StudyNotes.hspStudy.project.TankGame.TankGame01;

import javax.swing.*;
import java.awt.*;

/**
 * @version 1.0
 * @coding: utf-8
 * 定义我的画笔,用来画坦克
 * 坦克大战的绘图区域
 */
public class MyPanel extends JPanel {
    //定义我的坦克
    Hero hero = null;
    public MyPanel() {
        hero = new Hero(100, 100);//初始化自己坦克
    }

    //开始画图
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);//填充矩形，默认黑色
        //画出坦克-封装方法
        drawTank(hero.getX(), hero.getY(), g, 0, 0);
    }
    public void drawTank(
            int x, int y, Graphics g, int direct, int type) {
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
            default:
                System.out.println("暂时没有处理");
        }
    }
}
