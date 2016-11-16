package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.TIENDO;

public class TienDoDAO {
	ConnectionDB c;
	Connection conn;
	ResultSet rs;
	PreparedStatement pst;
	int row;
	Statement stm;
	public TienDoDAO() {
		// TODO Auto-generated constructor stub
		c= new ConnectionDB();
	}
	public ArrayList<TIENDO> getListByPage(int page,  int numOfRecords){
		int offset=(page-1)*numOfRecords+1;
		ArrayList<TIENDO> arTD = new ArrayList<TIENDO>();
		conn=c.getConnectSqlServer();
		String sql="SELECT detai.MDT, detai.TenDeTai, chuyennganh.TenCN, giaovien.HoTen, danhgiatiendo.TienDo from"
					+" (select *,  ROW_NUMBER() OVER (order by dangkidetai.MDK DESC) as RN from dangkidetai)"
					+" dangkidetai INNER JOIN danhgiatiendo  on danhgiatiendo.MDK = dangkidetai.MDK"
					+" INNER JOIN detai on detai.MDT = dangkidetai.MDT "
					+" INNER JOIN chuyennganh on chuyennganh.MaCN = detai.MaCN"
					+" INNER JOIN giaovien on giaovien.MaGVHD = detai.MaGVHD"
					+" WHERE RN BETWEEN "+offset+" AND "+(numOfRecords+offset-1);	
		try {

			stm = conn.createStatement();
			rs=stm.executeQuery(sql);
			while(rs.next()){
				int maDeTai = rs.getInt("MDT");
				String tenDeTai = rs.getString("TenDetai");
				String tenCN = rs.getString("TenCN");
				String gvhd = rs.getString("HoTen");
				float tienDo = rs.getFloat("TienDo");
				TIENDO td = new TIENDO(maDeTai, tenDeTai, tenCN, gvhd, tienDo);
				arTD.add(td);				
			}
			rs=stm.executeQuery("Select count(*) from danhgiatiendo");
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
		
		return arTD;
		
	}
	public int getRow(){
		return this.row;
	}

}
