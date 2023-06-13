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

public class VendorPage {
	WebDriver driver;
	Properties pr=new Properties();
	JavascriptHelper js;
	
	private final Logger logger=LoggerHelper.getLogger(VendorPage.class);
	ReportDownloadPage rptdwnld;
	public VendorPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//li//a[text()='Vendors']")public WebElement vendorsmenu;
	@FindBy(xpath = "//table//tbody//tr[1]//td[2]")public WebElement vendornames;
	@FindBy(xpath = "//li//a[text()='Vendor list']")public WebElement vendorslst;
	@FindBy(xpath = "//div//button[text()='Add Vendor']")public WebElement addvendor; 
	
	@FindBy(xpath="//*[@id='select2-vendor-results']//li[2]")public WebElement vendornmelst;
	@FindBy(xpath = "//*[@id='vendors-form']/div[1]/div[1]/div[1]/input[@name='Vendors[name]']")public WebElement vendorname;
	@FindBy(xpath="//input[@id='select_alltype']")public WebElement selallexpensetype;
	@FindBy(xpath="//*[@id='Vendors_gst_no']")public WebElement vendorgstno;
	
	@FindBy(xpath="//*[@id='Vendors_description']")public WebElement vendordescr;
	@FindBy(xpath="//*[@id='Vendors_address']")public WebElement vendoraddr;
	@FindBy(xpath="//*[@value='Create']")public WebElement vendorcreatebtn;
	@FindBy(xpath="//table[@id='vendortable']//tbody//tr[1]//td[9]//a")public WebElement vendoredit;
	@FindBy(xpath="//*[@id='vendors-form']/div[2]/input[1]")public WebElement vndrsavebtn;
	@FindBy(xpath = "//table[@id='vendortable']//tbody//tr[1]//td[2]")public WebElement editvndrnme;
	@FindBy(xpath="//li//a[text()='Vendor Payments']")public WebElement vndrpayment;
	@FindBy(xpath="//div[@class='clearfix']//button")public WebElement vndrpayaddentries;
	@FindBy(xpath="//*[@id='Dailyvendors_company_id']")public WebElement selvndrcmpny;
	@FindBy(xpath="//*[@id='Dailyvendors_project_id']")public WebElement selvndrpjt;
	 @FindBy(xpath="//*[@id='Dailyvendors_vendor_id']")public WebElement selvndrname;
	 @FindBy(xpath="//*[@id='Dailyvendors_payment_type']")public WebElement selpaytype;
	 @FindBy(xpath="//*[@id='Dailyvendors_bank']")public WebElement selbnknme;
	 @FindBy(xpath="//*[@id='Dailyvendors_cheque_no']")public WebElement ctypechkno;
	 @FindBy(xpath="//*[@id='Dailyvendors_amount']")public WebElement vndramnt;
	 @FindBy(xpath="//*[@id='Dailyvendors_description']")public WebElement vndrdescr;
	 @FindBy(xpath="//*[@id='buttonsubmit']")public WebElement vndrpaymntaddbtn;
	 @FindBy(xpath="//table//tbody[1]//tr//td[13]//span")public WebElement vndraction;
	 @FindBy(xpath="//*[@class='popover-content']//li//button[text()='Edit']")public WebElement vndrpaymntedit;
	 @FindBy(xpath="//div[@class='text-right submit-button']//div//button[1][text()='UPDATE']")public WebElement vndrupdatebtn;
	 @FindBy(xpath="//*[@class='popover-content']//li//button[text()='Delete']")public WebElement vndrdelete;
	
	 @FindBy(xpath="//li//a[text()='Vendor Payment Report']")public WebElement vndrpaymntrptlink;
	 @FindBy(xpath = "//body/div[1]/div[1]/div[2]/div[1]/div[1]/div[5]/div[1]/div[1]/div[2]/div[1]/label[1]/input[1]")public WebElement cmpnysearch;
	 @FindBy(xpath="//table//tbody[1]//tr[1]//td[1]")public WebElement vndrpaymnttranid;
	 @FindBy(xpath="//table//tbody[1]//tr[1]//td[8]")public WebElement vndrchqno;
	 @FindBy(xpath="//table//tbody//tr[1]//td[6]")public WebElement transactiontype;
	 @FindBy(xpath="//table//tbody[1]//tr[1]//td[9]")public WebElement vndrpaymnttbleamnt;
	 @FindBy(xpath="//table//tbody[1]//tr[1]//td[12]")public WebElement vndrpaidamnt;
	 
	 
	 @FindBy(xpath="//*[@id='vendor_id']")public WebElement selvendor;
	 @FindBy(xpath="//*[@id='company_id']")public WebElement selcompany;
	 @FindBy(xpath="//*[@value='GO']")public WebElement vndrgobtn;
	 
	 
	 @FindBy(xpath="//input[@type='search']")public WebElement searchvendor;
	 @FindBy(xpath="//a[@id='previous']")public WebElement previouslnk;
	 
	 @FindBy(xpath="//*[@id='Dailyvendors_date']")public WebElement vndrtabledate;
	 @FindBy(xpath="//*[@id='date_from']")public WebElement vndrreportfilterdate;
	public void clickvendorsmenu()
	{
		this.vendorsmenu.click();
	}
	public String Getvendorname()
	{
	String vendrname=vendornmelst.getText();
	return vendrname;
	}
	
