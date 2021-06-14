package pages;

import support.BaseCommands;

public class ProductDetailsPage {

    BaseCommands cmd = new BaseCommands();

    public void assertBrowserTitle(String productName) {
        cmd.assertBrowserTitle(productName + " - Spree Demo Site");
    }

}
