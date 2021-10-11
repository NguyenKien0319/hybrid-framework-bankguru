package pageUIs.nopCommerce;

public class BasePageUI {
	public static final String MY_ACCOUNT_LINK = "//div[@class='footer']//a[text()='My account']";
	public static final String SEARCH_LINK = "//div[@class='footer']//a[text()='Search']";
	public static final String SITE_MAP_LINK = "//div[@class='footer']//a[text()='Sitemap']";
	public static final String WISH_LIST_LINK = "//div[@class='header-links']//span[text()='Wishlist']";
	public static final String NEWS_LINK = "//div[@class='footer']//a[text()='News']";
	public static final String LOGO_LINK = "//div[@class='header-logo']//img";
	
	public static final String DYNAMIC_FOOTER_LINK = "//div[@class='footer']//a[text()= '%s']";
	//Submit button by Name
	public static final String SUBMIT_BUTTON_BY_NAME = "//button[@class='button-1 %s-button']";
	public static final String SEARCH_TEXTBOX = "//input[@id='small-searchterms']";
	public static final String SEACH_BOX_BUTTON = "//button[@class='button-1 search-box-button']";
	//Locator header-menu-not mobile
	public static final String HEADER_MENU_BY_NAME = "//ul[contains(@class,'notmobile')]//a[text()='%s ']";
	//Locator header-sub-menu-not mobile
	public static final String HEADER_SUB_MENU_BY_NAME = "//ul[contains(@class,'notmobile')]//a[text()='%s ']/parent::li/ul//a[contains(string(),'%s')]";
	public static final String PRODUCT_TITLE_LINK = "//h2[@class='product-title']/a";
	public static final String PRODUCT_PRICE = "//div[@class='prices']/span";
	//Review Product
	public static final String BUTTON_BY_ACTION = "//div[@class='overview-buttons']//button[text()='%s']";
	public static final String ADD_TO_WISHLIST_SUCCESS_TEXT = "//p[@class='content' and contains(string(),'The product has been added to your ')]";
	public static final String WISHLIST_LINK_IN_SUCCESS_TEXT = "//p[@class='content' and contains(string(),'The product has been added to your ')]/a[text()='wishlist']";
	public static final String INFOR_PRODUCT_VALUE = "//div[@class='%s']/span[contains(@class,'value')]";
	//WishListPage
	public static final String ADD_TO_CART_CHECKBOX_BY_PRODUCTNAME = "//a[@class='product-name' and text()='%s']/parent::td//preceding-sibling::td[@class='add-to-cart']/input";
	public static final String WISHLIST_ACTION_BUTTON = "//button[@class='button-2 %s-button']";
	//Pattern Object
	public static final String DYNAMIC_HEADER_BYNAME = "//div[@class='header']//a[text()= '%s']";
	public static final String DYNAMIC_RADIO_BUTTON_BYNAME = "//label[text()='%s']/preceding-sibling::input";
	public static final String DYNAMIC_TEXTBOX_BY_ID = "//input[@id='%s']";
	public static final String DYNAMIC_BUTTON_BY_NAME = "//button[text()='%s']";
}
