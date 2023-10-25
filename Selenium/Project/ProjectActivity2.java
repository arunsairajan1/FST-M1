package ProjectActivities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProjectActivity2 {
    WebDriver driver;
    @BeforeClass
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/jobs/");
    }

    @Test
       public void heading_Webpage(){
        String heading = driver.findElement(By.xpath("//h1[text()='Welcome to Alchemy Jobs']")).getText();
        System.out.println("heading of webpage:"  + heading);
        Assert.assertEquals( heading,"Welcome to Alchemy Jobs");
        driver.quit();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}