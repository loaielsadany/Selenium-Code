package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage extends PageBase{
    public CheckOutPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id="BillingNewAddress_FirstName")
    WebElement billingFirstNameTxtBox;

    @FindBy(id="BillingNewAddress_LastName")
    WebElement billingLastNameTxtBox;
    @FindBy(id="BillingNewAddress_Email")
    WebElement billingEmailTxtBox;
    @FindBy(id="BillingNewAddress_CountryId")
    WebElement billingCountryList;
    @FindBy(id="BillingNewAddress_City")
    WebElement billingCitTxtBox;
    @FindBy(id = "BillingNewAddress_StateProvinceId")
    WebElement billingStateTxtBox;
    @FindBy(id="BillingNewAddress_Address1")
    WebElement billingAddressTxtBox;

    @FindBy(id="BillingNewAddress_ZipPostalCode")
    WebElement billingPostCodeTxtBox;
    @FindBy(id="BillingNewAddress_PhoneNumber")
    WebElement billingPhoneNoTxtBox;
    @FindBy(css="button.button-1.new-address-next-step-button")
    WebElement continueBtn1;
    @FindBy(css="button.button-1.shipping-method-next-step-button")
     WebElement continueShippingBtn2;
    @FindBy(css="button.button-1.payment-method-next-step-button")
    WebElement continuePaymentBtn3;
    @FindBy(css="button.button-1.payment-info-next-step-button")
    WebElement continueNxtPaymentBtn4;
    @FindBy(css="button.button-1.confirm-order-next-step-button")
    WebElement confirmBtn5;
    @FindBy(css="button.button-1.order-completed-continue-button")
    WebElement continueCompleteBtn6;

    @FindBy(linkText = "Click here for order details.")
    WebElement orderDetailLink;
    @FindBy(css = "button.button-1.checkout-as-guest-button")
    WebElement checkoutAsGuestBtn;

    @FindBy(css="div.title")
    public WebElement successMessage;

    public void checkOutByRegisteredUser(String country,String state,String city,String address
            ,String postCode,String phoneNumber) throws InterruptedException {
        select=new Select(billingCountryList);
        select.selectByVisibleText(country);
        Thread.sleep(2000);
        select=new Select(billingStateTxtBox);
        select.selectByVisibleText(state);
        sendText(billingCitTxtBox,city);
        sendText(billingAddressTxtBox,address);
        sendText(billingPostCodeTxtBox,postCode);
        sendText(billingPhoneNoTxtBox,phoneNumber);
        Thread.sleep(4000);
        clickButton(continueBtn1);
        Thread.sleep(4000);
        clickButton(continueShippingBtn2);
        Thread.sleep(4000);
        clickButton(continuePaymentBtn3);
        Thread.sleep(4000);
        clickButton(continueNxtPaymentBtn4);
        Thread.sleep(4000);
        clickButton(confirmBtn5);

    }

    public void openOrderDetail(){
        clickButton(orderDetailLink);
    }


    public void checkOutAsGuestByUser(){clickButton(checkoutAsGuestBtn);}

    public void checkOutByUnregisteredUser(String firstName,String lastName,String email, String country,String state,String city,String address,String postCode,String phoneNumber) throws InterruptedException {

        sendText(billingFirstNameTxtBox,firstName);
        sendText(billingLastNameTxtBox,lastName);
        sendText(billingEmailTxtBox,email);
        select=new Select(billingCountryList);
        select.selectByVisibleText(country);
        Thread.sleep(2000);
        select=new Select(billingStateTxtBox);
        select.selectByVisibleText(state);
        sendText(billingCitTxtBox,city);
        sendText(billingAddressTxtBox,address);
        sendText(billingPostCodeTxtBox,postCode);
        sendText(billingPhoneNoTxtBox,phoneNumber);
        Thread.sleep(4000);
        clickButton(continueBtn1);
        Thread.sleep(4000);
        clickButton(continueShippingBtn2);
        Thread.sleep(4000);
        clickButton(continuePaymentBtn3);
        Thread.sleep(4000);
        clickButton(continueNxtPaymentBtn4);
        Thread.sleep(4000);
        clickButton(confirmBtn5);

    }


}
