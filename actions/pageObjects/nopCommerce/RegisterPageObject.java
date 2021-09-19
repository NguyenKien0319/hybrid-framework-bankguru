package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.RegisterPageUI;

public class RegisterPageObject extends BasePage {
	private WebDriver driver;
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickToGenderMaleRadioButton() {
		waitForElementClickable(driver, RegisterPageUI.RADIO_MALE);
		checkTheCheckBoxOrRadio(driver, RegisterPageUI.RADIO_MALE);
	}

	public void inputFirstNameTextBox(String firstName) {
		waitForElementVisible(driver, RegisterPageUI.FIRSTNAME_TEXTBOX);
		sendkeysToElement(driver, RegisterPageUI.FIRSTNAME_TEXTBOX, firstName);
	}

	public void inputLastNameTextBox(String lastName) {
		waitForElementVisible(driver, RegisterPageUI.LASTNAME_TEXTBOX);
		sendkeysToElement(driver, RegisterPageUI.LASTNAME_TEXTBOX, lastName);
	}

	public void inputEmailTextBox(String email) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendkeysToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, email);
	}

	public void inputPasswordTextBox(String password) {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		sendkeysToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
	}

	public void inputConfirmPasswordTextBox(String confirmPassword) {
		waitForElementVisible(driver, RegisterPageUI.CONFIRMPASSWORD_TEXTBOX);
		sendkeysToElement(driver, RegisterPageUI.CONFIRMPASSWORD_TEXTBOX, confirmPassword);
	}

	public void clickRegisterButton() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		checkTheCheckBoxOrRadio(driver, RegisterPageUI.REGISTER_BUTTON);
	}

	public boolean isTextRegisterDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.PAGE_TITLE);
		return isElementDisplayed(driver, RegisterPageUI.PAGE_TITLE);
	}

	public boolean isSuccesedMessageDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.SUCCESS_MESSAGE);
		return isElementDisplayed(driver, RegisterPageUI.SUCCESS_MESSAGE);
	}

	public HomePageObject clickToLogoutButton() {
		waitForElementClickable(driver, RegisterPageUI.LOGOUT_BUTTON);
		clickToElement(driver, RegisterPageUI.LOGOUT_BUTTON);
		return PageGeneratorManagement.getHomePage(driver);
	}

	public boolean isErrorMessageDisplay(WebDriver driver,String value, String errorMessage) {
		waitForElementVisible(driver, RegisterPageUI.DYNAMIC_REQUIRED_MESSAGE, value, errorMessage );
		return isElementDisplayed(driver, RegisterPageUI.DYNAMIC_REQUIRED_MESSAGE, value , errorMessage);
	}

	public boolean isErrorEmailMessageDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.ERROR_EMAIL_REGISTED_MESSAGE);
		return isElementDisplayed(driver, RegisterPageUI.ERROR_EMAIL_REGISTED_MESSAGE);
	}

	public boolean isInvalidPasswordMessageDispplayed() {
		waitForElementVisible(driver, RegisterPageUI.INVALID_PASSWORD_MESSAGE);
		return isElementDisplayed(driver, RegisterPageUI.INVALID_PASSWORD_MESSAGE);
	}

}
