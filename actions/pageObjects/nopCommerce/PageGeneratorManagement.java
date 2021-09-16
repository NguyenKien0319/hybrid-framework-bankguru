package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManagement {
	private static HomePageObject homePage;
	private static LoginPageObject loginPage;
	private static RegisterPageObject registerPage;
	private static MyAccountPageObject myAccountPage;
	private static SiteMapPageObject siteMapPage;
	private static NewsPageObject newsPage;
	private static WishListPageObject wishListPage;
	private static SearchPageObject searchPage;
	
	private PageGeneratorManagement() {
		}
	public static HomePageObject getHomePage(WebDriver driver) {
		//if(homePage == null) {
			homePage = new HomePageObject(driver);
		//}
		return homePage;
	}
	
	public static LoginPageObject getLoginPage(WebDriver driver) {
		//if(loginPage == null) {
			loginPage = new LoginPageObject(driver);
		//}
		return loginPage;
	}
	
	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		//if(registerPage == null) {
			registerPage = new RegisterPageObject(driver);
		//}
		return registerPage;
	}
	
	public static MyAccountPageObject getMyAccountPage(WebDriver driver) {
		if(myAccountPage == null) {
			myAccountPage = new MyAccountPageObject(driver);
		}
		return myAccountPage;
	}
	
	public static SiteMapPageObject getSiteMapPage(WebDriver driver) {
		if(siteMapPage == null) {
			siteMapPage = new SiteMapPageObject(driver);
		}
		return siteMapPage;
	}
	
	public static SearchPageObject getSearchPage(WebDriver driver) {
		if(searchPage == null) {
			searchPage = new SearchPageObject(driver);
		}
		return searchPage;
	}
	
	public static WishListPageObject getWishListPage(WebDriver driver) {
		if(wishListPage == null) {
			wishListPage = new WishListPageObject(driver);
		}
		return wishListPage;
	}
	
	public static NewsPageObject getNewsPage(WebDriver driver) {
		if(newsPage == null) {
			newsPage = new NewsPageObject(driver);
		}
		return newsPage;
	}
}