	public void clickvendorslist()
	{
		this.vendorslst.click();
	}
	public void clickaddvendor()
	{
		this.addvendor.click();
	}
	public void typevendorname(String vendorname)
	{
		this.vendorname.clear();
		this.vendorname.sendKeys(vendorname);
	}
	public void clickallexpensetype()
	{
		this.selallexpensetype.click();
	}
	public void typevendorgst(String vendorgstno)
	{
		this.vendorgstno.sendKeys(vendorgstno);
	}
	public void typevndrdecsr(String vndrdescr)
	{
		this.vendordescr.sendKeys(vndrdescr);
	}
	public void typevndraddr(String vndraddr)
	{
		this.vendoraddr.sendKeys(vndraddr);
		
	}
	public void Clicklastcompany() throws InterruptedException//To chk chkbox of last company
	{	
		
		JavascriptHelper js=new JavascriptHelper(driver);
	js.scrollDownByPixel();
	Thread.sleep(2000);
		List<WebElement>cmpelm=driver.findElements(By.xpath("//*[@id='Vendors_company_id']//li//label"));
		int cmpelmcnt=cmpelm.size();
		WebElement cmpnme=driver.findElement(By.xpath("//*[@id='Vendors_company_id']//li["+cmpelmcnt+"]//input"));
		if(!cmpnme.isSelected())
		{
			cmpnme.click();
		}
				
	}
	public void clickvndrcreate() throws InterruptedException
	{
		this.vendorcreatebtn.click();
		Thread.sleep(2000);
	}
	//to get last vendorname
	public String Getlastvendorname()
	{
		List<WebElement>vndrlst=driver.findElements(By.xpath("//table//tbody//tr//td[2]"));
		int vndrlstcnt=vndrlst.size();
		WebElement elem=driver.findElement(By.xpath("//table//tbody//tr["+vndrlstcnt+"]//td[2]"));
		String vendorname=elem.getText();
		return vendorname;
	}
	public void clickvndredit()
	{
		this.vendoredit.click();
	}
	public void clickvendoredit(String vndrname) throws InterruptedException
	{
		List<WebElement>vndrlst=driver.findElements(By.xpath("//table[@id='vendortable']//tbody//tr//td[2]"));
		for(int i=1;i<=vndrlst.size();i++)
		{
		
			String vndrnme=driver.findElement(By.xpath("//table[@id='vendortable']//tbody//tr["+i+"]//td[2]")).getText();
			if(vndrname.equals(vndrnme))
			{
				WebElement elem=driver.findElement(By.xpath("//table[@id='vendortable']//tbody//tr["+i+"]//td[9]//a"));
				JavascriptHelper js=new JavascriptHelper(driver);
				js.scrollToElemet(elem);
				Thread.sleep(2000);
				elem.click();
				Thread.sleep(2000);
				
			}
		}
	}
	public void clickvndrsavebtn()
	{
		JavascriptHelper js =new JavascriptHelper(driver)  ;
		WebElement elem=this.vndrsavebtn;
		try {
			
		
		    js.executeScript("arguments[0].click();", elem);
			
		}catch(Exception ex)
		{
			js.scrollUpByPixel();
			 js.executeScript("arguments[0].click();", elem);
		}
	}
	
	public String Getvndrname()
	{
		String vndrname=this.editvndrnme.getText();
		return vndrname;
		
	}


