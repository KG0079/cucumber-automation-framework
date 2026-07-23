package context;

import org.openqa.selenium.WebDriver;

import driver.DriverManager;
import pages.LoginPage;
import pages.SecureAreaPage;

public class TestContext {

	private WebDriver driver;

	private LoginPage loginPage;
	private SecureAreaPage secureAreaPage;

	public TestContext() {

		driver = DriverManager.getDriver();
		loginPage = new LoginPage(driver);

		secureAreaPage = new SecureAreaPage(driver);

	}

	public WebDriver getDriver() {
		return driver;

	}

	public LoginPage getLoginPage() {
		return loginPage;

	}

	public SecureAreaPage getSecureAreaPage() {
		return secureAreaPage;
	}

}
