package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.bean.GIAOVIEN;
import model.bean.NGUOIDUNG;
import model.bean.SINHVIEN;

public class NguoiDungDAO {
	ConnectionDB c;
	Connection conn;
	Statement stmt;
	ResultSet rs;
	PreparedStatement pst;
	public NguoiDungDAO(){
		c = new ConnectionDB();
	}
	public boolean insertData(NGUOIDUNG objNguoidung){
		boolean r =false;
		conn = c.getConnectSqlServer();
		String sql ="insert into nguoidung values(?,?,?)";
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, objNguoidung.getMaSo());
			pst.setString(2, objNguoidung.getPass());
			pst.setString(3, objNguoidung.getPhanQuyen());
			pst.executeUpdate();
			r=true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				conn.close();
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return r;
	}
	public boolean delData(int id){
		boolean res =false;
		conn=c.getConnectSqlServer();
		String sql="delete from nguoidung where maso =?";
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
			res=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;		
		
	}
}
