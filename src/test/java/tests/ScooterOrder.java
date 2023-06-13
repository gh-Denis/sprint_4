package tests;
import pages.AcceptWindow;
import pages.RentForm;
import pages.StartPage;
import pages.UserOrderForm;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import static org.hamcrest.CoreMatchers.startsWith;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScooterOrder {

    private WebDriver driver;
    private String expectedTextSuccessfulOrder = "Заказ оформлен";

    @Test
    public void firstOrder() {

        driver = new ChromeDriver();

        driver.get("https://qa-scooter.praktikum-services.ru/");

        StartPage objectStartPage = new StartPage(driver);
        UserOrderForm objectUserOrderForm = new UserOrderForm(driver);
        RentForm objectRentForm = new RentForm(driver);
        AcceptWindow objectAcceptWindow = new AcceptWindow(driver);

        objectStartPage.clickCookieButton();
        objectStartPage.clickTopButtonOfOrder();
        objectUserOrderForm.setName("Алексей");
        objectUserOrderForm.setSurname("Иванов");
        objectUserOrderForm.setAddress("Победы 10");
        objectUserOrderForm.setPhone("+79112345678");
        objectUserOrderForm.onClickListOfMetro();
        objectUserOrderForm.onClickStation();
        objectUserOrderForm.onDone();
        objectRentForm.onClickDate();
        objectRentForm.onClickCalendar();
        objectRentForm.onClickListPeriod();
        objectRentForm.onClickPeriod();
        objectRentForm.onDone();
        objectRentForm.onDoneModal();
        String actualTextSuccessfulOrder = objectAcceptWindow.getTitleAcceptModel();
        MatcherAssert.assertThat(actualTextSuccessfulOrder, startsWith(expectedTextSuccessfulOrder));
        System.out.println(actualTextSuccessfulOrder);
    }

    @Test
    public void secondOrder() {

        driver = new ChromeDriver();

        driver.get("https://qa-scooter.praktikum-services.ru/");

        StartPage objectStartPage = new StartPage(driver);
        UserOrderForm objectUserOrderForm = new UserOrderForm(driver);
        RentForm objectRentForm = new RentForm(driver);
        AcceptWindow objectAcceptWindow = new AcceptWindow(driver);

        objectStartPage.clickCookieButton();

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#root > div > div > div.Home_ThirdPart__LSTEE > div.Home_RoadMap__2tal_ > div.Home_FinishButton__1_cWm > button")));
        WebElement element = driver.findElement(By.cssSelector("#root > div > div > div.Home_ThirdPart__LSTEE > div.Home_RoadMap__2tal_ > div.Home_FinishButton__1_cWm > button"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);

        objectStartPage.clickBottomButtonOfOrder();
        objectUserOrderForm.setName("Анастасия");
        objectUserOrderForm.setSurname("Петрова");
        objectUserOrderForm.setAddress("Лесная 5");
        objectUserOrderForm.setPhone("+79312345678");
        objectUserOrderForm.onClickListOfMetro();
        objectUserOrderForm.onClickStation();
        objectUserOrderForm.onDone();
        objectRentForm.onClickDate();
        objectRentForm.onClickCalendar();
        objectRentForm.onClickListPeriod();
        objectRentForm.onClickPeriod();
        objectRentForm.onDone();
        objectRentForm.onDoneModal();
        String actualTextSuccessfulOrder = objectAcceptWindow.getTitleAcceptModel();
        MatcherAssert.assertThat(actualTextSuccessfulOrder, startsWith(expectedTextSuccessfulOrder));
        System.out.println(actualTextSuccessfulOrder);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
