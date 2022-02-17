package test2;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import lombok.SneakyThrows;

public class App {
    public static void main(String[] args) {
        String text = "  Kilo@gmail.com.ua jjjkk@jjj kilo.gramm@gmail.net.stat.org   kom2@org.33";
        Pattern pattern = Pattern.compile("[\\w\\d]+[\\.{1}[\\w\\d]+]{1,}@[\\w\\d]+\\.{1}[\\w\\d]+[\\.{1}[\\w\\d]+]*");
        Matcher matcher = pattern.matcher(text);
        // System.out.println("\"".concat(text).concat("\""));

        // while (matcher.find()) {
        // System.out.printf("found - s:%d, e:%d, m:\"%s\"\n", matcher.start(),
        // matcher.end(),
        // text.substring(matcher.start(), matcher.end()));
        // }
        String text2 = "  !!! \t ??  ..  ,,  one two!!,three,";
        System.out.println(text2);
        Pattern patt2 = Pattern.compile("[!? ,.;:\\t]+");

        String[] arStr = patt2.split(text2.strip(), 0);
        System.out.println(Arrays.toString(arStr));
        text2.
        // while (matcher.find()) {
        // System.out.printf("found - s:%d, e:%d, m:\"%s\"\n", matcher.start(),
        // matcher.end(),
        // text2.substring(matcher.start(), matcher.end()));
        // }

        // boolean drChrome = false;
        // ChromeOptions chromeOptions = new ChromeOptions();
        // ChromeDriver chromeDriver = new ChromeDriver(chromeOptions);
        // FirefoxOptions firefoxOptions = new FirefoxOptions();
        // FirefoxDriver firefoxDriver = new FirefoxDriver(firefoxOptions);
        // Object driver;
        // if (drChrome)
        // driver = chromeDriver;
        // else
        // driver = firefoxDriver;

        // chromeDriver.quit();
        // firefoxDriver.quit();

        /*
         * driver.get("http://automationpractice.com/index.php");
         * String str = driver.getTitle();
         * System.out.printf("\n\n%str\n\n", str);
         * By loginClass = By.className("login");
         * WebElement webElement = driver.findElement(loginClass);
         * webElement.click();
         * 
         * WebElement emailInput = driver.findElement(By.id("email_create"));
         * 
         * if (emailInput != null)
         * System.out.println(emailInput.getText());
         * // webElement.sendKeys("Joko1@gmail.com");
         * 
         * String str2 = driver.getTitle();
         * System.out.printf("\n\n%str\n\n", str2);
         * 
         * // By by = By.id("id");
         * // webElement = driver.findElement()
         * 
         * driver.quit();
         */
        // FirefoxOptions options1 = new FirefoxOptions();
        // var driver1 = new FirefoxDriver(options1);
        // driver1.get("https://sd.ua");
        // String str = driver1.getTitle();
        // System.out.printf("\n\n%str\n\n", str);
        // driver1.quit();
    }
}
