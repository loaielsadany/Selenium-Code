package Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegistrationTestUsingDDTAndDataProvider extends TestBase {

    HomePage homeObject;
    RegistrationPage registrationObject;
    LoginPage loginObject;

    @DataProvider(name ="testData")
    public static Object[][] userData(){
       return new Object[][]{{"loai","taha","l1.taha@gmail.com","14587625"},
               {"wedad","hussien","w1.hussien@gmail.com","555555548575"}

       };
    }

    @Test (priority = 1, dataProvider = "testData")
    public void checkRegistrationSuccessfully(String firstName,String lastName,String email,String password){
        homeObject=new HomePage(driver);
        registrationObject=new RegistrationPage(driver);

        homeObject.openRegistrationPage();
        registrationObject.register(firstName,lastName,email,password);

        Assert.assertEquals("Your registration completed",registrationObject.registerSuccessfulMessage.getText());
        homeObject.openLoginPage();
        loginObject=new LoginPage(driver);
        loginObject.loginByRegisteredUser(email,password);
        Assert.assertTrue(homeObject.logoutLink.isDisplayed());
        homeObject.logoutByRegisteredUser();
    }


}
