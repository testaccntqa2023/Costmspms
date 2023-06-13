package com.bhiawpkg.Pages;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BHIAW.Helper.LoggerHelper;
import com.bhiawpkg.Config.Config;
import org.apache.log4j.Logger;
public class CompanyPage {
	WebDriver driver;
	Properties pr=new Properties();
	JavascriptExecutor e ;
	Config con=new Config(pr);
	//Masterpage mstr;
	
	private final Logger logger=LoggerHelper.getLogger(CompanyPage.class);
	public CompanyPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//li//a[text()='Company']")public WebElement companyname;
	@FindBy(xpath="//*[@class='createcomp btn btn-primary']")public WebElement settingsaddcmpny;
	@FindBy(xpath="//input[@id='Company_name']")public WebElement companynme;
	@FindBy(xpath="//input[@id='Company_pincode']")public WebElement cmpnypincode;
	@FindBy(xpath="//input[@id='Company_phone']")public WebElement companyphone;
	@FindBy(xpath="//input[@id='Company_email_id']")public WebElement companyemailid;
	@FindBy(xpath="//input[@id='Company_company_gstnum']")public WebElement companygst;
	@FindBy(xpath="//input[@id='Company_company_tolerance']")public WebElement companytolerance;
	@FindBy(xpath="//input[@id='Company_subcontractor_limit']")public WebElement companysubcntrlimit;
	@FindBy(xpath="//input[@id='Company_company_popermission']")public WebElement compnypopermission;
	@FindBy(xpath="//*[@id='Company_auto_purchaseno']")public WebElement companypurchaseorderno;
	@FindBy(xpath="//input[@id='Company_purchase_amount']")public WebElement companypurchaseamnt;
	@FindBy(xpath="//input[@id='Company_expenses_email']")public WebElement compnyexpenseemail;
	@FindBy(xpath="//input[@id='Company_expenses_percentage']")public WebElement companyexpensepercentage;
	@FindBy(xpath="//*[@class='col-md-6']//ul[@class='checkboxList']//span[@id='Company_subco_email_userid']//li//label[text()='divya']")public WebElement subcntremail;
	@FindBy(xpath="']")public WebElement subcntr2;
	@FindBy(xpath="//*[@id='Company_description']")public WebElement compnydescr;
	@FindBy(xpath="//*[@id='Company_address']")public WebElement compnyaddress;
	
	@FindBy(xpath="//*[@class='btn btn-info createcomp_btn']")public WebElement invoiceemailnot;
	@FindBy(xpath="//*[@class='btn btn-info createcomp_btn']")public WebElement compnycreatebtn;
	@FindBy(xpath="//*[@id='Company_expenses_percentage']")public WebElement compnyexp;
	//
	
	public void clickcompany()
	{
		this.companyname.click();
		logger.info("--------------user click company-------------------");
	}
	public String getlastcmpnyname()
	 {
		 List<WebElement>elem=driver.findElements(By.xpath("//table//tbody//tr//td[2]"));
		 int cmpcnt=elem.size();
		 String companyname=driver.findElement(By.xpath("//table//tbody//tr["+cmpcnt+"]//td[2]")).getText();
		 return companyname;
	 }

}
