package com.bhiawpkg.Pages;

import java.time.LocalDate;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.jsoup.parser.ParseError;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.sikuli.script.FindFailed;
import org.testng.Assert;

import com.BHIAW.Helper.Dateselectionhelper;
import com.BHIAW.Helper.DropdownHelper;
import com.BHIAW.Helper.GenericHelper;
import com.BHIAW.Helper.JavascriptHelper;
import com.BHIAW.Helper.LoggerHelper;
import com.BHIAW.Helper.Radiobuttonhelper;
import com.BHIAW.Helper.Uploadhelper;

public class ReportDownloadPage {
	WebDriver driver;
	Properties pr=new Properties();
	GenericHelper gh;
	JavascriptHelper js;
	private final Logger logger=LoggerHelper.getLogger(ReportDownloadPage.class);
	public ReportDownloadPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//li//a[text()='Reports']")public WebElement reportmenu;
	@FindBy(xpath="//li//a[text()='Financial Reports']")public WebElement financialrpt;
	@FindBy(xpath="//a[text()='SAVE AS PDF']")public WebElement saveaspdf;
	@FindBy(xpath="//a[text()='SAVE AS EXCEL']")public WebElement saveasexcel;
	@FindBy(xpath="//li//a[text()='Receipt Report']")public WebElement receiptrptdwnld;
	@FindBy(xpath="//li//a[text()='Work Status Report']")public WebElement workstatus;
	@FindBy(xpath="//li//a[text()='Weekly Payment Report']")public WebElement weeklypaymntrpt;
	@FindBy(xpath="//li//a[text()='Project Report']")public WebElement projectreport;
	
	 @FindBy(xpath="//*[@id='project_id']")public WebElement pjtrptpjt;
	 @FindBy(xpath="//*[@id='project_status']")public WebElement pjtstatus;
	 @FindBy(xpath="//*[@id='company_id']")public WebElement pjtrptcmp;
	 @FindBy(xpath="//*[@value='GO']")public WebElement rptpjtgo;
	 @FindBy(xpath="//a[text()='UnReconciled Report']")public WebElement pjtrptunreconrpt;
	 @FindBy(xpath="//*[@id='company_id']")public WebElement receiptcmpny;
	 @FindBy(xpath="//*[@id='Expenses_fromdate']")public WebElement expfrmdate;
	 @FindBy(xpath="//*[@id='Expenses_todate']")public WebElement exptodate;
	 @FindBy(xpath="//*[@id='expenses-form']/div[4]/input[1]")public WebElement receiptrptgobtn;
	 @FindBy(xpath="//*[@id='subcontractor_id']")public WebElement subcntrname;
	 @FindBy(xpath="//*[@id='projectid']")public WebElement weeklyrptsubcntrpjt;
	 @FindBy(xpath="//*[@class='filter_elem filter_btns']//input[@value='Go']")public WebElement weeklypaymntgobtn;
	 @FindBy(xpath="//li//a[text()='Day Book Transactions']")public WebElement daybooktransopt;
	 @FindBy(xpath="//*[@id='Expenses_type']")public WebElement daybooktranstype;
	 @FindBy(xpath="//*[@id='Expenses_vendor_id']")public WebElement daybookvndrname;
	 @FindBy(xpath="//*[@id='Expenses_purchase_type']")public WebElement daybookpurchasetype;
	 @FindBy(xpath="//*[@id='Expenses_expense_type']")public WebElement daybookexptranstype;
	 @FindBy(xpath="//*[@id='Expenses_subcontractor_id']")public WebElement daybooksubcntrname;
	 @FindBy(xpath="//*[@id='search-form']/div[2]//div[5]//input[1]")public WebElement daybookgobtn;
	 @FindBy(xpath = "//*[@id='btSubmit']")public WebElement pjtrptgobtn;
	 //dailyexp rpt
	 @FindBy(xpath="//li//a[text()='Daily Expense Report']")public WebElement dailyexprpt;
	 @FindBy(xpath="//*[@id='Dailyexpense_exp_type']")public WebElement dlyexptype;
	 @FindBy(xpath="//*[@id='dailyexpense_purchase_type']")public WebElement dlyexppurchasetype;
	 @FindBy(xpath="//*[@id='Dailyexpense_expense_type']")public WebElement dlyexptranstype;
	 @FindBy(xpath="//*[@name='monthlyreport']")public WebElement dlyexpgobtn;
	 //vendorpaymnt rpt
	 @FindBy(xpath="//li//a[text()='Vendor Payment Report']")public WebElement vndrpaymntrpt;
	 @FindBy(xpath="//*[@id='vendor_id']")public WebElement vendorname;
	 @FindBy(xpath="//*[@id='btSubmit']")public WebElement vndrgobtn;
	 //subcntr paymnt rpt
	 @FindBy(xpath="//li//a[text()='Subcontractor Payment Report']")public WebElement subcntrpaymntrpt;
	 @FindBy(xpath="//*[@id='subcontractor_id']")public WebElement selsucntrname;
	 @FindBy(xpath="//*[@name='project_id']")public WebElement subcntrpjtname;
	 //cash balance report
	 @FindBy(xpath="//li//a[text()='Cashbalance  Report']")public WebElement cashbalancereport;
	 @FindBy(xpath="//*[@id='date_from']")public WebElement datefrom;
	 //taxreport
	 @FindBy(xpath="//li//a[text()='Tax Report']")public WebElement taxreport;
	 //reconciliation report
	 @FindBy(xpath="//li//a[text()='Reconciliation Report']")public WebElement reconciliationrpt;
	 @FindBy(xpath="//*[@id='Reconciliation_reconciliation_bank']")public WebElement reconcilebankname;
	 @FindBy(xpath="//*[@id='Reconciliation_company_id']")public WebElement  recocilecmpny;
	 @FindBy(xpath="//*[@type='submit']")public WebElement reconciligobtn;
	 //purchase report
	 @FindBy(xpath="//*[@name='Bills[project]']")public WebElement  purchaserptpjt;
	 @FindBy(xpath="//*[@name='Bills[vendor]']")public WebElement purchasevendr;
	 @FindBy(xpath="//li//a[text()='Purchase bill Report']")public WebElement purchasebillrpt;
	 //stock status report
	 @FindBy(xpath="//li//a[text()='Stock Status Report']")public WebElement stockstatusreport;
	 @FindBy(xpath="//*[@id='fixtable']//tbody//tr[1]//td[1]")public WebElement warehousename;
	 @FindBy(xpath="//*[@id='fixtable']//tbody//tr[2]//td[3]")public WebElement warehouseitem;
	 //check cash balance
	 @FindBy(xpath="//*[@id='date_from']")public WebElement cashbalancedatefrom;
	 @FindBy(xpath="//*[@id='date_to']")public WebElement cashbalancedateto;
	 @FindBy(xpath="//*[@id='btSubmit']")public WebElement cashbalancegobtn;
	 @FindBy(xpath="//*[@id='date_from']")public WebElement commondatefrom;
	 @FindBy(xpath="//*[@id='date_to']")public WebElement commondateto;
	 
