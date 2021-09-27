package pageUIs.nopCommerce;

public class HomePageUI {
	public static final String REGISTER_LINK = "//a[@class='ico-register']";
	public static final String LOGIN_LINK = "//a[@class='ico-login']";
	public static final String LOGOUT_LINK = "//a[@class='ico-logout']";
	public static final String SLIDER = "//div[@class='topic-block-title']/h2[text()='Welcome to our store']";
	
	public static final String MY_ACCOUNT_LINK = "//a[@class='ico-account']";
	//Add review
	public static final String FEATURES_PRODUCT_BY_NAME = "//h2[@class='product-title']/a[text()='%s']";
	public static final String REVIEW_TEXTLINK = "//a[text()='Add your review']";
	public static final String REVIEW_TITLE_TEXTBOX = "//input[@id='AddProductReview_Title']";
	public static final String REVIEW_TEXT_TEXTAREA = "//textarea[@id='AddProductReview_ReviewText']";
	public static final String REVIEW_RATING_RADIO_BUTTON = "//input[@aria-label='%s']";
	public static final String REVIEW_SUBMIT_BUTTON = "//button[@name='add-review']";
	public static final String REVIEW_ADD_SUCCESS_TEXT = "//div[@class='result' and contains (text(),'Product review is successfully added.')]";
}
