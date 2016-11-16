package model.bo;

import model.bean.NGUOIDUNG;
import model.dao.AdminDAO;

public class AdminBO {
		AdminDAO adDAO;
		public AdminBO() {
			adDAO = new AdminDAO();
			// TODO Auto-generated constructor stub
		}
		public boolean changeInfor(NGUOIDUNG admin){
			return adDAO.changeInfor(admin);
		}
}
