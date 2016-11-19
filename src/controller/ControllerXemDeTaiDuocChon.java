package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.DETAISINHVIEN;
import model.bean.SINHVIEN;
import model.bo.DeTaiSinhVienBO;

/**
 * Servlet implementation class ControllerXemThongTinDeTai
 */
public class ControllerXemDeTaiDuocChon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerXemDeTaiDuocChon() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		DETAISINHVIEN deTaiSinhVien = null;
		System.out.println("1");
		HttpSession session = request.getSession();
		SINHVIEN ObjSV = (SINHVIEN)session.getAttribute("ObjSV");
		int id = 0;
		if (request.getParameter("cid") != null) {
			System.out.println("2");
			request.setAttribute("ObjSV", ObjSV);
			id = Integer.parseInt(request.getParameter("cid"));
			DeTaiSinhVienBO deTaiSinhVienBO = new DeTaiSinhVienBO();
			deTaiSinhVien = deTaiSinhVienBO.getItemDeTaiSinhVien(id);
			System.out.println("Vào rồi");
			System.out.println(deTaiSinhVien.getMaDeTai()
					+ deTaiSinhVien.getGiaoVienHuongDan());
			request.setAttribute("deTaiSinhVien", deTaiSinhVien);
			request.getRequestDispatcher("SV_DangKiDeTai.jsp").forward(request, response);
		}
	}

}
	