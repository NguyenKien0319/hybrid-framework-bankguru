package pageUIs.admin.nopCommerce;

public class ProductUI {
	public static final String SEARCH_FIELD = "//div[@class='row search-row']";
	public static final String PRODUCT_NAME_TEXTBOX = "//input[@id='SearchProductName']";
	public static final String SEARCH_BUTTON = "//button[@id='search-products']";
	public static final String INFOR_PRODUCT_SEARCH_BY_NAME = "//tr[@class='odd']//td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']";
	public static final String EDIT_BUTTON_GET_BY_PRODUCT_NAME = "//td[text()='%s']//following-sibling::td[@class=' button-column']/a";
	public static final String MESSAGE_UPDATED_SUCCESS = "//div[contains(@class,'alert-success') and contains(string(),'The product has been updated successfully.')]";
	public static final String DEFAULT_IMAGE_IN_PRODUCT_LIST_SEARCH_BY_NAME = "//td[text()='%s']/preceding-sibling::td/img[contains(@src,'default-image')]";
}
