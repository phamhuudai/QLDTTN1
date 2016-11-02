package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.DETAI;
import model.bean.GIAOVIEN;
import model.bo.DeTaiBO;
import model.bo.GiaoVienBO;
import common.LibraryConst;
import common.LibraryPer;

/**
 * Servlet implementation class ControllerTimKiemDeTai
 */
public class ControllerTimKiemDeTai extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerTimKiemDeTai() {
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
		/*if(! LibraryPer.isAdmin(request, response)){
			return;
		}*/
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		if("search".equals(request.getParameter("search"))){
			String name=request.getParameter("name");
			//String name = new String(str_name.getBytes("ISO-8859-1"),"UTF-8");
			
			/*StringProcess strPr = new StringProcess();
			name=strPr.unAccent(name);*/
			DeTaiBO dtBO = new DeTaiBO();
			int currentPage=1;
			if(request.getParameter("page")!=null){
				currentPage=Integer.parseInt(request.getParameter("page"));
			}	
			ArrayList<DETAI> arDeTai=null;
			LibraryConst lib = new LibraryConst();
			int recordsPerPage=lib.ROW_COUNT;
			 if(currentPage==1){
	        	 arDeTai = dtBO.searchByPage(name,1, recordsPerPage);
	        	 System.out.println(currentPage);
	        	 System.out.println(name);
	        }else{
	        	 arDeTai = dtBO.searchByPage(name,currentPage, recordsPerPage); 
	        }
			int numOfRecords = dtBO.getRow();
		    int numOfPages = (int) Math.ceil(numOfRecords * 1.0 / recordsPerPage);
		    request.setAttribute("numOfRecord", numOfRecords);
		    request.setAttribute("name", name);
		    request.setAttribute("numOfPage", numOfPages);
		    request.setAttribute("currentPage", currentPage);
			request.setAttribute("arDeTai", arDeTai);
			RequestDispatcher rd = request.getRequestDispatcher("/Admin_TimKiemDeTai.jsp");
			rd.forward(request, response);
		}else{
			response.sendRedirect(request.getContextPath()+"/danhsachdetai");
		}
	}

}
