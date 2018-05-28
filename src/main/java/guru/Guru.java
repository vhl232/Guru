package guru;

import com.google.common.annotations.VisibleForTesting;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Guru {
    static String url = "http://www.demo.guru99.com/V4/manager/Managerhomepage.php";
    static  String testUrl;
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver","E:\\hachik NE TROGAT\\" +
                "test\\selenium drivera\\Mozilla GeckoDriver\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.demo.guru99.com/V4/");

        FindPassword findPassword = new FindPassword(driver);
        findPassword.passwordWebelement().sendKeys("rAtUqUt");

        FindUserId findUserId = new FindUserId(driver);
        findUserId.userId().sendKeys("mngr135005");

        ButtonLogin buttonLogin = new ButtonLogin(driver);
        buttonLogin.buttonLogin().click();


        testUrl = driver.getCurrentUrl();

        test1();

    //driver.quit();
    }

    public static void test1(){
        if(url.equals(testUrl)){
            System.out.println("test passed");
        }
        else {
            System.out.println("test not passed");
        }
    }

}

