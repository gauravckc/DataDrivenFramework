package com.w2a.testcases;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;
import com.w2a.pages.AddCustomerPage;
import com.w2a.pages.LoginPage;


public class TestCases extends TestBase {

	LoginPage loginpage;
	AddCustomerPage addcustpage;  
	

	@Test(groups= {"Regression","Sanity","Outsider"}) 
	public void LoginAsBankManager() throws Exception {
		loginpage = new LoginPage(driver);
		addcustpage = new AddCustomerPage(driver);
		loginpage.Select_bankManager();
		Assert.assertTrue(addcustpage.BtnAddCustomer.isDisplayed());	
	}

	@Test(priority=1, groups= {"Smoke","Sanity"})
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
	
	@Test(priority=2, groups= {"Smoke","Sanity"})
	public void EnterAddCustomerDetails_failed() throws Exception {
		loginpage = new LoginPage(driver);
		addcustpage = new AddCustomerPage(driver);
		loginpage.Select_bankManager();
		addcustpage.Select_AddCustomer();
		addcustpage.TxtBoxFirstName("");
		addcustpage.TxtBoxLastName("Sharma");
		addcustpage.TxtBoxPostcode("412101");
		addcustpage.BtnAddCustomerSubmit();
        System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();		
		System.out.println("**END**");
	}
	
}
