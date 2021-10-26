package com.saucedemo.sort;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.sauceDemo.LoginPO;
import pageObjects.sauceDemo.PageGeneratorManager;
import pageObjects.sauceDemo.ProductPO;

public class Level_17_Sort_Displaying extends BaseTest{
	private WebDriver driver;
	private LoginPO loginPage;
	private ProductPO productPage;
	String username, password;
	
	
	@Parameters({"browser", "url"})
	@BeforeTest
	public void BeforeTest(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		username = "standard_user";
		password = "secret_sauce";
		
		loginPage = PageGeneratorManager.getLoginPage(driver);
		loginPage.inpuTextBoxByID("user-name", username);
		loginPage.inpuTextBoxByID("password", password);
		loginPage.clickLogin();
		
		productPage = PageGeneratorManager.getProductPage(driver);
	}
	
	@Test
	public void Sort_Displaying_01_Sort_From_A_to_Z() {
		productPage.selectSortByText("Name (A to Z)");
		verifyTrue(productPage.isProductNameSortedByAscending());
	}
	
	@Test
	public void Sort_Displaying_02_Sort_From_Z_to_A() {
		productPage.selectSortByText("Name (Z to A)");
		verifyTrue(productPage.isProductNameSortedByDescending());
	}
	
	@Test
	public void Sort_Displaying_03_Sort_From_Low_to_High() {
		productPage.selectSortByText("Price (low to high)");
		verifyTrue(productPage.isProductPriceSortedByAscending());
	}
	
	@Test
	public void Sort_Displaying_04_Sort_From_High_to_Low() {
		productPage.selectSortByText("Price (high to low)");
		verifyTrue(productPage.isProductPriceSortedByDescending());
	}
	
	@AfterClass
	public void AfterClass() {
		driver.quit();
	}
	
}
