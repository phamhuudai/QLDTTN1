package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sun.javafx.sg.prism.NGDefaultCamera;

import model.bean.DETAI;
import model.bean.DETAI;
import model.bean.DETAI;


public class DeTaiDAO {
	ConnectionDB c;
	Connection conn;
	Statement stmt;
	ResultSet rs;
	int row;
	PreparedStatement pst;
	public DeTaiDAO(){
		c = new ConnectionDB();

	}
	
	public boolean updateData(DETAI objDeTai){
		boolean rs =false;
		conn = c.getConnectSqlServer();
		String sql ="update DETAI set  TenDeTai=?, MaCN=?, ThongTinNoiDung=?, MaGVHD=? WHERE MDT =?";
		try {
			pst=conn.prepareStatement(sql);			
			pst.setString(1, objDeTai.getTendetai());
			pst.setInt(2, objDeTai.getMacn());
			pst.setString(3, objDeTai.getThongtinnoidung());
			pst.setInt(4, objDeTai.getMagvhd());
			pst.setInt(5, objDeTai.getMadetai());
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
	
	public boolean deleteData(int maDeTai){
		boolean rs =false;
				conn = c.getConnectSqlServer();
				String sql ="delete from DETAI where MDT=?";
				try {
					pst=conn.prepareStatement(sql);					
					pst.setInt(1, maDeTai);
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
	public boolean insertData(DETAI objDeTai){
		boolean r =false	;
			conn = c.getConnectSqlServer();
			String sql="insert into DETAI values(?,?,?,?,?) ";
			try {
				pst=conn.prepareStatement(sql);
				pst.setInt(1, objDeTai.getMadetai());
				pst.setString(2, objDeTai.getTendetai());
				pst.setInt(3, objDeTai.getMacn());
				pst.setString(4,objDeTai.getThongtinnoidung());
				pst.setInt(5, objDeTai.getMagvhd());
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

	
	public DETAI getItemByID(int maDeTai) {
		// TODO Auto-generated method stub
		conn = c.getConnectSqlServer();
		DETAI objDeTai =null;
		try {
			String sql ="select * from DETAI where MDT = ?";
			pst =conn.prepareStatement(sql);
			pst.setInt(1, maDeTai);
			rs=pst.executeQuery();
			if(rs.next()){
				String tenDeTai=rs.getString("TenDetai");
				int maCN=rs.getInt("MaCN");
				String noiDung=rs.getString("ThongTinNoiDung");
				int maGVHD=rs.getInt("MaGVHD");
				objDeTai = new DETAI(maDeTai,tenDeTai,maCN,noiDung,maGVHD);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				rs.close();
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return objDeTai;
	}
	public boolean isExist(int maDeTai){
		boolean result=false;
		conn=c.getConnectSqlServer();
		String sql = "select * from DETAI where MDT = ?";
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, maDeTai);
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
	
	
	public ArrayList<DETAI> getListByPage(int page,  int numOfRecords){
		int offset=(page-1)*numOfRecords+1;
		ArrayList<DETAI> arDeTai = new ArrayList<DETAI>();
		conn=c.getConnectSqlServer();
		String sql="SELECT detai.MDT, detai.TenDeTai, deTai.MaCN, detai.ThongTinNoiDung, detai.MaGVHD, chuyennganh.TenCN, giaovien.HoTen from (select *, ROW_NUMBER() OVER (order by MDT DESC) as RN from detai) detai   INNER JOIN chuyennganh on detai.MaCN = chuyennganh.MaCN INNER JOIN giaovien on giaovien.MaGVHD = detai.MaGVHD"// get RN: row number
				+ " where RN BETWEEN "+offset+" AND "+(numOfRecords+offset-1);		

		try {
			Statement stmt = conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()){
				int madetai=rs.getInt("MDT");
				String tendetai=rs.getString("TenDeTai");
				int macn=rs.getInt("MaCN");
				String thongtinnoidung=rs.getString("ThongTinNoiDung");
				int magvhd=rs.getInt("MaGVHD");
				String tenCN = rs.getString("TenCN");
				String tenGVHD = rs.getString("HoTen");
				DETAI objDeTai = new DETAI(madetai, tendetai, macn, thongtinnoidung, magvhd,tenCN,tenGVHD);
				arDeTai.add(objDeTai);
				
			}
			rs=stmt.executeQuery("Select count(*) from DETAI");
			if(rs.next()){
				this.row=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return arDeTai;
		
	}
	public int getRow(){
		return this.row;
	}
	public ArrayList<DETAI> searchByPage(String name, int page,  int numOfRecords){
		int offset=(page-1)*numOfRecords+1;
		ArrayList<DETAI> arDeTai = new ArrayList<DETAI>();
		conn=c.getConnectSqlServer();
		String sql="SELECT detai.MDT, detai.TenDeTai, deTai.MaCN, detai.ThongTinNoiDung, detai.MaGVHD, chuyennganh.TenCN, DETAI.HoTen from (select *, ROW_NUMBER() OVER (order by MDT DESC) as RN from detai WHERE detai.TenDeTai LIKE N'%"+name+"%') detai   INNER JOIN chuyennganh on detai.MaCN = chuyennganh.MaCN INNER JOIN DETAI on detai.MaGVHD = DETAI.MaGVHD"// get RN: row number
				+ " where RN BETWEEN "+offset+" AND "+(numOfRecords+offset-1)+" AND detai.TenDeTai LIKE N'%"+name+"%'";				
			
		try {
			Statement stmt = conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()){
				int madetai=rs.getInt("MDT");
				String tendetai=rs.getString("TenDeTai");
				int macn=rs.getInt("MaCN");
				String thongtinnoidung=rs.getString("ThongTinNoiDung");
				int magvhd=rs.getInt("MaGVHD");
				String tenCN = rs.getString("TenCN");
				String tenGVHD = rs.getString("HoTen");
				DETAI objDeTai = new DETAI(madetai, tendetai, macn, thongtinnoidung, magvhd,tenCN,tenGVHD);
				arDeTai.add(objDeTai);
				
			}
			rs=stmt.executeQuery("Select count(*) from DETAI WHERE detai.TenDeTai LIKE N'%"+name+"%'");
			if(rs.next()){
				this.row=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		finally{
			try {

				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return arDeTai;
		
	}
	public ArrayList<DETAI> getList(){
		ArrayList<DETAI> arDT = new ArrayList<DETAI>();
		conn=c.getConnectSqlServer();
		try {
			stmt=conn.createStatement();
			String sql ="SELECT * FROM detai";

			rs=stmt.executeQuery(sql);
			while(rs.next()){
				int madetai = rs.getInt("MDT");
				String tendetai=rs.getString("TenDeTai");
				int macn=rs.getInt("MaCN");
				String thongtinnoidung=rs.getString("ThongTinNoiDung");
				int magvhd=rs.getInt("MaGVHD");
				DETAI objDT = new DETAI(madetai, tendetai, macn, thongtinnoidung, magvhd);
				arDT.add(objDT);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return arDT;
	}
/*	public static void main(String[] args) {
		DeTaiDAO detaiDAO = new DeTaiDAO();
		ArrayList<DETAI> arDT =detaiDAO.searchByPage("nhà",1, 2);
		for(int i=0;i<arDT.size();i++){
			System.out.println(arDT.get(i).getTendetai());
			
		}
	}*/
}
