package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.WaitUtil;

public class LoginPage {

	private WebDriver driver;
	private WaitUtil waitUtil;

	@FindBy(id = "username")
	private By username;

	@FindBy(id = "password")
	private By password;

	@FindBy(css = "button[type='submit']")
	private By submitButton;

	public LoginPage(WebDriver driver) {

		this.driver = driver;

		this.waitUtil = new WaitUtil(driver);

		PageFactory.initElements(driver, this);
	}

	public void enterUserName(String usernameText) {

		waitUtil.waitForVisibility(username).sendKeys(usernameText);
	}

	public void enterPassword(String passwordText) {

		waitUtil.waitForVisibility(password).sendKeys(passwordText);
	}

	public void submitButton() {

		waitUtil.waitForClickable(submitButton).click();
	}
}