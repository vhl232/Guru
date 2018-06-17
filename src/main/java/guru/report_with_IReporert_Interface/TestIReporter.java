package guru.report_with_IReporert_Interface;

import guru.Util;
import guru.report_with_ITestListener_interface.PageFactoryReport;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(value = ITreporter_implements.class)
public class TestIReporter {
    WebDriver driver;

    public TestIReporter() {
        System.setProperty("webdriver.chrome.driver",
                Util.DRIVER_LOCATION);
        this.driver = new ChromeDriver();
    }

    @Test
    public void enterValueInTextArea(){
        PageFactoryITreport pageFactoryITreport = new PageFactoryITreport(driver);
        pageFactoryITreport.textArea.sendKeys("suki");
        pageFactoryITreport.textArea.submit();

    }
}
