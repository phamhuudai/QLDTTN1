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

public class ReadExcel {
	public ArrayList<GIAOVIEN> getListGV(String filePath) {
		ArrayList<GIAOVIEN> alGV = new ArrayList<GIAOVIEN>();
		try {
			FileInputStream fis = new FileInputStream(filePath);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();
			int i = 0;
			while (rowIterator.hasNext()) {
				int magvhd = 0;
				String hoten = "";
				String strNgaysinh = "";
				int macn = 0;
				String email = "";
				String diachi = "";
				String sdt = "";
				// GIAOVIEN gv = new GIAOVIEN(magvhd, hoten, ngaysinh, macn,
				// email,diachi, sdt);
				// arGV.add(gv);
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					switch (cell.getColumnIndex()) {
					case 0:
						magvhd = (int) cell.getNumericCellValue();
						break;
					case 1:
						hoten = cell.getStringCellValue();
						break;
					case 2:
						strNgaysinh = cell.getStringCellValue();
						break;
					case 3:
						macn = (int) cell.getNumericCellValue();
						break;
					case 4:
						email = cell.getStringCellValue();
						break;
					case 5:
						diachi = cell.getStringCellValue();
						break;
					case 6:
						sdt = cell.getStringCellValue();
						break;
					}
				}
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Date ngaysinh = new Date();
				ngaysinh = (Date) sdf.parse(strNgaysinh);
				GIAOVIEN objGV = new GIAOVIEN(magvhd, hoten, ngaysinh, macn, email, diachi, sdt);
				alGV.add(objGV);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return alGV;

	}
	public static void main(String[] args) {
		ReadExcel read = new ReadExcel();
		String s ="E:\\JAVA\\servlet\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\QLDTTN1\\files\\Book1.xlsx";
		System.out.println(read.getListGV(s).size());
		
	}
}
