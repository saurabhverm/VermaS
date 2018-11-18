package com.wallethub;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SeleniumAssignment2 {
	
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
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public void afterClass() {
        //driver.quit();
    }
	
  @Test
  public void writeReview() {
	  try {
	
  	String username = "saurabhrocks.verma@gmail.com";
  	String password = "TVsv@123";
  	driver.get("https://wallethub.com/profile/test_insurance_company/");
  	driver.findElement(By.xpath("//a[@class='login']")).click();
  	driver.findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys(username);
  	driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
  	driver.findElement(By.xpath("//div[@class='btns']//button[2]")).click();
  	
  	Actions actions = new Actions(driver);
  	WebElement ratingStar = driver.findElement(By.xpath("//span[@class='wh-rating rating_4_5']"));
  	actions.moveToElement(ratingStar);

  	WebElement starselection = driver.findElement(By.xpath("//div[@class='wh-rating-choices-holder']/a[5]"));
  	actions.moveToElement(starselection);
  	actions.click().build().perform();
  	
  	driver.findElement(By.xpath("//form/div[1]/div[1]//span[2]/i")).click();
  	
  	driver.findElement(By.xpath("//form/div[1]/div/ul/li[2]/a")).click();
  	
  	driver.findElement(By.cssSelector("#review-content")).sendKeys("Writing this review as an assignment of selenium for the job opportunity of test automation engineer.dgcvgdsvcsgdcvdsgcvsdgcvsdgcvsdgcvdsgcvsdgcvgsdcvsdgcvsdgcvsdgcvsdgcvsdgcvgsdcvsdgcvsgdcvsdgcvsdgcvsdgcvsdgcvssjnsjndjsbhsabcsd  hbc sdshj bhbdc dsn bhhb sdvkh bjcbbcsdn vsdjcgdshjb.");
  	
  	driver.findElement(By.xpath("//span[@id='overallRating']//a[5]")).click();
  	Thread.sleep(5000);
  	driver.findElement(By.xpath("//input[@value='Submit']")).click();
  	Thread.sleep(5000);
  	actions.moveToElement(driver.findElement(By.xpath("//header/div/nav[3]/div[1]/a[9]")));
  	actions.click().build().perform();
  	driver.findElement(By.xpath("//div[1]/nav[7]/ul/li[1]/a")).click();
  	
  	String text = driver.findElement(By.xpath("//div/div[3]/div[1]/div[2]/p[1]")).getText();
  	System.out.println(text);
	
	}
	catch(Exception e)
  	{
  		System.out.println(e.getMessage());
  	} 
  
	  
	  
  }
}
