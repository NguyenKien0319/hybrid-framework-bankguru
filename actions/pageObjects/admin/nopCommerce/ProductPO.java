package pageObjects.admin.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.admin.nopCommerce.DashBoardUI;
import pageUIs.admin.nopCommerce.ProductUI;

public class ProductPO extends BasePage{
	private WebDriver driver;
	
	public ProductPO(WebDriver driver) {
		this.driver = driver;
	}

	public void goToPageByMenuBar(String bigCategories, String middleCategories) {
		waitForElementClickable(driver, DashBoardUI.BIG_CATEGORIES, bigCategories);
		clickToElement(driver, DashBoardUI.BIG_CATEGORIES, bigCategories);
		waitForElementClickable(driver, DashBoardUI.MIDDLE_CATEGORIES, middleCategories);
		clickToElement(driver, DashBoardUI.MIDDLE_CATEGORIES, middleCategories);
	}

	public void searchProductByName(String productName) {
		//waitForElementClickable(driver, ProductUI.SEARCH_FIELD);
		//clickToElement(driver, ProductUI.SEARCH_FIELD);
		waitForElementVisible(driver, ProductUI.PRODUCT_NAME_TEXTBOX);
		sendkeysToElement(driver, ProductUI.PRODUCT_NAME_TEXTBOX, productName);
		waitForElementClickable(driver, ProductUI.SEARCH_BUTTON);
		clickToElement(driver, ProductUI.SEARCH_BUTTON);
	}

	public boolean isSearchProductByNameDisplayed(String productName, String SKU, String price) {
		waitForElementVisible(driver, ProductUI.INFOR_PRODUCT_SEARCH_BY_NAME, productName, SKU, price);
		return isElementDisplayed(driver, ProductUI.INFOR_PRODUCT_SEARCH_BY_NAME, productName, SKU, price);
	}

	public void clickToEditProduct(String productName) {
		waitForElementClickable(driver, ProductUI.EDIT_BUTTON_GET_BY_PRODUCT_NAME, productName);
		clickToElement(driver, ProductUI.EDIT_BUTTON_GET_BY_PRODUCT_NAME, productName);
	}
	
}
