package pages;

import maps.HomeMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import support.DriverInit;

import java.util.LinkedList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class HomePage {

    HomeMap homeMap = new HomeMap();
    DriverInit driverInit = new DriverInit();

    public WebDriver getWebDriver() {
        return driverInit.getWebDriver();
    }

    public void assertBrowserTitle() {
        assertEquals(getWebDriver().getTitle(), "Spree Demo Site");

    }

    public void clickOnSearchBox() {
        getWebDriver().findElement(By.cssSelector(homeMap.SEARCH_TEXT_BOX)).click();
    }

    public void enterSearchCriteriaToSearchBox(String searchKey) {
        clickOnSearchBox();
        getWebDriver().findElement(By.cssSelector(homeMap.SEARCH_TEXT_BOX)).sendKeys(searchKey);
    }

    public void clickOnSearchSubmitButton() {
        getWebDriver().findElement(By.cssSelector(homeMap.SEARCH_QUERY_SUBMIT)).click();
    }

    public String getSearchResultSelector(String searchKey) {
        return homeMap.SEARCH_RESULT_ITEMS.replace("searchKey", searchKey);
    }

    public void waitForSearchResultsVisibility(String searchKey) {
        getWebDriver().findElement(By.cssSelector(getSearchResultSelector(searchKey))).isDisplayed();
    }

    public String getSearchResult(String searchKey) {
        return getWebDriver().findElement(By.cssSelector(getSearchResultSelector(searchKey)))
                .getText();
    }

    public void assertSearchResult(String searchKey, String expectedSearchItem) {
        assertEquals(getSearchResult(searchKey), expectedSearchItem);
    }

    public List<String> getSearchResults(String searchKey) {
        List<WebElement> webElements = getWebDriver().findElements(By.cssSelector(getSearchResultSelector(searchKey)));
        List<String> elementsText = new LinkedList<>();
        if (null != webElements || webElements.isEmpty()) {
            for (WebElement webElement : webElements) {
                elementsText.add(webElement.getText());
            }
        }
        return elementsText;
    }

    public void clickOnSearchResultItem(String itemName) {
        getWebDriver().findElement(By.cssSelector(getSearchResultSelector(itemName))).click();
    }

    public int numberOfElements(String searchKey) {
        List<WebElement> webElements = getWebDriver().findElements(By.cssSelector(getSearchResultSelector(searchKey)));
        int counter = 0;
        if (null != webElements || webElements.isEmpty()) counter = webElements.size();
        return counter;
    }

    public void assertNumberOfSearchResults(String searchKey, int expectedSearchResultNumbers) {
        assertEquals(numberOfElements(searchKey), expectedSearchResultNumbers);
    }
}