	public void clickvndrpayment()
	{
		this.vndrpayment.click();
	}
	public void clickaddentries()
	{
		this.vndrpayaddentries.click();
	}
	public void selvndrcmpny(String cmpny)
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingVisibleText(this.selvndrcmpny, cmpny);
	}
	public void selvndrpjt(String project)
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingVisibleText(this.selvndrpjt, project);
	}
	public void selvndrname(String vndrname)
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingVisibleText(this.selvndrname, vndrname);
	}
	public void selcompany(String cmpnyname)
	{
		List<WebElement>cmpnames=driver.findElements(By.xpath("//*[@id='Vendors_company_id']//li//input"));
		for(int i=1;i<=cmpnames.size();i++)
		{
			String cmpname=driver.findElement(By.xpath("//*[@id='Vendors_company_id']//li["+i+"]//label")).getText();
			if(cmpname.equals(cmpnyname))
			{
				WebElement elem=driver.findElement(By.xpath("//*[@id='Vendors_company_id']//li["+i+"]//input"));
				
				if(elem.getAttribute("checked")==null)
				{
					elem.click();
				}
			}
		}
	}
	public void selpaymnttype()
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingIndex(this.selpaytype, 1);
	}
	public void selpaymnttypecash()
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingIndex(this.selpaytype, 2);
	}
	public void selpaymnttypecredit()
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingIndex(this.selpaytype, 3);
	}
	public void selbank(String bnknme)
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingVisibleText(this.selbnknme, bnknme);
	}
	public void typechkno(String chqno)
	{
		this.ctypechkno.sendKeys(chqno);
	}
	public void typeamnt()
	{
		this.vndramnt.clear();
		String amnt=RandomStringUtils.randomNumeric(2);
		if(amnt=="00")
		{
			this.vndramnt.sendKeys(""+90);
		}
		else
		{
			this.vndramnt.sendKeys(""+amnt);
		}
	}
	public void typedescription()
	{
		this.vndrdescr.sendKeys("-----vndr descr-------------");
	}
	public void clickaddbtn() throws InterruptedException
	{
		
		this.vndrpaymntaddbtn.click();
		Thread.sleep(2000);
	}
	public void clickvndraction()
	{
		this.vndraction.click();
	}
	public void clickvndrpayedit()
	{
		this.vndrpaymntedit.click();
	}
	public void clickupdatebtn() throws InterruptedException
	{
		JavascriptHelper js=new JavascriptHelper(driver);
		js.executeScript("arguments[0].click();",this.vndrupdatebtn);
		//this.vndrupdatebtn.click();
		Thread.sleep(2000);
	}
	public void clickdvndrpaymntelete()
	{
		this.vndrdelete.click();
	}
	public void Gotovendorlist()
	{
		clickvendorsmenu();
		clickvendorslist();
	}
	public void Gotovendorpayments()
	{
		VendorPage	vndrpge=new VendorPage(driver);
		clickvendorsmenu();
		clickvndrpayment();
	}
	public void typedate() throws InterruptedException
	{
		//	vndrpge=new VendorPage(driver);
		LocalDate date=java.time.LocalDate.now();
		this.vndrtabledate.clear();
		this.vndrtabledate.sendKeys(""+date);
		Thread.sleep(2000);
		this.vndrtabledate.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
	}
	public String getvendorname(String cmpname)
	{
		String vendorname = null;
		List<WebElement> cmpnames=driver.findElements(By.xpath("//table[@id='vendortable']//tbody//tr//td[3]"));
		for(int i=1;i<=cmpnames.size();i++)
		{
			String cmpnme=driver.findElement(By.xpath("//table[@id='vendortable']//tbody//tr["+i+"]//td[3]")).getText();
			if(cmpname.equals(cmpnme))
			{
				vendorname=driver.findElement(By.xpath("//table[@id='vendortable']//tbody//tr["+i+"]//td[2]")).getText();
				//break; 
			}
			
		}
		return vendorname;
	}
	public String Getchqno(String expcmpname,String expvndrname)
	{
		String chqno=null;
		List<WebElement> cmpnames=driver.findElements(By.xpath("//table//tbody//tr//td[2]"));
		for(int i=1;i<=cmpnames.size();i++)
		{
			String actvndrnme=driver.findElement(By.xpath("//table//tbody//tr["+i+"]//td[4]")).getText();
			String cmpnme=driver.findElement(By.xpath("//table//tbody//tr["+i+"]//td[2]")).getText();
			if(expcmpname.equals(cmpnme)&&expvndrname.equals(actvndrnme))
			{
				chqno=driver.findElement(By.xpath("//table//tbody//tr["+i+"]//td[8]")).getText();
				 break;
			}
			
		}
		return chqno;
	}
	public String Getamount(String expcmpname,String expvndrname)
	{
		String amount=null;
		List<WebElement> cmpnames=driver.findElements(By.xpath("//table//tbody//tr//td[3]"));
		for(int i=1;i<=cmpnames.size();i++)
		{
			String actvndrnme=driver.findElement(By.xpath("//table//tbody//tr["+i+"]//td[4]")).getText();
			String cmpnme=driver.findElement(By.xpath("//table//tbody//tr["+i+"]//td[2]")).getText();
			if(expcmpname.equals(cmpnme)&&expvndrname.equals(actvndrnme))
			{
				amount=driver.findElement(By.xpath("//table//tbody[1]//tr["+i+"]//td[9]")).getText();
				 break;
			}
			
		}
		return amount;
	}
	public void switchWindow()  {
		 // WebDriver drv = getDriver();
		  Set<String> handles = driver.getWindowHandles();
		  String current = driver.getWindowHandle();
		  if (handles.size() > 1) {
		    handles.remove(current);
		  }
		  String newTab = handles.iterator().next();
		  driver.switchTo().window(newTab);
		}
	public void Clickvendorcompany(String company)
	{
		List<WebElement>cmpnames=driver.findElements(By.xpath("//*[@id='Vendors_company_id']//li//input"));
		for(int i=1;i<=cmpnames.size();i++)
		{
			String cmpname=driver.findElement(By.xpath("//*[@id='Vendors_company_id']//li["+i+"]//label")).getText();
			if(cmpname.equals(company))
			{
				driver.findElement(By.xpath("//*[@id='Vendors_company_id']//li["+i+"]//input")).click();
			}
		}
	}
	public void serchcompany(String cmpnynme)
	{
		this.cmpnysearch.sendKeys(cmpnynme);
		this.cmpnysearch.sendKeys(Keys.ENTER);
	}
	public String Getvndrtranid()
	{
		String vndrpaymnttransactionid=vndrpaymnttranid.getText();
		return vndrpaymnttransactionid;
	}
	public String Getchequeno()
	{
		String vndrpaymntchqno=vndrchqno.getText();
		return vndrpaymntchqno;
	}
	public String transactiontype()
	{
		String transactiontype=this.transactiontype.getText();
		return transactiontype;
	}
	public String Getvndrpaymntamount()
	{
		
		String vndrpaymntamnt=this.vndrpaymnttbleamnt.getText();
		return vndrpaymntamnt;
	}
	public String Getvndrpaymntpaidamount()
	{
		
		String vndrpaymntpaidamnt=this.vndrpaidamnt.getText();
		return vndrpaymntpaidamnt;
	}
	public void GetVendorpaymntReport() throws InterruptedException
	{
		 rptdwnld=new ReportDownloadPage(driver);
		  rptdwnld.Clickreportmenu();
		  Thread.sleep(2000);
		  rptdwnld.clickvendrpaymntreport();
		  Thread.sleep(2000);
	}
	public String getvndorname(String cmpname) throws InterruptedException
	{
		String vendorname = null;
		clickvendorsmenu();
		Thread.sleep(2000);
		clickvendorslist();
		Thread.sleep(2000);
		String vndrnme=getvendorname(cmpname);
		return vndrnme;
	}
	public void selvendor(String vendorname)
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingVisibleText(this.selvendor, vendorname);
	}
	public void selcmpany(String cmpny)
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingVisibleText(this.selcompany, cmpny);
	}
	public void clickvendorgo()
	{
		this.vndrgobtn.click();
	}
	public void Getvendorpaymentreportfilter(String vendorname,String cmpname) throws InterruptedException
	{
		selvendor(vendorname);
		Thread.sleep(2000);
		selcmpany(cmpname);
		Thread.sleep(2000);
		clickvendorgo();
	}
	public void Getvendorpaymentreportfilterdte(String vendorname,String cmpname,LocalDate frmdate) throws InterruptedException
	{
		selvendor(vendorname);
		Thread.sleep(2000);
		selcmpany(cmpname);
		Thread.sleep(2000);
		Sendvndrdate(frmdate);
		clickvendorgo();
	}
	public void Sendvndrdate(LocalDate date) throws InterruptedException
	{
		//LocalDate todaydate=java.time.LocalDate.now();
		this.vndrreportfilterdate.clear();
		this.vndrreportfilterdate.sendKeys(""+date);
		Thread.sleep(2000);
		this.vndrreportfilterdate.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		this.vndrreportfilterdate.sendKeys(Keys.ENTER);
		
	}
	public void typesearchvendor(String vndornme)
	{
		this.cmpnysearch.sendKeys(vndornme);
	}
	public int Gettotalamountofvendorpayments(String cmpname,String vendorname) throws InterruptedException
	 { 
		// int totalsubcntrpaymntamnt2=0;
		clickvendorsmenu();
		Thread.sleep(2000);
		clickvndrpayment();
		Thread.sleep(2000);
		int sum=0;
		
		List<WebElement>cmpelem=driver.findElements(By.xpath("//table//tbody//tr//td[2]"));
		for(int i=1;i<=cmpelem.size();i++)
		{
			String actcmpname=null;
			String vndrnme=null;
			String amount=null;
			if(i==1)
			{
			 actcmpname=driver.findElement(By.xpath("//table//tbody[1]//tr["+i+"]//td[2]")).getText();
			 vndrnme=driver.findElement(By.xpath("//table//tbody[1]//tr["+i+"]//td[4]")).getText();
			 amount=driver.findElement(By.xpath("//table//tbody[1]//tr["+i+"]//td[7]")).getText();
			}
			if(i>1&i<=cmpelem.size())
			{
				 actcmpname=driver.findElement(By.xpath("//table//tbody[2]//tr["+(i-1)+"]//td[2]")).getText();
				 vndrnme=driver.findElement(By.xpath("//table//tbody[2]//tr["+(i-1)+"]//td[4]")).getText();
				 amount=driver.findElement(By.xpath("//table//tbody[2]//tr["+(i-1)+"]//td[7]")).getText();
			}
			if(cmpname.equals(actcmpname))
			{
				if(vendorname.equals(vndrnme))
				{
					String amount1=amount.replaceAll("[^0-9.]", "");
					int total=(int)Double.parseDouble(amount1.toString());
					sum+=total;
				}
			
			}
				
		}
		return  sum;
	 }
	public int Gettotalamountofvendorpayments1(String cmpname,String vendorname) throws InterruptedException
	 { 
		// int totalsubcntrpaymntamnt2=0;
		
		int sum=0;int total=0;
		String actcmpname;
		String vndrnme;
		String amount;
		try {
			
			List<WebElement>cmpelem=driver.findElements(By.xpath("//table//tbody//tr//td[2]"));
			for(int i=1;i<=cmpelem.size();i++)
			{
					if(i==1)
						{
				actcmpname=driver.findElement(By.xpath("//table//tbody[1]//tr["+i+"]//td[2]")).getText();
				 vndrnme=driver.findElement(By.xpath("//table//tbody[1]//tr["+i+"]//td[4]")).getText();
				 amount=driver.findElement(By.xpath("//table//tbody[1]//tr["+i+"]//td[7]")).getText();
				 	if(vendorname.equals(vndrnme))
				 		{
						String amount1=amount.replaceAll("[^0-9.]", "");
						 total=(int)Double.parseDouble(amount1.toString());
						Thread.sleep(2000);
						sum+=total;
				 		}
				  }
				else
				{
			String actcmpname1;
			String vndrnme1;
			String amount2;
				 actcmpname1=driver.findElement(By.xpath("//table//tbody[2]//tr["+(i-1)+"]//td[2]")).getText();
				 Thread.sleep(2000);
				 vndrnme1=driver.findElement(By.xpath("//table//tbody[2]//tr["+(i-1)+"]//td[4]")).getText();
				 Thread.sleep(2000);
				 amount2=driver.findElement(By.xpath("//table//tbody[2]//tr["+(i-1)+"]//td[12]")).getText();
				 Thread.sleep(2000);
				 if(cmpname.equals(actcmpname1))
					{
						if(vendorname.equals(vndrnme1))
						{
							String amount3=amount2.replaceAll("[^0-9.]", "");
							 total=(int)Double.parseDouble(amount2.toString());
							Thread.sleep(2000);
							sum+=total;
						}
					
					}
			}
			
		}
		
	}
		catch(Exception ex)
		{
			logger.info("no row exist");
			
		}	
		return  sum;
	 }
	

	public int Gettotalamountofvendorpayments2(String cmpname,String vendorname) throws InterruptedException
	 { 
		// int totalsubcntrpaymntamnt2=0;
		
		int sum=0;
		try {
		List<WebElement>cmpelem=driver.findElements(By.xpath("//table//tbody//tr//td[2]"));
		for(int i=1;i<=cmpelem.size();i++)
		{
			String actcmpname=null;
			String vndrnme=null;
			String amount=null;
			if(i==1)
			{
			 actcmpname=driver.findElement(By.xpath("//table//tbody[1]//tr["+i+"]//td[2]")).getText();
			 Thread.sleep(2000);
			 vndrnme=driver.findElement(By.xpath("//table//tbody[1]//tr["+i+"]//td[4]")).getText();
			 Thread.sleep(2000);
			 amount=driver.findElement(By.xpath("//table//tbody[1]//tr["+i+"]//td[12]")).getText();
			 Thread.sleep(2000);
			}
			if(i>1&i<=cmpelem.size())
			{
				 actcmpname=driver.findElement(By.xpath("//table//tbody[2]//tr["+(i-1)+"]//td[2]")).getText();
				 Thread.sleep(2000);
				 vndrnme=driver.findElement(By.xpath("//table//tbody[2]//tr["+(i-1)+"]//td[4]")).getText();
				 Thread.sleep(2000);
				 amount=driver.findElement(By.xpath("//table//tbody[2]//tr["+(i-1)+"]//td[12]")).getText();
				 Thread.sleep(2000);
			}
			if(cmpname.equals(actcmpname))
			{
				if(vendorname.equals(vndrnme))
				{
					String amount1=amount.replaceAll("[^0-9.]", "");
					int total=(int)Double.parseDouble(amount1.toString());
					Thread.sleep(2000);
					sum+=total;
				}
			
			}
				
		}
		}catch(Exception ex)
		{
			logger.info("no row exist");
			
		}
		return  sum;
	 }
	
	public int Gettotalamntvndrpaymnts(String cmpnynme,String vndrnme) throws InterruptedException
	{
	  int sum1=0;
		for(int i=1;i<=3;i++)
		{
			 sum1+=Gettotalamountofvendorpayments2(cmpnynme,vndrnme);
			 Thread.sleep(2000);
			 logger.info(sum1);
			 Thread.sleep(2000);
			 this.previouslnk.click();
			 Thread.sleep(2000);
		}
		return sum1;
		
	}
	public int Gettotalpurrtrnamnt()
	{
		int totalamnt=0;
		String totalpurrtrnamnt=null;
		try 
		{
		 totalpurrtrnamnt=driver.findElement(By.xpath("//table[7]//thead//tr[3]//th[2]")).getText();
		  String totalamnt1=totalpurrtrnamnt.replaceAll("[^0-9.]", "");
		  totalamnt=(int)Double.parseDouble(totalamnt1.toString());
		}
		catch(Exception ex)
		{
			logger.info("Amount is not listed here");
		}
		return totalamnt;
	}
	
	public void DeleteVendorPaymentsEntriesnew()
	 {
		AlertHelper alert;
		try 
		{
			
			
			List<WebElement>lstvndr=driver.findElements(By.xpath("//table[@id='fixTable']//tbody//tr"));
			int cnt=lstvndr.size();
			for(int i=1;i<=cnt;i++)
			{
				WebElement actionbtn=driver.findElement(By.xpath("//table[@id='fixTable']//tbody//tr["+i+"]//td[13]//span"));
				JavascriptHelper js=new JavascriptHelper(driver);
				js.executeScript("arguments[0].click();",actionbtn);
				Thread.sleep(2000);
				WebElement deletebtn=driver.findElement(By.xpath("//*[@class='popover-content']//ul//li//button[text()='Delete']"));
				 js=new JavascriptHelper(driver);
				js.executeScript("arguments[0].click();",deletebtn);
				Thread.sleep(2000);
					alert=new AlertHelper(driver);
					 String alerttxt=alert.getAlertText();
					 if(alerttxt.equals("Can't delete !Reconciled Entry"))
					 {
						 logger.info("cannot delete. it is reconciled entry!!");
						 alert.AcceptAlertIfPresent();
						 Thread.sleep(2000);
						 driver.navigate().refresh();
						 Thread.sleep(2000);
					 }
					 else 
					 {
						 alert.AcceptAlertIfPresent();
						 Thread.sleep(2000);
						 driver.navigate().refresh();
						 Thread.sleep(2000);
						 i=i-1;
						 cnt=cnt-1;
					 }
			}	 
		}catch(Exception ex)
		{
			logger.info("Something went wrong .deletion is not possible");
			}
		}
	
	public int Gettotalpurchrtrnamountfrmvndrrpt()
	{
		int vndramnt=0;
		String vendramount;
		try {
		WebElement elem=driver.findElement(By.xpath("//table[7]//thead//tr[3]//th[2]"));
		JavascriptHelper js=new JavascriptHelper(driver);
		js.scrollToElemet(elem);
		 vendramount=elem.getText();
		}
		catch(Exception ex)
		{
			 vendramount="0.00";
		}
	    String vendramount1=vendramount.replaceAll("[^0-9.]", "");
	    vndramnt=(int)Double.parseDouble(vendramount1.toString());
		return vndramnt;	
	}
	
	
	public int GetVendoramount_daybookdetailsfrmvndrrpt()
	{
		int vndramnt=0;
		String vendramount;
		try
		{
		WebElement elem=driver.findElement(By.xpath("//table[5]//tbody[1]//tr[1]//th[2]//b"));
		JavascriptHelper js=new JavascriptHelper(driver);
		js.scrollToElemet(elem);
		 vendramount=elem.getText();
		}
		catch(Exception ex)
		{
			vendramount="0.00";	
		}
	    String vendramount1=vendramount.replaceAll("[^0-9.]", "");
	    vndramnt=(int)Double.parseDouble(vendramount1.toString());
		return vndramnt;	
	}	
