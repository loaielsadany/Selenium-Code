package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchProductPage extends PageBase{
    public SearchProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="small-searchterms")
    WebElement searchTxtBox;
    @FindBy(css = "button.button-1.search-box-button")
    WebElement searchBtn;
    @FindBy(linkText = "Apple MacBook Pro 13-inch")
    WebElement searchedProductLink;
    @FindBy(id="ui-id-1")
    List<WebElement> productList;

    public void searchProductByUser(String productName){
        sendText(searchTxtBox,productName);
        clickButton(searchBtn);
    }
    public void openProductDetails(){
        clickButton(searchedProductLink);
    }
    public void searchProductUsingAutoCompleteByUser(String partOfProductName) throws InterruptedException {
        sendText(searchTxtBox,partOfProductName);
        Thread.sleep(3000);
        clickButton(productList.get(0));

    }
}
