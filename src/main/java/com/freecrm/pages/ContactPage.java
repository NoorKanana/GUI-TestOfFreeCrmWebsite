package com.freecrm.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.base.TestBase;

public class ContactPage extends TestBase {

	public ContactPage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "first_name")
	WebElement firstName;

	@FindBy(name = "last_name")
	WebElement lasName;
	@FindBy(css = "input[class='search']")
	WebElement company;
	@FindBy(name = "department")
	WebElement department;
	@FindBy(xpath = "//*[text()='Save']")
	WebElement save;

	public void addNewContact(String fName, String LName, String compsnyName, String departmentName) {

		firstName.sendKeys(fName);
		lasName.sendKeys(LName);
		company.sendKeys(compsnyName);
		department.sendKeys(departmentName);
		save.click();
	}
	
}
