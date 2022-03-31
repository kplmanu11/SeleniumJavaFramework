package Framework.SeleniumJava;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.landingPage;
import pageObjects.loginPage;
import resources.base;

public class homePage extends base {
	//for parallel execution its better to create the driver within the scope of the this class
	public WebDriver driver;
	//To implement log below logger class should be defined 
	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver is initialized");
		
	}

	@Test(dataProvider = "getData")
	public void invokingDriver(String username, String password, String text) throws IOException, InterruptedException {
		driver.get(prop.getProperty("url"));
		log.info("navigated to the home page");
		landingPage lpg = new landingPage(driver);
		Thread.sleep(3000);
		log.info("popup cancelled");
		Assert.assertEquals(lpg.titleText().getText(), "FEATURED CghjgOURSES");
		Assert.assertTrue(lpg.navBarAll().isDisplayed());
		// System.out.println(lpg.navBarAll().isDisplayed());
		lpg.noThankYouText().click();
		lpg.loginClick().click();

		loginPage lp = new loginPage(driver);
		lp.EmailAddress().sendKeys(username);
		lp.Password().sendKeys(password);
		// System.out.print(text);
		lp.LoginButton().click();

	}

	@AfterTest
	public void TearDown() {
		driver.close();
		log.info("driver is closed and the browser process is killed");
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] obj = new Object[1][3];

		// 0th row
		obj[0][0] = "abc@gmail.com";
		obj[0][1] = "password";
		obj[0][2] = "Restricted User";

		// 1st row
		/*
		 * obj[1][0] = "xyz@gmail.com"; obj[1][1] = "password"; obj[1][2] =
		 * "Non-Restricted User";
		 */

		return obj;
	}

}
