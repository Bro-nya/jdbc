package com.itheima.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCDemo {
    public static void main(String[] args) throws Exception {
        //注册驱动
        //Class.forName("com.mysql.jdbc.Driver");// 现在可以省略不写了
        //获取链接
        String url="jdbc:mysql://localhost:3306/db1?useSSL=false";
        String username="root";
        String password="1234";
        Connection conn = DriverManager.getConnection(url, username, password);
        //定义sql
        String sql="update stu set age= 2000 where id=1";
        //获取执行sql的对象statement
        Statement stmt = conn.createStatement();
        //执行sql
        int count= stmt.executeUpdate(sql);//返回受影响函数
        System.out.println(count);
        //释放资源
        stmt.close();
        conn.close();
    }
}
