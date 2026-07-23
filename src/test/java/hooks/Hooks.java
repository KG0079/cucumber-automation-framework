package hooks;

import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;

public class Hooks {

    @Before
    public void setUp() {
    	
    	ConfigReader.loadConfig();

        DriverManager.createDriver();

        DriverManager.getDriver()
                .manage()
                .window()
                .maximize();

        DriverManager.getDriver()
                .manage()
                .timeouts()
                .implicitlyWait(Duration.ofSeconds(15));

        System.out.println("Before Scenario");
    }

    @After
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {

            TakesScreenshot ts =
                    (TakesScreenshot) DriverManager.getDriver();

            byte[] screenshot =
                    ts.getScreenshotAs(OutputType.BYTES);

            scenario.attach(
                    screenshot,
                    "image/png",
                    "Failure Screenshot"
            );
        }

        System.out.println("After scenario");

        DriverManager.quitDriver();
    }
}