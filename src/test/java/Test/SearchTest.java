package Test;

import Pages.DetailedProductPage;
import Pages.SearchProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends TestBase{

    SearchProductPage searchProductObject;
    DetailedProductPage detailedProductObject;
    String productName= "Apple MacBook Pro 13-inch";
@Test
    public void checkUserCanSearchProduct(){
        searchProductObject=new SearchProductPage(driver);
        searchProductObject.searchProductByUser(productName);
        searchProductObject.openProductDetails();
        detailedProductObject=new DetailedProductPage(driver);
        Assert.assertEquals(productName,detailedProductObject.detailedProductName.getText());

    }
}
