package com.gridtest;

import java.io.IOException;
import java.net.URL;
import java.sql.DriverManager;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.bhiawpkg.Config.Config;
import com.bhiawpkg.Pages.LoginPage;

public class LoginTeston_grid {
	static WebDriver driver;
	 @Test(priority = 1)
	  public void setup() throws InterruptedException, IOException {
		//ChromeOptions options=new ChromeOptions();
		  String nodeURL="http://192.168.1.7:35667/wd/hub";
		  DesiredCapabilities cap=DesiredCapabilities.htmlUnit();
		// cap.setCapability(ChromeOptions.CAPABILITY, options);
		  cap.setBrowserName("chrome");
		  cap.setPlatform(Platform.WINDOWS);
		 System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "\\Drivers\\chromedriver.exe");
		 driver=new RemoteWebDriver(new URL(nodeURL),cap);
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		  	//con.Geturl();
		 }
	 @Test(priority = 2)
	 public void Login() throws InterruptedException
	 {
		 driver.get("http://stagepms.ashlyerp.xyz/index.php?");
		 LoginPage bhilogin=new LoginPage(driver);
		//  Config con=new Config(pr);
		 // bhilogin.Login(con.Getusername(), con.Getpassword());
		
		  bhilogin.Login("bhideveloper", "bhi123");
		  Thread.sleep(4000);
		  //loger.info("--------Login is doing------------");
		  boolean status=bhilogin.verifysuccessfull();
		  	  if(status==true){
				Assert.assertTrue(true);
				Thread.sleep(2000);
				bhilogin.Clickbox();
				//loger.info("==============login is sucessful=========================");
				
			}
			else{
				//captureScreen(driver,"loginTest");
				 // Assert.assertTrue(false);
				Assert.assertTrue(false, "==============login is not sucessful=========================");
			}
	 }
}
