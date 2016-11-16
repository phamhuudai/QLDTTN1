package model.bo;

import java.util.ArrayList;

import model.bean.TIENDO;
import model.dao.TienDoDAO;

public class TienDoBO {
	TienDoDAO tdDAO ;
	public TienDoBO() {
		// TODO Auto-generated constructor stub
		tdDAO = new TienDoDAO();
	}
	public ArrayList<TIENDO> getList(int page, int numOfRecords){
		return tdDAO.getListByPage(page, numOfRecords);
	}
	public int getRow(){
		return  tdDAO.getRow();
	}

}
