package com.freecrm.pages;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.base.TestBase;

public class HomePage extends TestBase {

	public HomePage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[text()='Contacts']")
	WebElement contacts;

	@FindBy(xpath = "//*[text()='New']")
	WebElement newContact;

	@FindBy(xpath = "//*[text()='Status']")
	WebElement contactStatus;

	@FindBy(xpath = "//*[text()='Deals']")
	WebElement deals;

	@FindBy(xpath = "//*[text()='Tasks']")
	WebElement tasks;

	@FindBy(xpath = "//*[text()='New']")
	WebElement newDeals;

	@FindBy(xpath = "//*[text()='New']")
	WebElement newTasks;

	@FindBy(xpath = "//*[text()='Title']")
	WebElement titleLableTasks;

	@FindBy(xpath = "//*[text()='Title']")
	WebElement titleLableDeals;

	public boolean isDealsDisPlayed() {

		deals.click();
		newDeals.click();
		boolean titleOnDeals = titleLableDeals.isDisplayed();
		return titleOnDeals;
	}

	public boolean isTasksDisPlayed() {

		tasks.click();
		newTasks.click();
		boolean titleOnTasks = titleLableTasks.isDisplayed();
		return titleOnTasks;
	}

	public ContactPage clickOnNewContact() throws IOException {

		contacts.click();
		newContact.click();
		return new ContactPage();
	}

}
