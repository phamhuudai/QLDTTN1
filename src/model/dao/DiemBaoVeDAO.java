package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import model.bean.DIEMBAOVE;
import model.bean.SINHVIENDANGKYDETAI;

public class DiemBaoVeDAO {
	private Connection conn;
	private ResultSet rs;
	private PreparedStatement pst;
	private ConnectionDB connect;
	
	public DiemBaoVeDAO(){
		connect = new ConnectionDB();
	}
	
	public DIEMBAOVE getObjDiemBV(int mssv){
		conn = connect.getConnectSqlServer();
		String sql = "SELECT * FROM hoidongbaove INNER JOIN chitiethoidongbaove on hoidongbaove.MaHDBV = chitiethoidongbaove.MaHDBV"
				+"INNER JOIN giaovien on giaovien.MaGVHD = chitiethoidongbaove.MaGVHD"
				+"INNER JOIN dangkidetai on dangkidetai.MDK = hoidongbaove.MDK"
				+"INNER JOIN sinhvien on sinhvien.MSSV =  dangkidetai.MSSV1 or sinhvien.MSSV = dangkidetai.MSSV2 WHERE dangkidetai.MSSV1 =? or dangkidetai.MSSV2=?";
		System.out.println("SQL : "+sql);
		SINHVIENDANGKYDETAI objDeTai = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, mssv);
			pst.setInt(2, mssv);
			rs = pst.executeQuery();
			if(rs.next()){
				int mssv1 = rs.getInt("mssv1");
				int mssv2 = rs.getInt("mssv2");
				String tenSV1 = rs.getString("HoTen");
				int MDK = rs.getInt("MDK");
				int MaDT = rs.getInt("MDT");
				boolean hinhthuc = rs.getBoolean("hinhthuc");
				//int mssv2 = rs.getInt("MSSV2");
				Date NgayDK = rs.getDate("NgayDK");
				objDeTai = new SINHVIENDANGKYDETAI(MDK, MaDT, hinhthuc, mssv1, mssv2, NgayDK);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	
}
