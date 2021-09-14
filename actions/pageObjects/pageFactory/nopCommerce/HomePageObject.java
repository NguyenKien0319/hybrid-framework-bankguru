package pageObjects.pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class HomePageObject extends BasePageFactory {

	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='ico-register']")
	private WebElement registerLink;

	@FindBy(xpath = "//a[@class='ico-login']")
	private WebElement loginLink;

	@FindBy(id = "nivo-slider")
	private WebElement slider;

	public void clickToRegisterLink() {
		waitForElementClickable(driver, registerLink);
		clickToElement(driver, registerLink);
	}

	public boolean isSliderDisplayed() {
		waitForElementVisible(driver, slider);
		return isElementDisplayed(driver, slider);
	}

	public void clickToLoginButton() {
		waitForElementClickable(driver, loginLink);
		clickToElement(driver, loginLink);
	}

}
