package guru;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.sql.*;

public class TestNgWhithSQL {
    private  WebDriver driver;
    private  String  dbUrl = "jdbc:mysql://localhost:3306/Peoples?autoReconnect=true&useSSL=false";
    private String username = "root";
    String password = "1111";
    String query = "select *  user;";
    ResultSet resultQuery;
    Connection connection;
    String validUser = "select data from user_password where id =\"1\";";
    String validPassword = "select data from user_password where id =\"2\";";
    String invalidUser = "select data from user_password where id =\"3\";";
    String invalidPassword = "select data from user_password where id =\"4\";";


    @BeforeClass
    public void setSystem() throws ClassNotFoundException, SQLException {
        System.setProperty("webdriver.chrome.driver",Util.DRIVER_LOCATION);
        driver = new ChromeDriver();

       /* Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(dbUrl,username,password);
        Statement statement = connection.createStatement();
        resultQuery = statement.executeQuery(query);*/
    }
    @BeforeTest
    public void creatConectSQL() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(dbUrl);
        Statement statement = connection.createStatement();
        resultQuery = statement.executeQuery(query);
    }

    @Test
    public void testValidSQL(){
        PageV4 pageV4 = new PageV4(driver);
        Guru.test2(pageV4.passwordWebelement(),
                pageV4.userId(),pageV4.buttonLogin(),
                a,
                s,
                ()->driver.findElement(By.xpath("//input[@name='uid']"))  );
    }
    @Test
    public void testInvalidId(){}
    @Test
    public void teatInvalidPass(){
    }

    @AfterTest
    public void closeCon() throws SQLException {
        connection.close();
    }


    @AfterClass
    public void afterClass(){
    driver.quit();
    }

}
