package com.nopcommerce.search;

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
import pageObjects.nopCommerce.SearchPageObject;

public class Search_And_Advanced_Search extends BaseTest{
	WebDriver driver;
	HomePageObject homePage;
	LoginPageObject loginPage;
	SearchPageObject searchPage;
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void BeforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManagement.getHomePage(driver);
		loginPage = homePage.clickToLoginButtonToOpen();
		loginPage.inputEmailTextBox(GlobalConstants.EMAIL_ID);
		loginPage.inputPasswordTextBox(GlobalConstants.PASSWORD_ID);
		homePage = loginPage.clickLoginButtonToOpenPage();
		
		Assert.assertTrue(homePage.isSliderDisplayed());
	}
	@Test
	public void Search_01_Empty_Data() {
		homePage.openFooterPage(driver, "Search");
		searchPage = PageGeneratorManagement.getSearchPage(driver);
		searchPage.clickSubmitButtonByName(driver, "search");
		Assert.assertTrue(searchPage.isInvalidMessageDisplayed());
	}
	@Test
	public void Search_02_Data_Search_Not_Exist() {
		searchPage.inputToSearchTextBox("iPad 2050");
		searchPage.clickSubmitButtonByName(driver, "search");
		Assert.assertTrue(searchPage.isNoDataErrorMessageDisplayed());
	}
	@Test
	public void Search_03_Search_With_Contain_ProductName() {
		searchPage.inputToSearchTextBox("Lenovo");
		searchPage.clickSubmitButtonByName(driver, "search");
		Assert.assertEquals(searchPage.getNumberOfProduct("Lenovo"),2);
		Assert.assertTrue(searchPage.isProductResultContainsTextSearchByName("Lenovo"));
	}
	
	@AfterClass
	public void AfterClass() {
		driver.quit();
	}
}
