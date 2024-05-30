package utility;


import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    @Before
    public void beforeScenario()
    {
        System.out.println("Before statement");
    }
    @After
    public void afterScenario()
    {
        System.out.println("After statement");
    }
}
