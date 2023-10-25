package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Activity1 {
    WebDriver driver;
    SoftAssert softAssert;

    @BeforeClass
    public void setUp(){
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        softAssert = new SoftAssert();
        driver.get("https://www.training-support.net");
        }
    @Test
    public void homepageTest(){
        String heading1 = driver.findElement(By.tagName("h1")).getText();
        //Assertion
        //softAssert.assertEquals();
        //softAssert.assertTrue();
        //softAssert.assertAll();
        Assert.assertEquals(heading1, "Training Support");

        String heading2 = driver.findElement(By.tagName("h2")).getText();
        Assert.assertEquals(heading2, "/* We're Under Construction */");

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
