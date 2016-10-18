package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.THONGBAO;

public class ThongBaoDAO{
	
	ConnectionDB c;
	Connection conn;
	Statement stmt;
	ResultSet rs;
	PreparedStatement pst;
	public ThongBaoDAO(){
		c = new ConnectionDB();
	}
	public boolean delDataByGV(String maGV){
		boolean res=false;
		conn =c.getConnectSqlServer();
		String sql ="delete from thongbao where MaGVHD =?";
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, maGV);
			res=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
		
	}
}
