package pageUIs.admin.nopCommerce;

public class EditProductUI {
	public static final String TOGGLE_ICON_BY_CARD_TITLE = "//div[@class='card-title' and contains(string(),'%s')]/following-sibling::div//i";
	public static final String UPLOAD_FILE_BY_CARD_TITLE = "//div[@class='card-title' and contains(string(),'%s')]/parent::div/following-sibling::div//input[@type='file']";
	public static final String IMAGE_UPLOAD_SUCCESS = "//div[@class='upload-picture-block']//img[contains(@src,'%s')]";
	public static final String ALT_ATTRIBUTE_TEXTBOX = "//input[@id='AddPictureModel_OverrideAltAttribute']";
	public static final String TITLE_ATTRIBUTE_TEXTBOX = "//input[@id='AddPictureModel_OverrideTitleAttribute']";
	public static final String DISPLAYORDER_ATTRIBUTE_TEXTBOX = "//div[@class='card-title' and contains(string(),'Pictures')]/parent::div/following-sibling::div//span[@class='k-icon k-i-arrow-60-up']";
	public static final String ADD_PRODUCT_PICTURE_BUTTON = "//button[@id='addProductPicture']";
	public static final String ATTRIBUTE_INFO_NEW_IMAGE = "//a[contains(@href,'%s')]/parent::td/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']";
	public static final String SAVE_BUTTON = "//button[@name='save']";
	public static final String DELETE_IMAGE_BUTTON = "//a[contains(@href,'%s')]/parent::td//following-sibling::td/a[string()='Delete']";
	public static final String NO_DATA_IN_TABLE_BY_CARDTITLE = "//div[@class='card-title' and string()='%s']//parent::div//following-sibling::div[@class='card-body']//td[text()='No data available in table']";
	
}