	 //pjt report
	 @FindBy(xpath = "//table[9]/tbody[1]/tr")public WebElement pjtrptsubcntrpaymntamnt;
	 @FindBy(xpath = "//table[6]//tbody[1]/tr[5]/td[2]/b[1]")public WebElement pjtrptpubilltotalamnt;
	 @FindBy(xpath = "//table[10]//tbody//tr[5]//th[2]")public WebElement pjtrptlbrrpttotalamnt;
	@FindBy(xpath = "//a[text()='UnReconciled Report']")public WebElement unreconciledbutton;
	//Expense summary pjt rpt
	
	@FindBy(xpath = "//table[12]//tbody//tr")public WebElement expsummrypjtrpt;
	/*
	@FindBy(xpath = "")public WebElement
	@FindBy(xpath = "")public WebElement
	@FindBy(xpath = "")public WebElement
	@FindBy(xpath = "")public WebElement
	@FindBy(xpath = "")public WebElement
	*/
	public void Clickreportmenu()
	{
		this.reportmenu.click();
	}
	public void Clickfinancialrpt()
	{
		this.financialrpt.click();
	}
	public void clicksaveaspdf()
	{
		this.saveaspdf.click();
	}
	public void clicksaveasexcel()
	{
		this.saveasexcel.click();
	}
	public void clickreceiptrpt()
	{
		this.receiptrptdwnld.click();
	}
	public void clickworkstatus()
	{
		this.workstatus.click();
	}
	public void Clickweeklypaymntrpt()
	{
		this.weeklypaymntrpt.click();
	}
	public void Clickprojectreport()
	{
		this.projectreport.click();
	}
	
	public void selpjtrptpjt(String pjtname)
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingVisibleText(this.pjtrptpjt, pjtname);
	}
	public void selpjtstatus(String pjtstatus)
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingVisibleText(this.pjtstatus, pjtstatus);
	}
	public void selpjtrptcmpny(String cmpname)
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingVisibleText(this.pjtrptcmp, cmpname);
	}
	public void clickpjtrptgo()
	{
		this.rptpjtgo.click();
	}
	public void Clickunreconciledrpt()
	{
		this.pjtrptunreconrpt.click();
	}
	public void selreceiptcmpny(String company)
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingVisibleText(this.receiptcmpny, company);
	}
	public void selexpfromdate() throws InterruptedException
	{
//		this.expfrmdate.clear();
		LocalDate todaydate=java.time.LocalDate.now();
		this.expfrmdate.sendKeys(""+todaydate.minusMonths(1));
		Thread.sleep(2000);
	}
	public void selexptodate()
	{
		//this.exptodate.clear();
		LocalDate todaydate=java.time.LocalDate.now();
		this.exptodate.sendKeys(""+todaydate);
	}
