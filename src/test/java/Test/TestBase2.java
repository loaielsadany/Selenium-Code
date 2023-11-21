package Test;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import java.net.MalformedURLException;
import java.net.URL;


public class TestBase2 {

    public WebDriver driver;
    public DesiredCapabilities cap=new DesiredCapabilities();

    @BeforeTest
    @Parameters({"browser"})

    public void OpenUrl(String browser) throws MalformedURLException {

        if(browser.equals("chrome")){
            cap.setPlatform(Platform.ANY);
            cap.setBrowserName("chrome");
            ChromeOptions options=new ChromeOptions();
            options.merge(cap);
        }



            else if(browser.equals("firefox")){
                cap.setPlatform(Platform.ANY);
                cap.setBrowserName("firefox");
                FirefoxOptions options=new FirefoxOptions();
                options.merge(cap);
            }





        driver=new RemoteWebDriver(new URL("http://192.168.1.115:4444"),cap);
        driver.get("https://demo.nopcommerce.com");
    }
}
