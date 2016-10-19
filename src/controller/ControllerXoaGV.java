package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.GiaoVienBO;
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
		int id =Integer.parseInt(request.getParameter("id"));
		GiaoVienBO gvBO = new GiaoVienBO();
		if(gvBO.deleteGV(id)){
			response.sendRedirect(request.getContextPath()+"/danhsachgv?msg=del");
		}
		else{
			response.sendRedirect(request.getContextPath()+"/danhsachgv?msg=error");
		}
	}

}
