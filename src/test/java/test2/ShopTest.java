package test2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// import org.junit.After;
// import org.junit.Before;
// import org.junit.Test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ShopTest {
    ChromeOptions chromeOptions;
    ChromeDriver chromeDriver;
    WebDriver driver;
    String startUrl;
    String startTitle;
    String loginUrl;
    String loginTitle;
    String currUrl;
    String psswd;
    String emlAddr;

    @BeforeAll
    public void setUp() {
        // chromeOptions = new ChromeOptions();
        // chromeDriver = new ChromeDriver(chromeOptions);
        driver = new ChromeDriver();
        startUrl = "http://automationpractice.com/index.php";
        startTitle = "My Store";
        loginUrl = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
        loginTitle = "Login - My Store";
        currUrl = "";

    }

    @AfterAll
    public void teardown() {
        if (chromeDriver != null)
            chromeDriver.quit();
        if (driver != null)
            driver.quit();
    }

    @Disabled
    @Test
    public void mainPageOpenChrome() {
        chromeDriver.get(startUrl);
        assertEquals(startTitle, chromeDriver.getTitle());
    }

    @Test
    public void mainPageOpenDriver() {
        driver.get(startUrl);
        assertEquals(startTitle, driver.getTitle());
    }

    @Test
    public void gotoLoginPage() {
        driver.get(startUrl);
        WebElement webElement = driver.findElement(By.className("login"));
        assertFalse(webElement == null);
        webElement.click();
        currUrl = driver.getCurrentUrl();
        assertEquals(loginUrl, currUrl);
        assertEquals(loginTitle, driver.getTitle());

    }

    @Test
    public void inputAccountEmail() throws InterruptedException {
        driver.get(loginUrl);
        WebElement webElement = driver.findElement(By.className("account_input"));
        assertFalse(webElement == null);

        Date dtNow = new Date();
        SimpleDateFormat dtF = new SimpleDateFormat("EddMMhhmm", Locale.US);
        psswd = dtF.format(dtNow);
        emlAddr = psswd.concat("@test.email");

        webElement.sendKeys(emlAddr);
        Thread.sleep(7000);
        webElement = driver.findElement(By.id("SubmitCreate"));
        assertFalse(webElement == null);
        Thread.sleep(1000);
        webElement.click();
        currUrl = driver.getCurrentUrl();
        System.out.println(currUrl);
        Thread.sleep(7000);
    }

}
// http://automationpractice.com/index.php?controller=authentication&back=my-account
// http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation
