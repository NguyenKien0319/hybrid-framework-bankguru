package com.nopcommerce.sort;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.PageGeneratorManagement;

public class Sort_Display_Paging extends BaseTest{
	private WebDriver driver;
	HomePageObject homePage;
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void BeforeClass(String browserName, String urlNopcommerce) {
		driver = getBrowserDriver(browserName, urlNopcommerce);
		homePage = PageGeneratorManagement.getHomePage(driver);
		homePage.openHeaderMenuNotMobile(driver, "Computers", "Notebooks");
	}

	@Test
	public void Sort_Display_Paging_01_Sort_By_Name_A_To_Z() {
		homePage.selectSortBy("Name: A to Z");
		homePage.waitProductLoadingAgain();
		Assert.assertTrue(homePage.isProductNameSortedByAscending());
	}
	@Test
	public void Sort_Display_Paging_02_Sort_By_Name_Z_To_A() {
		homePage.selectSortBy("Name: Z to A");
		homePage.waitProductLoadingAgain();
		Assert.assertTrue(homePage.isProductNameSortedByDescending());
	}
	@Test
	public void Sort_Display_Paging_03_Sort_By_Price_Low_To_High() {
		homePage.selectSortBy("Price: Low to High");
		homePage.waitProductLoadingAgain();
		Assert.assertTrue(homePage.isProductSortedByPriceLowToHigh());
	}
	@Test
	public void Sort_Display_Paging_04_Sort_By_Price_High_To_Low() {
		homePage.selectSortBy("Price: High to Low");
		homePage.waitProductLoadingAgain();
		Assert.assertTrue(homePage.isProductSortedByPriceHighToLow());
	}
	@Test
	public void Sort_Display_Paging_05_Display_With_3_Product_InPaging() {
		homePage.selectDisplayPerPaging("3");
		homePage.waitProductLoadingAgain();
		Assert.assertTrue(homePage.isDisplayAtLeastNumberProduct());
		Assert.assertTrue(homePage.isDisplayIconPagingInPage("1", "next"));
		
		homePage.navigateToNextNumber("next");
		homePage.waitProductLoadingAgain();
		Assert.assertTrue(homePage.isDisplayIconPagingInPage("2", "previous"));
	}
		@Test
		public void Sort_Display_Paging_06_Display_With_6_Product_InPaging() {
		homePage.selectDisplayPerPaging("6");
		homePage.waitProductLoadingAgain();
		Assert.assertTrue(homePage.isDisplayAtLeastNumberProduct());
		Assert.assertTrue(homePage.isNotDisplayPageNumber());
	}
		@Test
		public void Sort_Display_Paging_07_Display_With_9_Product_InPaging() {
		homePage.selectDisplayPerPaging("9");
		homePage.waitProductLoadingAgain();
		Assert.assertTrue(homePage.isDisplayAtLeastNumberProduct());
		Assert.assertTrue(homePage.isNotDisplayPageNumber());
		}
	@AfterClass
	public void AfterClass() {
		driver.quit();
	}
}
