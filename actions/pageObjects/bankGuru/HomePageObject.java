package pageObjects.bankGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.bankGuru.HomePageUI;

public class HomePageObject extends BasePage{
	private WebDriver driver;
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	public boolean isTextWelcomeDisplayed() {
		waitForElementVisible(driver, HomePageUI.WELCOME_TEXT);
		return isElementDisplayed(driver, HomePageUI.WELCOME_TEXT);
	}
}
