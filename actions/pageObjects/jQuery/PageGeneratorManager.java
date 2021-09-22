package pageObjects.jQuery;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	private static HomePO homePage;
	
	private PageGeneratorManager() {		
	}
	
	public static HomePO getHomePage(WebDriver driver) {
		if(homePage == null) {
			homePage = new HomePO(driver);
		}
		return homePage;
	}
}
