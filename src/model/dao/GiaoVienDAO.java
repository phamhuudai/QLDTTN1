package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sun.javafx.sg.prism.NGDefaultCamera;

import model.bean.GIAOVIEN;

public class GiaoVienDAO {
	ConnectionDB c;
	Connection conn;
	Statement stmt;
	ResultSet rs;
	PreparedStatement pst;
	public GiaoVienDAO(){
		c = new ConnectionDB();

	}
	public ArrayList<GIAOVIEN> getList(){
		ArrayList<GIAOVIEN> arGV = new ArrayList<GIAOVIEN>();
		conn=c.getConnectSqlServer();
		try {
			stmt=conn.createStatement();
			String sql = "SELECT giaovien.MaGVHD, giaovien.HoTen, giaovien.NgaySinh, giaovien.MaCN, giaovien.Email, giaovien.DiaChi, giaovien.SDT, chuyennganh.TenCN from giaovien INNER JOIN  chuyennganh on giaovien.MaCN = chuyennganh.MaCN ORDER BY magvhd";
			rs=stmt.executeQuery(sql);
			while(rs.next()){
				int magvhd=rs.getInt("MaGVHD");
				String hoten=rs.getString("HoTen");
				java.util.Date ngaysinh=rs.getDate("NgaySinh");
				int macn=rs.getInt("MaCN");
				String email=rs.getString("Email");
				String diachi=rs.getString("DiaChi");
				String sdt=rs.getString("SDT");
				String tenCN=rs.getString("TenCN");
				GIAOVIEN gv = new GIAOVIEN(magvhd, hoten, ngaysinh, macn, email,diachi, sdt,tenCN);
				arGV.add(gv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return arGV;
	}
	public boolean updateGV(GIAOVIEN gv){
		boolean rs =false;
		conn = c.getConnectSqlServer();
		String sql ="update giaovien set  hoten=?, ngaysinh=?, macn=?, email=?,  diachi=?, sdt=? where magvhd=?";
		try {
			pst=conn.prepareStatement(sql);
			
			pst.setString(1, gv.getHoten());
			pst.setDate(2, new Date(gv.getNgaysinh().getTime()));
			pst.setInt(3, gv.getMacn());
			pst.setString(4, gv.getEmail());
			pst.setString(6, gv.getSdt());
			pst.setString(5, gv.getDiaChi());
			pst.setInt(7, gv.getMagvhd());
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
	public boolean deleteData(int maGV){
		boolean rs =false;
				conn = c.getConnectSqlServer();
				String sql ="delete from giaovien where magvhd=?";
				try {
					pst=conn.prepareStatement(sql);					
					pst.setInt(1, maGV);
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
	public boolean insertData(GIAOVIEN gv){
		boolean r =false	;
			conn = c.getConnectSqlServer();
			String sql="insert into giaovien values(?,?,?,?,?,?,?) ";
			try {
				pst=conn.prepareStatement(sql);
				pst.setInt(1, gv.getMagvhd());
				pst.setString(2, gv.getHoten());
				pst.setDate(3, new Date(gv.getNgaysinh().getTime()));
				pst.setInt(4, gv.getMacn());
				pst.setString(5, gv.getEmail());
				pst.setString(7, gv.getSdt());
				pst.setString(6, gv.getDiaChi());
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
	public String getNameByID(int id){
		String s="";
		conn=c.getConnectSqlServer();
		try {
			stmt=conn.createStatement();
			String sql ="select hoten from giaovien where magvhd='"+id+"'";
			rs=stmt.executeQuery(sql);
			if(rs.next()){
				s=rs.getString("HoTen");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return s;
	}
	
	public GIAOVIEN getItemByID(int id) {
		// TODO Auto-generated method stub
		conn = c.getConnectSqlServer();
		GIAOVIEN objGV =null;
		try {
			String sql ="select * from giaovien where magvhd = ?";
			pst =conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs=pst.executeQuery();
			if(rs.next()){
				int magvhd=rs.getInt("MaGVHD");
				String hoten=rs.getString("HoTen");
				java.util.Date ngaysinh=rs.getDate("NgaySinh");
				int macn=rs.getInt("MaCN");
				String email=rs.getString("Email");
				String diachi=rs.getString("DiaChi");
				String sdt=rs.getString("SDT");
				objGV = new GIAOVIEN(magvhd, hoten, ngaysinh, macn, email,diachi, sdt);
				
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
		return objGV;
	}

}
