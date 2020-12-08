package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    protected String MAIN_PAGE_HEADER = ".header2-menu_main";
    protected String MAIN_PAGE_FOOTER = "footer.footer2";
    protected String LOGIN_PAGE_SELECTOR = ".header2__auth";
    protected String LOGIN_PAGE_HEADER_SELECTOR = "div.new-log-reg__login:nth-child(2) > div:nth-child(1) > div:nth-child(1) > span:nth-child(1)";
    protected String LOGIN_PAGE_LOGIN_SELECTOR = "//form[@data-type='modal-form']//input[@placeholder='Электронная почта']";
    protected String LOGIN_PAGE_PASSWORD_SELECTOR = ".js-psw-input";
    protected String LOGIN_PAGE_LOGIN_BUTTON_SELECTOR = "div.new-input-line_last:nth-child(5) > button:nth-child(1)";

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void Login(){

        waitVisibility(By.cssSelector(LOGIN_PAGE_SELECTOR));

        click(By.cssSelector(LOGIN_PAGE_SELECTOR));

        isElementDisplayed(By.cssSelector(LOGIN_PAGE_HEADER_SELECTOR));

        waitVisibility(By.xpath(LOGIN_PAGE_LOGIN_SELECTOR));

        type(By.xpath(LOGIN_PAGE_LOGIN_SELECTOR), cfg.login());

        type(By.cssSelector(LOGIN_PAGE_PASSWORD_SELECTOR), cfg.password());

        click(By.cssSelector(LOGIN_PAGE_LOGIN_BUTTON_SELECTOR));

    }

}
