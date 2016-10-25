package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginDAO {
	ConnectionDB c;
	Connection conn;
	Statement stmt;
	ResultSet rs;
	
	public LoginDAO() {
		// TODO Auto-generated constructor stub
		c=new ConnectionDB();
	}
	public String checkLogin(int ma){
		String result=null;
		conn = c.getConnectSqlServer();
		String slq="select MaSo, PhanQuyen from nguoidung where Maso = "+ma;
		return result;
	}

}
