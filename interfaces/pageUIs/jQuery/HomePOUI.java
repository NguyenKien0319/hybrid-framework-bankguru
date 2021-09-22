package pageUIs.jQuery;

public class HomePOUI {
	public static final String PAGE_NUMBER = "//a[@class ='qgrd-pagination-page-link' and text() = '%s']";
	public static final String PAGE_NUMBER_ACTIVE = "//a[@class ='qgrd-pagination-page-link active' and text() = '%s']";
	public static final String HEADER_TEXTBOX_BY_NAME = "//div[@class='qgrd-header-text' and text()='%s']/parent::div/following-sibling::input";
	public static final String UPDATE_ROW_BY_COUNTRY = "//td[@data-key='country' and text()='%s']//parent::tr//button[@class='qgrd-%s-row-btn']";
	public static final String VALUE_ROW_TEXT_BOX = "//td[@data-key='females' and text()='%s']/following-sibling::td[@data-key='country' and text()='%s']/following-sibling::td[@data-key='males' and text()='%s']/following-sibling::td[@data-key='total' and text()='%s']";
	
	public static final String CELL_TEXTBOX = "//tr[%s]/td[%s]/input";
	public static final String COLUMN_INDEX_BY_HEADERNAME = "//th[text()='%s']/preceding-sibling::th";
	public static final String BUTTON_UPDATE_TABLE = "//tr[%s]//td[@id]//button[@title='%s']";
}
