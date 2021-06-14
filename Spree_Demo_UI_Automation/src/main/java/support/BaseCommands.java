package support;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class BaseCommands {

    DriverInit driverInit = new DriverInit();

    public WebDriver getWebDriver() {
        return driverInit.getWebDriver();
    }

    public void assertBrowserTitle(String expectedValue) {
        Assert.assertEquals(getWebDriver().getTitle(), expectedValue);
    }

    public WebElement element(String locator) {
        return getWebDriver().findElement(By.cssSelector(locator));
    }

    public void clickOnElement(String locator) {
        element(locator).click();
    }

    public void sendKeys(String locator, String expectedValue) {
        element(locator).clear();
        element(locator).sendKeys(expectedValue);
    }

    public String getElementText(String locator) {
        return element(locator).getText();
    }
}
