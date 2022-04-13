package test2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ShopTest {
    WebDriver driver;
    String startUrl;
    String startTitle;
    String loginUrl;
    String loginTitle;
    String currUrl;
    String psswd;
    String emlAddr;
    String accCreateUrl;
    String accCreateTitle;
    final String DATAFILE = "c:\\Projects\\test2junit\\src\\test\\java\\test2\\json\\testData.json";

    @BeforeAll
    public void setUp() {
        driver = new ChromeDriver();

        startUrl = "http://automationpractice.com/index.php";
        startTitle = "My Store";

        loginUrl = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
        loginTitle = "Login - My Store";

        accCreateUrl = "http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation";

        currUrl = "";

    }

    @AfterAll
    public void teardown() {
        if (driver != null)
            driver.quit();
    }

    // @Test
    // public void mainPageOpenDriver() {
    // driver.get(startUrl);
    // assertEquals(startTitle, driver.getTitle());
    // }

    // @Test
    // public void gotoLoginPage() {
    // driver.get(startUrl);
    // WebElement webElement = driver.findElement(By.className("login"));
    // assertFalse(webElement == null);
    // webElement.click();
    // currUrl = driver.getCurrentUrl();
    // assertEquals(loginUrl, currUrl);
    // assertEquals(loginTitle, driver.getTitle());

    // }

    @Test
    public void inputAccountEmail() throws InterruptedException {
        // * open login page
        driver.get(loginUrl);
        // * find imput area for email addr
        // WebElement webElement = driver.findElement(By.className("account_input"));
        String xpCreateEmail = "//input[contains(@class,'account_input')]";
        WebElement webElement = driver.findElement(By.xpath(xpCreateEmail));
        assertFalse(webElement == null);

        // * create random addr and passwd
        SimpleDateFormat dtF = new SimpleDateFormat("EddMMhhmm", Locale.US);
        psswd = dtF.format(new Date());
        emlAddr = psswd.concat("@test.email");

        // * input email addr in "input" and change focus for validate email addr
        webElement.sendKeys(emlAddr, Keys.TAB);

        // * find parent element - he contain class validate email addr
        // * go to page input add data
        WebElement submitButt = driver.findElement(By.id("SubmitCreate"));
        assertFalse(submitButt == null);
        submitButt.submit();
        // * wait load page
        currUrl = driver.getCurrentUrl();
        while (loginUrl.equals(currUrl)) {
            currUrl = driver.getCurrentUrl();
        }
        assertEquals(accCreateUrl, currUrl);
        assertEquals(emlAddr, driver.findElement(By.name("email")).getAttribute("value"));
        System.out.println(driver.findElement(By.xpath("//input[contains(@name,'email')]")).getAttribute("value"));
    }

    @Test
    public void createNewUser() throws InterruptedException {
        driver.get(loginUrl);
        WebElement emailNewInput = driver.findElement(By.className("account_input"));

        // * create random addr and passwd
        SimpleDateFormat dtF = new SimpleDateFormat("EddMMhhmm", Locale.US);
        psswd = dtF.format(new Date());
        emlAddr = psswd.concat("@test.email");

        emailNewInput.sendKeys(emlAddr, Keys.TAB);
        WebElement submitButt = driver.findElement(By.id("SubmitCreate"));
        submitButt.submit();
        // * wait load page
        currUrl = driver.getCurrentUrl();

        while (loginUrl.equals(currUrl)) {
            currUrl = driver.getCurrentUrl();
        }

        // * check send params from prev page
        assertEquals(emlAddr, driver.findElement(By.name("email")).getAttribute("value"));

        // * filling fields to new user
        String[][] userData = {
                { "input", "id", "customer_firstname", "Vasia" }, // id="customer_firstname"
                { "input", "id", "customer_lastname", "Pupkin" },
                { "input", "id", "passwd", psswd },
                { "input", "id", "firstname", "Vasia" },
                { "input", "id", "lastname", "Pupkin" },
                { "input", "id", "company", "Roga&Kopyta" },
                { "input", "id", "address1", "Drugby str., 91100, 'Roga&Kopyta'" },
                { "input", "id", "address2", "h.31, fl.5" },
                { "input", "id", "city", "New York" },
                { "input", "id", "postcode", "91100" },
                { "textarea", "id", "other", "No information" },
                { "input", "id", "phone", "+180645233771" },
                { "input", "id", "phone_mobile", "+180505233771" },
                { "input", "id", "alias", "Kyiv" }
        };
        driver.findElement(By.id("id_gender2")).click();
        driver.findElement(By.id("id_gender1")).click();
        driver.findElement(By.xpath("//select[@id='days']/option[@value='3']")).click();
        driver.findElement(By.xpath("//select[@id='months']/option[@value='8']")).click();
        driver.findElement(By.xpath("//select[@id='years']/option[@value='1980']")).click();
        driver.findElement(By.xpath("//select[@id='id_state']/option[@value='24']")).click();
        String xPath = "";
        for (String[] userIter : userData) {
            xPath = String.format("//%s[@%s='%s']", userIter[0], userIter[1], userIter[2]);
            driver.findElement(By.xpath(xPath)).sendKeys(userIter[3], Keys.TAB);
        }

        Thread.sleep(5000);
    }

}
