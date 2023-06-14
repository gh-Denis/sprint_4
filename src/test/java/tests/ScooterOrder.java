package tests;
import pages.AcceptWindow;
import pages.RentForm;
import pages.StartPage;
import pages.UserOrderForm;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import static org.hamcrest.CoreMatchers.startsWith;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScooterOrder extends BaseTest {

    private String expectedTextSuccessfulOrder = "Заказ оформлен";
    public By orderButtonLocator = By.cssSelector("#root > div > div > div.Home_ThirdPart__LSTEE > div.Home_RoadMap__2tal_ > div.Home_FinishButton__1_cWm > button");
    public String scrollIntoView = "arguments[0].scrollIntoView();";

    @Test
    public void orderScooterByTopButton() {

        driver = new ChromeDriver();

        driver.get(URL);

        StartPage objectStartPage = new StartPage(driver);
        UserOrderForm objectUserOrderForm = new UserOrderForm(driver);
        RentForm objectRentForm = new RentForm(driver);
        AcceptWindow objectAcceptWindow = new AcceptWindow(driver);

        objectStartPage.clickCookieButton();
        objectStartPage.clickTopButtonOfOrder();
        objectUserOrderForm.setName(name1);
        objectUserOrderForm.setSurname(surname1);
        objectUserOrderForm.setAddress(address1);
        objectUserOrderForm.setPhone(phone1);
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
    }

    @Test
    public void orderScooterByBottomButton() {

        driver = new ChromeDriver();

        driver.get(URL);

        StartPage objectStartPage = new StartPage(driver);
        UserOrderForm objectUserOrderForm = new UserOrderForm(driver);
        RentForm objectRentForm = new RentForm(driver);
        AcceptWindow objectAcceptWindow = new AcceptWindow(driver);

        objectStartPage.clickCookieButton();

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(orderButtonLocator));
        WebElement element = driver.findElement(orderButtonLocator);
        ((JavascriptExecutor) driver).executeScript(scrollIntoView, element);

        objectStartPage.clickBottomButtonOfOrder();
        objectUserOrderForm.setName(name2);
        objectUserOrderForm.setSurname(surname2);
        objectUserOrderForm.setAddress(address2);
        objectUserOrderForm.setPhone(phone2);
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
    }
}
