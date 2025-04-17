package com.w2a.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage  {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "div> div:nth-child(5) >[class='btn btn-primary btn-lg']")
	public WebElement BtnBankManagerLogin;

	public void Select_bankManager() {
		BtnBankManagerLogin.click();
	}

}
