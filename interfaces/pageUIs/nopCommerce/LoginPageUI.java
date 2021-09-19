package pageUIs.nopCommerce;

public class LoginPageUI {
	public static final String PAGE_TITLE = "//div[@class='page-title']/h1[text()='Welcome, Please Sign In!']";
	public static final String EMAIL_TEXTBOX = "//input[@id = 'Email']";
	public static final String PASSWORD_TEXTBOX = "//input[@id = 'Password']";
	public static final String LOGIN_BUTTON = "//button[@type= 'submit' and text()='Log in']";
	public static final String DYNAMIC_ERROR_EMAIL_MESSAGE = "//span[@id='Email-error' and text()='%s']";
	public static final String DYNAMIC_ERROR_MESSAGE = "//div//li[text()='%s']";
	public static final String LOGIN_LINK = "//a[@class='ico-login']";
}
