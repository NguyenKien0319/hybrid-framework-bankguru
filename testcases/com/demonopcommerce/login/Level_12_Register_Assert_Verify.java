package com.demonopcommerce.login;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.PageGeneratorManagement;
import pageObjects.nopCommerce.RegisterPageObject;

public class Level_12_Register_Assert_Verify extends BaseTest{
	private WebDriver driver;
	HomePageObject homePage;
	RegisterPageObject registerPage;
	
	@Parameters({"browser", "url"})
	@BeforeTest
	public void initBrowser(String browserName, String url) {
		driver  = getBrowserDriver(browserName, url);
	}
	
	@Test
	public void Register_01_Assert_Verify() {
		homePage = PageGeneratorManagement.getHomePage(driver);
		//HomePage > RegisterPage
		registerPage = homePage.clickToRegisterLink();
		//Failed lan 1
		verifyFalse(registerPage.isTextRegisterDisplayed());
		
		registerPage.clickRegisterButton();
		//Failed lan 2
		verifyFalse(registerPage.isErrorMessageDisplay(driver,"FirstName","First name is required."));
		verifyTrue(registerPage.isErrorMessageDisplay(driver,"LastName", "Last name is required."));
		verifyTrue(registerPage.isErrorMessageDisplay(driver,"Email", "Email is required."));
		verifyTrue(registerPage.isErrorMessageDisplay(driver,"Password","Password is required."));
		//Failed lan 3
		verifyFalse(registerPage.isErrorMessageDisplay(driver,"ConfirmPassword", "Password is required."));
	}
	
	@AfterClass
	public void AfterClass() {
		driver.close();
	}
}
