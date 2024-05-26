package utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Browser;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import static utility.Base.driver;

public class Screenshots {
//    public static Webdriver driver;
    public static String captureScreenshot() {
        Long l= Calendar.getInstance().getTimeInMillis();
        String screenshotId=l.toString();

        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "/test-result/Reports/";
        String imgPath = path+screenshotId+".png";
        File destination = new File(imgPath);

        try {
            FileUtils.copyFile(src, destination);
            System.out.println("Image captured successful"+src+"&"+destination);
        } catch (IOException e) {
            System.out.println("Capture failed" + e.getMessage());
        }
        String ImagePath = destination.getAbsolutePath();
    return ImagePath;
    }

}
