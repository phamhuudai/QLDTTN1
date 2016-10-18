package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IdProcess {
	ConnectionDB c ;
	PreparedStatement pst;
	Connection conn;
	ResultSet rs;
	//xu ly cat 3 so cuoi cua ID o vi tri cuoi cung trong Bang
	public IdProcess(){
		c = new ConnectionDB();
	}
	public int getID(String id, String tenBang){
		//String idProcess = null;
		int idInt = 0;
		conn = c.getConnectSqlServer();
		//cat so tu id
		
		String sql = "SELECT MAX(cast ("+id+" as int)) as id FROM " +tenBang;
		try {
			pst =conn.prepareStatement(sql);
			rs =pst.executeQuery();
			if(rs.next()){
				idInt =rs.getInt("id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				pst.close();
				rs.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return idInt+1;
	}
	/*public static void main(String[] agrs){
		IdProcess idProcess=new IdProcess();
		int id = idProcess.getID("MaGVHD", "giaovien");
		System.out.println(id);
	}*/
}
