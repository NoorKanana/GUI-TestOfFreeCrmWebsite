package com.freecrm.testcases;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.freecrm.base.TestBase;
import com.freecrm.pages.ContactPage;
import com.freecrm.pages.HomePage;
import com.freecrm.pages.LoginPage;
import com.freecrm.util.TestUtils;
import com.relevantcodes.extentreports.LogStatus;

import atu.testrecorder.exceptions.ATUTestRecorderException;

public class ContactPageTest extends TestBase {

	public ContactPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	LoginPage loginPageObj;
	HomePage homePageObj;
	ContactPage contactPageObj;

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

	@DataProvider
	public Object testData() throws Throwable {
		Object data[][] = TestUtils.getDataFromExcel("ContactPage");
		return data;
	}

	@Test(priority = 1, dataProvider = "testData")
	public void addContactTest(String fName, String LName, String compsnyName, String departmentName)
			throws IOException {
		homePageObj.clickOnNewContact();
		contactPageObj = new ContactPage();// för att detta ska Öppnas efter att klicka på contact
		contactPageObj.addNewContact(fName, LName, compsnyName, departmentName);

//		Actions action=new Actions(driver);
//		action.moveToElement(firstName).click().sendKeys("j,hkygliuuuuuuuuu").build().perform();
//		action.moveToElement(lasName).click().sendKeys("j,hkygliuuuuuuuuu").build().perform();
	}

}
