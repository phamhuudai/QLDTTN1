package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.LibraryPer;
import model.bean.DETAI;
import model.bean.GIAOVIEN;
import model.bean.NGUOIDUNG;
import model.bo.ChuyenNhanhBO;
import model.bo.DeTaiBO;
import model.bo.GiaoVienBO;
import model.bo.NguoiDungBO;
import model.dao.GiaoVienDAO;
import model.dao.IdProcess;

/**
 * Servlet implementation class ControllerThemGVTT
 */
public class ControllerThemDTTT extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerThemDTTT() {
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
		if(request.getParameter("them")==null){
//			response.sendRedirect(request.getContextPath()+"/Admin_DeTai_ThongThuong.jsp");
			ChuyenNhanhBO cnBO = new ChuyenNhanhBO();
			GiaoVienBO gvBO = new GiaoVienBO();
			request.setAttribute("arCN", cnBO.getList());
			request.setAttribute("arGV", gvBO.getList());
			RequestDispatcher rd = request.getRequestDispatcher("/Admin_DeTai_ThemThongThuong.jsp");
			rd.forward(request, response);
		}else if("Thêm".equals(request.getParameter("them"))){
			String noiDung=request.getParameter("noiDung");
			//String noiDung= new String(nD.getBytes("ISO-8859-1"),"UTF-8");
			String tenDeTai=request.getParameter("tenDeTai");
			//String tenDeTai = new String(ten.getBytes("ISO-8859-1"),"UTF-8");
			int maCN = Integer.parseInt(request.getParameter("maCN"));
			int maGVHD = Integer.parseInt(request.getParameter("maGVHD"));
			IdProcess idPr = new IdProcess();
			int maDeTai =idPr.getID("MDT", "detai");
			DETAI objDeTai = new DETAI(maDeTai, tenDeTai, maCN, noiDung, maGVHD);
			DeTaiBO dtBO = new DeTaiBO();
			if(dtBO.insertData(objDeTai)){
				response.sendRedirect(request.getContextPath()+"/danhsachdetai?msg=add");
			}else{
				response.sendRedirect(request.getContextPath()+"/danhsachdetai?msg=error");
			}
		}
		
		
	}

}
