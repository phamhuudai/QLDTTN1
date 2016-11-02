package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
				DeTaiBO dtBO = new DeTaiBO();
				ArrayList<DETAI> arDT = dtBO.getList();
				XSSFWorkbook workbook = new XSSFWorkbook(); 				
				//Create a blank sheet
				XSSFSheet sheet = workbook.createSheet("De Tai");				 
				//This data needs to be written (Object[])
				TreeMap<String, Object[]> data = new TreeMap<String, Object[]>();
				data.put("1", new Object[] {"MDT", "Ten DT", "MaCN","NoiDung","GVHD"});
				int i=2;
				for(DETAI ObjDT : arDT){
					data.put(i+"", new Object[]{ObjDT.getMadetai(),ObjDT.getTendetai(),ObjDT.getMacn(),ObjDT.getThongtinnoidung(),ObjDT.getMagvhd()});
					i++;
				}				 
				//Iterate over data and write to sheet
				Set<String> keyset = data.keySet();
				int rownum = 0;
				for (String key : keyset)
				{
				    Row row = sheet.createRow(rownum++);
				    Object [] objArr = data.get(key);
				    int cellnum = 0;
				    for (Object obj : objArr)
				    {
				       Cell cell = row.createCell(cellnum++);
				       if(obj instanceof String)
				            cell.setCellValue((String)obj);
				        else if(obj instanceof Integer)
				            cell.setCellValue((Integer)obj);
				    }
				}
				try 
				{
					//Write the workbook in file system
				    FileOutputStream out = new FileOutputStream(new File("howtodoinjava_demo.xlsx"));
				    workbook.write(out);
				    out.close();				    
				    System.out.println("howtodoinjava_demo.xlsx written successfully on disk.");				     
				} 
				catch (Exception e) 
				{
				    e.printStackTrace();
				}
	}
}
