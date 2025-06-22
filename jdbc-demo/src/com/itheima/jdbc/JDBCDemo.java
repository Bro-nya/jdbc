package com.itheima.jdbc;

import java.sql.DriverManager;

public class JDBCDemo {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");

        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
    }
}
