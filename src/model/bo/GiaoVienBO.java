package model.bo;

import java.util.ArrayList;

import model.bean.GIAOVIEN;
import model.dao.GiaoVienDAO;

public class GiaoVienBO {
	private GiaoVienDAO gvDao;
	public GiaoVienBO() {
		gvDao = new GiaoVienDAO();
	}
	public ArrayList<GIAOVIEN> getList(){
		return gvDao.getList();
	}
	public int getRow(){
		return gvDao.getRow();
	}
	public ArrayList<GIAOVIEN> getListByPage(int page, int numOfRecords){
		return gvDao.getListByPage(page, numOfRecords);
	}
	public ArrayList<GIAOVIEN> searchByPage(String name, int page, int numOfRecords){
		return gvDao.searchByPage(name, page, numOfRecords);
	}
	public boolean updateData(GIAOVIEN objGV){
		return gvDao.updateGV(objGV);
	}
	public ArrayList<GIAOVIEN> search(String name){
		return gvDao.searchData(name);
	}
	public GIAOVIEN getItemByID(int id){
		return gvDao.getItemByID(id);
	}
	public String getNameByID(int id){
		return gvDao.getNameByID(id);
	}
	public boolean insertData(GIAOVIEN objGV){
		return gvDao.insertData(objGV);
	}
	public boolean deleteGV(int id) {
		// TODO Auto-generated method stub
		return gvDao.deleteData(id);
		
	}
	public boolean isExist(int maGvhd){
		return gvDao.isExist(maGvhd);
	}
	
	
	
}
