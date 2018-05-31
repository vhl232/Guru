package guru;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageV4 {
    WebDriver driver;

    public PageV4(WebDriver driver) {
        this.driver = driver;
    }
    By password = By.xpath("//input[@name='password']");

    public WebElement passwordWebelement(){
        return driver.findElement(password);
    }

    By userId = By.xpath("//input[@name='uid']");

    public WebElement userId(){
        return driver.findElement(userId);
    }
    By login = By.xpath("//input[@name='btnLogin']");

    public WebElement buttonLogin(){
        return driver.findElement(login);
    }
}

