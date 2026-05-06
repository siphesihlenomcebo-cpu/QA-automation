package StepDef;

import DriveManeger.DriverSetUp;
import io.cucumber.core.eventbus.UuidGenerator;
import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static Repos.Objects.*;
import static org.junit.Assert.assertTrue;

public class MyStepdefsYouTube {

    WebDriver driver = Hooks.driver;

    @Given("User is on YouTube homepage")
    public void userIsOnYouTubeHomepage()
    {
//        driver = DriverSetUp.getDriver("CHROME");
        driver.get("https://www.youtube.com/");
    }
    @When("User searches for video {string}")
    public void user_searches_forVideo(String video)
    {
        driver.findElement(search).sendKeys(video);
        driver.findElement(vidoe).click();
    }
    @When("User clicks on the second video")
    public void user_clicks_on_the_second_video()
    {
        driver.findElement(vidoe2).click();
    }

    @Then("the video should start playing")
    public void the_video_should_start_playing()
    {
        driver.findElement(displayed).isDisplayed();
    }

}
