package pages;

import maps.HomeMap;
import org.testng.Assert;
import support.BaseCommands;

public class HomePage {

    BaseCommands cmd = new BaseCommands();
    HomeMap homeMap = new HomeMap();

    public void assertBrowserTitle() {
        cmd.assertBrowserTitle("Spree Demo Site");
    }

    public void setValueForSearchTextBox(String expectedValue) {
        cmd.clickOnElement(homeMap.SEARCH_TEXT_BOX);
        cmd.sendKeys(homeMap.SEARCH_TEXT_BOX, expectedValue);
    }

    public void clickOnSearchButton() {
        cmd.clickOnElement(homeMap.SEARCH_SUBMIT_BUTTON);
    }

    public String getNewLocatorForSearchResultsItem(String expectedValue) {
        return homeMap.SEARCH_RESULTS_ITEM.replace("searchKey", expectedValue);
    }

    public void assertProductInSearchResults(String expectedValue) {
        Assert.assertEquals(cmd.getElementText(getNewLocatorForSearchResultsItem(expectedValue)),
                expectedValue);
    }

    public void clickOnSearchResultsItem(String itemName) {
       cmd.clickOnElement(getNewLocatorForSearchResultsItem(itemName));
    }

//    public void searchProduct(String expectedValue) {
//        setValueForSearchTextBox(expectedValue);
//        cmd.clickOnElement(homeMap.SEARCH_SUBMIT_BUTTON);
//    }


}
