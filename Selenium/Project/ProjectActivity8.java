package ProjectActivities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProjectActivity8 {
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
    public void testLogin() {
        // Navigate to the login page
        driver.get("https://alchemy.hguy.co/jobs/wp-admin");

        // Find the username field and enter the username
        WebElement usernameField = driver.findElement(By.id("user_login"));
        usernameField.sendKeys("root");

        // Find the password field and enter the password
        WebElement passwordField = driver.findElement(By.id("user_pass"));
        passwordField.sendKeys("pa$$w0rd");

        // Find the login button and click it
        WebElement loginButton = driver.findElement(By.id("wp-submit"));
        loginButton.click();

        // Verify successful login
        WebElement dashboard = driver.findElement(By.cssSelector(".wrap > h1"));
        String actualText = dashboard.getText();
        System.out.println(actualText);
        String expectedText = "Dashboard";
        Assert.assertEquals(actualText, expectedText, "Login failed");

      // Print success message if the verification is successful
       System.out.println("Logged in successfully.");
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}

