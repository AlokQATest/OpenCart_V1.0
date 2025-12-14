package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilitytest {
	public FileInputStream file;
	public FileOutputStream out_File;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;
	String path;
	
	public ExcelUtilitytest(String path) {
		this.path = path;
		
	}
	
	public int getRowCount(String sheetName) throws IOException {
		file = new FileInputStream(path);
		workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheet(sheetName);
		int rowcount = sheet.getLastRowNum();
		workbook.close();
		file.close();
		return rowcount;
	}
	
	public int getCellCount(String sheetName, int rownum) throws IOException {
		file = new FileInputStream(path);
		workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rownum);
		int cellcount = row.getLastCellNum();
		workbook.close();
		file.close();
		return cellcount;
	}
	
	public String getCellData(String sheetName, int rownum, int colnum) throws IOException {
		file = new FileInputStream(path);
		workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rownum);
		cell = row.getCell(colnum);
		
		DataFormatter formatter = new DataFormatter();
		String data;
		try {
			data = formatter.formatCellValue(cell);
		}
		catch (Exception e){
			data = "";
		}
		workbook.close();
		file.close();
		return data;
	}
	
	public void setCellData(String sheetName, int rownum, int colnum, String data) throws IOException {
		
		File xlfile= new File(path);
		//checking whether file exists or not- if not then creating it
		if(!xlfile.exists()) {
			workbook = new XSSFWorkbook();
			out_File = new FileOutputStream(path);
			workbook.write(out_File);
		}
		
		
		
		
		
		
	}
}
