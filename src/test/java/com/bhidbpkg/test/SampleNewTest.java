package com.bhidbpkg.test;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bhiawpkg.Config.Config;
import com.bhiawpkg.Pages.LoginPage;
import com.bhiawpkg.TestBase.TestBase;

public class SampleNewTest {
	
	WebDriver driver;
	@BeforeMethod
	public void Launchbrowser() 
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "\\Drivers\\chromedriver.exe");
	    driver=new ChromeDriver();
	    driver.get("https://icmdemo.dev.altd.in/signin");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    
	}
	
  @Test
  public void Test1() throws InterruptedException {
	  
	  driver.findElement(By.id("email")).sendKeys("admin@icmdemo.com");
	  driver.findElement(By.id("password")).sendKeys("icmdemo123!@#");
	  driver.findElement(By.xpath("//*[@type='submit']")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//span[contains(text(),'Admin Settings')]")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//span[contains(text(),'Geographical Level')]")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//body/div[@id='root']/section[1]/aside[1]/div[1]/div[2]/div[2]/div[1]/ul[1]/li[1]/ul[1]/li[1]/ul[1]/li[2]/a[1]")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//body/div[@id='root']/section[1]/section[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[2]/a[1]")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//input[@id='front_line']")).sendKeys("Test1");;
	  driver.findElement(By.xpath("//*[@class='ant-select-selection__rendered']//div[contains(text(),'Please select an Area')]")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//li[contains(text(),'america')]")).click();
	  Thread.sleep(2000);
	driver.findElement(By.xpath("///*[@id='currency']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//li[contains(text(),'Omani Rial')]")).click();
	  
	 // driver.findElement(By.xpath("//body/div[3]/div[1]/div[1]/div[1]/ul//li[text()='america']")).click();
	  
	  /*WebElement elem1=driver.findElement(By.xpath("//*[@class='ant-select-selection__rendered']//div[contains(text(),'Please select an Area')]"));
	  Select s1=new Select(elem1);
	  s1.selectByVisibleText("Test");
	  
	 // driver.findElement(By.xpath("//*[@class='ant-select-dropdown ant-select-dropdown--single ant-select-dropdown-placement-bottomLeft  ant-select-dropdown-hidden']//div//ul//li[text()='Test']")).click();
	  Thread.sleep(2000);
	List<WebElement>areas=driver.findElements(By.xpath("//body/div[3]/div[1]/div[1]/div[1]/ul//li[@unselectable='on']"));
	JavascriptExecutor js = (JavascriptExecutor) driver;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("document.getElementsByTagName('option')[0].");
    js.executeScript(stringBuilder.toString());
	/*for(WebElement we:areas)
	{
		if(we.getText().equals("Test"))
		{  

	        we.click();
	        Thread.sleep(2000);
		}
	}*/
  }
  
}








