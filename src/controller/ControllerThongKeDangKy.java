package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.DANGKYDETAI;
import model.bo.DangKyBO;

import common.LibraryConst;

/**
 * Servlet implementation class ControllerThongKeDangKy
 */
public class ControllerThongKeDangKy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerThongKeDangKy() {
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
		DangKyBO dkBO = new DangKyBO();
		int currentPage=1;
		if(request.getParameter("page")!=null){
			currentPage=Integer.parseInt(request.getParameter("page"));
		}
		ArrayList<DANGKYDETAI> arDK=null;
		LibraryConst lib = new LibraryConst();
		int recordsPerPage=lib.ROW_COUNT;
		 if(currentPage==1){
        	 arDK = dkBO.getList(1, recordsPerPage);
        }else{
        	 arDK = dkBO.getList(currentPage, recordsPerPage); 
        }
		int numOfRecords = dkBO.getRow();
	    int numOfPages = (int) Math.ceil(numOfRecords * 1.0 / recordsPerPage);
	    request.setAttribute("numOfPage", numOfPages);
	    request.setAttribute("currentPage", currentPage);
		request.setAttribute("arDK", arDK);
		RequestDispatcher rd = request.getRequestDispatcher("/Admin_DangKy_ThongKeDangKy.jsp");
		rd.forward(request, response);
	}

}
