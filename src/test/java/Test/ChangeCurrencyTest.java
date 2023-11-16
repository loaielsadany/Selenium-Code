package Test;

import Pages.DetailedProductPage;
import Pages.HomePage;
import Pages.SearchProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangeCurrencyTest extends TestBase {


    HomePage homeObject;
    SearchProductPage searchProductObject;
    DetailedProductPage detailedProductObject;
    String productName;

    @Test(priority = 1)
    public void checkChangeCurrencyByUser() {
        homeObject = new HomePage(driver);
        homeObject.changeCurrencyByUserToEuro();
    }

    @Test(priority = 2)
    public void checkSearchUsingAutoCompleteByUser() throws InterruptedException {
        searchProductObject=new SearchProductPage(driver);
        searchProductObject.searchProductUsingAutoCompleteByUser("macb");
        detailedProductObject=new DetailedProductPage(driver);
        Assert.assertTrue(detailedProductObject.detailedProductName.getText().contains("Mac"));
        Assert.assertTrue(detailedProductObject.productPrice.getText().contains("€"));
        System.out.println(detailedProductObject.productPrice.getText());


    }



    }
