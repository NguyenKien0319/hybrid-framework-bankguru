package pageObjects.admin.nopCommerce;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	private static LoginPageObject loginPage;
	private static DashBoardPO dashboardPage;
	private static ProductPO productPage;
	private static EditProductPO editProductPage;
	
	public PageGeneratorManager() {
		}
	
	public static LoginPageObject getLoginPage(WebDriver driver) {
		return loginPage = new LoginPageObject(driver);
	}
	
	public static DashBoardPO getDashBoardPage(WebDriver driver) {
		return dashboardPage = new DashBoardPO(driver);
	}

	public static ProductPO getProductPage(WebDriver driver) {
		return productPage = new ProductPO(driver);
	}
	
	public static EditProductPO getEditProductPage(WebDriver driver) {
		return editProductPage = new EditProductPO(driver);
	}
}
