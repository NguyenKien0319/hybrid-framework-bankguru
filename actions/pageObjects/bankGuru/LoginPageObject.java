package pageObjects.bankGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.bankGuru.LoginPageUI;

public class LoginPageObject extends BasePage {
	private WebDriver driver;
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isTextDemoSiteDisplayed() {
		waitForElementVisible(driver, LoginPageUI.TEXT_STEPS);
		return isElementDisplayed(driver, LoginPageUI.TEXT_STEPS);
	}

	public void clickToHereLink() {
		waitForElementClickable(driver, LoginPageUI.HERE_LINK);
		clickToElement(driver, LoginPageUI.HERE_LINK);
	}

	public void inputToEmailTextBox(String userID) {
		waitForAllElementsVisible(driver, LoginPageUI.USER_TEXTBOX);
		sendkeysToElement(driver, LoginPageUI.USER_TEXTBOX, userID);
	}

	public void inputToPasswordTextBox(String passwordID) {
		waitForAllElementsVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeysToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, passwordID);
	}

	public void clickLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
	}

}
