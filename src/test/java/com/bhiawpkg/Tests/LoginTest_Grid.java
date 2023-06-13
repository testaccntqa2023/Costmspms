package com.bhiawpkg.Tests;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.BHIAW.Helper.LoggerHelper;
import com.bhiawpkg.Config.Config;
import com.bhiawpkg.Pages.LoginPage;
import com.bhiawpkg.TestBase.TestBase;

public class LoginTest_Grid extends TestBase{
	private static Logger loger=LoggerHelper.getLogger(LoginTest_Grid.class);
	
	  @Test(priority = 1)
	  public void setup() throws InterruptedException, IOException {
		  
		  String nodeURL="http://192.168.1.7:35667/wd/hub";
		  DesiredCapabilities cap=new DesiredCapabilities();//.chrome
		  cap.setBrowserName("chrome");
		  cap.setPlatform(Platform.WIN10);
		 
		  	//con.Geturl();
		 }
	  
	 @Test(priority = 2)
	 public void Login() throws InterruptedException, IOException
	 {
		 LoginPage bhilogin=new LoginPage(driver);
		  Config con=new Config(pr);
		  bhilogin.Login(con.Getusername(), con.Getpassword());
		  Thread.sleep(4000);
		  loger.info("--------Login is doing------------");
		  boolean status=bhilogin.verifysuccessfull();
		  	  if(status==true){
				Assert.assertTrue(true);
				Thread.sleep(2000);
				bhilogin.Clickbox();
				loger.info("==============login is sucessful=========================");
				
			}
			else{
				captureScreen(driver,"loginTest");
				 // Assert.assertTrue(false);
				Assert.assertTrue(false, "==============login is not sucessful=========================");
			}
	 }
	 
	}
