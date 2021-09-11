package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.HomePageUI;

public class HomePageObject extends BasePage {
	private WebDriver driver;
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void clickToRegisterLink() {
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
	}

	public boolean isSliderDisplayed() {
		waitForElementVisible(driver, HomePageUI.SLIDER);
		return isElementDisplayed(driver, HomePageUI.SLIDER);
	}

	public void clickToLoginButton() {
		waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
	}
	
}
