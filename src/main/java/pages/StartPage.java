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

    public void clickCookieButton() {
        driver.findElement(cookieButton).click();
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

    public String getButtonLocator(boolean isUpButton) {
        if (isUpButton)
            return ".//button[@class='Button_Button__ra12g' and text()='Заказать']";
        else
            return ".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']";
    }
}
