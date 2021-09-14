package pageObjects.pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class LoginPageObject extends BasePageFactory {
	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "Email")
	private WebElement emailID;
	@FindBy(id = "Password")
	private WebElement passwordID;
	@FindBy(xpath = "//button[@type= 'submit' and text()='Log in']")
	private WebElement loginButton;

	public void inputEmailTextBox(String email) {
		waitForElementVisible(driver, emailID);
		sendkeysToElement(driver, emailID, email);
	}

	public void inputPasswordTextBox(String password) {
		waitForElementVisible(driver, passwordID);
		sendkeysToElement(driver, passwordID, password);
	}

	public void clickLoginButton() {
		waitForElementClickable(driver, loginButton);
		clickToElement(driver, loginButton);
	}

}
