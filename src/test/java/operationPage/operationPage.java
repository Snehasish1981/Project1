package operationPage;

import java.time.Duration;
import java.util.*;

//import ExtentReport.Reporting;
import ExtentReport.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utility.Base;
import utility.Screenshots;

public class operationPage extends Base {

    ExtentReports report= ExtentReporter.Setup();;
    ExtentTest test;
    ExtentTest test1;

@Test
    public void launch_Goibibo_page() throws InterruptedException, NoSuchMethodException {
    launchURL();

    String name = new Object(){}.getClass().getEnclosingMethod().getName();
    System.out.println("Method name:"+name);

        WebElement titlepopup=driver.findElement(By.xpath("//h3[text()='Login/Signup']"));
        WebElement closepopup=driver.findElement(By.xpath("//span[contains(@class,'sc-gsFSXq')]"));
        System.out.println("Title: "+titlepopup.getText());
        closepopup.click();

        String sc= Screenshots.captureScreenshot();
        Thread.sleep(2000);
        test=report.createTest("launch_Goibibo_page");
        test.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromPath(sc).build());
        test.assignCategory("P0");
//        endReport();
        test.pass(name, MediaEntityBuilder.createScreenCaptureFromPath(sc).build());
//        report.flush();
}
    @Test
        public void hotel_menu() throws InterruptedException {
        String name = new Object(){}.getClass().getEnclosingMethod().getName();
        List<WebElement> itemlist=driver.findElements(By.xpath("//ul[contains(@class,'sc-1f')]/li"));
        itemlist.size();
        for(WebElement itemlistmenu : itemlist)
            if(itemlistmenu.getText().equals("Hotels"))
            {
                System.out.println(itemlistmenu.getText());
                itemlistmenu.click();
                break;
            }
//        report= ExtentReporter.ExtentReportGenerator();
        test1=report.createTest("Hotel Menu");
        String sc= Screenshots.captureScreenshot();
        Thread.sleep(2000);
        test1.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromPath(sc).build());
