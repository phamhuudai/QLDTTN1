package model.dao;

import java.sql.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import model.bean.DANGKYDETAI;

public class DangKyDAO {
	ConnectionDB c;
	Connection conn;
	Statement stm;
	ResultSet rs;
	int row;
	public DangKyDAO() {
		// TODO Auto-generated constructor stub
		c = new ConnectionDB();
	}
	public ArrayList<DANGKYDETAI> getList(int page,  int numOfRecords){
		int offset=(page-1)*numOfRecords+1;
		conn = c.getConnectSqlServer();
		ArrayList<DANGKYDETAI> arDK = new ArrayList<DANGKYDETAI>();
		String sql = "SELECT dangkidetai.MDK, sinhvien.HoTen,sinhvien.MSSV,detai.MDT, detai.TenDeTai, dangkidetai.HinhThuc, dangkidetai.NgayDK  "
					+" from (SELECT *, ROW_NUMBER() OVER (ORDER BY dangkidetai.MDK DESC) AS RN FROM dangkidetai ) "
					+" dangkidetai  INNER JOIN detai  on detai.MDT =dangkidetai.MDT "
					+" INNER JOIN sinhvien  on sinhvien.MSSV=dangkidetai.MSSV1 or sinhvien.MSSV = dangkidetai.MSSV2" 
					+" WHERE RN BETWEEN "+offset+" AND "+(numOfRecords+offset-1);
		try {
			stm =conn.createStatement();
			rs=stm.executeQuery(sql);
			while(rs.next()){
				int mdk=rs.getInt("MDK");
				int mdt=rs.getInt("MDT");
				int hinhthuc=rs.getInt("HinhThuc");
				int mssv=rs.getInt("MSSV");
				Date ngaydk=rs.getDate("NgayDK");
				String tenSV=rs.getString("HoTen");
				String tenDeTai=rs.getString("TenDeTai");
				DANGKYDETAI dk = new DANGKYDETAI(mdk, mdt, hinhthuc, mssv, ngaydk, tenSV, tenDeTai);
				arDK.add(dk);
			}
			rs=stm.executeQuery("Select count(*) from dangkidetai");
			if(rs.next()){
				this.row=rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arDK;

	}
	public int getRow(){
		return this.row;
	}
	public static void main(String[] args) {
		DangKyDAO dk = new DangKyDAO();
		System.out.println(dk.getList(1, 10));
	}

}
