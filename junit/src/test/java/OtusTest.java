import base.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class OtusTest extends BaseTest {

    @Test
    @DisplayName("Переход на сайт")
    public void Test() throws InterruptedException {

        mainPage.goTo(cfg.url_otus());

        mainPage.Login();

        Thread.sleep(3000);

        aboutPage.goTo(cfg.url_otus_about());

        aboutPage.uncheckAllCheckboxes();

        aboutPage.fillAllFields();

        aboutPage.save();

        Thread.sleep(5000);

        aboutPage.goTo(cfg.url_otus_about());

        aboutPage.checkFilledFields();

        Thread.sleep(5000);

    }

}