//        test1.pass(name, MediaEntityBuilder.createScreenCaptureFromPath(sc).build());
//        test1.assignCategory("P1");
//        endReport();
    }
    @Test
    public void location_date(String place_location, String fromdate, String todate) {
        String fromdatekeyword = fromdate; //user input from date in Examples table
        String todatekeyword = todate; //user input to date in Example table
        String fromdatekeyword_date[] = fromdatekeyword.split("-");
        String fromdatekeyword_day = fromdatekeyword_date[0]; //user input from day
        String fromdatekeyword_month = fromdatekeyword_date[1]; //user input from month
        String fromdatekeyword_year = fromdatekeyword_date[2]; //user input from year
        String todatekeyword_date[] = todatekeyword.split("-");
        String todatekeyword_day = todatekeyword_date[0]; //user input to day
        String todatekeyword_month = todatekeyword_date[1]; //user input to month
        String todatekeyword_year = todatekeyword_date[2]; //user input to year
        WebElement location = driver.findElement(By.xpath("//input[@data-testid='home-autosuggest-input']"));
        //Selection of location
        location.click();
        Actions act = new Actions(driver);
        act.sendKeys(location, place_location).perform();
        act.pause(2000).perform();
        act.sendKeys(location, Keys.ARROW_DOWN).perform();
        act.sendKeys(Keys.ENTER).perform();

        WebElement fromdatecal=driver.findElement(By.xpath("//div[@data-testid='openCheckinCalendar']/h4"));
        fromdatecal.click();

        String appcalendar_monthyear_left = driver.findElement(By.xpath("//div[@data-testid='CalendarBlockOuterWrapper']/section/div/div/div/span[2]")).getText();
        String appcalendar_monthyear_left_split[] = appcalendar_monthyear_left.split(" ");
        String appcalendar_month_left = appcalendar_monthyear_left_split[0]; //application month left table
        String appcalendar_monthyear_right = driver.findElement(By.xpath("//div[@data-testid='CalendarBlockOuterWrapper']/section/div/div[2]/div/span")).getText();
        String appcalendar_monthyear_right_split[] = appcalendar_monthyear_right.split(" ");
        String appcalendar_month_right = appcalendar_monthyear_right_split[0]; //application month right table

        if(fromdatekeyword_month.equals(appcalendar_month_left)) {

            driver.findElement(By.xpath("//div[contains(@class, 'dcalendar-newstyles__DayAndDateLeftWrapper')]//ul[contains(@class, 'dcalendar-newstyles__DateWrapDiv')]//*[text()='" + fromdatekeyword_day + "']")).click();
        }
        else if(fromdatekeyword_month.equals(appcalendar_month_right))
        {
            driver.findElement(By.xpath("//div[contains(@class, 'dcalendar-newstyles__DayAndDateRightWrapper')]//ul[contains(@class, 'dcalendar-newstyles__DateWrapDiv')]//*[text()='"+fromdatekeyword_day+"']")).click();
        }
        else System.out.println("No such date present");

        if(todatekeyword_month.equals(appcalendar_month_left))
        {
            driver.findElement(By.xpath("//div[contains(@class, 'dcalendar-newstyles__DayAndDateLeftWrapper')]//ul[contains(@class, 'dcalendar-newstyles__DateWrapDiv')]//*[text()='" + todatekeyword_day + "']")).click();
        }
        else if(todatekeyword_month.equals(appcalendar_month_right))
        {
            driver.findElement(By.xpath("//div[contains(@class, 'dcalendar-newstyles__DayAndDateRightWrapper')]//ul[contains(@class, 'dcalendar-newstyles__DateWrapDiv')]//*[text()='"+todatekeyword_day+"']")).click();
        }
        else System.out.println("No such date present");
//        driver.findElement(By.xpath("//input[@aria-activedecendant='downshit-1-item-0']")).click();
//        WebElement fromdatecal = driver.findElement(By.xpath("//div[@data-testid='openCheckinCalendar']/h4"));
//        datepicker(driver,fromdatecal,fromdate);
//        datepicker(driver,fromdatecal,todate);
        }

    @Test
    public void guest_room_option(String guest,String room) {
        WebElement guests = driver.findElement(By.xpath("//input[contains(@class,'SearchBlockUIstyles__CitySearchInput')]"));
        guests.click();
        WebElement adultsno = driver.findElement(By.xpath("//h4[@data-testid='adult-count']"));
        int adultsno_int = Integer.parseInt(adultsno.getText());
        WebElement adultsno_dec = driver.findElement(By.xpath("//span[@data-testid='button-adult-dec']"));
        WebElement adultsno_inc = driver.findElement(By.xpath("//span[@data-testid='button-adult-add']"));
        WebElement adultsno_button = driver.findElement(By.xpath("//button[@data-testid='searchHotelBtn']"));
        int guest_int=Integer.parseInt(guest);
        int room_int=Integer.parseInt(room);

            do {

                if (adultsno_int > guest_int) {
                    adultsno_dec.click();
                }
                else if (adultsno_int < guest_int) {
                adultsno_inc.click();
            }

        }while (adultsno_int == guest_int);
            driver.findElement(By.xpath("//button[text()='Done']")).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
    }

    @Test
    public void search()
    {
        WebElement search_button=driver.findElement(By.xpath("//button[text()='Search']"));
        search_button.click();
    }

    @Test
    public void hotel_list()
    {
        String label_hotel_menu=driver.findElement(By.xpath("//p[contains(@class,'PopularLocationsWidgetstyles')]")).getText();
        if(label_hotel_menu.contains("Kolkata"))
        {
            System.out.println("Hotels list in Kolkata is displayed");
//            ExtentReporter.pass2("Hotels list in Kolkata is displayed");
        }
    }
    List<WebElement> hotel_name;
    @Test
    public void hotel_name()
    {
        int hotels_count=0;
        hotel_name=driver.findElements(By.xpath("//div[@class='infinite-scroll-component ']/div/div/div/div[2]/div/div/div[2]/h4"));
        System.out.println("Hotel names:");
        for(WebElement hotelname:hotel_name)
        {
            hotels_count=hotels_count+1;
            System.out.println(hotelname.getText());
        }
//        Reporting.tearDown();
        System.out.println("Number of Hotels :"+hotels_count);
    }

    public void select_hotel(String hotel_name_input)
    {
        for(WebElement hn:hotel_name)
        {
            if(hn.getText().contains(hotel_name_input))
            {
                hn.click();
            }
        }
    }
         public void endTest()
    {
        driver.quit();
    }
    @AfterTest
    public void endReport()
    {
        report.flush();
    }

}
