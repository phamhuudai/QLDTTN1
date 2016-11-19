package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import model.bean.SINHVIENDANGKYDETAI;

public class DangKyDeTaiDAO {
	private Connection conn;
	private ResultSet rs;
	// private Statement st;
	private PreparedStatement pst;
	ConnectionDB connect;

	public DangKyDeTaiDAO() {
		connect = new ConnectionDB();
	}

	public int addDeTaiDangKy_1(SINHVIENDANGKYDETAI ObjdkDeTai) {
		int result = 0;
		conn = connect.getConnectSqlServer();
		String sql = "INSERT INTO dangkidetai(MDK,MDT,HinhThuc,MSSV1,NgayDK) VALUES(?,?,?,?,?);";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, ObjdkDeTai.getMDK());
			pst.setInt(2, ObjdkDeTai.getMDT());
			pst.setBoolean(3, ObjdkDeTai.isHinhThuc());
			pst.setInt(4, ObjdkDeTai.getMSSV1());
			java.util.Date utilDate = ObjdkDeTai.getNgayDK();
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			pst.setDate(5, sqlDate);
			pst.executeUpdate();
			result = 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
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
