package ProjectActivities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProjectActivity3 {
    WebDriver driver;
    @BeforeClass
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/jobs/");
    }

     @Test
     public void url_header(){
        WebElement headerImage  = driver.findElement(By.xpath("//img[@class='attachment-large size-large wp-post-image']"));
        String imageUrl = headerImage.getAttribute("src");
        System.out.println("header image url: " +imageUrl);

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}