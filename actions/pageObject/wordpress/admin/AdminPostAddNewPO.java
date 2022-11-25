package pageObject.wordpress.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.admin.AdminLoginPageUI;
import pageUIs.wordpress.admin.AdminPostAddNewPageUI;

public class AdminPostAddNewPO extends BasePage {
	WebDriver driver;
	
	public AdminPostAddNewPO(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToAddNewPostTitle(String postTitleValue) {
		waitForElementVisible(driver, AdminPostAddNewPageUI.TITLE_TEXTBOX);
		sendkeyToElement(driver, AdminPostAddNewPageUI.TITLE_TEXTBOX, postTitleValue);
		
	}

	public void enterToAddNewPostBody(String postBodyValue) {
		waitForElementClickable(driver, AdminPostAddNewPageUI.BODY_BUTTON);
		clickToElement(driver, AdminPostAddNewPageUI.BODY_BUTTON);
		
		waitForElementVisible(driver, AdminPostAddNewPageUI.BODY_TEXTBOX);
		sendkeyToElement(driver, AdminPostAddNewPageUI.BODY_TEXTBOX, postBodyValue);

		
	}

	public void clickToPublishButton() {
		waitForElementClickable(driver, AdminPostAddNewPageUI.PUBLISH_BUTTON);
		clickToElement(driver, AdminPostAddNewPageUI.PUBLISH_BUTTON);
		
	}

	public boolean isPostPublishMessageDissplay(String postPublishedMessage) {
		waitForElementVisible(driver, AdminPostAddNewPageUI.PUBLISHED_MESSAGE, postPublishedMessage);
		return isElementDisplayed(driver, AdminPostAddNewPageUI.PUBLISHED_MESSAGE, postPublishedMessage);
		
	}

	public AdminPostSearchPO openSearchPostPageUrl(String searchPostUrl) {
		openUrlPage(driver, searchPostUrl);
		return PageGeneratorManager.getAdminPostSearchPage(driver);
		
	}

	public void clickToPrePublishOrUpdateButton() {
		waitForElementClickable(driver, AdminPostAddNewPageUI.PRE_PUBLISH_BUTTON);
		clickToElement(driver, AdminPostAddNewPageUI.PRE_PUBLISH_BUTTON);
		
	}

	public void enterToEditPostBody(String postBody) {
		waitForElementVisible(driver, AdminPostAddNewPageUI.BODY_TEXTBOX);
		
		waitForAllElementVisible(driver, AdminPostAddNewPageUI.BODY_TEXTBOX);
		clearValueInElementByPressKey(driver, AdminPostAddNewPageUI.BODY_TEXTBOX);
		sendkeyToElement(driver, AdminPostAddNewPageUI.BODY_TEXTBOX, postBody);
		
	}

}
