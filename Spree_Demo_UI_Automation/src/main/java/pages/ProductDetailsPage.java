package pages;

import maps.ProductDetailsMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import support.DriverInit;

import static org.testng.Assert.assertEquals;

public class ProductDetailsPage {

    ProductDetailsMap productDetailsMap = new ProductDetailsMap();
    DriverInit driverInit = new DriverInit();

    public WebDriver getWebDriver() {
        return driverInit.getWebDriver();
    }

    public void assertProductTitle(String expectedProductTitle) {
        assertEquals(getWebDriver().findElement(By.cssSelector(productDetailsMap.PRODUCT_TITLE)).getText(), expectedProductTitle);
    }

    public void clickOnAddToCartButton() {
        getWebDriver().findElement(By.cssSelector(productDetailsMap.ADD_TO_CART_BUTTON)).click();
    }
}
