package pageObject.facebook;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.facebook.LoginPageUI;

public class LoginPageObject extends BasePage{
	WebDriver driver;
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToCreateNewAccountButton() {
		waitForElementClickable(driver, LoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);
		clickToElement(driver, LoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);
	}

	public boolean isEmailAddressTextboxDisplayed() {
		waitForAllElementVisible(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX);
		return isElementDisplayed(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX);
	}

	public void enterToEmailAddressTextbox(String emailAddress) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX);
		sendkeyToElement(driver,LoginPageUI.EMAIL_ADDRESS_TEXTBOX, emailAddress);
		
	}

	public boolean isConfirmEmailAddressTextboxDisplayed() {
		return isElementDisplayed(driver, LoginPageUI.CONFIRM_EMAIL_ADDRESS_TEXTBOX);
	}

	public void clickToCloseIconAtRegisterForm() {
		waitForElementClickable(driver, LoginPageUI.CLOSE_BUTTON);
		clickToElement(driver, LoginPageUI.CLOSE_BUTTON);
		
	}

	public boolean isConfirmEmailAddressTextboxUnDisplayed() {
		waitForElementUndisplayed(driver, LoginPageUI.CONFIRM_EMAIL_ADDRESS_TEXTBOX);
		return isElementUndisplayed(driver, LoginPageUI.CONFIRM_EMAIL_ADDRESS_TEXTBOX);
	}

}
