package com.sc.dao;

import com.sc.po.VipCard;
import com.sc.util.DBConnection;
import com.sc.util.DateUtil;
import com.sc.util.InputUtil;

import java.sql.*;
import java.util.ArrayList;

public class VipCardDao {
    public VipCard login(VipCard vip) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        VipCard v = new VipCard();
        try {
            String sql = "select * from vipcard where name=? and password=?";
            conn = DBConnection.getConnection();
            ps = conn.prepareStatement(sql);
            // 4.赋值
            // 5.ִ执行
            ps.setString(1, vip.getName());
            ps.setString(2, vip.getPassword());
            rs = ps.executeQuery();
            while (rs.next()) {
                v.setCid(rs.getInt(1));
                v.setName(rs.getString(2));
                v.setPassword(rs.getString(3));
                v.setPoint(rs.getInt(5));
                v.setCdate(rs.getString(6));
                v.setCard(rs.getString(4));
                v.setPid(rs.getInt(7));
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            DBConnection.closeAll(conn, ps, rs);
        }
        return v;
    }

    /**
     * 开卡-添加会员信息
     * @param vipCard
     * @return
     * @throws SQLException
     */
    public int addVipCard(VipCard vipCard){
        int i = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "INSERT INTO VipCard(name, password, card, cdate) VALUES (?, ?, ?, ?)";
            conn=DBConnection.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, vipCard.getName());
            pstmt.setString(2, vipCard.getPassword());
            pstmt.setString(3, vipCard.getCard());
            pstmt.setString(4, vipCard.getCdate());
            i=pstmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            DBConnection.closeAll(conn, pstmt, rs);
        }
        return i;
    }



    //dao修改密码
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

            ps.setString(2,v.getName());
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
    /*//会员修改密码
     public int updatePassword(VipCard v) {
        int i = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            // 1.sql语句
            String sql = "update vipcard set password=? where name=?";
            // 2.获取数据库连接对象
            conn = DBConnection.getConnection();
            // 3.预编译
            ps = conn.prepareStatement(sql);
            // 4.赋值
            System.out.println("请输入用户名：");
            String name = InputUtil.getString();
            ps.setString(2, name);
            ps.setString(1, v.getPassword());

            // 5.ִ执行
            i = ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            DBConnection.closeAll(conn, ps, null);
        }
        return i;
    }

     */

    public Integer selectPointsByCard(String card) {
        int i = 0;
        Connection conn = null;
        PreparedStatement ps = null;
		Integer point = null;
		try {
            // 1.sql语句
            String sql = "select Point from vipcard where Card=?";
            // 2.获取数据库连接对象
            conn = DBConnection.getConnection();
            // 3.预编译
            ps = conn.prepareStatement(sql);
            // 4.赋值
            ps.setString(1, card);
			ResultSet rs = ps.executeQuery();
			// 5.ִ执行
            while (rs.next()) {
				point = rs.getInt(1);
			}
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            DBConnection.closeAll(conn, ps, null);
        }
        return point;
    }
    //积分累计
    public int addPoints(String card, int points) {
        int i = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            // 1.sql语句
            String sql = "update vipcard set Point=? where card=?";
            // 2.获取数据库连接对象
            conn = DBConnection.getConnection();
            // 3.预编译
            ps = conn.prepareStatement(sql);
            // 4.赋值
            ps.setInt(1, points+selectPointsByCard(card));
            ps.setString(2, card);
            // 5.ִ执行
            i = ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            DBConnection.closeAll(conn, ps, null);
        }
        return i;
    }
    //查询所有会员信息
	public ArrayList<VipCard> selectAllVip(){
		int i = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		ArrayList<VipCard> vipList = new ArrayList<>();
		try {
			// 1.sql语句
			String sql = "select * from vipcard";
			// 2.获取数据库连接对象
			conn = DBConnection.getConnection();
			// 3.预编译
			ps = conn.prepareStatement(sql);
			// 4.ִ执行
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				 int cid=rs.getInt(1);
				 String name=rs.getString(2);
				 String password=rs.getString(3);
				 String card=rs.getString(4);
				 int point=rs.getInt(5);
				 Date cdate=rs.getDate(6);
				 int pid=rs.getInt(7);
				 vipList.add(new VipCard(cid,name,password,card,point, DateUtil.dateToString(cdate),pid));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.closeAll(conn, ps, null);
		}
		return vipList;
	}

    //兑换后修改积分
    public int updatePoint(int point,String card){
        int i=0;
        Connection conn=null;
        PreparedStatement ps =null;
        try {
            String sql="update vipcard set Point=? where card=?";
            //数据库连接
            conn=DBConnection.getConnection();
            //预编译
            ps= conn.prepareStatement(sql);
            ps.setInt(1, point);
            ps.setString(2, card);
            i=ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            DBConnection.closeAll(conn, ps, null);
        }
        return i;
    }
    //查询卡号是否与表中一致
    public VipCard selectCard(String card){
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        //用来存储数据库查询结果的
        VipCard v=new VipCard();
        try {
            //1.sql语句
            String sql="select * from vipcard where Card=?";
            //2.预编译sql语句
            //获取数据库连接对象
            conn=DBConnection.getConnection();
            //预编译对象
            ps=conn.prepareStatement(sql);
            ps.setString(1,card);
            //执行并得到结果集
            rs=ps.executeQuery();
            // 5.ִ执行
            while (rs.next()) {
                v.setCid(rs.getInt(1));
                v.setName(rs.getString(2));
                v.setPassword(rs.getString(3));
                v.setCard(rs.getString(4));
                v.setPoint(rs.getInt(5));
                v.setCdate(rs.getString(6));
                v.setPid(rs.getInt(7));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            DBConnection.closeAll(conn, ps, null);
        }
        return v;
    }
}
