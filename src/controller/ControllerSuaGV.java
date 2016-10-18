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

import model.bean.CHUYENNGANH;
import model.bean.GIAOVIEN;
import model.bo.ChuyenNhanhBO;
import model.bo.GiaoVienBO;
import model.dao.GiaoVienDAO;

/**
 * Servlet implementation class ControllerSuaGV
 */
public class ControllerSuaGV extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerSuaGV() {
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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		GiaoVienBO gvBo = new GiaoVienBO();
		if(request.getParameter("id") == null){			
			response.sendRedirect(request.getContextPath()+"/danhsachgv");
		}else{
			if("Sửa".equals(request.getParameter("sua"))){
				int magvhd=Integer.parseInt(request.getParameter("id"));
				String hoten=request.getParameter("tenGv");
				String Str_ngaysinh=request.getParameter("ngaysinh");
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				Date ngaysinh = new Date();
				try {
					ngaysinh = (Date)format.parse(Str_ngaysinh);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				int macn=Integer.parseInt(request.getParameter("cn"));
				String email=request.getParameter("email");
				String sdt=request.getParameter("sdt");
				String diachi=request.getParameter("dc");
				GIAOVIEN objGV = new GIAOVIEN(magvhd, hoten, ngaysinh, macn, email,diachi,sdt,"");
				if(gvBo.updateData(objGV)){
					response.sendRedirect(request.getContextPath()+"/danhsachgv?msg=edit");
				}else{
					response.sendRedirect(request.getContextPath()+"/danhsachgv?msg=error");
				}
			}else{				
				int id = Integer.parseInt(request.getParameter("id"));				
				GIAOVIEN objGV = gvBo.getItemByID(id);				
				request.setAttribute("objGV", objGV);
				ChuyenNhanhBO cnBO = new ChuyenNhanhBO();
				request.setAttribute("arCN", cnBO.getList());
				
				RequestDispatcher rd = request.getRequestDispatcher("/Admin_GV_Sua.jsp");
				rd.forward(request, response);
			}
			
		}
		
		
		 
	}

}
