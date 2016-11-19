package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.LibraryConst;
import common.LibraryPer;
import model.bean.DETAI;
import model.bean.GIAOVIEN;
import model.bo.DeTaiBO;
import model.bo.GiaoVienBO;
import model.dao.ChuyenNganhDAO;
import model.dao.GiaoVienDAO;

/**
 * Servlet implementation class ControllerGVHD
 */
public class ControllerDSDT extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerDSDT() {
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
		DeTaiBO deTaiBO = new DeTaiBO();
		int currentPage=1;
		if(request.getParameter("page")!=null){
			currentPage=Integer.parseInt(request.getParameter("page"));
		}
		ArrayList<DETAI> arDeTai=null;
		LibraryConst lib = new LibraryConst();
		int recordsPerPage=lib.ROW_COUNT;
		 if(currentPage==1){
        	 arDeTai = deTaiBO.getListByPage(1, recordsPerPage);
        }else{
        	 arDeTai = deTaiBO.getListByPage(currentPage, recordsPerPage); 
        }

		int numOfRecords = deTaiBO.getRow();
	    int numOfPages = (int) Math.ceil(numOfRecords * 1.0 / recordsPerPage);
	    request.setAttribute("numOfPage", numOfPages);
	    request.setAttribute("currentPage", currentPage);
		request.setAttribute("arDeTai", arDeTai);
		RequestDispatcher rd = request.getRequestDispatcher("/Admin_DeTai_DsDeTai.jsp");
		rd.forward(request, response);
		/////////test
	}

}
