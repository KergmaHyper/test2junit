package test2;

import java.util.Scanner;

import com.google.common.math.Quantiles.Scale;

//import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Calc {

    public static int add(int x, int y) {
        return x + y;
    }

    public static int mlt(int x, int y) {
        return x * y;
    }

    public static int dvd(int x, int y) {
        return x / y;
    }

    public static int sub(int x, int y) {
        return x - y;
    }

    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        var driver = new ChromeDriver(options);
        driver.get("https://sd.ua");
        String str = driver.getTitle();
        System.out.printf("\n\n%str\n\n", str);
        driver.quit();

        // FirefoxOptions options1 = new FirefoxOptions();
        // var driver1 = new FirefoxDriver(options1);
        // driver1.get("https://sd.ua");
        // String str = driver1.getTitle();
        // System.out.printf("\n\n%str\n\n", str);
        // driver1.quit();
    }

}
