package model.bo;

import model.dao.ThongBaoDAO;

public class ThongBaoBO {
	private ThongBaoDAO tbDAO;
	public ThongBaoBO() {
		// TODO Auto-generated constructor stub
		tbDAO = new ThongBaoDAO();
	}
	public boolean delData(int maGV){
		return tbDAO.delData(maGV);
	}

}
