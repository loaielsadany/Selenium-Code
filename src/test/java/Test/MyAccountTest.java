package Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.MyAccountPage;
import Pages.RegistrationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class MyAccountTest extends TestBase{

    HomePage homeObject;
    RegistrationPage registrationObject;
    LoginPage loginObject;
    MyAccountPage myAccountObject;
    String firstName="loai";
    String lastName="Taha";
    String oldPassword="01234567";
    String newPassword="12345678910";
    String email="loaiacavhj.taha12@gmail.com";


    @Test(priority = 1)
    public void checkRegistrationSuccessfully(){
        homeObject=new HomePage(driver);
        registrationObject=new RegistrationPage(driver);

        homeObject.openRegistrationPage();
        registrationObject.register(firstName,lastName,email,oldPassword);

        Assert.assertEquals("Your registration completed",registrationObject.registerSuccessfulMessage.getText());

    }

    @Test (dependsOnMethods = {"checkRegistrationSuccessfully"})
    public void checkLoginByRegisteredUser(){
        homeObject.openLoginPage();
        loginObject=new LoginPage(driver);
        loginObject.loginByRegisteredUser(email,oldPassword);
        Assert.assertTrue(homeObject.logoutLink.isDisplayed());
    }

    @Test(dependsOnMethods = {"checkLoginByRegisteredUser"})
    public void checkMyAccountChangePassword() throws InterruptedException {
        myAccountObject=new MyAccountPage(driver);
        homeObject.openMyAccount();
        myAccountObject.openChangePasswordPage();
        myAccountObject.changePasswordByRegisteredUser(oldPassword,newPassword);
        Assert.assertTrue(myAccountObject.changePasswordSuccessfulMessage.isDisplayed());
    }

    @Test(dependsOnMethods = {"checkMyAccountChangePassword"})
    public void checkMyAccountChangePasswordRelease(){
        myAccountObject.releaseChangePasswordMessage();
    }


    @Test(dependsOnMethods = {"checkMyAccountChangePasswordRelease"})
    public void checkLogoutByRegisteredUser() throws InterruptedException {
//        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.elementToBeClickable(homeObject.logoutLink));
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(3000);

        homeObject.logoutByRegisteredUser();
    }
    @Test (dependsOnMethods = {"checkLogoutByRegisteredUser"})
    public void checkLoginByRegisteredUserAfterChangePassword() {
        homeObject.openLoginPage();
//        loginObject = new LoginPage(driver);
        loginObject.loginByRegisteredUser(email, newPassword);
        Assert.assertTrue(homeObject.logoutLink.isDisplayed());
    }

    @Test(dependsOnMethods = {"checkLoginByRegisteredUserAfterChangePassword"})
    public void checkLogoutByRegisteredUserAfterChangePassword() throws InterruptedException {
//        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.elementToBeClickable(homeObject.logoutLink));
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(3000);

        homeObject.logoutByRegisteredUser();

    }

}
