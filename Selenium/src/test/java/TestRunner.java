import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestRunner {

    /*
    2.
    1)Зайти на сайт asos.ru
    2)Перейти в "подвал" сайт
    3)Нажать на значок соц. сети ВК

    Ожидаемый результат: переадресация в вк.

    10.
    1)Зайти на сайт asos.ru
    2)Нажать на поле поиска и ввести "Зеленые кроссовки New Balance 452"

    Ожидаемый результат: переадресация на страницу с введенными кроссовками
    */

    @Test(groups = {"SeleniumTests"})
    public void searchSneakersByName(){
        System.setProperty("webdriver.firefox.bin", "c:\\Program Files\\Firefox Nightly\\firefox.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.asos.com/ru/");
        driver.findElement(By.xpath("//*[@id=\"chrome-search\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"chrome-search\"]")).sendKeys("Зеленые кроссовки New Balance 452");
        driver.findElement(By.xpath("//*[@class=\"kH5PAAC _1KRfEms\"]")).click();
        Assert.assertEquals(driver.getTitle(), "Зеленые кроссовки New Balance 452 | ASOS");
        driver.close();
    }

    @Test(groups = {"SeleniumTests"})
    public void vkontakteCheck(){
        System.setProperty("webdriver.firefox.bin", "c:\\Program Files\\Firefox Nightly\\firefox.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.asos.com/ru/");
        driver.findElement(By.xpath("//*[@class=\"_119KPCL _2FaCbHq\"]")).click();
        System.out.println("Page title is: " + driver.getTitle());
        driver.close();
    }
}
