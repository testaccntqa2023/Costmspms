package com.bhiawpkg.Pages;

import java.time.LocalDate;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BHIAW.Helper.Dateselectionhelper;
import com.BHIAW.Helper.DropdownHelper;
import com.BHIAW.Helper.LoggerHelper;
import com.mysql.cj.x.protobuf.MysqlxExpect.Open.Condition.Key;

public class Reportpage {
	WebDriver driver;
	Properties pr=new Properties();
	private final Logger logger=LoggerHelper.getLogger(Reportpage.class);
	@FindBy(xpath ="//li[8]//a[text()='Reports']")public WebElement reports;
	@FindBy(xpath ="//li//a[text()='Project Report']")public WebElement projectreport;
	@FindBy(xpath ="//*[@class='view']//div//select[@name='ProjectReport[project_id]']")public WebElement choosepjt;
	@FindBy(xpath ="//*[@class='view']//div//select[@name='ProjectReport[report_type]']")public WebElement chooserpttype;
	@FindBy(id ="ProjectReport_from_date")public WebElement fromdate;
	@FindBy(id ="ProjectReport_to_date")public WebElement todate;
	@FindBy(xpath ="//*[@value='Generate']")public WebElement clickgenerate;
	@FindBy(xpath ="//*[@id='project-report-grid']//table//thead//tr[2]//td[2]//select")public WebElement pjtselgrid;
//-----------------------------------------------------project report--------------------------------
	@FindBy(xpath ="//li//a[text()='Employee Monthly Report']")public WebElement empmonthrept;
	@FindBy(xpath ="//*[@id='startdate']")public WebElement   empmonthreptstartdate;
	@FindBy(xpath ="//*[@id='tilldate']")public WebElement empmonthreptenddate;
	@FindBy(xpath ="//*[@id='dprtment']")public WebElement empmonthreptdept;
	@FindBy(xpath ="//*[@id='btn_submit_for_report']")public WebElement empmonthreptsubmit;
	@FindBy(xpath ="//*[@id='saveasexcel']")public WebElement empmonthreptsaveasexcel;
	
	@FindBy(xpath ="//*[@id='project-report-grid']//table//thead//tr//td[2]//select")public WebElement selpjtrpt;
	@FindBy(xpath ="//*[@id='project-report-grid']//table//thead//tr//td[3]//select")public WebElement selrpttype;
	@FindBy(xpath ="//*[@id='project-report-grid']//table//tbody//tr[1]//td//a[2]")public WebElement pdfrptdnld;
//---------------------------------------------Employee monthly report--------------------------------
	//---------------------------------------------Service report--------------------------------	
	@FindBy(xpath ="//li//a[text()='Service Report']")public WebElement servicereport;
	@FindBy(xpath ="//*[@id='date_from']")public WebElement servicerptfromdate;
	@FindBy(xpath ="//*[@id='date_till']")public WebElement servicerpttodate;
	@FindBy(xpath ="//*[@id='Tasks_project_id']")public WebElement servicerptpjtname;
	@FindBy(xpath ="//*[@id='Tasks_clientsite_id']")public WebElement servicerptlocation;
	@FindBy(xpath ="//*[@value='Search']")public WebElement servicerptsearch;
	public Reportpage(WebDriver driver)
	{
	 this.driver=driver;
	 PageFactory.initElements(driver, this);
	}
    public void clickreports()
    {
    	this.reports.click();
    	logger.info("-----------click reports menu--------------------");
    }
    public void clickpjtrepts()
    {
    	this.projectreport.click();
    	logger.info("-----------click project report from report menu--------------------");
    }
    public void selpjt(String sepjt)
    {
    	DropdownHelper dpselchoosepjt=new DropdownHelper(driver);
    	dpselchoosepjt.SelectUsingVisibleText(choosepjt, sepjt);
    	logger.info("-----------select project --------------------");
    }
    public void clickreporttype()
    {
    	this.chooserpttype.click();
    	logger.info("-----------choose report type--------------------");
    }
    public void selrpttype(String pjttype)
    {
    	DropdownHelper dpselchooserpt=new DropdownHelper(driver);
    	dpselchooserpt.SelectUsingVisibleText(chooserpttype, pjttype);
    	logger.info("-----------select project type --------------------");	
    }
    public void clickfromdate()
    {
    	this.fromdate.click();
    	logger.info("-----------click from date--------------------");
    }
    public void typepjtfrmdate()
    {
    	LocalDate Today_date=java.time.LocalDate.now();
    	this.fromdate.sendKeys(""+Today_date.minusMonths(1));
    	logger.info("-----------Type from date--------------------");
    }
    
