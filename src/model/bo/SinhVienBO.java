package model.bo;

import model.bean.SINHVIEN;
import model.dao.SinhVienDAO;

public class SinhVienBO {
	SinhVienDAO svDAO = new SinhVienDAO();
	
	public SINHVIEN getObjSV(int id_nguoidung){
		return svDAO.getObjSV(id_nguoidung);
	}

	public int updateSV(SINHVIEN objSV) {
		return svDAO.updateSV(objSV);
	}
}