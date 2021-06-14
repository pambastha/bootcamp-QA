import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;

public class SearchProductTest extends BaseTest {

    HomePage homePage = new HomePage();
    ProductDetailsPage productDetailsPage = new ProductDetailsPage();

    @Test
    public void searchProductAndValidateTest() {
        homePage.assertBrowserTitle();
//        loginPage.enterUserName("prashant");
//        loginPage.enterPassword("prashant123");
//        loginPage.submit;

        homePage.setValueForSearchTextBox("jersey");
        homePage.clickOnSearchButton();

        String expectedItem = "Apache Baseball Jersey";
        homePage.assertProductInSearchResults(expectedItem);
        homePage.clickOnSearchResultsItem(expectedItem);

        productDetailsPage.assertBrowserTitle(expectedItem);
    }

}
