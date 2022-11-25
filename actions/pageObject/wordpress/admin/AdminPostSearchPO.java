package pageObject.wordpress.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.admin.AdminPostSearchPageUI;
import pageUIs.wordpress.admin.UserHomePageUI;

public class AdminPostSearchPO extends BasePage {
 WebDriver driver;
	
	public AdminPostSearchPO(WebDriver driver) {
		this.driver = driver;
	}

	public AdminPostAddNewPO clickToAddNewButton() {
		waitForElementClickable(driver, AdminPostSearchPageUI.ADD_NEW_BUTTON);
		clickToElement(driver, AdminPostSearchPageUI.ADD_NEW_BUTTON);
		return PageGeneratorManager.getAdminPostAddNewPage(driver);
		
	}

	public String getPageUrl(WebDriver driver2) {
		// TODO Auto-generated method stub
		return driver.getCurrentUrl();
	}

	public void enterToSearchTextbox(String postTitle) {
		waitForElementVisible(driver, AdminPostSearchPageUI.SEARCH_TEXTBOX);
		sendkeyToElement(driver, AdminPostSearchPageUI.SEARCH_TEXTBOX, postTitle);
	}

	public void clickToSearchPostsButton() {
		waitForElementClickable(driver, AdminPostSearchPageUI.SEARCH_BUTTON);
		clickToElement(driver, AdminPostSearchPageUI.SEARCH_BUTTON);
		
	}

	public boolean isPostSearchTableDisplayed(String headerID, String cellValue) {
		int headerIndex = getElementSize(driver, AdminPostSearchPageUI.TABLE_HEADER_INDEX_BY_HEADER_NAME, headerID) +1;
		waitForAllElementVisible(driver, AdminPostSearchPageUI.TABLE_ROW_VALUE_BY_HEADER_INDEX, String.valueOf(headerIndex), cellValue);
		return isElementDisplayed(driver,AdminPostSearchPageUI.TABLE_ROW_VALUE_BY_HEADER_INDEX, String.valueOf(headerIndex), cellValue);
	}

	public AdminPostAddNewPO clickToPostTitleLink(String postTitle) {
		waitForElementClickable(driver, AdminPostSearchPageUI.TITLE_POST_LINK, postTitle);
		clickToElement(driver, AdminPostSearchPageUI.TITLE_POST_LINK, postTitle);
		return PageGeneratorManager.getAdminPostAddNewPage(driver);
	}



}
