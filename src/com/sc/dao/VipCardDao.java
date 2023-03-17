package com.sc.dao;

import com.sc.po.VipCard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VipCardDao {
	public VipCard login(VipCard vip) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		VipCard v= new VipCard();
		try{
			String sql="select * from vipcard where name=? and password=?";
	
		 conn=DBConnection.getConnection();
		 ps=conn.prepareStatement(sql);
		//4.��ֵ
		//5.ִ�У��õ������
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
	//�޸�����
		public int updatePassword(VipCard v){
			int i=0;
			Connection conn=null;
			PreparedStatement ps=null;
			try {
				//1.sql���
				String sql="update vipcard set password=? where name=?";
				//2.���ݿ����Ӷ���
				conn=DBConnection.getConnection();
				//3.Ԥ�������
				ps = conn.prepareStatement(sql);
				//4.��ֵ
				System.out.println("�����������û�����");
				String name=InputUtil.getString();
				ps.setString(2, name);
				ps.setString(1, v.getPassword());
				
				//5.ִ�У��õ����
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
