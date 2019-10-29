//package com.generic;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//
//import org.apache.poi.EncryptedDocumentException;
//import org.apache.poi.hssf.model.RowBlocksReader;
//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.usermodel.WorkbookFactory;
//import org.testng.Reporter;
//
//public class Excel implements IAutoConst {
//
//	public int getRowCount(String path, String Sheet)
//			throws EncryptedDocumentException, InvalidFormatException, IOException {
//		int rc = -1;
//		FileInputStream fis = new FileInputStream(XL_PATH);
//		Workbook wb = WorkbookFactory.create(fis);
//
//		try {
//
//			rc = wb.getSheet(SHEET_NAME).getLastRowNum();
//		}
//
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//		return rc;
//	}
//
//	public int getColCount(String path,String Sheet) throws EncryptedDocumentException, InvalidFormatException, IOException {
//		int cc=-1;
//		FileInputStream fis = new FileInputStream(XL_PATH);
//		Workbook wb=WorkbookFactory.create(fis);
//		
//		try
//		{
//			cc=wb.getSheet(SHEET_NAME).getRow(0).getLastCellNum();
//		}
//		
//		
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//		return cc;
//	}
//
//	public static String getData(String path,String Sheet,int rc,int cc) throws EncryptedDocumentException, InvalidFormatException, IOException {
//		
//			String ss="";
//			FileInputStream fis = new FileInputStream(XL_PATH);
//			
//			Workbook wb=WorkbookFactory.create(fis);
//			
//
////			Sheet sheet = excel.getSheet("Sheet1");
////			s = new String[sheet.getPhysicalNumberOfRows() - 1][sheet.getRow(0).getLastCellNum()];
//			for (int i = 1; i < rc; i++) {
//				for (int j = 0; j < cc; j++) 
//				{
//					//					Cell value = sheet.getRow(i).getCell(j);
////					s[i - 1][j] = value.toString();
//					Cell value=wb.getSheet(SHEET_NAME).getRow(rc).getCell(cc);
////					Reporter.log(value.toString(),true);
//					ss=value.toString();
//					
//				}
//										}
//			return ss;
//			 
//	}
//
//	
//}


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
import org.testng.Reporter;

public class Excel implements IAutoConst{
	
	public int getRow(String path,String sheet) 
	{
		FileInputStream fis;
		int rc=-1;
		try {
			fis = new FileInputStream(XL_PATH);
			Workbook w = WorkbookFactory.create(fis);
			rc = w.getSheet(SHEET_NAME).getLastRowNum();
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
				fis = new FileInputStream(XL_PATH);
				Workbook w = WorkbookFactory.create(fis);
				cc = w.getSheet(SHEET_NAME).getRow(0).getLastCellNum();
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
			fis = new FileInputStream(XL_PATH);
			w = WorkbookFactory.create(fis);
			value=w.getSheet(SHEET_NAME).getRow(row).getCell(col).toString();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return value;
	}
	
	public static void storeValue(String path,String sheet, int row, int col, String data)
			throws EncryptedDocumentException, InvalidFormatException {

		FileInputStream fis;
		try {
			fis = new FileInputStream(XL_PATH);
			Workbook wb = WorkbookFactory.create(fis);
			wb.getSheet(SHEET_NAME).getRow(row).getCell(col).setCellValue(data);
			FileOutputStream fos = new FileOutputStream(path);
			wb.write(fos);
			wb.close();
		} catch (Exception e) {
			System.out.println("File Not Found");
			e.printStackTrace();
		}

	}
	public static void setStatus(String path,String sheet, int row, int col, String status)
			throws EncryptedDocumentException, InvalidFormatException {

		FileInputStream fis;
		try {
			fis = new FileInputStream(XL_PATH);
			Workbook wb = WorkbookFactory.create(fis);
			wb.getSheet(SHEET_NAME).getRow(row).getCell(col).setCellValue(status);
			FileOutputStream fos = new FileOutputStream(path);
			wb.write(fos);
			wb.close();
		} catch (Exception e) {
			System.out.println("File Not Found");
			e.printStackTrace();
		}
	}

}
