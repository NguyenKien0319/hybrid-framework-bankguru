package pageObjects.nopCommerce;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.nopCommerce.SearchPageUI;

public class SearchPageObject extends BasePage{
	WebDriver driver;
	public SearchPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public boolean isInvalidMessageDisplayed() {
		waitForElementVisible(driver, SearchPageUI.INVALID_ERROR_MESSAGE_SEARCH);
		return isElementDisplayed(driver, SearchPageUI.INVALID_ERROR_MESSAGE_SEARCH);
	}
	public void inputToSearchTextBox(String value) {
		waitForElementVisible(driver, SearchPageUI.SEARCH_TEXTBOX);
		sendkeysToElement(driver, SearchPageUI.SEARCH_TEXTBOX, value);
	}
	public boolean isNoDataErrorMessageDisplayed() {
		waitForElementVisible(driver, SearchPageUI.NO_DATA_MESSAGE_SEARCH);
		return isElementDisplayed(driver, SearchPageUI.NO_DATA_MESSAGE_SEARCH);
	}
	public int getNumberOfProduct(String productName) {
		waitForAllElementsVisible(driver, SearchPageUI.SEARCH_RESULT_BY_NAME,productName);
		return getElementSize(driver, SearchPageUI.SEARCH_RESULT_BY_NAME,productName);
	}
	public boolean isProductResultContainsTextSearchByName(String searchText) {
		waitForAllElementsVisible(driver, SearchPageUI.SEARCH_RESULT_BY_NAME,searchText);
		List<WebElement> allProducts = getElements(driver, SearchPageUI.SEARCH_RESULT_BY_NAME,searchText);
		for (WebElement product : allProducts) {
			product.getText().contains(searchText);
		}
		return true;
	}
	public String getProductNameSearchByName(String searchText) {
		waitForElementVisible(driver, SearchPageUI.SEARCH_RESULT_BY_NAME, searchText);
		return getTextElement(driver, SearchPageUI.SEARCH_RESULT_BY_NAME, searchText);
	}
	public void clickToCheckBoxByName(String checkBoxName) {
		waitForElementClickable(driver, SearchPageUI.SEARCH_CHECKBOX_BYNAME, checkBoxName);
		checkTheCheckBoxOrRadio(driver, SearchPageUI.SEARCH_CHECKBOX_BYNAME, checkBoxName);	
	}
	public void selectCategoriesDropDownList(String item) {
		waitForElementClickable(driver, SearchPageUI.SEARCH_CATEGORIES_DROPDOWN_LIST, item);
		selectDropDownByText(driver, SearchPageUI.SEARCH_CATEGORIES_DROPDOWN_LIST, item);
	}
	public void selectManufacturerDropDownList(String item) {
		waitForElementClickable(driver, SearchPageUI.SEARCH_MANUFACTURER_DROPDOWN_LIST, item);
		selectDropDownByText(driver, SearchPageUI.SEARCH_MANUFACTURER_DROPDOWN_LIST, item);
	}

}
