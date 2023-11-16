package Test;

import Pages.AddToCartPage;
import Pages.DetailedProductPage;
import Pages.SearchProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartTest extends TestBase {

    SearchProductPage searchProductObject;
    DetailedProductPage detailedProductObject;
    AddToCartPage addToCartObject;

    @Test(priority = 1)
    public void checkSearchUsingAutoCompleteByUser() throws InterruptedException {
        searchProductObject = new SearchProductPage(driver);
        searchProductObject.searchProductUsingAutoCompleteByUser("macb");
        detailedProductObject = new DetailedProductPage(driver);
        Assert.assertTrue(detailedProductObject.detailedProductName.getText().contains("Mac"));
    }

    @Test(dependsOnMethods = {"checkSearchUsingAutoCompleteByUser"})
    public void checkAddToCart() throws InterruptedException {
        detailedProductObject.addToCartByUser();
        Thread.sleep(2000);
        driver.get("https://demo.nopcommerce.com/cart");
        Thread.sleep(2000);
        addToCartObject = new AddToCartPage(driver);
        addToCartObject.changeQuantityInAddTOCart("5");
        Assert.assertTrue(addToCartObject.productNameLink.getText().contains("Apple"));
        Thread.sleep(5000);

    }

    @Test(dependsOnMethods = {"checkAddToCart"})
    public void checkRemoveProductFromCart() {

        addToCartObject.removeProductFromToCart();
    }

}