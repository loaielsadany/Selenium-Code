package Test;

import Utilities.Helper;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.HashMap;

public class TestBase extends AbstractTestNGCucumberTests {
    public static WebDriver driver;

    public static String downloadPath="D:\\MY LIFE-2024\\SW TEST\\UdemyProject\\NopCommerce\\Downloads";

    public static FirefoxOptions firefoxOptions(){

        FirefoxOptions options=new FirefoxOptions();
        options.addPreference("browser.download.folderList",2);
        options.addPreference("browser.download.dir",downloadPath);
        return options;
    }

    public static ChromeOptions chromeOptions(){

        ChromeOptions options=new ChromeOptions();
        HashMap<String,Object> chromePrefs=new HashMap<String,Object>();
        chromePrefs.put("profile.default.content_settings.popups",0);
        chromePrefs.put("download.default_directory",downloadPath);
        options.setExperimentalOption("prefs",chromePrefs);

        return options;
    }

    @BeforeSuite
    @Parameters("browser")

    public void startDriver(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver(chromeOptions());
        }

        if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver(firefoxOptions());
        }

        if (browserName.equalsIgnoreCase("ie")) {
            driver = new InternetExplorerDriver();
        }
        if(browserName.equalsIgnoreCase("headless")) {


            DesiredCapabilities caps=new DesiredCapabilities();
            caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,"D:\\MY LIFE-2024\\SW TEST\\Driver\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
            String[]phantomArgs={"--web-security=no","--ignore-ssl-errors=yes"};
            caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS,phantomArgs);
            driver=new PhantomJSDriver(caps);

        }
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
        driver.manage().window().maximize();
    }




//    @AfterSuite
//    public void stopDriver(){
//        driver.quit();
//    }

    @AfterMethod
    public void takeScreenshotOnFailure(ITestResult result) throws IOException {

        if(result.getStatus()==ITestResult.FAILURE){
            System.out.println("Failed!");
            System.out.println("Taking Screenshot");
            Helper.takeScreenShot(driver,result.getName());
        }

    }

}
