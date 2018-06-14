package guru;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.EventListener;

public class WebDriverProvider {
    private static WebDriver driver;

    private WebDriverProvider() {
    }
    public static WebDriver webDriverProvider(){
        if(driver==null){
            driver = new EventFiringWebDriver(new ChromeDriver());
            //MyEventListner eventListener = new MyEventListner();
            ((EventFiringWebDriver)driver).register(new MyEventListner());//eventListener;
        }
        return driver;
    }
}
