package StepDef;

import DriveManeger.DriverSetUp;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.sql.DriverManager;

import static DriveManeger.DriverSetUp.driver;
import static Repos.Objects.*;

public class MyStepdefs {

    WebDriver driver;

    @Given("User is on SwagLabs page")
    public void userIsOnSwagLabsPage()  {
//        driver = DriverSetUp.getDriver("CHROME");
        driver = Hooks.driver;
        driver.get("https://www.saucedemo.com/");
        System.out.println(driver.getCurrentUrl());
    }

    @When("User enters username {string}")
    public void userEntersUsername(String username) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(slUsername).sendKeys(username);
    }

    @And("User enters password {string}")
    public void userEntersPassword(String password)

    {
        driver.findElement(slpassword).sendKeys(password);
    }

    @And("User clicks login button")
    public void userClicksLoginButton()
    {
        driver.findElement(loginButton).click();
    }

    @Then("Product page is displayed")
    public void productPageIsDisplayed()
    {
//        driver.findElement(displayed).isDisplayed();
        Assert.assertTrue(driver.findElement(displayed).isDisplayed());
    }

    @Then("Error message {string} should be displayed")
    public void errorMessageShouldBeDisplayed(String arg0)
    {
        driver.findElement(errorMessage1).getText();
    }

    @When("User clicks product to cart")
    public void userClicksProductToCart()
    {
        driver.findElement(addToCart).click();
    }


    @Then("Your cart page is displayed")
    public void yourCartPageIsDisplayed()
    {
        driver.findElement(containerCart).isDisplayed();
    }

    @When("user click shopping cart")
    public void userClickShoppingCart()
    {
        driver.findElement(shoppingCart).click();
    }

    @Then("Checkout Your Information page is displayed")
    public void checkoutYourInformationPageIsDisplayed()
    {
        driver.findElement(checkoutField).isDisplayed();
    }
    @When("User clicks checkout")
    public void userClicksCheckout()
    {
        driver.findElement(checkout).click();
    }


    @When("User enters first name {string}")
    public void userEntersFirstName(String firstname)
    {
        driver.findElement(firstName).sendKeys(firstname);
    }

    @And("User enters last name {string}")
    public void userEnterLastName(String lastname)
    {
        driver.findElement(lastName).sendKeys(lastname);

    }
    @And("User enter code {string}")
    public void userEnterCode(String postalCode)
    {
        driver.findElement(Code).sendKeys(postalCode);
    }

    @When("User clicks continue button")
    public void userClicksContinueButton()
    {
        driver.findElement(continueButton).click();
    }


    @Then("Overview page is displayed")
    public void overviewPageIsDisplayed()
    {
        driver.findElement(containerCart).isDisplayed();
    }


    @When("the user adds three different products to the cart")
    public void theUserAddsThreeDifferentProductsToTheCart()
    {
        driver.findElement(addToCart).click();
        driver.findElement(addToCart2).click();
        driver.findElement(addToCart3).click();
        driver.findElement(addToCart4).click();
    }
}
