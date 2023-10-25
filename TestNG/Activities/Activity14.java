package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Activity14 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        // System.out.println("webdriver.gecko.driver", "C:/Users/Lulu/.wdm/drivers/geckodriver/win64/0.32/geckodriver.exe");
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");
        WebDriver driver = new FirefoxDriver(); //open browser

        driver.get("https://training-support.net/selenium/tables");
        System.out.println("Title of the page is " + driver.getTitle());

        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='sortableTable']/tbody/tr"));
        List<WebElement> cols = driver.findElements(By.xpath("//table[@id='sortableTable']/thead/tr/th"));
        System.out.println("Number of rows:" + rows.size());
        System.out.println("Number of columns:" + cols.size());

        WebElement row2col2 = driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/th[2]"));
        System.out.println(row2col2.getText());

        driver.findElement(By.xpath("//table[@id='sortableTable']/tr/th")).click();

        row2col2 = driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]"));
        System.out.println(row2col2.getText());

        driver.quit();
    }

}
