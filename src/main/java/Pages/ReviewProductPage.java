package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReviewProductPage extends PageBase{
    public ReviewProductPage(WebDriver driver) {
        super(driver);
    }

@FindBy(id="AddProductReview_Title")
WebElement reviewTittleTxtBox;

@FindBy(id="AddProductReview_ReviewText")
WebElement reviewTxtBox;

@FindBy(id="addproductrating_4")
WebElement productRatingRdoBtn4;

@FindBy(css = "button.button-1.write-product-review-button")
WebElement submitReviewBtn;
@FindBy(css = "div.result")
public WebElement reviewNotificationMessage;

public void addReviewByUser(String reviewTittle,String reviewText){
    sendText(reviewTittleTxtBox,reviewTittle);
    sendText(reviewTxtBox,reviewText);
    clickButton(productRatingRdoBtn4);
    clickButton(submitReviewBtn);
}
}
