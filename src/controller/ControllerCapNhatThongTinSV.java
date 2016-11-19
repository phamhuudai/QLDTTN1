package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.SINHVIEN;
import model.bo.SinhVienBO;

/**
 * Servlet implementation class ControllerCapNhatThongTinSV
 */
public class ControllerCapNhatThongTinSV extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerCapNhatThongTinSV() {
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
		//HttpSession session = request.getSession();
		//SINHVIEN ObjSV = (SINHVIEN)session.getAttribute("ObjSV");
		SinhVienBO svBO = new SinhVienBO();
		if(request.getParameter("capnhat")!=null){
			String email = request.getParameter("email");
			String sdt = request.getParameter("sdt");
			String diachi = request.getParameter("diachi");
			int mssv = Integer.parseInt(request.getParameter("cid"));
			System.out.println("lấy về MSSV:"+mssv);
			System.out.println(" email "+email);
			System.out.println("sdt"+sdt);
			System.out.println("diachi"+diachi);
			SINHVIEN ObjSV = new SINHVIEN(mssv,diachi, email, sdt);
			int result = svBO.updateSV(ObjSV);
		}
	}

}
