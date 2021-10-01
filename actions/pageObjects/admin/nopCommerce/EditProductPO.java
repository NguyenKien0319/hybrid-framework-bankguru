package pageObjects.admin.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.GlobalConstants;
import pageUIs.admin.nopCommerce.DashBoardUI;
import pageUIs.admin.nopCommerce.EditProductUI;
import pageUIs.admin.nopCommerce.ProductUI;

public class EditProductPO extends BasePage {
	private WebDriver driver;

	public EditProductPO(WebDriver driver) {
		this.driver = driver;
	}

	public void goToPageByMenuBar(String bigCategories, String middleCategories) {
		waitForElementClickable(driver, DashBoardUI.BIG_CATEGORIES, bigCategories);
		clickToElement(driver, DashBoardUI.BIG_CATEGORIES, bigCategories);
		waitForElementClickable(driver, DashBoardUI.MIDDLE_CATEGORIES, middleCategories);
		clickToElement(driver, DashBoardUI.MIDDLE_CATEGORIES, middleCategories);
	}

	public void searchProductByName(String productName) {
		// waitForElementClickable(driver, ProductUI.SEARCH_FIELD);
		// clickToElement(driver, ProductUI.SEARCH_FIELD);
		waitForElementVisible(driver, ProductUI.PRODUCT_NAME_TEXTBOX);
		sendkeysToElement(driver, ProductUI.PRODUCT_NAME_TEXTBOX, productName);
		waitForElementClickable(driver, ProductUI.SEARCH_BUTTON);
		clickToElement(driver, ProductUI.SEARCH_BUTTON);
	}

	public boolean isSearchProductByNameDisplayed(String productName, String SKU, String price) {
		waitForElementVisible(driver, ProductUI.INFOR_PRODUCT_SEARCH_BY_NAME, productName, SKU, price);
		return isElementDisplayed(driver, ProductUI.INFOR_PRODUCT_SEARCH_BY_NAME, productName, SKU, price);
	}

	public void clickToEditProduct(String productName) {
		waitForElementClickable(driver, ProductUI.EDIT_BUTTON_GET_BY_PRODUCT_NAME, productName);
		clickToElement(driver, ProductUI.EDIT_BUTTON_GET_BY_PRODUCT_NAME, productName);
	}

	public void openSubTabByCardTitle(String cardTitle) {
		waitForElementVisible(driver, EditProductUI.TOGGLE_ICON_BY_CARD_TITLE, cardTitle);
		String toogleIconStatus = getElementAttribute(driver, EditProductUI.TOGGLE_ICON_BY_CARD_TITLE, "class",
				cardTitle);
		if (toogleIconStatus.contains("fa-plus")) {
			waitForElementClickable(driver, EditProductUI.TOGGLE_ICON_BY_CARD_TITLE, cardTitle);
			clickToElement(driver, EditProductUI.TOGGLE_ICON_BY_CARD_TITLE, cardTitle);
		}
	}

	public void upLoadProductImageByCardTitle(String cardTitle, String... fileNames) {
		String filePath = GlobalConstants.UPLOAD_PATH;
		String fullFileName = "";
		for (String file : fileNames) {
			fullFileName = fullFileName + filePath + file + "\n";
		}
		fullFileName = fullFileName.trim();
		getElement(driver, EditProductUI.UPLOAD_FILE_BY_CARD_TITLE, cardTitle).sendKeys(fullFileName);
		;
	}

	public boolean isImageUploadDisplayed(String imageName) {
		String imageSplit = imageName.split("\\.")[0];
		waitForElementVisible(driver, EditProductUI.IMAGE_UPLOAD_SUCCESS, imageSplit);
		return isElementDisplayed(driver, EditProductUI.IMAGE_UPLOAD_SUCCESS, imageSplit);
	}

	public void inputToALTAttributeTextBox(String value) {
		waitForElementVisible(driver, EditProductUI.ALT_ATTRIBUTE_TEXTBOX);
		sendkeysToElement(driver, EditProductUI.ALT_ATTRIBUTE_TEXTBOX, value);
	}

	public void inputToTitleAttributeTextBox(String value) {
		waitForElementVisible(driver, EditProductUI.TITLE_ATTRIBUTE_TEXTBOX);
		sendkeysToElement(driver, EditProductUI.TITLE_ATTRIBUTE_TEXTBOX, value);
	}

	public void inputToOrderAttributeTextBox(String value) {
		waitForElementClickable(driver, EditProductUI.DISPLAYORDER_ATTRIBUTE_TEXTBOX);
		clickToElement(driver, EditProductUI.DISPLAYORDER_ATTRIBUTE_TEXTBOX, value);
	}

	public void inputAllAttributesTextBox(String valueALT, String valueTitle, String ValueOrder) {
		inputToALTAttributeTextBox(valueALT);
		inputToTitleAttributeTextBox(valueTitle);
		inputToOrderAttributeTextBox(ValueOrder);
		waitForElementClickable(driver, EditProductUI.ADD_PRODUCT_PICTURE_BUTTON);
		clickToElement(driver, EditProductUI.ADD_PRODUCT_PICTURE_BUTTON);
	}

	public boolean isNewInfoImageDisplayed(String productName, String displayOrder, String ALT, String title) {
		String imageProductName = productName.replace(" ", "-").toLowerCase();
		waitForElementVisible(driver, EditProductUI.ATTRIBUTE_INFO_NEW_IMAGE, imageProductName, displayOrder, ALT,
				title);
		return isElementDisplayed(driver, EditProductUI.ATTRIBUTE_INFO_NEW_IMAGE, imageProductName, displayOrder, ALT,
				title);
	}

	public ProductPO clickToSaveButton() {
		waitForElementClickable(driver, EditProductUI.SAVE_BUTTON);
		clickToElement(driver, EditProductUI.SAVE_BUTTON);
		return PageGeneratorManager.getProductPage(driver);
	}

	public void deleteProductByName(String productName) {
		productName = productName.replace(" ", "-").toLowerCase();
		waitForElementClickable(driver, EditProductUI.DELETE_IMAGE_BUTTON, productName);
		clickToElement(driver, EditProductUI.DELETE_IMAGE_BUTTON, productName);
		aceptAlert(driver);
	}

	public boolean isNoDataInTableDisplayedByCardTitle(String cardTitle) {
		waitForAllElementsVisible(driver, EditProductUI.NO_DATA_IN_TABLE_BY_CARDTITLE, cardTitle);
		return isElementDisplayed(driver, EditProductUI.NO_DATA_IN_TABLE_BY_CARDTITLE, cardTitle);
	}

}
