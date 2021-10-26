package pageObjects.sauceDemo;

import org.openqa.selenium.WebDriver;


public class PageGeneratorManager {
	private static LoginPO loginPage;
	private static ProductPO productPage;
	
	private PageGeneratorManager() {
	}
	
	public static LoginPO getLoginPage(WebDriver driver) {
		return loginPage = new LoginPO(driver);
	}
	
	public static ProductPO getProductPage(WebDriver driver) {
		return productPage = new ProductPO(driver);
	}
}
