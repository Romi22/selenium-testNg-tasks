package com.fico.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.*;

public class ProductSearchTest
{
    WebDriver driver=null;

    @BeforeClass
    public void beforeClass() {
        String driverPath="C:\\Users\\romiakhtarkhan\\Downloads\\chromedriver_win32\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
    }

    @Test(dataProvider = "product")
    public void testProductSearch(String prod)
    {
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.flipkart.com");
        System.out.println(driver.getCurrentUrl());
        driver.manage().window().maximize();
        driver.findElement(xpath("/html/body/div[2]/div/div/button")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(xpath("//*[@id=\"container\"]/div/div[2]/div/ul/li[1]/span"));
        action.moveToElement(we).build().perform();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(xpath("//*[@id=\"container\"]/div/div[2]/div/ul/li[1]/ul/li/ul/li[1]/ul/li[7]/a")).click();
        driver.findElement(xpath("//*[@id=\"container\"]/div/div[3]/div[3]/div[2]/div/div[1]/a")).click();
        WebElement textDemo = driver.findElement(By.xpath(prod));
       // WebElement textDemo = driver.findElement(new ByLinkText("Apple iPhone 8 Plus (PRODUCT)RED (Red, 64 GB)"));
        if(textDemo.isDisplayed())
            System.out.println("Product found on the flipkart");
        else
            System.out.println("Product not found");
    }

    @DataProvider(name="product")
    public static Object[][] numbersData()
    {
        return new Object[][] {{"//*[text()='Apple iPhone 8 Plus (PRODUCT)RED (Red, 64 GB)']"}};
    }
}

