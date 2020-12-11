import base.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.WebDriverWait;


public class OtusTest extends BaseTest {

    @Test
    @DisplayName("Заполнение личной информации")
    public void Test() throws InterruptedException {

        loginPage.goTo(cfg.url_otus());

        loginPage.Login();

        mainPage.goToPersonal();

        aboutPage.fillAllFields();

        aboutPage.save();

        mainPage.goToPersonal();

        aboutPage.checkFilledFields();

    }

}
