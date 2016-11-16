package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.DANHSACHQL;



public class DanhSachQLDAO {
	ConnectionDB c;
	PreparedStatement pst;
	Connection conn;
	ResultSet rs;
	public DanhSachQLDAO() {
		// TODO Auto-generated constructor stub
		c=new ConnectionDB(); 
	}
	public ArrayList<DANHSACHQL> getList(int maGV){
		ArrayList<DANHSACHQL> arQL=new ArrayList<DANHSACHQL>();
		conn=c.getConnectSqlServer();
		String sql="SELECT sv.HoTen,sv.MSSV, lop.TenLop, sv.Email, sv.SDT, cn.TenCN, dt.TenDeTai  from "+ 
				"detai as dt INNER JOIN dangkidetai as dk on dt.MDT =dk.MDT "+ 
				"INNER JOIN sinhvien as sv on sv.MSSV=dk.MSSV1 or sv.MSSV = dk.MSSV2 "+
				"INNER JOIN chuyennganh as cn on sv.MaCN=cn.MaCN "+
				"INNER JOIN lop on sv.MaLop = lop.MaLop where dt.MaGVHD=?";

		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, maGV);
			rs=pst.executeQuery();
			while(rs.next()){
				String tenSV=rs.getString("HoTen");
				int maSV=rs.getInt("MSSV");
				String lop=rs.getString("TenLop");
				String email=rs.getString("Email");
				String sdt=rs.getString("SDT");
				String tenCN=rs.getString("TenCN");
				String tenDT=rs.getString("TenDeTai");
				DANHSACHQL ds = new DANHSACHQL(tenSV, maSV, lop, email, sdt, tenCN, tenDT);
				
				arQL.add(ds);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arQL;
	}
/*	public static void main(String[] args) {
		DanhSachQLDAO ds = new DanhSachQLDAO();
		System.out.println(ds.getList(200004));
	}*/
	
	public ArrayList<DANHSACHQL> getListSinhVien(int maGV){
		ArrayList<DANHSACHQL> arQL=new ArrayList<DANHSACHQL>();
		conn=c.getConnectSqlServer();
		String sql="SELECT sv.HoTen,sv.MSSV, lop.TenLop, sv.Email, sv.SDT  from detai as dt "
				+ "INNER JOIN dangkidetai as dk on dt.MDT =dk.MDT "
				+ "INNER JOIN sinhvien as sv on sv.MSSV=dk.MSSV1 or sv.MSSV = dk.MSSV2 "
				+ "INNER JOIN lop on sv.MaLop = lop.MaLop where dt.MaGVHD=?";

		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, maGV);
			rs=pst.executeQuery();
			while(rs.next()){
				String tenSV=rs.getString("HoTen");
				int maSV=rs.getInt("MSSV");
				String lop=rs.getString("TenLop");
				String email=rs.getString("Email");
				String sdt=rs.getString("SDT");
				DANHSACHQL ds = new DANHSACHQL(tenSV, maSV, lop, email, sdt, "", "");
				
				arQL.add(ds);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arQL;
	}
	
	
	public ArrayList<DANHSACHQL> TimSinhVien(int maGV, String ten){
		ArrayList<DANHSACHQL> arQL=new ArrayList<DANHSACHQL>();
		conn=c.getConnectSqlServer();
		String sql="SELECT sv.HoTen,sv.MSSV, lop.TenLop, sv.Email, sv.SDT  from detai as dt "
				+ "INNER JOIN dangkidetai as dk on dt.MDT =dk.MDT "
				+ "INNER JOIN sinhvien as sv on sv.MSSV=dk.MSSV1 or sv.MSSV = dk.MSSV2 "
				+ "INNER JOIN lop on sv.MaLop = lop.MaLop where dt.MaGVHD=? and sv.HoTen like N'%"+ten+"%'";

		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, maGV);
			rs=pst.executeQuery();
			while(rs.next()){
				String tenSV=rs.getString("HoTen");
				int maSV=rs.getInt("MSSV");
				String lop=rs.getString("TenLop");
				String email=rs.getString("Email");
				String sdt=rs.getString("SDT");
				DANHSACHQL ds = new DANHSACHQL(tenSV, maSV, lop, email, sdt, "", "");
				
				arQL.add(ds);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arQL;
	}
	

}
