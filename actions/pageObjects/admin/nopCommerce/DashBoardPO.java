package pageObjects.admin.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.admin.nopCommerce.DashBoardUI;

public class DashBoardPO extends BasePage{
	private WebDriver driver;
	
	public DashBoardPO(WebDriver driver) {
		this.driver = driver;
	}

	public void goToPageByMenuBar(String bigCategories, String middleCategories) {
		waitForElementClickable(driver, DashBoardUI.BIG_CATEGORIES, bigCategories);
		clickToElement(driver, DashBoardUI.BIG_CATEGORIES, bigCategories);
		waitForElementClickable(driver, DashBoardUI.MIDDLE_CATEGORIES, middleCategories);
		clickToElement(driver, DashBoardUI.MIDDLE_CATEGORIES, middleCategories);
	}
	
}
