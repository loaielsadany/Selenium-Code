package Utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class Helper {

    public static String screenShootLocation="D:\\MY LIFE-2024\\SW TEST\\UdemyProject\\NopCommerce\\Screenshots";
    public static void takeScreenShot(WebDriver driver,String screenShotName) throws IOException {

        TakesScreenshot ts=(TakesScreenshot) driver;
        File source=ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source,new File(screenShootLocation,screenShotName+".png"));


    }
}
