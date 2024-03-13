package com.tutorialsNinja.TestData;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelCode {
	
	//0. Add poi Apache dependencies in pom.xml file
	//1. Create or use the created Excel Sheet which has the data
	//2. Make sure the sheetnames are correct
	//3. Copy the Excel sheet and put it inside the package where you want to keep your code
	//4. Make sure the Excel sheet is updated, then only paste it as mentioned in point 3
	//5. Students please practice this 5 times - watch the video and do it
	
	public static FileInputStream ip;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	
	
	@DataProvider(name = "TNLogin")
	public Object[][] getTNExcelLoginData() throws Exception {
		Object[][] data = ExcelCode.readFromExcelSheetTNLogin("LoginTN");
		return data;
	}
	
	
	public static Object[][] readFromExcelSheetTNLogin(String sheetName) throws Exception {
	//5. Create the Object of FileInputStream class and pass the path of the Excel sheet in its Constructor
		 ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\com\\tutorialsNinja\\TestData\\ExcelData.xlsx");
	//6. Create the Object of XSSFWorkbook class
		 workbook = new XSSFWorkbook(ip);
	//7. use the workbook reference to address individual sheet
		sheet = workbook.getSheet(sheetName);
	//8. identify the rows and cols of the sheet
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();
	//9. Create a 2-Dimensional Object Array and then return the Object Array
		Object[][] data = new Object[rows][cols];
		for(int i=0 ; i<rows ; i++) {
			XSSFRow row = sheet.getRow(i+1);
			for(int j=0 ; j<cols ; j++) {
					XSSFCell cell = row.getCell(j);
					CellType celltype = cell.getCellType();
					
					switch(celltype) {
					case STRING:
						data[i][j] = cell.getStringCellValue();
						break;
						
					case NUMERIC:
						data[i][j] = Integer.toString((int)cell.getNumericCellValue());
						break;
						
					case BOOLEAN:
						data[i][j] = cell.getBooleanCellValue();
						break;
					}
			}
		}
		
		return data;
	
	}
	
	@DataProvider(name = "TNRegister")
	public Object[][] getTNExcelRegisterData() throws Exception {
		Object[][] data = ExcelCode.readFromExcelSheetTNRegister("RegisterTN");
		return data;
	}
	
	public static Object[][] readFromExcelSheetTNRegister(String sheetName) throws Exception {
		//5. Create the Object of FileInputStream class and pass the path of the Excel sheet in its Constructor
			 ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\com\\tutorialsNinja\\TestData\\ExcelData.xlsx");
		//6. Create the Object of XSSFWorkbook class
			 workbook = new XSSFWorkbook(ip);
		//7. use the workbook reference to address individual sheet
			sheet = workbook.getSheet(sheetName);
		//8. identify the rows and cols of the sheet
			int rows = sheet.getLastRowNum();
			int cols = sheet.getRow(0).getLastCellNum();
		//9. Create a 2-Dimensional Object Array and then return the Object Array
			Object[][] data = new Object[rows][cols];
			for(int i=0 ; i<rows ; i++) {
				XSSFRow row = sheet.getRow(i+1);
				for(int j=0 ; j<cols ; j++) {
						XSSFCell cell = row.getCell(j);
						CellType celltype = cell.getCellType();
						
						switch(celltype) {
						case STRING:
							data[i][j] = cell.getStringCellValue();
							break;
							
						case NUMERIC:
							data[i][j] = Integer.toString((int)cell.getNumericCellValue());
							break;
							
						case BOOLEAN:
							data[i][j] = cell.getBooleanCellValue();
							break;
						}
				}
			}
			
			return data;
		
		}
	
	


}
