package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.LibraryPer;
import model.bean.NGUOIDUNG;
import model.bo.LoginBO;

/**
 * Servlet implementation class ControllerLogin
 */
public class ControllerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerLogin() {
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
		if(request.getParameter("submit")!=null){
			int ma= Integer.parseInt(request.getParameter("userName"));
			String pass= request.getParameter("pass");
			LoginBO lgBO = new LoginBO();
			NGUOIDUNG objND =lgBO.checkLogin(ma, pass);
			if(objND==null){
				request.setAttribute("error", "error");
				RequestDispatcher rd = request.getRequestDispatcher("/HomePage.jsp");
				rd.forward(request, response);
			}else{
				HttpSession session = request.getSession();
				session.setAttribute("sObjND", objND);
				if("ADMIN".equals(objND.getPhanQuyen())){
					System.out.println("ADMIN");
					//navigate to...
				}else if("GV".equals(objND.getPhanQuyen())){
					System.out.println("GV");
					//navigate to...
				}else if("SV".equals(objND.getPhanQuyen())){
					System.out.println("SV");
					//navigate to...
				}
			}
			
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("HomePage.jsp");
			rd.forward(request, response);
		}
	}

}
