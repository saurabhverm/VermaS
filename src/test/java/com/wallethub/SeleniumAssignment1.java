package com.wallethub;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SeleniumAssignment1 {
	
	private WebDriver driver;

    @BeforeClass
    public void beforeClass() {
    	//Initiate driver
    	String path = System.getProperty("user.dir");   // return project folder path

    	String driverpath = path + "/Resource/chromedriver";
    	System.setProperty("webdriver.chrome.driver",driverpath);
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
    @Test
    public void facebookMessage() throws InterruptedException {
    	try {
    		
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	String username = "saurabhdevil27";
    	String password = "9739569896";
    	driver.get("http://facebook.com");
    	driver.findElement(By.cssSelector("#email")).sendKeys(username);
    	driver.findElement(By.cssSelector("#pass")).sendKeys(password);
    	driver.findElement(By.cssSelector("#pass")).sendKeys(Keys.ENTER);
    	Thread.sleep(5000);
    	String parentHandle = driver.getWindowHandle();
    	driver.findElement(By.xpath("//div[@class='_3ubp _sg2']/span[1]")).click();
    	
    	Actions actions = new Actions(driver);
    	actions.moveToElement(driver.findElement(By.xpath("//div[@class='_1mf _1mj']")));
    	actions.click();
    	actions.sendKeys("Hello World!");
    	actions.build().perform();
    	
    	//driver.findElement(By.xpath("//div[@class='_1mf _1mj']")).sendKeys("Hello World!");

    	driver.findElement(By.xpath("//ol[@class='_26bz']//li[1]/div[1]/ol[1]/li[1]/div[1]/div[1]/div")).click();
    	
    	
    	
    	driver.findElement(By.xpath("//div[@class='_6c0o']//button[@value='1']")).click();
    	driver.switchTo().window(parentHandle);
    	Thread.sleep(5000);
    	}
    	catch(Exception e)
    	{
    		System.out.println(e.getMessage());
    	}
    }
}
