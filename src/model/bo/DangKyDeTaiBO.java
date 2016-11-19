package model.bo;

import model.bean.SINHVIENDANGKYDETAI;
import model.dao.DangKyDeTaiDAO;

public class DangKyDeTaiBO {
	DangKyDeTaiDAO dkDeTai = new DangKyDeTaiDAO();
	
	public int addDeTaiDangKy_1(SINHVIENDANGKYDETAI ObjdkDeTai){
		return dkDeTai.addDeTaiDangKy_1(ObjdkDeTai);
	}
	
	public SINHVIENDANGKYDETAI getObjDeTaiSV(int mssv1){
		return dkDeTai.getObjDeTaiSV(mssv1);
	}
}
