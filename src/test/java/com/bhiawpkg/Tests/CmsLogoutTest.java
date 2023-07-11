package com.bhiawpkg.Tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.bhiawpkg.Pages.CMSLogoutPage;

public class CmsLogoutTest {
	WebDriver driver;
	public void cmsLogout() throws InterruptedException
	  {
		
		CMSLogoutPage logout=new CMSLogoutPage(driver);
		  logout.clickusericon();
		  logout.clickLogout();
		  Thread.sleep(2000);
	}
}
