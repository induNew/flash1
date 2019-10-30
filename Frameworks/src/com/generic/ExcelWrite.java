package com.generic;

import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite {

	public static void CreateExcel(String fileName,String sheetName) throws Exception{
		Workbook w=new XSSFWorkbook();
		Sheet sh=w.createSheet(sheetName);
		sh.createRow(0).createCell(0).setCellValue("Name");
		sh.getRow(0).createCell(1).setCellValue("Status");
		FileOutputStream fileOut=new FileOutputStream(fileName+ ".xlsx");
		w.write(fileOut);
		fileOut.close();
		w.close();
		
	
}
}
