package pages;

import base.BaseTest;
import config.ServerConfig;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertTrue;


public abstract class BasePage {

    public WebDriver driver;
    public WebDriverWait webDriverWait;
    public Logger logger = LogManager.getLogger(BaseTest.class);
    public ServerConfig cfg = ConfigFactory.create(ServerConfig.class);

    public void goTo(String url){
        driver.get(url);
        logger.info("Выполнен переход на " + url);
    }

    public BasePage(WebDriver webDriver) {
        this.driver = webDriver;
        webDriverWait = new WebDriverWait(webDriver, 4);
    }

    public void waitVisibility(By elementBy){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
    }

    public void click(By elementBy){
        waitVisibility(elementBy);
        driver.findElement(elementBy).click();
        logger.info("Выполнен клик по элементу: " + elementBy);
    }

    public void isElementDisplayed(By elementBy){
        waitVisibility(elementBy);
        assertTrue(driver.findElement(elementBy).isDisplayed());
        logger.info("Элемент найден: " + elementBy);
    }

    public void type(By elementBy, String text){
        driver.findElement(elementBy).sendKeys(Keys.CONTROL + "a");
        driver.findElement(elementBy).sendKeys(text);
        logger.info("В поле " + elementBy + " введен текст " + text);
    }

    public void tickCheckBox(){

    }
}
