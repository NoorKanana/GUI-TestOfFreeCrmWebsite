package com.freecrm.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.freecrm.base.TestBase;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

public class TestUtils extends TestBase {
	public static ATUTestRecorder recorder;

	public TestUtils() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void takeScreenshot(String methodName) throws IOException {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile,
				new File("C:\\Users\\NOOR\\eclipse-workspace\\FreeCRMApplicationTest\\TestReport\\" + methodName + ".png"));
	}

	public static void video(String methodName) throws ATUTestRecorderException {
		recorder = new ATUTestRecorder("C:\\Users\\NOOR\\eclipse-workspace\\FreeCRMApplicationTest\\TestReport", methodName,
				false);
		recorder.start();
	}
	public static Object[][] getDataFromExcel(String sheetName) throws IOException {
		File file = new File("C:\\Users\\NOOR\\eclipse-workspace\\FreeCRMApplicationTest\\src\\main\\java\\com\\freecrm\\testData\\FreeCRMTestData.xlsx");
		FileInputStream fis = new FileInputStream(file);

		XSSFWorkbook workbook = new XSSFWorkbook(fis);// Xlsx use med den XSSFWorkbook Apache poi
		Sheet sheet = workbook.getSheet(sheetName);// String nameIt=sheet.getRow(2).getCell(3).toString();

		int rows = sheet.getLastRowNum();
		int columns = sheet.getRow(0).getLastCellNum();

		Object data[][] = new Object[rows][columns];

		for (int i = 0; i < rows; i++) {
			for (int k = 0; k < columns; k++) {
				data[i][k] = sheet.getRow(i).getCell(k).toString();
				//workbook.close();
			}

		}
		return data;

	}

}
