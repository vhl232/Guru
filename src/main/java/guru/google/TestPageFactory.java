package guru.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import guru.Util;

public class TestPageFactory {
	private WebDriver driver;


	public TestPageFactory() {
		System.setProperty("webdriver.chrome.driver",
				Util.DRIVER_LOCATION);
		this.driver = new ChromeDriver();
	}

	@Test
	public void findElement(){
		GogleMainPage page = new GogleMainPage(driver);

		page.textArea.sendKeys("suki");
		page.textArea.submit();
	}
}
