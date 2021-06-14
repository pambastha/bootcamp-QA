package support;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

public class DriverInit {

    public static WebDriver driver;
    private final String browser = System.getProperty("browser");
    private String baseUrl = "http://spree-vapasi.herokuapp.com/";

    public void getBrowser() {
        if(null == browser || browser.isEmpty()) {
            WebDriverManager.chromedriver().setup();
            this.driver = new ChromeDriver();
        } else if(browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            this.driver = new ChromeDriver();
        } else if (browser.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            this.driver = new EdgeDriver();
        } else {
            WebDriverManager.chromedriver().setup();
            this.driver = new ChromeDriver();
        }

        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.driver.manage().window().maximize();

        this.driver.get(baseUrl);
    }

    public WebDriver getWebDriver() {
        return this.driver;
    }

    public void closeBrowser() {
        this.driver.close();
        this.driver.quit();
    }



}
