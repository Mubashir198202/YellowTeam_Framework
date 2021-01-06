package com.zoopla.excel.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Zoopla_ExcelDataPass {
	
	
	public static ArrayList<String>readExcelData(int colum) throws Throwable {
		
		FileInputStream file = new FileInputStream("C:\\Users\\marup\\eclipse-workspace\\YellowTeam_Framework\\ZooplaExcel_TestData\\EXCEL TEST CASE ZOOPLA.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(file);
		XSSFSheet sheet = book.getSheet("Sheet1");
		
		Iterator<Row>it = sheet.iterator();
		it.next();
		
		ArrayList<String>list = new ArrayList<String>();
		while(it.hasNext()) {
			list.add(it.next().getCell(colum).getStringCellValue());
		}
		System.out.println("List of data : "+list);
		
		
		return list;
		
	}
	
	
	
	
	
	
	
	
	

}
