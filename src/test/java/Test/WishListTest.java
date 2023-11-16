package Test;

import Pages.DetailedProductPage;
import Pages.HomePage;
import Pages.SearchProductPage;
import Pages.WishListPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WishListTest extends TestBase {

    SearchProductPage searchProductObject;
    DetailedProductPage detailedProductObject;
    HomePage homeObject;
    WishListPage wishListObject;

    @Test(priority = 1)
    public void checkSearchUsingAutoCompleteByUser() throws InterruptedException {
        searchProductObject = new SearchProductPage(driver);
        searchProductObject.searchProductUsingAutoCompleteByUser("macb");
        detailedProductObject = new DetailedProductPage(driver);
        Assert.assertTrue(detailedProductObject.detailedProductName.getText().contains("Mac"));
    }

    @Test(dependsOnMethods = {"checkSearchUsingAutoCompleteByUser"})
    public void checkAddProductToWishList() throws InterruptedException {
        wishListObject=new WishListPage(driver);
        homeObject=new HomePage(driver);
        detailedProductObject.addProductTOWishListByUser();
        homeObject.openWishList();
        Assert.assertTrue(wishListObject.productNameInWishList.getText().contains("Apple MacBook"));
    }

    @Test(dependsOnMethods = {"checkAddProductToWishList"})
    public void checkRemoveProductFromWishList(){
        wishListObject.removeProductToWishListByUser();
        Assert.assertTrue(wishListObject.wishListMessage.getText().contains("The wishlist is empty"));
    }
}