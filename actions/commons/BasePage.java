package commons;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
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

import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.MyAccountPageObject;
import pageObjects.nopCommerce.NewsPageObject;
import pageObjects.nopCommerce.PageGeneratorManagement;
import pageObjects.nopCommerce.SearchPageObject;
import pageObjects.nopCommerce.SiteMapPageObject;
import pageObjects.nopCommerce.WishListPageObject;
import pageUIs.nopCommerce.BasePageUI;

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
	
	public Set<Cookie> getAllCookies(WebDriver driver) {
		return driver.manage().getCookies();
	}
	
	public void SetAllCookies(WebDriver driver, Set<Cookie> allCookies) {
		for (Cookie cookie : allCookies) {
			driver.manage().addCookie(cookie);
		}
	}

	public Alert waitElementPresence(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	public void aceptAlert(WebDriver driver) {
		waitElementPresence(driver);
		alert = driver.switchTo().alert();
		alert.accept();
	}

	public void cancelAlert(WebDriver driver) {
		waitElementPresence(driver);
		alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public void senkeysToAlert(WebDriver driver, String value) {
		waitElementPresence(driver);
		alert = driver.switchTo().alert();
		alert.sendKeys(value);
	}

	public String getTextToAlert(WebDriver driver) {
		waitElementPresence(driver);
		alert = driver.switchTo().alert();
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

	public String getDynamicLocator(String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
		return locator;
	}

	public WebElement getElement(WebDriver driver, String locator) {
		return driver.findElement(getByXpath(locator));
	}

	public WebElement getElement(WebDriver driver, String locator, String... values) {
		return driver.findElement(getByXpath(getDynamicLocator(locator, values)));
	}
	
	public String getElementAttribute(WebDriver driver,String locator, String attributeName, String... values) {
		return getElement(driver,getDynamicLocator(locator, values)).getAttribute(attributeName);
	}

	public List<WebElement> getElements(WebDriver driver, String locator) {
		return driver.findElements(getByXpath(locator));
	}
	
	public List<WebElement> getElements(WebDriver driver, String locator, String...params) {
		return driver.findElements(getByXpath(getDynamicLocator(locator, params)));
	}

	public void clickToElement(WebDriver driver, String locator) {
		getElement(driver, locator).click();
	}

	public void clickToElement(WebDriver driver, String locator, String... values) {
		getElement(driver, getDynamicLocator(locator, values)).click();
	}

	public void sendkeysToElement(WebDriver driver, String locator, String value) {
		getElement(driver, locator).clear();
		getElement(driver, locator).sendKeys(value);
	}

	public void sendkeysToElement(WebDriver driver, String locator, String value, String... values) {
		getElement(driver, getDynamicLocator(locator, values)).clear();
		getElement(driver, getDynamicLocator(locator, values)).sendKeys(value);
	}

	public int getElementSize(WebDriver driver, String locator) {
		return getElements(driver, locator).size();
	}
	
	public int getElementSize(WebDriver driver, String locator, String...params) {
		locator = getDynamicLocator(locator, params);
		return getElements(driver, locator).size();
	}
	
	public void selectDropDownByText(WebDriver driver, String locator, String item) {
		select = new Select(getElement(driver, locator));
		select.selectByVisibleText(item);
	}
	
	public void selectDropDownByText(WebDriver driver, String locator, String item, String... params) {
		select = new Select(getElement(driver, getDynamicLocator(locator, params)));
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
		sleepInMiliSecond(1000);

		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		List<WebElement> allItems = explicitWait
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childItemLocator)));

		for (WebElement item : allItems) {
			if (item.getText().trim().equals(expectedItem)) {
				jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				sleepInMiliSecond(1000);

				item.click();
				sleepInMiliSecond(1000);
				break;
			}
		}
	}

	public String getAttributeValue(WebDriver driver, String locator, String attributeName) {
		return getElement(driver, locator).getAttribute(attributeName);
	}
	
	public String getAttributeValue(WebDriver driver, String locator, String attributeName, String... params) {
		return getElement(driver, getDynamicLocator(locator, params)).getAttribute(attributeName);
	}

	public String getTextElement(WebDriver driver, String locator) {
		return getElement(driver, locator).getText();
	}
	
	public String getTextElement(WebDriver driver, String locator, String...params) {
		return getElement(driver, getDynamicLocator(locator, params)).getText();
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
	
	public void checkTheCheckBoxOrRadio(WebDriver driver, String locator, String... params) {
		if (!isElementSelected(driver, getDynamicLocator(locator, params))) {
			getElement(driver, getDynamicLocator(locator, params)).click();
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

	public Boolean isElementDisplayed(WebDriver driver, String locator, String... values) {
		return getElement(driver, getDynamicLocator(locator, values)).isDisplayed();
	}
	
	public boolean isElementUnDisplayed(WebDriver driver, String locator) {
		overrideGlobalTimeout(driver,GlobalConstants.SHORT_TIMEOUT);
		List<WebElement> elements = getElements(driver, locator);
		overrideGlobalTimeout(driver, GlobalConstants.LONG_TIMEOUT);
		if(elements.size() == 0) {
			return true;
		}
		else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void overrideGlobalTimeout(WebDriver driver, long timeOut) {
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
	}

	public Boolean isElementEnabled(WebDriver driver, String locator) {
		return getElement(driver, locator).isEnabled();
	}

	public Boolean isElementSelected(WebDriver driver, String locator) {
		return getElement(driver, locator).isSelected();
	}
	public Boolean isElementSelected(WebDriver driver, String locator, String... params) {
		return getElement(driver, getDynamicLocator(locator, params)).isSelected();
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
	
	public void hoverMouseToElement(WebDriver driver, String locator, String... params) {
		action = new Actions(driver);
		action.moveToElement(getElement(driver, getDynamicLocator(locator, params))).perform();
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
	
	public void presskeyToElement(WebDriver driver, String locator, Keys key, String... params) {
		action = new Actions(driver);
		action.sendKeys(getElement(driver, locator,params), key).perform();
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
		sleepInMiliSecond(1);
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
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
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

	protected void waitForElementVisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
	}
	
	protected void waitForElementPresence(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.presenceOfElementLocated(getByXpath(locator)));
	}

	protected void waitForElementVisible(WebDriver driver, String locator, String... values) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait
				.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(getDynamicLocator(locator, values))));
	}

	protected void waitForAllElementsVisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(locator)));
	}
	
	protected void waitForAllElementsVisible(WebDriver driver, String locator, String... params) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(getDynamicLocator(locator, params))));
	}

	protected void waitForElementClickable(WebDriver driver, String locator, String... values) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(getDynamicLocator(locator, values))));
	}
	
	protected void waitForElementClickable(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
	}

	public void waitForElementInvisible(WebDriver driver, String locator, String... values) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait
				.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(getDynamicLocator(locator, values))));
	}

	public void sleepInMiliSecond(long timeoutInSecond) {
		try {
			Thread.sleep(timeoutInSecond);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public SiteMapPageObject openSiteMapPage(WebDriver driver) {
		waitForAllElementsVisible(driver, BasePageUI.SITE_MAP_LINK);
		clickToElement(driver, BasePageUI.SITE_MAP_LINK);
		return PageGeneratorManagement.getSiteMapPage(driver);
	}

	public SearchPageObject openSearchPage(WebDriver driver) {
		waitForAllElementsVisible(driver, BasePageUI.SEARCH_LINK);
		clickToElement(driver, BasePageUI.SEARCH_LINK);
		return PageGeneratorManagement.getSearchPage(driver);
	}

	public WishListPageObject openWishListPage(WebDriver driver) {
		waitForAllElementsVisible(driver, BasePageUI.WISH_LIST_LINK);
		clickToElement(driver, BasePageUI.WISH_LIST_LINK);
		return PageGeneratorManagement.getWishListPage(driver);
	}

	public NewsPageObject openNewsPage(WebDriver driver) {
		waitForAllElementsVisible(driver, BasePageUI.NEWS_LINK);
		clickToElement(driver, BasePageUI.NEWS_LINK);
		return PageGeneratorManagement.getNewsPage(driver);
	}

	public MyAccountPageObject openMyAccountPage(WebDriver driver) {
		waitForAllElementsVisible(driver, BasePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, BasePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManagement.getMyAccountPage(driver);
	}

	// 1 ham by DynamicLocator in footer
	public void openFooterPage(WebDriver driver, String pageName) {
		waitForElementVisible(driver, BasePageUI.DYNAMIC_FOOTER_LINK, pageName);
		clickToElement(driver, BasePageUI.DYNAMIC_FOOTER_LINK, pageName);
	}

	public String getTextDropDownList(WebDriver driver, String locator) {
		select = new Select(getElement(driver, locator));
		return select.getFirstSelectedOption().getText();
	}
	
	public String getTextDropDownList(WebDriver driver, String locator, String... params) {
		select = new Select(getElement(driver, getDynamicLocator(locator, params)));
		return select.getFirstSelectedOption().getText();
	}
	//Submit button by Name
	public void clickSubmitButtonByName(WebDriver driver, String... params) {
		waitForElementClickable(driver, BasePageUI.SUBMIT_BUTTON_BY_NAME, params);
		clickToElement(driver, BasePageUI.SUBMIT_BUTTON_BY_NAME, params);
	}
	
	//Search product by name
	public SearchPageObject searchProductByName(WebDriver driver, String productName) {
		waitForElementVisible(driver, BasePageUI.SEARCH_TEXTBOX);
		sendkeysToElement(driver, BasePageUI.SEARCH_TEXTBOX, productName);
		waitForElementClickable(driver, BasePageUI.SEACH_BOX_BUTTON);
		clickToElement(driver, BasePageUI.SEACH_BOX_BUTTON);
		return PageGeneratorManagement.getSearchPage(driver);
	}
	
	//Open header-menu not mobile
	public void openHeaderMenuNotMobile(WebDriver driver, String headerName, String headerSubName) {
		waitForElementVisible(driver, BasePageUI.HEADER_MENU_BY_NAME, headerName);
		hoverMouseToElement(driver, BasePageUI.HEADER_MENU_BY_NAME, headerName);
		waitForElementClickable(driver, BasePageUI.HEADER_SUB_MENU_BY_NAME, headerName, headerSubName);
		clickToElement(driver, BasePageUI.HEADER_SUB_MENU_BY_NAME, headerName, headerSubName);
	}
	//Sort
	public boolean isDataStringSortedByAscending(WebDriver driver, String locator) {
		List<WebElement> elements = getElements(driver, locator);
		List<String> names = elements.stream().map(name->name.getText()).collect(Collectors.toList());
		List<String> sortNames = new ArrayList<String>(names);
		Collections.sort(sortNames);
		return sortNames.equals(names);
	}
	
	public boolean isDataStringSortedByDescending(WebDriver driver, String locator) {
		List<WebElement> elements = getElements(driver, locator);
		List<String> names = elements.stream().map(name-> name.getText()).collect(Collectors.toList());
		List<String> sortNames = new ArrayList<String>(names);
		Collections.sort(sortNames);
		Collections.reverse(sortNames);
		return sortNames.equals(names);
	}
	
	public boolean isDataFloatSortedByAscending(WebDriver driver, String locator) {
		ArrayList<Float> arrayList = new ArrayList<Float>();
		List<WebElement> elements = getElements(driver, locator);
		for (WebElement element : elements) {
			arrayList.add(Float.parseFloat(element.getText().replace("$", "").replace(",", "").trim()));
		}
		ArrayList<Float> sortList = new ArrayList<Float>(arrayList);
		Collections.sort(sortList);
		return sortList.equals(arrayList);
	}
	
	public boolean isDataFloatSortedByDescending(WebDriver driver, String locator) {
		ArrayList<Float> arrayList = new ArrayList<Float>();
		List<WebElement> elements = getElements(driver, locator);
		for (WebElement element : elements) {
			arrayList.add(Float.parseFloat(element.getText().replace("$", "").replace(",", "").trim()));
		}
		ArrayList<Float> sortList = new ArrayList<Float>(arrayList);
		Collections.sort(sortList);
		Collections.reverse(sortList);
		return sortList.equals(arrayList);
	}
	//ReviewProduct
	public void getProductByAction(WebDriver driver, String buttonAction) {
		waitForElementClickable(driver, BasePageUI.BUTTON_BY_ACTION, buttonAction);
		clickToElement(driver, BasePageUI.BUTTON_BY_ACTION, buttonAction);
	}
	public boolean isAddToWishListMessageSuccessDisplayed(WebDriver driver) {
		waitForElementVisible(driver, BasePageUI.ADD_TO_WISHLIST_SUCCESS_TEXT);
		return isElementDisplayed(driver, BasePageUI.ADD_TO_WISHLIST_SUCCESS_TEXT);
	}
	//Open wishlistPage
	public WishListPageObject clickToOpenWishList(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.WISHLIST_LINK_IN_SUCCESS_TEXT);
		clickToElement(driver, BasePageUI.WISHLIST_LINK_IN_SUCCESS_TEXT);
		return PageGeneratorManagement.getWishListPage(driver);
	}
	
	public void clickAddToCartCheckBoxByProductName(WebDriver driver, String productName) {
		waitForElementClickable(driver, BasePageUI.ADD_TO_CART_CHECKBOX_BY_PRODUCTNAME, productName);
		checkTheCheckBoxOrRadio(driver, BasePageUI.ADD_TO_CART_CHECKBOX_BY_PRODUCTNAME, productName);
	}
	public void clickWishListAcTionButton(WebDriver driver, String actionButton) {
		waitForElementClickable(driver, BasePageUI.WISHLIST_ACTION_BUTTON, actionButton);
		clickToElement(driver, BasePageUI.WISHLIST_ACTION_BUTTON, actionButton);
	}
	public String getInforProductValue(WebDriver driver, String inforProductValue) {
		waitForElementVisible(driver, BasePageUI.INFOR_PRODUCT_VALUE, inforProductValue);
		return getTextElement(driver, BasePageUI.INFOR_PRODUCT_VALUE, inforProductValue);
	}
	//Goback HomePage
	public HomePageObject clickToHeaderLogo(WebDriver driver) {
		waitForElementVisible(driver, BasePageUI.LOGO_LINK);
		clickToElement(driver, BasePageUI.LOGO_LINK);
		return PageGeneratorManagement.getHomePage(driver);
	}
	
	//Patern Object
	public void clickToHeaderByName(WebDriver driver, String headerName) {
		waitForElementClickable(driver, BasePageUI.DYNAMIC_HEADER_BYNAME, headerName);
		clickToElement(driver, BasePageUI.DYNAMIC_HEADER_BYNAME, headerName);
	}
	
	public void clickToRadioButtonByName(WebDriver driver, String buttonName) {
		waitForElementClickable(driver, BasePageUI.DYNAMIC_RADIO_BUTTON_BYNAME, buttonName);
		checkTheCheckBoxOrRadio(driver, BasePageUI.DYNAMIC_RADIO_BUTTON_BYNAME, buttonName);
	}
	
	public void inputTextBoxByID(WebDriver driver, String ID, String value) {
		waitForElementVisible(driver, BasePageUI.DYNAMIC_TEXTBOX_BY_ID, ID);
		sendkeysToElement(driver, BasePageUI.DYNAMIC_TEXTBOX_BY_ID, value, ID);
	}
	
	public void clickButtonByName(WebDriver driver, String buttonName) {
		waitForElementClickable(driver, BasePageUI.DYNAMIC_BUTTON_BY_NAME, buttonName);
		clickToElement(driver, BasePageUI.DYNAMIC_BUTTON_BY_NAME, buttonName);
	}
	
	//Sort_sauce
	public boolean isDataStringSortByASC_sauce(WebDriver driver, String locator) {
		List<WebElement> elementLists = getElements(driver, locator);
		List<String> productNames = elementLists.stream().map(n->n.getText()).collect(Collectors.toList()); 
		List<String> sortProductNames = new ArrayList<String>(productNames);
		Collections.sort(sortProductNames);
		return productNames.equals(sortProductNames);
	}
	public boolean isDataStringSortByDESC_sauce(WebDriver driver, String locator) {
		List<WebElement> elementLists = getElements(driver, locator);
		List<String> productNames = elementLists.stream().map(n->n.getText()).collect(Collectors.toList()); 
		List<String> sortProductNames = new ArrayList<String>(productNames);
		Collections.sort(sortProductNames);
		Collections.reverse(sortProductNames);
		return productNames.equals(sortProductNames);
	}
	public boolean isDataFloatSortByASC_sauce(WebDriver driver, String locator) {
		ArrayList<Float> arrayList = new ArrayList<Float>();
		List<WebElement> elementLists = getElements(driver, locator);
		for (WebElement element : elementLists) {
			arrayList.add(Float.parseFloat(element.getText().replace("$", "").trim()));
		}
		ArrayList<Float> sortFloat = new ArrayList<Float>(arrayList);
		Collections.sort(sortFloat);
		return arrayList.equals(sortFloat);
	}
	public boolean isDataFloatSortByDESC_sauce(WebDriver driver, String locator) {
		ArrayList<Float> arrayList = new ArrayList<Float>();
		List<WebElement> elementLists = getElements(driver, locator);
		for (WebElement element : elementLists) {
			arrayList.add(Float.parseFloat(element.getText().replace("$", "").trim()));
		}
		ArrayList<Float> sortFloat = new ArrayList<Float>(arrayList);
		Collections.sort(sortFloat);
		Collections.reverse(sortFloat);
		return arrayList.equals(sortFloat);
	}
	
	private Alert alert;
	private Select select;
	private Actions action;
	private WebDriverWait explicitWait;
	private JavascriptExecutor jsExecutor;
}
