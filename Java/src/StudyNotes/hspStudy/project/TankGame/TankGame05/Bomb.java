package StudyNotes.hspStudy.project.TankGame.TankGame05;

/**
 * @version 1.0
 * @coding: utf-8
 * 击中坦克后的爆炸
 */
public class Bomb {
    int x, y; //爆炸的位置
    int life = 9;//生命周期
    boolean isLife = true;

    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //减少生命值,配合图片出现爆炸效果
    public void lifeDown() {
        if (life > 0) {
            life--;
        } else {
            isLife = false;
        }
    }
}
