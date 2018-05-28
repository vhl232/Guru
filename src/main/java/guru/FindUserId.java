package guru;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FindUserId {
    WebDriver driver;

    public FindUserId(WebDriver driver) {
        this.driver = driver;
    }
    By userId = By.xpath("//input[@name='uid']");

    public WebElement userId(){
        return driver.findElement(userId);
    }
}
