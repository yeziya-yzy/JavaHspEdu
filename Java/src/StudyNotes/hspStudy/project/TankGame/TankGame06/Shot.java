package StudyNotes.hspStudy.project.TankGame.TankGame06;


/**
 * @version 1.0
 * @coding: utf-8
 * 坦克射击
 */
public class Shot implements Runnable {
    int x;//子弹x
    int y;//子弹y
    int direct = 0;//子弹射击方向
    int speed = 2;//子弹速度
    boolean isLive = true;//子弹是否还是存活的

    public Shot(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    @Override
    public void run() {
        while (isLive) {
            //线程休眠(让子弹出现,不然直接没了)
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //根据方向来改变X和Y坐标
            switch (direct) {
                case 0://上
                    y -= speed;
                    break;
                case 1://右
                    x += speed;
                    break;
                case 2://下
                    y += speed;
                    break;
                case 3://左
                    x -= speed;
                    break;
            }
            //子弹移动到边界,就销毁
            if (!(x >= 0 && x <= 1000 && y >= 0 && y <= 750 && isLive == true)) {
                isLive = false;
            }
        }
    }
}
