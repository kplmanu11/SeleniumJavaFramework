package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class landingPageObject {
	public WebDriver driver;

	By loginbtn = By.cssSelector("a[href*='sign_in']");
	By titleText = By.xpath("//h2[contains(text(),'Featured')]");
	By popupDialog = By.xpath("//button[contains(text(),'NO')]");
	
	By navBar = By.xpath("//ul[@class='nav navbar-nav navbar-right']");

	public landingPageObject(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public loginPage loginClick() { 
		driver.findElement(loginbtn).click();
		loginPage lp = new loginPage(driver);
		return lp;
	}

}
