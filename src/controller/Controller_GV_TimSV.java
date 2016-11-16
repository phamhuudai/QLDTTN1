package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.GIAOVIEN;
import model.bo.DanhSachQuanLyBO;

/**
 * Servlet implementation class Controller_GV_TimSV
 */
public class Controller_GV_TimSV extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller_GV_TimSV() {
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
		String ten=request.getParameter("ten");
		HttpSession session = request.getSession();
		GIAOVIEN objGV = (GIAOVIEN)session.getAttribute("sObjND");
		DanhSachQuanLyBO ds = new DanhSachQuanLyBO();
		int maGV = 200004;//objGV.getMagvhd();		
		request.setAttribute("arSV", ds.TimSinhVien(maGV, ten));
		RequestDispatcher rd = request.getRequestDispatcher("GVHD_TimSV.jsp");
		rd.forward(request, response);
	}

}
