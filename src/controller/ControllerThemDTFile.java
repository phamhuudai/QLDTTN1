package controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.DETAI;
import model.bean.GIAOVIEN;
import model.bean.NGUOIDUNG;
import model.bo.DeTaiBO;
import model.bo.GiaoVienBO;
import model.bo.NguoiDungBO;

import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.apache.tomcat.util.http.fileupload.FileItem;

import sun.font.GlyphLayout.GVData;
import common.LibraryPer;
import common.ReadExcelDeTai;
import common.ReadExcelGV;

/**
 * Servlet implementation class ControllerThemGVFile
 */
public class ControllerThemDTFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerThemDTFile() {
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
		if("load".equals(request.getParameter("type"))){
			
			RequestDispatcher rd =request.getRequestDispatcher("Admin_DeTai_NhapTuFile.jsp");
			rd.forward(request, response);
		}else{
	
			String fileName="";
			DiskFileItemFactory fif = new DiskFileItemFactory();
			ServletFileUpload sfu = new ServletFileUpload(fif);
			try {
				
				List<org.apache.commons.fileupload.FileItem> listItem = sfu.parseRequest(request);
				for(org.apache.commons.fileupload.FileItem file : listItem){
					
					if(! file.isFormField()){
						fileName = file.getName();
						
						SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyykkmmssSS");
						Date date = new Date();
						String fileName_new="DeTai"+sdf.format(date)+"."+FilenameUtils.getExtension(fileName);
						String filePath = request.getServletContext().getRealPath("") +File.separator+"files"+File.separator+fileName_new;
						File f = new File(filePath);
						try {
							file.write(f);
							ReadExcelDeTai read = new ReadExcelDeTai();
							ArrayList<DETAI> arDT =read.getListDeTai(filePath);							
							if(read.getError().size() == 0){
//								System.out.println(filePath);
								DeTaiBO dtBO = new DeTaiBO();
								for(DETAI objDT :arDT){								
										if(dtBO.insertData(objDT)){
											continue;
										}else{
											response.sendRedirect(request.getContextPath()+"/danhsachdetai?msg=error");
										}								
								}
								response.sendRedirect(request.getContextPath()+"/danhsachdetai?msg=add");
							}else{
								ArrayList<String> arError = read.getError();
								request.setAttribute("arError", arError);
								RequestDispatcher rd = request.getRequestDispatcher("/danhsachdetai");
								rd.forward(request, response);
							}
							
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
