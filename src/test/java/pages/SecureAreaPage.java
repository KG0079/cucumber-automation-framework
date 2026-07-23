package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.WaitUtil;

public class SecureAreaPage {

	private WebDriver driver;
	private WaitUtil waitUtil;

	private By successMessage = By.id("flash");

	public SecureAreaPage(WebDriver driver) {
		this.driver = driver;
		this.waitUtil = new WaitUtil(driver);
	}

	public String getSuccessMessage() {

		return waitUtil.waitForVisibility(successMessage).getText();
	}
}
