package model.dao;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import model.bean.DATTG;
import model.bean.DETAI;

public class DatTGDAO {
	ConnectionDB c;
	Connection conn;
	Statement stmt;
	ResultSet rs;
	int row;
	PreparedStatement pst;
	public DatTGDAO(){
		c = new ConnectionDB();

	}
	public ArrayList<DATTG> getList(){
		ArrayList<DATTG> arTG = new ArrayList<DATTG>();
		conn = c.getConnectSqlServer();
		String sql="Select * from dattg";
		try {
			stmt =conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()){
				int maDot =rs.getInt("MaDot");
				Date thoiGianBD=rs.getDate("ThoiGianBD");
				Date thoiGianKT=rs.getDate("ThoiGianKT");
				int thoiGianTH=rs.getInt("ThoiGianTH");
				DATTG tg = new DATTG(maDot, thoiGianBD, thoiGianKT, thoiGianTH);
				arTG.add(tg);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return arTG;
	}
	
	
	public boolean insertData(DATTG tg){
		boolean r =false	;
			conn = c.getConnectSqlServer();
			String sql="insert into dattg values(?,?,?,?) ";
			try {
				pst=conn.prepareStatement(sql);
				pst.setInt(1, tg.getMaDot());
				pst.setDate(2, new java.sql.Date(tg.getThoiGianBD().getTime()));
				pst.setDate(3, new java.sql.Date(tg.getThoiGianKT().getTime()));
				pst.setInt(4, tg.getThoiGianTH());
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
	
	public boolean deleteData(int maDot){
		boolean rs =false;
				conn = c.getConnectSqlServer();
				String sql ="delete from dattg where MaDot=?";
				try {
					pst=conn.prepareStatement(sql);					
					pst.setInt(1, maDot);
					pst.executeUpdate();
					rs=true;
					
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
		
		return rs;
	}
	/*public static void main(String[] args) {
		DatTGDAO d = new DatTGDAO();
		for(DATTG dt :d.getList()){
			System.out.println(dt.getThoiGianBD());
		}
	}*/
}
