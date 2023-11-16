package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase{
    public ContactUsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "FullName")
    WebElement yourName;

    @FindBy(id = "Email")
    WebElement yourEmail;

    @FindBy(id = "Enquiry")
    WebElement yourMessage;

    @FindBy(name = "send-email")
    WebElement submitBtn;

    @FindBy(css="div.result")
    public WebElement contactUsMessage;

    public void contactUsByUser(String name,String email,String message){

        sendText(yourName,name);
        sendText(yourEmail,email);
        sendText(yourMessage,message);
        clickButton(submitBtn);
    }


}
