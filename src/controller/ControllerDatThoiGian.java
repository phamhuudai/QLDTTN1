package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.DATTG;
import model.bo.DatTGBO;
import model.dao.IdProcess;

/**
 * Servlet implementation class ControllerDatThoiGian
 */
public class ControllerDatThoiGian extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerDatThoiGian() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("tao") == null){
			response.sendRedirect(request.getContextPath()+"/Admin_DangKy_CaiDatTG.jsp");
		}else{
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			DatTGBO tgBO = new DatTGBO();
			try {
				IdProcess idPr = new IdProcess();
				int id =idPr.getID("MaDot", "dattg");
				Date tgBatDau = (Date) sdf.parse(request.getParameter("tgBatDau"));
				Date tgKetThuc =(Date)  sdf.parse(request.getParameter("tgKetThuc"));
				int tgThucHien = Integer.parseInt(request.getParameter("tgThucHien"));
				DATTG tg = new DATTG(id, tgBatDau, tgKetThuc, tgThucHien);
				if(tgBO.insertData(tg)){
					response.sendRedirect(request.getContextPath()+"/CacDotDK?msg=add");
				}else{
					response.sendRedirect(request.getContextPath()+"/CacDotDK?msg=err");
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
