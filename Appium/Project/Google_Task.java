package Project;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Google_Task {
    AndroidDriver driver;
    WebDriverWait wait;
    // Set up method
    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.apps.tasks");
        options.setAppActivity(".ui.TaskListsActivity");
        options.noReset();

        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Test method
    @Test
    public void note_creation_Test() {
        // Perform the calculation
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.id("com.google.android.apps.tasks:id/tasks_fab")
        ));
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/tasks_fab")).click();
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")
        ));
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys("Complete Activity with Google Tasks");
        driver.findElement(AppiumBy.id( "com.google.android.apps.tasks:id/add_task_done")).click();
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.id("com.google.android.apps.tasks:id/tasks_fab")
        ));
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/tasks_fab")).click();
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")
        ));
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys("Complete Activity with Google Keep");
        driver.findElement(AppiumBy.id( "com.google.android.apps.tasks:id/add_task_done")).click();
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.id("com.google.android.apps.tasks:id/tasks_fab")
        ));
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/tasks_fab")).click();
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")
        ));
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys("Complete the second Activity Google Keep");
        driver.findElement(AppiumBy.id( "com.google.android.apps.tasks:id/add_task_done")).click();

        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.FrameLayout[1]")
        ));

        List<WebElement> imageElements = driver.findElements(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.FrameLayout"));
        // Find the result

        int a= imageElements.size();
        System.out.println(a);

        // Assertion
        Assert.assertEquals(a, "3");
    }


    // Tear down method
    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }
}
