package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.MyDashBoardPageUI;

public class MyDashBoardPageObject extends BasePage{
	private WebDriver driver;
	public MyDashBoardPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public boolean isTextHeaderDisplayed() {
		waitForElementVisible(driver, MyDashBoardPageUI.DASHBOARD_HEADER);
		return isElementDisplayed(driver, MyDashBoardPageUI.DASHBOARD_HEADER);
	}
}
