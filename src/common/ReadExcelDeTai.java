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

import model.bean.DETAI;
import model.bo.ChuyenNhanhBO;
import model.bo.DeTaiBO;
import model.bo.GiaoVienBO;

public class ReadExcelDeTai {
	private ArrayList<String> arError;
	ChuyenNhanhBO cnBO;
	DeTaiBO dtBO;
	GiaoVienBO gvBO;

	public ReadExcelDeTai() {
		arError = new ArrayList<String>();
		cnBO = new ChuyenNhanhBO();
		dtBO = new DeTaiBO();
		gvBO = new GiaoVienBO();
	}

	public static boolean isRowEmpty(Row row) {
		for (int c = row.getFirstCellNum(); c < row.getLastCellNum(); c++) {
			Cell cell = row.getCell(c);
			if (cell != null && cell.getCellType() != Cell.CELL_TYPE_BLANK)
				return false;
		}
		return true;
	}

	public ArrayList<DETAI> getListDeTai(String filePath) {
		ArrayList<DETAI> alGV = new ArrayList<DETAI>();
		try {
			FileInputStream fis = new FileInputStream(filePath);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();
			int i = 0;
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				if (!isRowEmpty(row)) {
					if (i == 0) {
						i++;
						continue;
					}
					int maDeTai = 0;
					String tenDeTai = "";
					int maCN = 0;

					String noiDung = "";
					int maGVHD = 0;
					int check = 0;

					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						switch (cell.getColumnIndex()) {
						case 0:
							try {
								maDeTai = (int) cell.getNumericCellValue();

							} catch (Exception e) {
								maDeTai = 0;
								check = -1;
							}
							break;
						case 1:
							try {
								tenDeTai = cell.getStringCellValue();
							} catch (Exception e) {
								tenDeTai = "";
								check = -1;
							}
							break;
						case 2:
							try {
								maCN = (int) cell.getNumericCellValue();
							} catch (Exception e) {
								maCN = 0;
								check = -1;
							}
							break;
						case 3:
							try {
								noiDung = cell.getStringCellValue();
							} catch (Exception e) {
								noiDung = "";
								check = -1;
							}
							break;
						case 4:
							try {
								maGVHD = (int) cell.getNumericCellValue();
							} catch (Exception e) {
								maGVHD = 0;
								check = -1;
							}
							break;
						}
					}
					
						String error = "Dòng " + i + ": ";
						if (check == -1 || maCN == 0 || maDeTai == 0 || maGVHD == 0) {
							if (maDeTai == 0) {
								
								error += "lỗi mã đề tài, ";
							}
							if (tenDeTai.isEmpty()) {
								error += "lỗi tên đề tài, ";
							}
							if (maCN == 0) {
								error += "lỗi mã CN, ";
							}
							if (noiDung.isEmpty()) {
								error += "lỗi nội dung, ";
							}
							if (maGVHD == 0) {
								error += "lỗi mã GVHD, ";
							}
							arError.add(error);
						} else if (dtBO.isExist(maDeTai)) {
							error += "Mã đề tài: " + maDeTai + " đã tồn tại!, ";
							arError.add(error);
						} else if (!cnBO.isExist(maCN)) {
							error += "Không tồn tại mã chuyên ngành: " + maCN;
							arError.add(error);
						} else if (!gvBO.isExist(maGVHD)) {
							error += "Không tồn tại Giáo viên: " + maGVHD;
							arError.add(error);
						} else {
							DETAI objDT = new DETAI(maDeTai, tenDeTai, maCN,
									noiDung, maGVHD);
							alGV.add(objDT);
						}
						i++;

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

	public ArrayList<String> getError() {
		return arError;
	}

	/*public static void main(String[] args) {
		ReadExcelDeTai r = new ReadExcelDeTai();
		ArrayList<DETAI> ar = r
				.getListDeTai("E:\\JAVA\\servlet\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\QLDTTN1\\files\\detai.xlsx");
		//System.out.println(ar.get(0).getMagvhd());
		System.out.println(r.getError());

	}*/

}
