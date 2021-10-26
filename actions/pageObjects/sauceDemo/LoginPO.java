package pageObjects.sauceDemo;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.sauce.LoginPageUI;

public class LoginPO extends BasePage{
	private WebDriver driver;
	
	public LoginPO (WebDriver driver) {
		this.driver = driver;
	}

	public void inpuTextBoxByID(String textboxName, String value) {
		waitForElementVisible(driver, LoginPageUI.TEXTBOX_BY_ID, textboxName);
		sendkeysToElement(driver, LoginPageUI.TEXTBOX_BY_ID, value, textboxName);
	}

	public void clickLogin() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
	}
	
	
}
