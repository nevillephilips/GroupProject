package com.google;


import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.DataProvider;





public class Utility {
	
	public static Logger Log = Utility.getlog(Utility.class);
	
	public static void utils (String actualvalue, String expectedvalue) {
		
		if (actualvalue.equalsIgnoreCase(expectedvalue)) {
		     Log.info("The test is passed");
		}
		else {
			
			Log.info("The test is failed");
			Log.info("Because");
			Log.info("Actual value  :"+actualvalue+" is not same as real value "+expectedvalue);
			Assert.assertEquals(expectedvalue, actualvalue);
		}
		
	}
	 
	public static Logger getlog (Class clazz) {
		
		Logger football= Logger.getLogger(clazz);
		
		PropertyConfigurator.configure("src\\test\\resources\\Log4j.Properties");
		return football;
		
		
		
		
	}
	@DataProvider(name="OSA")
	public static Object [][] Data () {
		
		Object [][] excel= Utility.readExcelFile("C:\\Users\\Owner\\Desktop\\Book1.xlsx", "IDPass");
		
		
		return excel;
		
		
	}
	
	public static Object[][] readExcelFile(String path,String sheetName) {
		Object data[][]=null;
		DataFormatter formatter=new DataFormatter();
		try {
		File file=new File(path);
		FileInputStream fileInput=new FileInputStream(file);
		XSSFWorkbook workbook=new XSSFWorkbook(fileInput);
		XSSFSheet sheet=workbook.getSheet(sheetName);
		int rowSize= sheet.getPhysicalNumberOfRows();
		int colSize=sheet.getRow(0).getLastCellNum();
		data=new Object[rowSize][colSize];
			Iterator<Row> rowIterator=sheet.rowIterator();
			int rowCount=0;	
			while(rowIterator.hasNext()) {
				Row row=rowIterator.next();
				Iterator<Cell> cellIterator=row.cellIterator();
				int colCount=0;
				while(cellIterator.hasNext()) {
					Cell cell=cellIterator.next();
					data[rowCount][colCount]=formatter.formatCellValue(cell);
					colCount++;
				}
				rowCount++;
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return data;
		}
}


