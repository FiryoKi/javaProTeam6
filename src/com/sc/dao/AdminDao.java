package com.sc.dao;
import com.sc.po.Admin;
import com.sc.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
//管理员登录方法
public class AdminDao {
    public Admin Login(Admin admin){
        String sql = "select*from user where Admin=? and Password =?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs =null;
        Admin a = new Admin();
        try{
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,a.getAdmin());
            ps.setString(2,a.getPassword());
            rs = ps.executeQuery();

            while(rs.next()){
                a.setUid(rs.getInt(1));
                a.setAdmin(rs.getString(2));
                a.setPassword(rs.getString(3));
                a.setPID(rs.getInt(4));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            DBConnection.closeAll(conn, ps, rs);
        }
        return a;

    }
}
