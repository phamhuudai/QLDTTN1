package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import model.bean.SINHVIENDANGKYDETAI;

public class SinhVienDangKyDeTaiDAO {
	private Connection conn;
	private ResultSet rs;
	private Statement st;
	private PreparedStatement pst;
	ConnectionDB connect;

	public SinhVienDangKyDeTaiDAO(){
		connect = new ConnectionDB();
	}

	public int addDeTai1(SINHVIENDANGKYDETAI objDeTai) {
		int result =0;
		conn = connect.getConnectSqlServer();
		String sql = "INSERT INTO dangkidetai(MDK,MDT,HinhThuc,MSSV1,NgayDK) VALUES (?,?,?,?,?)";
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, objDeTai.getMDK());
			pst.setInt(2, objDeTai.getMDT());
			pst.setBoolean(3, objDeTai.isHinhThuc());
			pst.setInt(4, objDeTai.getMSSV1());
			java.util.Date utilDate = objDeTai.getNgayDK();
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			pst.setDate(5, sqlDate);
			pst.executeUpdate();
			result = 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} finally{
			try {
				pst.close();
				conn.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	public int addDeTai2(SINHVIENDANGKYDETAI objDangkydetai) {
		int result =0;
		conn = connect.getConnectSqlServer();
		String sql = "INSERT INTO dangkidetai(MDK,MDT,HinhThuc,MSSV1,MSSV2,NgayDK) VALUES (?,?,?,?,?,?)";
		System.out.println("SQL:     "+sql );
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, objDangkydetai.getMDK());
			pst.setInt(2, objDangkydetai.getMDT());
			pst.setBoolean(3, objDangkydetai.isHinhThuc());
			pst.setInt(4, objDangkydetai.getMSSV1());
			pst.setInt(5, objDangkydetai.getMSSV2());
			java.util.Date utilDate = objDangkydetai.getNgayDK();
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			pst.setDate(6, sqlDate);
			pst.executeUpdate();
			result = 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} finally{
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	public SINHVIENDANGKYDETAI getObjDeTaiSV(int mssv1) {
		conn = connect.getConnectSqlServer();
		String sql = "SELECT * FROM dangkidetai WHERE MSSV1 =? ";
		System.out.println("SQL : "+sql);
		SINHVIENDANGKYDETAI objDeTai = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, mssv1);
			rs = pst.executeQuery();
			if(rs.next()){
				int MDK = rs.getInt("MDK");
				int MaDT = rs.getInt("MDT");
				boolean hinhthuc = rs.getBoolean("hinhthuc");
				int mssv2 = rs.getInt("MSSV2");
				Date NgayDK = rs.getDate("NgayDK");
				objDeTai = new SINHVIENDANGKYDETAI(MDK, MaDT, hinhthuc, mssv1, mssv2, NgayDK);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objDeTai;
	}

}
