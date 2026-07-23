package stepdefinitions;

import java.util.Map;
import pages.SecureAreaPage;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import context.TestContext;
import driver.DriverManager;
import io.cucumber.java.en.*;
import pages.LoginPage;
import utils.ConfigReader;
import utils.LogUtil;

public class LoginSteps {

	private WebDriver driver;
	private LoginPage loginPage;
	private TestContext context;
	private SecureAreaPage secureAreaPage;

	public LoginSteps(TestContext context) {
		this.context = context;
		this.loginPage = context.getLoginPage();
		this.secureAreaPage = context.getSecureAreaPage();

	}

	private static final Logger logger = LogUtil.getLogger(LoginSteps.class);

	@Given("I am on the login page")
	public void i_am_on_the_login_page() {

		logger.info("Openning login page");

		context.getDriver().get(ConfigReader.getProperty("url"));

		loginPage = new LoginPage(driver);

	}

	@When("I enter the following login details:")
	public void i_enter_the_following_login_details(io.cucumber.datatable.DataTable dataTable) {

		Map<String, String> loginData = dataTable.asMap(String.class, String.class);

		logger.info("I enter username");
		loginPage.enterUserName(loginData.get("username"));
	
		
		logger.info("I enter password");
		loginPage.enterPassword(loginData.get("password"));

	}

	@When("I click the login button")
	public void i_click_the_login_button() {
		loginPage.submitButton();

	}

	@Then("I should see the homepage")
	public void i_should_see_the_homepage() {

		String message = secureAreaPage.getSuccessMessage();
		Assert.assertTrue(message.contains("You logged into a secure area"));

	}
}
