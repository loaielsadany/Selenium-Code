package Test;

import Data.ExcelReader;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class RegistrationTestUsingDDTAndExcelTest extends TestBase {

    HomePage homeObject;
    RegistrationPage registrationObject;
    LoginPage loginObject;


    @DataProvider(name="ExcelData")
    public Object[][]userData() throws IOException {
        ExcelReader excelReader=new ExcelReader();
        return excelReader.getExcelData();
    }

    @Test (priority = 1,dataProvider = "ExcelData")
    public void checkRegistrationSuccessfully(String firstName, String lastName,String email,String password){
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


