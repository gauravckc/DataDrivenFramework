package com.w2a.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	WebDriver driver;

	//new code
	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "button[ng-click='addCust()']")
	public WebElement BtnAddCustomer;

	@FindBy(css = "[ng-model='fName']")
	public WebElement TxtBoxFirstName; 
	
	@FindBy(css = "[ng-model='lName']")
	public WebElement TxtBoxLastName;
	
	@FindBy(css = "[ng-model='postCd']")
	public WebElement TxtBoxPostcode;
	
	@FindBy(css = "[type='submit']")
	public WebElement BtnAddCustomerSubmit;
	
	public void Select_AddCustomer() 
	{
		BtnAddCustomer.click();
	}
	
	public void TxtBoxFirstName(String str) {
		TxtBoxFirstName.sendKeys(str);
	}

	public void TxtBoxLastName(String str) {
		TxtBoxLastName.sendKeys(str);
	}

	public void TxtBoxPostcode(String str) {
		TxtBoxPostcode.sendKeys(str);
		
	}

	public void BtnAddCustomerSubmit() {
		BtnAddCustomerSubmit.click();
		
	}
}
