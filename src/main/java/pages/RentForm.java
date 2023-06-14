package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RentForm {
    private WebDriver driver;
    public RentForm(WebDriver driver) {
        this.driver = driver;
    }

    private By date = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private By calendar = By.cssSelector(".react-datepicker__day--012");
    private By listPeriod = By.cssSelector(".Dropdown-placeholder");
    private By period = By.xpath(".//div[text()='трое суток']");
    private By done = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");
    private By doneModal = By.xpath(".//button[text()='Да' and @class='Button_Button__ra12g Button_Middle__1CSJM']");


    public void onClickDate() {
        driver.findElement(date).click();
    }
    public void onClickCalendar() {
        driver.findElement(calendar).click();
    }
    public void onClickListPeriod() {
        driver.findElement(listPeriod).click();
    }
    public void onClickPeriod() {
        driver.findElement(period).click();
    }
    public void onDone() {
        driver.findElement(done).click();
    }
    public void onDoneModal() {
        driver.findElement(doneModal).click();
    }
}
