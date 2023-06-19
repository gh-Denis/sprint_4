package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecondOrderPage {
    private WebDriver driver;
    public SecondOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    private By date = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private By calendar = By.xpath("//div/span[@class='Dropdown-arrow']");
    private By rentPeriod = By.xpath("//div[contains(text(),'двое суток')]");
    private By colorScooter = By.xpath("//label[contains(text(),'чёрный жемчуг')]");
    private By orderComment = By.xpath("//div/input[@placeholder='Комментарий для курьера']");
    private By orderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");
    private By acceptButton = By.xpath(".//button[text()='Да' and @class='Button_Button__ra12g Button_Middle__1CSJM']");
    private By orderSuccessText = By.cssSelector(".Order_ModalHeader__3FDaJ");

    public void onClickDate(String dataField) {
        driver.findElement(date).sendKeys(dataField);
    }
    public void onClickCalendar() {
        driver.findElement(calendar).click();
    }
    public void onClickRentPeriod() {
        driver.findElement(rentPeriod).click();
    }
    public  void onSetColorScooter() {
        driver.findElement(colorScooter).click();
    }
    public  void onSetOrderComment(String commentField){
        driver.findElement(orderComment).sendKeys(commentField);
    }
    public void onClickOrderButton() {
        driver.findElement(orderButton).click();
    }
    public void onClickAcceptButton() {
        driver.findElement(acceptButton).click();
    }
    public String getOrderSuccessText() {
        return driver.findElement(orderSuccessText).getText();
    }

    public void fillSecondPage(String dataField, String commentField) {
        onClickDate(dataField);
        onClickCalendar();
        onClickRentPeriod();
        onSetColorScooter();
        onSetOrderComment(commentField);
    }
}
