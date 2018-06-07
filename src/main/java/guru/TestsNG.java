package guru;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestsNG {
	private WebDriver driver;
	private Properties prop;
	private static final String SUCCESS_LOGIN_URL = "http://www.demo.guru99.com/V4/manager/Managerhomepage.php";
	private static final String RIGTH_TEXT_ALERT = "User or Password is not valid";


	@BeforeTest
	public void setSystem() throws IOException {
		 System.setProperty("webdriver.chrome.driver",Util.DRIVER_LOCATION);
		 driver= new ChromeDriver();
		FileInputStream read =  new FileInputStream("src/main/resources/prop.properties");
		prop = new Properties();
		prop.load(read);
	}
	@Test(priority = 1)
	public void validData(){
		String idUser =  prop.getProperty("USER_ID");
		String pasword = prop.getProperty("PASSWORD");

		PageV4 pageV4 = new PageV4(driver);
		enterData(pageV4.passwordWebelement(),
				pageV4.buttonLogin(),
				()->driver.findElement(By.xpath("//input[@name='uid']")),
				idUser,
				pasword);
		Assert.assertEquals(driver.getCurrentUrl(),SUCCESS_LOGIN_URL);
	}
	@Test(priority = 0)
	public void inValidData(){
		String idUser =  prop.getProperty("invalidUser");
		String pasword = prop.getProperty("PASSWORD");
		PageV4 pageV4 = new PageV4(driver);

		enterData(pageV4.passwordWebelement(),
				pageV4.buttonLogin(),
				()->driver.findElement(By.xpath("//input[@name='uid']")),
				idUser,
				pasword);

		Alert alert = driver.switchTo().alert();
		String textAlert =  alert.getText();
		Assert.assertEquals(textAlert, RIGTH_TEXT_ALERT);
		alert.accept();
	}
	@Test
	public void invalidPassword(){
		String idUser =  prop.getProperty("USER_ID");
		String pasword = prop.getProperty("invalidPassword");
		PageV4 pageV4 = new PageV4(driver);

		Guru.test2(pageV4.passwordWebelement(),
				null,
				pageV4.buttonLogin(),
				pasword,idUser,
				()->driver.findElement(By.xpath("//input[@name='uid']")));

		Alert alert = driver.switchTo().alert();
		String textAlert =  alert.getText();
		Assert.assertEquals(textAlert, RIGTH_TEXT_ALERT);
		alert.accept();
	}

	private  void enterData(WebElement pass, WebElement click, WebElementFunc lamda1, String idUser, String pasword){
		pass.sendKeys(pasword);
		lamda1.r().sendKeys(idUser);
		click.click();


	}
	@AfterTest
	public void quit(){
		driver.quit();
	}
}
