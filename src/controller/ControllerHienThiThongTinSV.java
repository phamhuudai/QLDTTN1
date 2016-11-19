package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.SINHVIEN;

/**
 * Servlet implementation class ControllerHienThiThongTinSV
 */
public class ControllerHienThiThongTinSV extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerHienThiThongTinSV() {
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
		HttpSession session = request.getSession();
		SINHVIEN ObjSV = (SINHVIEN)session.getAttribute("ObjSV");
		request.setAttribute("ObjSV", ObjSV);
		System.out.println("Tên Sinh Viên: "+ObjSV.getHoTen());
		request.getRequestDispatcher("SV_CapNhatCaNhan.jsp").forward(request, response);
	}

}