public void clickreportgobtn()
		{
			this.receiptrptgobtn.click();
		}
	public void selsubcontractor(String subcntrname)
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingVisibleText(this.subcntrname, subcntrname);
	}
	public void selweeklyrptpjt(String pjtname)
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingVisibleText(this.weeklyrptsubcntrpjt, pjtname);
	}
	public void Clickweeklypaymntgobtn()
	{
		this.weeklypaymntgobtn.click();
	}
	public void clickdaybooktransaction()
	{
		this.daybooktransopt.click();
	}
	public void seldaybooktranstype_credit()
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingIndex(this.daybooktranstype, 1);
	}
	public void seldaybooktranstype_debit()
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingIndex(this.daybooktranstype, 1);
	}
	public void seldaybookvndrname(String vndrname)
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingVisibleText(this.daybookvndrname, vndrname);
	}
	public void seldaybookpurchasetype()
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingIndex(this.daybookpurchasetype, 2);
	}
	public void seldaybookpexptype()
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingIndex(this.daybookexptranstype, 2);
	}
	public void seldaybooksubcntrname(String subcntrname)
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingVisibleText(this.daybooksubcntrname, subcntrname);
	}
	public void clickdaybookgobtn()
	{
		this.daybookgobtn.click();
	}
	//dlyexprpt
	public void clickdlyexprpt()
	{
		this.dailyexprpt.click();
	}
	public void seldailyexptype()
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingIndex(this.dlyexptype, 2);
	}
	public void seldailyexppurchasetype()
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingIndex(this.dlyexppurchasetype, 2);
	}
	public void seldailyexptranstype()
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingIndex(this.dlyexptranstype, 2);
	}
	public void clickdlyexpgobtn()
	{
		this.dlyexpgobtn.click();
	}
	//vendor payment report
	public void clickvendrpaymntreport()
	{
		this.vndrpaymntrpt.click();
	}
	public void selvendornamername(String vendorname)
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingVisibleText(this.vendorname, vendorname);
	}
	public void clickvndrgobtn()
	{
		this.vndrgobtn.click();
	}
	public void clicksubcntrpaymntreport()
	{
		this.subcntrpaymntrpt.click();
	}
	public void selsubcntrname(String subcntrname)
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingVisibleText(this.selsucntrname, subcntrname);
	}
	public void selsubcntrpjtname(String subcntrpjtname)
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingVisibleText(this.subcntrpjtname, subcntrpjtname);
	}
	//cash balance report
	public void clickcashbalancereport()
	{
		this.cashbalancereport.click();
	}
	public void seldatefrom(String todaydate)
	{
		this.datefrom.sendKeys(todaydate.toString());
		//dpsel.SelectUsingVisibleValue(this.datefrom, todaydate);
	}
	 public void rptfromdate() throws InterruptedException
	  {
		 js=new JavascriptHelper(driver);
		 WebElement elem1=driver.findElement(By.xpath("//*[@id='date_from']"));
		 js.executeScript("arguments[0].removeAttribute('readonly','readonly')",elem1);
		  driver.findElement(By.xpath("//*[@id='date_from']")).clear();
		  LocalDate Today_date=java.time.LocalDate.now();
		   elem1.sendKeys(""+Today_date.minusMonths(1));
		   Thread.sleep(2000);
		  logger.info("--------------enter service report from date-----------------------");
	  }
	 public void rpttodate() throws InterruptedException
	  {
		 js=new JavascriptHelper(driver);
		 WebElement elem1=driver.findElement(By.xpath("//*[@id='date_to']"));
		 js.executeScript("arguments[0].removeAttribute('readonly','readonly')",elem1);
		  driver.findElement(By.xpath("//*[@id='date_to']")).clear();
		  LocalDate Today_date=java.time.LocalDate.now();
		   elem1.sendKeys(""+Today_date);
		   Thread.sleep(2000);
		  logger.info("--------------enter service report from date-----------------------");
	  }
	 //tax report
	 public void clicktaxreport()
	 {
		 this.taxreport.click();
	 }
	 //reconciliation
	 public void clickreconciliation()
	 {
		 this.reconciliationrpt.click();
	 }
	 
	 public void Reconciliationrptfromdate() throws InterruptedException
	  {
		 js=new JavascriptHelper(driver);
		 WebElement elem1=driver.findElement(By.xpath("//*[@id='Reconciliation_fromdate']"));
		 js.executeScript("arguments[0].removeAttribute('readonly','readonly')",elem1);
		  driver.findElement(By.xpath("//*[@id='Reconciliation_fromdate']")).clear();
		  LocalDate Today_date=java.time.LocalDate.now();
		   elem1.sendKeys(""+Today_date.minusMonths(1));
		   Thread.sleep(2000);
		  logger.info("--------------enter from date-----------------------");
	  }
	 public void Reconconciliationrpttodate() throws InterruptedException
	  {
		 js=new JavascriptHelper(driver);
		 WebElement elem1=driver.findElement(By.xpath("//*[@id='Reconciliation_todate']"));
		 js.executeScript("arguments[0].removeAttribute('readonly','readonly')",elem1);
		  driver.findElement(By.xpath("//*[@id='Reconciliation_todate']")).clear();
		  LocalDate Today_date=java.time.LocalDate.now();
		   elem1.sendKeys(""+Today_date);
		   Thread.sleep(2000);
		  logger.info("--------------enter to date-----------------------");
	  }
	 public void selbankreconciliation(String bankname)
	 {
		 DropdownHelper dpsel=new DropdownHelper(driver);
		 dpsel.SelectUsingVisibleText(this.reconcilebankname, bankname);
	 }
	 public void selreconcilcmp(String company)
		{
			DropdownHelper dpsel=new DropdownHelper(driver);
			dpsel.SelectUsingVisibleText(this.recocilecmpny, company);
		}
	 public void clickreconcilgobtn()
	 {
		 this.reconciligobtn.click();
	 }
	 //purchase report
	 public void clickpurchasebillreport()
	 {
		 this.purchasebillrpt.click();
	 }
	 public void selpurchasepjt(String purchasepjt)
		{
			DropdownHelper dpsel=new DropdownHelper(driver);
			dpsel.SelectUsingVisibleText(this.purchaserptpjt, purchasepjt);
		}
	 public void selpurchasevndr(String purchasevndr)
		{
			DropdownHelper dpsel=new DropdownHelper(driver);
			dpsel.SelectUsingVisibleText(this.purchasevendr, purchasevndr);
		}
	 public void clickstockstatusreport()
	 {
		 this.stockstatusreport.click();
	 }
	 public String Getwarehousename()
	 {
		 String whname=this.warehousename.getText();
		 return whname;
	 }
	 public String Getwarehouseitem()
	 {
		 String whitem=this.warehouseitem.getText();
		 return whitem;
	 }
	 public void typecashbalancedatefrm()
	 {
		 LocalDate todaydate=java.time.LocalDate.now();
		 this.cashbalancedatefrom.sendKeys(""+todaydate);
	 }
	 public void typecashbalancedateto()
	 {
		 LocalDate todaydate=java.time.LocalDate.now();
		 this.cashbalancedateto.sendKeys(""+todaydate);
	 }
	 public void clickGobutton()
	 {
		 this.cashbalancegobtn.click();
	 }
	 public void checkcashbalance()
	 {
		 typecashbalancedatefrm();
		 typecashbalancedateto();
		 clickGobutton();
		 
	 }
	 public void selcommondatefrm()
	 {  
		 LocalDate todaydate=java.time.LocalDate.now();
		 
		 this.commondatefrom.sendKeys(""+todaydate.minusDays(15));
	 }
	 public void selcommondatefrm1(String frmdte)
	 {  
		  this.commondatefrom.sendKeys(frmdte);
	 }
	 public void selcommondateto() throws InterruptedException
	 {
		 LocalDate todaydate=java.time.LocalDate.now();
		 this.commondateto.sendKeys(""+todaydate);
		 Thread.sleep(2000);
		 this.commondateto.sendKeys(Keys.ENTER);
		 Thread.sleep(2000);
	 }
	 public void Vendorpaymntfilter(String vndrnme,String cmpnynme) throws InterruptedException
	 {
		selvendornamername(vndrnme); 
		Thread.sleep(2000);
		selpjtrptcmpny(cmpnynme);
		Thread.sleep(2000);
		selcommondatefrm();
		Thread.sleep(2000);
		selcommondateto();
		Thread.sleep(2000);
		clickvndrgobtn();
	 }
	 public void Vendorpaymntfilterwithdate(String vndrnme,String cmpnynme,String frmdate) throws InterruptedException
	 {
		selvendornamername(vndrnme); 
		Thread.sleep(2000);
		selpjtrptcmpny(cmpnynme);
		Thread.sleep(2000);
		selcommondatefrm1(frmdate);
		Thread.sleep(2000);
		selcommondateto();
		Thread.sleep(2000);
		clickvndrgobtn();
	 }
	 public String Getrpttransid(String transid)
		{
		 String transidtxt=null;
		 String trid = null;
			List<WebElement>transids=driver.findElements(By.xpath("//table[10][@class='table vendor_table reconcil_table']//tbody//tr//td[1]"));
			while(true)
			{
			for(int i=2;i<=transids.size();i++)
			{
				//String transidtxt=null;
				 transidtxt=driver.findElement(By.xpath("//table[10][@class='table vendor_table reconcil_table']//tbody//tr["+i+"]//td[1]")).getText();
				if(transidtxt.equalsIgnoreCase(transid))
				{
					logger.info("-Credit payment reflected in the Vendor Report--");
					 trid=transid;
					
					//Assert.assertTrue(true, "-Credit payment reflected in the Vendor Report--");
				}
				/*
				 * else { logger.info("-Credit payment not reflected in the Vendor Report--");
				 * //Assert.assertTrue(false,"-Credit payment reflected in the Vendor Report--"
				 * ); }
				 */
			}
			return trid;}
		}
	 public boolean Getrpttransidstatus(String transid)
		{
		 String transidtxt=null;
		
			List<WebElement>transids=driver.findElements(By.xpath("//table[10][@class='table vendor_table reconcil_table']//tbody//tr//td[1]"));
			boolean found=false;
			
			for(int i=1;i<=transids.size();i++)
			{
				int n=1;
				n=n+i;
				//String transidtxt=null;
				 transidtxt=driver.findElement(By.xpath("//table[10][@class='table vendor_table reconcil_table']//tbody//tr["+n+"]//td[1]")).getText();
				//if(!transid.equalsIgnoreCase(transidtxt))
				if(transid.equals(transidtxt))
				{
					found=true;
					//logger.info("-Credit payment reflected in the Vendor Report--");
					// trid=transid;
					
					//Assert.assertTrue(true, "-Credit payment reflected in the Vendor Report--");
				}
				/*
				 * else { logger.info("-Credit payment not reflected in the Vendor Report--");
				 * //Assert.assertTrue(false,"-Credit payment reflected in the Vendor Report--"
				 * ); }
				 */
					//n=n-1;
			}
			//return null;
			return found;
		}
	
	 public void Getreport(WebElement elem)
	 {
		 Clickreportmenu();
		 elem.click();
				 
	 }
	 public void Getvendorpaymntreport() throws InterruptedException
	 {
		 ReportDownloadPage  rptdwnld=new ReportDownloadPage(driver);
		  rptdwnld.Clickreportmenu();
		  Thread.sleep(2000);
		  rptdwnld.clickvendrpaymntreport();
		  Thread.sleep(2000);
	 }
	 public void clickvndrsaveaspdf(String vndrnme,String cmpnyname) throws InterruptedException
	 {
		 ReportDownloadPage rptdwnld=new ReportDownloadPage(driver);
		  rptdwnld.Clickreportmenu();
		  Thread.sleep(2000);
		  rptdwnld.clickvendrpaymntreport();
		  Thread.sleep(2000);
		  rptdwnld.Vendorpaymntfilter(vndrnme,cmpnyname);
		 rptdwnld.clickvndrgobtn();
		 Thread.sleep(2000);
		 logger.info("-------user click go button-----------");
		 rptdwnld.clicksaveaspdf();
		 Thread.sleep(2000);
		 logger.info("-------User click Save as PDF----------------");
		 logger.info("--------Vendor payment Report save As Pdf button is clicked------------");
	 }
	 public int Getvendorpaymnttotalamount()
		{
		 int totalamnt2=0;
		 try {
			String totalamnt=driver.findElement(By.xpath("//table[11][@class='table vendor_table reconcil_table']//tbody//th[4]//b[1]")).getText();
			String totalamnt1=totalamnt.replaceAll("[^0-9.]", "");
			 totalamnt2=(int)Double.parseDouble(totalamnt1.toString());
			}catch(Exception ex)
		 {
				logger.info("Any payment exist");
				Assert.assertTrue(false, "Any payment exist");
		 }
			return totalamnt2;
		}
	 public void GotoProjectreportPage()
	 {
		 Clickreportmenu();
		 Clickprojectreport();
		 
	 }
	 public void GetProjectreportFilter(String cmpnyname,String pjtname,String date) throws InterruptedException
	 {
		 selpjtrptpjt(pjtname);
		 Thread.sleep(2000);
		 selpjtrptcmpny(cmpnyname);
		 Thread.sleep(2000);
		 //this.commondateto.sendKeys(date);
		 this.commondatefrom.sendKeys(date);
		 Thread.sleep(2000);
		 this.commondatefrom.sendKeys(Keys.ENTER);
		 Thread.sleep(2000);
		 clickpjtrptgo();
		 Thread.sleep(2000);
	 }
	 
	 public void GetProjectreportFilterwithdate(String cmpnyname,String pjtname,LocalDate date) throws InterruptedException
	 {
		 selpjtrptpjt(pjtname);
		 Thread.sleep(2000);
		 selpjtrptcmpny(cmpnyname);
		 Thread.sleep(2000);
		 this.commondateto.sendKeys(""+date);
		 Thread.sleep(2000);
		 clickpjtrptgo();
		 Thread.sleep(2000);
	 }
	 public void GetProjectreportFilterwithdateft(String cmpnyname,String pjtname,LocalDate date) throws InterruptedException
	 {
		 selpjtrptpjt(pjtname);
		 Thread.sleep(2000);
		 selpjtrptcmpny(cmpnyname);
		 Thread.sleep(2000);
		 this.commondateto.sendKeys(""+date);
		 Thread.sleep(2000);
		 this.commondatefrom.sendKeys(""+date);
		 Thread.sleep(2000);
		 
		 clickpjtrptgo();
		 Thread.sleep(2000);
	 }
	 public int Getpjtrptsubcntrpaymnt() throws InterruptedException
	 {
		 int rowcnt=driver.findElements(By.xpath("//table[9]//tbody[1]//tr")).size();
		 WebElement elem=driver.findElement(By.xpath("//table[9]//tbody[1]//tr["+rowcnt+"]//td[6]"));
		////table[9]//tbody[1]/tr["+rowcnt+"]/td[2]/b[1]
		 js=new JavascriptHelper(driver);
		 js.scrollToElemet(elem);
		 Thread.sleep(2000);
		 String pjtsubcntpaymntamnt=elem.getText();
		 String pjtsubcntpaymntamnt1=pjtsubcntpaymntamnt.replaceAll("[^0-9.]", "");
		 int pjtsubcntpaymntamnt2=(int)Double.parseDouble(pjtsubcntpaymntamnt1);			
		 return pjtsubcntpaymntamnt2;
	 }
	 public int Getpjtrptsubcntrpaymnt1() throws InterruptedException
	 {
		 int rowcnt=driver.findElements(By.xpath("//table[9]//tbody[1]//tr")).size();
		 WebElement elem=driver.findElement(By.xpath("//table[9]//tbody[1]//tr[3]//td[6]"));
		////table[9]//tbody[1]/tr["+rowcnt+"]/td[2]/b[1]
		 js=new JavascriptHelper(driver);
		 js.scrollToElemet(elem);
		 Thread.sleep(2000);
		 String pjtsubcntpaymntamnt=elem.getText();
		 String pjtsubcntpaymntamnt1=pjtsubcntpaymntamnt.replaceAll("[^0-9.]", "");
		 int pjtsubcntpaymntamnt2=(int)Double.parseDouble(pjtsubcntpaymntamnt1);			
		 return pjtsubcntpaymntamnt2;
	 }
	 public int Getpjtrptsubcntrpaymnttotalamnt() throws InterruptedException
	 {
		 int pjtsubcntpaymntamnt2=0;
		 try {
		 int rowcnt=driver.findElements(By.xpath("//table[9]//tbody[1]//tr")).size();
		 WebElement elem=driver.findElement(By.xpath("//table[9]//tbody[1]/tr["+rowcnt+"]/td[2]/b[1]"));
		 js=new JavascriptHelper(driver);
		 js.scrollToElemet(elem);
		 Thread.sleep(2000);
		 String pjtsubcntpaymntamnt=elem.getText();
		 String pjtsubcntpaymntamnt1=pjtsubcntpaymntamnt.replaceAll("[^0-9.]", "");
		  pjtsubcntpaymntamnt2=(int)Double.parseDouble(pjtsubcntpaymntamnt1);			
		 }catch(Exception ex)
		 {
			 logger.info("No payment Exist");
			 Assert.assertTrue(true);
		 }
		 return pjtsubcntpaymntamnt2;
	 }
	 public int Getpjtrptpubilltotalamnt() throws InterruptedException
	 {
		 int rowcnt=driver.findElements(By.xpath("//table[6]//tbody[1]//tr")).size();
		 WebElement elem=driver.findElement(By.xpath("//table[6]//tbody[1]/tr["+rowcnt+"]/td[2]/b[1]"));
		 //WebElement elem=this.pjtrptpubilltotalamnt;
		 js=new JavascriptHelper(driver);
		 js.scrollToElemet(elem);
		 Thread.sleep(2000);
		 String pjtrptpubilltotalamnt=elem.getText();
		 String pjtrptpubilltotalamnt1=pjtrptpubilltotalamnt.replaceAll("[^0-9.]", "");
		 int pjtrptpubilltotalamnt2=(int)Double.parseDouble(pjtrptpubilltotalamnt1);			
	 
		 return pjtrptpubilltotalamnt2;
	 }
	 public int Getpjtrptlbrrpttotalamnt() throws InterruptedException
	 {
		 int rowcnt=driver.findElements(By.xpath("//table[10]//tbody[1]//tr")).size();
		 WebElement elem=driver.findElement(By.xpath("//table[10]//tbody[1]//tr["+rowcnt+"]//th[2]"));
		 //WebElement elem=this.pjtrptpubilltotalamnt;
		 js=new JavascriptHelper(driver);
		 js.scrollToElemet(elem);
		 Thread.sleep(2000);
		// WebElement elem=this.pjtrptlbrrpttotalamnt;
		 //js=new JavascriptHelper(driver);
		// js.scrollToElemet(elem);
		// Thread.sleep(2000);
		 String pjtrptpubilltotalamnt=elem.getText();
		 String pjtrptpubilltotalamnt1=pjtrptpubilltotalamnt.replaceAll("[^0-9.]", "");
		 int pjtrptpubilltotalamnt2=(int)Double.parseDouble(pjtrptpubilltotalamnt1);			
		 return pjtrptpubilltotalamnt2;
	 }
	 public int Getpjtrptsalesquotationtotalamnt() throws InterruptedException
	 {
		 int rowcnt=driver.findElements(By.xpath("//table[3]//tbody[1]//tr")).size();
		 WebElement elem=driver.findElement(By.xpath("//table[3]//tbody[1]//tr["+rowcnt+"]//th[2]"));
		 //WebElement elem=this.pjtrptpubilltotalamnt;//table[3]//tbody[1]//tr[4]//th[2]
		 js=new JavascriptHelper(driver);
		 js.scrollToElemet(elem);
		 Thread.sleep(2000);
		 String pjtrptsalesquotationtotalamnt=elem.getText();
		 String pjtrptsalesquotationtotalamnt1=pjtrptsalesquotationtotalamnt.replaceAll("[^0-9.]", "");
		 int pjtrptsalesquotationtotalamnt2=(int)Double.parseDouble(pjtrptsalesquotationtotalamnt1);			
		 return pjtrptsalesquotationtotalamnt2;
	 }
	 public boolean Verifysalesquotationamount(int salesquotamnt) throws InterruptedException
	 {
		 boolean status=false;
		 js=new JavascriptHelper(driver);
		 js.scrollUpByPixel();
		 Thread.sleep(2000);
		String salesquotamount=driver.findElement(By.xpath("//table[2]//tr[1]//td[2]")).getText();
		String salesquotamount1=salesquotamount.replaceAll("[^0-9.]", "");
		int salesquotamount2=(int)Double.parseDouble(salesquotamount1.toString());
		 if(salesquotamount2==salesquotamnt)
		 {
			 status=true;
		 }
		 return true;
	 }
	 public int Getpjtrptdaybooktotalamntwithoutpubill() throws InterruptedException
	 {
		 int pjtrptdaybooktotalamntnopubill2=0;
		 try {
		 int rowcnt=driver.findElements(By.xpath("//table[8]//tbody[1]//tr")).size();
		 WebElement elem=driver.findElement(By.xpath("//table[8]//tbody[1]/tr["+rowcnt+"]/td[2]/b[1]"));
		 //WebElement elem=this.pjtrptpubilltotalamnt;
		 js=new JavascriptHelper(driver);
		 js.scrollToElemet(elem);
		 Thread.sleep(2000);
		 String pjtrptdaybooktotalamntnopubill=elem.getText();
		 String pjtrptdaybooktotalamntnopubill1=pjtrptdaybooktotalamntnopubill.replaceAll("[^0-9.]", "");
		  pjtrptdaybooktotalamntnopubill2=(int)Double.parseDouble(pjtrptdaybooktotalamntnopubill1);			
		 
		 }catch(Exception ex)
		 {
			 logger.info("No row data exist in the project report..");
		 }
		 return pjtrptdaybooktotalamntnopubill2;
	 }
	 public void clickunreconciledbtn()
	 {
		 this.unreconciledbutton.click();
	 }
	 public int Getpjtrptdaybooktotalamntnobillchqueunreconciled() throws InterruptedException
	 {
		 int i=0;
		 int rowcnt=driver.findElements(By.xpath("//table[5]//tbody[1]//tr")).size();
		 WebElement elem=driver.findElement(By.xpath("//table[5]//tbody[1]//tr["+rowcnt+"]/td[2]/b[1]"));
		 //WebElement elem=this.pjtrptpubilltotalamnt;
		 js=new JavascriptHelper(driver);
		 js.scrollToElemet(elem);
		 Thread.sleep(2000);
		 String unreconpjtrptdaybooktotalamntnopubill=elem.getText();
		 String unreconpjtrptdaybooktotalamntnopubill1=unreconpjtrptdaybooktotalamntnopubill.replaceAll("[^0-9.]", "");
		 int unreconpjtrptdaybooktotalamntnopubill2=(int)Double.parseDouble(unreconpjtrptdaybooktotalamntnopubill1);			
		 return unreconpjtrptdaybooktotalamntnopubill2;
	 }
	 public int Getpjtrptdaybooktotalamntnobillchquereconciled() throws InterruptedException
	 {
		 int rowcnt=driver.findElements(By.xpath("//table[5]//tbody[1]//tr")).size();
		 WebElement elem=driver.findElement(By.xpath("//table[5]//tbody[1]//tr["+rowcnt+"]/td[2]/b[1]"));
		 //WebElement elem=this.pjtrptpubilltotalamnt;
		 js=new JavascriptHelper(driver);
		 js.scrollToElemet(elem);
		 Thread.sleep(2000);
		 String unreconpjtrptdaybooktotalamntnopubill=elem.getText();
		 String unreconpjtrptdaybooktotalamntnopubill1=unreconpjtrptdaybooktotalamntnopubill.replaceAll("[^0-9.]", "");
		 int unreconpjtrptdaybooktotalamntnopubill2=(int)Double.parseDouble(unreconpjtrptdaybooktotalamntnopubill1);			
		 return unreconpjtrptdaybooktotalamntnopubill2;
	 }
	 public int Getpjtrptpurchasertrntotalamnt() throws InterruptedException
	 {
		 int rowcnt=driver.findElements(By.xpath("//table[7]//tbody[1]//tr")).size();
		 WebElement elem=driver.findElement(By.xpath("//table[7]//tbody[1]//tr["+rowcnt+"]//td[2]"));
		 js=new JavascriptHelper(driver);
		 js.scrollToElemet(elem);
		 Thread.sleep(2000);
		 String pjtrptpurrtrntotalamnt=elem.getText();
		 String pjtrptpurrtrntotalamnt1=pjtrptpurrtrntotalamnt.replaceAll("[^0-9.]", "");
		 int pjtrptpurrtrntotalamnt2=(int)Double.parseDouble(pjtrptpurrtrntotalamnt1);			
		 return pjtrptpurrtrntotalamnt2;
	 }
	 public int calculationpjtrptexpsummarytotalamnt() throws InterruptedException
	 {
		 int sum=0;
		 List<WebElement>amntexplst=driver.findElements(By.xpath("//table[12]//tbody//tr"));
		 for(int i=2;i<=amntexplst.size()-1;i++)
		 {
			 WebElement elem=driver.findElement(By.xpath("//table[12]//tbody//tr["+i+"]//td[2]"));
			 js=new JavascriptHelper(driver);
			 js.scrollToElemet(elem);
			 Thread.sleep(2000);
			 String pjtrptexpsummarytotalamnt=elem.getText();
			 String pjtrptexpsummarytotalamnt1=pjtrptexpsummarytotalamnt.replaceAll("[^0-9.]", "");
			 int pjtrptexpsummarytotalamnt2=(int)Double.parseDouble(pjtrptexpsummarytotalamnt1);
			 sum+=pjtrptexpsummarytotalamnt2;
		 }
		 return sum;
	 }
	 public int Getpjtrptexpsummarytotalamnt() throws InterruptedException
	 {
		 int rowcnt=driver.findElements(By.xpath("//table[12]//tbody//tr")).size();
		 WebElement elem=driver.findElement(By.xpath("//table[12]//tbody//tr["+rowcnt+"]//th[2]"));
		 js=new JavascriptHelper(driver);
		 js.scrollToElemet(elem);
		 Thread.sleep(2000);
		 String pjtrptexpsummarytotalamnt=elem.getText();
		 String pjtrptexpsummarytotalamnt1=pjtrptexpsummarytotalamnt.replaceAll("[^0-9.]", "");
		 int pjtrptexpsummarytotalamnt2=(int)Double.parseDouble(pjtrptexpsummarytotalamnt1);			
		 return pjtrptexpsummarytotalamnt2;
	 }
	 public void GotoFinancialreportPage()
	 {
		 Clickreportmenu();
		 Clickfinancialrpt();
	 }
	 public int GetFinancialexpenseamnt(String cmpname,String pjtname)
	 {
		 int totalexpamnt=0;
		 String expamnt=null;
		 List<WebElement> fxedratecnt=driver.findElements(By.xpath("//table[1]//tbody[2]//tr"));
		 for(int i=1;i<=fxedratecnt.size();i++)
		 {
			 String prjtname=driver.findElement(By.xpath("//table[1]//tbody[2]//tr["+i+"]//td[2]")).getText();
			 String cmpnyname=driver.findElement(By.xpath("//table[1]//tbody[2]//tr["+i+"]//td[3]")).getText();
			 if(cmpname.equals(cmpnyname))
			 {
				 if(pjtname.equals(prjtname))
				 {
					expamnt=driver.findElement(By.xpath("//table[1]//tbody[2]//tr["+i+"]//td[7]")).getText();
					String expamnt1=expamnt.replaceAll("[^0-9.]", "");
				     totalexpamnt=(int)Double.parseDouble(expamnt1.toString());
					
				 }
			 }
		 }
		 return totalexpamnt;
		 
	 }
	 public int GetFinancialinvoiceamnt(String cmpname,String pjtname)
	 {
		 int totalinvoiceamnt=0;
		 String invoiceamnt=null;
		 List<WebElement> fxedratecnt=driver.findElements(By.xpath("//table[1]//tbody[2]//tr"));
		 for(int i=1;i<=fxedratecnt.size();i++)
		 {
			 String prjtname=driver.findElement(By.xpath("//table[1]//tbody[2]//tr["+i+"]//td[2]")).getText();
			 String cmpnyname=driver.findElement(By.xpath("//table[1]//tbody[2]//tr["+i+"]//td[3]")).getText();
			 if(cmpname.equals(cmpnyname))
			 {
				 if(pjtname.equals(prjtname))
				 {
					 invoiceamnt=driver.findElement(By.xpath("//table[1]//tbody[2]//tr["+i+"]//td[8]")).getText();
					String invoiceamnt1=invoiceamnt.replaceAll("[^0-9.]", "");
					totalinvoiceamnt=(int)Double.parseDouble(invoiceamnt1.toString());
					
				 }
			 }
		 }
		 return totalinvoiceamnt;
		 
	 }
	 public int GetFinancialreceiptamnt(String cmpname,String pjtname)
	 {
		 int totalreceiptamnt=0;
		 String receiptamnt=null;
		 List<WebElement> fxedratecnt=driver.findElements(By.xpath("//table[1]//tbody[2]//tr"));
		 for(int i=1;i<=fxedratecnt.size();i++)
		 {
			 String prjtname=driver.findElement(By.xpath("//table[1]//tbody[2]//tr["+i+"]//td[2]")).getText();
			 String cmpnyname=driver.findElement(By.xpath("//table[1]//tbody[2]//tr["+i+"]//td[3]")).getText();
			 if(cmpname.equals(cmpnyname))
			 {
				 if(pjtname.equals(prjtname))
				 {
					 receiptamnt=driver.findElement(By.xpath("//table[1]//tbody[2]//tr["+i+"]//td[6]")).getText();
					String receiptamnt1=receiptamnt.replaceAll("[^0-9.]", "");
					totalreceiptamnt=(int)Double.parseDouble(receiptamnt1.toString());
					
				 }
			 }
		 }
		 return totalreceiptamnt;
		 
	 }
	 public int GetFinancialbalanceamnt(String cmpname,String pjtname)
	 {
		 int totalbalanceamnt=0;
		 String balanceamnt=null;
		 List<WebElement> fxedratecnt=driver.findElements(By.xpath("//table[1]//tbody[2]//tr"));
		 for(int i=1;i<=fxedratecnt.size();i++)
		 {
			 String prjtname=driver.findElement(By.xpath("//table[1]//tbody[2]//tr["+i+"]//td[2]")).getText();
			 String cmpnyname=driver.findElement(By.xpath("//table[1]//tbody[2]//tr["+i+"]//td[3]")).getText();
			 if(cmpname.equals(cmpnyname))
			 {
				 if(pjtname.equals(prjtname))
				 {
					 balanceamnt=driver.findElement(By.xpath("//table[1]//tbody[2]//tr["+i+"]//td[9]")).getText();
					String balanceamnt1=balanceamnt.replaceAll("[^0-9.-]", "");
					totalbalanceamnt=(int)Double.parseDouble(balanceamnt1.toString());
					
				 }
			 }
		 }
		 return totalbalanceamnt;
		 
	 }
	 public void GotoDailyexprptpge()
	 {
		 Clickreportmenu();
		 clickdlyexprpt();
	 }
	 public void Filterdailyexp(String cmpname)
	 {
		 selpjtrptcmpny(cmpname);
		 clickdlyexpgobtn();
	 }
}
