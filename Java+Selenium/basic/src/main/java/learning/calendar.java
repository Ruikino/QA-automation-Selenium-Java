package learning;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class calendar {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Development\\Drivers\\geckodriver-v0.33.0-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        driver.findElement(By.cssSelector("input[id='ctl00_mainContent_view_date1']")).click();
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();

        //System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());
         try {
            Thread.sleep(Duration.ofSeconds(4)); // Wait for 10 seconds before closing the browser (example)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
        //System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());
    
        if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))
        {
            System.out.println("its enabled");
            Assert.assertTrue(true);
        }
        else
        {
            System.out.println("its disabled");
            Assert.assertTrue(false);
        }
    }
}
