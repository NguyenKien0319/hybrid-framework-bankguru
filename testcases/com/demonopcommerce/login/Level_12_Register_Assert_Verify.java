package com.demonopcommerce.login;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
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
	//@Test
	public void Register_02_Invalid_Email() {
		registerPage.getRefreshPage(driver);
		registerPage.inputEmailTextBox("abc");
		registerPage.clickRegisterButton();
		Assert.assertTrue(registerPage.isErrorMessageDisplay(driver, "Email", "Wrong email"));
	}
	//@Test
	public void Register_03_Invalid_Password() {
		registerPage.getRefreshPage(driver);
		registerPage.inputPasswordTextBox("123");
		registerPage.clickRegisterButton();
		
		Assert.assertTrue(registerPage.isInvalidPasswordMessageDispplayed());
	}
	//@Test
	public void Register_04_Not_Match_ConfirmPassword() {
		registerPage.getRefreshPage(driver);
		registerPage.inputConfirmPasswordTextBox("123");
		registerPage.clickRegisterButton();
		Assert.assertTrue(registerPage.isErrorMessageDisplay(driver, "ConfirmPassword", "The password and confirmation password do not match."));
	}
	//@Test
	public void Register_05_Register_Success() {
		registerPage.getRefreshPage(driver);
		registerPage.inputFirstNameTextBox("automation");
		registerPage.inputLastNameTextBox("Fc");
		registerPage.inputEmailTextBox(GlobalConstants.EMAIL_ID);
		registerPage.inputPasswordTextBox(GlobalConstants.PASSWORD_ID);
		registerPage.inputConfirmPasswordTextBox(GlobalConstants.PASSWORD_ID);
		registerPage.clickRegisterButton();
		
		Assert.assertTrue(registerPage.isSuccesedMessageDisplayed());
	}
	//@Test
	public void Register_06_Email_Already_Registed() {
		
		homePage = registerPage.clickToLogoutButton();
		registerPage = homePage.clickToRegisterLink();
		
		registerPage.inputFirstNameTextBox("automation");
		registerPage.inputLastNameTextBox("Fc");
		registerPage.inputEmailTextBox(GlobalConstants.EMAIL_ID);
		registerPage.inputPasswordTextBox(GlobalConstants.PASSWORD_ID);
		registerPage.inputConfirmPasswordTextBox(GlobalConstants.PASSWORD_ID);
		registerPage.clickRegisterButton();
		
		Assert.assertTrue(registerPage.isErrorEmailMessageDisplayed());
	}
	
	@AfterClass
	public void AfterClass() {
		driver.close();
	}
}