    public void clicktodate()
    {
    	this.todate.click();
    	logger.info("-----------click to date--------------------");
    }
    public void typepjttodate()
    {
    	LocalDate Today_date=java.time.LocalDate.now();
    	this.todate.sendKeys(""+Today_date);
    	logger.info("-----------Type from date--------------------");
    }
    public void clickgenerate()
    {
    	this.clickgenerate.click();
    	logger.info("-----------click generate--------------------");
    }
    public void Getpjtfrmrptdate(String exMonth,String exYear,String exDay)
    {
    	Dateselectionhelper dateselpjtfrmdate=new Dateselectionhelper(driver);
    	dateselpjtfrmdate.selpjtfromreportdate(exMonth, exYear, exDay);
    	logger.info("--------------select from date-----------------------");
    }
    
    
    
  //-----------------------------------------------------project report--------------------------------
  //---------------------------------------------Employee monthly report--------------------------------
  public void clickempmnthrpt()
  {
	  this.empmonthrept.click();
	  logger.info("--------------click emp month report-----------------------");
  }
  public void selstartempmnthrptdate()
  {
	  this.empmonthreptstartdate.clear();
	  LocalDate Today_date=java.time.LocalDate.now();
	  this.empmonthreptstartdate.sendKeys(""+Today_date.minusMonths(1));
	  logger.info("--------------start date-----------------------");
  }
  public void selendempmnthrptdate()
  {
	  this.empmonthreptenddate.clear();
	  LocalDate Today_date=java.time.LocalDate.now();
	  this.empmonthreptenddate.sendKeys(""+Today_date);
	  logger.info("--------------end date-----------------------");
  }
  public void seldepartment(String empdept)
  {
	  DropdownHelper dpseldept=new DropdownHelper(driver);
	  dpseldept.SelectUsingVisibleText(this.empmonthreptdept, empdept);
	  logger.info("--------------select department-----------------------");
  }
  public void clicksubmitemprpt()
  {
	  this.empmonthreptsubmit.click();
	  logger.info("--------------click submit button-----------------------");
  }
  public void clicksaveasexcel()
  {
	  this.empmonthreptsaveasexcel.click();
	  logger.info("--------------click save as excel-----------------------");
  }
  public void selpjtrptgrid(String pjtselgr)
  {
	  DropdownHelper dpselpjtgrid=new DropdownHelper(driver);
	  dpselpjtgrid.SelectUsingVisibleText(this.pjtselgrid, pjtselgr);
	  logger.info("--------------select project from grid-------------------------");
  }
  public void selpjtreport(String pjtrpt)
  {
	  DropdownHelper dpselpjtrpt=new DropdownHelper(driver);
	  dpselpjtrpt.SelectUsingVisibleText(this.selpjtrpt, pjtrpt);
	  logger.info("---------selecting the project-----------");
  }
  public void selpjtrpttype(String pjtrpttype)
  {
	  DropdownHelper dpselpjtrpt=new DropdownHelper(driver);
	  dpselpjtrpt.SelectUsingVisibleText(this.selrpttype, pjtrpttype);
	  this.selrpttype.sendKeys(Keys.ENTER);
	  logger.info("---------selecting the project report type-----------");
  }
  public void clickpdfrptdonload()
  {
	  this.pdfrptdnld.click();
	  logger.info("---------click pdf report icon---------------");
  }
//---------------------------------------------Service report--------------------------------
  public void clickservicerept()
  {
	  this.servicereport.click();
	  logger.info("---------click service report-------------------------");
  }
  public void servicerpttodate()
  {
	  this.servicerpttodate.clear();
	  LocalDate Today_date=java.time.LocalDate.now();
	  this.servicerpttodate.sendKeys(""+Today_date);
	  logger.info("--------------enter service report till date-----------------------");
	  
  }
  public void servicerptfromdate() throws InterruptedException
  {
	  this.servicerptfromdate.clear();
	  LocalDate Today_date=java.time.LocalDate.now();
	  this.servicerptfromdate.sendKeys(""+Today_date.minusMonths(1));
	  Thread.sleep(2000);
	  logger.info("--------------enter service report from date-----------------------");
  }
  public void selservicerptpjt(String servrptpjt)
  {
	  DropdownHelper dpselpjtrpt=new DropdownHelper(driver);
	  dpselpjtrpt.SelectUsingVisibleText(this.servicerptpjtname, servrptpjt);
	  logger.info("---------selecting the  service project-----------");
  }
  public void clicksearch()
  {
	  this.servicerptsearch.click();
	  logger.info("----click search of service report----------");
  }
}
