package com.sc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


//用来连接数据库，可以获取数据库连接对象
public class DBConnection {

    //1.数据库连接参数
    private static String user = "root";
    private static String password="jiaruixue1217";
    private static String url="jdbc:mysql://127.0.0.1:3306/market_vip?serverTimezone=UTC";
    //2.加载驱动类
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    //3.获取数据库连接对象方法
    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn =DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return conn;
    }
    //关闭方法
    public static void closeAll(Connection conn,PreparedStatement ps,ResultSet rs) {
        try {
            if(conn!=null) {
                conn.close();
            }
            if(ps!=null) {
                conn.close();
            }
            if(rs!=null) {
                conn.close();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}