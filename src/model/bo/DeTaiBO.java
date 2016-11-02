package model.bo;

import java.util.ArrayList;

import model.bean.DETAI;
import model.bean.GIAOVIEN;
import model.dao.DeTaiDAO;
import model.dao.GiaoVienDAO;

public class DeTaiBO {
	private DeTaiDAO dtDao;
	public DeTaiBO() {
		dtDao = new DeTaiDAO();
	}
	public ArrayList<DETAI> getListByPage(int page, int numOfRecords){
		return dtDao.getListByPage(page, numOfRecords);
	}
	public ArrayList<DETAI> getList(){
		return dtDao.getList();
	}
	public ArrayList<DETAI> searchByPage(String name, int page, int numOfRecords){
		return dtDao.searchByPage(name,page, numOfRecords);
	}
	public int getRow(){
		return dtDao.getRow();
	}
	public boolean insertData(DETAI objDeTai){
		return dtDao.insertData(objDeTai);
	}
	public boolean delData(int maDeTai){
		return dtDao.deleteData(maDeTai);
	}
	public boolean updateData(DETAI objDeTai){
		return dtDao.updateData(objDeTai);
	}
	public boolean isExist(int maDeTai){
		return dtDao.isExist(maDeTai);
	}
	public DETAI getItemByID(int maDeTai){
		return dtDao.getItemByID(maDeTai);
	}
	
	
	
}
