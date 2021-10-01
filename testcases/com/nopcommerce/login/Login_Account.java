package com.nopcommerce.login;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;
import pageObjects.nopCommerce.PageGeneratorManagement;

public class Login_Account extends BaseTest{
	private WebDriver driver;
	HomePageObject homePage;
	LoginPageObject loginPage;
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void initBrowser(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
	}
	
	@Test
	public void Login_01_Empty_Data() {
		homePage = PageGeneratorManagement.getHomePage(driver);
		loginPage = homePage.clickToLoginButtonToOpen();
		loginPage.clickLoginButton();
		
		Assert.assertTrue(loginPage.isErrorEmailMessageDisplayed(driver,"Please enter your email"));
	}
	@Test
	public void Login_02_Invalid_Email() {
		loginPage.getRefreshPage(driver);
		loginPage.inputEmailTextBox("abc");
		loginPage.clickLoginButton();
		
		Assert.assertTrue(loginPage.isErrorEmailMessageDisplayed(driver,"Wrong email"));
	}
	@Test
	public void Login_03_Email_Not_Register_Yet() {
		loginPage.getRefreshPage(driver);
		loginPage.inputEmailTextBox(GlobalConstants.EMAIL_NOT_REGISTER);
		loginPage.clickLoginButton();
		
		Assert.assertTrue(loginPage.isErrorMessageDisplayed(driver, "No customer account found"));
	}
	@Test
	public void Login_04_Empty_Password() {
		loginPage.clickLoginHeaderLink();
		loginPage.inputEmailTextBox(GlobalConstants.EMAIL_ID);
		loginPage.clickLoginButton();
		
		Assert.assertTrue(loginPage.isErrorMessageDisplayed(driver, "The credentials provided are incorrect"));
	}
	@Test
	public void Login_05_Incorrect_Password() {
		loginPage.clickLoginHeaderLink();
		loginPage.inputEmailTextBox(GlobalConstants.EMAIL_ID);
		loginPage.inputPasswordTextBox("123456789");
		loginPage.clickLoginButton();
		
		Assert.assertTrue(loginPage.isErrorMessageDisplayed(driver, "The credentials provided are incorrect"));
	}
	@Test
	public void Login_06_Login_Success() {
		loginPage.clickLoginHeaderLink();
		loginPage.inputEmailTextBox(GlobalConstants.EMAIL_ID);
		loginPage.inputPasswordTextBox(GlobalConstants.PASSWORD_ID);
		homePage = loginPage.clickLoginButtonToOpenPage();
		
		Assert.assertTrue(homePage.isSliderDisplayed());
	}
	
	@AfterClass
	public void AfterClass() {
		driver.close();
	}
}
