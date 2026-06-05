package StepDef;

import DriveManeger.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks {

    public static WebDriver driver;

    @Before
    public void setUp(Scenario scenario) {

        driver = DriverFactory.initDriver();

        System.out.println("Test Started: " + scenario.getName());
    }

    @AfterStep
    public void captureScreen(Scenario scenario) {

        byte[] source = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES);

        scenario.attach(source, "image/png", "Screenshot");
    }

    @After
    public void tearDown(Scenario scenario) {

        if (driver != null) {
            driver.quit();
        }

        System.out.println("Test Finished: " + scenario.getName());
    }
}