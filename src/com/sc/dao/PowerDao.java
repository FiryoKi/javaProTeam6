package com.sc.dao;

import com.sc.po.Power;
import com.sc.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PowerDao {
    //查询权限
    public Power selectPower(String Power){
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        //用来存储数据库查询结果的
        Power p=new Power();
        try {
            //1.sql语句
            String sql="select * from power where Power =?";
            //2.预编译sql语句
            //获取数据库连接对象
            conn= DBConnection.getConnection();
            //预编译对象
            ps=conn.prepareStatement(sql);
            ps.setString(1,Power);
            //执行并得到结果集
            rs=ps.executeQuery();
            // 5.ִ执行
            while (rs.next()) {
                p.setPID(rs.getInt(1));
                p.setPower(rs.getString(2));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            DBConnection.closeAll(conn, ps, null);
        }
        return p;
    }

}
