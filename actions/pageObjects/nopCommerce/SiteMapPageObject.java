package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.SiteMapPageUI;

public class SiteMapPageObject extends BasePage{
	WebDriver driver;
	public SiteMapPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public boolean isSideMapTitleDisplayed() {
		waitForElementVisible(driver, SiteMapPageUI.PAGE_TITLE);
		return isElementDisplayed(driver, SiteMapPageUI.PAGE_TITLE);
	}
}
