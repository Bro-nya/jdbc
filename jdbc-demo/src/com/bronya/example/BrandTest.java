package com.bronya.example;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.bronya.pojo.Brand;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

public class BrandTest {

    @Test
    public void BrandSelectAll() throws Exception {
        //加载德鲁伊配置文件，并且获取连接池对象，再获取数据库连接
        Properties prop = new Properties();
        prop.load(new FileInputStream("D:\\juan\\mycode\\jdbc\\jdbc-demo\\src\\druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        Connection conn = dataSource.getConnection();
        //定义sql
        String sql = "select * from tb_brand Limit 2";
        //获取pstms对象
        PreparedStatement pstmt = conn.prepareStatement(sql);
        //执行sql
        ResultSet rs = pstmt.executeQuery();
        //处理结果封装
        Brand brand = null;
        List<Brand> brands = new ArrayList<Brand>();
        while (rs.next()) {
            int id = rs.getInt("id");
            String brandName = rs.getString("brand_name");
            String companyName = rs.getString("company_name");
            int ordered = rs.getInt("ordered");
            String description = rs.getString("description");
            int status = rs.getInt("status");

            brand = new Brand();
            brand.setId(id);
            brand.setBrandName(brandName);
            brand.setCompanyName(companyName);
            brand.setOrdered(ordered);
            brand.setDescription(description);
            brand.setStatus(status);

            brands.add(brand);
        }
        System.out.println(brands);
        rs.close();
        pstmt.close();
        conn.close();
    }

    @Test
    public void BrandAdd() throws Exception {
        //模拟接收的数据
        // 接收页面提交的参数
        String brandName = "香飘飘";
        String companyName = "香飘飘";
        int ordered = 1;
        String description = "绕地球一圈";
        int status = 1;

        //加载德鲁伊配置文件，并且获取连接池对象，再获取数据库连接
        Properties prop = new Properties();
        prop.load(new FileInputStream("D:\\juan\\mycode\\jdbc\\jdbc-demo\\src\\druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        Connection conn = dataSource.getConnection();
        //定义sql
        String sql = "insert into tb_brand(brand_name, company_name, ordered, description, STATUS) values(?,?,?,?,?)";
        //获取pstms对象
        PreparedStatement pstmt = conn.prepareStatement(sql);
        //设置？参数
        pstmt.setString(1, brandName);
        pstmt.setString(2, companyName);
        pstmt.setInt(3, ordered);
        pstmt.setString(4, description);
        pstmt.setInt(5, status);
        //执行sql
        int count = pstmt.executeUpdate();//返回受影响的行数
        //执行结果
        System.out.println(count>0);

        pstmt.close();
        conn.close();
    }

    @Test
    public void BrandUpdate() throws Exception {
        //模拟接收的数据
        // 接收页面提交的参数
        String brandName = "香飘飘";
        String companyName = "香飘飘";
        int ordered = 10000;
        String description = "绕地球三圈";
        int status = 1;

        int id=4;

        //加载德鲁伊配置文件，并且获取连接池对象，再获取数据库连接
        Properties prop = new Properties();
        prop.load(new FileInputStream("D:\\juan\\mycode\\jdbc\\jdbc-demo\\src\\druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        Connection conn = dataSource.getConnection();
        //定义sql
        String sql = "update tb_brand set brand_name=?,company_name=?,ordered=?,description=?,status=? where id=?";
        //获取pstms对象
        PreparedStatement pstmt = conn.prepareStatement(sql);
        //设置？参数
        pstmt.setString(1, brandName);
        pstmt.setString(2, companyName);
        pstmt.setInt(3, ordered);
        pstmt.setString(4, description);
        pstmt.setInt(5, status);
        pstmt.setInt(6, id);

        //执行sql
        int count = pstmt.executeUpdate();//返回受影响的行数
        //执行结果
        System.out.println(count>0);

        pstmt.close();
        conn.close();
    }

    @Test
    public void BrandDelete() throws Exception {
        //模拟接收的数据
        // 接收页面提交的参数

        int id=4;

        //加载德鲁伊配置文件，并且获取连接池对象，再获取数据库连接
        Properties prop = new Properties();
        prop.load(new FileInputStream("D:\\juan\\mycode\\jdbc\\jdbc-demo\\src\\druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        Connection conn = dataSource.getConnection();
        //定义sql
        String sql = "delete from tb_brand where id=?";
        //获取pstms对象
        PreparedStatement pstmt = conn.prepareStatement(sql);
        //设置？参数
        pstmt.setInt(1, id);

        //执行sql
        int count = pstmt.executeUpdate();//返回受影响的行数
        //执行结果
        System.out.println(count>0);

        pstmt.close();
        conn.close();
    }
}
