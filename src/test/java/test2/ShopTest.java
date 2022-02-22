package test2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.sql.Time;
import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

// import org.junit.After;
// import org.junit.Before;
// import org.junit.Test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ShopTest {
    ChromeOptions chromeOptions = new ChromeOptions();
    ChromeDriver chromeDriver = new ChromeDriver(chromeOptions);
    String startUrl = "http://automationpractice.com/index.php";
    String startTitle = "My Store";
    String loginUrl = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
    String loginTitle = "Login - My Store";
    String currUrl = "";

    // WebDriver drv = new ChromeDriver();
    @AfterAll
    public void teardown() {
        if (chromeDriver != null)
            chromeDriver.quit();
    }

    @Test
    public void mainPageOpenChrome() {
        chromeDriver.get(startUrl);
        assertEquals(startTitle, chromeDriver.getTitle());

    }

    @Test
    public void gotoLoginPage() {
        chromeDriver.get(startUrl);
        WebElement webElement = chromeDriver.findElement(By.className("login"));
        assertFalse(webElement == null);
        webElement.click();
        currUrl = chromeDriver.getCurrentUrl();
        assertEquals(loginUrl, currUrl);
        assertEquals(loginTitle, chromeDriver.getTitle());

    }

    @Test
    public void inputAccountEmail() throws InterruptedException {
        chromeDriver.get(loginUrl);
        WebElement webElement = chromeDriver.findElement(By.className("account_input"));
        Date dtNow = new Date();

        webElement.sendKeys("keysToSend");

    }

}
