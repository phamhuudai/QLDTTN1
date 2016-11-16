package controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.DETAI;
import model.bo.DeTaiBO;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Servlet implementation class ControllerOutputExcelDeTai
 */
public class ControllerOutputExcelDeTai extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerOutputExcelDeTai() {
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
		XSSFWorkbook workbook = new XSSFWorkbook(); 
		
		//Create a blank sheet
		XSSFSheet sheet = workbook.createSheet("DeTai");
		sheet.setColumnWidth(0, 5000);
		sheet.setColumnWidth(1, 10000);
		sheet.setColumnWidth(2, 5000);
		sheet.setColumnWidth(3, 10000);
		sheet.setColumnWidth(4, 5000);
		 
		 
		//Iterate over data and write to sheet
		DeTaiBO dtBO = new DeTaiBO();
		ArrayList<DETAI> arDT = dtBO.getList(); 		
		int rownum = 1;
		
		//create name of collumn
			Row rowTitle = sheet.createRow(rownum++);
			Cell cellMaDT_t = rowTitle.createCell(0);
			
		    cellMaDT_t.setCellValue("Mã đề tài");
		    
		    Cell cellTenDT_t = rowTitle.createCell(1);
		    cellTenDT_t.setCellValue("Tên đề tài");
		  
		    Cell cellMaCN_t = rowTitle.createCell(2);
		    cellMaCN_t.setCellValue("Mã chuyên ngành");
		    
		    Cell cellNoiDung_t = rowTitle.createCell(3);
		    cellNoiDung_t.setCellValue("Nội dung");

		    Cell cellMaGVHD_t = rowTitle.createCell(4);
		    cellMaGVHD_t.setCellValue("Mã GVHD");
		
		
		for (DETAI objDT : arDT)
		{	
			
		    Row row = sheet.createRow(rownum++);
		    			   
		    Cell cellMaDT = row.createCell(0);
		    cellMaDT.setCellValue(objDT.getMadetai());
		    
		    Cell cellTenDT = row.createCell(1);
		    cellTenDT.setCellValue(objDT.getTendetai());
		  
		    Cell cellMaCN = row.createCell(2);
		    cellMaCN.setCellValue(objDT.getMacn());
		    
		    Cell cellNoiDung = row.createCell(3);
		    cellNoiDung.setCellValue(objDT.getThongtinnoidung());

		    Cell cellMaGVHD = row.createCell(4);
		    cellMaGVHD.setCellValue(objDT.getMagvhd());
		    
		}

		
		ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
		workbook.write(outByteStream);
		byte [] outArray = outByteStream.toByteArray();
		response.setContentType("application/ms-excel");
		response.setContentLength(outArray.length);
		response.setHeader("Expires:", "0"); // eliminates browser caching
		response.setHeader("Content-Disposition", "attachment; filename=danhsachdetai.xlsx");
		OutputStream outStream = response.getOutputStream();
		outStream.write(outArray);
		outStream.flush();
	}
}
