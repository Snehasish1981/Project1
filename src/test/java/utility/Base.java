package utility;

//import ExtentReport.Reporting;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import ExtentReport.ExtentReporter;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    static String excelPath="C:\\Users\\Snehashis\\IdeaProjects\\edurekaProject\\src\\test\\resources\\Login details.xlsx";
    public static List<String> read_excelfile() throws FileNotFoundException {

        FileInputStream exl = new FileInputStream(excelPath);
        XSSFWorkbook srcBook = null;
        try {
            srcBook = new XSSFWorkbook(exl);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        XSSFSheet sh=srcBook.getSheetAt(0);
        XSSFRow r1= sh.getRow(0);
        XSSFRow r2= sh.getRow(1);
        XSSFCell c1= r1.getCell(0);
        XSSFCell userid1= r2.getCell(0);
        XSSFCell password1= r2.getCell(1);
        System.out.println(userid1.toString());
        System.out.println(password1.toString());
        List<String> cre=new ArrayList<>();
        cre.add(userid1.toString());
        cre.add(password1.toString());
        return cre;
    }
    public void launchURL()
    {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Snehashis\\IdeaProjects\\edurekaProject\\src\\test\\resources\\chromedriver\\chromedriver.exe");
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
