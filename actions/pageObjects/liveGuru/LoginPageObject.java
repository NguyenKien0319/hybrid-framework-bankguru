package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.LoginPageUI;

public class LoginPageObject extends BasePage{
	private WebDriver driver;
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void inputEmailAddress(String emailAddress) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeysToElement(driver, LoginPageUI.EMAIL_TEXTBOX, emailAddress);
	}
	public void inputPassword(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeysToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}
	public void clickLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
	}
	public void loginToSystem(WebDriver driver, String emailAddress, String password) {
		inputEmailAddress(emailAddress);
		inputPassword(password);
		clickLoginButton();
	}
	public String get_Empty_Error_Email_Message() {
		waitForElementVisible(driver, LoginPageUI.ERROR_EMAIL_MESSAGE);
		return getElement(driver, LoginPageUI.ERROR_EMAIL_MESSAGE).getText();
	}
	public String get_Empty_Error_Password_Message() {
		waitForElementVisible(driver, LoginPageUI.ERROR_PASSWORD_MESSAGE);
		return getElement(driver, LoginPageUI.ERROR_PASSWORD_MESSAGE).getText();
	}
	public String get_Invalid_Error_Email_Message() {
		waitForElementVisible(driver, LoginPageUI.ERROR_EMAIL_MESSAGE);
		return getElement(driver, LoginPageUI.ERROR_EMAIL_MESSAGE).getText();
	}
	public String get_Invalid_Error_Password_Message() {
		waitForElementVisible(driver, LoginPageUI.ERROR_PASSWORD_MESSAGE);
		return getElement(driver, LoginPageUI.ERROR_PASSWORD_MESSAGE).getText();
	}
	public boolean isIncorrectMessageDisplayed() {
		waitForElementVisible(driver, LoginPageUI.INCORRECT_EMAIL_PASSWORD_MESSAGE);
		return isElementDisplayed(driver, LoginPageUI.INCORRECT_EMAIL_PASSWORD_MESSAGE);
	}
}
