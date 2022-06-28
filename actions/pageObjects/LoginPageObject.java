package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.HomePageUI;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BasePage {

	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
	}

	public void inputToEmailTextbox(String invalidEmail) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX,invalidEmail);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver,LoginPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
	}

	public String getErrorMessageLoginUnsuccessful() {
		waitForElementVisible(driver,LoginPageUI.LOGIN_UNSUCCESSFUL_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.LOGIN_UNSUCCESSFUL_ERROR_MESSAGE);
	}

	public void inputToPasswordTextbox(String notFoundEmail) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX,notFoundEmail);
		
	}
}