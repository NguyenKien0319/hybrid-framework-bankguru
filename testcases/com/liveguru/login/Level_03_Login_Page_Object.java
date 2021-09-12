package com.liveguru.login;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.liveGuru.HomePageObject;
import pageObjects.liveGuru.LoginPageObject;
import pageObjects.liveGuru.MyDashBoardPageObject;

public class Level_03_Login_Page_Object {
	HomePageObject homePage;
	LoginPageObject loginPage;
	MyDashBoardPageObject myDashBoardPage;
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String emailAddress, password;

	@BeforeClass
	public void initBrowser() {
		emailAddress = "automation@gmail.com";
		password = "123123";

		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void Login_01_Empty_Username_Password() {
		driver.get("http://live.demoguru99.com/");
		homePage = new HomePageObject(driver);
		homePage.clickToMyAccountLink();

		loginPage = new LoginPageObject(driver);
		loginPage.loginToSystem(driver, "", "");

		Assert.assertEquals(loginPage.get_Empty_Error_Email_Message(), "This is a required field.");
		Assert.assertEquals(loginPage.get_Empty_Error_Password_Message(), "This is a required field.");
	}

	@Test
	public void Login_02_Invalid_Email() {
		loginPage.getRefreshPage(driver);
		loginPage.loginToSystem(driver, "123@123.12", password);

		Assert.assertEquals(loginPage.get_Invalid_Error_Email_Message(),
				"Please enter a valid email address. For example johndoe@domain.com.");
	}

	@Test
	public void Login_03_Invalid_Password() {
		loginPage.getRefreshPage(driver);
		loginPage.loginToSystem(driver, emailAddress, "123");

		Assert.assertEquals(loginPage.get_Invalid_Error_Password_Message(),
				"Please enter 6 or more characters without leading or trailing spaces.");
	}

	@Test
	public void Login_04_Incorrect_Email() {
		loginPage.getRefreshPage(driver);
		loginPage.loginToSystem(driver, "autoemail99999@hotmail.net", password);

		Assert.assertTrue(loginPage.isIncorrectMessageDisplayed());
	}

	@Test
	public void Login_05_Incorrect_Password() {
		loginPage.getRefreshPage(driver);
		loginPage.loginToSystem(driver, emailAddress, "123456");

		Assert.assertTrue(loginPage.isIncorrectMessageDisplayed());
	}

	@Test
	public void Login_06_Login_Success() {
		loginPage.getRefreshPage(driver);
		loginPage.loginToSystem(driver, emailAddress, password);

		myDashBoardPage = new MyDashBoardPageObject(driver);
		Assert.assertTrue(myDashBoardPage.isTextHeaderDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public String getEmailRandom() {
		Random rand = new Random();
		return "autotesting" + rand.nextInt(999999) + "@hotmail.net";
	}
}
