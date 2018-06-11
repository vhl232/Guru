package guru;


import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FindTextDynamicTable {
    WebDriver driver;
    Logger logger = LoggerFactory.getLogger(FindTextDynamicTable.class);
    Properties prop;
    public static String path = "E:\\selenium\\";

    @BeforeTest
    public void setSystem(){
        System.setProperty("webdriver.chrome.driver",Util.DRIVER_LOCATION);
        driver = WebDriverProvider.webDriverProvider();
        driver.get(Util.BASE_URL);
        logger.info("set system property");
    }

    @BeforeClass
    public void getInputData() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("src/main/resources/prop.properties");
        prop = new Properties();
        prop.load(fileInputStream);
        logger.info("get input data");
    }
    @Test
    public void getTextwithDynamicTable() throws IOException, InterruptedException {
        String user = prop.getProperty("USER_ID");
        String password = prop.getProperty("PASSWORD");
        PageV4 pageV4 = new PageV4(driver);
        Guru.test2(pageV4.passwordWebelement(),
                pageV4.userId(),
                pageV4.buttonLogin(),
                password,user,
                ()->driver.findElement(By.xpath("//input[@name='uid']")));
        logger.info("entry into system");
        takeScreenShot("1");
        Thread.sleep(3000);
    }



    public  void takeScreenShot(String a) throws IOException {
        File screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screen,new File(path+"_"+a+".png"));
    }
}
