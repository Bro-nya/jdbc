package com.bronya.jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*JDBC API Connection*/

/// 事务
public class Connection {
    public static void main(String[] args) throws SQLException {
        String url="jdbc:mysql://localhost:3306/db1?useSSL=false";
        String username="root";
        String password="1234";
        java.sql.Connection conn = DriverManager.getConnection(url, username, password);

        String sql="update stu set age= 2000 where id=1";
        String sql2="update stu set age= 2000 where id=2";

        Statement stmt = conn.createStatement();

        try {
            //开启事务
            conn.setAutoCommit(false);
            int count= stmt.executeUpdate(sql);
            System.out.println(count);

            int count2= stmt.executeUpdate(sql2);
            System.out.println(count);

            //提交事务
            conn.commit();
        } catch (Exception e) {

            //回滚事务
            conn.rollback();
            throw new RuntimeException(e);
        }

        stmt.close();
        conn.close();
    }
}
