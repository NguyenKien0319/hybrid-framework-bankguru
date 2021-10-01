package com.jQuery.datatable;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jQuery.HomePO;
import pageObjects.jQuery.PageGeneratorManager;

public class Level_09_Data_Table extends BaseTest {
	private WebDriver driver;
	HomePO homePage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void initBrowser(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
	}

	@Test
	public void Table_01_Paging() {
		homePage = PageGeneratorManager.getHomePage(driver);
		homePage.goToPagingByNumber("5");
		Assert.assertTrue(homePage.isgoToPageSuccess("5"));

		homePage.goToPagingByNumber("10");
		Assert.assertTrue(homePage.isgoToPageSuccess("10"));

		homePage.goToPagingByNumber("3");
		Assert.assertTrue(homePage.isgoToPageSuccess("3"));
	}

	@Test
	public void Table_02_Actions() {
		// input to header text box
		homePage.inputToHeaderTextBoxByName("Brazil", "Country");
		homePage.getRefreshPage(driver);
		homePage.inputToHeaderTextBoxByName("123", "Females");
		homePage.getRefreshPage(driver);
		homePage.inputToHeaderTextBoxByName("56", "Males");
		homePage.getRefreshPage(driver);
		// Click icon
		homePage.updateRowByCountry("Algeria", "remove");
		homePage.updateRowByCountry("Aruba", "remove");
		// verify Info
		homePage.getRefreshPage(driver);
		Assert.assertTrue(homePage.isInfoDisplayCorrectly("276880", "Angola", "276472", "553353"));
		Assert.assertTrue(homePage.isInfoDisplayCorrectly("338282", "Argentina", "349238", "687522"));
	}
	@AfterClass(alwaysRun = true)
	public void AfterClass() {
		driver.quit();
	}
}
