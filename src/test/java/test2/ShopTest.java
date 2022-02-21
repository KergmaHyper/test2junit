package test2;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ShopTest {
    ChromeOptions chromeOptions = new ChromeOptions();
    ChromeDriver chromeDriver = new ChromeDriver(chromeOptions);

    @Before
    public void InitDriver() {

    }

    @Test
    public void mainPageOpenChrome() {
        chromeDriver.get("http://automationpractice.com/index.php");
        assertEquals("My Store", chromeDriver.getTitle());
    }

    @After
    public void finishWorkChromeDriver() {
        chromeDriver.quit();
    }

}
