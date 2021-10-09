package com.demonopcommerce.login;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;
import pageObjects.nopCommerce.MyAccountPageObject;
import pageObjects.nopCommerce.NewsPageObject;
import pageObjects.nopCommerce.PageGeneratorManagement;
import pageObjects.nopCommerce.RegisterPageObject;
import pageObjects.nopCommerce.SearchPageObject;
import pageObjects.nopCommerce.SiteMapPageObject;
import pageObjects.nopCommerce.WishListPageObject;

public class Level_13_Register_Login_Page_Log_ReportHTML_ExtendReport4 extends BaseTest {
	private WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String emailAddress, password;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void BeforeClass(String browserName, String url) {

		driver = getBrowserDriver(browserName, url);

		emailAddress = getEmailRandom();
		password = "123123";
	}

	@Test
	public void Login_01_Register_To_System() {
		log.info("User_Register_01: Verify go to HomePage success");
		homePage = PageGeneratorManagement.getHomePage(driver);
		Assert.assertTrue(homePage.isSliderDisplayed());

		log.info("User_Register_02: Click to RegisterLink");
		registerPage = homePage.clickToRegisterLink();

		log.info("User_Register_03: Verify title Register Page display");
		Assert.assertTrue(registerPage.isTextRegisterDisplayed());

		log.info("User_Register_04: Click to Male Gender radio button");
		registerPage.clickToGenderMaleRadioButton();

		log.info("User_Register_05: Input FirstName textbox 'Automation' ");
		registerPage.inputFirstNameTextBox("Automation");

		log.info("User_Register_06: Input LastName textbox 'Testing' ");
		registerPage.inputLastNameTextBox("Testing");

		log.info("User_Register_07: Input Email textbox'" + emailAddress + "'");
		registerPage.inputEmailTextBox(emailAddress);

		log.info("User_Register_08: Input Password textbox '" + password + "'");
		registerPage.inputPasswordTextBox(password);

		log.info("User_Register_09: Input ConfirmPassword textbox '" + password + "'");
		registerPage.inputConfirmPasswordTextBox(password);

		log.info("User_Register_10: Click Register button");
		registerPage.clickRegisterButton();

		log.info("User_Register_11: Verify message Register success display");
		Assert.assertTrue(registerPage.isSuccesedMessageDisplayed());

		log.info("User_Register_12: Click logout button");
		homePage = registerPage.clickToLogoutButton();

		log.info("User_Register_13: Verify Sider Homepage display");
		Assert.assertTrue(homePage.isSliderDisplayed());
	}

	@Test
	public void Login_02_Login_To_System() {
		log.info("User_Login_01: Go to Login screen");
		loginPage = homePage.clickToLoginButtonToOpen();

		log.info("User_Login_02: Input Email textbox '" + emailAddress + "'");
		loginPage.inputEmailTextBox(emailAddress);

		log.info("User_Login_03: Input Password textbox '" + password + "'");
		loginPage.inputPasswordTextBox(password);

		log.info("User_Login_03: click Login button");
		homePage = loginPage.clickLoginButtonToOpenPage();

		log.info("User_Login_04: Verify Slide Homepage display");
		verifyFalse(homePage.isSliderDisplayed());
		// homePage.clickLogoutButton();
	}

	@AfterClass
	public void AfterClass() {
		driver.close();
	}

	HomePageObject homePage;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;
	MyAccountPageObject myAccountPage;
	SiteMapPageObject siteMapPage;
	NewsPageObject newsPage;
	WishListPageObject wishListPage;
	SearchPageObject searchPage;

}