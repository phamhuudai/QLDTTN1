package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.LibraryConst;

import model.bean.GIAOVIEN;
import model.bo.GiaoVienBO;
import model.dao.ChuyenNganhDAO;
import model.dao.GiaoVienDAO;

/**
 * Servlet implementation class ControllerGVHD
 */
public class ControllerDSGV extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerDSGV() {
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
		GiaoVienBO gvBO = new GiaoVienBO();
		int currentPage=1;
		if(request.getParameter("page")!=null){
			currentPage=Integer.parseInt(request.getParameter("page"));
		}
		ArrayList<GIAOVIEN> arGV=null;
		LibraryConst lib = new LibraryConst();
		int recordsPerPage=lib.ROW_COUNT;
		 if(currentPage==1){
        	 arGV = gvBO.getListByPage(1, recordsPerPage);
        }else{
        	 arGV = gvBO.getListByPage(currentPage, recordsPerPage); 
        }
		int numOfRecords = gvBO.getRow();
	    int numOfPages = (int) Math.ceil(numOfRecords * 1.0 / recordsPerPage);
	    request.setAttribute("numOfPage", numOfPages);
	    request.setAttribute("currentPage", currentPage);
		request.setAttribute("arGV", arGV);
		RequestDispatcher rd = request.getRequestDispatcher("/Admin_GV.jsp");
		rd.forward(request, response);
		/////////test
	}

}
