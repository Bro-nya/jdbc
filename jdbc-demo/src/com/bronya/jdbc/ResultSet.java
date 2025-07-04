package com.bronya.jdbc;

import com.bronya.pojo.Account;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;


/// JDBC API ResultSet

public class ResultSet {

    @Test
    public void testResultSet() throws Exception {
        String url = "jdbc:mysql://localhost:3306/db1?useSSL=false";
        String username = "root";
        String password = "1234";
        Connection conn = DriverManager.getConnection(url, username, password);

        String sql = "select * from stu";

        Statement stmt=conn.createStatement();

        java.sql.ResultSet rs=stmt.executeQuery(sql);

        while(rs.next()){
            int id=rs.getInt(1);
            String name =rs.getString(2);
            int age =rs.getInt("age");

            System.out.println("id:"+id+",name:"+name+",age:"+age);
        }
        rs.close();
        stmt.close();
        conn.close();
    }

    /// 将数据库的表封装进对象，再存储至集合中

    @Test
    public void testResultSet2() throws Exception {
        String url = "jdbc:mysql://localhost:3306/db1?useSSL=false";
        String username = "root";
        String password = "1234";
        Connection conn = DriverManager.getConnection(url, username, password);

        String sql = "select * from stu";

        Statement stmt=conn.createStatement();

        java.sql.ResultSet rs=stmt.executeQuery(sql);

        ArrayList<Account> accounts=new ArrayList<>();

        while(rs.next()){
            Account acc=new Account();

            int id=rs.getInt(1);
            String name =rs.getString(2);
            int age =rs.getInt("age");

            acc.setId(id);
            acc.setName(name);
            acc.setAge(age);

           accounts.add(acc);
        }
        System.out.println(accounts);

        rs.close();
        stmt.close();
        conn.close();
    }
}
