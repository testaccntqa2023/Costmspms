package com.bhiawpkg.Pages;


import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bhiawpkg.Config.Config;
import com.BHIAW.Helper.JavascriptHelper;
import com.BHIAW.Helper.LoggerHelper;

public class CompanyPage {
	WebDriver driver;
	Properties pr=new Properties();
	JavascriptExecutor e ;
	Config con=new Config(pr);
	Masterpage mstr;
	
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
	public void clickaddcompany() throws InterruptedException
	{
		WebElement elem=this.settingsaddcmpny;
		JavascriptExecutor e =(JavascriptExecutor)driver;
        e.executeScript("arguments[0].click();", elem);
		this.settingsaddcmpny.click();
		Thread.sleep(2000);
		logger.info("--------------user click add company-------------------");
	}
	public void typecompanynme(String cmpname)
	{
		
		this.companynme.sendKeys(cmpname);
		logger.info("-----------type company name---------------");
	}
	public void typecmpnypincode(String cmppincode)
	{
		this.cmpnypincode.sendKeys(cmppincode);
		logger.info("---------type company code----------------");
	}
	public void typecmpnyphone(String cmpphone)
	{
		this.companyphone.sendKeys(cmpphone);
		logger.info("---------type company phone----------------");
	}
	public void typecmpnyemail(String cmpnyemail)
	{
		this.companyemailid.sendKeys(cmpnyemail);
		logger.info("---------type company email----------------");
	}
	public void typecmpnyGSTno(String cmpnygstno)
	{
		this.companygst.sendKeys(cmpnygstno);
		logger.info("---------type company GST no----------------");
	}
	public void typecmpnytolerance(String cmpnytolerance)
	{
		this.companytolerance.sendKeys(cmpnytolerance);
		logger.info("---------type company tolerance----------------");
	}
	public void typesubcntrpaylmt(String subcntrpaylmt)
	{
		this.companysubcntrlimit.sendKeys(subcntrpaylmt);
		logger.info("---------type sub contractor payment limit----------------");
	}
	public void clickcmpnypopermission()
	{
		WebElement elem=this.compnypopermission;
		JavascriptExecutor e =(JavascriptExecutor)driver;
        e.executeScript("arguments[0].click();", elem);
		//this.compnypopermission.click();;
		logger.info("---------click PO Permission---------------");
	}
	public void clickcmpnyautopoderno()
	{
		WebElement elem=this.companypurchaseorderno;
		JavascriptExecutor e =(JavascriptExecutor)driver;
        e.executeScript("arguments[0].click();", elem);
		//this.compnypopermission.click();;
		logger.info("---------click auto Purchase order no---------------");
	}
	public void typecmppurchseamnt(String cmppurchseamnt)
	{
		this.companysubcntrlimit.sendKeys(cmppurchseamnt);
		logger.info("---------type company purchase amount----------------");
	}
	public void clicksubcntremailnotification()
	{
	    //con=new Config(pr);
		//*[@id='Clients_company_id']//li//label[contains(text(),"BHICompany")]
		String subcntremailnot=con.Getcompanyusername();
		
		//-------------------------------------
		WebElement chkbox=driver.findElement(By.xpath("//*[@class='col-md-6']//ul[@class='checkboxList']//span[@id='Company_subco_email_userid']//li//label[text()="+subcntremailnot+"]"));
		 if (!chkbox.isSelected()) {
		        JavascriptExecutor e =(JavascriptExecutor)driver;
		        e.executeScript("arguments[0].click();", chkbox);
		       //Checking whether first attempt to check the check box worked
		        
		        if (!chkbox.isSelected()) {
		        	chkbox.click();
		        }
		    }
		logger.info("-----------click subcontractor email notification user----------------");
	 
	}
	public void clickPOemailnotification()
	{
		 con=new Config(pr);
		//*[@id='Clients_company_id']//li//label[contains(text(),"BHICompany")]
		String poemailnot=con.Getcompanyusername();
		WebElement chkbox=driver.findElement(By.xpath("//*[@class='col-md-6']//ul[@class='checkboxList']//span[@id='Company_po_email_userid']//li//label[text()=poemailnot]"));
		 if (!chkbox.isSelected()) {
		        JavascriptExecutor e =(JavascriptExecutor)driver;
		        e.executeScript("arguments[0].click();", chkbox);
		       // Checking whether first attempt to check the check box worked
		       // if (!chkbox.isSelected()) {
		        	chkbox.click();
		       // }
		    }
		logger.info("-----------click user fro PO email notification ----------------");
	}
	public void typedescription(String cmpnydesc)
	{
		this.compnydescr.sendKeys(cmpnydesc);
		logger.info("------type company description-------------------");
	}
	public void typecmpnyaddress(String cmpnyaddr)
	{
		this.compnyaddress.sendKeys(cmpnyaddr);
		logger.info("------type company address-------------------");
	}
	public void clickinvoiceemailnot()
	{
		con=new Config(pr);
		String invoiceemailnot=con.Getcompanyusername();
		WebElement chkbox=driver.findElement(By.xpath("//*[@class='col-md-6']//ul[@class='checkboxList']//span[@id='Company_invoice_email_userid']//li//label[text()=invoiceemailnot]"));
		 if (!chkbox.isSelected()) {
		        JavascriptExecutor e =(JavascriptExecutor)driver;
		        e.executeScript("arguments[0].click();", chkbox);
		         	chkbox.click();
		     
		    }
		logger.info("-----------click user fro PO email notification ----------------");
	}
	public void clickcmpnycreatebtn()
	{
		WebElement elem=this.compnycreatebtn;
		JavascriptExecutor e =(JavascriptExecutor)driver;
        e.executeScript("arguments[0].click();", elem);
		logger.info("------click company create button---------------");
	}
	public String getlastcmpnyname()
	 {
		 List<WebElement>elem=driver.findElements(By.xpath("//table//tbody//tr//td[2]"));
		 int cmpcnt=elem.size();
		 String companyname=driver.findElement(By.xpath("//table//tbody//tr["+cmpcnt+"]//td[2]")).getText();
		 return companyname;
	 }
	public String Getselecmpnynme(String username) throws InterruptedException
	{
		mstr=new Masterpage(driver);
		 mstr.clicksettingsmenu();
		 Thread.sleep(2000);
		 logger.info("----------user click settings-----------");
		 mstr.clicksettingsusers();
		 List<WebElement>userlist=driver.findElements(By.xpath("//table//tbody//tr"));
		 String companyname=null;
		 for(int i=1;i<=userlist.size();i++)
		 {
			 
			 String usernme=driver.findElement(By.xpath("//table//tbody//tr["+i+"]//td[2]")).getText();
			 if(username.equals(usernme))
			 {
				 driver.findElement(By.xpath("//table//tbody//tr["+i+"]//td[10]//a[1]")).click();
				 List<WebElement>cmpnames=driver.findElements(By.xpath("//*[@id='Users_company_id']//li"));
				 for(int j=1;j<=cmpnames.size();j++)
				 {
					// if(companyname.equals(cmpname))
					// {
						 WebElement elem=driver.findElement(By.xpath("//*[@id='Users_company_id']//li["+j+"]//input"));
						 if(elem.isSelected())
						 {
							 companyname=driver.findElement(By.xpath("//*[@id='Users_company_id']//li["+j+"]//label")).getText();
							// break;
						 }
					 //}
				 }
			 }
			 //driver.findElement(By.xpath("//*[@value='Save']")).click();
			
		 }
		return companyname;
		
	}
	public String Getcompanyname() throws InterruptedException
	{
		mstr=new Masterpage(driver);
		 mstr.clicksettingsmenu();
		 Thread.sleep(2000);
		 logger.info("----------user click settings-----------");
		 clickcompany();
		 Thread.sleep(2000);
		 logger.info("----------user click company-----------");
		 String cmpnyname=getlastcmpnyname();
		 Thread.sleep(2000);
		 System.out.println("company name "+cmpnyname);
		 Thread.sleep(2000);
		 return cmpnyname;
		
	}
	public String getlastcmpnyname1()
	 {
		
		 CompanyPage cmpnypge=new CompanyPage(driver);
		 cmpnypge.clickcompany();
		 logger.info("----------user click company-----------");
		 List<WebElement>elem=driver.findElements(By.xpath("//table//tbody//tr//td[2]"));
		 int cmpcnt=elem.size();
		 String companyname=driver.findElement(By.xpath("//table//tbody//tr["+cmpcnt+"]//td[2]")).getText();
		 return companyname;
	 }
	
