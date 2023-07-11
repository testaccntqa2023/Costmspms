package com.bhiawpkg.Pages;




import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.BHIAW.Helper.LoggerHelper;


public class CMSLogoutPage {
	 WebDriver driver;
		Properties pr=new Properties();
		private final Logger logger=LoggerHelper.getLogger(CMSLogoutPage.class);
		By Logoutimg = By.xpath("//a//img[contains(@src,'/themes/jpvcms/images/avatar.png')]");
		By Logoutuser=By.xpath("//a[contains(@href,'/index.php?r=site/logout')]");
		@FindBy(xpath="//a//img[contains(@src,'/themes/jpvcms/images/avatar.png')]")public WebElement usericon;
				
		@FindBy(xpath="//*[@id='myNavbar']//div//ul//li[2]")public WebElement Logout1;
		@FindBy(xpath="//a[contains(@href,'/index.php?r=site/logout')]")public WebElement Logout;
		public CMSLogoutPage(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		public void clickusericon() throws InterruptedException
		{
			WebElement elem=driver.findElement(Logoutimg);
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", elem);
			Thread.sleep(2000);
			logger.info("user icon is clicked!!!!");
		}
		public void clickLogout()
		{
			WebElement elem=driver.findElement(Logoutuser);
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", elem);
			logger.info("user click logout!!!!");
			
		}
}
