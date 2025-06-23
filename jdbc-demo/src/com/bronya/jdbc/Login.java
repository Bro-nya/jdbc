package com.bronya.jdbc;

import org.junit.Test;

import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class Login {

    /// 会被sql注入的登录
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

    /// 防止sql注入，preparedStatement
    @Test
    public void testLogin_Inject() throws Exception {
        //useServerPrepStmts=true 开启预编译
        String url = "jdbc:mysql://localhost:3306/test?useSSL=false&useServerPrepStmts=true";
        String username = "root";
        String password = "1234";
        Connection conn = DriverManager.getConnection(url, username, password);

        String name="bronya";
        String pwd="123456";

        String sql = "select * from tb_user where name=? and pwd=?";

        //创建链接对象，并传入sql值
        PreparedStatement stmt=conn.prepareStatement(sql);
        //设置？的值
        stmt.setString(1,name);
        stmt.setString(2,pwd);

        ResultSet rs=stmt.executeQuery();

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
