package StudyNotes.hspStudy.jdbc;

import StudyNotes.hspStudy.Utils.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @version 1.0
 * @coding: utf-8
 * 演示 java 的批处理
 */
public class Batch_ {
    //传统方法，添加 5000 条数据到 admin2
    @Test
    public void noBatch() throws Exception {
        Connection connection = JDBCUtils.getConnection();
        String sql = "insert into admin2 values(null, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        System.out.println("开始执行");
        long start = System.currentTimeMillis();//开始时间
        for (int i = 0; i < 5000; i++) {//5000 执行
            preparedStatement.setString(1, "jack" + i);
            preparedStatement.setString(2, "666");
            preparedStatement.executeUpdate();
        }
        long end = System.currentTimeMillis();
        System.out.println("传统的方式 耗时=" + (end - start));//传统的方式 耗时=5553
        //关闭连接
        JDBCUtils.close(null, preparedStatement, connection);
    }


    @Test
    //使用批量方式添加数据
    public void batch() throws Exception {
        Connection connection = JDBCUtils.getConnection();
        String sql = "insert into admin2 values(null, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        System.out.println("开始执行");
        long start = System.currentTimeMillis();//开始时间
        for (int i = 0; i < 5000; i++) {//5000 执行
            preparedStatement.setString(1, "jack" + i);
            preparedStatement.setString(2, "666");
            preparedStatement.addBatch();
            //当有 1000 条记录时，在批量执行
            if ((i + 1) % 1000 == 0) {//满 1000 条 sql
                preparedStatement.executeBatch();
                //清空一把
                preparedStatement.clearBatch();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("批量方式 耗时=" + (end - start));//批量方式 耗时=72
        //关闭连接
        JDBCUtils.close(null, preparedStatement, connection);
    }
}