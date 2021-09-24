package pageObjects.admin.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.admin.nopCommerce.LoginUI;

public class LoginPageObject extends BasePage{
	private WebDriver driver;
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public DashBoardPO loginToPage(String email, String password) {
		waitForAllElementsVisible(driver, LoginUI.EMAIL_TEXTBOX);
		sendkeysToElement(driver, LoginUI.EMAIL_TEXTBOX, email);
		waitForAllElementsVisible(driver, LoginUI.PASSWORD_TEXTBOX);
		sendkeysToElement(driver, LoginUI.PASSWORD_TEXTBOX, password);
		clickToElement(driver, LoginUI.LOGIN_BUTTON);
		return PageGeneratorManager.getDashBoardPage(driver);
	}
}
