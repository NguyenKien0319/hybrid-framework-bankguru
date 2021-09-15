package com.nopcommerce.login;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;
import pageObjects.nopCommerce.PageGeneratorManagement;
import pageObjects.nopCommerce.RegisterPageObject;

public class Level_06_Register_Login_PageGeneratorManagement extends BaseTest{
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String emailAddress, password;
	
	@Parameters ({"browser", "url"})
	@BeforeClass
	public void BeforeClass(String browserName, String url) {
		
		driver  = getBrowserDriver(browserName, url);
		
		emailAddress = getEmailRandom();
		password = "123123";
	}
	
	@Test
	public void Login_01_Register_To_System() {
		homePage  = PageGeneratorManagement.getHomePage(driver);
		System.out.println(homePage.hashCode());
		Assert.assertTrue(homePage.isSliderDisplayed());
		
		registerPage = homePage.clickToRegisterLink();

		Assert.assertTrue(registerPage.isTextRegisterDisplayed());
		registerPage.clickToGenderMaleRadioButton();
		registerPage.inputFirstNameTextBox("Automation");
		registerPage.inputLastNameTextBox("Testing");
		registerPage.inputEmailTextBox(emailAddress);
		registerPage.inputPasswordTextBox(password);
		registerPage.inputConfirmPasswordTextBox(password);
		registerPage.clickRegisterButton();
		
		Assert.assertTrue(registerPage.isSuccesedMessageDisplayed());
		
		homePage = registerPage.clickToLogoutButton();	
		System.out.println(homePage.hashCode());
		
		Assert.assertTrue(homePage.isSliderDisplayed());
	}
	
	@Test
	public void Login_02_Login_To_System() {
		loginPage = homePage.clickToLoginButton();

		loginPage.inputEmailTextBox(emailAddress);
		loginPage.inputPasswordTextBox(password);
		
		homePage = loginPage.clickLoginButton();
		System.out.println(homePage.hashCode());

		Assert.assertTrue(homePage.isSliderDisplayed());
	}
	
	@AfterClass
	public void AfterClass() {
		driver.close();
	}
	
	public String getEmailRandom() {
		Random rand = new Random();
		return "testing" + rand.nextInt(999999) + "@hotmail.net";
	}
	HomePageObject homePage;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;
	
}