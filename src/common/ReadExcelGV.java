package common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



import model.bean.GIAOVIEN;

public class ReadExcelGV {
	private ArrayList<String> arError;
	public ReadExcelGV(){
		arError = new ArrayList<String>();
	}
	
	public ArrayList<GIAOVIEN> getListGV(String filePath) {
		ArrayList<GIAOVIEN> alGV = new ArrayList<GIAOVIEN>();
		try {
			FileInputStream fis = new FileInputStream(filePath);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();
			int i = 0;
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				if (i == 0) {
					i++;
					continue;
				}
				i++;
				int magvhd = 0;
				String hoten = "";
				String strNgaysinh = "";
				int macn = 0;
				String email = "";
				String diachi = "";
				String sdt = "";
				int check=0;
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					switch (cell.getColumnIndex()) {
					case 0:
						try{
							magvhd = (int) cell.getNumericCellValue();
						}catch(Exception e){
							magvhd=0;
							check=-1;
						}
						break;
					case 1:
						try{
						hoten = cell.getStringCellValue();
						}catch(Exception e){
							hoten="";
							check=-1;
						}
						break;
					case 2:
						try{
						strNgaysinh = cell.getStringCellValue();
						}catch(Exception e){
							strNgaysinh="";
							check=-1;
						}
						break;
					case 3:
						try{
						macn = (int) cell.getNumericCellValue();
						}catch(Exception e){
							macn=0;
							check=-1;
						}
						break;
					case 4:
						try{
						email = cell.getStringCellValue();
						}catch(Exception e){
							email="";
							check=-1;
						}
						break;
					case 5:
						try{
						diachi = cell.getStringCellValue();
						}catch(Exception e){
							diachi="";
							check=-1;
						}
						break;
					case 6:
						try{
						sdt = cell.getStringCellValue();
						}catch(Exception e){
							sdt="";
							check=-1;
						}
						break;
					}
				}
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Date ngaysinh = new Date();
				try{				
				ngaysinh = (Date) sdf.parse(strNgaysinh);
				}
				catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					ngaysinh=null;
				}
				String error="Dòng "+i+": ";
				if(check==-1){
					if(magvhd==0){
						error+="lỗi mã GVHD, ";
					}
					if(hoten.isEmpty()){
						error+="lỗi họ tên, ";
					}
					if(ngaysinh==null){
						error+="lỗi ngày sinh, ";
					}
					if(macn==0){
						error+="lỗi mã CN, ";
					}
					if(email.isEmpty()){
						error+="lỗi email, ";
					}
					if(diachi.isEmpty()){
						error+="lỗi địa chỉ, ";
					}
					if(sdt.isEmpty()){
						error+="lỗi SĐT.";
					}
					arError.add(error);
				}else{
					GIAOVIEN objGV = new GIAOVIEN(magvhd, hoten, ngaysinh, macn, email, diachi, sdt);
					alGV.add(objGV);
				}
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return alGV;
	}
	public ArrayList<String> getError(){
		return arError;
	}
	/*public static void main(String[] args) {
		ReadExcelGV r = new ReadExcelGV();
		ArrayList<GIAOVIEN> ar=r.getListGV("E:\\JAVA\\servlet\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\QLDTTN1\\files\\Book1.xlsx");
		System.out.println(ar.get(0).getMagvhd());
		System.out.println(r.getError());
	}*/
	
}
