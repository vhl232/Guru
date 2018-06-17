package guru.report_with_IReporert_Interface;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageFactoryITreport {
    WebDriver driver;
    @FindBy(id = "lst-ib")
    WebElement textArea;

    public PageFactoryITreport(WebDriver driver) {
        this.driver = driver;
        driver.get("https://www.google.com.ua");
        PageFactory.initElements(driver,this);
    }
}
