package model.bo;

import java.util.ArrayList;

import model.bean.DANHSACHQL;
import model.dao.DanhSachQLDAO;

public class DanhSachQuanLyBO {
	DanhSachQLDAO dsDAO;
	public DanhSachQuanLyBO() {
		// TODO Auto-generated constructor stub
		dsDAO=new DanhSachQLDAO();
	}
	public ArrayList<DANHSACHQL> getList(int maGV){
		return dsDAO.getList(maGV);
	}
	public ArrayList<DANHSACHQL> getListSinhVien(int maGV){
		return dsDAO.getListSinhVien(maGV);
	}
	public ArrayList<DANHSACHQL> TimSinhVien(int maGV, String ten){
		return dsDAO.TimSinhVien(maGV, ten);
	}

}
