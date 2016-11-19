package model.bo;

import model.bean.SINHVIENDANGKYDETAI;
import model.dao.SinhVienDangKyDeTaiDAO;

public class SinhVienDangKyDeTaiBO {
	SinhVienDangKyDeTaiDAO dangKyDeTaiDAO = new SinhVienDangKyDeTaiDAO();
	
	public int addDeTai1(SINHVIENDANGKYDETAI objDeTai){
		return dangKyDeTaiDAO.addDeTai1(objDeTai);
	}

	public int addDeTai2(SINHVIENDANGKYDETAI objDangkydetai) {
		return dangKyDeTaiDAO.addDeTai2(objDangkydetai);
	}
	
	public SINHVIENDANGKYDETAI getObjDeTaiSV(int mssv1){
		return dangKyDeTaiDAO.getObjDeTaiSV(mssv1);
	}
}
