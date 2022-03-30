package Framework.SeleniumJava;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.landingPage;
import pageObjects.loginPage;
import resources.base;

public class usingDataProvider extends base {
	
	@Test(dataProvider="getData")
	public void test(String username,String password) throws IOException {
		driver = initializeDriver();
		driver.get("https://www.qaclickacademy.com");
		
		landingPage l = new landingPage(driver);
		l.loginClick().click();
		
		loginPage lp = new loginPage(driver);
		lp.EmailAddress().sendKeys(username);
		lp.Password().sendKeys(password);
		lp.LoginButton().click();
		
		}
	
	@DataProvider
	public Object[][] getData() {
		
		Object[][] obj = new Object[1][2];
		obj[0][0]="user@gmail.com";
		obj[0][1]="pass";
		
		return obj;
	}
	
}
