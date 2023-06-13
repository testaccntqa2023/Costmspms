package com.bhiawpkg.Pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	Properties pr=new Properties();
	@FindBy(xpath="//a[contains(text(),'Home')]")public WebElement homebtn;
	@FindBy(linkText="Purchase")public WebElement purchasebtn;
	@FindBy(linkText="WAREHOUSE")public WebElement warehousebtn;
	@FindBy(linkText="Sales")public WebElement salesbtn;
	@FindBy(linkText="Day Book")public WebElement daybookbtn;
	@FindBy(linkText="Daily Expenses")public WebElement dailyexpensebtn;
	@FindBy(linkText="Labour Report")public WebElement labourreportbtn;
	@FindBy(linkText="Vendors")public WebElement vendorbtnbtn;
	@FindBy(linkText="Sub Contractors")public WebElement subcontractorbtn;
	@FindBy(linkText="Settings")public WebElement settingsbtnbtn;
	@FindBy(linkText="Reports")public WebElement reportsbtn;
	@FindBy(xpath="//*[@class='pending_concil']")public WebElement Reconciliationbtn;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickhomebtn() 
	{
		this.homebtn.click();
	}
	public void clickpurchasebtn() 
	{
		this.purchasebtn.click();
	}
}
