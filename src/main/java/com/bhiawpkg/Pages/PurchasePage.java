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

import com.BHIAW.Helper.AlertHelper;
import com.BHIAW.Helper.Dateselectionhelper;
import com.BHIAW.Helper.DropdownHelper;
import com.BHIAW.Helper.GenericHelper;
import com.BHIAW.Helper.JavascriptHelper;
import com.BHIAW.Helper.LoggerHelper;
import com.BHIAW.Helper.Radiobuttonhelper;
import com.BHIAW.Helper.Uploadhelper;

public class PurchasePage {
	WebDriver driver;
	Properties pr=new Properties();
	GenericHelper gh;
	PurchasePage puchpge;
	JavascriptHelper js=new JavascriptHelper(driver);
	private final Logger logger=LoggerHelper.getLogger(PurchasePage.class);
	@FindBy(xpath="//li//a[text()='Purchase']")public WebElement purchasemenu;
	@FindBy(xpath="//li//a[text()='Purchase Orders']")public WebElement purchaseorder;
	@FindBy(xpath="//li//a[text()='Purchase Bills']")public WebElement purchasebill;
	
	@FindBy(xpath="//a[text()='Add PO By Quantity']")public WebElement AddpoByQuantitybtn;
	@FindBy(xpath="//a[text()='Add PO by Width x Height']")public WebElement AddPoByWHbtn;
	@FindBy(xpath="//a[text()='Add PO by Length']")public WebElement AddPoByLength;
	@FindBy(xpath="//*[@id='projectid']")public WebElement popjtfilter;
	//*[@id='projectid']
	
	//------------------------------Purchase Item - Add/Edit
	@FindBy(xpath = "//*[@title='Choose Company']")public WebElement selcompany;
	@FindBy(xpath = "//*[@class='select2-search__field']")public WebElement searchvalue;
	@FindBy(xpath = "//*[@title='Select Project']")public WebElement selpurproject;
	@FindBy(xpath = "//*[@title='Select Expense Head']")public WebElement selexpensehead;
	@FindBy(xpath = "//*[@title='Choose Expense Head']")public WebElement chooseexphead;
	
	@FindBy(xpath = "//*[@title='Select Vendor']")public WebElement selvendor;
	@FindBy(xpath = "//*[@id='select2-expense_head-results']//li")public WebElement expensehead;
	@FindBy(xpath = "//*[@id='datepicker']")public WebElement date;
	@FindBy(xpath = "//*[@id='purchaseno']")public WebElement purchaseno;
	@FindBy(xpath = "//*[@id='contact_no']")public WebElement contactno;
	@FindBy(xpath = "//*[@id='shipping_address']")public WebElement shippingaddr;
	
	@FindBy(xpath = "/html/body/p")public WebElement podescription;
	//-------------PO-Edit
	@FindBy(xpath = "//table[@id='fixtable']//tbody[1]//tr[1]//td[16]//span")public WebElement poaction;
	@FindBy(xpath = "//*[@id='fixtable']/tbody[1]/tr/td[14]")public WebElement poedit;
	@FindBy(xpath = "//*[@class='popover-content']//li//button[text()='Edit']")public WebElement poeditbtn;
	@FindBy(xpath = "//*[@class='popover-content']//li//button[text()='Rate Approve']")public WebElement rateapprovebtn;
	@FindBy(xpath = "//*[@class='popover-content']//li//button[text()='Delete']")public WebElement podeletebtn;
	@FindBy(xpath = "//*[@class='popover-content']//li//button[text()='PO Edit']")public WebElement popopoveredit;
	
	@FindBy(xpath = "//*[@class='popover-content']//li//button[text()='View Bills']")public WebElement popopoverviewbills;
	//------purchase item
	@FindBy(xpath = "//*[@id='select2-description-container']")public WebElement selpoitm;
	@FindBy(xpath = "//*[@id='select_div']//select[@id='description']")public WebElement selpuitem;
	@FindBy(xpath = "//*[@id='quantity']")public WebElement puitmquantity;
	@FindBy(xpath = "//*[@id='purchase_quantity']")public WebElement billitmquantity;
	@FindBy(xpath = "//*[@id='previous_details']//div//button")public  WebElement closebtnpreviousdetails;
	@FindBy(xpath = "//input[@id='rate']")public WebElement rate;
	@FindBy(xpath = "//input[@id='dis_amount']")public WebElement discnt;
	@FindBy(xpath = "//input[@id='0']")public WebElement puitmsavebtn;
	
	@FindBy(xpath="//table[@id='fixtable']//tbody[1]//tr[1]//td[10]")public WebElement puchordrstatus;
	@FindBy(xpath="//table[@id='fixtable']//tbody[1]//tr[1]//td[10]//div")public WebElement draftstatus;
	@FindBy(xpath = "//table[@id='fixtable']//tbody[1]//tr[1]//td[10]")public WebElement savedstatus;
	@FindBy(xpath="//table[@id='fixtable']//tbody[1]//tr[1]//td[10]")public WebElement draftelem;
	//purchase bill
	@FindBy(xpath="//*[@class='add-btn pull-right']//a[text()='Add Bill']")public WebElement addbillbtn;
	@FindBy(xpath="//*[@class='add-btn pull-right']//a[text()='Add Bill Without PO']")public WebElement addbillwithoutpobtn;
	@FindBy(xpath = "//span[@id='select2-Bills_company_id-container']")public WebElement selcmpnybill;
	@FindBy(xpath = "//*[@class='select2-search__field']")public WebElement typeselvalue;
	@FindBy(xpath = "//*[@id='select2-Bills_purchase_id-container']")public WebElement clickpubill;
	@FindBy(xpath = "//*[@id='Bills_bill_number']")public WebElement typebillno;
	@FindBy(xpath = "//*[@id='select2-Warehousestock_warehousestock_warehouseid-container']")public WebElement clickwarehousedp;
	//purchase bill - Edit
	
