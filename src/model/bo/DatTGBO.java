package model.bo;

import java.util.ArrayList;

import model.bean.DATTG;
import model.dao.DatTGDAO;

public class DatTGBO {
	DatTGDAO tgDAO;
	public DatTGBO() {
		tgDAO = new DatTGDAO();
		// TODO Auto-generated constructor stub
	}
	public ArrayList<DATTG> getList(){
		return tgDAO.getList();
	}
	public boolean insertData(DATTG tg){
		return tgDAO.insertData(tg);
		
	}
	public boolean deleteData(int maDot){
		return tgDAO.deleteData(maDot);
	}

}
