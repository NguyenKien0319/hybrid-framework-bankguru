package pageObjects.bankGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.bankGuru.RegisterPageUI;

public class RegisterPageObject extends BasePage{
	private WebDriver driver;
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void inputToEmailTextBox(String email) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendkeysToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, email);
	}

	public void clickSumbitButton() {
		waitForElementClickable(driver, RegisterPageUI.SUBMIT_BUTTON);
		clickToElement(driver, RegisterPageUI.SUBMIT_BUTTON);
	}

	public String getUserInfor() {
		waitForElementVisible(driver, RegisterPageUI.USERID_INFOR);
		return getElement(driver,RegisterPageUI.USERID_INFOR).getText();
	}

	public String getPasswordInfor() {
		waitForElementVisible(driver, RegisterPageUI.PASSWORDID_INFOR);
		return getElement(driver,RegisterPageUI.PASSWORDID_INFOR).getText();
	}
	
}
