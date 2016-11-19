package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.LibraryPer;
import model.bean.DETAISINHVIEN;
import model.bean.SINHVIEN;
import model.bo.DeTaiSinhVienBO;

/**
 * Servlet implementation class ControllerSinhVienDangKyDeTai
 */
public class ControllerXemDeTai extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerXemDeTai() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest requests, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		if(!LibraryPer.isStudent(request, response)){
			return;
		}
		
		HttpSession session = request.getSession();
		SINHVIEN ObjSV = (SINHVIEN)session.getAttribute("ObjSV");
		
		request.setAttribute("ObjSV", ObjSV);
		DeTaiSinhVienBO deTaiSinhVienBO = new DeTaiSinhVienBO();
		ArrayList<DETAISINHVIEN> alDeTaiSinhViens = deTaiSinhVienBO.getDeTaiSinhVien();
		
		request.setAttribute("alDeTaiSinhViens", alDeTaiSinhViens);
		request.getRequestDispatcher("SV_TrangChu.jsp").forward(request, response);
		System.out.println("vo roi");
	}
	
	

}
