package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AboutPage extends BasePage {

    protected String ABOUT_PAGE_HEADER = ".title__text";

    protected String ABOUT_PAGE_NAME_SELECTOR = "#id_fname";
    protected String ABOUT_PAGE_SURNAME_SELECTOR = "#id_lname";
    protected String ABOUT_PAGE_LATIN_SURNAME_SELECTOR = "#id_lname_latin";
    protected String ABOUT_PAGE_LATIN_NAME_SELECTOR = "#id_fname_latin";
    protected String ABOUT_PAGE_NAME_BLOG_SELECTOR = "#id_blog_name";
    protected String ABOUT_PAGE_BIRTH_DATE_SELECTOR = ".input-icon > input:nth-child(1)";
    protected String ABOUT_PAGE_COMPANY_SELECTOR = "#id_company";
    protected String ABOUT_PAGE_POSITION_SELECTOR = "#id_work";

    protected String ABOUT_PAGE_COUNTRY_SELECTOR = ".js-lk-cv-dependent-master > label:nth-child(1) > div:nth-child(2)";
    protected String ABOUT_PAGE_CITY_SELECTOR = ".js-lk-cv-dependent-slave-city > label:nth-child(1) > div:nth-child(2)";
    protected String ABOUT_PAGE_LANGUAGE_SELECTOR = "div.container__col_12:nth-child(3) > " +
            "div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > " +
            "div:nth-child(2) > div:nth-child(1) > label:nth-child(1) > div:nth-child(2)";
    protected String ABOUT_PAGE_GENDER_SELECTOR = "#id_gender";

    protected String ABOUT_PAGE_ADD_BUTTON = "//button[.='Добавить']";
    protected String ABOUT_PAGE_ADD_BLOCK = "//div[@class='container__row js-formset-row']//" +
            "div[contains(@class, 'container__col_md-0')]//button[.='Удалить']/../../../";

    protected Map<String, String> textFieldsMap = new HashMap<>();
    protected Map<String, String> contactMap = new HashMap<>();
    protected Map<String, String> dropdownFieldsMapButton = new LinkedHashMap<>();
    protected Map<String, String> dropdownFieldsMapOption = new LinkedHashMap<>();

    public AboutPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void fillTextFields() {

        waitVisibility(By.cssSelector(ABOUT_PAGE_HEADER));

        textFieldsMap.put(ABOUT_PAGE_NAME_SELECTOR, "Андрей");
        textFieldsMap.put(ABOUT_PAGE_SURNAME_SELECTOR, "Ефимов");
        textFieldsMap.put(ABOUT_PAGE_LATIN_NAME_SELECTOR, "Andrey");
        textFieldsMap.put(ABOUT_PAGE_LATIN_SURNAME_SELECTOR, "Efimov");
        textFieldsMap.put(ABOUT_PAGE_NAME_BLOG_SELECTOR, "nowoox");
        textFieldsMap.put(ABOUT_PAGE_BIRTH_DATE_SELECTOR, "23.03.1988");
        textFieldsMap.put(ABOUT_PAGE_COMPANY_SELECTOR, "Компания");
        textFieldsMap.put(ABOUT_PAGE_POSITION_SELECTOR, "Должность");

        for (Map.Entry entry : textFieldsMap.entrySet()) {
            type(By.cssSelector(entry.getKey().toString()), entry.getValue().toString());
        }
    }

    public void fillDropdownFieldsButton() throws InterruptedException {

        waitVisibility(By.cssSelector(ABOUT_PAGE_HEADER));

        dropdownFieldsMapButton.put(ABOUT_PAGE_COUNTRY_SELECTOR, "Россия");
        dropdownFieldsMapButton.put(ABOUT_PAGE_CITY_SELECTOR, "Москва");
        dropdownFieldsMapButton.put(ABOUT_PAGE_LANGUAGE_SELECTOR, "Продвинутый (Advanced)");

        for (Map.Entry entry : dropdownFieldsMapButton.entrySet()) {

            waitPresense(By.cssSelector(entry.getKey().toString()));

            //webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(entry.getKey().toString())));

            Actions builder = new Actions(driver);

            builder.moveToElement(driver.findElement(By.cssSelector(entry.getKey().toString())))
                    .click().build().perform();
            logger.info("Открыт выпадающий список " + entry.getKey());

            waitVisibility(By.xpath("//button[@title='" + entry.getValue() + "']"));

            //driver.findElement(By.xpath("//button[@title='" + entry.getValue() + "']")).click();
            click(By.xpath("//button[@title='" + entry.getValue() + "']"));
            logger.info("Выбрано значение выпадающего списка " + entry.getValue());
        }


    }

    public void fillDropdownFieldsOption() {

        waitVisibility(By.cssSelector(ABOUT_PAGE_HEADER));

        dropdownFieldsMapOption.put(ABOUT_PAGE_GENDER_SELECTOR, "Мужской");

        for (Map.Entry entry : dropdownFieldsMapOption.entrySet()) {

            waitVisibility(By.cssSelector(entry.getKey().toString()));

            driver.findElement(By.cssSelector(entry.getKey().toString())).click();
            logger.info("Открыт выпадающий список " + entry.getKey());

            waitVisibility(By.xpath("//option[.='" + entry.getValue() + "']"));

            driver.findElement(By.xpath("//option[.='" + entry.getValue() + "']")).click();
            logger.info("Выбрано значение выпадающего списка " + entry.getValue());
        }

    }

    public void fillContact() {

        contactMap.put("VK", "Вконтакте");
        contactMap.put("Facebook","Фейсбук");
        contactMap.put("Тelegram","Телеграм");

        waitVisibility(By.cssSelector(ABOUT_PAGE_HEADER));

        List<WebElement> deleteButtons = driver.findElements(By.xpath("//div[contains(@class, 'container__col_md-0')]//*[.='Удалить']"));

        for (WebElement element : deleteButtons) {
            element.click();
        }

        //addContact("VK", "Вконтакте");
        //addContact("Facebook", "Фейсбук");
        //addContact("Тelegram", "Телеграм");

        for (Map.Entry entry : contactMap.entrySet()){
            addContact(entry.getKey().toString(), entry.getValue().toString());
            logger.info("Для способа связи " + entry.getKey() + " введено значение " + entry.getValue());
        }

    }

    protected void addContact(String Name, String Text) {

        click(By.xpath(ABOUT_PAGE_ADD_BUTTON));

        waitVisibility(By.xpath(ABOUT_PAGE_ADD_BLOCK + "/*[.='Способ связи']"));

        click(By.xpath(ABOUT_PAGE_ADD_BLOCK + "/*[.='Способ связи']"));
        click(By.xpath(ABOUT_PAGE_ADD_BLOCK + "/div[not(contains(@class,'hide'))]/div/button[@title='" + Name + "']"));
        type(By.xpath("(" + ABOUT_PAGE_ADD_BLOCK + "/input[contains(@class, 'input_straight-top-left')])[last()]"), Text);

        click(By.xpath("(" + ABOUT_PAGE_ADD_BLOCK + "/input[@type='checkbox']/following-sibling::span)[last()]"));

    }

    public void checkFilledFields() {

        waitVisibility(By.cssSelector(ABOUT_PAGE_HEADER));

        for (Map.Entry entry : textFieldsMap.entrySet()) {
            assertEquals(driver.findElement(By.cssSelector(entry.getKey().toString())).getAttribute("value"), entry.getValue());
            logger.info("Поле " + entry.getKey() + " заполнено верно, значение " + entry.getValue());
        }

        for (Map.Entry entry : dropdownFieldsMapButton.entrySet()) {
            assertEquals(driver.findElement(By.cssSelector(entry.getKey().toString())).getText(), entry.getValue());
            logger.info("Поле " + entry.getKey() + " заполнено верно, значение " + entry.getValue());
        }

        for (Map.Entry entry : dropdownFieldsMapOption.entrySet()) {
            Select select = new Select(driver.findElement(By.cssSelector(entry.getKey().toString())));
            assertEquals(select.getFirstSelectedOption().getText(), entry.getValue());
            logger.info("Поле " + entry.getKey() + " заполнено верно, значение " + entry.getValue());
        }

    }

    public void save() {
        click(By.cssSelector("button.button_md-4:nth-child(1)"));
    }

    public void fillAllFields() throws InterruptedException {

        fillContact();
        fillDropdownFieldsButton();
        fillDropdownFieldsOption();
        fillTextFields();

    }

    public void uncheckAllCheckboxes(){

        waitPresense(By.xpath("//input[@type='checkbox' and @checked]/following-sibling::span"));

        List<WebElement> checked = driver.findElements(By.xpath("//input[@type='checkbox' and @checked]/following-sibling::span"));

        for (WebElement element : checked){
            element.click();
            logger.info("Выполнен клик по элементу " + element);
        }
    }


}
