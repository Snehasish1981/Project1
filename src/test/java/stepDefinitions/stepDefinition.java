package stepDefinitions;

import ExtentReport.ExtentReporter;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import operationPage.operationPage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import utility.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefinition extends Base {
    @Given("User launch Goibibo website page")
    public void user_launch_goibibo_website_page() {
        try {
            operationPage page = new operationPage();
            page.launch_Goibibo_page();
            System.out.println("Application launch successfully");
        }catch (Exception e) {
            System.out.println("Page no found" +e);
        }
    }
    @When("User clicks on hotel menu")
    public void user_clicks_on_hotel_menu() {
        try{
            operationPage page=new operationPage();
            page.hotel_menu();
            System.out.println("Hotel option selected successfully");
        }catch(Exception e){
            System.out.println("Menu not found");
        }

    }
    @When("^enters location (.*) & check in (.*) & check out (.*) details")
    public void enters_location_check_in_check_out_details(String location,String fromdate,String todate) {
        try {
            operationPage page = new operationPage();
            page.location_date(location,fromdate,todate);
            System.out.println("Location and date selected successfully");
        }catch (Exception e){
            System.out.println("Location or date not found");
        }
    }
    @When("selects one adult {string} under Rooms {string} option")
    public void selects_one_adult_under_rooms_option(String guest,String room) {
        try {
            operationPage page = new operationPage();
            page.guest_room_option(guest,room);
            System.out.println("Head numbers entered successfully");
        }catch (Exception e){
            System.out.println("Rooms option is not updated"+e);
        }
    }
    @When("clicks on Search button")
    public void search()
    {
        try {
            operationPage page = new operationPage();
            page.search();
            System.out.println("Search done");
        }catch (Exception e){
            System.out.println("Search button is not enabled"+e);
        }
    }
    @When("Hotel list appears")
    public void hotel_list()
    {
        try {
            operationPage page = new operationPage();
            page.hotel_list();
            System.out.println("Hotel List showing");
        }catch (Exception e){
            System.out.println("Hotel List not showing"+e);
        }
    }
    @Then("list down the hotel names")
    public void hotel_names()
    {
        try {
            operationPage page = new operationPage();
            page.hotel_name();
            System.out.println("Hotel Names showing");
        }catch (Exception e){
            System.out.println("Hotel Names not showing");
        }
    }
    @Then("select hotel {string} from the list")
    public void select_hotel(String hotel_name)
    {
        try {
            operationPage page = new operationPage();
            page.select_hotel(hotel_name);
            System.out.println("Hotel selected");
        }catch (Exception e){
            System.out.println("Hotel is not showing");
        }
    }

    @When("clicks on Get Set Go button")
    public void clicks_on_get_set_go_button() {

    }
    @Then("Hotels details are displayed")
    public void hotels_details_are_displayed() {

    }
    @AfterClass
    @Then("close browser")
    public void tearDown()
{
    try {
        operationPage page = new operationPage();
        page.endTest();
        System.out.println("End test");
    }catch (Exception e){
        System.out.println("Error!");
    }
}
//@AfterStep
//public void addScreenshot(Scenario scenario)
//{
//     final byte[] screenshot=((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//     scenario.attach(screenshot,"image/png",scenario.getName());
//
//}


}
