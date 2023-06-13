package com.bhiawpkg.Pages;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BHIAW.Helper.LoggerHelper;

public class LogoutPage {
	 WebDriver driver;
		Properties pr=new Properties();
		private final Logger logger=LoggerHelper.getLogger(LogoutPage.class);
		@FindBy(xpath="//*[@class='icon-user']")public WebElement usericon;
		@FindBy(xpath="//*[@class='icon-key ico']")public WebElement Logout;
		public LogoutPage(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		public void clickusericon()
		{
			this.usericon.click();
			logger.info("user icon is clicked!!!!");
		}
		public void clickLogout()
		{
			this.Logout.click();
			logger.info("user click logout!!!!");
			
		}
}
