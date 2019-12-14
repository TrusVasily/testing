package test;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import page.AsosMainPage;

import static org.junit.Assert.assertFalse;

public class LabelCheckTest {

    private WebDriver driver;

    private static final String PAGE_LABEL ="Asos";

    @Before
    public void before() {
        System.setProperty("webdriver.chrome.driver", "f:/chrome.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void addWomenLabelCheckTest() {
        AsosMainPage asosMainPage = new AsosMainPage(driver)
                .openPage()
                .openVK();

        assertFalse(asosMainPage.getLabelText().contains(PAGE_LABEL));
    }

    @After
    public void after() {
        driver.close();
    }
}
