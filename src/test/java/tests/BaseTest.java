package tests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    String URL = ("https://qa-scooter.praktikum-services.ru/");

    String name1 = ("Алексей");
    String surname1 = ("Иванов");
    String address1 = ("Победы 10");
    String phone1 = ("79112345678");


    String name2 = ("Анастасия");
    String surname2 = ("Петрова");
    String address2 = ("Лесная 5");
    String phone2 = ("79312345678");

    protected WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}
