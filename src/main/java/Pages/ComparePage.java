package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ComparePage extends PageBase{
    public ComparePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="a.clear-list")
    WebElement clearListLink;

    @FindBy(css = "table.compare-products-table")
    List<WebElement> tableCompare;

    @FindBy(tagName = "tr")
    List<WebElement> allRows;

    @FindBy(tagName = "td")
    List<WebElement> allCols;

    @FindBy(css="div.no-data")
    public WebElement clearCompareMessage;

    @FindBy(linkText = "Apple MacBook Pro 13-inch")
    public WebElement fistProductName;

    @FindBy(linkText = "Asus N551JK-XO076H Laptop")
    public WebElement secondProductName;

    public void compareProductsDetailsByUser(){


            for (WebElement row:allRows)
            {
                System.out.println(row.getText()+"\t");
            }


    }

    public void clearCompareProductByUser(){
        clickButton(clearListLink);
    }




}
