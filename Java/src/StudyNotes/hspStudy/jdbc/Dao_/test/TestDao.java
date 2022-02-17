package StudyNotes.hspStudy.jdbc.Dao_.test;

import StudyNotes.hspStudy.jdbc.Dao_.dao.ActorDao;
import StudyNotes.hspStudy.jdbc.Dao_.dao.GoodsDao;
import StudyNotes.hspStudy.jdbc.Dao_.domain.Actor;
import StudyNotes.hspStudy.jdbc.Dao_.domain.Goods;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @version 1.0
 * @coding: utf-8
 */
public class TestDao {
    //测试 ActorDAO 对 actor 表 crud 操作
    @Test
    public void testActorDAO() {
        ActorDao actorDao = new ActorDao();
        //1. 查询
        List<Actor> actors = actorDao.queryMulti("select * from actor where id >= ?", Actor.class, 1);
        System.out.println("===查询结果===");
        for (Actor actor : actors) {
            System.out.println(actor);
        }
        //2. 查询单行记录
        Actor actor = actorDao.querySingle("select * from actor where id = ?", Actor.class, 6);
        System.out.println("====查询单行结果====");
        System.out.println(actor);
        //3. 查询单行单列
        Object o = actorDao.queryScalar("select name from actor where id = ?", 6);
        System.out.println("====查询单行单列值===");
        System.out.println(o);
        //4. dml 操作 insert ,update, delete
        int update = actorDao.update("insert into actor values(null, ?, ?, ?, ?)", "张无忌", "男", "2000-11-11", "999");
        System.out.println(update > 0 ? "执行成功" : "执行没有影响表");
    }


    //测试 ActorDAO 对 Goods 表 crud 操作
    @Test
    public void testGoodsDAO() {
        GoodsDao goodsDao = new GoodsDao();
        //1. 查询
        List<Goods> goods = goodsDao.queryMulti("select * from goods where id >= ?", Goods.class, 1);
        System.out.println("===查询结果===");
        for (Goods good : goods) {
            System.out.println(good);
        }
        //2. 查询单行记录
        Goods good = goodsDao.querySingle("select * from goods where id = ?", Goods.class, 6);
        System.out.println("====查询单行结果====");
        System.out.println(good);
        //3. 查询单行单列
        Object o = goodsDao.queryScalar("select goods_name from goods where id = ?", 3);
        System.out.println("====查询单行单列值===");
        System.out.println(o);
        //4. dml 操作 insert ,update, delete
        int update = goodsDao.update("INSERT INTO goods VALUES(?,?,?)", "6", "he", "2300");
        System.out.println(update > 0 ? "执行成功" : "执行没有影响表");
    }
}