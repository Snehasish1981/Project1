package ExtentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReporter{
    public static ExtentReports extent=null;
    public static ExtentSparkReporter spark=null;
    public static ExtentTest test=null;
    public static ExtentReports Setup(){
        String timestamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());  //time stamp
        String rpt_name="Test report-"+timestamp+".html";
        spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-result/Reports/report.html");
        spark.config().setDocumentTitle("GoIbibo Automation Report");
        spark.config().setReportName("GoIbibo Automation report");
        spark.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
        spark.config().setTheme(Theme.DARK);
        extent = new ExtentReports();
        extent.attachReporter(spark);
        return extent;
    }
//    public static void TearDown()
//    {
//        extent.flush();
//    }
}
