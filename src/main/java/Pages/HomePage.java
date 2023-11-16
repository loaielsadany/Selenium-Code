package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase{
    public HomePage(WebDriver driver) {
        super(driver);
        js=(JavascriptExecutor) driver;
        action=new Actions(driver);
    }

    @FindBy (linkText ="Register")
    WebElement registerLink;

    @FindBy (linkText = "Log in")
    WebElement loginLink;

    @FindBy (linkText = "Log out")
    public WebElement logoutLink;

    @FindBy (linkText = "My account")
    WebElement myAccountLink;

    @FindBy(linkText = "Contact us")
    WebElement contactUsLink;

    @FindBy(id="customerCurrency")
    WebElement currencyDropList;

    @FindBy(linkText ="Computers")
    WebElement computersLink;
    @FindBy(linkText ="Notebooks")
     WebElement noteBooksLink;
    @FindBy(linkText = "Wishlist")
    WebElement wishListLink;

public void openRegistrationPage(){
    clickButton(registerLink);
}

public void openLoginPage(){
    clickButton(loginLink);
}

public void logoutByRegisteredUser(){
    clickButton(logoutLink);
}

public void openMyAccount(){clickButton(myAccountLink);}

public void openContactUsPageByUser(){
    scrollDown();
    clickButton(contactUsLink);}

public void changeCurrencyByUserToEuro(){
    select=new Select(currencyDropList);
    select.selectByVisibleText("Euro");

    }

    public void selectNoteBooksByHover() {

    action.moveToElement(computersLink).build().perform();
    action.moveToElement(noteBooksLink).click().build().perform();
    }

    public void openWishList(){
    clickButton(wishListLink);
    }

}


