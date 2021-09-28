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
	String containsProductName, fullProductName;
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void BeforeClass(String browserName, String appUrl) {
		containsProductName = "Lenovo";
		fullProductName = "Thinkpad X1 Carbon";
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
		searchPage.inputToSearchTextBox(containsProductName);
		searchPage.clickSubmitButtonByName(driver, "search");
		Assert.assertEquals(searchPage.getNumberOfProduct(containsProductName),2);
		Assert.assertTrue(searchPage.isProductResultContainsTextSearchByName(containsProductName));
	}
	@Test
	public void Search_04_Search_With_Full_ProductName() {
		searchPage.inputToSearchTextBox(fullProductName);
		searchPage.clickSubmitButtonByName(driver, "search");
		Assert.assertEquals(searchPage.getNumberOfProduct(fullProductName),1);
		Assert.assertEquals(searchPage.getProductNameSearchByName(fullProductName),"Lenovo Thinkpad X1 Carbon Laptop");
	}
	@Test
	public void Search_05_Advanced_Search_With_Parents_Categories() {
		searchPage.getRefreshPage(driver);
		searchPage.inputToSearchTextBox("Apple MacBook Pro");
		searchPage.clickToCheckBoxByName("Advanced search");
		searchPage.selectCategoriesDropDownList("Computers");
		searchPage.clickSubmitButtonByName(driver, "search");
		Assert.assertTrue(searchPage.isNoDataErrorMessageDisplayed());
	}
	@Test
	public void Search_06_Advanced_Search_With_Sub_Categories() {
		searchPage.openFooterPage(driver, "Search");
		searchPage.inputToSearchTextBox("Apple MacBook Pro");
		searchPage.clickToCheckBoxByName("Advanced search");
		searchPage.selectCategoriesDropDownList("Computers");
		searchPage.clickToCheckBoxByName("Automatically search sub categories");
		searchPage.clickSubmitButtonByName(driver, "search");
		Assert.assertEquals(searchPage.getNumberOfProduct("Apple MacBook Pro"),1);
		Assert.assertEquals(searchPage.getProductNameSearchByName("Apple MacBook Pro"),"Apple MacBook Pro 13-inch");
	}
	@Test
	public void Search_07_Advanced_Search_With_Incorrect_Manufacturer() {
		searchPage.openFooterPage(driver, "Search");
		searchPage.inputToSearchTextBox("Apple MacBook Pro");
		searchPage.clickToCheckBoxByName("Advanced search");
		searchPage.selectCategoriesDropDownList("Computers");
		searchPage.clickToCheckBoxByName("Automatically search sub categories");
		searchPage.selectManufacturerDropDownList("HP");
		searchPage.clickSubmitButtonByName(driver, "search");
		Assert.assertTrue(searchPage.isNoDataErrorMessageDisplayed());
	}
	@Test
	public void Search_08_Advanced_Search_With_Correct_Manufacturer() {
		searchPage.openFooterPage(driver, "Search");
		searchPage.inputToSearchTextBox("Apple MacBook Pro");
		searchPage.clickToCheckBoxByName("Advanced search");
		searchPage.selectCategoriesDropDownList("Computers");
		searchPage.clickToCheckBoxByName("Automatically search sub categories");
		searchPage.selectManufacturerDropDownList("Apple");
		searchPage.clickSubmitButtonByName(driver, "search");
		Assert.assertEquals(searchPage.getNumberOfProduct("Apple MacBook Pro"),1);
		Assert.assertEquals(searchPage.getProductNameSearchByName("Apple MacBook Pro"),"Apple MacBook Pro 13-inch");
	}
	@AfterClass
	public void AfterClass() {
		driver.quit();
	}
}
