package com.nopcommerce.admin;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.admin.nopCommerce.DashBoardPO;
import pageObjects.admin.nopCommerce.EditProductPO;
import pageObjects.admin.nopCommerce.LoginPageObject;
import pageObjects.admin.nopCommerce.PageGeneratorManager;
import pageObjects.admin.nopCommerce.ProductPO;

public class Level_10_Upload_File extends BaseTest {
	WebDriver driver;
	LoginPageObject loginPage;
	DashBoardPO dashboardPage;
	ProductPO productPage;
	EditProductPO editProductPage;
	String ProductName, imageName;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void initBrowser(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		ProductName = "Adobe Photoshop CS4";
		imageName = "image_3.jpg";
	}

	@Test
	public void Upload_File() {
		loginPage = PageGeneratorManager.getLoginPage(driver);
		dashboardPage = loginPage.loginToPage("admin@yourstore.com", "admin");
		dashboardPage.goToPageByMenuBar("Catalog", "Products");
		productPage = PageGeneratorManager.getProductPage(driver);
		productPage.searchProductByName(ProductName);
		Assert.assertTrue(productPage.isSearchProductByNameDisplayed(ProductName, "AD_CS4_PH", "75"));
		productPage.clickToEditProduct(ProductName);
		editProductPage = PageGeneratorManager.getEditProductPage(driver);
		editProductPage.openSubTabByCardTitle("Pictures");
		editProductPage.upLoadProductImageByCardTitle("Pictures", imageName);
		Assert.assertTrue(editProductPage.isImageUploadDisplayed(imageName));
		editProductPage.inputAllAttributesTextBox("abc", "NameTitle", "1");
		Assert.assertTrue(editProductPage.isNewInfoImageDisplayed(ProductName, "1", "abc", "NameTitle"));
		editProductPage.clickToSaveButton();
	}
}
