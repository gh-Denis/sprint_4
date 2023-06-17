package tests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    static String URL = ("https://qa-scooter.praktikum-services.ru/");
    static String TOPORDERBUTTON = ".//button[@class='Button_Button__ra12g' and text()='Заказать']";
    static String BOTTOMORDERBUTTON = ".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']";

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
