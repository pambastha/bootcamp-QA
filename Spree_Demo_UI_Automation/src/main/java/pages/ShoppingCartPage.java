package pages;

import maps.ShoppingCartMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import support.DriverInit;

import static org.testng.Assert.assertEquals;

public class ShoppingCartPage {

    ShoppingCartMap shoppingCartMap = new ShoppingCartMap();
    DriverInit driverInit = new DriverInit();

    public WebDriver getWebDriver() {
        return driverInit.getWebDriver();
    }

    public void assertShoppingCartHeader() {
        assertEquals(getWebDriver().findElement(By.cssSelector(shoppingCartMap.CART_HEADER)).getText(),
                "Shopping Cart");
    }

    public void assertProductDescription(String expectedProduct) {
        assertEquals(getWebDriver().findElement(By.cssSelector(shoppingCartMap.ITEM_DESCRIPTION)).getText(),
                expectedProduct);
    }

    public void assertCheckoutLink() {
        assertEquals(getWebDriver().findElement(By.cssSelector(shoppingCartMap.CHECKOUT_LINK)).getText(),
                "Checkout");
    }
}


