package utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;





public class ExcelReading{
	
	
	static XSSFWorkbook wbk;
static	XSSFSheet sheet;
//String excelPath ="C:\\Users\\61468\\eclipse-workspace\\listeners\\AspiringTester\\src\\main\\java\\resources\\testData.xlsx";
	// CREATING CONSTRUCTOR
	
	public  ExcelReading(String excelPath, String sheetName) throws IOException {
		
FileInputStream fis = new FileInputStream(excelPath);
		
		wbk = new XSSFWorkbook(fis);
		 sheet = wbk.getSheet(sheetName);
		
	}
	
	
	
   @Test
	public  int getRowCount () throws IOException {
		
		
		int rowCount = sheet.getPhysicalNumberOfRows();
		
		return rowCount;
		
	}
	
   
   @Test
	public  int getColumnCount () throws IOException {
	   
	   
	   int cellCount = sheet.getRow(0).getLastCellNum();
	   return cellCount;
		
   }
   
   @Test
  	public   Object getCellData(int rownum, int colnum) throws IOException {
	   //will pass rownumber, col number
	   
	
		  
		  
	   DataFormatter formatter = new DataFormatter();
	   Object value = formatter.formatCellValue(sheet.getRow(rownum).getCell(colnum)); 
	
	 return value; 
	   
	   
   }
   

}
