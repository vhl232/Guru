package guru;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PageClassFactory {

    WebDriver driver;
    @FindBy(id="lst-ib")
    WebElement textArea;


    @BeforeTest
    public void setProperty(){
       System.setProperty("webdriver.chrome.driver",
               Util.DRIVER_LOCATION);
      // driver = new ChromeDriver();
       driver.get("https://www.google.com.ua");
    }

    public PageClassFactory(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @Test
    public void findElement(){
    textArea.sendKeys("suki");
    textArea.submit();
    }
}
