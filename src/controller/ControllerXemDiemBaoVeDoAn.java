package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.DIEMBAOVE;
import model.bean.SINHVIEN;
import model.bean.SINHVIENDANGKYDETAI;
import model.bo.SinhVienDangKyDeTaiBO;

/**
 * Servlet implementation class ControllerXemDiemBaoVeDoAn
 */
public class ControllerXemDiemBaoVeDoAn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerXemDiemBaoVeDoAn() {
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
		SinhVienDangKyDeTaiBO svdkdtBO = new SinhVienDangKyDeTaiBO();
		
		HttpSession session = request.getSession();
		SINHVIEN ObjSV = (SINHVIEN)session.getAttribute("ObjSV");
		int mssv1 = ObjSV.getMssv();
		//System.out.println("mssv1: "+mssv1);		
		SINHVIENDANGKYDETAI objDeTaiSV = svdkdtBO.getObjDeTaiSV(mssv1);
		//DIEMBAOVE objDiemBV = 
		System.out.println("Tên đề tài: "+objDeTaiSV.getMDK());
		request.getRequestDispatcher("SV_XemDiemBV.jsp").forward(request, response);
	}

}