public int GetVendoramountfrmvndrrpt()
{
	int vndramnt=0;
	String vendramount;//="0.00";
	try {
	WebElement elem=driver.findElement(By.xpath("//table[3]//tbody[1]//tr[1]//th[2]//b"));
	JavascriptHelper js=new JavascriptHelper(driver);
	js.scrollToElemet(elem);
	 vendramount=elem.getText();
	}catch(Exception ex)
	{
		vendramount="0.00";
	}
    String vendramount1=vendramount.replaceAll("[^0-9.]", "");
    vndramnt=(int)Double.parseDouble(vendramount1.toString());
	return vndramnt;	
}
public int GetPaidtoVendoramount_dayboodetailsfrmvndrrpt()
{
	int paidtovndramnt=0;
	String paidtovendramount;
	try {
	WebElement elem=driver.findElement(By.xpath("//table[5]//tbody[1]//tr[1]//th[5]//b"));
	JavascriptHelper js=new JavascriptHelper(driver);
	js.scrollToElemet(elem);
	 paidtovendramount=elem.getText();
	}
	 catch(Exception ex)
	 {
		  paidtovendramount="0.00";
	 }
    String paidtovendramount1=paidtovendramount.replaceAll("[^0-9.]", "");
    paidtovndramnt=(int)Double.parseDouble(paidtovendramount1.toString());
	return paidtovndramnt;	
}
public int GetPaidtoVendoramountfrmvndrrpt()
{
	int paidtovndramnt=0;
	String paidtovendramount;
	try {
	WebElement elem=driver.findElement(By.xpath("//table[3]//tbody[1]//tr[1]//th[5]//b"));
	JavascriptHelper js=new JavascriptHelper(driver);
	js.scrollToElemet(elem);
	 paidtovendramount=elem.getText();
	}
	catch(Exception ex)
	{
		 paidtovendramount="0.00";
	}
    String paidtovendramount1=paidtovendramount.replaceAll("[^0-9.]", "");
    paidtovndramnt=(int)Double.parseDouble(paidtovendramount1.toString());
	return paidtovndramnt;	
}
public int GetBalancewithTDSDaybooksummaryamountfrmvndrrpt()
{
	int balancewithTDSamnt=0;
	String balanceamount;
	try {
	WebElement elem=driver.findElement(By.xpath("//table[3]//tbody[1]//tr[1]//th[6]//b"));
	JavascriptHelper js=new JavascriptHelper(driver);
	js.scrollToElemet(elem);
	 balanceamount=elem.getText();
	}
	catch(Exception ex)
	{
		balanceamount="0.00";
	}
	String balanceamount1=balanceamount.replaceAll("[^0-9.]", "");
    balancewithTDSamnt=(int)Double.parseDouble(balanceamount1.toString());
	return balancewithTDSamnt;	
}

