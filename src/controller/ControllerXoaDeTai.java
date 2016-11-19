package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.LibraryPer;

import model.bo.DeTaiBO;
import model.bo.GiaoVienBO;
import model.bo.NguoiDungBO;
import model.bo.ThongBaoBO;

/**
 * Servlet implementation class ControllerXoaDeTai
 */
public class ControllerXoaDeTai extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerXoaDeTai() {
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
		int maDeTai =Integer.parseInt(request.getParameter("maDeTai"));
		System.out.println(maDeTai);
		DeTaiBO dtBO = new DeTaiBO();
		if(dtBO.delData(maDeTai)){
			response.sendRedirect(request.getContextPath()+"/danhsachdetai?msg=del");
		
		}
		else{
			response.sendRedirect(request.getContextPath()+"/danhsachdetai?msg=error");
		}
	}

}
