package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.LibraryPer;

import model.bean.DETAISINHVIEN;
import model.bean.SINHVIEN;
import model.bean.SINHVIENDANGKYDETAI;
import model.bo.DangKyDeTaiBO;
import model.bo.DeTaiSinhVienBO;
import model.bo.SinhVienDangKyDeTaiBO;
import model.dao.IdProcess;

/**
 * Servlet implementation class ControllerDangKyDeTai
 */
public class ControllerDangKyDeTai extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerDangKyDeTai() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		if(!LibraryPer.isStudent(request, response)){
			return;
		}
		
		SinhVienDangKyDeTaiBO dangKyDeTaiBO = new SinhVienDangKyDeTaiBO();
		DETAISINHVIEN deTaiSinhVien = null;
		System.out.println("1");
		HttpSession session = request.getSession();
		SINHVIEN ObjSV = (SINHVIEN)session.getAttribute("ObjSV");
		request.setAttribute("ObjSV", ObjSV);
		if (request.getParameter("dangky") != null) {
			DangKyDeTaiBO dkDeTaiBO = new DangKyDeTaiBO();
			int id = Integer.parseInt(request.getParameter("cid"));
			System.out.println("id"+id);
			DeTaiSinhVienBO deTaiSinhVienBO = new DeTaiSinhVienBO();
			deTaiSinhVien = deTaiSinhVienBO.getItemDeTaiSinhVien(id);
			
			int madetai=deTaiSinhVien.getMaDeTai();
			String hThuc = request.getParameter("hinhThuc");
			boolean hinhThuc=false;
			if("caNhan".equals(hThuc)){
				hinhThuc = false;
			}else{
				hinhThuc = true;
			}
			
			System.out.println("Hinh thuc lay ve"+hinhThuc);
			int mssv1 = ObjSV.getMssv();
			if(hinhThuc==true){
				System.out.println("Vô chưa??????????????");
				int mssv2 = Integer.parseInt(request.getParameter("mssv2"));
				Date ngayDK = new Date();
				System.out.println("Mã số sinh viên 2:"+mssv2);
				SimpleDateFormat dinhDangThoiGian = new SimpleDateFormat("dd/MM/yyyy ");
				String hienThiThoiGian = dinhDangThoiGian.format(ngayDK.getTime());
				System.out.println("Ngay Dang Ky: "+hienThiThoiGian);
				IdProcess idPr = new IdProcess();
				int MDK =idPr.getID("MDK", "dangkidetai");
				SINHVIENDANGKYDETAI objDangkydetai= new SINHVIENDANGKYDETAI(MDK, madetai, hinhThuc, mssv1,mssv2, ngayDK);
				int result = dangKyDeTaiBO.addDeTai2(objDangkydetai);
			}else{
				Date ngayDK = new Date();
				SimpleDateFormat dinhDangThoiGian = new SimpleDateFormat("dd/MM/yyyy ");
				String hienThiThoiGian = dinhDangThoiGian.format(ngayDK.getTime());
				System.out.println("Ngay Dang Ky: "+hienThiThoiGian);
				IdProcess idPr = new IdProcess();
				int MDK =idPr.getID("MDK", "dangkidetai");
				System.out.println("lalalalalalla");
				SINHVIENDANGKYDETAI objDangkydetai= new SINHVIENDANGKYDETAI(MDK, madetai, hinhThuc, mssv1, ngayDK);
				int result = dangKyDeTaiBO.addDeTai1(objDangkydetai);
			}
			System.out.println("ancsds"+madetai);
			/*int mssv1 = ObjSV.getMssv();
			String hinhThuc = request.getParameter("hinhThuc");
			if("nhom".equals(hinhThuc)){
				int mssv2 = Integer.parseInt(request.getParameter("mssv2"));
				System.out.println("mã số sv 2: "+mssv2);
			}
			//dkDeTaiBO.addDeTaiDangKy_1()
			
			System.out.println("hình thức đăng ký :"+hinhThuc);
			System.out.println("Mã đề tài"+madetai);
			System.out.println("MSSV1: "+mssv1);*/
		}else{
			request.getRequestDispatcher("SV_DangKiDeTai.jsp").forward(request, response);
		}
	}
}
