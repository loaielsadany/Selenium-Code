package Test;

import Pages.DetailedProductPage;
import Pages.SearchProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchAutoCompleteTest extends TestBase {


    SearchProductPage searchProductObject;
    DetailedProductPage detailedProductObject;
    @Test
    public void checkSearchUsingAutoCompleteByUser() throws InterruptedException {
        searchProductObject=new SearchProductPage(driver);
        searchProductObject.searchProductUsingAutoCompleteByUser("macb");
        detailedProductObject=new DetailedProductPage(driver);
        Assert.assertTrue(detailedProductObject.detailedProductName.getText().contains("Mac"));

    }
}
