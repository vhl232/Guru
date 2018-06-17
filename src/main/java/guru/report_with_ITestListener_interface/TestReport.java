package guru.report_with_ITestListener_interface;

import guru.Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Report.class)
public class TestReport {
    WebDriver driver;


    public TestReport() {
        System.setProperty("webdriver.chrome.driver",
                    Util.DRIVER_LOCATION);
        this.driver = new ChromeDriver();
    }

    @Test
    public void enterValueInTextArea(){
        PageFactoryReport pageFactoryReport = new PageFactoryReport(driver);
        pageFactoryReport.textAreA.sendKeys("suki");
        pageFactoryReport.textAreA.submit();

    }

}
