package com.bhiawpkg.Pages;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BHIAW.Helper.GenericHelper;
import com.BHIAW.Helper.LoggerHelper;

public class LoginPage {
	 WebDriver driver;
	Properties pr=new Properties();
	private final Logger logger=LoggerHelper.getLogger(LoginPage.class);
	@FindBy(id="LoginForm_username")public WebElement username;
	@FindBy(id="LoginForm_password")public WebElement password;
	@FindBy(xpath="//*[@class='btn btn-success uppercase']")public WebElement Loginbttn;
	//@FindBy(xpath="//body/div[2]/div[2]/div[4]/div[1]/div[1]/div[2]/i[1]")public WebElement closebtn;
	/*//xpath=//div[@id='box']/i*/
	@FindBy(xpath="//*[@class='container clearfix']")public WebElement successmsg;
	//@FindBy(xpath="//div[@id='box']/i")public WebElement closebtn;
	@FindBy(xpath="//i[@class='glyphicon toggle-expand-icon close-button glyphicon-remove']")public WebElement closebtn;
	//i[@class='glyphicon toggle-expand-icon close-button glyphicon-remove']
	public LoginPage(WebDriver driver)
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
		//this.closebtn.click();
		
	}
	public void Login(String username,String password)
	{
		typeusername(username);
		typepassword(password);
		clickloginbtn();
	}
	public boolean verifysuccessfull()
	{
		
		return new GenericHelper().isDisplayed(successmsg);
		
	}
public void Clickbox()
{
	this.closebtn.click();
	
}
}
