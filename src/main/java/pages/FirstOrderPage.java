package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class FirstOrderPage {
    private WebDriver driver;
    public FirstOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    private By name = By.xpath(".//input[@placeholder='* Имя']");
    private By surname  = By.xpath(".//input[@placeholder='* Фамилия']");
    private By address  = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private By metroStation = By.xpath(".//input[@placeholder='* Станция метро']");
    private By phoneNumber = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private By nextButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    public void setName(String userName) {
        driver.findElement(name).sendKeys(userName);
    }
    public void setSurname(String userSurname) {
        driver.findElement(surname).sendKeys(userSurname);
    }
    public void setAddress(String userAddress) {
        driver.findElement(address).sendKeys(userAddress);
    }
    public void setMetroStation(String userMetroStation) {
        driver.findElement(metroStation).sendKeys(userMetroStation, Keys.ARROW_DOWN, Keys.ENTER);
    }
    public void setPhoneNumber(String userPoneNumber) {
        driver.findElement(phoneNumber).sendKeys(userPoneNumber);
    }
    public void onClickNextButton() {
        driver.findElement(nextButton).click();
    }

    public void fillFirstPage (String name, String surname, String address, String metroStation, String phoneNumber) {
        setName(name);
        setSurname(surname);
        setAddress(address);
        setMetroStation(metroStation);
        setPhoneNumber(phoneNumber);
    }
}
