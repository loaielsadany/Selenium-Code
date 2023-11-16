package Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegistrationPage;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.apache.commons.lang3.ObjectUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class RegistrationWithDDTAndCSVTest extends TestBase {

    HomePage homeObject;
    RegistrationPage registrationObject;
    LoginPage loginObject;
    CSVReader reader;

    @Test (priority = 1)
    public void checkRegistrationSuccessfully() throws IOException, CsvValidationException {

        String CSVPath=System.getProperty("user.dir")+"\\src\\test\\java\\Data\\New Microsoft Excel Worksheet (2).csv";

        FileReader file=new FileReader(CSVPath);
        reader=new CSVReader(file);
        String[]csvCell;
         while ((csvCell=reader.readNext()) != null)
         {
             String firstName=csvCell[0];
             String lastName=csvCell[1];
             String email=csvCell[2];
             String password=csvCell[3];

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


}
