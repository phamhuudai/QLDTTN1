package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.LibraryPer;

import model.bo.GiaoVienBO;
import model.bo.NguoiDungBO;
import model.bo.ThongBaoBO;
import model.dao.GiaoVienDAO;

/**
 * Servlet implementation class ControllerXoaGV
 */
public class ControllerXoaGV extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerXoaGV() {
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
		int maGV =Integer.parseInt(request.getParameter("id"));
		GiaoVienBO gvBO = new GiaoVienBO();
		ThongBaoBO tbBO = new ThongBaoBO();
		NguoiDungBO ndBO = new NguoiDungBO();
		if(tbBO.delData(maGV)){
			if(gvBO.deleteGV(maGV)){
				if(ndBO.delData(maGV)){
					response.sendRedirect(request.getContextPath()+"/danhsachgv?msg=del");
				}else{
					response.sendRedirect(request.getContextPath()+"/danhsachgv?msg=error");
				}
			}else{
				response.sendRedirect(request.getContextPath()+"/danhsachgv?msg=error");
			}
		}
		else{
			response.sendRedirect(request.getContextPath()+"/danhsachgv?msg=error");
		}
	}

}
