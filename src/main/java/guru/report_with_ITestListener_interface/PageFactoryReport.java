package guru.report_with_ITestListener_interface;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageFactoryReport {

    WebDriver driver;
    @FindBy(id = "lst-ib")
    WebElement textAreA;

    public PageFactoryReport(WebDriver driver) {
        this.driver = driver;
        driver.get("https://www.google.com.ua");
        PageFactory.initElements(driver,this);
    }
}
