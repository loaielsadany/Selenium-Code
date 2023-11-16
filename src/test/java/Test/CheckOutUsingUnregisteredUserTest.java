package Test;

import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckOutUsingUnregisteredUserTest extends TestBase{

    SearchProductPage searchProductObject;
    DetailedProductPage detailedProductObject;
//    RegistrationPage registrationObject;
//    HomePage homeObject;
//    LoginPage loginObject;
    AddToCartPage addToCartObject;
    CheckOutPage checkOutObject;
    OrderDetailPage orderDetailObject;

    String firstName="loai";
    String lastName="Taha";
    String email="lnapp.tshs@gmsil.com";

//    String password="123456789";

    String billingCountry="United States";
    String billingState="Alaska";
    String billingCity="tesa";
    String billingAddress="shoubra Street";
    String billingPostCode="1001";
    String billingPhoneNo="01117756689";



    @Test(priority = 1)

    public void checkSearchUsingAutoCompleteByUser() throws InterruptedException {
        searchProductObject = new SearchProductPage(driver);
        searchProductObject.searchProductUsingAutoCompleteByUser("macb");
        detailedProductObject = new DetailedProductPage(driver);
        Assert.assertTrue(detailedProductObject.detailedProductName.getText().contains("Mac"));
    }

    @Test(dependsOnMethods = {"checkSearchUsingAutoCompleteByUser"})
    public void checkAddToCart() throws InterruptedException {
        detailedProductObject.addToCartByUser();
        Thread.sleep(2000);
        driver.get("https://demo.nopcommerce.com/cart");
        Thread.sleep(2000);
        addToCartObject = new AddToCartPage(driver);
        addToCartObject.changeQuantityInAddTOCart("5");
        Assert.assertTrue(addToCartObject.productNameLink.getText().contains("Apple"));
        Thread.sleep(5000);
    }

    @Test(dependsOnMethods = {"checkAddToCart"})
    public void checkCheckoutByUnregisteredUser() throws InterruptedException {

        addToCartObject.openCheckOutByUser();
        checkOutObject=new CheckOutPage(driver);
        checkOutObject.checkOutAsGuestByUser();
        checkOutObject.checkOutByUnregisteredUser(firstName,lastName,email,billingCountry,billingState,billingCity,billingAddress,billingPostCode,billingPhoneNo);
        Thread.sleep(1000);
        System.out.println(checkOutObject.successMessage.getText());
        Assert.assertTrue(checkOutObject.successMessage.getText().contains("Your order has been successfully "));
    }
    @Test (dependsOnMethods = {"checkCheckoutByUnregisteredUser"})
    public void checkInvoiceByUser() {
        checkOutObject.openOrderDetail();
        orderDetailObject = new OrderDetailPage(driver);
        orderDetailObject.invoiceByUser();

    }
    }
