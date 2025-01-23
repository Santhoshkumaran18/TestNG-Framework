package ExcelIntegration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataDrivenWritingintoExcel {
	public static void main(String[] args) throws IOException {
		File file=new File(System.getProperty("user.dir")+ "/test.xlsx");
		FileOutputStream fos=new FileOutputStream(file);
		XSSFWorkbook workbook=new XSSFWorkbook();
		
		XSSFSheet sheet= workbook.createSheet("Santhosh");
		XSSFRow row1= sheet.createRow(0);
		row1.createCell(0).setCellValue("Automation");
		row1.createCell(1).setCellValue("Name");
		 
		XSSFRow row2= sheet.createRow(1);
		row1.createCell(0).setCellValue("1");
		row1.createCell(1).setCellValue("Automation");
		
		workbook.write(fos);
		workbook.close();
		fos.close();
		
		System.out.println("File is created successfully");
	}
}
