package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderDetailPage extends PageBase{
    public OrderDetailPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(linkText = "Print")
    WebElement invoicePrintLink;

    @FindBy(linkText = "PDF Invoice")
    WebElement invoiceDownload;

    public void invoiceByUser(){
        clickButton(invoicePrintLink);
        clickButton(invoiceDownload);
    }

}
