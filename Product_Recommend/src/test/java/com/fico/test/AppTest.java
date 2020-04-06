package com.fico.test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
public class AppTest {
    WebDriver driver;
    @BeforeClass
    public void beforeClass(){
        try {
            String driverPath = "C:\\Users\\romiakhtarkhan\\Downloads\\chromedriver_win32\\chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", driverPath);
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testcase1() {
        driver.get("https://www.flipkart.com/");
        driver.findElement(By.xpath("//input[@class='_2zrpKA _1dBPDZ']")).sendKeys("romiakhtar95@gmail.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Romi@0021");
        driver.findElement(By.xpath("//button[@class='_2AkmmA _1LctnI _7UHT_c']//span[contains(text(),'Login')]")).click();
        try { Thread.sleep(2000); }
        catch (Exception e) {}
        Actions actions = new Actions(driver);
        WebElement more =driver.findElement(By.xpath("//div[text()='More']"));  //more option
        actions.moveToElement(more).perform();
        driver.findElement(By.xpath("//div[contains(text(),'Notification Preferences')]")).click();
        try { Thread.sleep(3000); }
        catch (Exception e) {}
        driver.findElement(By.xpath("//li[contains(text(),'Email')]")).click();
        try { Thread.sleep(3000); }
        catch (Exception e) {}
        driver.findElement(By.xpath("//div[contains(text(),'Recommendations by Flipkart')]")).click();
        try { Thread.sleep(3000); }
        catch (Exception e) {}
        driver.findElement(By.xpath("//p[contains(text(),'Offers based on your interests')]")).click();
        try { Thread.sleep(3000); }
        catch (Exception e) {}
        driver.findElement(By.xpath("//p[contains(text(),'Offers to complement your purchases')]")).click();

            System.out.println("Product recommendations changed successfully");

    }
}