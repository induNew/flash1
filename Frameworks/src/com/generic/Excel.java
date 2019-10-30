
package com.generic;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.model.RowBlocksReader;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Reporter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {
	public int getRow(String path,String sheet ) 
	{
		FileInputStream fis;
		int rc=-1;
		try {
			fis = new FileInputStream(path);
			Workbook w = WorkbookFactory.create(fis);
			rc = w.getSheet(sheet).getLastRowNum();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return rc;
	}

	public int getColumn(String path,String sheet)
	{
		{
			FileInputStream fis;
			int cc=-1;
			try {
				fis = new FileInputStream(path);
				Workbook w = WorkbookFactory.create(fis);
				cc = w.getSheet(sheet).getRow(0).getLastCellNum();
			}
			catch(Exception e) 
			{
				e.printStackTrace();
			}
			return cc;
		}

	}
	
	public static String getData(String path,String sheet, int row,int col)
	{
		String value="";
		Workbook w;
		FileInputStream fis;
		try {
			fis = new FileInputStream(path);
			w = WorkbookFactory.create(fis);
			value=w.getSheet(sheet).getRow(row).getCell(col).toString();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return value;
	}
	

	
	
		public static void createExcel(String path, String sheetName) throws Exception {
		Workbook w = new XSSFWorkbook();
		Sheet sh = w.createSheet(sheetName);
		sh.createRow(0).createCell(0).setCellValue("Test case Name");
		sh.getRow(0).createCell(1).setCellValue("Status");
		FileOutputStream fileOut = new FileOutputStream(path);
		w.write(fileOut);
		fileOut.close();
		w.close();
		}

		public static void setData(String Name, String status, int row, int col, String sheet, String path)
		throws Throwable {
		FileInputStream fis;
		try {
		fis = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheet);
		sh.createRow(row).createCell(col).setCellValue(Name);
		col++;
		sh.getRow(row).createCell(col).setCellValue(status);
		FileOutputStream fos = new FileOutputStream(path);
		wb.write(fos);
		wb.close();
		} catch (Exception e) {
		e.printStackTrace();
		}

		}
	

}
