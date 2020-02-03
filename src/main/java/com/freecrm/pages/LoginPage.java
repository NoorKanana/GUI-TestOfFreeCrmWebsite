package com.freecrm.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.base.TestBase;

public class LoginPage extends TestBase {
	public LoginPage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "a[href='https://freecrm.com']")
	WebElement logo;

	@FindBy(css = "a[href='https://ui.freecrm.com']")
	WebElement logIn;

	@FindBy(name = "email")
	WebElement userNameTextbox;

	@FindBy(name = "password")
	WebElement passWordTextbox;

	@FindBy(css = "div[class='ui fluid large blue submit button']")
	WebElement loginButton;

	public String getTitle() {
		String actulTitle = driver.getTitle();
		return actulTitle;
	}

	public String getUlr() {
		String actulUrl = driver.getCurrentUrl();
		return actulUrl;
	}

	public boolean logoIsDisplayd() {
		boolean actulLogo = logo.isDisplayed();
		return actulLogo;
	}

	public HomePage performlogIn() throws IOException {
		logIn.click();
		userNameTextbox.sendKeys(prop.getProperty("userName"));
		passWordTextbox.sendKeys(prop.getProperty("password"));
		loginButton.click();
		return new HomePage();

	}
	public void quit() {
		driver.quit();
		}
}
