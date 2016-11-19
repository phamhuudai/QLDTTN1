package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.DETAISINHVIEN;

public class DeTaiSinhVienDAO {
	private Connection conn;
	private ResultSet rs;
//	private Statement st;
	private PreparedStatement pst;
	ConnectionDB connect;

	public DeTaiSinhVienDAO() {
		connect = new ConnectionDB();
	}

	public ArrayList<DETAISINHVIEN> getListDeTaiSinhVien() {
		conn = connect.getConnectSqlServer();
		ArrayList<DETAISINHVIEN> alDeTaiSinhViens = new ArrayList<DETAISINHVIEN>();

		String sql = "SELECT * FROM detai inner JOIN chuyennganh  on detai.MaCN = chuyennganh.MaCN "
				+ "INNER JOIN giaovien on giaovien.MaGVHD = detai.MaGVHD";
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				int maDeTai = rs.getInt("MDT");
				String tenDeTai = rs.getString("TenDeTai");
				String tenChuyenNganh = rs.getString("tenCN");
				String giaoVienHuongDan = rs.getString("HoTen");
				String thongtinnoidung = rs.getString("ThongTinNoiDung");
				DETAISINHVIEN objDeTaiSV = new DETAISINHVIEN(maDeTai, tenDeTai, tenChuyenNganh, giaoVienHuongDan,thongtinnoidung);
				alDeTaiSinhViens.add(objDeTaiSV);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				rs.close();
				conn.close();
				pst.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return alDeTaiSinhViens;
	}

	public DETAISINHVIEN getItemDeTaiSinhVien(int id) {
		DETAISINHVIEN deTaiSinhVien = null;
		conn = connect.getConnectSqlServer();
		String sql ="SELECT * FROM detai inner JOIN chuyennganh  on detai.MaCN = chuyennganh.MaCN INNER JOIN giaovien on giaovien.MaGVHD = detai.MaGVHD WHERE detai.MDT=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if(rs.next()){
				int maDeTai = rs.getInt("MDT");
				String tenDeTai = rs.getString("TenDeTai");
//				String maChuyenNganh = rs.getString("MCN")
				String tenChuyenNganh = rs.getString("tenCN");
				String giaoVienHuongDan = rs.getString("HoTen");
				String thongtinnoidung = rs.getString("ThongTinNoiDung");
				deTaiSinhVien = new DETAISINHVIEN(maDeTai, tenDeTai, tenChuyenNganh, giaoVienHuongDan,thongtinnoidung);
			}
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
		
		return deTaiSinhVien;
	}

}
