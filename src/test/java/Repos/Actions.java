package Repos;

import DriveManeger.DriverSetUp;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static DriveManeger.DriverSetUp.driver;

public class Actions {
    public class Action extends DriverSetUp {

        public static boolean CheckObjectExist(WebDriver driver, By element) {
            boolean exist = false;
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
                wait.until(ExpectedConditions.visibilityOfElementLocated(element));
                if (driver.findElement(element).isDisplayed()) {
                    exist = true;


                }
            } catch (Exception e) {
                System.out.println("Element not found:");
                System.out.println(e.getMessage());
            }
            return exist;
        }

        public static void EnterText(WebDriver driver, By element, String text) {
            if (CheckObjectExist(driver, element)) {
                driver.findElement(element).sendKeys(text);

            }

        }

        public static void clickObject(WebDriver driver, By element) {
            if (CheckObjectExist(driver, element)) {
                driver.findElement(element).click();

            }

        }
    }
}
