package com.sc.dao;

import com.sc.po.Good;
import com.sc.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.sc.util.DBConnection;

public class GoodDao {
    //会员或管理员查询有哪些可以兑换的东西
    public List<Good>selectAll(){
        List<Good> good=new ArrayList<Good>();
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            String sql="select * from Good";
            //获取连接
            conn=DBConnection.getConnection();
            //预编译sql语句
            ps=conn.prepareStatement(sql);
            //获取结果集
            rs=ps.executeQuery();
            while(rs.next()) {
                Good g=new Good();
                g.setGid(rs.getInt(1));
                g.setGoodName(rs.getString(2));
                g.setNeedPoint(rs.getInt(3));
                g.setNumber(rs.getInt(4));
                good.add(g);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            DBConnection.closeAll(conn, ps, rs);
        }
        return good;

    }
    //查看要兑换物品是否在其中
    public Good Exchange(Good good) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        //用来存储数据库查询结果的
        Good g=new Good();
        try {
            //1.sql语句
            String sql="select * from Good where GoodName=?";
            //2.预编译sql语句
            //获取数据库连接对象
            conn=DBConnection.getConnection();
            //预编译对象
            ps=conn.prepareStatement(sql);
            //给?赋值
            ps.setString(1, good.getGoodName());
            //执行并得到结果集
            rs=ps.executeQuery();
            while(rs.next()) {
                g.setGid(rs.getInt(1));
                g.setGoodName(rs.getString(2));
                g.setNeedPoint(rs.getInt(3));
                g.setNumber(rs.getInt(4));

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            DBConnection.closeAll(conn,ps,rs);
        }
        return g;

    }
    //兑换成功后修改数据库中数目
    public int updateNumber(String GoodName,int Number){
        int i=0;
        Connection conn=null;
        PreparedStatement ps =null;
        try {
            String sql="update Good set Number=? where GoodName=? ";
            //数据库连接
            conn=DBConnection.getConnection();
            //预编译
            ps= conn.prepareStatement(sql);
            ps.setInt(1, Number);
            ps.setString(2, GoodName);
            i=ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            DBConnection.closeAll(conn, ps, null);
        }
        return i;
    }
    //管理员增加能够兑换的商品
    public int add(Good g) {
        int i=0;
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            String sql="insert into Good values(null,?,?,?)";
            conn=DBConnection.getConnection();
            ps=conn.prepareStatement(sql);
            ps.setString(1, g.getGoodName());
            ps.setInt(2, g.getNeedPoint());
            ps.setInt(3,g.getNumber());
            i=ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            DBConnection.closeAll(conn, ps, rs);
        }
        return i;
    }
    //管理员修改能够兑换的商品
    public int update(Good g) {
        int i=0;
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            String sql="update Good set GoodName=?,NeedPoint=?,Number=? where Gid=?";
            conn=DBConnection.getConnection();
            ps=conn.prepareStatement(sql);
            ps.setString(1, g.getGoodName());
            ps.setInt(2, g.getNeedPoint());
            ps.setInt(3, g.getNumber());
            ps.setInt(4, g.getGid());
            i=ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            DBConnection.closeAll(conn, ps, rs);
        }
        return i;
    }
    //管理员删除能够兑换的商品
    public int delete(int Gid) {
        int i=0;
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            String sql="delete from Good where Gid=?";
            conn=DBConnection.getConnection();
            ps=conn.prepareStatement(sql);
            ps.setInt(1, Gid);
            i=ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            DBConnection.closeAll(conn, ps, rs);
        }
        return i;
    }
}
