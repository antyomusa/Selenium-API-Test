package stepDef;

import config.EnvTarget;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginStepdefs extends EnvTarget {


    @Given("The user is on login page")
    public void theUserIsOnLoginPage() {

        System.setProperty("webdriver.chrome.driver", "src/test/java/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();

        // set url
        driver.get(baseUrl);

        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);

        // Wait for the login button to be visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@type='submit'][@data-test='login-button']")
        ));
    }

    @When("The user fill username and password")
    public void theUserFillUsernameAndPassword() {
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @When("The user fill invalid username and password")
    public void theUserFillInvalidUsernameAndPassword() {
        driver.findElement(By.name("user-name")).sendKeys("standard_user123");
        driver.findElement(By.id("password")).sendKeys("secret_sauce123");
    }

    @And("The user click login button")
    public void theUserClickLoginButton() {
        driver.findElement(By.xpath("//input[@type='submit'][@data-test='login-button']")).click();
    }

    @Then("User verify login result")
    public void userVerifyLoginResult() {

        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);

        // Wait until the Products page is visible (confirmation of login success)
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[@class='title'][contains(text(),'Products')]")
        ));

        driver.quit();
    }

    @Then("User get error message")
    public void userGetErrorMessage() {

        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id='login_button_container']/div/form/div[3]/h3")
        ));

        driver.quit();
    }
}
