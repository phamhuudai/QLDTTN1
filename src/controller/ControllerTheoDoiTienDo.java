package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.GIAOVIEN;
import model.bean.TIENDO;
import model.bo.GiaoVienBO;
import model.bo.TienDoBO;
import common.LibraryConst;
import common.LibraryPer;

/**
 * Servlet implementation class ControllerTheoDoiTienDo
 */
public class ControllerTheoDoiTienDo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerTheoDoiTienDo() {
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
		if(! LibraryPer.isAdmin(request, response)){
			return;
		}
		TienDoBO tdBO = new TienDoBO();
		int currentPage=1;
		if(request.getParameter("page")!=null){
			currentPage=Integer.parseInt(request.getParameter("page"));
		}
		ArrayList<TIENDO> arTD=null;
		LibraryConst lib = new LibraryConst();
		int recordsPerPage=lib.ROW_COUNT;
		 if(currentPage==1){
        	 arTD = tdBO.getList(1, recordsPerPage);
        }else{
        	 arTD = tdBO.getList(currentPage, recordsPerPage); 
        }
		int numOfRecords = tdBO.getRow();
	    int numOfPages = (int) Math.ceil(numOfRecords * 1.0 / recordsPerPage);
	    request.setAttribute("numOfPage", numOfPages);
	    request.setAttribute("currentPage", currentPage);
		request.setAttribute("arTD", arTD);
		RequestDispatcher rd = request.getRequestDispatcher("/Admin_DeTai_TheoDoiTienDo.jsp");
		rd.forward(request, response);
	}

}
