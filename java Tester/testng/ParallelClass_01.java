package testng;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;

public class ParallelClass_01 extends BaseTest {
	WebDriver driver;
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		  driver = getBrowserDriver(browserName);
		  
		  
	  }
	  
	@Test
	public void User_01_Register() {
		
	}
	@Test
	public void User_02_Register() {
		
	}
	@Test
	public void User_03_Register() {
		
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	
	
	
	
	

}
