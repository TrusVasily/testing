import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TestRunner {

    /*
    2.
    1)Зайти на сайт asos.ru
    2)Перейти в "подвал" сайт
    3)Нажать на значок соц. сети ВК

    Ожидаемый результат: переадресация в вк.
    */

    @Test
    public void vkontakteCheck(){
        System.setProperty("webdriver.firefox.bin", "f:/chrome.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.asos.com/ru/");
        driver.findElement(By.xpath("//*[@class='_119KPCL _2FaCbHq']")).click();
        System.out.println("Page title is: " + driver.getTitle());
        driver.close();
    }
}
