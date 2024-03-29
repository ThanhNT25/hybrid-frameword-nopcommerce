package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class RegisterPageObject extends BasePageFactory{
private WebDriver driver;
	
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//input[@id='FirstName']" )
	private WebElement firstNameTextbox ;
	
	@FindBy(xpath ="//input[@id='LastName']" )
	private WebElement lastNameTextbox ;
	
	@FindBy(xpath ="//input[@id='Email']" )
	private WebElement emailTextbox ;
	
	@FindBy(xpath ="//input[@id='Password']" )
	private WebElement passwordTextbox ;
	
	@FindBy(xpath ="//input[@id='ConfirmPassword']" )
	private WebElement confirmPasswordTextbox ;
	
	@FindBy(xpath ="//span[@id='FirstName-error']" )
	private WebElement firstNameErrorMessage ;
	
	@FindBy(xpath ="//span[@id='LastName-error']" )
	private WebElement lastNameErrorMessage ;
	
	@FindBy(xpath ="//span[@id='Email-error']" )
	private WebElement emailErrorMessage ;
	
	@FindBy(xpath ="//span[@id='Password-error']" )
	private WebElement passwordErrorMessage ;
	
	@FindBy(xpath ="//span[@id='ConfirmPassword-error']" )
	private WebElement confirmPasswordErrorMessage ;
	
	@FindBy(xpath ="//div[@class='result']" )
	private WebElement registerSuccessMessage ;
	
	@FindBy(xpath ="//a[@class='ico-logout']" )
	private WebElement loginLink ;
	
	@FindBy(xpath ="//div[@class='message-error validation-summary-errors']//li" )
	private WebElement existMailErrorMessage ;
	
	@FindBy(xpath ="//button[@id='register-button']" )
	private WebElement registerButton ;
	
	public String getErrorMessageAtFirstnameTextbox() {
		waitForElementVisible(driver, firstNameTextbox);
		return getElementText(driver, firstNameTextbox);
	}

	public String getErrorMessageAtLastnameTextbox() {
		waitForElementVisible(driver, lastNameErrorMessage);
		return getElementText(driver, lastNameErrorMessage);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, emailErrorMessage);
		return getElementText(driver, emailErrorMessage);
	}

	public String getErrorMessageAtPasswordTextbox() {
		waitForElementVisible(driver, passwordErrorMessage);
		return getElementText(driver, passwordErrorMessage);
	}

	public String getErrorMessageAtConfirmPasswordTextbox() {
		waitForElementVisible(driver, confirmPasswordErrorMessage);
		return getElementText(driver, confirmPasswordErrorMessage);
	}

	public void inputToFirstnameTextbox(String firstName) {
		waitForElementVisible(driver, firstNameTextbox);
		sendkeyToElement(driver,firstNameTextbox,firstName);
		
	}

	public void inputToLastnameTextbox(String lastName) {
		waitForElementVisible(driver, lastNameTextbox);
		sendkeyToElement(driver,lastNameTextbox,lastName);
		
	}

	public void inputToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, emailTextbox);
		sendkeyToElement(driver,emailTextbox,emailAddress);
		
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, passwordTextbox);
		sendkeyToElement(driver,passwordTextbox,password);
	}

	public void inputToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementVisible(driver, confirmPasswordTextbox);
		sendkeyToElement(driver,confirmPasswordTextbox,confirmPassword);
		
	}

	public void clickToRegisterButton() {
		waitForElementClickable(driver, registerButton);
		clickToElement(driver, registerButton);
	}

	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver, registerSuccessMessage);
		return getElementText(driver, registerSuccessMessage);
	}

	public String getErrorExistingEmailMessage() {
		waitForElementVisible(driver, existMailErrorMessage);
		return getElementText(driver, existMailErrorMessage);
	}

	public void clickToLogoutLink() {
		waitForElementClickable(driver, loginLink);
		clickToElement(driver, loginLink);
		
	}


}
