package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_2 {
	    public static void main(String[] args) {
	        WebDriver driver = new FirefoxDriver();
	        driver.get("https://www.training-support.net/selenium/simple-form");
	        String pageTitle = driver.getTitle();
	        System.out.println(pageTitle);
	        WebElement firstName = driver.findElement(By.xpath("//input[@id = 'firstName']"));
	        WebElement lastName = driver.findElement(By.xpath("//input[@id = 'lastName']"));
	        firstName.sendKeys("Hima");
	        lastName.sendKeys("Nag");
	        driver.findElement(By.xpath("//input[@id = 'email']")).sendKeys("hima@gmail.com");
	        driver.findElement(By.xpath("//input[@id = 'number']")).sendKeys("2109876543");
	        driver.findElement(By.xpath("//textarea")).sendKeys("Hello Hima ");
	        driver.findElement(By.xpath("//input[contains(@class, 'green')]")).click();
	        driver.close();
	    }
	}

