package pageObjects.sauceDemo;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.sauce.LoginPageUI;
import pageUIs.sauce.ProductPageUI;

public class ProductPO extends BasePage{
	private WebDriver driver;
	
	public ProductPO (WebDriver driver) {
		this.driver = driver;
	}

	public void selectSortByText(String sortBy) {
		waitForElementClickable(driver, ProductPageUI.SORT_BY_OPTION, sortBy);
		selectDropDownByText(driver, ProductPageUI.SORT_BY_OPTION, sortBy);
	}

	public boolean isProductNameSortedByAscending() {
		return isDataStringSortByASC_sauce(driver, ProductPageUI.PRODUCT_TITLE_NAME);
	}

	public boolean isProductNameSortedByDescending() {
		return isDataStringSortByDESC_sauce(driver, ProductPageUI.PRODUCT_TITLE_NAME);
	}

	public boolean isProductPriceSortedByAscending() {
		return isDataFloatSortByASC_sauce(driver, ProductPageUI.PRODUCT_PRICE);
	}

	public boolean isProductPriceSortedByDescending() {
		return isDataFloatSortByDESC_sauce(driver, ProductPageUI.PRODUCT_PRICE);
	}
		
}
