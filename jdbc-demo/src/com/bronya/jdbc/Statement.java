package com.bronya.jdbc;

import org.junit.Test;
import java.sql.Connection;
import java.sql.DriverManager;

/*JDBC API Statement*/

public class Statement {
    /**
     *  *执行DML（增删改数据）语句，返回收修改数量，没修改就返回0
     *  *执行DDL（增删改库表）语句,成功也可能返回0，所有不要用下面if else判断
    *@throws Exception
    */
    @Test
    public void testStatement() throws Exception {
        String url="jdbc:mysql://localhost:3306/db1?useSSL=false";
        String username="root";
        String password="1234";
        Connection conn = DriverManager.getConnection(url, username, password);
        //定义sql
        String sql="update stu set age= 3000 where id=1";
        String sql2="create database db2";
        //获取执行sql的对象statement
        java.sql.Statement stmt = conn.createStatement();
        //执行sql
        int count= stmt.executeUpdate(sql);//返回受影响函数
        System.out.println(count);
        int count2= stmt.executeUpdate(sql2);//返回受影响函数
        if(count2>0){
            System.out.println( "修改成功");
        }else{
            System.out.println("修改失败");
        }
        //释放资源
        stmt.close();
        conn.close();
    }
}
