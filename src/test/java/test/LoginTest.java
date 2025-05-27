package test;

import config.EnvTarget;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginTest extends EnvTarget {
    @Test
    public void successLogin(){
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

        // Fill in username and password
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        // Click the login button
        driver.findElement(By.xpath("//input[@type='submit'][@data-test='login-button']")).click();

        // Wait until the Products page is visible (confirmation of login success)
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[@class='title'][contains(text(),'Products')]")
        ));

        driver.quit();
    }

    @Test
    public void failedLogin(){
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

        // Fill in username and password
        driver.findElement(By.name("user-name")).sendKeys("standard_sauce");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        // Click the login button
        driver.findElement(By.xpath("//input[@type='submit'][@data-test='login-button']")).click();

        // Wait until the Products page is visible (confirmation of login success)
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id='login_button_container']/div/form/div[3]/h3/button")
        ));

        driver.quit();
    }
}
