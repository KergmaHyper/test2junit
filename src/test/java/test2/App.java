package test2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class App {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        var driver = new ChromeDriver(options);
        driver.get("http://automationpractice.com/index.php");
        String str = driver.getTitle();
        System.out.printf("\n\n%str\n\n", str);
        By loginClass = By.className("login");
        WebElement webElement = driver.findElement(loginClass);
        webElement.click();
        WebElement emailInput = driver.findElement(By.id("email_create"));

        if (emailInput != null)
            System.out.println(emailInput.getText());
        // webElement.sendKeys("Joko1@gmail.com");

        String str2 = driver.getTitle();
        System.out.printf("\n\n%str\n\n", str2);

        // By by = By.id("id");
        // webElement = driver.findElement()

        driver.quit();

        // FirefoxOptions options1 = new FirefoxOptions();
        // var driver1 = new FirefoxDriver(options1);
        // driver1.get("https://sd.ua");
        // String str = driver1.getTitle();
        // System.out.printf("\n\n%str\n\n", str);
        // driver1.quit();
    }
}
