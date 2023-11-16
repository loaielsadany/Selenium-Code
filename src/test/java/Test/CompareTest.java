package Test;

import Pages.ComparePage;
import Pages.DetailedProductPage;
import Pages.SearchProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CompareTest extends TestBase{

    SearchProductPage searchProductObject;
    DetailedProductPage detailedProductObject;
    ComparePage compareObject;

    String firstProductName="Apple MacBook Pro 13-inch";
    String secondProductName="Asus N551JK-XO076H Laptop";

    @Test(priority = 1)

    public void checkSearchUsingAutoCompleteByUser() throws InterruptedException {
        searchProductObject=new SearchProductPage(driver);
        searchProductObject.searchProductUsingAutoCompleteByUser("macb");
        detailedProductObject=new DetailedProductPage(driver);
        detailedProductObject.addToCompareListByUser();
        System.out.println(detailedProductObject.detailedProductName.getText());
        Assert.assertTrue(detailedProductObject.detailedProductName.getText().contains(firstProductName));

        searchProductObject.searchProductUsingAutoCompleteByUser("asus");
        detailedProductObject.addToCompareListByUser();
        Thread.sleep(1000);
        System.out.println(detailedProductObject.detailedProductName.getText());
        Assert.assertTrue(detailedProductObject.detailedProductName.getText().contains(secondProductName));
    }

    @Test(dependsOnMethods = {"checkSearchUsingAutoCompleteByUser"})

    public void checkCompareByUser(){

        driver.get("https://demo.nopcommerce.com/compareproducts");
        compareObject=new ComparePage(driver);
        compareObject.compareProductsDetailsByUser();
        Assert.assertTrue(compareObject.fistProductName.getText().equals("Apple MacBook Pro 13-inch"));
        Assert.assertTrue(compareObject.secondProductName.getText().equals("Asus N551JK-XO076H Laptop"));
    }

//    @Test(dependsOnMethods = {"checkCompareByUser"})
//    public void checkClearCompareByUser() throws InterruptedException {
//        Thread.sleep(5000);
//        compareObject.clearCompareProductByUser();
//        Assert.assertTrue(compareObject.clearCompareMessage.getText().contains("You have no items to compare"));
//
//    }

}
