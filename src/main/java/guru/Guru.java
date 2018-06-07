package guru;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Guru {
    static String url = "http://www.demo.guru99.com/V4/manager/Managerhomepage.php";
    static  String testUrl;
    public static void main(String[] args) throws IOException {
        //System.setProperty("webdriver.gecko.driver","E:\\hachik NE TROGAT\\" +
               // "test\\selenium drivera\\Mozilla GeckoDriver\\geckodriver.exe");
        //System.setProperty("webdriver.chrome.driver",Util.DRIVER_LOCATION);
        setupSystem();
        //WebDriver driver = new FirefoxDriver();
        WebDriver driver = creatProfile();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(Util.BASE_URL);
        Properties prop = new Properties();
        //System.out.println(Arrays.toString(new File("../").list()));
        FileInputStream read =  new FileInputStream("src/main/resources/prop.properties");
        prop.load(read);
        String id =  prop.getProperty("USER_ID");
        String pasword = prop.getProperty("PASSWORD");



        PageV4 pageV4 = new PageV4(driver);
       // pageV4.passwordWebelement().sendKeys(Util.PASSWORD);

       // pageV4.userId().sendKeys(Util.USER_ID);

       // pageV4.buttonLogin().click();


        testUrl = driver.getCurrentUrl();

        Runnable rr = ()->{
            prop.put("111", "123123123");
        };

        //test1();
        WebElementFunc s = ()->driver.findElement(By.xpath("//input[@name='uid']"));
        test2(pageV4.passwordWebelement(),
                pageV4.userId(),
                pageV4.buttonLogin(),
                pasword,
                id, s);

        driver.quit();

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
  public static void test2(WebElement pass,WebElement id,WebElement click, String pasword,String logID, WebElementFunc lamda1){
        pass.sendKeys(pasword);
        lamda1.r().sendKeys(logID);
        click.click();
    }
	Runnable r = ()->System.out.println(42);






}

