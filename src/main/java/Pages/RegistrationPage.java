package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends PageBase {
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="gender-male")
    WebElement genderBtn;

    @FindBy(id="FirstName")
    WebElement firstNameTxtBox;

    @FindBy(id="LastName")
    WebElement lastNameTxtBox;


    @FindBy(id="Email")
    WebElement emailTxtBox;


    @FindBy(id="Password")
    WebElement passwordTxtBox;

    @FindBy(id="ConfirmPassword")
    WebElement confirmPasswordTxtBox;

    @FindBy(id="register-button")
    WebElement registerBtn;

    @FindBy(css = "div.result")
    public  WebElement registerSuccessfulMessage;


    public void register(String firstName,String lastName,String email,String password)
    {
        clickButton(genderBtn);

        sendText(firstNameTxtBox,firstName);
        sendText(lastNameTxtBox,lastName);
        sendText(emailTxtBox,email);
        sendText(passwordTxtBox,password);
        sendText(confirmPasswordTxtBox,password);
        clickButton(registerBtn);

    }

}
