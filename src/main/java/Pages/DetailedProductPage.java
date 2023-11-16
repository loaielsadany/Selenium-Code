package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DetailedProductPage extends PageBase{
    public DetailedProductPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css="strong.current-item")
    public WebElement detailedProductName;

    @FindBy(css = "button.button-2.email-a-friend-button")
    WebElement emailAFriendBtn;

    @FindBy(id="price-value-4")
    public WebElement productPrice;

    @FindBy(linkText = "Add your review")
    WebElement addReviewLink;

    @FindBy(id = "add-to-wishlist-button-4")
    WebElement addToWishListBtn;
    @FindBy(css = "span.close")
    WebElement crossWishMessage;
    @FindBy(css="button.button-2.add-to-compare-list-button")
    WebElement addToCompareListBtn;
    @FindBy(id="add-to-cart-button-4")
    WebElement addToCartBtn;

    public void emailAFriendAProduct(){
        clickButton(emailAFriendBtn);
    }

    public void openReviewPage(){clickButton(addReviewLink);}

    public void addProductTOWishListByUser() throws InterruptedException {

        clickButton(addToWishListBtn);
        Thread.sleep(3000);
        clickButton(crossWishMessage);
    }

    public void addToCompareListByUser(){
        clickButton(addToCompareListBtn);
    }

    public void addToCartByUser(){clickButton(addToCartBtn);}
}
