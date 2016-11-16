package common;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import model.bean.DETAI;
import model.bean.GIAOVIEN;
import model.bo.DeTaiBO;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class writeexcel {



		public static void main(String[] args) 
		{
			
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
			try 
			{
				//Write the workbook in file system
			    FileOutputStream out = new FileOutputStream(new File("DeTai.xlsx"));
			    workbook.write(out);
			    out.close();			     
			} 
			catch (Exception e) 
			{
			    e.printStackTrace();
			}
		}
	}
