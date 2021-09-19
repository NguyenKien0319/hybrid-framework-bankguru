package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.LoginPageUI;

public class LoginPageObject extends BasePage {
	private WebDriver driver;
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputEmailTextBox(String email) {
		waitForAllElementsVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeysToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);
	}

	public void inputPasswordTextBox(String password) {
		waitForAllElementsVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeysToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public HomePageObject clickLoginButtonToOpenPage() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManagement.getHomePage(driver);
	}

	public void clickLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
	}

	public boolean isErrorEmailMessageDisplayed(WebDriver driver, String errorText) {
		waitForElementVisible(driver, LoginPageUI.DYNAMIC_ERROR_EMAIL_MESSAGE, errorText);
		return isElementDisplayed(driver, LoginPageUI.DYNAMIC_ERROR_EMAIL_MESSAGE, errorText);
	}

	public boolean isErrorMessageDisplayed(WebDriver driver, String errorText) {
		waitForElementVisible(driver, LoginPageUI.DYNAMIC_ERROR_MESSAGE, errorText);
		return isElementDisplayed(driver, LoginPageUI.DYNAMIC_ERROR_MESSAGE, errorText);
	}

	public void clickLoginHeaderLink() {
		waitForElementVisible(driver, LoginPageUI.LOGIN_LINK);
		clickToElement(driver, LoginPageUI.LOGIN_LINK);
	}

}
