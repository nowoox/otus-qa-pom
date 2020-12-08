package base;

import config.ServerConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.AboutPage;
import pages.LoginPage;
import pages.MainPage;

public class BaseTest {

    protected WebDriver driver;
    public Logger logger = LogManager.getLogger(BaseTest.class);
    public ServerConfig cfg = ConfigFactory.create(ServerConfig.class);
    public LoginPage loginPage;
    public AboutPage aboutPage;
    public MainPage mainPage;

    @BeforeEach
    public void setUp(){
        DriverFactory driverFactory = new DriverFactory(DriverFactory.Browser.chrome.toString().toLowerCase());
        try {
            WebDriverManager.chromedriver().setup();
            driver = driverFactory.createDriver();
            logger.info("Драйвер запущен");
            loginPage = PageFactory.initElements(driver, LoginPage.class);
            aboutPage = PageFactory.initElements(driver, AboutPage.class);
            mainPage = PageFactory.initElements(driver, MainPage.class);
        } catch (Exception e){

        }
    }

    @AfterEach
    public void setDown(){
        if (driver != null) {
            driver.quit();
            logger.info("Драйвер остановлен");
        }
    }
}
