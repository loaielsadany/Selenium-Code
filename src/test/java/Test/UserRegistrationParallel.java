package Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegistrationPage;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserRegistrationParallel extends TestBase2{

    HomePage homeObject;
    RegistrationPage registrationObject;
    LoginPage loginObject;
    Faker faker=new Faker();
    String firstName= faker.name().firstName();
    String lastName=faker.name().lastName();
    String email=faker.internet().emailAddress();
    String password=faker.number().digits(8);

    @Test(priority = 1)
    public void checkRegistrationSuccessfully(){
        homeObject=new HomePage(driver);
        registrationObject=new RegistrationPage(driver);

        homeObject.openRegistrationPage();
        registrationObject.register(firstName,lastName,email,password);
        System.out.println("user data are: "+ firstName+" "+lastName+" "+email+" "+password);
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
    public void checkLogoutByRegisteredUserAfterChangePassword()  {


        homeObject.logoutByRegisteredUser();

    }


}
