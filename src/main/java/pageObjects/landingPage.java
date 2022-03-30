package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class landingPage {

	public WebDriver driver;

	By loginbtn = By.cssSelector("a[href*='sign_in']");
	By titleText = By.xpath("//h2[contains(text(),'Featured')]");
	By popupDialog = By.xpath("//button[contains(text(),'NO')]");
	
	By navBar = By.xpath("//ul[@class='nav navbar-nav navbar-right']");

	public landingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement loginClick() { 
		return driver.findElement(loginbtn);
	}
	
	public WebElement titleText() {
		return driver.findElement(titleText);
	}
	public WebElement noThankYouText() {
		return driver.findElement(popupDialog);
				
	}
	
	public WebElement navBarAll() {
		return driver.findElement(navBar);
	}

}
