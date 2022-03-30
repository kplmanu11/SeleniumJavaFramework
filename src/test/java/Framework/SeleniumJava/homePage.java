package Framework.SeleniumJava;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.landingPage;
import pageObjects.loginPage;
import resources.base;

public class homePage extends base {

	@Test(dataProvider = "getData")
	public void invokingDriver(String username, String password, String text) throws IOException, InterruptedException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));

		landingPage lpg = new landingPage(driver);
		Thread.sleep(3000);
		Assert.assertEquals(lpg.titleText().getText(), "FEATURED COURSES");
		Assert.assertTrue(lpg.navBarAll().isDisplayed());
		System.out.println(lpg.navBarAll().isDisplayed());
		lpg.noThankYouText().click();
		lpg.loginClick().click();

		loginPage lp = new loginPage(driver);
		lp.EmailAddress().sendKeys(username);
		lp.Password().sendKeys(password);
		System.out.print(text);
		lp.LoginButton().click();

	}

	@DataProvider
	public Object[][] getData() {
		Object[][] obj = new Object[2][3];

		// 0th row
		obj[0][0] = "abc@gmail.com";
		obj[0][1] = "password";
		obj[0][2] = "Restricted User";

		// 1st row
		obj[1][0] = "xyz@gmail.com";
		obj[1][1] = "password";
		obj[1][2] = "Non-Restricted User";

		return obj;
	}

}
