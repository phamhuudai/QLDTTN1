package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.bean.NGUOIDUNG;

public class LoginDAO {
	ConnectionDB c;
	Connection conn;
	PreparedStatement pst;
	ResultSet rs;
	
	public LoginDAO() {
		// TODO Auto-generated constructor stub
		c=new ConnectionDB();
	}
	public NGUOIDUNG checkLogin(int ma, String pass){
		NGUOIDUNG objND=null;
		conn = c.getConnectSqlServer();
		String sql="select * from nguoidung where Maso = ? AND PassWord = ?";
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, ma);
			pst.setString(2, pass);
			rs=pst.executeQuery();
			if(rs.next()){
				int maSo =rs.getInt("MaSo");
				String phanQuyen=rs.getString("PhanQuyen").trim();
				String pw=rs.getString("PassWord");
				objND=new NGUOIDUNG(maSo, pw, phanQuyen);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objND;
	}

}
