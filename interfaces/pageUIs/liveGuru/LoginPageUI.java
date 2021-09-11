package pageUIs.liveGuru;

public class LoginPageUI {
	public static final String EMAIL_TEXTBOX = "//input[@id= 'email']";
	public static final String PASSWORD_TEXTBOX = "//input[@id= 'pass']";
	public static final String LOGIN_BUTTON = "//button[@id= 'send2']";
	public static final String ERROR_EMAIL_MESSAGE = "//input[@id= 'email']/following-sibling::div";
	public static final String ERROR_PASSWORD_MESSAGE = "//input[@id= 'pass']/following-sibling::div";
	public static final String INCORRECT_EMAIL_PASSWORD_MESSAGE = "//li//span[text()='Invalid login or password.']";
}
