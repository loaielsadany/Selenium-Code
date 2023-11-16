package Steps;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegistrationPage;
import Test.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class UserRegistration extends TestBase {
    HomePage homeObject;
    RegistrationPage registrationObject;
    LoginPage loginObject;

    @Given("the User in the Home Page")
    public void the_user_in_the_home_page() {
        homeObject=new HomePage(driver);
        homeObject.openRegistrationPage();
    }
    @When("I click on register link")
    public void i_click_on_register_link() {
        Assert.assertTrue(driver.getCurrentUrl().contains("register"));

    }
    @When("I entered the user Data {string},{string}, {string},{string}")
    public void i_entered_the_user_data(String firstname, String lastname, String email, String password) {
        registrationObject=new RegistrationPage(driver);
        registrationObject.register(firstname,lastname,email,password);
        homeObject.openLoginPage();
        loginObject=new LoginPage(driver);
        loginObject.loginByRegisteredUser(email,password);

    }
    @Then("The registration page displayed Successfully")
    public void the_registration_page_displayed_successfully() {



         homeObject.logoutByRegisteredUser();

    }

}
