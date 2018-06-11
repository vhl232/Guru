package guru;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DataProviding {
    WebDriver driver;
    Alert alert;

    @BeforeTest
    public void setSystem(){
        System.setProperty("webdriver.chrome.driver",Util.DRIVER_LOCATION);
        driver = WebDriverProvider.webDriverProvider();
        driver.get(Util.BASE_URL);
    }

    @Test(dataProvider = "DataGuru")
    public void enterValidDataWithDataProvider(String user ,String pass ){

        PageV4 pageV4 = new PageV4(driver);
        Guru.test2(pageV4.passwordWebelement(),
                pageV4.userId(),
                pageV4.buttonLogin(),
                pass,
                user,
                ()->driver.findElement(By.xpath("//input[@name='uid']")));

    }
    @Test(dataProvider = "DataGuru")
    public void enterInvalidID(String user,String pass){
        PageV4 pageV4 = new PageV4(driver);
        Guru.test2(pageV4.passwordWebelement(),
                pageV4.userId(),
                pageV4.buttonLogin(),
                pass,
                user,
                ()->driver.findElement(By.xpath("//input[@name='uid']")));
        driver.switchTo().alert().accept();
    }
    @Test(dataProvider = "DataGuru")
    public void enterInvalidPass(String user,String pass){
        PageV4 pageV4 = new PageV4(driver);
        Guru.test2(pageV4.passwordWebelement(),
                pageV4.userId(),
                pageV4.buttonLogin(),
                pass,
                user,
                ()->driver.findElement(By.xpath("//input[@name='uid']")));
        driver.switchTo().alert().accept();
    }
    @AfterTest
    public void endWork(){
        driver.quit();
    }

    @DataProvider(name = "DataGuru")
    public Object[][] dataProv(Method method){
        if(method.getName().equalsIgnoreCase("enterValidDataWithDataProvider")){
        return new Object[][]{{"mngr135005", "rAtUqUt"}};
        }
          else if (method.getName().equalsIgnoreCase("enterInvalidID")){
               return new  Object[][] {{"aaa","rAtUqUt"}};
        }
            else return new  Object[][]{{"mngr135005","qwqwq"}};

        };


    }


