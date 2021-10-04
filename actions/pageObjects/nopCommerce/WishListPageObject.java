package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.WishListPageUI;

public class WishListPageObject extends BasePage{
	WebDriver driver;
	public WishListPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public boolean isInfoByNameDisplayed(String productName, String SKU, String price, String quatity) {
		waitForElementVisible(driver, WishListPageUI.INFOR_PRODUCT_BY_NAME, productName, SKU, price, quatity);
		return isElementDisplayed(driver, WishListPageUI.INFOR_PRODUCT_BY_NAME, productName, SKU, price, quatity);
	}
	public void clickWishListLinkSharing() {
		waitForElementClickable(driver, WishListPageUI.MY_WISHLIST_URL);
		clickToElement(driver, WishListPageUI.MY_WISHLIST_URL);
	}
	public boolean isMyWishListTitleDisplayed() {
		waitForElementVisible(driver, WishListPageUI.MY_WISHLIST_TITLE);
		return isElementDisplayed(driver, WishListPageUI.MY_WISHLIST_TITLE);
	}
	public String getItemQuatity(String headerName) {
		waitForElementVisible(driver, WishListPageUI.ITEM_QUALITY, headerName);
		return getTextElement(driver, WishListPageUI.ITEM_QUALITY, headerName);
	}
}
