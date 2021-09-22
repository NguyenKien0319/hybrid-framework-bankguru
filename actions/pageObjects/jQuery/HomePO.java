package pageObjects.jQuery;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.jQuery.HomePOUI;

public class HomePO extends BasePage{
	private WebDriver driver;
	
	public HomePO(WebDriver driver) {
		this.driver = driver;
	}

	public void goToPagingByNumber(String pageNumber) {
		waitForElementVisible(driver, HomePOUI.PAGE_NUMBER, pageNumber);
		clickToElement(driver, HomePOUI.PAGE_NUMBER, pageNumber);
	}

	public boolean isgoToPageSuccess(String pageNumber) {
		waitForElementVisible(driver, HomePOUI.PAGE_NUMBER_ACTIVE, pageNumber);
		return isElementDisplayed(driver, HomePOUI.PAGE_NUMBER_ACTIVE, pageNumber);
	}

	public void inputToHeaderTextBoxByName(String value, String headerName) {
		waitForElementVisible(driver, HomePOUI.HEADER_TEXTBOX_BY_NAME, headerName);
		sendkeysToElement(driver, HomePOUI.HEADER_TEXTBOX_BY_NAME, value, headerName);
		presskeyToElement(driver, HomePOUI.HEADER_TEXTBOX_BY_NAME,Keys.ENTER, headerName);
	}

	public void updateRowByCountry(String country, String action) {
		waitForElementClickable(driver, HomePOUI.UPDATE_ROW_BY_COUNTRY, country, action);
		clickToElement(driver, HomePOUI.UPDATE_ROW_BY_COUNTRY, country, action);
	}

	public boolean isInfoDisplayCorrectly(String femals, String country, String males, String total) {
		waitForElementVisible(driver, HomePOUI.VALUE_ROW_TEXT_BOX, femals, country, males, total);
		return isElementDisplayed(driver, HomePOUI.VALUE_ROW_TEXT_BOX, femals, country, males, total);
	}

	public void inputToRowTextBoxByRow(String headerName, String rowNumber, String value) {
		int columnIndex = getElementSize(driver, HomePOUI.COLUMN_INDEX_BY_HEADERNAME, headerName) + 1;
		waitForElementVisible(driver, HomePOUI.CELL_TEXTBOX, rowNumber, String.valueOf(columnIndex));
		sendkeysToElement(driver, HomePOUI.CELL_TEXTBOX, value, rowNumber, String.valueOf(columnIndex));
	}

	public void actionToUpdateTable(String rowNumber, String actions) {
		waitForElementClickable(driver, HomePOUI.BUTTON_UPDATE_TABLE, rowNumber, actions);
		clickToElement(driver, HomePOUI.BUTTON_UPDATE_TABLE, rowNumber, actions);
	}
	
}
