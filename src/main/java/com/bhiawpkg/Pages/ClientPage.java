package com.bhiawpkg.Pages;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BHIAW.Helper.AlertHelper;
import com.BHIAW.Helper.DropdownHelper;
import com.BHIAW.Helper.GenericHelper;
import com.BHIAW.Helper.LoggerHelper;

public class ClientPage {
	WebDriver driver;
	Properties pr=new Properties();
	private final Logger logger=LoggerHelper.getLogger(ClientPage.class);
	public ClientPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//Element lcators
	@FindBy(xpath = "//*[text()='Clients']") public WebElement clientmenu;
	
	@FindBy(xpath = "//*[@class ='portlet light']//div//a[text()='Add Client']") public WebElement addclient;
	@FindBy(id = "cru-frame") public WebElement clientframe;
	@FindBy(id = "Clients_name") public WebElement clientname;
	@FindBy(id = "Clients_nick_name") public WebElement clientnickname;
	@FindBy(id = "Clients_project_type") public WebElement clientpjttype;
	@FindBy(id = "uniform-Clients_status_0") public WebElement clientactivestatus;
	@FindBy(id = "Clients_description") public WebElement clientdescription;
	@FindBy(xpath = "//*[@value='Create']") public WebElement clientcreate;
	@FindBy(id = "projects-grid") public WebElement clientgrid;
	public void clickclientmenu()
	{
		this.clientmenu.click();
		logger.info("--------------click client menu---------------------");
	}
	public void clickaddclient()
	{
		this.addclient.click();
		logger.info("--------------click add client ---------------------");
	}
	public void switchclientfr()
	{
		AlertHelper alertf=new AlertHelper(driver);
		alertf.switchtoframe(this.clientframe);
		logger.info("--------------switch into a client frame---------------------");
	}
	public void typeclientname(String clientnme)
	{
		this.clientname.sendKeys(clientnme);
		logger.info("--------------enter client name---------------------");
		
	}
	public void typeclientnickname(String clientnicknme)
	{
		this.clientnickname.sendKeys(clientnicknme);
		logger.info("--------------enter client nick name---------------------");
	}
	public void selProjecttype(String pjttype)
	{
		DropdownHelper dpselpjttype=new DropdownHelper(driver);
		dpselpjttype.SelectUsingVisibleText(this.clientpjttype, pjttype);
		logger.info("---------select the project type---------------------");
		
	}
	public void clickclientstatus()
	{
		this.clientactivestatus.click();
		logger.info("---------choose status of  a client-------------");
	}
	public void typedescr(String clientdescr)
	{
		this.clientdescription.sendKeys(clientdescr);
		logger.info("----------Enter client description-------------");
	}
	public void clickcretebutton()
	{
		this.clientcreate.click();
		logger.info("-----------clicking create button-----------------");
	}
	public void verifysuccessfull()
	{
		GenericHelper elmdisplayed=new GenericHelper();
		elmdisplayed.isDisplayed(this.clientgrid);
		logger.info("---------clent is created!!-----------");
	}
}
