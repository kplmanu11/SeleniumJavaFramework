package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {

	public WebDriver driver;

	public loginPage(WebDriver driver) {
		this.driver = driver;
	}

	By emailAddress = By.id("user_email");
	By password = By.id("user_password");
	By loginButton = By.cssSelector("input[type='submit']");

	public WebElement EmailAddress() {
		return driver.findElement(emailAddress);
	}

	public WebElement Password() {
		return driver.findElement(password);
	}
	
	public WebElement LoginButton() {
		return driver.findElement(loginButton);
	}

}
