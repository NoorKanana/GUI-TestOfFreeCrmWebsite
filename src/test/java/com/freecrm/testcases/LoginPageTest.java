package com.freecrm.testcases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;

import com.freecrm.base.TestBase;
import com.freecrm.pages.HomePage;
import com.freecrm.pages.LoginPage;
import com.freecrm.util.TestUtils;
import com.relevantcodes.extentreports.LogStatus;

import atu.testrecorder.exceptions.ATUTestRecorderException;

public class LoginPageTest extends TestBase {

	public LoginPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	LoginPage loginPageObj;
	HomePage homePageObj;

	@Parameters({ "browser" })
	@BeforeMethod
	public void setUp(Method method, String browser) throws ATUTestRecorderException, IOException {
		logger = extent.startTest(method.getName());
		initialization(browser);// definera driver
		loginPageObj = new LoginPage();
		TestUtils.video(method.getName() + " with " + browser);

	}

	@Parameters({ "browser" })
	@AfterMethod
	public void tearDown(Method method, String browser, ITestResult result)
			throws ATUTestRecorderException, IOException {
		TestUtils.takeScreenshot(method.getName() + " with " + browser);
		TestUtils.recorder.stop();
		if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(LogStatus.PASS, "Test is pass");
			logger.log(LogStatus.PASS, "<a href='" + result.getName()+" with "+browser + ".png"
					+ "' ><span class='lable info'>Download Snapshot </span></a>");
			logger.log(LogStatus.PASS, "<a href='" + result.getName()  +" with "+browser +".mov"
					+ "' ><span class='lable info'>Download video </span></a>");

		}

		else if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(LogStatus.FAIL, result.getThrowable());
			logger.log(LogStatus.FAIL, "<a href='" + result.getName() +" with "+browser + ".png"
					+ "' ><span class='lable info'>Download Snapshot </span></a>");
			logger.log(LogStatus.FAIL, "<a href='" + result.getName() +" with "+browser +".mov"
					+ "' ><span class='lable info'>Download video </span></a>");


		} else {
			logger.log(LogStatus.SKIP, "Test is skipped");
			logger.log(LogStatus.SKIP, "<a href='" + result.getName() +" with "+browser + ".png"
					+ "' ><span class='lable info'>Download Snapshot </span></a>");
			logger.log(LogStatus.SKIP, "<a href='" + result.getName() +" with "+browser +".mov"
					+ "' ><span class='lable info'>Download video </span></a>");
		}
		loginPageObj.quit();

	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("I will execute first C1");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("I will execute Last C1");
	}

	@Test(priority = 5)

	public void titleTest() {// bygga metoden h�r f�r att vi ska bygga den f�rsta testfall som best�r av
								// olika steg
		// namnet p� metoden �r samma namn p� testfall

		String expectedTitle = "Free CRM #1 cloud software for any business large or small";
		String actualTitle = loginPageObj.getTitle();
		assertEquals(actualTitle, expectedTitle);

	}

	@Test(priority = 2)
	public void urlTest() {

		String expectedUrl = "https://freecrm.com/";
		String actualUrl = loginPageObj.getUlr();
		System.out.println(actualUrl);
		Assert.assertEquals(actualUrl, expectedUrl, "If this massege appear thats mean there is a failure");

	}

	@Test(priority = 3)
	public void logoTest() {

		boolean expectedLogo = true;
		boolean actualLogo = loginPageObj.logoIsDisplayd();
		System.out.println(actualLogo);
		assertEquals(actualLogo, expectedLogo);

	}

	@Test(priority = 4)
	public void logInTest() throws IOException {

		homePageObj = loginPageObj.performlogIn();

	}

}
