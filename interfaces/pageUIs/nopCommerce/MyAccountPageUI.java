package pageUIs.nopCommerce;

public class MyAccountPageUI {
	public static final String FEMALE_RADIO_BUTTON = "//input[@id='gender-female']";
	public static final String TEXTBOX_BY_NAME = "//input[@id='%s']";
	public static final String DATEOFBIRTH_DROPDOWN_LIST = "//select[@name='DateOfBirth%s']";
	public static final String SAVE_BUTTON = "//button[@name='save-info-button']";
	//Add Address
	public static final String LEFT_MENU_LINK = "//a[contains(string(),'%s')]";
	public static final String ADDRESSES_ADD_NEW_BUTTON = "//button[@class='button-1 add-address-button']";
	public static final String ADDRESSES_NO_DATA_TEXT = "//div[@class='no-data' and text()='No addresses']";
	public static final String ADDRESSES_TEXTBOX_BY_NAME = "//input[@id='Address_%s']";
	public static final String ADDRESSES_TEXTBOX_COUNTRY = "//select[@id='Address_CountryId']";
	public static final String ADDRESSES_SAVE_BUTTON = "//button[@class='button-1 save-address-button']";
	public static final String ADDRESSES_VERIFY_INFOR = "//div[@class='address-list']//li[@class='name' and text()='%s']/following-sibling::li[@class='email' and text()='%s']/following-sibling::li[@class='phone' and text()='%s']//following-sibling::li[@class='address1' and text()='%s']/following-sibling::li[@class='city-state-zip' and text()='%s']/following-sibling::li[@class='country' and text()='%s']";
	public static final String ADDRESSED_DELETE_BUTTON = "//button[@type='button' and text()='Delete']";
	//ChangePassword
	public static final String CHANGE_PASSWORD_SUCCESS_TEXT = "//p[@class='content' and text()='Password was changed']";
	public static final String CHANGE_PASSWORD_TEXTBOX = "//input[@id='%sPassword']";
	public static final String CHANGE_PASSWORD_SAVE_BUTTON = "//button[@class='button-1 change-password-button']";
	public static final String LOGOUT_LINK = "//a[@class='ico-logout']";
	public static final String CHANGE_PASSWORD_CLOSE_BUTTON = "//span[@title='Close']";
	//My product review
	public static final String VERIFY_PRODUCTS_REVIEW_SUCCESS = "//div[@class='product-review-item']//strong[text()='%s']/parent::div/following-sibling::div//div[@style='width:%s']//ancestor::div[@class='review-item-head']/following-sibling::div/div[@class='review-text' and text()='%s']/following-sibling::div//a[text()='%s']";
}	
