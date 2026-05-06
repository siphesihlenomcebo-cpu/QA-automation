package StepDef;

import DriveManeger.DriverFactory;
import DriveManeger.DriverSetUp;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.sql.DriverManager;
import java.util.Properties;

import static DriveManeger.DriverSetUp.driver;

public class Hooks {

    public static DriverSetUp hooks;
    private static Scenario scenario;

    public class Hook extends DriverSetUp {

        //    @Getter@Setter
        public static Scenario scenario;

        @Before
        public void setup(Scenario scenario) {

            Hooks.scenario = scenario;
            if (driver == null) {
                System.out.println("Test Case: " + scenario.getName());
            }

        }

        @AfterStep
        public void captureScreen(Scenario scenario) {
            byte[] source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(source, "image/png", "screen");
        }

        @After
        public void teardown(Scenario scenario) {
            System.out.println("Test Case: " + scenario.getName());
            driver.quit();
        }
    }
    @After
    public void tearDown() {
        DriverSetUp.quitDriver();
    }

    @Before
    public void setUp() {
        driver = DriverFactory.initDriver();
    }

    @After
    public void tearUP() {
        if (driver != null) {
            driver.quit();
        }
    }
        public static WebDriver driver;

        @Before
        public void setUps() {
            driver = DriverFactory.initDriver();
        }

        @After
        public void tearDowns() {
            if (driver != null) {
                driver.quit();
            }
        }
    }





