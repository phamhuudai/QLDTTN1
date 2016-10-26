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

import model.bean.GIAOVIEN;
import model.bean.NGUOIDUNG;
import model.bo.GiaoVienBO;
import model.bo.NguoiDungBO;

import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.apache.tomcat.util.http.fileupload.FileItem;

import sun.font.GlyphLayout.GVData;
import common.ReadExcelGV;

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
						String fileName_new="DanhSach"+sdf.format(date)+"."+FilenameUtils.getExtension(fileName);
						String filePath = request.getServletContext().getRealPath("") +File.separator+"files"+File.separator+fileName_new;
						File f = new File(filePath);
						try {
							file.write(f);
							ReadExcelGV read = new ReadExcelGV();
							ArrayList<GIAOVIEN> arGV =read.getListGV(filePath);							
							if(read.getError().size() == 0){
								System.out.println(filePath);
								System.out.println(arGV);
								GiaoVienBO gvBO = new GiaoVienBO();
								for(GIAOVIEN objGV :arGV){
									int maSo=objGV.getMagvhd();
									NGUOIDUNG nd = new NGUOIDUNG(maSo, "12345678", "GV");
									NguoiDungBO ndBO = new NguoiDungBO();
									if(ndBO.insertData(nd)){								
										if(gvBO.insertData(objGV)){
											continue;
										}else{
											ndBO.delData(maSo);
											response.sendRedirect(request.getContextPath()+"/danhsachgv?msg=error");
											
										}
									}
								}
								response.sendRedirect(request.getContextPath()+"/danhsachgv?msg=add");
							}else{
								ArrayList<String> arError = read.getError();
								request.setAttribute("arError", arError);
								RequestDispatcher rd = request.getRequestDispatcher("/danhsachgv");
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
