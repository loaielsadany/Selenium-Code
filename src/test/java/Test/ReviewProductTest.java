package Test;

import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ReviewProductTest extends TestBase{
    HomePage homeObject;
    RegistrationPage registrationObject;
    SearchProductPage searchProductObject;
    DetailedProductPage detailedProductObject;
    LoginPage loginObject;
    ReviewProductPage reviewProductObject;
    String reviewTittle="product review by loai";
    String reviewText="This Product is good and easy to use";
    String firstName ="loai";
    String lastName="taha";
    String email="lo61000.taha@gmail.com";
    String password="12345678910";

    @Test(priority = 1)
    public void checkRegistrationSuccessfully(){
        homeObject=new HomePage(driver);
        registrationObject=new RegistrationPage(driver);

        homeObject.openRegistrationPage();
        registrationObject.register(firstName,lastName,email,password);

        Assert.assertEquals("Your registration completed",registrationObject.
                registerSuccessfulMessage.getText());

    }

    @Test (dependsOnMethods = {"checkRegistrationSuccessfully"})
    public void checkLoginByRegisteredUser(){
        homeObject.openLoginPage();
        loginObject=new LoginPage(driver);
        loginObject.loginByRegisteredUser(email,password);
        Assert.assertTrue(homeObject.logoutLink.isDisplayed());
    }

    @Test (dependsOnMethods = {"checkLoginByRegisteredUser"})
    public void checkSearchUsingAutoCompleteByUser() throws InterruptedException {
        searchProductObject=new SearchProductPage(driver);
        searchProductObject.searchProductUsingAutoCompleteByUser("macb");
        detailedProductObject=new DetailedProductPage(driver);
        Assert.assertTrue(detailedProductObject.detailedProductName.getText().contains("Mac"));
    }

    @Test (dependsOnMethods = {"checkSearchUsingAutoCompleteByUser"})
    public void checkReviewProductByUser()  {
        detailedProductObject.openReviewPage();
        reviewProductObject=new ReviewProductPage(driver);
        reviewProductObject.addReviewByUser(reviewTittle,reviewText);
        Assert.assertTrue(reviewProductObject.reviewNotificationMessage.
                getText().contains("Product review is successfully added"));

    }

    @Test(dependsOnMethods = {"checkReviewProductByUser"})
    public void checkLogoutByRegisteredUserAfterReview() {
        homeObject.logoutByRegisteredUser();

    }



}
