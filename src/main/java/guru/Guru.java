package guru;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Guru {
    static String url = "http://www.demo.guru99.com/V4/manager/Managerhomepage.php";
    static  String testUrl;
    public static void main(String[] args) {
        //System.setProperty("webdriver.gecko.driver","E:\\hachik NE TROGAT\\" +
               // "test\\selenium drivera\\Mozilla GeckoDriver\\geckodriver.exe");
        //System.setProperty("webdriver.chrome.driver",Util.DRIVER_LOCATION);
        setupSystem();
        //WebDriver driver = new FirefoxDriver();
        WebDriver driver = creatProfile();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(Util.BASE_URL);

        FindPassword findPassword = new FindPassword(driver);
        findPassword.passwordWebelement().sendKeys(Util.PASSWORD);

        FindUserId findUserId = new FindUserId(driver);
        findUserId.userId().sendKeys(Util.USER_ID);

        ButtonLogin buttonLogin = new ButtonLogin(driver);
        buttonLogin.buttonLogin().click();


        testUrl = driver.getCurrentUrl();

        test1();

        driver.quit();

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
    public static void setupSystem(){
        System.setProperty("webdriver.chrome.driver",Util.DRIVER_LOCATION);
    }
    private static WebDriver initWedriver(ChromeOptions options){
        return new ChromeDriver(options);
    }
    private static WebDriver initWedriver(){
        return initWedriver(null);
    }
    private static WebDriver creatProfile() {
        String profileAdress = "C:\\Users\\Fat Faggy\\AppData\\Local\\Google\\Chrome\\User Data\\Default";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + profileAdress);
        return initWedriver(options);
    }


}

