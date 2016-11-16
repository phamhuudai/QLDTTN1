package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.DatTGBO;
import model.bo.DeTaiBO;

/**
 * Servlet implementation class ControllerXoaThoiGian
 */
public class ControllerXoaThoiGian extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerXoaThoiGian() {
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
		int maDot =Integer.parseInt(request.getParameter("id"));
		DatTGBO tgBO = new DatTGBO();
		if(tgBO.deleteData(maDot)){
			response.sendRedirect(request.getContextPath()+"/CacDotDK?msg=del");
		
		}
		else{
			response.sendRedirect(request.getContextPath()+"/CacDotDK?msg=error");
		}
	}

}
