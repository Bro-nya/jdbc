package com.bronya.jdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Login {

    @Test
    public void testLogin() throws Exception {
        String url = "jdbc:mysql://localhost:3306/test?useSSL=false";
        String username = "root";
        String password = "1234";
        Connection conn = DriverManager.getConnection(url, username, password);

        String name="bronya";
        String pwd="123456";

        String sql = "select * from tb_user where name='"+name+"' and pwd='"+pwd+"'";

        Statement stmt=conn.createStatement();

        ResultSet rs=stmt.executeQuery(sql);

        if (rs.next()) {
            System.out.println("成功");
        }else {
            System.out.println("失败");
        }

        rs.close();
        stmt.close();
        conn.close();
    }


}
