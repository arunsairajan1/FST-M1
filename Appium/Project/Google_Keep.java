package Project;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Google_Keep {
    AndroidDriver driver;

    // Set up method
    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.keep");
        options.setAppActivity(".activities.BrowseActivity");
        options.noReset();

        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
    }

    // Test method
    @Test
    public void note_creation_Test() {
        // Perform the calculation
        driver.findElement(AppiumBy.id("com.google.android.keep:id/new_note_button")).click();
        driver.findElement(AppiumBy.id("com.google.android.keep:id/editable_title")).sendKeys("Task2");
        driver.findElement(AppiumBy.id("com.google.android.keep:id/edit_note_text")).sendKeys("Task2desc");
        driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();

        // Find the result
        String result = driver.findElement(AppiumBy.id("com.google.android.keep:id/index_note_title")).getText();
        System.out.println(result);
        // Assertion
        Assert.assertEquals(result, "Task2");
    }


    // Tear down method
    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }
}
