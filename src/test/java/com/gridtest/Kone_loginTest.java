package com.gridtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Kone_loginTest {
	WebDriver driver;
	
	@BeforeTest
	public void Launchbrowser()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://icmdemo.dev.altd.in/signin");
	}
	
  @Test
  public void Login() throws InterruptedException {
	  driver.manage().window().maximize();
	  driver.findElement(By.id("email")).sendKeys("admin@icmdemo.com");
	  driver.findElement(By.id("password")).sendKeys("icmdemo123!@#");
	  driver.findElement(By.xpath("//*[@type='submit']")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//*[@class='gx-layout-sider-scrollbar']//div[1]//ul//li[1]//div[1]//i[@class='icon icon-setting']")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//*[@class='gx-layout-sider-scrollbar']//div[1]//ul[@id='adminsettings$Menu']//li[1]//div//span[contains(text(),'Geographical Level')]")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//*[@class='gx-layout-sider-scrollbar']//div[1]//ul[@id='geographicallevel$Menu']//li[1]//a//span")).click();
	 // driver.findElement(By.xpath("//*[@id='adminsettings$Menu']//li[1]//ul[@id='geographicallevel$Menu']//li//a[1]//span[text()='Manage Area']")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//*[@class='ant-card-body']//a[@class='btn btn-primary']")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//*[@id='area']")).sendKeys("Second floor");
	  driver.findElement(By.id("currency")).click();
	  Thread.sleep(2000);
  }
}
