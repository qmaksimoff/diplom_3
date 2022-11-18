package tools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {


    public static WebDriver getBrowser() {
        String browserName;
        try {
            browserName = System.getProperty("browser");
        } catch (RuntimeException e) {
            e.printStackTrace();
            browserName = "chrome";
        }
        if (browserName == null) browserName = "chrome";
        String path = System.getProperty("user.dir");
        switch (browserName) {
            case "chrome": {
                System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
                return new ChromeDriver();
            }
            case "yandex": {
                System.setProperty("webdriver.chrome.driver", "/usr/local/bin/yandexdriver");
                return new ChromeDriver();
            }
            default: {
                System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
                throw new RuntimeException("Unknown browser name!");
            }
        }
    }
}