	@FindBy(xpath = "//table[@id='fixtable']//tbody[1]//tr[1]//td[13]//span")public WebElement pubillaction;
	@FindBy(xpath = "//*[@class='popover-content']//li//a[text()='Edit']")public WebElement pubilledit;
	@FindBy(xpath = "//table[@id='fixtable']//tbody[1]//tr[1]//td[4]")public WebElement pubillno;
	@FindBy(xpath = "//table[@id='fixtable']//tbody[1]//tr[1]//td[5]")public WebElement pubillwhname;
	
	
	
	@FindBy(xpath="//input[@id='buttonsubmit']")public WebElement pubillcreatebutton ;
	@FindBy(xpath="//*[@id='biquantity0']")public WebElement quantity;
	@FindBy(xpath="//input[@id='buttonsubmit']")public WebElement pobilleditsavebtn;
	@FindBy(xpath="//*[@class='info']")public WebElement successmsg ;
	@FindBy(xpath = "//table[@id='main-table']/tbody/tr/td[2]")public WebElement specitm;
	@FindBy(xpath="//*[@class='popover-content']//li//button[text()='Edit']")public WebElement pobilledit;
	@FindBy(xpath="//table[@id='fixtable']//tbody[1]//tr[1]//td[4]")public WebElement pubill ;
	@FindBy(xpath="//table[@id='fixtable']//tbody[1]//tr[1]//td[8]")public WebElement pobillvndr;
	
	//purchase bill view
	@FindBy(xpath = "//*[@class='popover-content']//li//a[text()='View']")public WebElement pubillview;
	@FindBy(xpath="//a[text()='SAVE AS PDF']")public WebElement pubillsaveaspdf;
	@FindBy(xpath="//a[@id='download']")public WebElement pubillsaveasexcel;
	
	//purchase bill - without po
	@FindBy(xpath="//a[text()='Add Bill Without PO']")public WebElement addbillwithoutpo;
	@FindBy(xpath="//*[@id='company_id']")public WebElement selpocompany; 
	@FindBy(xpath="//*[@id='project']")public WebElement selpjtwithoutpo ; 
	@FindBy(xpath="//*[@id='expense_head']")public WebElement selexphead;
	@FindBy(xpath="//*[@id='vendor']")public WebElement selbillwithoutpovendor;
	@FindBy(xpath="//*[@id='Warehousestock_warehousestock_warehouseid']")public WebElement selbillwithoutpowarehouse ; 
	@FindBy(xpath="//*[@id='bill_number']")public WebElement billno;
	//@FindBy(xpath="//*[@id='description']")public WebElement withoutpobillitem ;
	@FindBy(xpath="//form//div[5]//div[2]//div[1]//div[1]//div[1]//div[1]//div//select")public WebElement withoutpobillitem ;
	
	@FindBy(xpath="//*[@id='purchase_quantity']")public WebElement withoutpobillqnty;
	@FindBy(xpath="//*[@id='purchase_rate']")public WebElement withoutpobillrate;
	@FindBy(xpath="//*[@value='Save']")public WebElement withoutpobillsavebtn ; 
	@FindBy(xpath="//*[@type='search']")public WebElement searchitm;
	 @FindBy(xpath = "//*[@id='purchaseitem_unit']")public WebElement selunit;
	 //Purchase Return
	 @FindBy(xpath="//li//a[text()='Purchase Return']")public WebElement purchasereturn;
	 @FindBy(xpath="//a[text()='Add Purchase Return']")public WebElement Addpurchasereturn;
	 @FindBy(xpath="//*[@id='PurchaseReturn_bill_id']")public WebElement pureturnbill;
	 @FindBy(xpath="//*[@id='fixtable']//tbody//tr[1]//td[4]")public WebElement puretbillno;
	 @FindBy(xpath="//*[@id='PurchaseReturn_return_number']")public WebElement retuno;
	 @FindBy(xpath="//table//tbody//tr//td[5]//input[@id='biquantity0']")public WebElement purreturnqnty;
	 @FindBy(xpath="//table//tbody//tr//td[7]//input[@id='birate0']")public WebElement purretrate; 
	 @FindBy(xpath="//*[@id='buttonsubmit']")public WebElement purreturncreatebtn;
	 @FindBy(xpath="//*[@id='PurchaseReturn_return_date']")public WebElement purretdate;
	 //previous purchase
	 @FindBy(xpath="//li//a[text()='Previous Purchase']")public WebElement previouspurchase; 
	 @FindBy(xpath="//*[@id='item_id']")public WebElement previouspurchaseitem;
	 @FindBy(xpath="//*[@id='vendor_id']")public WebElement previouspurchasevendor;
	 @FindBy(xpath="//*[@id='date_from']")public WebElement datefrom; 
	@FindBy(xpath=" //*[@id='date_to']")public WebElement dateto; 
	@FindBy(xpath="//*[@value='Go']")public WebElement Gobutton;
	@FindBy(xpath="//a[text()='SAVE AS EXCEL']")public WebElement prepursaveasexcel; 
	@FindBy(xpath="//a[text()='SAVE AS PDF']")public WebElement prepursaveaspdf; 
	//purchase bill- project report
	@FindBy(xpath = "//*[@id='Bills_company_id']")public WebElement pubillcmpny;
	@FindBy(xpath = "//*[@id='project_id']")public WebElement pubillpjt;
	@FindBy(xpath = "//*[@id='vendor_id']")public WebElement pubillvndor;
	@FindBy(xpath = "//*[@value='Go']")public WebElement pubillgobtn;
	@FindBy(xpath = "//*[@id='fixtable']//tbody//tr[1]//td[8]")public WebElement vndrname;
	//pubill delete
	@FindBy(xpath = "//a[text()='Delete Bill']")public WebElement deletebillbtn;
	@FindBy(xpath = "//*[@id='PurchaseReturn_return_number']")public WebElement selpurrtrnno;
	@FindBy(xpath = "//*[@id='delivery_date']")public WebElement expdelivrydate;
	/*
	@FindBy(xpath = "//*[@id='Expenses_projectid']")public WebElement selpjt;
	@FindBy(xpath = "")public WebElement
	@FindBy(xpath = "")public WebElement
	@FindBy(xpath = "")public WebElement
	@FindBy(xpath = "")public WebElement
	@FindBy(xpath = "")public WebElement*/
	
	
	@FindBy(xpath = "//*[@id='project']")public WebElement selpjt;
	public void selpjt(String pjtnme)
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingVisibleText(this.selpjt, pjtnme);
	}
	public PurchasePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickpurchasemenu()
	{
		this.purchasemenu.click();
		logger.info("----------click purchase menu--------------------");
	}
	public void clickpurchaseorders()
	{
		this.purchaseorder.click();
		logger.info("----------click purchase order--------------------");
	}
	public void clickaddPoByQuantity()
	{
		this.AddpoByQuantitybtn.click();
		logger.info("----------click Add PO By Quantity-------------------");
	}
	public void clickaddPoByLength()
	{
		this.AddPoByLength.click();
		logger.info("----------click Add PO By Length-------------------");
	}
	public void clickaddPoByWH()
	{
		this.AddPoByWHbtn.click();
		logger.info("----------click Add PO By widthandHeight-------------------");
	}
	
	public void typeusername(String uname) 
	{
	//	this.username.sendKeys(uname);
		logger.info("----------Username is getting------------");
	}
