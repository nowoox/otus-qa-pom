import base.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.WebDriverWait;


public class OtusTest extends BaseTest {

    @Test
    @DisplayName("Переход на сайт")
    public void Test() throws InterruptedException {

        loginPage.goTo(cfg.url_otus());

        loginPage.Login();

        //Thread.sleep(3000);

        //WebDriverWait wait = new WebDriverWait(driver.)
        //driver.navigate().to(cfg.url_otus_about());

        mainPage.goToPersonal();

        //mainPage.goTo(cfg.url_otus_about());

        aboutPage.fillAllFields();

        aboutPage.save();

        //Thread.sleep(5000);

        aboutPage.goTo(cfg.url_otus_about());

        aboutPage.checkFilledFields();

        //Thread.sleep(5000);

    }

}
