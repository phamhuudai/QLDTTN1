package model.bo;

import model.bean.NGUOIDUNG;
import model.dao.NguoiDungDAO;

public class NguoiDungBO {
	NguoiDungDAO ndDAO;
	public NguoiDungBO() {
		// TODO Auto-generated constructor stub
		ndDAO=new NguoiDungDAO();
	}
	public boolean insertData(NGUOIDUNG objNguoidung){
		return ndDAO.insertData(objNguoidung);
	}
	public boolean delData(int id){
		return ndDAO.delData(id);
	}
}
