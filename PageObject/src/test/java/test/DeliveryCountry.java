package test;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import page.AsosMainPage;

import static org.testng.Assert.assertTrue;

public class DeliveryCountry {

    private WebDriver driver;

    private static final String COUNTRY_LABEL = "Беларусь";

    @Before
    public void before() {
        System.setProperty("webdriver.driver", "f:/chrome.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void getDeliveryTitleTest() {
        AsosMainPage asosMainPage = new AsosMainPage(driver)
                .openPage()
                .checkDeliveryCountry();

        assertTrue(asosMainPage.getLabelText().contains(COUNTRY_LABEL));
    }

    @After
    public void after() {
        driver.close();
    }
}
