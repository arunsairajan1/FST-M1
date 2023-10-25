package ProjectActivities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class ProjectActivity5 {
    WebDriver driver;
    @BeforeClass
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/jobs/");
    }
    @Test
    public void testJobNavigation(){

        // Find the navigation bar element
        WebElement navigationBar = driver.findElement(By.id("menu-item-24"));

        // Find the "Jobs" menu item and click it
        WebElement jobsMenuItem = navigationBar.findElement(By.linkText("Jobs"));
        jobsMenuItem.click();

        // Read the page title
        String pageTitle = driver.getTitle();

        // Verify the correct page using the page title
        String expectedTitle = "Jobs – Alchemy Jobs";
        Assert.assertEquals(pageTitle, expectedTitle, "Incorrect page title");

        // Print success message if the verification is successful
        System.out.println("You are on the correct page.");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}