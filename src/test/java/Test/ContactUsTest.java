package Test;

import Pages.ContactUsPage;
import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactUsTest extends TestBase{

    HomePage homeObject;
    ContactUsPage contactUsObject;
    String yourName="loai";
    String yourEmail= "l025.taha@gmail.com";
    String yourMessage= "How are you";

    @Test

    public void checkContactUsByUser(){
        homeObject=new HomePage(driver);
        contactUsObject=new ContactUsPage(driver);
        homeObject.openContactUsPageByUser();
        contactUsObject.contactUsByUser(yourName,yourEmail,yourMessage);
        Assert.assertTrue(contactUsObject.contactUsMessage.getText().contains("Your enquiry has been successfully"));
    }
}
