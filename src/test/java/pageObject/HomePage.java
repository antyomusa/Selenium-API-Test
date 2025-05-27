package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    // This is what we called as Page Object Modelling (POM)
    // As far as i see this is very good method to achieve non-repetitive code

    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    By registerButton = By.xpath("//*[@id='loginPanel']/p[2]/a");

    // Metode click register
    public void clickRegister(){
        driver.findElement(registerButton).click();
    }
}
