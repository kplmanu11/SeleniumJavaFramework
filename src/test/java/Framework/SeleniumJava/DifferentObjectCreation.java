package Framework.SeleniumJava;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import pageObjects.landingPageObject;
import pageObjects.loginPage;
import resources.base;

public class DifferentObjectCreation extends base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
	}
	
	@Test(dataProvider = "getData")
	public void invokinDriverDifferent(String username,String password) throws InterruptedException {
		driver.get(prop.getProperty("url"));
		
		landingPageObject lpo = new landingPageObject(driver);
		Thread.sleep(3000);
		loginPage lp = lpo.loginClick();
		
		lp.EmailAddress().sendKeys(username);
		lp.Password().sendKeys(password);
		lp.LoginButton().click();
		
		
	}
	
	@AfterTest
	public void TearDown() {
		driver.close();
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] obj = new Object[1][2];
		
		obj[0][0]="ram@gmai.com";
		obj[0][1]="test";
		
		return obj;
	}
	
	

}
