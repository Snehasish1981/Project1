package utility;

//import ExtentReport.Reporting;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import ExtentReport.ExtentReporter;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Base extends Screenshots{

    public static WebDriver driver;
    public static  ExtentReports report;
    String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
    String repName="Test-Report-"+timeStamp+".html";
    public static ExtentTest logger;

    @BeforeClass
    public void setupSuite()
    {
        ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/test-result/Reports/"+repName));
        report=new ExtentReports();
        report.attachReporter(extent);
    }
    public void startdriver()
    {

//        driver.manage().window().maximize();
    }
    public void launchURL()
    {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Snehashis\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        readConfigproperties prop=new readConfigproperties();
        driver.get(prop.getURL());
//        captureScreenshot();
//        Reporting.pass2("Launch GoIbibo Website");
    }

    public void waittime()
    {

    }

    public void extentReport(String name) throws InterruptedException {

//        String testMethodname=method.getName();
        ExtentReports report;
        ExtentTest test;
        report=ExtentReporter.Setup();
        test=report.createTest(name);
        String sc= Screenshots.captureScreenshot();
        Thread.sleep(5000);
        test.pass(name, MediaEntityBuilder.createScreenCaptureFromPath(sc).build());
//        report.flush();
    }
    public void extentReportflush()
    {
        ExtentReports report;
        report=ExtentReporter.Setup();
        report.flush();
    }

    public void setInputvalue(WebElement element, String input)
    {
        element.click();
        element.clear();
        element.sendKeys(input);

    }

    public static void datepicker(WebDriver driver, WebElement element, String dateVal)
    {
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].setAttribute('value','"+dateVal+"');",element);
    }
 }
