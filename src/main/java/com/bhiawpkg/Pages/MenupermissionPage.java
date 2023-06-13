package com.bhiawpkg.Pages;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BHIAW.Helper.AlertHelper;
import com.BHIAW.Helper.JavascriptHelper;
import com.BHIAW.Helper.LoggerHelper;

public class MenupermissionPage {
	WebDriver driver;
	Properties pr=new Properties();
	private final Logger logger=LoggerHelper.getLogger(MenupermissionPage.class);
	public MenupermissionPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//Element lcators
	@FindBy(xpath = "//li//a[text()='Settings']") public WebElement settingsmenu;
	@FindBy(xpath = "//li//a[text()='Menu Permissions']") public WebElement menupermission;
	//@FindBy(xpath = "//*[@class='grid']//table//th//input") public WebElement allchkboxpermission;
	//user selection
	//*[@id='userslist']//li//a[text()='Akash S']
	
	
	@FindBy(xpath="//*[@id='userslist']//li//a[text()='")public WebElement selectuserlist1;
	@FindBy(xpath="']")public WebElement selectuserlist2;
	@FindBy(xpath = "//*[@id='savebtn']") public WebElement savebutton;
	@FindBy(xpath ="//*[@class='icon-arrow-up']")public WebElement scrolltotop;
	@FindBy(id ="user_search")public WebElement usersearch;
	public void clickSettingsmenu()
	{
		this.settingsmenu.click();
		logger.info("----------user click settings menu-----------------");
	}
	public void clickmenupermission()
	{
		this.menupermission.click();
		logger.info("----------user click menupermission -----------------");
	}
	public void typeusername(String username) throws InterruptedException
	{
		this.usersearch.sendKeys(username);
		this.usersearch.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		logger.info("-----type username-----------------");
	}
	public void checkallpermission() throws InterruptedException
	{
		List<WebElement>permissionlist=driver.findElements(By.xpath("//*[@class='grid']//table//th//input"));
		for(int i=0;i<=permissionlist.size();i++)
		{
			Iterator<WebElement>we=permissionlist.iterator();
			while(we.hasNext())
			{
				WebElement webel=we.next();
				if(!webel.isSelected())
				{
					try {
					JavascriptHelper js=new JavascriptHelper(driver);
					js.scrollUpByPixel();
					if(!webel.isSelected())
					{
						js.scrollUpByPixel();
					}
					//js.scrollToElemet(webel);
					webel.click();
					}
					catch(Exception weException)
					{
						JavascriptHelper js=new JavascriptHelper(driver);
						js.executeScript("window.scrollBy(0, 43)", webel);
						webel.click();
					}
				}
				
			}
			
		}
		
	/*	JavascriptHelper js=new JavascriptHelper(driver);
		for(WebElement we:permissionlist)
		{
			//js.scrollIntoView(we);
			if(!we.isSelected())
			{
				
				//js.executeScript(null)
			we.click();
			logger.info("----------user click menupermission -----------------");
			js.scrollDownByPixel();
			
			//js.executeScript("window.scrollBy(0, 40)", we);
			//js.scrollIntoViewAndClick(we);
			//JavascriptHelper js=new JavascriptHelper(driver);
			//js.scrollToElemet(we);
			//js.scrollToElemet(we);
			//js.executeScript("window.scrollBy(0, 20)", we);
			
			//Thread.sleep(2000);
			//js.scrollToElemet(we);
			//js.scrollDownByPixel();
			}
			
			*/
		//}
		
	}
	
	public void clickscroltotop()
	{
		this.scrolltotop.click();
	}
	public void clicksavebutton()
	{
		this.savebutton.click();
		logger.info("----------------click save button---------------------");
	}
	public void clickAlert()
	{
		AlertHelper alertpermission=new AlertHelper(driver);
		alertpermission.getAlert();
		alertpermission.AcceptAlertIfPresent();
		logger.info("-------Accept alert----------");
		JavascriptHelper js=new JavascriptHelper(driver);
		js.scrollUpByPixel();
	}
	
}
