package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "src/test/java/features", glue = "stepDefinitions"
        ,monochrome = true, dryRun = false,
        tags= "@FB_Login",
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class testRunnerfile extends AbstractTestNGCucumberTests {

}