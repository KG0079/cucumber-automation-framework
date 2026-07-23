package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.ConfigReader;

public class DriverManager {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public static void createDriver() {
		
	String browser=ConfigReader.getProperty("browser");
	

		if (browser.equalsIgnoreCase("chrome")) {

			driver.set(new ChromeDriver());
		}

		else if (browser.equalsIgnoreCase("firefox")) {

			driver.set(new FirefoxDriver());
		}

		else {

			throw new RuntimeException("Browser not supported: " + browser);
		}
	}

	public static WebDriver getDriver() {
		return driver.get();
	}

	public static void quitDriver() {
		if (driver.get() != null) {
			driver.get().quit();
			driver.remove();
		}
	}
}
