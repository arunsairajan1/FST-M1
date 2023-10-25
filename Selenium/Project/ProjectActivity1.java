package ProjectActivities;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class ProjectActivity1 {
    //Declare global object
    WebDriver driver;
    @BeforeClass
      public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/jobs/");
    }
    @Test
    public void validate_title(){
        String title = driver.getTitle();
        System.out.println("Page title is: " + title);
        Assert.assertEquals("Alchemy Jobs – Job Board Application", title);
    }
        @AfterClass
      public void tearDown(){
           driver.quit();
        }
}