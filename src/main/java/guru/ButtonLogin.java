package guru;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ButtonLogin {
    WebDriver driver;

    public ButtonLogin(WebDriver driver) {
        this.driver = driver;
    }
    By login = By.xpath("//input[@name='btnLogin']");

    public WebElement buttonLogin(){
        return driver.findElement(login);
    }
}
