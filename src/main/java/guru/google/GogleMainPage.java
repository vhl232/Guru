package guru.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import guru.Util;

public class GogleMainPage {

    WebDriver driver;
    @FindBy(id="lst-ib")
    WebElement textArea;




    public GogleMainPage(WebDriver driver) {
        this.driver  = driver;
        driver.get("https://www.google.com.ua");
        PageFactory.initElements(driver,this);
    }

}
