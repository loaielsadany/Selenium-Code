package Pages;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase{
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (linkText = "Change password")
    WebElement changePasswordLink;
    @FindBy(id="OldPassword")
    WebElement oldPasswordBtn;
    @FindBy(id="NewPassword")
    WebElement newPasswordBtn;
    @FindBy(id="ConfirmNewPassword")
    WebElement confirmPasswordBtn;
    @FindBy(css ="button.button-1.change-password-button")
    WebElement changePasswordBtn;
    @FindBy(css = "span.close")
    WebElement crossBtn;

    @FindBy(css="p.content")
    public WebElement changePasswordSuccessfulMessage;


    public void openChangePasswordPage(){clickButton(changePasswordLink);}

    public void changePasswordByRegisteredUser (String oldPassword,String newPassword){
        sendText(oldPasswordBtn,oldPassword);
        sendText(newPasswordBtn,newPassword);
        sendText(confirmPasswordBtn,newPassword);
        clickButton(changePasswordBtn);
    }

    public void releaseChangePasswordMessage(){
        clickButton(crossBtn);
    }


}
