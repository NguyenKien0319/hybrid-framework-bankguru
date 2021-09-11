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

	public void clickLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
	}

}
