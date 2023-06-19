package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public class StartPage {
    private WebDriver driver;

    public StartPage(WebDriver driver) {
        this.driver = driver;
    }

    private By cookieButton = By.id("rcc-confirm-button");
    private By topOrderButton = By.xpath(".//button[@class='Button_Button__ra12g' and text()='Заказать']");
    private By bottomOrderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");

    public void clickCookieButton() {
        driver.findElement(cookieButton).click();
    }
    public void onOrderButtonClick(By button) {
        driver.findElement(button).click();
    }
    public void clickOrderButton(boolean isUpButton) {
        if (isUpButton)
            onOrderButtonClick(topOrderButton);
        else
            onOrderButtonClick(bottomOrderButton);
    }

    public void clickQuestion(int questionNumber) {
        driver.findElement(By.id("accordion__heading-" + questionNumber)).click();
    }
    public String getAnswerText(int questionNumber) {
        return driver.findElement(By.xpath(".//div[@id='accordion__panel-"+ questionNumber +"']/p")).getText();
    }
    public void waitForAnswerAppear() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
}
