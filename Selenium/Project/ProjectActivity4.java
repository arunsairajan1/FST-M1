package ProjectActivities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProjectActivity4 {
    WebDriver driver;
    @BeforeClass
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/jobs/");
    }
    @Test
      public void second_Heading(){

        String secondHeading =driver.findElement(By.xpath("//h2[text()='Quia quis non']")).getText();
        System.out.println("Second heading of webpage:"  + secondHeading );
        Assert.assertEquals( secondHeading,"Quia quis non");


    }
     @AfterClass
     public void tearDown() {
         driver.quit();
     }
}