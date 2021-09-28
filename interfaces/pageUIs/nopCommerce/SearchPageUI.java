package pageUIs.nopCommerce;

public class SearchPageUI {
	public static final String INVALID_ERROR_MESSAGE_SEARCH = "//div[@class='warning' and text()='Search term minimum length is 3 characters']";
	public static final String NO_DATA_MESSAGE_SEARCH = "//div[@class='no-result' and text()='No products were found that matched your criteria.']";
	public static final String SEARCH_TEXTBOX = "//input[@id='q']";
	public static final String SEARCH_RESULT_BY_NAME = "//h2[@class='product-title']/a[contains(text(),'%s')]";
	public static final String SEARCH_CHECKBOX_BYNAME = "//label[text()='%s']";
	public static final String SEARCH_CATEGORIES_DROPDOWN_LIST = "//select[@id='cid']";
	public static final String SEARCH_MANUFACTURER_DROPDOWN_LIST = "//select[@id='mid']";
	
}
