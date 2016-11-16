package model.bo;

import java.util.ArrayList;

import model.bean.DANGKYDETAI;
import model.dao.DangKyDAO;

public class DangKyBO {
	DangKyDAO dkDAO ;
	public DangKyBO() {
		// TODO Auto-generated constructor stub
		dkDAO = new DangKyDAO();
	}
	public ArrayList<DANGKYDETAI> getList(int page, int numOfRecords){
		return dkDAO.getList(page, numOfRecords);
	}
	public int getRow(){
		return  dkDAO.getRow();
	}

}
