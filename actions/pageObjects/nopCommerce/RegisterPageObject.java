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
		waitForAllElementsVisible(driver, RegisterPageUI.FIRSTNAME_TEXTBOX);
		sendkeysToElement(driver, RegisterPageUI.FIRSTNAME_TEXTBOX, firstName);
	}

	public void inputLastNameTextBox(String lastName) {
		waitForAllElementsVisible(driver, RegisterPageUI.LASTNAME_TEXTBOX);
		sendkeysToElement(driver, RegisterPageUI.LASTNAME_TEXTBOX, lastName);
	}

	public void inputEmailTextBox(String email) {
		waitForAllElementsVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendkeysToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, email);
	}

	public void inputPasswordTextBox(String password) {
		waitForAllElementsVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		sendkeysToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
	}

	public void inputConfirmPasswordTextBox(String confirmPassword) {
		waitForAllElementsVisible(driver, RegisterPageUI.CONFIRMPASSWORD_TEXTBOX);
		sendkeysToElement(driver, RegisterPageUI.CONFIRMPASSWORD_TEXTBOX, confirmPassword);
	}

	public void clickRegisterButton() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		checkTheCheckBoxOrRadio(driver, RegisterPageUI.REGISTER_BUTTON);
	}

	public boolean isTextRegisterDisplayed() {
		waitForAllElementsVisible(driver, RegisterPageUI.PAGE_TITLE);
		return isElementDisplayed(driver, RegisterPageUI.PAGE_TITLE);
	}

	public boolean isSuccesedMessageDisplayed() {
		waitForAllElementsVisible(driver, RegisterPageUI.SUCCESS_MESSAGE);
		return isElementDisplayed(driver, RegisterPageUI.SUCCESS_MESSAGE);
	}

	public void clickToLogoutButton() {
		waitForElementClickable(driver, RegisterPageUI.LOGOUT_BUTTON);
		clickToElement(driver, RegisterPageUI.LOGOUT_BUTTON);
	}

}
