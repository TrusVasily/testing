package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AsosMainPage extends Page {

    private static final String HOMEPAGE_URL = "https://www.asos.com/ru/";

    private static final By VK_BUTTON = By.xpath("//*[@class='_119KPCL _2FaCbHq']");

    private static final By COUNTRY = By.xpath("//*[@id='country']");

    private static final By DELIVERY_COUNTRY = By.xpath("//*[@class='w9hgW1d _19PGtzt']");


    public AsosMainPage(WebDriver driver) {
        super(driver);
    }

    public AsosMainPage openPage() {
        driver.navigate().to(HOMEPAGE_URL);
        return this;
    }

    public AsosMainPage openVK() {
        waitUntilElementToBeClickable(VK_BUTTON).click();
        return this;
    }

    public AsosMainPage checkDeliveryCountry() {
        waitUntilElementToBeClickable(DELIVERY_COUNTRY).click();
        return this;
    }

    public String getLabelText() {
        return waitUntilPresenceOfElement(COUNTRY).getText();
    }

}
