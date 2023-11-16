package Test;

import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EmailProductToFriendTest extends TestBase {

    SearchProductPage searchProductObject;
    DetailedProductPage detailedProductObject;
    RegistrationPage registrationObject;
    HomePage homeObject;
    EmailAFriendAProductPage emailAFriendAProductObject;
    LoginPage loginObject;
    String firstName="loai";
    String lastName="Taha";
    String email="lpo.tshs@gmsil.com";

    String password="123456789";
    String friendMail="w1.hussien@gmail.com";

    String personalMessage="Hi this is a good product";



    @Test (priority = 1)
    public void checkRegistrationSuccessfully(){
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



    @Test(dependsOnMethods ={"checkLoginByRegisteredUser"})

    public void checkSearchUsingAutoCompleteByUser() throws InterruptedException {
        searchProductObject = new SearchProductPage(driver);
        searchProductObject.searchProductUsingAutoCompleteByUser("macb");
        detailedProductObject = new DetailedProductPage(driver);
        Assert.assertTrue(detailedProductObject.detailedProductName.getText().contains("Mac"));
    }



    @Test (dependsOnMethods ={"checkSearchUsingAutoCompleteByUser"} )

    public void checkEmailAFriendAProduct(){
        detailedProductObject.emailAFriendAProduct();
        emailAFriendAProductObject=new EmailAFriendAProductPage(driver);
        emailAFriendAProductObject.emailAFriendAProduct(friendMail,personalMessage);
        Assert.assertTrue(emailAFriendAProductObject.emailAFriendAProductNotificationMessage.
                getText().contains("Your message has been sent"));

    }

    @Test(dependsOnMethods = {"checkEmailAFriendAProduct"})
    public void checkLogoutByRegisteredUserAfterReview() {
        homeObject.logoutByRegisteredUser();
    }
}