package com.jQuery.datatable;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jQuery.HomePO;
import pageObjects.jQuery.PageGeneratorManager;

public class Level_09_Data_Table2 extends BaseTest {
	WebDriver driver;
	HomePO homePage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void initBrowser(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
	}

	@Test
	public void Table_01_Input_To_Row_TextBox() {
		homePage = PageGeneratorManager.getHomePage(driver);
		homePage.inputToRowTextBoxByRow("Contact Person","3","123");
		homePage.inputToRowTextBoxByRow("Order Placed","2","abc");
		homePage.inputToRowTextBoxByRow("Company","1","Codecomplete");
	}
	@Test
	public void Table_02_Click_Icon() {
		homePage.actionToUpdateTable("3","Move Up");
		homePage.actionToUpdateTable("1","Move Down");
		homePage.actionToUpdateTable("2","Insert Row Above");
	}
	@AfterClass
	public void AfterClass() {
		driver.quit();
	}
}
