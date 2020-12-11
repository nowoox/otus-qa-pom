package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class MainPage extends BasePage {

    protected String MAIN_PAGE_PROFILE_LINK = ".header2-menu__dropdown-text";

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void goToPersonal(){

        waitPresence(By.cssSelector(MAIN_PAGE_PROFILE_LINK));

        Actions builder = new Actions(driver);

        builder.moveToElement(driver.findElement(By.cssSelector(".header2-menu__item-text__username")))
                .build()
                .perform();

        waitVisibility(By.cssSelector(MAIN_PAGE_PROFILE_LINK));

        driver.findElement(By.cssSelector(MAIN_PAGE_PROFILE_LINK)).click();
        logger.info("Выполнен переход в личный кабинет");

    }
}
