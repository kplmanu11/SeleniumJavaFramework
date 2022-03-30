package resources;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class base {
	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"D:\\Demo\\SeleniumJava\\src\\main\\java\\resources\\data.properties");

		prop.load(fis);
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Demo\\drivers\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			// firefox driver file
		} else if (browserName.equals("edge")) {
			System.setProperty("webdriver.edge.driver", "D:\\Demo\\drivers\\edgedriver_win64\\msedgedriver.exe");
			driver = new EdgeDriver();
		}

		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		return driver;

	}

}
