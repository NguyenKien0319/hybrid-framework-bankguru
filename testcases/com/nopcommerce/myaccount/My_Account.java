package com.nopcommerce.myaccount;

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
import pageObjects.nopCommerce.MyAccountPageObject;
import pageObjects.nopCommerce.PageGeneratorManagement;

public class My_Account extends BaseTest{
	WebDriver driver;
	HomePageObject homePage;
	LoginPageObject loginPage;
	MyAccountPageObject myAccountPage;
	String oldPassword, newPassword;
	@Parameters({"browser", "url"})
	@BeforeClass
	public void BeforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		oldPassword = "123123";
		newPassword = "456789";
		homePage = PageGeneratorManagement.getHomePage(driver);
		loginPage = homePage.clickToLoginButtonToOpen();
		loginPage.inputEmailTextBox(GlobalConstants.EMAIL_ID);
		loginPage.inputPasswordTextBox(oldPassword);
		homePage = loginPage.clickLoginButtonToOpenPage();
		
		Assert.assertTrue(homePage.isSliderDisplayed());
	}
	
	@Test
	public void MyAccount_01_Update_Customer_Info() {
		myAccountPage = homePage.openMyAccountPage(driver);
		myAccountPage.selectFemaleRadioButton();
		myAccountPage.updateTexBoxByName("FirstName","testing");
		myAccountPage.updateTexBoxByName("LastName","forum");
		myAccountPage.updateTexBoxByName("Company","Apple");
		myAccountPage.updateBirthdate("Day","19");
		myAccountPage.updateBirthdate("Month","March");
		myAccountPage.updateBirthdate("Year","1999");
		myAccountPage.clickToSaveButton();
		
		Assert.assertTrue(myAccountPage.isFemaleRadioButtonSelected());
		Assert.assertEquals(myAccountPage.isTextBoxByNameUpdated("FirstName"),"testing");
		Assert.assertEquals(myAccountPage.isTextBoxByNameUpdated("LastName"),"forum");
		Assert.assertEquals(myAccountPage.isTextBoxByNameUpdated("Company"),"Apple");
		Assert.assertEquals(myAccountPage.isBirthdateUpdated("Day"),"19");
		Assert.assertEquals(myAccountPage.isBirthdateUpdated("Month"),"March");
		Assert.assertEquals(myAccountPage.isBirthdateUpdated("Year"),"1999");
	}
	@Test 
	public void MyAccount_02_Add_New_Address() {
		myAccountPage.goToLinkName("Addresses");
		myAccountPage.addNewAddressInfor();
		myAccountPage.inputTextBoxByName("FirstName","selenium");
		myAccountPage.inputTextBoxByName("LastName","testing");
		myAccountPage.inputTextBoxByName("Email",GlobalConstants.EMAIL_ID);
		myAccountPage.selectCountryDropDownList("Viet Nam");
		myAccountPage.inputTextBoxByName("City","Da Nang");
		myAccountPage.inputTextBoxByName("Address1","Cam Le");
		myAccountPage.inputTextBoxByName("ZipPostalCode","654321");
		myAccountPage.inputTextBoxByName("PhoneNumber","0123456789");
		myAccountPage.clickSaveButton();
		//myAccountPage = PageGeneratorManagement.getMyAccountPage(driver);
		Assert.assertTrue(myAccountPage.isNewInfoAccountDisplayed("selenium" + " " + "testing",GlobalConstants.EMAIL_ID," 0123456789","Cam Le","Da Nang," + " "+"654321","Viet Nam"));
		myAccountPage.deleteInfoAccount();
		Assert.assertTrue(myAccountPage.isNoDataDisplayed());
	}
	@Test
	public void MyAccount_03_Change_Password() {
		myAccountPage.goToLinkName("Change password");
		myAccountPage.inputToChangePassword("Old",oldPassword);
		myAccountPage.inputToChangePassword("New",newPassword);
		myAccountPage.inputToChangePassword("ConfirmNew",newPassword);
		Assert.assertTrue(myAccountPage.inputPasswordChangeSuccess());
		homePage = myAccountPage.clickToLogoutButton();
		
		loginPage = homePage.clickToLoginButtonToOpen();
		loginPage.inputEmailTextBox(GlobalConstants.EMAIL_ID);
		loginPage.inputPasswordTextBox(oldPassword);
		loginPage.clickLoginButton();
		Assert.assertTrue(loginPage.isErrorMessageDisplayed(driver, "The credentials provided are incorrect"));
		loginPage.inputPasswordTextBox(newPassword);
		homePage = loginPage.clickLoginButtonToOpenPage();
	}
	@Test
	public void MyAccount_04_Verify_Add_Review() {
		homePage.clickToProductByName("Build your own computer");
		homePage.clickToAddReviewTextLink();
		homePage.inputReviewTitle("Review Title");
		homePage.inputReviewContent("This is content");
		homePage.clickRatingRadioButton("Good");
		homePage.clickSubmitReviewButton();
		Assert.assertTrue(homePage.isAddReviewMessageSuccessDisplayed());
		myAccountPage = homePage.openMyAccountPage(driver);
		myAccountPage.goToLinkName("My product reviews");
		Assert.assertTrue(myAccountPage.isReviewProductByNameDisplayed("Review Title","80%","This is content","Build your own computer"));
	}
	
	@AfterClass
	public void AfterClass() {
		driver.quit();
	}
}
