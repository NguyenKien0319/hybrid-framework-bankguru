package pageUIs.nopCommerce;

import commons.GlobalConstants;

public class WishListPageUI {
	public static final String MY_WISHLIST_TITLE = "//div[@class='page-title']/h1[text()='Wishlist of " + GlobalConstants.FIRST_NAME + " " + GlobalConstants.LAST_NAME + "']";
	public static final String MY_WISHLIST_URL = "//span[text()='Your wishlist URL for sharing:']/following-sibling::a[@class='share-link']";
	public static final String INFOR_PRODUCT_BY_NAME = "//a[@class='product-name' and text()='%s']/parent::td/preceding-sibling::td[@class='sku']/span[text()='%s']/parent::td/following-sibling::td[@class='unit-price']/span[text()='%s']/parent::td/following-sibling::td[@class='quantity']/input[@value='%s']";
	public static final String ITEM_QUALITY = "//a[@class='ico-%s']/span[contains(@class,'qty')]";
}
