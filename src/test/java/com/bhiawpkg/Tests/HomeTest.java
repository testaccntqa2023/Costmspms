package com.bhiawpkg.Tests;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.BHIAW.Helper.LoggerHelper;
import com.bhiawpkg.Config.Config;
import com.bhiawpkg.Pages.HomePage;
import com.bhiawpkg.Pages.LoginPage;
import com.bhiawpkg.TestBase.TestBase;

public class HomeTest extends TestBase{
	private static Logger loger=LoggerHelper.getLogger(HomeTest.class);
	
  @Test
  public void Home() throws InterruptedException, IOException {
	   LoginPage bhilogin=new LoginPage(driver);
	  Config con=new Config(pr);
	  bhilogin.Login(con.Getusername(), con.Getpassword());
	  loger.info("--------Login is doing------------");
	  bhilogin.clickloginbtn();
	  Thread.sleep(5000);
	  HomePage hp=new HomePage(driver);
	  hp.clickhomebtn();
	  loger.info("--------Home button is clicked------------");
	 // boolean status=driver.getTitle().contentEquals("NOTIFICATIONS");
	  boolean status=driver.getPageSource().contains("NOTIFICATIONS");//D2R - Dashboard
	  if(status==true)
	  {
		  Assert.assertTrue(true);
		  loger.info("HomePage is loaded!!!");
	  }
	  else
	  {
		  loger.info("homepage is failed!!!");
		  captureScreen(driver,"loginTest");
		  Assert.assertTrue(false);
		 
		  
	  }
  }
}