//------------------------------------purchase orders
	public void selpurcompany()
	{
		this.selcompany.click();
	}
	public void typevalue(String value) throws InterruptedException
	{
	
		GenericHelper gener=new GenericHelper();
		 gener.typevalueinsearch(this.searchvalue, value);
		// this.searchvalue.sendKeys(Keys.ENTER);
	}
	public void selpurproject()
	{
		this.selpurproject.click();
	}
	public void selpurchexpehead()
	{
		this.selexpensehead.click();
	}
	public void choosepurchexpehead()
	{
		this.chooseexphead.click();
	}
	public void selpurvendor()
	{
		this.selvendor.click();
	}
	public void typedate()
	{
		this.date.clear();
		LocalDate Today_date=java.time.LocalDate.now();
		  this.date.sendKeys(""+Today_date);
		this.date.sendKeys(Keys.ENTER);
		
	}
	public void typedelivrydate()
	{
		this.expdelivrydate.clear();
		LocalDate Today_date=java.time.LocalDate.now();
		  this.expdelivrydate.sendKeys(""+Today_date);
		this.expdelivrydate.sendKeys(Keys.ENTER);
	}
	public void typepurchaseno(String pno)
	{
		this.purchaseno.click();
		this.purchaseno.sendKeys(pno);
	}
	public void typecontno(String contno)
	{
		this.contactno.clear();
		this.contactno.sendKeys(contno);
	}
	public void typeaddr(String shippingaddr)
	{
		this.shippingaddr.click();
		this.shippingaddr.sendKeys(shippingaddr);
		this.shippingaddr.sendKeys(Keys.ENTER);
	}
	public void typepodescription(String descr)
	{
		this.podescription.sendKeys(descr);
	}
	//---------------------Edit
	public void clickpoactionmenu()
	{
		this.poaction.click();
	}
	public void clickpoeditbtn()
	{
		this.poeditbtn.click();
	}
	public void clickpoitem()
	{
		//this.puitmselect.click();
	}
	public void selectpoitm()
	{
		DropdownHelper dpselpoitm=new DropdownHelper(driver);
		dpselpoitm.SelectUsingIndex(selpuitem, 1);
	}
	public void typepuitmquantity(String quantity)
	{
		this.puitmquantity.sendKeys(quantity);
	}
	public void typepuitmquantitynobill(String quantity)
	{
		this.billitmquantity.sendKeys(quantity);
	}
	public void  clickprreviousclosebtn() {
		this.closebtnpreviousdetails.click();
		
	}
	public void typerate(String rate)
	{
		this.rate.sendKeys(rate);
	}
	public void typediscount(String discnt)
	{
		this.discnt.sendKeys(discnt);
	}
	public void clickpuitmsavebtn()
	{
		this.puitmsavebtn.click();
	}
	//Approve
	public String Getpostatus() throws InterruptedException
	{
		String status=puchordrstatus.getText();
		Thread.sleep(2000);
		return status;
	}
	public void Clickrateapprove()
	{
		this.rateapprovebtn.click();
	}
	public void clickdraftstatus()
	{
		this.draftstatus.click();
	}
	
	public String Getpodstatus()
	{
		String status=draftstatus.getText();
		return status;
	}
	public boolean Getelementstatus()
	{
		GenericHelper gh=new GenericHelper();
	
		boolean draftelm=gh.isAttribtuePresent(draftelem, "class");
		
		return draftelm;
	}
	public void clickpurchasebill()
	{
		this.purchasebill.click();
	}
	public void clickaddbill()
	{
		this.addbillbtn.click();
	}
	public void clickaddbillwithoutpo()
	{
		this.addbillwithoutpo.click();
	}
	public String Getposavedstatus()
	{
		String status=savedstatus.getText();
		return status;
	}
	public void clickselcmpnybill()
	{
		this.selcmpnybill.click();
	}
	public void typeselcmpny(String cmpny) 
	{
		 gh=new GenericHelper();
		 gh.typevalueinsearch(this.typeselvalue, cmpny);
		// this.typeselvalue.sendKeys(cmpny);
	}
	public void clickpubill()
	{
		this.clickpubill.click();
	}
	public void typeselbill(String pubill)
	{
		 gh=new GenericHelper();
		 gh.typevalueinsearch(this.typeselvalue, pubill);
	}
	public void typebillno(String bilno)
	{
	this.typebillno.sendKeys(bilno);
	}
	public void typewarehsename(String whnme)
	{
		gh=new GenericHelper();
		gh.typevalueinsearch(typeselvalue, whnme);
		//this.typeselvalue.sendKeys(Keys.ENTER);
	}
	public void clickpubillaction()
	{
		this.pubillaction.click();
	}
	public void clickpubilledit()
	{
		this.pubilledit.click();
	}
	public void clickselwarehouse()
	{
		this.clickwarehousedp.click();
	}
	public void clickpubillcreatebutton()
	{
		this.pubillcreatebutton.click();
	}
	public void typequantity(String qntity) throws InterruptedException
	{
		this.quantity.sendKeys(qntity);
		Thread.sleep(2000);
		this.quantity.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	}
	public void clickpoeditsavebtn()
	{
		this.pobilleditsavebtn.click();
	}
	public String Getsucessmsg()
	{
		String sucessmsg=this.successmsg.getText();
		return sucessmsg;
	}
	public String Getpubillno()
	{
		return this.pubillno.getText();
	}
	public String Getpubillwarehouse()
	{
		return this.pubillwhname.getText();
	}
	public String Getpubillvendorname()
	{
		return this.pobillvndr.getText();
	}
	public String Getspecitm()
	{
		return this.specitm.getText();
	}
	public void clickpobilledit()
	{
		this.pobilledit.click();
	}
	public String Getlastpubillno()
	{
		String billno=this.pubillno.getText();
		return billno;
	}
	public void clickadbillwithoutpo()
	{
		this.addbillwithoutpo.click();
	}
	public void selpowithoutpocmpny(String cmpny)
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingVisibleText(this.selpocompany, cmpny);
	}
	public void selpowithoutpopjt(String project)
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingVisibleText(this.selpjtwithoutpo, project);
	}
	public void selpowithoutpoexphead()
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingIndex(this.selexphead, 2);
	}
	public void selpowithoutpoexphead1(String exphead)
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingVisibleText(this.selexphead, exphead);
	}
	public void selpowithoutpoexphead2()
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingIndex(this.selexphead, 2);
	}
	public void selpowithoutpovndr(String vendor)
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingVisibleText(this.selbillwithoutpovendor, vendor);
	}
	public void selpowithoutpowarehse(String whse)
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingVisibleText(this.selbillwithoutpowarehouse, whse);
	}
	public void typebillno() throws InterruptedException
	{
		this.billno.sendKeys("bilno"+RandomStringUtils.randomNumeric(3));
		this.billno.sendKeys(Keys.ENTER);
		//Thread.sleep(2000);
	}
	public void selitmwithoutpo() throws InterruptedException
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		Thread.sleep(2000);
		dpsel.SelectUsingIndex(this.withoutpobillitem, 1);
		Thread.sleep(2000);
	}
	public void clickitmwithoutpo()
	{
		this.withoutpobillitem.click();
		

	}
	public void typeqnty(String qnty)
	{
		this.withoutpobillqnty.sendKeys(qnty);
	}
	public void typewithoutpobillrate(String rate)
	{
		this.withoutpobillrate.sendKeys(rate);
	}
	public void clickwithoutpobillsave()
	{
		this.withoutpobillsavebtn.click();
	}
	public void typeitem(String item) throws InterruptedException
	{
	
		GenericHelper gener=new GenericHelper();
		 gener.typevalueinsearch(this.searchitm, item);
		// this.searchvalue.sendKeys(Keys.ENTER);
	}
	public void selunits(String unit)
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingVisibleText(this.selunit, unit);
	}
	public void clickpurchasereturn()
	{
		this.purchasereturn.click();
	}
	public void clickpurchaseaddreturn()
	{
		this.Addpurchasereturn.click();
	}
	public void selpurchaseretbill(String billno)
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingVisibleText(this.pureturnbill, billno);
	}
	public String Getpurretbillno()
	{
		String billno=this.puretbillno.getText();
		return billno;
	}
	public String Getpurretsecondbillno()
	{
		WebElement elem=driver.findElement(By.xpath("//*[@id='fixtable']//tbody//tr[2]//td[4]"));
		String billno=elem.getText();
		return billno;
	}
	public String Getpurretthirdbillno()
	{
		WebElement elem=driver.findElement(By.xpath("//*[@id='fixtable']//tbody//tr[3]//td[4]"));
		String billno=elem.getText();
		return billno;
	}
	public void typreturnno()
	{
		this.retuno.sendKeys("retno"+RandomStringUtils.randomNumeric(2));
		this.retuno.sendKeys(Keys.ENTER);
	}
	public void typreturnqnty() throws InterruptedException
	{
		//this.purreturnqnty.click();
		//Thread.sleep(2000);
		
		this.purreturnqnty.sendKeys("1");
	}
	public void typreturnrate()
	{
		this.purretrate.sendKeys("100");
	}
	public void clickpurreturncreatebtn()
	{
		this.purreturncreatebtn.click();
	}
	public void typepurretdate()
	{
		LocalDate todaydate=java.time.LocalDate.now();
		this.purretdate.sendKeys(""+todaydate);
		this.purretdate.sendKeys(Keys.ENTER);
	}
	public void clickpubillview()
	{
		this.pubillview.click();
	}
	public void clickpubillsavepdf()
	{
		this.pubillsaveaspdf.click();
	}
	public void clickpubillsaveexcel()
	{
		this.pubillsaveasexcel.click();
	}
	//previous purchase
	public void clickpreviouspurchase() 
	{
		this.previouspurchase.click();
	}
	public void seitemprevpurchse()
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingIndex(previouspurchaseitem, 1);
		
	}
	public void selprevpurchsevendor(String vndr)
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingVisibleText(previouspurchasevendor, vndr);
		
	}
	public void typedatefrm()
	{
		/*
		WebElement elem1=driver.findElement(By.xpath("//*[@id='date_from']"));
		 js.executeScript("arguments[0].removeAttribute('readonly','readonly')",elem1);
		  driver.findElement(By.xpath("//*[@id='date_from']")).clear();
		  LocalDate Today_date=java.time.LocalDate.now();
		   elem1.sendKeys(""+Today_date);*/
		LocalDate todaydate=java.time.LocalDate.now();
		this.datefrom.sendKeys(""+todaydate);
	}
	public void typedateto()
	{
		/*WebElement elem1=driver.findElement(By.xpath("//*[@id='date_to'']"));
		 js.executeScript("arguments[0].removeAttribute('readonly','readonly')",elem1);
		  driver.findElement(By.xpath("//*[@id='date_to'']")).clear();
		  LocalDate Today_date=java.time.LocalDate.now();
		   elem1.sendKeys(""+Today_date);*/
		LocalDate todaydate=java.time.LocalDate.now();
		this.dateto.sendKeys(""+todaydate);
	}
	public void clickgobtn()
	{
		this.Gobutton.click();
	}
	public void clicksaveaspdf()
	{
		this.prepursaveaspdf.click();
	}
	public void clicksaveasexcel()
	{
		this.prepursaveasexcel.click();
	}
	public String Getpubillno1() throws InterruptedException
	{
		 puchpge=new PurchasePage(driver);
		 puchpge.clickpurchasemenu();																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																									
		 logger.info("------click purchase Menu-----------");
		 Thread.sleep(2000);
		 logger.info("------click purchase Orders--------------------------");
		 puchpge.clickpurchasebill();
		 logger.info("------click purchase Bill--------------------------");
		 String lastbillno=Getlastpubillno();
		 Thread.sleep(2000);
		 String lastbillvndr=Getpubillvendorname();
		 Thread.sleep(2000);
		 return lastbillno;
	}
	public String Getpubillvndrname() throws InterruptedException
	{
		puchpge=new PurchasePage(driver);
		 puchpge.clickpurchasemenu();																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																									
		 logger.info("------click purchase Menu-----------");
		 Thread.sleep(2000);
		 logger.info("------click purchase Orders--------------------------");
		 puchpge.clickpurchasebill();
		 logger.info("------click purchase Bill--------------------------");
		 String lastbillvndr=Getpubillvendorname();
		 Thread.sleep(2000);
		 return lastbillvndr;
	}
	//purchase bill in project report
	public void selpubillcmpny(String cmpny)
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingVisibleText(this.pubillcmpny, cmpny);
	}
	public void selpubillpjt(String pjt)
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingVisibleText(this.pubillpjt, pjt);
	}
	public void selpuorderpjt(String pjt)
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingVisibleText(this.popjtfilter, pjt);
	}
	
	public void selpubillvendor(String vndorname)
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingVisibleText(this.pubillvndor, vndorname);
	}
	
	public void Getpubillfilter(String cmpny,String pjt,String vndrnme,LocalDate fromdate,LocalDate todate) throws InterruptedException
	{
		selpubillcmpny(cmpny);
		Thread.sleep(2000);
		selpubillpjt(pjt);
		selpubillvendor(vndrnme);
		typedatefrom(fromdate);
		typetodate(todate);
		clickgobtn();
	}
	public void Getpuorderfilter(String cmpny,String pjt,LocalDate fromdate) throws InterruptedException
	{
		selpowithoutpocmpny(cmpny);
		Thread.sleep(2000);
		selpuorderpjt(pjt);
		typedatefrom(fromdate);
		clickgobtn();
	}
	 public int Gettotalamountofpubill(String cmpname)
	 { 
		// int totalsubcntrpaymntamnt2=0;
		clickpurchasemenu();
		clickpurchasebill();
		int sum=0;
		List<WebElement>cmpelem=driver.findElements(By.xpath("//table//tbody//tr//td[6]"));
		for(int i=1;i<=cmpelem.size();i++)
		{
			String actcmpname=driver.findElement(By.xpath("//table//tbody//tr["+i+"]//td[6]")).getText();
			String amount=driver.findElement(By.xpath("//table//tbody//tr["+i+"]//td[12]")).getText();
			if(cmpname.equals(actcmpname))
			{
			String amount1=amount.replaceAll("[^0-9.]", "");
			int total=(int)Double.parseDouble(amount1.toString());
			sum+=total;
			
			}
			
		}
		return  sum;
	 }
	 public void typedatefrom(LocalDate fromdate) throws InterruptedException
	 {
		// LocalDate fromdate=java.time.LocalDate.now();
		 this.datefrom.click();////*[@id='date_from']
		 this.datefrom.sendKeys(""+fromdate);
		 this.datefrom.sendKeys(Keys.ENTER);
		 Thread.sleep(2000);
	 }
	 public void typetodate(LocalDate todate)
	 {
		 //LocalDate todate=java.time.LocalDate.now();
		 this.dateto.click();
		 this.dateto.sendKeys(""+todate);
	 }
	 public void Gotopubill()
	 {
		 clickpurchasemenu();
		 clickpurchasebill();
	 }
	 public void GotoPurchaseOrders()
	 {
		 clickpurchasemenu();
		 clickpurchaseorders();
	 }
	public boolean Verifybillno(String billno) {
		boolean status=false;
		List<WebElement>billnos=driver.findElements(By.xpath("//table//tbody//tr//td[4]"));
		for(int i=1;i<=billnos.size();i++)
		{
			String bilno=driver.findElement(By.xpath("//table//tbody//tr["+i+"]//td[4]")).getText();
			if(billno.equals(bilno))
			{
				status=true;
			}
		}
		return status;
	}
	public int Getpurchasereturnamount(String billno)
	{
		int purrtnamnt2=0;
		List<WebElement> amntlst=driver.findElements(By.xpath("//table//tbody//tr"));
		int rowcnt=amntlst.size();
		for(int i=1;i<=rowcnt;i++)
		{
			String billnumber=driver.findElement(By.xpath("//table//tbody//tr["+rowcnt+"]//td[3]")).getText();
			if(billnumber.equals(billno))
			{
				String purrtnamnt=driver.findElement(By.xpath("//table//tbody//tr["+rowcnt+"]//td[8]")).getText();
				String purrtnamnt1=purrtnamnt.replaceAll("[^0-9.]", "");
				 purrtnamnt2=(int)Double.parseDouble(purrtnamnt1.toString());
			}
		}
		
		return purrtnamnt2;
	}
	public int Gettotalpurrtnamnt()
	{
		int totalamount2=0;
		List<WebElement> amntlst=driver.findElements(By.xpath("//table//tfoot//tr"));
		int rowcnt=amntlst.size();
		String totalamount=driver.findElement(By.xpath("//table//tfoot//tr["+rowcnt+"]//th[8]")).getText();
		String totalamount1=totalamount.replaceAll("[^0-9.]", "");
		 totalamount2=(int)Double.parseDouble(totalamount1.toString());
		return totalamount2;
		
	}
	//*[@id='fixtable']//tbody//tr[1]//td[8]
	public String Getvendorname()
	{
		String vndrnme=this.vndrname.getText();
		return vndrnme;
	}
	public int Getpurchasereturntotalamnt() throws InterruptedException
	{ 
		js=new JavascriptHelper(driver);
		js.scrollDownByPixel();
		Thread.sleep(2000);
		int totalamnt2=0;
		List<WebElement> lstpurrtn=driver.findElements(By.xpath("//table[7]//thead[1]//tr"));
		int rowcnt=lstpurrtn.size();
		for(int i=1;i<=rowcnt;i++)
		{
			WebElement elem=driver.findElement(By.xpath("//table[7]//thead[1]//tr["+rowcnt+"]//th[2]"));
			
			js.scrollToElemet(elem);
			
			String totalamnt=elem.getText();
			String totalamnt1=totalamnt.replaceAll("[^0-9.]", "");
			 totalamnt2=(int)Double.parseDouble(totalamnt1.toString());
		}
		return totalamnt2;
	}
	public String Getreturnno(String billno) {
		String returnno=null;
		boolean retrnno=false;
		try 
		{
			//int a;	
		
		 while(!retrnno)
			{
			 List<WebElement>lst=driver.findElements(By.xpath("//table//tbody//tr"));
			 js=new JavascriptHelper(driver);
			 js.scrollDownByPixel();
			 Thread.sleep(2000);
			for(int i=1;i<=lst.size();i++)
				 {
					String billnumber=driver.findElement(By.xpath("//table//tbody//tr["+i+"]//td[3]")).getText();
					if(billno.equals(billnumber))
					{
						WebElement rtrnelm=driver.findElement(By.xpath("//table//tbody//tr["+i+"]//td[4]"));
						returnno=rtrnelm.getText();
						retrnno=true;
						break;
					}
					if(i==lst.size())
					{
						try {
							 boolean status=false;
							 status=driver.findElement(By.xpath("//li//a[text()='Next >']")).isDisplayed();
							if(status==true)
							{
								driver.findElement(By.xpath("//li//a[text()='Next >']")).click();
							}
						}
						catch (Exception e) {
							// TODO: handle exception
						}
					}
				 }
			  
			/*	js=new JavascriptHelper(driver);
				js.scrollDownByPixel();
				Thread.sleep(2000);
				WebElement nextelem=driver.findElement(By.xpath("//li//a[text()='Next >']"));
				new Actions(driver).moveToElement(nextelem).build().perform();
				Thread.sleep(2000);
				nextelem.click();
				Thread.sleep(2000);*/
			  }
			}
		catch (Exception e) 
		{
		// TODO: handle exception
		logger.info("no elements present!!");								
		}
		return returnno;
	}
	//Delete PO
	
	public void clickpodeletebtn()
	{
		this.podeletebtn.click();
	}
	public void clickpopoverpoedit()
	{
		this.popopoveredit.click();
	}
	public void clickpopoverviewbills()
	{
		this.popopoverviewbills.click();
	}
	
	public void clickdeletebillbtn()
	{
		this.deletebillbtn.click();
	}
	public boolean Getsavedstatus()
	{
		boolean savedstatus=false;
		String statustxt=driver.findElement(By.xpath("//table[@id='fixtable']//tbody[1]//tr[1]//td[10]")).getText();
		if(statustxt.equals("Saved"))
		{
			savedstatus=true;
		}
		return savedstatus;
	}
	public void DeletePurchaseOrders(String cmpnme,String pjtnme) throws InterruptedException
	{
		js=new JavascriptHelper(driver);
		try {
		List<WebElement> lstpos=driver.findElements(By.xpath("//*[@id='fixtable']//tbody//tr"));
		//for(int i=1;i<=lstpos.size();i++)
		for(int j=1;j<=lstpos.size();j++)
		{
			int i=1;
		/*	if(j==1)
			{
			 i=1;
			
			}
			else
			{
				//j=j-1;
				i=1;
			}
			if(j==lstpos.size())
			{
				j=1;
			}*/
		if(j==1||j==lstpos.size())
		{
			String cmpname=driver.findElement(By.xpath("//*[@id='fixtable']//tbody[1]//tr["+i+"]//td[3]")).getText();
			String pjtname=driver.findElement(By.xpath("//*[@id='fixtable']//tbody[1]//tr["+i+"]//td[4]")).getText();
			String postatus=driver.findElement(By.xpath("//table[@id='fixtable']//tbody[1]//tr["+i+"]//td[10]")).getText();
			String billingstatus=driver.findElement(By.xpath("//table[@id='fixtable']//tbody[1]//tr["+i+"]//td[13]")).getText();
			if(cmpname.equals(cmpnme)&&pjtname.equals(pjtnme))
			{
				if(billingstatus.equals("Fully Billed"))
				{
					driver.findElement(By.xpath("//table[@id='fixtable']//tbody[1]//tr["+i+"]//td[14]//span")).click();
					clickpopoverpoedit();
					Thread.sleep(2000);
					clickdeletebillbtn();
					Thread.sleep(2000);
					AlertHelper alert=new AlertHelper(driver);
					alert.AcceptAlertIfPresent();
					Thread.sleep(2000);
					//((Navigation) driver).back();
					driver.navigate().to("http://stagev2.agacinteriors.xyz/index.php?r=purchase/admin");
					Thread.sleep(2000);
					driver.findElement(By.xpath("//table[@id='fixtable']//tbody[1]//tr["+i+"]//td[14]//span")).click();
					clickpodeletebtn();
					Thread.sleep(2000);
					 alert=new AlertHelper(driver);
					alert.AcceptAlertIfPresent();
					Thread.sleep(2000);
					//i=i-1;
				}
				else if(billingstatus.equals("PO not issued"))
				{
					driver.findElement(By.xpath("//table[@id='fixtable']//tbody[1]//tr["+i+"]//td[14]//span")).click();
					Thread.sleep(2000);
					clickpodeletebtn();
					Thread.sleep(2000);
					AlertHelper alert=new AlertHelper(driver);
					alert.AcceptAlertIfPresent();
					Thread.sleep(2000);
				}
				else if(postatus.equals("Approval needed"))
				{
					driver.findElement(By.xpath("//table[@id='fixtable']//tbody[1]//tr["+i+"]//td[14]//span")).click();
					Thread.sleep(2000);
					clickpodeletebtn();
					Thread.sleep(2000);
				}
				else if(postatus.equals("Saved")||billingstatus.equals("Pending to be Billed"))
				{
					logger.info("Deletion  is not possibile .pending to be billed");
					
				}
				else if(postatus.equals("Draft"))
				{
					driver.findElement(By.xpath("//table[@id='fixtable']//tbody[1]//tr["+i+"]//td[14]//span")).click();
					Thread.sleep(2000);
					//clickpopoverpoedit();
					//Thread.sleep(2000);
					clickpodeletebtn();
					Thread.sleep(2000);
					AlertHelper alert=new AlertHelper(driver);
					alert.AcceptAlertIfPresent();
					Thread.sleep(2000);
					driver.navigate().to("http://stagev2.agacinteriors.xyz/index.php?r=purchase/admin");
					Thread.sleep(2000);
					
				}
				else
				{
					driver.findElement(By.xpath("//table[@id='fixtable']//tbody[1]//tr["+i+"]//td[14]//span")).click();
					Thread.sleep(2000);
					clickpopoverpoedit();
					Thread.sleep(2000);
					clickdeletebillbtn();
					Thread.sleep(2000);
					AlertHelper alert=new AlertHelper(driver);
					alert.AcceptAlertIfPresent();
					Thread.sleep(2000);
					driver.navigate().to("http://stagev2.agacinteriors.xyz/index.php?r=purchase/admin");
					Thread.sleep(2000);
					clickpoactionmenu();
					Thread.sleep(2000);
					clickpodeletebtn();
					Thread.sleep(2000);
				}
			
			}
		
		}
		else
		{
			
			WebElement cmpelem,pjtelem,postatuselem,billstatuselem;
			js.scrollDownByPixel();
			cmpelem=driver.findElement(By.xpath("//*[@id='fixtable']//tbody[2]//tr["+i+"]//td[3]"));
			js.scrollToElemet(cmpelem);
			String cmpname=cmpelem.getText();
			pjtelem=driver.findElement(By.xpath("//*[@id='fixtable']//tbody[2]//tr["+i+"]//td[4]"));
			js.scrollToElemet(pjtelem);
			String pjtname=pjtelem.getText();
			postatuselem=driver.findElement(By.xpath("//table[@id='fixtable']//tbody[2]//tr["+i+"]//td[10]"));
			js.scrollToElemet(postatuselem);
			String postatus=postatuselem.getText();
			billstatuselem=driver.findElement(By.xpath("//table[@id='fixtable']//tbody[2]//tr["+i+"]//td[13]"));
			js.scrollToElemet(billstatuselem);
			String billingstatus=billstatuselem.getText();
			if(cmpname.equals(cmpnme)&&pjtname.equals(pjtnme))
			{
				if(billingstatus.equals("Fully Billed"))
				{
					driver.findElement(By.xpath("//table[@id='fixtable']//tbody[2]//tr["+i+"]//td[14]//span")).click();
					clickpopoverpoedit();
					Thread.sleep(2000);
					clickdeletebillbtn();
					Thread.sleep(2000);
					AlertHelper alert=new AlertHelper(driver);
					alert.AcceptAlertIfPresent();
					Thread.sleep(2000);
					driver.navigate().to("http://stagev2.agacinteriors.xyz/index.php?r=purchase/admin");
					Thread.sleep(2000);
					driver.findElement(By.xpath("//table[@id='fixtable']//tbody[2]//tr["+i+"]//td[14]//span")).click();
					clickpodeletebtn();
					Thread.sleep(2000);
					 alert=new AlertHelper(driver);
					alert.AcceptAlertIfPresent();
					Thread.sleep(2000);
					//i=i-1;
				}
				else if(billingstatus.equals("PO not issued"))
				{
					driver.findElement(By.xpath("//table[@id='fixtable']//tbody[2]//tr["+i+"]//td[14]//span")).click();
					clickpodeletebtn();
					Thread.sleep(2000);
					AlertHelper alert=new AlertHelper(driver);
					alert.AcceptAlertIfPresent();
					Thread.sleep(2000);
				}
				else if(postatus.equals("Approval needed"))
				{
					driver.findElement(By.xpath("//table[@id='fixtable']//tbody[2]//tr["+i+"]//td[14]//span")).click();
					Thread.sleep(2000);
					clickpodeletebtn();
					Thread.sleep(2000);
				}
				else if(postatus.equals("Saved")||billingstatus.equals("Pending to be Billed"))
				{
					logger.info("Deletion  is not possibile .pending to be billed");
					
				}
				else if(postatus.equals("Draft"))
				{
					driver.findElement(By.xpath("//table[@id='fixtable']//tbody[2]//tr["+i+"]//td[14]//span")).click();
					Thread.sleep(2000);
					//clickpopoverpoedit();
					//Thread.sleep(2000);
					clickpodeletebtn();
					Thread.sleep(2000);
					AlertHelper alert=new AlertHelper(driver);
					alert.AcceptAlertIfPresent();
					Thread.sleep(2000);
					driver.navigate().to("http://stagev2.agacinteriors.xyz/index.php?r=purchase/admin");
					Thread.sleep(2000);
					
				}
				else
				{
					driver.findElement(By.xpath("//table[@id='fixtable']//tbody[2]//tr["+i+"]//td[14]//span")).click();
					Thread.sleep(2000);
					clickpopoverpoedit();
					Thread.sleep(2000);
					clickdeletebillbtn();
					Thread.sleep(2000);
					AlertHelper alert=new AlertHelper(driver);
					alert.AcceptAlertIfPresent();
					Thread.sleep(2000);
					driver.navigate().to("http://stagev2.agacinteriors.xyz/index.php?r=purchase/admin");
					Thread.sleep(2000);
					clickpoactionmenu();
					Thread.sleep(2000);
					clickpodeletebtn();
					Thread.sleep(2000);
				}
			}
			
		}
	}
	
		}
		catch(Exception ex)
		{
			logger.info("Purchase order does not exist");
		}
	
}
	public String  getpubilltodelete()
	{
		String billno=driver.findElement(By.xpath("//form[1]/div[4]/table[1]/tbody[1]/tr[1]/td[2]")).getText();
		return billno;
	}
	public void Gotopurchasereturn() throws InterruptedException
	{
		PurchasePage puchpge=new PurchasePage(driver);
		clickpurchasemenu();
		Thread.sleep(2000);
		clickpurchasereturn();
		Thread.sleep(2000);
		
	}
	public String Getpurrtrnbillno()
	{
		String billno=null;
		boolean status=false;
		try 
		{
			List<WebElement>purrtrnbillno=driver.findElements(By.xpath("//table//tbody//tr//td[3]"));
			for(int i=1;i<=purrtrnbillno.size();i++)
			{
				billno=driver.findElement(By.xpath("//table//tbody//tr["+i+"]//td[3]")).getText();
				if(!billno.isEmpty()) 
				{
					status=true;
					break;
				}
				
			}
		}
		catch (Exception e)
		{
			logger.info("No data present in the purchase return table...");
		}
		return billno;
	}
	public boolean Verifybillnowithvndrnme(String vndrname,String billno)
	{
		boolean status=false;
		String vndrnme=null;
		try {
			
			List<WebElement> pno=driver.findElements(By.xpath("//table//tbody//tr//td[4]"));
			for(int i=1;i<=pno.size();i++)
			{
				
			    String vndrnme1= driver.findElement(By.xpath("//table//tbody//tr["+i+"]//td[8]")).getText();
			    String billnum=driver.findElement(By.xpath("//table//tbody//tr["+i+"]//td[4]")).getText();
			    if(vndrname.equals(vndrnme1)&&billno.equals(billnum))
			    {
			    	status=true;
			    	break;
			    }
			    if(i==pno.size())
				{
			    	
					WebElement nxtelem=driver.findElement(By.xpath("//ul[@id='yw3']//li//a[text()='Next >']"));
					if(nxtelem.isDisplayed())
					{
						js=new JavascriptHelper(driver);
						js.scrollDownByPixel();
						
						nxtelem.click();
						
					}
				}
		   } 
		}
		catch (Exception e)
		{
			logger.info("no elements present in the purchase order table");
		}
		return status;
		
	}
	public void searchpurrtrnno(String rtrnno)
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingVisibleText(this.selpurrtrnno, rtrnno);
	}
	//************************13-01-2023***************************
	@FindBy(xpath="//li//a[text()='Material Requisition']")public WebElement materialrequisition;
	@FindBy(xpath="//*[@id='MaterialRequisition_requisition_project_id']")public WebElement selpjtformaterialreq;
	@FindBy(xpath="//table//tbody//tr	//td[7]//a[2]")public WebElement ADDPObtn;
	@FindBy(xpath="//button[text()='Save']")public WebElement Savebtn;
	
	
	@FindBy(xpath="//*[@id='po_number']")public WebElement selpo;
	
	public void clickmaterialrequisition()
	{
		this.materialrequisition.click();
	}
	public void selpjtformaterialreq(String pjtmatreq)
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingVisibleText(this.selpjtformaterialreq, pjtmatreq);
	}
	public void clickaddPObtn()
	{
		this.ADDPObtn.click();
		logger.info("----click ADD PO button--------");
	}
	public void selpurchaseno(String PO)
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingVisibleText(this.selpo, PO);
	}
	public void clicksavebutton()
	{
		this.Savebtn.click();
		logger.info("---click the save button----");
	}
}

















