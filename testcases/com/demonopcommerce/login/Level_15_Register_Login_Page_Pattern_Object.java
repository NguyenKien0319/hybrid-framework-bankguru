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

public class Level_15_Register_Login_Page_Pattern_Object extends BaseTest {
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
		homePage.clickToHeaderByName(driver, "Register");
		registerPage  = PageGeneratorManagement.getRegisterPage(driver);

		log.info("User_Register_03: Verify title Register Page display");
		verifyTrue(registerPage.isTextRegisterDisplayed());

		log.info("User_Register_04: Click to Male Gender radio button");
		registerPage.clickToRadioButtonByName(driver, "Male");

		log.info("User_Register_05: Input FirstName textbox 'Automation' ");
		registerPage.inputTextBoxByID(driver, "FirstName", "Automation");

		log.info("User_Register_06: Input LastName textbox 'Testing' ");
		registerPage.inputTextBoxByID(driver, "LastName", "Testing");

		log.info("User_Register_07: Input Email textbox'" + emailAddress + "'");
		registerPage.inputTextBoxByID(driver, "Email", emailAddress);

		log.info("User_Register_08: Input Password textbox '" + password + "'");
		registerPage.inputTextBoxByID(driver, "Password", password);

		log.info("User_Register_09: Input ConfirmPassword textbox '" + password + "'");
		registerPage.inputTextBoxByID(driver, "ConfirmPassword", password);

		log.info("User_Register_10: Click Register button");
		registerPage.clickButtonByName(driver, "Register");

		log.info("User_Register_11: Verify message Register success display");
		verifyTrue(registerPage.isSuccesedMessageDisplayed());

		log.info("User_Register_12: Click logout button");
		registerPage.clickToHeaderByName(driver, "Log out");
		homePage = PageGeneratorManagement.getHomePage(driver);

		log.info("User_Register_13: Verify Sider Homepage display");
		verifyTrue(homePage.isSliderDisplayed());
	}

	@Test
	public void Login_02_Login_To_System() {
		log.info("User_Login_01: Go to Login screen");
		homePage.clickToHeaderByName(driver, "Log in");
		loginPage = PageGeneratorManagement.getLoginPage(driver);

		log.info("User_Login_02: Input Email textbox '" + emailAddress + "'");
		loginPage.inputTextBoxByID(driver, "Email", emailAddress);

		log.info("User_Login_03: Input Password textbox '" + password + "'");
		loginPage.inputTextBoxByID(driver, "Password", password);

		log.info("User_Login_03: click Login button");
		loginPage.clickButtonByName(driver, "Log in");
		homePage = PageGeneratorManagement.getHomePage(driver);

		log.info("User_Login_04: Verify Slide Homepage display");
		verifyTrue(homePage.isSliderDisplayed());
		// homePage.clickLogoutButton();
	}

	@AfterClass(alwaysRun = true)
	public void AfterClass() {
		closeBrowserAndDriver();
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