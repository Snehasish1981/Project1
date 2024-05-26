package Windowhandler;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import utility.readConfigproperties;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class WindowHandler {
    public static ChromeDriver driver;
    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Snehashis\\IdeaProjects\\edurekaProject\\src\\test\\resources\\chromedriver\\chromedriver.exe");
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html#google_vignette");
        String parent=driver.getWindowHandle();
        System.out.println(parent);
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,200)");
        driver.findElement(By.xpath("//button[@id='newWindowBtn']")).click();
        Set<String> allwindows=driver.getWindowHandles();
        for(String child:allwindows)
        {

            if(!parent.equalsIgnoreCase(child))
            {
                driver.switchTo().window(child);
                System.out.println(child);
                driver.findElement(By.xpath("//Select[@id='selectnav2']")).click();

            }
        }

    }
}
