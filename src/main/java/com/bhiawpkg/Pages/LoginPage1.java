package com.bhiawpkg.Pages;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BHIAW.Helper.GenericHelper;
import com.BHIAW.Helper.LoggerHelper;

public class LoginPage1 {
	
		WebDriver driver;
		Properties pr=new Properties();
		private final Logger logger=LoggerHelper.getLogger(LoginPage1.class);
		@FindBy(id="LoginForm_username")public WebElement username;
		@FindBy(id="LoginForm_password")public WebElement password;
		@FindBy(xpath="//*[@id='login-form']//div[4]//input[@value='Login']")public WebElement Loginbttn;
		@FindBy(xpath="//li//a[text()='Home']")public WebElement successmsg;
		public LoginPage1(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		public void typeusername(String uname) 
		{
			this.username.sendKeys(uname);
			logger.info("----------Username is getting------------");
		}
		public void typepassword(String password) 
		{
			 this.password.sendKeys(password);
			 logger.info("----------Password is getting------------");
		}
		public void clickloginbtn()
		{
			this.Loginbttn.click();
			logger.info("----------Loginbutton is clicked------------");
			
		}
		public void Login(String username,String password) throws InterruptedException
		{
			typeusername(username);
			Thread.sleep(2000);
			typepassword(password);
		}
		public boolean verifysuccessfull()
		{
			
			return new GenericHelper().isDisplayed(successmsg);
			
		}

}
