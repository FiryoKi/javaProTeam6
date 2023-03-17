package com.sc.dao;

import com.sc.po.VipCard;
import com.sc.util.DBConnection;
import com.sc.util.InputUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.sc.util.DBConnection;
import com.sc.util.InputUtil;

public class VipCardDao {
    public VipCard login(VipCard vip) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        VipCard v= new VipCard();
        try{
            String sql="select * from vipcard where name=? and password=?";

            conn= DBConnection.getConnection();
            ps=conn.prepareStatement(sql);
            //4.赋值
            //5.执行，得到结果集
            ps.setString(1, vip.getName());
            ps.setString(2, vip.getPassword());


            rs=ps.executeQuery();
            while(rs.next()) {

                v.setCid(rs.getInt(1));
                v.setName(rs.getString(2));
                v.setPassword(rs.getString(3));
                v.setPoint(rs.getInt(5));
                v.setCdate(rs.getString(6));
                v.setCard(rs.getString(4));
                v.setPid(rs.getInt(7));
            }

        }catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            DBConnection.closeAll(conn, ps, rs);
        }
        return v;
    }
    //修改密码
    public int updatePassword(VipCard v){
        int i=0;
        Connection conn=null;
        PreparedStatement ps=null;
        try {
            //1.sql语句
            String sql="update vipcard set password=? where name=?";
            //2.数据库连接对象
            conn=DBConnection.getConnection();
            //3.预编译对象
            ps = conn.prepareStatement(sql);
            //4.赋值
            System.out.println("请输入您的用户名：");
            String name= InputUtil.getString();
            ps.setString(2, name);
            ps.setString(1, v.getPassword());

            //5.执行，得到结果
            i=ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            DBConnection.closeAll(conn, ps, null);
        }
        return i;
    }
}

