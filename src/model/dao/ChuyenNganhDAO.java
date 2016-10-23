package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;





import model.bean.CHUYENNGANH;

public class ChuyenNganhDAO {
	ConnectionDB c;
	Connection conn;
	ResultSet rs;
	Statement stmt;
	PreparedStatement pst;
	public ChuyenNganhDAO(){
		c= new ConnectionDB();
	}
	public String getName(int id){
		String result="";
		conn=c.getConnectSqlServer();
		try {
			stmt=conn.createStatement();
			String sql="select TenCN from chuyenNganh where MaCN = '"+id+"'";
			rs=stmt.executeQuery(sql);
			if(rs.next()){
				result=rs.getString("TenCN");				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return result;
	}
	public ArrayList<CHUYENNGANH> getList(){
		ArrayList<CHUYENNGANH> arCN = new ArrayList<CHUYENNGANH>();
		conn=c.getConnectSqlServer();
		try {
			stmt=conn.createStatement();
			String sql="select * from chuyennganh";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				int macn=rs.getInt(1);
				String tencn=rs.getString(2);
				CHUYENNGANH cn = new CHUYENNGANH(macn,tencn);
				arCN.add(cn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arCN;
	}
	public boolean isExist(int maCn){
		boolean result=false;
		conn=c.getConnectSqlServer();
		String sql = "select * from chuyennganh where maCN = ? ";
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, maCn);
			rs=pst.executeQuery();
			if(rs.next()){
				result=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return result;
		
	}
	

}
