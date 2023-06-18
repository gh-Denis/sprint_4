package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.SecondOrderPage;
import pages.FirstOrderPage;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.StartPage;

import static org.hamcrest.CoreMatchers.containsString;

@RunWith(Parameterized.class)
public class ScooterOrder extends BaseTest {

    private final Boolean orderButtonLocator;
    private final String name;
    private final String surname;
    private final String address;
    private final String metroStation;
    private final String phoneNumber;
    private final String date;
    private final String orderComment;

    public ScooterOrder(Boolean orderButtonLocator, String name, String surname, String address, String metroStation, String phoneNumber, String date, String orderComment) {
        this.orderButtonLocator = orderButtonLocator;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metroStation = metroStation;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.orderComment = orderComment;
    }

    @Parameterized.Parameters
    public static Object[][] getCustomersData() {
        return new Object[][]{
                {true, "Алексей", "Иванов", "Победы 10", "Черкизовская", "79112345678", "25.06.2023", "Хорошо"},
                {false, "Анастасия", "Петрова", "Лесная 5", "Чистые пруды", "79312345678", "26.06.2023", "Хорошо"},
        };
    }

    @Test
    public void testUpOrderButton() {
        driver = new ChromeDriver();
        StartPage objectStartPage = new StartPage(driver);
        driver.get(URL);
        objectStartPage.clickCookieButton();
        driver.findElement(By.xpath(objectStartPage.getButtonLocator(orderButtonLocator))).click();
        FirstOrderPage firstOrderPage = new FirstOrderPage(driver);
        firstOrderPage.fillFirstPage(name, surname, address, metroStation, phoneNumber);
        firstOrderPage.onClickNextButton();
        SecondOrderPage secondOrderPage = new SecondOrderPage(driver);
        secondOrderPage.fillSecondPage(date, orderComment);
        secondOrderPage.onClickOrderButton();
        secondOrderPage.onClickAcceptButton();
        String orderText = secondOrderPage.getOrderSuccessText();
        MatcherAssert.assertThat(orderText, containsString("Заказ оформлен"));
    }
}
