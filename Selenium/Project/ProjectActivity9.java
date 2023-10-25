package ProjectActivities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProjectActivity9 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void driverSetup() {
        // Installing Firefox driver
        WebDriverManager.firefoxdriver().setup();
        // Suppressing browser log
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");
        //Initializing the driver
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //Opening the browser
        driver.get("https://alchemy.hguy.co/jobs/wp-admin");
    }

    @Test
    public void addNewJobTest() throws InterruptedException {
        //Login to the account
        driver.findElement(By.id("user_login")).sendKeys("root");
        driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Thread.sleep(2000);

        //Navigate to Job Listings and add a job
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/ul/li[7]/a/div[3]")).click();
        driver.findElement(By.className("page-title-action")).click();
        driver.findElement(By.cssSelector(".components-modal__header > button:nth-child(2)")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("post-title-0")).sendKeys("Associate Engineer");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button.components-button:nth-child(3)")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[4]/div[1]/div/div/div[1]/div/div[2]/div[3]/div/div/div/div[1]/div/button")).click();
        Thread.sleep(2000);

        // Validate job is created
        String publishedMessage = driver.findElement(By.cssSelector(".post-publish-panel__postpublish-header")).getText();
        Assert.assertEquals(publishedMessage, "Associate Engineer is now live.");

        // Validate newly created job reflects in Jobs screen
        driver.get("https://alchemy.hguy.co/jobs/jobs/");
        driver.findElement(By.id("search_keywords")).sendKeys("Associate Engineer");
        driver.findElement(By.xpath("//input[@value='Search Jobs']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.className("company_logo")));
        String jobName = driver.findElement(By.className("position")).getText();
        Assert.assertEquals(jobName, "Associate Engineer");
        System.out.println("Associate Engineer Job is posted successfully");
    }

    @AfterClass
    public void closeBrowser() {
        //Closing the browser
        driver.quit();
    }
}
