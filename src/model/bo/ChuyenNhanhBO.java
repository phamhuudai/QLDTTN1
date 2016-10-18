package model.bo;

import java.util.ArrayList;

import model.bean.CHUYENNGANH;
import model.dao.ChuyenNganhDAO;

public class ChuyenNhanhBO {
	ChuyenNganhDAO cnDAO;
	public ChuyenNhanhBO(){
		cnDAO = new ChuyenNganhDAO();
	}
	public ArrayList<CHUYENNGANH> getList(){
		return cnDAO.getList();
	}
	public String getName(int id){
		return cnDAO.getName(id);
	}
}
