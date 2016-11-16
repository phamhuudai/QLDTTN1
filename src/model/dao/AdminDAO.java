package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.bean.NGUOIDUNG;

public class AdminDAO {
	ConnectionDB c;
	Connection conn;
	Statement stmt;
	ResultSet rs;
	PreparedStatement pst;
	public AdminDAO(){
		c = new ConnectionDB();
	}
	public boolean changeInfor(NGUOIDUNG admin){
		boolean result =false;
		String sql ="update nguoidung set Password = ? where MaSo = ?";
		conn = c.getConnectSqlServer();
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, admin.getPass());
			pst.setInt(2, admin.getMaSo());
			pst.executeUpdate();
			result=true;		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
}
