package ProjectActivities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class ProjectActivity7 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://alchemy.hguy.co/jobs/");
    }

    @Test
    public void createJobTest() throws InterruptedException {
        driver.findElement(By.id("menu-item-26")).click();
        driver.findElement(By.id("create_account_email")).sendKeys("testjob58@gmail.com");
        driver.findElement(By.id("job_title")).sendKeys("System Engineer");
        driver.findElement(By.id("job_location")).sendKeys("Bangalore");
        driver.findElement(By.id("job_description_ifr")).sendKeys(" Test Job creation");
        driver.findElement(By.id("application")).sendKeys("https://lms.training-support.net");
        driver.findElement(By.id("company_name")).sendKeys("ABS Pvt Ltd");
        driver.findElement(By.id("company_website")).sendKeys("https://alchemy.hguy.co");
        driver.findElement(By.id("company_tagline")).sendKeys("Problem One Solution");
        driver.findElement(By.id("company_video")).sendKeys("https://www.youtube.com/watch?v=QM2-MX1Lz-A");
        driver.findElement(By.id("company_twitter")).sendKeys("@Twitter");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@value='Preview']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@value='Submit Listing']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("menu-item-24")));
        driver.findElement(By.id("menu-item-24")).click();
        driver.findElement(By.id("search_keywords")).sendKeys("ABS Pvt Ltd");
        driver.findElement(By.xpath("//input[@value='Search Jobs']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.className("company_logo")));
        String jobName = driver.findElement(By.className("position")).getText();
        Assert.assertEquals(jobName, "System Engineer\nABS Pvt Ltd Problem One Solution");
    }


    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}