package pageUIs.nopCommerce;

public class RegisterPageUI {
	public static final String PAGE_TITLE = "//div[@class='page-title']/h1[text()='Register']";
	public static final String RADIO_MALE = "//input [@id= 'gender-male']";
	public static final String FIRSTNAME_TEXTBOX = "//input [@id= 'FirstName']";
	public static final String LASTNAME_TEXTBOX = "//input [@id= 'LastName']";
	public static final String EMAIL_TEXTBOX = "//input [@id= 'Email']";
	public static final String PASSWORD_TEXTBOX = "//input [@id= 'Password']";
	public static final String CONFIRMPASSWORD_TEXTBOX = "//input [@id= 'ConfirmPassword']";
	public static final String REGISTER_BUTTON = "//button [@id='register-button']";
	public static final String SUCCESS_MESSAGE = "//div[text()='Your registration completed']";
	public static final String LOGOUT_BUTTON = "//a[@class='ico-logout']";
	public static final String DYNAMIC_REQUIRED_MESSAGE = "//span[@id ='%s-error' and text() = '%s']";
	public static final String ERROR_EMAIL_REGISTED_MESSAGE = "//div//li[text()='The specified email already exists']";
	public static final String INVALID_PASSWORD_MESSAGE = "//span[@id='Password-error']/p[text()='Password must meet the following rules: ']";
}
