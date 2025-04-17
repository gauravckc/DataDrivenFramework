package com.w2a.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;
import com.w2a.pages.AddCustomerPage;
import com.w2a.pages.LoginPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCases extends TestBase {

	LoginPage loginpage;
	AddCustomerPage addcustpage;  

	@Test
	public void LoginAsBankManager() throws Exception {
		loginpage = new LoginPage(driver);
		addcustpage = new AddCustomerPage(driver);
		loginpage.Select_bankManager();
		Assert.assertTrue(addcustpage.BtnAddCustomer.isDisplayed());	

	}
	@Test(priority=1)
	public void EnterAddCustomerDetails() throws Exception {
		loginpage = new LoginPage(driver);
		addcustpage = new AddCustomerPage(driver);
		loginpage.Select_bankManager();
		addcustpage.Select_AddCustomer();
		addcustpage.TxtBoxFirstName("Gaurav");
		addcustpage.TxtBoxLastName("Sharma");
		addcustpage.TxtBoxPostcode("412101");
		addcustpage.BtnAddCustomerSubmit();
        System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();		
		System.out.println("**END**");
	}
	
	
}
