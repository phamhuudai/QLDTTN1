package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.FileItem;

/**
 * Servlet implementation class ControllerThemGVFile
 */
public class ControllerThemGVFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerThemGVFile() {
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
		if("load".equals(request.getParameter("type"))){
			RequestDispatcher rd =request.getRequestDispatcher("ADmin_GV_ThemTuFile.jsp");
			rd.forward(request, response);
		}else{
			String nameFile="";
			DiskFileItemFactory fif = new DiskFileItemFactory();
			ServletFileUpload sfu = new ServletFileUpload(fif);
			try {
				List<org.apache.commons.fileupload.FileItem> listItem = sfu.parseRequest(request);
				for(org.apache.commons.fileupload.FileItem file : listItem){
					if(! file.isFormField()){
						nameFile = file.getName();
						System.out.println(nameFile);
					}
				}
				
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