public int GetBalancewithTDSDaybookdetailsamountfrmvndrrpt()
{
	int balancewithTDSamnt=0;
	String balanceamount;
	try {
	WebElement elem=driver.findElement(By.xpath("//table[5]//tbody[1]//tr[1]//th[6]//b"));
	JavascriptHelper js=new JavascriptHelper(driver);
	js.scrollToElemet(elem);
	 balanceamount=elem.getText();
	}
	catch(Exception ex)
	{
		 balanceamount="0.00";
	}
    String balanceamount1=balanceamount.replaceAll("[^0-9.]", "");
    balancewithTDSamnt=(int)Double.parseDouble(balanceamount1.toString());
	return balancewithTDSamnt;	
}
public void DeleteVendorPaymentsEntries1()
	 {
		AlertHelper alert;
		try 
		{
			
			List<WebElement>lstvndr=driver.findElements(By.xpath("//table[@id='fixTable']//tbody//tr"));
			for(int i=1;i<=lstvndr.size();i++)
			{
				if(i==1||i<=lstvndr.size())
				{
					driver.findElement(By.xpath("//table[@id='fixTable']//tbody//tr["+i+"]//td[13]//span")).click();
					driver.findElement(By.xpath("//*[@class='popover-content']//ul//li//button[text()='Delete']")).click();
					alert=new AlertHelper(driver);
					 String alerttxt=alert.getAlertText();
					 if(alerttxt.equals("Can't delete !Reconciled Entry"))
					 {
						 logger.info("cannot delete. it is reconciled entry!!");
						 alert.AcceptAlertIfPresent();
						 driver.navigate().refresh();
					 }
					 else 
					 {
						 alert.AcceptAlertIfPresent();
						 driver.navigate().refresh();
					 }
					 
				}
				else
				{
					int j=i-1;
					try {
						driver.findElement(By.xpath("//table[@id='fixTable']//tbody[2]//tr["+j+"]//td[13]//span")).click();
					}
					catch(Exception ex)
					{
						driver.findElement(By.xpath("//table[@id='fixTable']//tbody[2]//tr[1]//td[13]//span")).click();
					}
					driver.findElement(By.xpath("//*[@class='popover-content']//ul//li//button[text()='Delete']")).click();
					 alert=new AlertHelper(driver);
					 String alerttxt=alert.getAlertText();
					 if(alerttxt.equals("Can't delete !Reconciled Entry"))
					 {
						 logger.info("cannot delete. it is reconciled entry!!");
						 alert.AcceptAlertIfPresent();
						 driver.navigate().refresh();
					 }
					 else 
					 {
						 alert.AcceptAlertIfPresent();
						 driver.navigate().refresh();
					 }
					
				}
			}
		}
		catch(Exception ex)
		{
			logger.info("Something went wrong .deletion is not possible");
			}
		}

	public void DeleteVendorPaymentsEntries()
	 {
		AlertHelper alert;
		try 
		{
			
			List<WebElement>lstvndr=driver.findElements(By.xpath("//table[@id='fixTable']//tbody//tr"));
			for(int i=1;i<=lstvndr.size();i++)
			{
				if(i==1)
				{
					driver.findElement(By.xpath("//table[@id='fixTable']//tbody[1]//tr[1]//td[13]//span")).click();
					driver.findElement(By.xpath("//*[@class='popover-content']//ul//li//button[text()='Delete']")).click();
					alert=new AlertHelper(driver);
					 String alerttxt=alert.getAlertText();
					 if(alerttxt.equals("Can't delete !Reconciled Entry"))
					 {
						 logger.info("cannot delete. it is reconciled entry!!");
						 alert.AcceptAlertIfPresent();
						 driver.navigate().refresh();
					 }
					 else 
					 {
						 alert.AcceptAlertIfPresent();
						 driver.navigate().refresh();
					 }
					 
				}
				else if(i==lstvndr.size())
				{
					try {
					driver.findElement(By.xpath("//table[@id='fixTable']//tbody[1]//tr["+i+"]//td[13]//span")).click();
					}
					catch(Exception ex)
					{
						driver.findElement(By.xpath("//table[@id='fixTable']//tbody[2]//tr["+(i-1)+"]//td[13]//span")).click();
						//driver.findElement(By.xpath("//table[@id='fixTable']//tbody[2]//tr[1]//td[13]//span")).click();
					}
					driver.findElement(By.xpath("//*[@class='popover-content']//ul//li//button[text()='Delete']")).click();
					 alert=new AlertHelper(driver);
					 String alerttxt=alert.getAlertText();
					 if(alerttxt.equals("Can't delete !Reconciled Entry"))
					 {
						 logger.info("cannot delete. it is reconciled entry!!");
						 alert.AcceptAlertIfPresent();
						 driver.navigate().refresh();
					 }
					 else 
					 {
						 alert.AcceptAlertIfPresent();
						 driver.navigate().refresh();
					 }
				}
				else
				{
					int j=i-1;
					try {
						driver.findElement(By.xpath("//table[@id='fixTable']//tbody[2]//tr["+j+"]//td[13]//span")).click();
					}
					catch(Exception ex)
					{
						driver.findElement(By.xpath("//table[@id='fixTable']//tbody[2]//tr[1]//td[13]//span")).click();
					}
					driver.findElement(By.xpath("//*[@class='popover-content']//ul//li//button[text()='Delete']")).click();
					 alert=new AlertHelper(driver);
					 String alerttxt=alert.getAlertText();
					 if(alerttxt.equals("Can't delete !Reconciled Entry"))
					 {
						 logger.info("cannot delete. it is reconciled entry!!");
						 alert.AcceptAlertIfPresent();
						 driver.navigate().refresh();
					 }
					 else 
					 {
						 alert.AcceptAlertIfPresent();
						 driver.navigate().refresh();
					 }
				}
			}
		}
		catch(Exception ex)
		{
			logger.info("No element exist!!");
		}
	 }
