package DriveManeger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.HashMap;

public class DriverSetUp {

    public static WebDriver driver = null;

    public static WebDriver getDriver(String browser) {

        if (driver == null) {
            switch (browser.toUpperCase()) {

                case "CHROME":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    driver = new ChromeDriver(chromeOptions);
                    break;

                case "MSEDGE":
                    WebDriverManager.edgedriver().setup();
                    EdgeOptions edgeOptions = new EdgeOptions();
                    driver = new EdgeDriver(edgeOptions);
                    break;

                default:
                    throw new RuntimeException("Browser not supported: " + browser);
            }

            driver.manage().window().maximize();
            System.out.println(" Browser launched once");
        }

        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
            System.out.println(" Browser closed");
        }
    }


    {

            String runMode = System.getProperty("runMode", "local"); // local or cloud

            try {

                if (runMode.equalsIgnoreCase("cloud")) {

                    // 🔥 LambdaTest execution
                    String username = "YOUR_USERNAME";
                    String accessKey = "YOUR_ACCESS_KEY";

                    ChromeOptions browserOptions = new ChromeOptions();
                    browserOptions.setPlatformName("Windows 10");
                    browserOptions.setBrowserVersion("latest");

                    HashMap<String, Object> ltOptions = new HashMap<>();
                    ltOptions.put("username", username);
                    ltOptions.put("accessKey", accessKey);
                    ltOptions.put("build", "Swag Labs Build");
                    ltOptions.put("name", "Swag Labs Login Test");

                    browserOptions.setCapability("LT:Options", ltOptions);

                    driver = new RemoteWebDriver(
                            new URL("https://" + username + ":" + accessKey + "@hub.lambdatest.com/wd/hub"),
                            browserOptions
                    );

                    System.out.println(" Running on LambdaTest cloud");

                } else {

                    // 💻 Local execution
                    ChromeOptions chromeOptions = new ChromeOptions();
                    driver = new ChromeDriver(chromeOptions);

                    driver.manage().window().maximize();
                    System.out.println(" Running locally");
                }



            } catch (Exception e) {
                throw new RuntimeException("Driver setup failed", e);
            }
        }



}

