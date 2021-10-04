package com.nomcommerce.wishlist;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;
import pageObjects.nopCommerce.PageGeneratorManagement;
import pageObjects.nopCommerce.SearchPageObject;
import pageObjects.nopCommerce.ShoppingCartPageObject;
import pageObjects.nopCommerce.WishListPageObject;

public class WishList_Compare_RecentView extends BaseTest{
	private WebDriver driver;
	HomePageObject homePage;
	LoginPageObject loginPage;
	WishListPageObject wishListPage;
	String productName, quatity, sku, price;
	SearchPageObject searchPage;
	ShoppingCartPageObject shoppingCartPage;
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void BeforeClass(String browserName, String urlNopcommerce) {
		driver = getBrowserDriver(browserName, urlNopcommerce);
		homePage = PageGeneratorManagement.getHomePage(driver);
		loginPage = homePage.clickToLoginButtonToOpen();
		loginPage.inputEmailTextBox(GlobalConstants.EMAIL_ID);
		loginPage.inputPasswordTextBox(GlobalConstants.PASSWORD_ID);
		homePage = loginPage.clickLoginButtonToOpenPage();
		productName = "Apple MacBook Pro 13-inch";
		quatity = "2";
	}
	@Test
	public void WishList_Compare_RecentView_01_Add_To_WishList() {
		searchPage = homePage.searchProductByName(driver,productName);
		Assert.assertTrue(searchPage.isProductResultContainsTextSearchByName(productName));
		searchPage.clickProductNameTextLink(productName);
		sku = searchPage.getInforProductValue(driver, "sku");
		price = searchPage.getInforProductValue(driver, "product-price");
		searchPage.getProductByAction(driver,"Add to wishlist");
		Assert.assertTrue(searchPage.isAddToWishListMessageSuccessDisplayed(driver));
		wishListPage = searchPage.clickToOpenWishList(driver);
		Assert.assertTrue(wishListPage.isInfoByNameDisplayed(productName,sku,price,quatity));
		wishListPage.clickWishListLinkSharing();
		Assert.assertTrue(wishListPage.isMyWishListTitleDisplayed());
	}
	@Test
	public void WishList_Compare_RecentView_02_Add_To_Cart_From_WishList() {
		homePage = wishListPage.clickToHeaderLogo(driver);
		homePage.openFooterPage(driver,"Wishlist");
		wishListPage = PageGeneratorManagement.getWishListPage(driver);
		quatity = wishListPage.getItemQuatity("wishlist");
		wishListPage.clickAddToCartCheckBoxByProductName(driver, productName);
		wishListPage.clickWishListAcTionButton(driver, "wishlist-add-to-cart");
		Assert.assertEquals(wishListPage.getItemQuatity("cart"), quatity);
	}
}
