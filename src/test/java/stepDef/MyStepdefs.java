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
import pageObject.HomePage;

import java.time.Duration;
import java.util.Random;

public class MyStepdefs extends EnvTarget {
    @Given("the user is on the ParaBank homepage")
    public void theUserIsOnTheParaBankHomepage() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        // set url
        driver.get(parabankUrl);
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='leftPanel']/h2"))
        );
    }

    @When("the user clicks the register link")
    public void theUserClicksTheRegisterLink() {

        // Without Page Object Modelling ( POM )
//        driver.findElement(By.xpath("//*[@id='loginPanel']/p[2]/a")).click();

        // With Page Object Modelling
        HomePage homePage = new HomePage(driver);

        homePage.clickRegister();
    }

    @Then("the user should be on the registration page")
    public void theUserShouldBeOnTheRegistrationPage() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='rightPanel']/h1"))
        );
    }

    @When("the user enters their name")
    public void theUserEntersTheirName() {
        driver.findElement(By.id("customer.firstName")).sendKeys("Anthony");
        driver.findElement(By.id("customer.lastName")).sendKeys("Yoab");
    }

    @And("the user enters their address details")
    public void theUserEntersTheirAddressDetails() {
        driver.findElement(By.id("customer.address.street")).sendKeys("123");
        driver.findElement(By.id("customer.address.city")).sendKeys("123");
        driver.findElement(By.id("customer.address.state")).sendKeys("123");
        driver.findElement(By.id("customer.address.zipCode")).sendKeys("123");
        driver.findElement(By.id("customer.phoneNumber")).sendKeys("123");
        driver.findElement(By.id("customer.ssn")).sendKeys("123");
    }

    @And("the user enters a valid username and password")
    public void theUserEntersAValidUsernameAndPassword() {
        Random rand = new Random();
        int randNum = rand.nextInt(1000);
        driver.findElement(By.id("customer.username")).sendKeys("antyomusa" + randNum);
        driver.findElement(By.id("customer.password")).sendKeys("user123");
    }

    @And("the user confirms the password")
    public void theUserConfirmsThePassword() {
        driver.findElement(By.id("repeatedPassword")).sendKeys("user123");
    }

    @And("the user clicks the Register button")
    public void theUserClicksTheRegisterButton() {
        driver.findElement(By.xpath("//*[@id='customerForm']/table/tbody/tr[13]/td[2]/input")).click();
    }

    @Then("the registration should be successful")
    public void theRegistrationShouldBeSuccessful() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='rightPanel']"))
        );
        driver.close();
    }

    @And("the user confirms the password incorrectly")
    public void theUserConfirmsThePasswordIncorrectly() {
        driver.findElement(By.id("repeatedPassword")).sendKeys("user123123");
    }

    @Then("an error message should appear indicating that the passwords do not match")
    public void anErrorMessageShouldAppearIndicatingThatThePasswordsDoNotMatch() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='repeatedPassword.errors']"))
        );
        driver.close();
    }
}
