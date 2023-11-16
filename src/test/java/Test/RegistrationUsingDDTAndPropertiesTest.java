package Test;

import Data.LoadProperties;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationUsingDDTAndPropertiesTest extends TestBase {

    HomePage homeObject;
    RegistrationPage registrationObject;
    LoginPage loginObject;
    String firstName= LoadProperties.userData.getProperty("firstName");
    String lastName= LoadProperties.userData.getProperty("lastName");
    String email= LoadProperties.userData.getProperty("email");
    String password= LoadProperties.userData.getProperty("password");

    @Test (priority = 1)
    public void checkRegistrationSuccessfully(){

        System.out.println(LoadProperties.userData);
        homeObject=new HomePage(driver);
        registrationObject=new RegistrationPage(driver);

        homeObject.openRegistrationPage();
        registrationObject.register(firstName,lastName,email,password);

        Assert.assertEquals("Your registration completed",registrationObject.registerSuccessfulMessage.getText());

    }

    @Test (dependsOnMethods = {"checkRegistrationSuccessfully"})
    public void checkLoginByRegisteredUser(){
        homeObject.openLoginPage();
        loginObject=new LoginPage(driver);
        loginObject.loginByRegisteredUser(email,password);
        Assert.assertTrue(homeObject.logoutLink.isDisplayed());


    }

    @Test(dependsOnMethods = {"checkLoginByRegisteredUser"})
    public void checkLogoutByRegisteredUserAfterChangePassword() throws InterruptedException {


        homeObject.logoutByRegisteredUser();

    }

}
