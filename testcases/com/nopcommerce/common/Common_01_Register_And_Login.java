package com.nopcommerce.common;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;
import pageObjects.nopCommerce.PageGeneratorManagement;
import pageObjects.nopCommerce.RegisterPageObject;

public class Common_01_Register_And_Login extends BaseTest {
	private WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String emailAddress, password;
	public static Set<Cookie> loginCookies;

	@Parameters({ "browser", "url" })
	@BeforeTest
	public void BeforeClass(String browserName, String url) {
		log.info("Init Browser '" + browserName + "' and Open appUrl '" + url + "'");
		driver = getBrowserDriver(browserName, url);

		emailAddress = getEmailRandom();
		password = "123123";
	
		log.info("Register_And_Login_01: Verify go to HomePage success");
		homePage = PageGeneratorManagement.getHomePage(driver);
		Assert.assertTrue(homePage.isSliderDisplayed());

		log.info("Register_And_Login_02: Click to RegisterLink");
		registerPage = homePage.clickToRegisterLink();

		log.info("Register_And_Login_03: Verify title Register Page display");
		Assert.assertTrue(registerPage.isTextRegisterDisplayed());

		log.info("Register_And_Login_04: Click to Male Gender radio button");
		registerPage.clickToGenderMaleRadioButton();

		log.info("Register_And_Login_05: Input FirstName textbox 'Automation' ");
		registerPage.inputFirstNameTextBox("Automation");

		log.info("Register_And_Login_06: Input LastName textbox 'Testing' ");
		registerPage.inputLastNameTextBox("Testing");

		log.info("Register_And_Login_07: Input Email textbox'" + emailAddress + "'");
		registerPage.inputEmailTextBox(emailAddress);

		log.info("Register_And_Login_08: Input Password textbox '" + password + "'");
		registerPage.inputPasswordTextBox(password);

		log.info("Register_And_Login_09: Input ConfirmPassword textbox '" + password + "'");
		registerPage.inputConfirmPasswordTextBox(password);

		log.info("Register_And_Login_10: Click Register button");
		registerPage.clickRegisterButton();

		log.info("Register_And_Login_11: Verify message Register success display");
		Assert.assertTrue(registerPage.isSuccesedMessageDisplayed());

		log.info("Register_And_Login_12: Click logout button");
		homePage = registerPage.clickToLogoutButton();

		log.info("Register_And_Login_13: Verify Sider Homepage display");
		Assert.assertTrue(homePage.isSliderDisplayed());
	
		log.info("Register_And_Login_14: Go to Login screen");
		loginPage = homePage.clickToLoginButtonToOpen();

		log.info("Register_And_Login_15: Input Email textbox '" + emailAddress + "'");
		loginPage.inputEmailTextBox(emailAddress);

		log.info("Register_And_Login_16: Input Password textbox '" + password + "'");
		loginPage.inputPasswordTextBox(password);

		log.info("Register_And_Login_17: click Login button");
		homePage = loginPage.clickLoginButtonToOpenPage();

		log.info("Register_And_Login_18: getAllCookies");
		loginCookies = homePage.getAllCookies(driver); 
		
		log.info("Post Condition: Close Browser '" + browserName + "'");
		closeBrowserAndDriver();
	}

	HomePageObject homePage;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;

}