public void Senddate1(LocalDate date) throws InterruptedException
	{
	this.vndrtabledate.clear();
	this.vndrtabledate.sendKeys(""+date);
	Thread.sleep(2000);
	this.vndrtabledate.sendKeys(Keys.ENTER);
	Thread.sleep(2000);
	this.vndrtabledate.sendKeys(Keys.ENTER);
	Thread.sleep(2000);
	}
public void Senddate2(String date) throws InterruptedException
{
this.vndrtabledate.clear();
this.vndrtabledate.sendKeys(""+date);
Thread.sleep(2000);
this.vndrtabledate.sendKeys(Keys.ENTER);
Thread.sleep(2000);

}
public int Gettotalamntvndrpaymntamnt(String cmpnyname,String pjtnme,String vndrnme,LocalDate fromdate) throws InterruptedException {
	WebElement cmpname,pjtname,vndrname,fromdte,purtype,retno;
	String cmpnynme,prjtnme,vendrnme,frmdate,purchtype,rtrnno;
	js=new JavascriptHelper(driver);
	List<WebElement>cmps=driver.findElements(By.xpath("//html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]//table[1]/tbody/tr/td[2]"));
	int rowcnt=cmps.size();
	String amount;
	int sum=0;
	int j=0;
	for(int i=1;i<=rowcnt;i++)
	{
		
		if(i==1)
		{
			j=1;
		
	cmpname=driver.findElement(By.xpath("//table//tbody["+j+"]//tr["+i+"]//td[2]"));
	js.scrollToElemet(cmpname);
	cmpnynme=cmpname.getText();
	Thread.sleep(2000);
	pjtname=driver.findElement(By.xpath("//table//tbody["+j+"]//tr["+i+"]//td[3]"));
	js.scrollToElemet(pjtname);
	prjtnme=pjtname.getText();
	Thread.sleep(2000);
	vndrname=driver.findElement(By.xpath("//table//tbody["+j+"]//tr["+i+"]//td[4]"));
	js.scrollToElemet(vndrname);
	vendrnme=vndrname.getText();
	Thread.sleep(2000);
	/*purtype=driver.findElement(By.xpath("//table//tbody["+j+"]//tr["+i+"]//td[21]"));
	js.scrollToElemet(purtype);
	purchtype=purtype.getText();
	Thread.sleep(2000);
	retno=driver.findElement(By.xpath("//table//tbody["+j+"]//tr["+i+"]//td[6]"));
	js.scrollToElemet(retno);
	rtrnno=retno.getText();*/
	fromdte=driver.findElement(By.xpath("//*[@id='Dailyvendors_date']"));
	frmdate=fromdte.getAttribute("value");
	Thread.sleep(2000);
		
	
			if(cmpnyname.equals(cmpnynme)&&pjtnme.equals(prjtnme)&&vndrnme.equals(vendrnme))//fromdate&&"17-08-2022".equals(frmdate)
				{
					WebElement amnt=driver.findElement(By.xpath("//table//tbody["+j+"]//tr["+i+"]//td[12]"));
					js.scrollToElemet(amnt);
					Thread.sleep(2000);
					amount=amnt.getText();
					String amount1=amount.replaceAll("[^0-9.]", "");
					Thread.sleep(2000);
					int amount2=(int)Double.parseDouble(amount1.toString());
					Thread.sleep(2000);
					sum+=amount2;
					Thread.sleep(2000);
				}
	
	}
		else {
			j=2;
			
			cmpname=driver.findElement(By.xpath("//table//tbody["+j+"]//tr["+(i-1)+"]//td[2]"));
			js.scrollToElemet(cmpname);
			cmpnynme=cmpname.getText();
			Thread.sleep(2000);
			pjtname=driver.findElement(By.xpath("//table//tbody["+j+"]//tr["+(i-1)+"]//td[3]"));
			js.scrollToElemet(pjtname);
			prjtnme=pjtname.getText();
			Thread.sleep(2000);
			vndrname=driver.findElement(By.xpath("//table//tbody["+j+"]//tr["+(i-1)+"]//td[4]"));
			js.scrollToElemet(vndrname);
			vendrnme=vndrname.getText();
			Thread.sleep(2000);
			/*purtype=driver.findElement(By.xpath("//table//tbody["+j+"]//tr["+(i-1)+"]//td[21]"));
			js.scrollToElemet(purtype);
			purchtype=purtype.getText();
			Thread.sleep(2000);
			retno=driver.findElement(By.xpath("//table//tbody["+j+"]//tr["+(i-1)+"]//td[6]"));
			js.scrollToElemet(retno);
			rtrnno=retno.getText();*/
			fromdte=driver.findElement(By.xpath("//*[@id='Dailyvendors_date']"));
			frmdate=fromdte.getAttribute("value");
			Thread.sleep(2000);
			
			if(cmpnyname.equals(cmpnynme)&&pjtnme.equals(prjtnme)&&vndrnme.equals(vendrnme))//fromdate&&"17-08-2022".equals(frmdate)
						{
							WebElement amnt=driver.findElement(By.xpath("//table//tbody["+j+"]//tr["+(i-1)+"]//td[12]"));
							js.scrollToElemet(amnt);
							Thread.sleep(2000);
							amount=amnt.getText();
							String amount1=amount.replaceAll("[^0-9.]", "");
							Thread.sleep(2000);
							int amount2=(int)Double.parseDouble(amount1.toString());
							Thread.sleep(2000);
							sum+=amount2;
							Thread.sleep(2000);
						}
	
		}
	}
	return sum;
}
//direct vendor payment table
public int Gettotalvndrpaymentamntfrmvndrrpt()
{
	
	int vndramnt=0;
	String vendramount;//="0.00";
	try {
	WebElement elem=driver.findElement(By.xpath("//table[11]//tbody[1]//tr[1]//th[4]//b[1]"));
	JavascriptHelper js=new JavascriptHelper(driver);
	js.scrollToElemet(elem);
	 vendramount=elem.getText();
	 }
	catch(Exception ex)
	{
		vendramount="0.00";
	}
    String vendramount1=vendramount.replaceAll("[^0-9.]", "");
    vndramnt=(int)Double.parseDouble(vendramount1.toString());
	return vndramnt;
	

}
//Overall summary table
public int Gettotalvndrpaymentamntfrmvndrrptoverallsummary()
{
	
	int vndramnt=0;
	WebElement elem=driver.findElement(By.xpath("//table[1]//tbody//tr[4]//td[5]"));
	JavascriptHelper js=new JavascriptHelper(driver);
	js.scrollToElemet(elem);
	String vendramount=elem.getText();
    String vendramount1=vendramount.replaceAll("[^0-9.]", "");
    vndramnt=(int)Double.parseDouble(vendramount1.toString());
	return vndramnt;

}
public int Gettotaldaybokinvoiceamntfrmvndrrpt_overallsummary()
{
	
	int vndramnt=0;
	String vendramount;
	try {
	WebElement elem=driver.findElement(By.xpath("//table[1]//tbody//tr[2]//td[2]"));
	JavascriptHelper js=new JavascriptHelper(driver);
	js.scrollToElemet(elem);
	 vendramount=elem.getText();
	}
	catch(Exception ex)
	{
		 vendramount="0.00";
	}
    String vendramount1=vendramount.replaceAll("[^0-9.]", "");
    vndramnt=(int)Double.parseDouble(vendramount1.toString());
	return vndramnt;

}
public int Gettotalpurrtrnamntfrmvndrrpt_overallsummary()
{
	
	int vndramnt=0;
	String vendramount;
	try {
	WebElement elem=driver.findElement(By.xpath("//table[1]//tbody//tr[3]//td[2]"));
	JavascriptHelper js=new JavascriptHelper(driver);
	js.scrollToElemet(elem);
	 vendramount=elem.getText();
	}
	catch (Exception e) {
		 vendramount="0.00";
	}
    String vendramount1=vendramount.replaceAll("[^0-9.]", "");
    vndramnt=(int)Double.parseDouble(vendramount1.toString());
	return vndramnt;

}
public int Getpaidtovndramntfrmvndrrpt_overallsummary()
{
	
	int vndramnt=0;
	String vendramount;
	try {
	WebElement elem=driver.findElement(By.xpath("//table[1]//tbody//tr[2]//td[5]"));
	JavascriptHelper js=new JavascriptHelper(driver);
	js.scrollToElemet(elem);
	 vendramount=elem.getText();
	}
	catch (Exception e) {
		 vendramount="0.00";
	}
    String vendramount1=vendramount.replaceAll("[^0-9.]", "");
    vndramnt=(int)Double.parseDouble(vendramount1.toString());
	return vndramnt;

}
public int Getactualbalance_overallsummary()
{
	int balanceamnt=0;
	String vendramount;
	try
	{
	WebElement elem=driver.findElement(By.xpath("//table[1]//tfoot//tr//th[6]"));
	JavascriptHelper js=new JavascriptHelper(driver);
	js.scrollToElemet(elem);
	 vendramount=elem.getText();
	}
	catch (Exception e) {
		 vendramount="0.00";
	}
    String vendramount1=vendramount.replaceAll("[^0-9.-]", "");
    balanceamnt=(int)Double.parseDouble(vendramount1.toString());
	return balanceamnt;
	
	
	}
}


/*DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;
String [] Date=displaydate.toString().split("[-]");
String day=Date[0].toString();
System.out.println("Day is "+day);
String month=Date[1].toString();
System.out.println("Month is "+month);
String year=Date[2].toString();
System.out.println("Year is "+year); 
Thread.sleep(2000);
System.out.println("Date is "+day+"-"+month+"-"+year); 
String displaydate1=day+"-"+month+"-"+year;
Thread.sleep(2000);
displaydate=year+"-"+month+"-"+day;

// formatter = DateTimeFormatter.ofPattern("dd-mm-YYYY"); 
//LocalDate date1=LocalDate.parse(displaydate);
// date1= LocalDate.parse(displaydate, formatter);
// System.out.println("Parsed date is " + "localdate : " + date1);

*/














