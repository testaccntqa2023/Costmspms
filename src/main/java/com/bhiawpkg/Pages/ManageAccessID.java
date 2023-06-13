package com.bhiawpkg.Pages;

import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BHIAW.Helper.DropdownHelper;
import com.BHIAW.Helper.LoggerHelper;

public class ManageAccessID {
	WebDriver driver;
	Properties pr=new Properties();
	private final Logger logger=LoggerHelper.getLogger(ManageAccessID.class);
	@FindBy(xpath ="//*[@class='nav nav-tabs']//li[2]//a[text()='Manage Access IDs']")public WebElement manageaccessid;
	@FindBy(id ="DeviceAccessids_deviceid")public WebElement deviceacsid;
	@FindBy(id ="DeviceAccessids_accesscard_id")public WebElement acscardid;
	@FindBy(xpath ="//*[@value='Add']")public WebElement Acsaddbtn;
	//@FindBy(xpath ="//*[@id='device-accessids-grid']//table//tbody//tr//td[4]//a[@title='Update']")public WebElement acsideditbtn;
	@FindBy(xpath ="//tbody/tr[1]/td[4]/a[1]/img[1]")public WebElement acsideditbtn;
	
	@FindBy(xpath ="//*[@value='Update']")public WebElement updatebtn;
	public ManageAccessID(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickmanageacsid()
	{
		this.manageaccessid.click();
		logger.info("-----------click manage access id---------------------");
	}
	public void selectdeviceacsid(String device)
	{
		DropdownHelper dpselacsid=new DropdownHelper(driver);
		dpselacsid.SelectUsingVisibleText(deviceacsid, device);
		logger.info("--------------selecting the device id----------------------");
	}
	public void typeacsid(String Acsid)
	{
		this.acscardid.sendKeys(Acsid);
		logger.info("--------------type the access id----------------------");
	}
	public void clickAcsaddbtn()
	{
		this.Acsaddbtn.click();
		logger.info("--------user click Access id Add button--------------");
	}
	public void Clickacsidedit()
	{
		this.acsideditbtn.click();
		logger.info("------------click Edit button---------------------------");
	}
	public void edittypeacsid()
	{
		String oldacsid=this.acscardid.getText();
		this.acscardid.clear();
		this.acscardid.sendKeys(RandomStringUtils.randomNumeric(3)+oldacsid);
		logger.info("--------enter new acs id-------------");
	}
	public void clickupdatebtn()
	{
		this.updatebtn.click();
		logger.info("------click update button--------");
	}
	public boolean VerifysuccessfullAdd()
	{
		return driver.getPageSource().contains("Successfully added new Access id.");
	}
	public boolean VerifysuccessfullEdit()
	{
		return driver.getPageSource().contains("Successfully updated.");
	}
	
}
