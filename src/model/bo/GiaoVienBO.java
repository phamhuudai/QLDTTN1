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
	public boolean updateData(GIAOVIEN objGV){
		return gvDao.updateGV(objGV);
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
