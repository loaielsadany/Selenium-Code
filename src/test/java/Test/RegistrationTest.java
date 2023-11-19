package Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegistrationPage;
import net.bytebuddy.build.Plugin;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {

    HomePage homeObject;
    RegistrationPage registrationObject;
    LoginPage loginObject;

    @Test (priority = 1)
    public void checkRegistrationSuccessfully(){
        homeObject=new HomePage(driver);
        registrationObject=new RegistrationPage(driver);

        homeObject.openRegistrationPage();
        registrationObject.register("loai","taha","mk011.taha@gmail.com","12345678");

//        Assert.assertEquals("Your registration completed",registrationObject.registerSuccessfulMessage.getText());

    }

    @Test (dependsOnMethods = {"checkRegistrationSuccessfully"})
    public void checkLoginByRegisteredUser(){
        homeObject.openLoginPage();
        loginObject=new LoginPage(driver);
        loginObject.loginByRegisteredUser("mk011.taha@gmail.com","12345678");
        Assert.assertTrue(homeObject.logoutLink.isDisplayed());


    }

    @Test(dependsOnMethods = {"checkLoginByRegisteredUser"})
    public void checkLogoutByRegisteredUserAfterChangePassword() throws InterruptedException {


        homeObject.logoutByRegisteredUser();

    }

}
