package guru;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import java.sql.*;

public class TestNgWhithSQL {
    private  WebDriver driver;
    private  String  dbUrl = "jdbc:mysql://localhost:3306/sql";
    //"jdbc:mysql://localhost:3306/Peoples?autoReconnect=true&useSSL=false";
    //private String username = "root";
    //String password = "1111";

    String query = "select *  user;";
    ResultSet resultQuery;
    Connection connection;

    String validUser = "select data from user_password where id =\"1\";";
    String validPassword = "select data from user_password where id =\"2\";";
    String invalidUser = "select data from user_password where id =\"3\";";
    String invalidPassword = "select data from user_password where id =\"4\";";

    private static Logger logger = LoggerFactory.getLogger(TestNgWhithSQL.class);

    @BeforeClass
    public void setSystem() throws ClassNotFoundException, SQLException {
        logger.info("creat system preopertys");
        System.setProperty("webdriver.chrome.driver",Util.DRIVER_LOCATION);
        driver = WebDriverProvider.webDriverProvider();


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
        logger.debug("creat connection with db");
    }

    /*@Test
    public void testValidSQL(){
        PageV4 pageV4 = new PageV4(driver);
        Guru.test2(pageV4.passwordWebelement(),
                pageV4.userId(),pageV4.buttonLogin(),
                a,
                s,
                ()->driver.findElement(By.xpath("//input[@name='uid']"))  );
    }*/
    @Test
    public void testInvalidId(){}
    @Test
    public void teatInvalidPass(){
    }

    @AfterTest
    public void closeCon() throws SQLException {
        connection.close();
        logger.info("closing connection witn db");
    }


    @AfterClass
    public void afterClass(){
    driver.quit();
    logger.info("closing browser");
    }

}
