package pageObject.jQuery.dataTable;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.jquery.datatable.PageGeneratorManager;

import commons.BasePage;
import pageUIs.jQuery.dataTable.HomePageUI;

public class HomePageObject extends BasePage{
	private WebDriver driver;
	
	public HomePageObject (WebDriver driver) {
		this.driver = driver;
	}

	public void openPagingByNumber(String pageNumber) {
		waitForElementClickable(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
		clickToElement(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber );
		
	}

	public void enterToHeaderTextboxByLabel(String headerLabel, String value) {
		waitForElementVisible(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, headerLabel);
		sendkeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL,value, headerLabel);
		pressKeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, Keys.ENTER, headerLabel);
		
	}

	public boolean isPageNumberActived(String pageNumber) {
		waitForElementVisible(driver, HomePageUI.PAGINATION_PAGE_ACTIVED_BY_NUMBER,pageNumber);
		return isElementDisplayed(driver, HomePageUI.PAGINATION_PAGE_ACTIVED_BY_NUMBER,pageNumber);
	}

	public List<String> getValueEachRowAtAllPage() {
		int totalPage =  getElementSize(driver, HomePageUI.TOTAL_PAGINATION);
		System.out.println("Total size = " +totalPage);
		List<String> allRowValuesaAllPage = new ArrayList<String>();
		
		// khong muon lay data cos trung du lieu
		// Set<String> allRowValueUniqueAllPage = new HashSet<String>();
		
		// duyet qua tat ca cac page
		for(int index = 1; index <= totalPage; index++) {
			clickToElement(driver, HomePageUI.PAGINATION_PAGE_INDEX, String.valueOf(index));
			sleepInSecond(1);
			
			//get text cua all row moi page dua vao arraylist
			List<WebElement> allRowElementEachPage = getListWebElement(driver, HomePageUI.ALL_ROW_EACH_PAGE);
			for(WebElement eachRow : allRowElementEachPage) {
				allRowValuesaAllPage.add(eachRow.getText());
			}
		}
		
		// In ra tat ca gia tri row -  tat ca cac page
		for (String value : allRowValuesaAllPage) {
			System.out.println("-------------------------------------");
			System.out.println(value);
			
		}
		
		return allRowValuesaAllPage;
		
	}

	public void enterToTextboxByColumnNameAtRowNumber(String columnName, String rowNumber, String value) {
		//column index ddua vao ten cot
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName)+1;
		
		//sendky vao dong nao
		waitForElementVisible(driver, HomePageUI.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
		sendkeyToElement(driver, HomePageUI.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, value, rowNumber, String.valueOf(columnIndex));
		
	}

	public void selectDropdownColumnNameAtRowNumber(String columnName, String rowNumber, String valueToSelect) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName)+1;
		waitForElementClickable(driver,HomePageUI.DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
		selectItemDefaultDropdown(driver,HomePageUI.DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX, valueToSelect, rowNumber, String.valueOf(columnIndex));
	}

	public void clickToLoadButton() {
		waitForElementClickable(driver,HomePageUI.BUTTON_LOAD_DATA );
		clickToElement(driver, HomePageUI.BUTTON_LOAD_DATA);
		
	}

	public void checkToCheckboxByColumnNameAtRow(String columnName, String rowNumber ) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName)+1;
		waitForElementClickable(driver,HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
		checkToDefaultCheckboxOrRadio(driver,HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
		
	}

	public void uncheckToCheckboxByColumnNameAtRow(String columnName, String rowNumber) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName)+1;
		waitForElementClickable(driver,HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
		uncheckToDefaultCheckbox(driver,HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
	}

	public void clickToIconByRowNumber(String rowNumber, String iconName) {
		waitForElementClickable(driver,HomePageUI.ICON_NAME_BY_ROW_NUMBER, rowNumber, iconName);
		clickToElement(driver, HomePageUI.ICON_NAME_BY_ROW_NUMBER, rowNumber, iconName);
	}


}
