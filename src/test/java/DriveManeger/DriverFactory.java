package DriveManeger;

import Utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.HashMap;

public class DriverFactory {

    public static WebDriver driver;


    public static WebDriver initDriver() {


        try {

            String username = ConfigReader.get("lt.username");
            String accesskey = ConfigReader.get("lt.accesskey");


            if (username == null || username.isEmpty() ||
                    accesskey == null || accesskey.isEmpty()) {
                throw new RuntimeException("LambdaTest credentials missing in config.properties");
            }

            ChromeOptions browserOptions = new ChromeOptions();
            browserOptions.setPlatformName(ConfigReader.get("lt.platform"));
            browserOptions.setBrowserVersion(ConfigReader.get("lt.browserVersion"));

            HashMap<String,Object>ltOptions = new HashMap<>();

            ltOptions.put("username", username);
            ltOptions.put("accessKey", accesskey);
            ltOptions.put("project", ConfigReader.get("project"));
            ltOptions.put("build", ConfigReader.get("build"));
            ltOptions.put("name", ConfigReader.get("SwagLabs Automation"));
            ltOptions.put("plugin","java-java");
            ltOptions.put("w3c", true);
            ltOptions.put("visual", true);
            ltOptions.put("video", true);
            ltOptions.put("console", "error");

            driver = new RemoteWebDriver(
                    new URL("https://" + username + ":" + accesskey + "@hub.lambdatest.com/wd/hub"),
                    browserOptions
            );

            System.out.println("Running on LambdaTest cloud");

            return driver;

        } catch (Exception e) {
            throw new RuntimeException("Driver initialization failed", e);
        }
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}

