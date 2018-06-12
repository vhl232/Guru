package guru;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

public class CreatGroupsAndDataProviding {
    public static String path = "E:\\selenium\\";
        WebDriver driver;

        @BeforeTest
        public void setSystem(){
            System.setProperty("webdriver.chrome.driver",Util.DRIVER_LOCATION);
            driver = WebDriverProvider.webDriverProvider();
            driver.get(Util.BASE_URL);
        }

        @Test(dataProvider = "DataGuru",groups = {"validData"})
        public void enterValidDataWithDataProvider(String user ,String pass ) throws IOException {

            PageV4 pageV4 = new PageV4(driver);
            Guru.test2(pageV4.passwordWebelement(),
                    pageV4.userId(),
                    pageV4.buttonLogin(),
                    pass,
                    user,
                    ()->driver.findElement(By.xpath("//input[@name='uid']")));
           // takeScreenShot("2");

        }
        @Test(dataProvider = "DataGuru",groups = {"invaliData"})
        public void enterInvalidID(String user,String pass) throws IOException {
            PageV4 pageV4 = new PageV4(driver);
            Guru.test2(pageV4.passwordWebelement(),
                    pageV4.userId(),
                    pageV4.buttonLogin(),
                    pass,
                    user,
                    ()->driver.findElement(By.xpath("//input[@name='uid']")));
            //takeScreenShot("3");
            driver.switchTo().alert().accept();

        }
        @Test(dataProvider = "DataGuru",groups = {"invaliData"})
        public void enterInvalidPass(String user,String pass) throws IOException {

            PageV4 pageV4 = new PageV4(driver);
            Guru.test2(pageV4.passwordWebelement(),
                    pageV4.userId(),
                    pageV4.buttonLogin(),
                    pass,
                    user,
                    ()->driver.findElement(By.xpath("//input[@name='uid']")));
            //takeScreenShot("4");
            driver.switchTo().alert().accept();

        }
        @AfterTest
        public void endWork(){
            driver.quit();
        }

        @DataProvider(name = "DataGuru")
        public Object[][] dataProv( ITestNGMethod a) {
            Object[][] data = null;
            for (String group : a.getGroups()) {
                if (group.equalsIgnoreCase("validData")) {
                     data =  new Object[][]{{"mngr135005", "rAtUqUt"}};
                }
                else if (group.equalsIgnoreCase("invaliData")) {
                     data =  new Object[][]{{"aaa", "rAtUqUt"},
                                                  {"mngr135005", "qwqwq"}};
                }
            }
             return  data;
        }

    public  void takeScreenShot(String a) throws IOException {
        File screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screen,new File(path+" "+a+".png"));
    }

    }




