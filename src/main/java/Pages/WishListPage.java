package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends PageBase{
    public WishListPage(WebDriver driver) {
        super(driver);
    }




    @FindBy(css= "button.remove-btn")
    WebElement removeWishProductBtn;

    @FindBy(css = "a.product-name")
    public WebElement productNameInWishList;
    @FindBy(css = "div.page-body")
    public WebElement wishListMessage;



    public void removeProductToWishListByUser(){
        clickButton(removeWishProductBtn);
    }
}
