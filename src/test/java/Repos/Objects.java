package Repos;

import org.openqa.selenium.By;

public class Objects {
    public static By slUsername = By.xpath("//input[@id='user-name']"),
    slpassword = By.xpath("//input[@id='password']"),
    loginButton =By.xpath("//input[@id='login-button']"),
    displayed = By.xpath("//span[text()='Products']"),
    errorMessage1 =By.xpath("//div[@class='error-message-container error']"),
    addToCart = By.xpath(" (//button[text()='Add to cart'])[1]"),
     addToCart2 = By.xpath(" (//button[text()='Add to cart'])[2]"),
    addToCart3 = By.xpath(" (//button[text()='Add to cart'])[3]"),
            addToCart4 = By.xpath(" (//button[text()='Add to cart'])[4]"),
            containerCart = By.xpath("//div[@class='header_secondary_container']"),
    shoppingCart = By.xpath("//div[@class='shopping_cart_container']"),
    checkout = By.xpath("//button[@id='checkout']"),
    checkoutField = By.xpath("//span[text()='Checkout: Your Information']"),
    firstName = By.xpath("//input[@name='firstName']"),
    lastName = By.xpath("//input[@name='lastName']"),
    Code = By.xpath("//input[@name='postalCode']"),
    continueButton = By.xpath("//input[@id='continue']"),


    search = By.xpath("//*[@id='center']/yt-searchbox/div[1]/div/form/input"),
    vidoe = By.xpath("//*[@id='center']/yt-searchbox/div[1]/div/form/input"),
    vidoe2 = By.xpath("//span[text()='Playwright Beginner Tutorials']");

}

