package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import model.bean.SINHVIEN;

public class SinhVienDAO {
	private Connection conn;
	private ResultSet rs;
	private PreparedStatement pst;
	private Statement st;
	private ConnectionDB connect;
	
	public SinhVienDAO(){
		connect = new ConnectionDB();
	}

	public SINHVIEN getObjSV(int id_nguoidung) {
		conn = connect.getConnectSqlServer();
		SINHVIEN objSV = null ;
		String sql = "SELECT * FROM sinhvien INNER JOIN lop on sinhvien.MaLop=lop.MaLop "+
		"INNER JOIN chuyennganh on chuyennganh.MaCN=sinhvien.MaCN WHERE MSSV=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id_nguoidung);
			rs=pst.executeQuery();
			if(rs.next()){
				int mssv = rs.getInt("MSSV");
				String hoTen = rs.getString("HoTen");
				Date date = rs.getDate("NgaySinh");
				String lop = rs.getString("TenLop");
				String tenCN = rs.getString("TenCN");
				String email = rs.getString("email");
				String sdt = rs.getString("SDT");
				String ngaySinh = new SimpleDateFormat("yyyy-MM-dd").format(date);
				String diachi = rs.getString("DiaChi");
	            System.out.println("Ngày sinh: " + ngaySinh);
				
				objSV = new SINHVIEN(mssv, hoTen, date, mssv, mssv, lop, tenCN, diachi, email, sdt);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return objSV;
	}

	public int updateSV(SINHVIEN objSV) {
		int result = 0;
		conn = connect.getConnectSqlServer();
		String	sql = "UPDATE sinhvien set Email = ?, SDT=?, DiaChi=? where MSSV=?";
		System.out.println(sql);
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objSV.getEmail());
			pst.setString(2, objSV.getSdt());
			pst.setString(3, objSV.getDiaChi());
			pst.setInt(4, objSV.getMssv());
			pst.executeUpdate();
			result =1;
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

}
