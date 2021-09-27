package pageUIs.nopCommerce;

public class BasePageUI {
	public static final String MY_ACCOUNT_LINK = "//div[@class='footer']//a[text()='My account']";
	public static final String SEARCH_LINK = "//div[@class='footer']//a[text()='Search']";
	public static final String SITE_MAP_LINK = "//div[@class='footer']//a[text()='Sitemap']";
	public static final String WISH_LIST_LINK = "//div[@class='header-links']//span[text()='Wishlist']";
	public static final String NEWS_LINK = "//div[@class='footer']//a[text()='News']";
	
	public static final String DYNAMIC_FOOTER_LINK = "//div[@class='footer']//a[text()= '%s']";
	//Submit button by Name
	public static final String SUBMIT_BUTTON_BY_NAME = "//button[@class='button-1 %s-button']";
}
