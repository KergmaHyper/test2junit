package test2;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class App {
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
