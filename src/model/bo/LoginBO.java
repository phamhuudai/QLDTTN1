package model.bo;

import model.bean.NGUOIDUNG;
import model.dao.LoginDAO;

public class LoginBO {
	LoginDAO lgDAO;
	public LoginBO() {
		// TODO Auto-generated constructor stub
		lgDAO = new LoginDAO();
	}
	public NGUOIDUNG checkLogin(int ma, String pass){
		return lgDAO.checkLogin(ma, pass);
	}

}
