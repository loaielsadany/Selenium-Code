package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailAFriendAProductPage extends PageBase {
    public EmailAFriendAProductPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id="FriendEmail")
    WebElement friendEmailTxtBox;
    @FindBy(id="YourEmailAddress")
    WebElement yourEmailTxtBox;

    @FindBy(id="PersonalMessage")
    WebElement personalMessageTxtBox;
    @FindBy(name = "send-email")
    WebElement sendMailBtn;

    @FindBy(css="div.result")
    public WebElement emailAFriendAProductNotificationMessage;

    public void emailAFriendAProduct(String friendMail,String personalMessage){
        sendText(friendEmailTxtBox,friendMail);
        sendText(personalMessageTxtBox,personalMessage);
        clickButton(sendMailBtn);

    }



}
