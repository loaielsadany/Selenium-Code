package Test;

import Pages.HomePage;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HoverTest extends TestBase{

    HomePage homeObject;

    @Test
    public void checkHoverAndSelect()  {
        homeObject=new HomePage(driver);
        homeObject.selectNoteBooksByHover();
        Assert.assertTrue(driver.getCurrentUrl().contains("notebooks"));
       ;
    }

}
