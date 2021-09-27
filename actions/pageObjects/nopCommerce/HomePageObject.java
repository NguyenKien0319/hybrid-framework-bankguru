package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.HomePageUI;

public class HomePageObject extends BasePage {
	private WebDriver driver;
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	public RegisterPageObject clickToRegisterLink() {
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		return PageGeneratorManagement.getRegisterPage(driver);
	}

	public boolean isSliderDisplayed() {
		waitForElementVisible(driver, HomePageUI.SLIDER);
		return isElementDisplayed(driver, HomePageUI.SLIDER);
	}

	public LoginPageObject clickToLoginButtonToOpen() {
		waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		return PageGeneratorManagement.getLoginPage(driver);
	}
	public void clickLogoutButton() {
		waitForElementClickable(driver, HomePageUI.LOGOUT_LINK);
		clickToElement(driver, HomePageUI.LOGOUT_LINK);
	}
	//Review Product
	public void clickToProductByName(String productName) {
		waitForElementClickable(driver, HomePageUI.FEATURES_PRODUCT_BY_NAME, productName);
		clickToElement(driver, HomePageUI.FEATURES_PRODUCT_BY_NAME, productName);	
	}
	public void clickToAddReviewTextLink() {
		waitForElementClickable(driver, HomePageUI.REVIEW_TEXTLINK);
		clickToElement(driver, HomePageUI.REVIEW_TEXTLINK);
	}
	public void inputReviewTitle(String title) {
		waitForElementClickable(driver, HomePageUI.REVIEW_TITLE_TEXTBOX);
		sendkeysToElement(driver, HomePageUI.REVIEW_TITLE_TEXTBOX,title);
	}
	public void inputReviewContent(String content) {
		waitForElementClickable(driver, HomePageUI.REVIEW_TEXT_TEXTAREA);
		sendkeysToElement(driver, HomePageUI.REVIEW_TEXT_TEXTAREA, content);
	}
	public void clickRatingRadioButton(String rating) {
		waitForElementClickable(driver, HomePageUI.REVIEW_RATING_RADIO_BUTTON, rating);
		clickToElement(driver, HomePageUI.REVIEW_RATING_RADIO_BUTTON, rating);
	}
	public void clickSubmitReviewButton() {
		waitForElementClickable(driver, HomePageUI.REVIEW_SUBMIT_BUTTON);
		clickToElement(driver, HomePageUI.REVIEW_SUBMIT_BUTTON);
	}
	public boolean isAddReviewMessageSuccessDisplayed() {
		waitForElementVisible(driver, HomePageUI.REVIEW_ADD_SUCCESS_TEXT);
		return isElementDisplayed(driver, HomePageUI.REVIEW_ADD_SUCCESS_TEXT);
	}	
}
