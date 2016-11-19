package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.LibraryPer;
import model.bean.CHUYENNGANH;
import model.bean.DETAI;
import model.bean.GIAOVIEN;
import model.bo.ChuyenNhanhBO;
import model.bo.DeTaiBO;
import model.bo.GiaoVienBO;
import model.dao.GiaoVienDAO;

/**
 * Servlet implementation class ControllerSuaGV
 */
public class ControllerSuaDT extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerSuaDT() {
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
		
		if(request.getParameter("madt") == null){	
			System.out.println(request.getParameter("madt"));
			response.sendRedirect(request.getContextPath()+"/danhsachdetai");
		}else{
			if("edit".equals(request.getParameter("edit"))){

				DeTaiBO dtBo = new DeTaiBO();
				int maDeTai=Integer.parseInt(request.getParameter("madt"));
				int maGVHD=Integer.parseInt(request.getParameter("maGVHD"));
				int maCN =Integer.parseInt(request.getParameter("maCN"));
				String nD=request.getParameter("noiDung");
				String noiDung= new String(nD.getBytes("ISO-8859-1"),"UTF-8");
				String ten=request.getParameter("tenDeTai");
				String tenDeTai = new String(ten.getBytes("ISO-8859-1"),"UTF-8");
				DETAI objDeTai = new DETAI(maDeTai, tenDeTai, maCN,noiDung, maGVHD);
				if(dtBo.updateData(objDeTai)){
					response.sendRedirect(request.getContextPath()+"/danhsachdetai?msg=edit");
				}else{
					response.sendRedirect(request.getContextPath()+"/danhsachdetai?msg=error");
				}
			}else{	
				System.out.println(request.getParameter("sua"));
				int maDeTai= Integer.parseInt(request.getParameter("madt"));				
				DeTaiBO dtBo = new DeTaiBO();				
				request.setAttribute("objDeTai", dtBo.getItemByID(maDeTai));
				ChuyenNhanhBO cnBO = new ChuyenNhanhBO();
				request.setAttribute("arCN", cnBO.getList());
				GiaoVienBO gvBO = new GiaoVienBO();
				request.setAttribute("arGV", gvBO.getList());				
				RequestDispatcher rd = request.getRequestDispatcher("/Admin_DeTai_SuaDeTai.jsp");
				rd.forward(request, response);
			}
			
		}
		
		
		 
	}

}
