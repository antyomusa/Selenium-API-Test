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

public class LoginTDDStepDefs extends EnvTarget {

    @Given("The user is on login page tdd")
    public void theUserIsOnLoginPageTdd() {
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

    @When("^The user fill (.*) and (.*) tdd")
    public void theUserFillUsernameAndPasswordTdd(String username, String password) {
        driver.findElement(By.name("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @And("The user click login button tdd")
    public void theUserClickLoginButtonTdd() {
        driver.findElement(By.xpath("//input[@type='submit'][@data-test='login-button']")).click();
    }

    @Then("^User verify login (.*) tdd")
    public void userVerifyLoginResultTdd(String result) {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);

        if (result.equals("Passed")) {
            // Wait until the Products page is visible (confirmation of login success)
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//span[@class='title'][contains(text(),'Products')]")
            ));
        } else {
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[@id='login_button_container']/div/form/div[3]/h3")
            ));
        }

        driver.quit();
    }
}