	public void typecmpnyexp()
	{
		WebElement elem=driver.findElement(By.xpath("//*[@id='Company_expenses_percentage']"));
		Actions builder = new Actions(driver);
		 builder.moveToElement(elem).build().perform();
		this.compnyexp.sendKeys("20");
	}
	public void clicksubcontremailnot1(String subcntremailnotuser) throws InterruptedException
	 {
		JavascriptHelper js=new JavascriptHelper(driver);
		//   Getcompanyusername();
		 int subcntrcnt=driver.findElements(By.xpath("//*[@class='col-md-6']//ul[@class='checkboxList']//span[@id='Company_subco_email_userid']//li//input")).size();
		 
		 for(int i=1;i<=subcntrcnt;i++)
		 {
		 String cmpnyuname=driver.findElement(By.xpath("//*[@id='Company_subco_email_userid']//li["+i+"]//label")).getText();
		// driver.findElement(By.xpath("//*[@class='col-md-6']//ul[@class='checkboxList']//span[@id='Company_subco_email_userid']//li//label[text()='"+subcntremailnot+"]'")).click();
		 System.out.println(cmpnyuname);
		if(subcntremailnotuser.contains(cmpnyuname))
		{
			
			WebElement chkbox=driver.findElement(By.xpath("//*[@id='Company_subco_email_userid']//li["+i+"]//input"));
			//js.scrollToElemetAndClick(chkbox);
			JavascriptExecutor e =(JavascriptExecutor)driver;
	        e.executeScript("arguments[0].click();", chkbox);
	       // chkbox.click();
	        Thread.sleep(2000);
	        break;
		}
		 }
	 }
	 public void clickPOemailnot1(String emailuser)
	 {

		
		 int subcntrcnt=driver.findElements(By.xpath("//*[@class='col-md-6']//ul[@class='checkboxList']//span[@id='Company_po_email_userid']//li")).size();
		 
		 for(int i=1;i<=subcntrcnt;i++)
		 {
 		 String cmpnyuname=driver.findElement(By.xpath("//*[@id='Company_po_email_userid']//li["+i+"]//label")).getText();
		// driver.findElement(By.xpath("//*[@class='col-md-6']//ul[@class='checkboxList']//span[@id='Company_subco_email_userid']//li//label[text()='"+subcntremailnot+"]'")).click();
		if(emailuser.contains(cmpnyuname))
		{
			WebElement chkbox=driver.findElement(By.xpath("//*[@id='Company_po_email_userid']//li["+i+"]//label"));
			JavascriptExecutor e =(JavascriptExecutor)driver;
	        e.executeScript("arguments[0].click();", chkbox);
	   	
		}
		 }
	 }
	 public void clickinvoiceemailnot1(String invoiceuser) throws InterruptedException
	 {

		 int subcntrcnt=driver.findElements(By.xpath("//*[@class='col-md-6']//ul[@class='checkboxList']//span[@id='Company_invoice_email_userid']//li")).size();
		 
		 for(int i=1;i<=subcntrcnt;i++)
		 {
 		 String cmpnyuname=driver.findElement(By.xpath("//*[@id='Company_invoice_email_userid']//li["+i+"]//label")).getText();
 		 // driver.findElement(By.xpath("//*[@class='col-md-6']//ul[@class='checkboxList']//span[@id='Company_subco_email_userid']//li//label[text()='"+subcntremailnot+"]'")).click();
		if(cmpnyuname.contains(invoiceuser))
		{
			WebElement chkbox=driver.findElement(By.xpath("//*[@id='Company_invoice_email_userid']//li["+i+"]//label"));
			JavascriptExecutor e =(JavascriptExecutor)driver;
	        e.executeScript("arguments[0].click();", chkbox);
	        Thread.sleep(2000);
	   	    break;
		}
		 }
	 }
}
