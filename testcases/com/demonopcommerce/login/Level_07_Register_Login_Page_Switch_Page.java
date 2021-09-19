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

public class Level_07_Register_Login_Page_Switch_Page extends BaseTest{
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
		loginPage = homePage.clickToLoginButtonToOpen();

		loginPage.inputEmailTextBox(emailAddress);
		loginPage.inputPasswordTextBox(password);
		
		homePage = loginPage.clickLoginButtonToOpenPage();
		System.out.println(homePage.hashCode());

		Assert.assertTrue(homePage.isSliderDisplayed());
		//homePage.clickLogoutButton();
	}
	
	@Test
	public void Login_03_Switch_Page() {

		//Homepage > Myaccount 
		myAccountPage = homePage.openMyAccountPage(driver);
		
		//Myaccount > Sitemap
		siteMapPage = myAccountPage.openSiteMapPage(driver);

		//Sitemap > Search
		searchPage = siteMapPage.openSearchPage(driver);
		
		//Search > News
		newsPage = searchPage.openNewsPage(driver);
		
		//News > Whitelist
		wishListPage = newsPage.openWishListPage(driver);
		
		//Whitelisrt > Sitemap
		siteMapPage = wishListPage.openSiteMapPage(driver);
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