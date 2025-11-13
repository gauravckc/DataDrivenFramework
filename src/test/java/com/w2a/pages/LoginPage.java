package com.w2a.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.w2a.utilities.GetAILocater;

public class LoginPage  {
	WebDriver driver;
	//gaurav
	//public String dmeo = "div> div:nth-child(5) >[class='btn btn-primary btn-lg']";
//	GetAILocater getailocater = new GetAILocater();
//	public String demo = getailocater.getAIEnhancedXPath("Bank Manager Login");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
  
	@FindBy(css = "div> div:nth-child(5) >[class='btn btn-primary btn-lg']")
	public WebElement BtnBankManagerLogin;

	public void Select_bankManager() throws Exception {
		BtnBankManagerLogin.click();
//		driver.findElement(By.xpath(getailocater.getAIEnhancedXPath("Bank Manager Login"))).click();
		
	}
	
}
