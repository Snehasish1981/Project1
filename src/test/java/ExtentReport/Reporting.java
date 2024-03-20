//package ExtentReport;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.MediaEntityBuilder;
//import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.markuputils.ExtentColor;
//import com.aventstack.extentreports.markuputils.MarkupHelper;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.reporter.configuration.Theme;
//import org.openqa.selenium.WebDriver;
//import org.openxmlformats.schemas.drawingml.x2006.diagram.CTSampleData;
//import org.testng.ITestContext;
//import org.testng.ITestResult;
//import org.testng.Reporter;
//import org.testng.TestListenerAdapter;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterSuite;
//import org.testng.annotations.BeforeSuite;
//
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//
//import static utility.Screesnhots.captureScreenshot;
//
//public class Reporting extends TestListenerAdapter {
//
//    public static ExtentSparkReporter spark=null;
//    public static ExtentReports extent=null;
//    public static ExtentTest test=null;
//
//    public static ExtentReports setup()
//    {
//
//        String timestamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());  //time stamp
//        String rpt_name="Test report"+timestamp+".html";
//        spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-result/Reports/"+rpt_name);
//        spark.config().setDocumentTitle("GoIbibo Automation Report");
//        spark.config().setReportName("GoIbibo Automation report");
//        spark.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
//        spark.config().setTheme(Theme.DARK);
//
//        extent = new ExtentReports();
//        extent.attachReporter(spark);
//        return extent;
//    }
//
//    public static void testStepHandle(String teststatus, WebDriver driver,ExtentTest extentTest,Throwable throwable)
//    {
//        switch (teststatus)
//        {
//            case "FAIL":
//                extentTest.fail(MarkupHelper.createLabel("Test failed",ExtentColor.RED));
//                extentTest.fail(throwable);
//
//                break;
//            case "PASS":
//                extentTest.fail(MarkupHelper.createLabel("Test passed",ExtentColor.GREEN));
//                break;
//
//            default:
//                break;
//        }
//    }
//    public void onTestSuccess(ITestResult tr)
//    {
//        test=extent.createTest(tr.getName());
//        test.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN));
//
//        List<String> reporterMessages = Reporter.getOutput(tr);
//        for (int i = 0; i < reporterMessages.size(); i++)
//        {
//            System.out.println(reporterMessages.get(i));
//            test.info(reporterMessages.get(i));
//        }
//
//    }
//@AfterMethod
//    public static void getResult(ITestResult result)
//    {
//        String pathsc=captureScreenshot();
//        if(result.getStatus()==ITestResult.SUCCESS)
//        {
//            test.pass(MarkupHelper.createLabel(result.getName()+"Test case passed", ExtentColor.GREEN));
//        }
//        else if(result.getStatus()==ITestResult.FAILURE)
//        {
//            test.fail(MarkupHelper.createLabel(result.getName()+"Test case failed", ExtentColor.RED));
//            test.fail(result.getThrowable());
//        }
//        else if(result.getStatus()==ITestResult.SKIP)
//        {
//            test.skip(MarkupHelper.createLabel(result.getName()+"Test case skipped", ExtentColor.YELLOW));
//            test.skip(result.getThrowable());
//        }
//
//
//
//
////        extentreport.
////                createTest("GoIbibo","Login into GoIbibo website")
////                .log(Status.PASS,info, MediaEntityBuilder.createScreenCaptureFromPath(pathsc).build());
////                .addScreenCaptureFromPath(path,info);
//
//    }
//    @AfterSuite
//    public static void tearDown()
//    {
//
//        ExtentReports extentreport = new ExtentReports();
//        extentreport.flush();
//    }
//    public static void pass2(String info)
//    {
//        ExtentReports extentreport = new ExtentReports();
//
//        String timestamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());  //time stamp
//        String rpt_name="Test report"+timestamp+".html";
//        spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-result/Reports/"+rpt_name);
//        spark.config().setDocumentTitle("GoIbibo Automation Report");
//        spark.config().setReportName("GoIbibo Automation report");
//        spark.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
//        spark.config().setTheme(Theme.DARK);
//
//        extent = new ExtentReports();
//        extent.attachReporter(spark);
////        File file=new File("reporter.html");
//
//        extentreport.attachReporter(spark);
//
//        spark.config().setDocumentTitle("GoIbibo Automation Report");
//        spark.config().setReportName("GoIbibo Automation report");
//        spark.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
//        String pathsc=captureScreenshot();
//
//        extentreport.
//                createTest("GoIbibo",info)
//                .log(Status.PASS,info, MediaEntityBuilder.createScreenCaptureFromPath(pathsc).build());
////                .addScreenCaptureFromPath(path,info);
////        extentreport.flush();
//    }
//}
