package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddToCartPage extends PageBase{
    public AddToCartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="input.qty-input")
    WebElement quantityOfProductTxtBox;
    @FindBy(css="a.product-name")
     public WebElement productNameLink;
    @FindBy(name="updatecart")
    WebElement removeBtn;
    @FindBy(id="updatecart")
    WebElement updateCartBtn;
    @FindBy(id = "termsofservice")
    WebElement agreeToServiceBtn;
    @FindBy(id = "checkout")
    WebElement checkOutBtn;


    public void changeQuantityInAddTOCart(String quantity){
        clearText(quantityOfProductTxtBox);
        sendText(quantityOfProductTxtBox,quantity);
        clickButton(updateCartBtn);
    }

    public void removeProductFromToCart(){
        clickButton(removeBtn);
    }

    public void openCheckOutByUser(){
        clickButton(agreeToServiceBtn);
        clickButton(checkOutBtn);
    }
}
