package pageUIs.nopCommerce;

public class HomePageUI {
	public static final String REGISTER_LINK = "//a[@class='ico-register']";
	public static final String LOGIN_LINK = "//a[@class='ico-login']";
	public static final String LOGOUT_LINK = "//a[@class='ico-logout']";
	public static final String SLIDER = "//div[@class='topic-block-title']/h2[text()='Welcome to our store']";
	
	public static final String MY_ACCOUNT_LINK = "//a[@class='ico-account']";
	//ReviewProduct
	public static final String FEATURES_PRODUCT_BY_NAME = "//h2[@class='product-title']/a[text()='%s']";
	public static final String REVIEW_TEXTLINK = "//a[text()='Add your review']";

	//Add review
	public static final String REVIEW_TITLE_TEXTBOX = "//input[@id='AddProductReview_Title']";
	public static final String REVIEW_TEXT_TEXTAREA = "//textarea[@id='AddProductReview_ReviewText']";
	public static final String REVIEW_RATING_RADIO_BUTTON = "//input[@aria-label='%s']";
	public static final String REVIEW_SUBMIT_BUTTON = "//button[@name='add-review']";
	public static final String REVIEW_ADD_SUCCESS_TEXT = "//div[@class='result' and contains (text(),'Product review is successfully added.')]";
	//Sort
	public static final String SORT_BY_OPTION = "//select[@id='products-orderby']";
	public static final String PRODUCTS_PAGE_SIZE = "//select[@id='products-pagesize']";
	public static final String PRODUCT_ITEM = "//div[@class='product-item']";
	public static final String CURRENT_PAGE_NUMBER = "//div[@class='pager']//li[@class='current-page']/span[text()='%s']";
	public static final String ICON_NAVIGATION_PAGE = "//div[@class='pager']//li[@class='%s-page']";
	public static final String NUMBER_PAGE_LIST = "//div[@class='pager']/li";
	public static final String LOADING_ICON = "//div[@class='ajax-products-busy' and @style='display: none;']";
}
