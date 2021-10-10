package com.demonopcommerce.login;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register_And_Login;

import commons.BaseTest;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;
import pageObjects.nopCommerce.MyAccountPageObject;
import pageObjects.nopCommerce.PageGeneratorManagement;
import pageObjects.nopCommerce.RegisterPageObject;

public class Level_14_Register_Login_Page_Share_State extends BaseTest {
	private WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String emailAddress, password;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void BeforeClass(String browserName, String url) {
		log.info("Init Browser '" + browserName + "' and Open appUrl '" + url + "'");
		driver = getBrowserDriver(browserName, url);
		emailAddress = getEmailRandom();
		password = "123123";

		homePage = PageGeneratorManagement.getHomePage(driver);

		log.info("Pre-condition - Step_01: Set Cookies Login");
		homePage.SetAllCookies(driver, Common_01_Register_And_Login.loginCookies);
		homePage.sleepInMiliSecond(2000);
		homePage.getRefreshPage(driver);
	}

	@Test
	public void Login_01_Register_To_System() {

		log.info("User_Login_01: Verify Sider Homepage display");
		verifyTrue(homePage.isSliderDisplayed());
	}

	@Test
	public void Login_02_Login_To_System() {

		homePage.clickLogoutButton();
		homePage.sleepInMiliSecond(5000);
	}

	@AfterClass(alwaysRun = true)
	public void AfterClass() {
		closeBrowserAndDriver();
	}

	HomePageObject homePage;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;
	MyAccountPageObject myAccountPage;

}