package StudyNotes.hspStudy.project.TankGame.TankGame01;

/**
 * @version 1.0
 * @coding: utf-8
 */
public class Tank {
    private int x;//坦克的横坐标
    private int y;//坦克的纵坐标

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }
}