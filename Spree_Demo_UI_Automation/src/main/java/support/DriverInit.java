package support;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static java.lang.System.getProperty;

public class DriverInit {

    private final String baseUrl = "http://spree-vapasi.herokuapp.com/";
    private final String browser = getProperty("browser");
    public static WebDriver driver;

    public void getBrowser() {
        if (null == browser || browser.isEmpty()) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("--disable-dev-shm-usage");// overcome limited resource problems
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox"); // Bypass OS security model
            options.addArguments("--remote-debugging-port=9222");
            this.driver = new ChromeDriver(options);
        } else {
            if (browser.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless");
                options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
                options.addArguments("--disable-gpu");
                options.addArguments("--no-sandbox"); // Bypass OS security model
                options.addArguments("--remote-debugging-port=9222");
                this.driver = new ChromeDriver(options);
            }
        }
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.driver.manage().window().maximize();
        getBaseUrl();
    }

    private void getBaseUrl() {
        this.driver.get(baseUrl);
    }

    public WebDriver getWebDriver() {
        return this.driver;
    }

    public void closeBrowser() {
        this.driver.quit();
    }
}
