package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
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

	public Alert waitElementPresence(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, timeouts);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	public void aceptAlert(WebDriver driver) {
		waitElementPresence(driver);
		alert.accept();
	}

	public void cancelAlert(WebDriver driver) {
		waitElementPresence(driver);
		alert.dismiss();
	}

	public void senkeysToAlert(WebDriver driver, String value) {
		waitElementPresence(driver);
		alert.sendKeys(value);
	}

	public String getTextToAlert(WebDriver driver) {
		waitElementPresence(driver);
		return alert.getText();
	}

	public void switchToWindowByID(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			if (!runWindow.equals(parentID)) {
				driver.switchTo().window(runWindow);
				break;
			}
		}
	}

	public void switchToWindowByTitle(WebDriver driver, String windowTitle) {
		Set<String> listWindows = driver.getWindowHandles();
		for (String window : listWindows) {
			driver.switchTo().window(window);
			if (driver.getTitle().equals(windowTitle)) {
				break;
			}
		}
	}

	public void closeAllWinDowsWithoutParent(WebDriver driver, String parentWindow) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			driver.switchTo().window(runWindow);
			if (!runWindow.equals(parentWindow)) {
				driver.close();
			}
			driver.switchTo().window(parentWindow);
		}
	}

	public By getByXpath(String locator) {
		return By.xpath(locator);
	}

	public WebElement getElement(WebDriver driver, String locator) {
		return driver.findElement(getByXpath(locator));
	}

	public List<WebElement> getElements(WebDriver driver, String locator) {
		return driver.findElements(getByXpath(locator));
	}

	public void clickToElement(WebDriver driver, String locator) {
		getElement(driver, locator).click();
	}

	public void sendkeysToElement(WebDriver driver, String locator, String value) {
		getElement(driver, locator).clear();
		getElement(driver, locator).sendKeys(value);
	}

	public int getElementSize(WebDriver driver, String locator) {
		return getElements(driver, locator).size();
	}

	public void selectDropDownByText(WebDriver driver, String locator, String item) {
		select = new Select(getElement(driver, locator));
		select.selectByVisibleText(item);
	}

	public String getDropDownItem(WebDriver driver, String locator) {
		select = new Select(getElement(driver, locator));
		return select.getFirstSelectedOption().getText();
	}

	public Boolean isDropDownMultiple(WebDriver driver, String locator) {
		select = new Select(getElement(driver, locator));
		return select.isMultiple();
	}

	public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator,
			String expectedItem) {
		getElement(driver, parentLocator).click();
		sleepInSecond(1);

		explicitWait = new WebDriverWait(driver, timeouts);
		List<WebElement> allItems = explicitWait
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childItemLocator)));

		for (WebElement item : allItems) {
			if (item.getText().trim().equals(expectedItem)) {
				jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				sleepInSecond(1);

				item.click();
				sleepInSecond(1);
				break;
			}
		}
	}

	public String getAttributeValue(WebDriver driver, String locator, String attributeName) {
		return getElement(driver, locator).getAttribute(attributeName);
	}

	public String getTextElement(WebDriver driver, String locator) {
		return getElement(driver, locator).getText();
	}

	public String getCssValue(WebDriver driver, String locator, String cssAttributeName) {
		return getElement(driver, locator).getCssValue(cssAttributeName);
	}

	public String convertRbgaToHex(String rbgaValue) {
		return Color.fromString(rbgaValue).asHex();
	}

	public void checkTheCheckBoxOrRadio(WebDriver driver, String locator) {
		if (!isElementSelected(driver, locator)) {
			getElement(driver, locator).click();
		}
	}

	public void unCheckTheCheckBox(WebDriver driver, String locator) {
		if (isElementSelected(driver, locator)) {
			getElement(driver, locator).click();
		}
	}

	public Boolean isElementDisplayed(WebDriver driver, String locator) {
		return getElement(driver, locator).isDisplayed();
	}

	public Boolean isElementEnabled(WebDriver driver, String locator) {
		return getElement(driver, locator).isEnabled();
	}

	public Boolean isElementSelected(WebDriver driver, String locator) {
		return getElement(driver, locator).isSelected();
	}

	public WebDriver switchToFrameByElement(WebDriver driver, String locator) {
		return driver.switchTo().frame(getElement(driver, locator));
	}

	public WebDriver switchToDefaultContent(WebDriver driver, String locator) {
		return driver.switchTo().defaultContent();
	}

	public void doubleClickToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.doubleClick(getElement(driver, locator)).perform();
	}

	public void hoverMouseToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.moveToElement(getElement(driver, locator)).perform();
	}

	public void rightClickToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.contextClick(getElement(driver, locator)).perform();
	}

	public void dragAndDrop(WebDriver driver, String sourceLocator, String targetLocator) {
		action = new Actions(driver);
		action.dragAndDrop(getElement(driver, sourceLocator), getElement(driver, targetLocator)).perform();
	}

	public void presskeyToElement(WebDriver driver, String locator, Keys key) {
		action = new Actions(driver);
		action.sendKeys(getElement(driver, locator), key).perform();
	}

	public Object executeJavascriptToBrowser(WebDriver driver, String javaScript) {
		jsExecutor = (JavascriptExecutor) driver;
		return jsExecutor.executeScript(javaScript);
	}

	public String getInnerText(WebDriver driver) {
		jsExecutor = (JavascriptExecutor) driver;
		return jsExecutor.executeScript("return document.documentElement.innerText;").toString();
	}

	public Boolean areExpectedTextInInnerText(WebDriver driver, String textExpected) {
		jsExecutor = (JavascriptExecutor) driver;
		String textActual = (String) jsExecutor
				.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0];");
		return textActual.equals(textExpected);
	}

	public Object scrollToElement(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		return jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(driver, locator));
	}

	public void scrollToBottomPage(WebDriver driver) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJS(WebDriver driver, String url) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.location = '" + url + "'");
	}

	public void highlightElement(WebDriver driver, String locator) {
		WebElement element = getElement(driver, locator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				"border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getElement(driver, locator));
	}

	public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(driver, locator));
	}

	public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');",
				getElement(driver, locator));
	}

	public String getElementValidationMessage(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getElement(driver, locator));
	}

	public boolean areJQueryAndJsLoadedSuccess(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, timeouts);
		jsExecutor = (JavascriptExecutor) driver;
		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return window.jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};
		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return (Boolean) jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};
		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	public boolean isImageLoaded(WebDriver driver, String locator) {
		boolean status = (boolean) jsExecutor.executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				getElement(driver, locator));
		if (status) {
			return true;
		} else {
			return false;
		}
	}

	public void waitForElementVisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, timeouts);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
	}

	public void waitForAllElementsVisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, timeouts);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(locator)));
	}

	public void waitForElementClickable(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, timeouts);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
	}

	public void waitForElementInvisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, timeouts);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(locator)));
	}

	public void sleepInSecond(long timeoutInSecond) {
		try {
			Thread.sleep(timeoutInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private Alert alert;
	private Select select;
	private Actions action;
	private long timeouts = 30;
	private WebDriverWait explicitWait;
	private JavascriptExecutor jsExecutor;
}
