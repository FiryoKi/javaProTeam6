package com.sc.dao;

import com.sc.po.Good;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodDao {
    //会员或管理员查询有哪些可以兑换的东西
    public List<Good>selectAll(){
        List<Good> good=new ArrayList<Good>();
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            String sql="select * from Good";
            conn=DBConnection.getConnection();
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()) {
                Good g=new Good();
                g.setGid(rs.getInt(1));
                g.setGoodName(rs.getString(2));
                g.setNeedPoint(rs.getInt(3));
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
