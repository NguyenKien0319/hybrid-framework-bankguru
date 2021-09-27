package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.MyAccountPageUI;

public class MyAccountPageObject extends BasePage{
	private WebDriver driver;
	public MyAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void selectFemaleRadioButton() {
		waitForElementClickable(driver, MyAccountPageUI.FEMALE_RADIO_BUTTON);
		checkTheCheckBoxOrRadio(driver, MyAccountPageUI.FEMALE_RADIO_BUTTON);
	}
	
	public void updateBirthdate(String params, String item) {
		waitForElementClickable(driver, MyAccountPageUI.DATEOFBIRTH_DROPDOWN_LIST, params);
		selectDropDownByText(driver, MyAccountPageUI.DATEOFBIRTH_DROPDOWN_LIST, item, params);
	}
	
	public void updateTexBoxByName(String fieldName, String value) {
		waitForElementVisible(driver, MyAccountPageUI.TEXTBOX_BY_NAME, fieldName);
		sendkeysToElement(driver, MyAccountPageUI.TEXTBOX_BY_NAME, value, fieldName);
	}
	public boolean isFemaleRadioButtonSelected() {
		waitForElementClickable(driver, MyAccountPageUI.FEMALE_RADIO_BUTTON);
		return isElementSelected(driver, MyAccountPageUI.FEMALE_RADIO_BUTTON);
	}
	public String isTextBoxByNameUpdated(String fieldName) {
		waitForElementVisible(driver, MyAccountPageUI.TEXTBOX_BY_NAME, fieldName);
		return getAttributeValue(driver,MyAccountPageUI.TEXTBOX_BY_NAME, "value",fieldName);
	}
	public String isBirthdateUpdated(String params) {
		waitForElementVisible(driver, MyAccountPageUI.DATEOFBIRTH_DROPDOWN_LIST, params);
		return getTextDropDownList(driver, MyAccountPageUI.DATEOFBIRTH_DROPDOWN_LIST, params);
	}
	public void clickToSaveButton() {
		waitForElementClickable(driver, MyAccountPageUI.SAVE_BUTTON);
		clickToElement(driver, MyAccountPageUI.SAVE_BUTTON);
	}
	
	//Add new address
	public void goToLinkName(String nameLink) {
		waitForElementClickable(driver, MyAccountPageUI.LEFT_MENU_LINK, nameLink);
		clickToElement(driver, MyAccountPageUI.LEFT_MENU_LINK, nameLink);
		
	}	
	public void addNewAddressInfor() {
		waitForElementClickable(driver, MyAccountPageUI.ADDRESSES_ADD_NEW_BUTTON);
		clickToElement(driver, MyAccountPageUI.ADDRESSES_ADD_NEW_BUTTON);
	}
	public void inputTextBoxByName(String fieldName, String value) {
		waitForElementVisible(driver, MyAccountPageUI.ADDRESSES_TEXTBOX_BY_NAME, fieldName);
		sendkeysToElement(driver, MyAccountPageUI.ADDRESSES_TEXTBOX_BY_NAME, value, fieldName);
	}
	public void selectCountryDropDownList(String countryName) {
		waitForElementClickable(driver, MyAccountPageUI.ADDRESSES_TEXTBOX_COUNTRY);
		selectDropDownByText(driver, MyAccountPageUI.ADDRESSES_TEXTBOX_COUNTRY, countryName);
	}
	public void clickSaveButton() {
		waitForElementClickable(driver, MyAccountPageUI.ADDRESSES_SAVE_BUTTON);
		clickToElement(driver, MyAccountPageUI.ADDRESSES_SAVE_BUTTON);
		sleepInMiliSecond(1000);
	}
	public boolean isNewInfoAccountDisplayed(String name, String email, String phone, String address1, String zipCodeCity, String country) {
		waitForElementVisible(driver, MyAccountPageUI.ADDRESSES_VERIFY_INFOR, name, email, phone, address1, zipCodeCity, country);
		return isElementDisplayed(driver, MyAccountPageUI.ADDRESSES_VERIFY_INFOR, name, email, phone, address1, zipCodeCity, country);
	}
	public void deleteInfoAccount() {
		waitForElementClickable(driver, MyAccountPageUI.ADDRESSED_DELETE_BUTTON);
		clickToElement(driver, MyAccountPageUI.ADDRESSED_DELETE_BUTTON);
		aceptAlert(driver);
	}
	public boolean isNoDataDisplayed() {
		waitForElementVisible(driver, MyAccountPageUI.ADDRESSES_NO_DATA_TEXT);
		return isElementDisplayed(driver, MyAccountPageUI.ADDRESSES_NO_DATA_TEXT);
	}
	public void inputToChangePassword(String fieldName, String value) {
		waitForElementVisible(driver, MyAccountPageUI.CHANGE_PASSWORD_TEXTBOX, fieldName);
		sendkeysToElement(driver, MyAccountPageUI.CHANGE_PASSWORD_TEXTBOX, value, fieldName);	
	}
	public boolean inputPasswordChangeSuccess() {
		waitForElementClickable(driver, MyAccountPageUI.CHANGE_PASSWORD_SAVE_BUTTON);
		clickToElement(driver, MyAccountPageUI.CHANGE_PASSWORD_SAVE_BUTTON);
		waitForElementVisible(driver, MyAccountPageUI.CHANGE_PASSWORD_SUCCESS_TEXT);
		return isElementDisplayed(driver, MyAccountPageUI.CHANGE_PASSWORD_SUCCESS_TEXT);
	}
	public HomePageObject clickToLogoutButton() {
		waitForElementClickable(driver, MyAccountPageUI.CHANGE_PASSWORD_CLOSE_BUTTON);
		clickToElement(driver, MyAccountPageUI.CHANGE_PASSWORD_CLOSE_BUTTON);
		waitForElementInvisible(driver, MyAccountPageUI.CHANGE_PASSWORD_CLOSE_BUTTON);
		//sleepInMiliSecond(1000);
		waitForElementClickable(driver, MyAccountPageUI.LOGOUT_LINK);
		clickToElement(driver, MyAccountPageUI.LOGOUT_LINK);
		return PageGeneratorManagement.getHomePage(driver);
	}
	public boolean isReviewProductByNameDisplayed(String reviewTitle, String rating, String reviewContent, String productName) {
		waitForElementVisible(driver, MyAccountPageUI.VERIFY_PRODUCTS_REVIEW_SUCCESS, reviewTitle, rating, reviewContent, productName);
		return isElementDisplayed(driver, MyAccountPageUI.VERIFY_PRODUCTS_REVIEW_SUCCESS, reviewTitle, rating, reviewContent, productName);
	}
	
}
