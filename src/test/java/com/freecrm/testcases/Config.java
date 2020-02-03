package com.freecrm.testcases;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.freecrm.base.TestBase;
import com.relevantcodes.extentreports.ExtentReports;

public class Config extends TestBase {

	public Config() throws IOException {
		super();

	}

	@BeforeSuite
	public void start() {
		extent = new ExtentReports("C:\\Users\\NOOR\\eclipse-workspace\\FreeCRMApplicationTest\\TestReport\\index.html", true);
		extent.addSystemInfo("OS", "Windows");
		extent.addSystemInfo("Owner", "Noor");
		extent.addSystemInfo("Test Name", "FReeCRM test");
		extent.addSystemInfo("Language", "Java");
		extent.addSystemInfo("Framework", "POM");

	}

	@AfterSuite
	public void end() {
		extent.flush();
	}
}
