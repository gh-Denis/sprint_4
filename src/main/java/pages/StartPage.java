package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StartPage {
    private WebDriver driver;

    public StartPage(WebDriver driver) {
        this.driver = driver;
    }

    private By cookieButton = By.id("rcc-confirm-button");

    public void clickCookieButton() {
        driver.findElement(cookieButton).click();
    }
    public void clickQuestion(int questionNumber) {
        driver.findElement(By.id("accordion__heading-" + questionNumber)).click();
    }
    public String getAnswerText(int questionNumber) {
        return driver.findElement(By.xpath(".//div[@id='accordion__panel-"+ questionNumber +"']/p")).getText();
    }
}
