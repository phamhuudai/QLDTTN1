package model.bo;

import java.util.ArrayList;

import model.bean.DETAISINHVIEN;
import model.dao.DeTaiSinhVienDAO;

public class DeTaiSinhVienBO {
	DeTaiSinhVienDAO deTaiSinhVienDAO = new DeTaiSinhVienDAO();
	public ArrayList<DETAISINHVIEN> getDeTaiSinhVien(){
		return deTaiSinhVienDAO.getListDeTaiSinhVien();
	}
	
	public DETAISINHVIEN getItemDeTaiSinhVien(int id){
		return deTaiSinhVienDAO.getItemDeTaiSinhVien(id);
	}
}
