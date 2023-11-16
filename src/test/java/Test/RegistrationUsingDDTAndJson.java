package Test;

import Data.JsonDataReader;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegistrationPage;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class RegistrationUsingDDTAndJson extends TestBase {

    HomePage homeObject;
    RegistrationPage registrationObject;
    LoginPage loginObject;

    @Test (priority = 1)
    public void checkRegistrationSuccessfully() throws IOException, ParseException {

       JsonDataReader jsonObject=new JsonDataReader();
       jsonObject.JasonReader();

        homeObject=new HomePage(driver);
        registrationObject=new RegistrationPage(driver);

        homeObject.openRegistrationPage();
        registrationObject.register(jsonObject.firstName, jsonObject.lastName, jsonObject.email,jsonObject.password );

        Assert.assertEquals("Your registration completed",registrationObject.registerSuccessfulMessage.getText());
        homeObject.openLoginPage();
        loginObject=new LoginPage(driver);
        loginObject.loginByRegisteredUser(jsonObject.email, jsonObject.password);
        Assert.assertTrue(homeObject.logoutLink.isDisplayed());
        homeObject.logoutByRegisteredUser();

    }


}