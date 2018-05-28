package guru;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FindPassword {
    WebDriver driver;

    public FindPassword(WebDriver driver) {
        this.driver = driver;
    }
    By password = By.xpath("//input[@name='password']");

    public WebElement passwordWebelement(){
        return driver.findElement(password);
    }
}
