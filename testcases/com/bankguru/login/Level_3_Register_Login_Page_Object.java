package com.bankguru.login;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.bankGuru.HomePageObject;
import pageObjects.bankGuru.LoginPageObject;
import pageObjects.bankGuru.RegisterPageObject;

public class Level_3_Register_Login_Page_Object {
	HomePageObject homePage;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String userID, passwordID, emailAddress;

	@BeforeClass
	public void beforeClass() {
		emailAddress = getEmailRandom();
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@BeforeMethod
	public void BeforeMethod() {
		driver.get("http://demo.guru99.com/v4/");
		loginPage = new LoginPageObject(driver);
		Assert.assertTrue(loginPage.isTextDemoSiteDisplayed());
	}

	@Test
	public void Login_01_Register_Account() {

		loginPage.clickToHereLink();
		registerPage = new RegisterPageObject(driver);
		registerPage.inputToEmailTextBox(emailAddress);
		registerPage.clickSumbitButton();
		userID = registerPage.getUserInfor();
		passwordID = registerPage.getPasswordInfor();
	}

	@Test
	public void Login_02_Login_To_System() {
		loginPage.inputToEmailTextBox(userID);
		loginPage.inputToPasswordTextBox(passwordID);
		loginPage.clickLoginButton();

		homePage = new HomePageObject(driver);
		Assert.assertTrue(homePage.isTextWelcomeDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public String getEmailRandom() {
		Random rand = new Random();
		return "automation" + rand.nextInt(999999) + "@hotmail.net";
	}
}
