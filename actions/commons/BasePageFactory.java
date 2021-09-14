package commons;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageFactory {
	public void openUrlPage(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	public void getToBackPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void getToFowardPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void getRefreshPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void clickToElement(WebDriver driver, WebElement element) {
		element.click();
	}

	public void sendkeysToElement(WebDriver driver, WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}

	public Boolean isElementDisplayed(WebDriver driver, WebElement element) {
		return element.isDisplayed();
	}

	public Boolean isElementEnabled(WebDriver driver, WebElement element) {
		return element.isEnabled();
	}

	public Boolean isElementSelected(WebDriver driver, WebElement element) {
		return element.isSelected();
	}

	public void waitForElementVisible(WebDriver driver, WebElement element) {
		explicitWait = new WebDriverWait(driver, timeouts);
		explicitWait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForAllElementsVisible(WebDriver driver, List<WebElement> element) {
		explicitWait = new WebDriverWait(driver, timeouts);
		explicitWait.until(ExpectedConditions.visibilityOfAllElements(element));
	}

	public void waitForElementClickable(WebDriver driver, WebElement element) {
		explicitWait = new WebDriverWait(driver, timeouts);
		explicitWait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void checkTheCheckBoxOrRadio(WebDriver driver, WebElement element) {
		if (!isElementSelected(driver, element)) {
			element.click();
		}
	}

	private long timeouts = 30;
	private WebDriverWait explicitWait;
	private JavascriptExecutor jsExecutor;
}
