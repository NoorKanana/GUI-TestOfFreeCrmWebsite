package com.freecrm.testcases;

import java.io.IOException;
import java.lang.reflect.Method;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;

import com.freecrm.base.TestBase;
import com.freecrm.pages.HomePage;
import com.freecrm.pages.LoginPage;
import com.freecrm.util.TestUtils;
import com.relevantcodes.extentreports.LogStatus;

import atu.testrecorder.exceptions.ATUTestRecorderException;

public class HomePageTest extends TestBase {
	public HomePageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	HomePage homePageObj;
	LoginPage loginPageObj;

	@BeforeTest
	public void beforeTest() {
		System.out.println("I will execute first test");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("I will execute Last test");

	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("I will execute first C2");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("I will execute Last C2");

	}

	@Parameters({ "browser" })
	@BeforeMethod

	private void tearUp(Method method, String browser) throws ATUTestRecorderException, IOException {
		logger = extent.startTest(method.getName());
		initialization(browser);
		loginPageObj = new LoginPage();
		TestUtils.video(method.getName() + " with " + browser);
		homePageObj = loginPageObj.performlogIn();
	}

	@Parameters({ "browser" })
	@AfterMethod
	public void tearDown(Method method, String browser, ITestResult result)
			throws IOException, ATUTestRecorderException {
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

	@Test(priority = 7)
	public void clickOnDealsTest() {
		Assert.assertTrue(homePageObj.isDealsDisPlayed(), "The Title is not displayed");

	}

	@Test(priority = 8)
	public void clickOnTasksTest() {
		Assert.assertTrue(homePageObj.isTasksDisPlayed(), "The Title is not displayed");

	}
}
