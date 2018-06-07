package guru;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageV4 {
    private WebDriver driver;

    public PageV4(WebDriver driver) {
        this.driver = driver;
        driver.get(Util.BASE_URL);
    }
    private By password = By.xpath("//input[@name='password']");

    public WebElement passwordWebelement(){
        return driver.findElement(password);
    }

    private By userId = By.xpath("//input[@name='uid']");

    public WebElement userId(){
        return driver.findElement(userId);
    }

    private By login = By.xpath("//input[@name='btnLogin']");

    public WebElement buttonLogin(){
        return driver.findElement(login);
    }
}

