package pageObjects.pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class RegisterPageObject extends BasePageFactory {
	private WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='page-title']/h1[text()='Register']")
	WebElement pageTitle;

	@FindBy(id = "gender-male")
	WebElement gender_male;

	@FindBy(id = "FirstName")
	WebElement FirstName;

	@FindBy(id = "LastName")
	WebElement LastName;

	@FindBy(id = "Email")
	WebElement Email;

	@FindBy(id = "Password")
	WebElement Password;

	@FindBy(id = "ConfirmPassword")
	WebElement ConfirmPassword;

	@FindBy(id = "register-button")
	WebElement registerButton;

	@FindBy(xpath = "//div[text()='Your registration completed']")
	WebElement successMessage;

	@FindBy(xpath = "//a[@class='ico-logout']")
	WebElement logoutButton;

	public void clickToGenderMaleRadioButton() {
		waitForElementClickable(driver, gender_male);
		checkTheCheckBoxOrRadio(driver, gender_male);
	}

	public void inputFirstNameTextBox(String firstName) {
		waitForElementVisible(driver, FirstName);
		sendkeysToElement(driver, FirstName, firstName);
	}

	public void inputLastNameTextBox(String lastName) {
		waitForElementVisible(driver, LastName);
		sendkeysToElement(driver, LastName, lastName);
	}

	public void inputEmailTextBox(String email) {
		waitForElementVisible(driver, Email);
		sendkeysToElement(driver, Email, email);
	}

	public void inputPasswordTextBox(String password) {
		waitForElementVisible(driver, Password);
		sendkeysToElement(driver, Password, password);
	}

	public void inputConfirmPasswordTextBox(String confirmPassword) {
		waitForElementVisible(driver, ConfirmPassword);
		sendkeysToElement(driver, ConfirmPassword, confirmPassword);
	}

	public void clickRegisterButton() {
		waitForElementClickable(driver, registerButton);
		checkTheCheckBoxOrRadio(driver, registerButton);
	}

	public boolean isTextRegisterDisplayed() {
		waitForElementVisible(driver, pageTitle);
		return isElementDisplayed(driver, pageTitle);
	}

	public boolean isSuccesedMessageDisplayed() {
		waitForElementVisible(driver, successMessage);
		return isElementDisplayed(driver, successMessage);
	}

	public void clickToLogoutButton() {
		waitForElementClickable(driver, logoutButton);
		clickToElement(driver, logoutButton);
	}

}
