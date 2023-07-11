package com.bhiawpkg.Pages;

import java.awt.Robot;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BHIAW.Helper.DropdownHelper;
import com.BHIAW.Helper.JavascriptHelper;
import com.BHIAW.Helper.LoggerHelper;
import com.bhiawpkg.Config.Config;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;

public class Masterpage {
	WebDriver driver;
	Robot robo;
	Properties pr=new Properties();
	private final Logger logger=LoggerHelper.getLogger(Masterpage.class);
		
	public Masterpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*//a[text()='Settings']") public WebElement settingsmenu;
	@FindBy(xpath = "//li//a[text()='Users']") public WebElement settingsusers;
	@FindBy(xpath = "//table//tbody//tr//td[2]") public WebElement grdusers;
	@FindBy(xpath = "//*//form[1]/div[2]/input[1]") public WebElement userpagesavebtn;
	
	
	@FindBy(xpath = "//li//a[text()='Quotation Category']") public WebElement settingsquotcategory;
	@FindBy(xpath = "//li//a[text()='Quotation Item']") public WebElement settingsquotitem;
	@FindBy(xpath = "//li//a[text()='Quotation Finish']") public WebElement settingsquotfinish;
	@FindBy(xpath = "//li//a[text()='Quotation Worktype']") public WebElement settingsquotworktype;
	@FindBy(xpath = "//li//a[text()='Sales Executive']") public WebElement settingssalesexecutive;
	//category============================================================================================
	@FindBy(xpath="//*[@id='QuotationCategoryMaster_name']")public WebElement categoryname;
	@FindBy(xpath="//*[@id='quotation-category-master-form']/div/div[2]/input[1]")public WebElement createcategorybtn;
	
	//worktype=====================================================================================================
	@FindBy(xpath="//*[@id='QuotationWorktype_name']")public WebElement worktypename;
	@FindBy(xpath="//*[@id='QuotationWorktype_template_id']")public WebElement selworktypetemplate;
	@FindBy(xpath="//*[@id='QuotationWorktype_status']")public WebElement selworktypestatus;
	@FindBy(xpath="//*[@id='quotation-finish-master-form']/div/div[4]/input[1]")public WebElement worktypecreatebtn;
	//Quotation FInish=====================================================================================================
		@FindBy(xpath="//*[@id='QuotationFinishMaster_name']")public WebElement quotationfinishname;
		@FindBy(xpath="//body/div[1]/div[1]/div[2]/div[4]/div[1]/div[1]/div[1]/form[1]/div[2]/div[2]/input[1]")public WebElement quotationfinshcreatebtn;
		@FindBy(xpath="//*[@value='Create']") public WebElement qfinishcreatebtn;
		
		//Quotation FInish=====================================================================================================
				@FindBy(xpath="//*[@id='QuotationFinishMaster_name']")public WebElement addquotationitembtn;
				@FindBy(xpath="//*[@id='worktype']")public WebElement quotationitemcategory;
				
		//Quotation item
				@FindBy(xpath="//a[text()='Add Quotation Item']")public WebElement addquotationitem;
				@FindBy(xpath="//*[@id='QuotationItemMaster_quotation_category_id']")public WebElement selctgryforqitm;
				@FindBy(xpath="//*[@id='worktype']")public WebElement selworktype;
				@FindBy(xpath="//*[@id='additem-button']")public WebElement AddQitmbtn;
//create quotation item master
	@FindBy(xpath="//*[@id='worktype_label']")public WebElement worktypelabel;
	@FindBy(xpath="//*[@id='shutter_material_1']")public WebElement worktypematerial;
	@FindBy(xpath="//*[@id='shutter_finish_1']")public WebElement worktypefinish;
	@FindBy(xpath="//*[@id='shutterwork_description_1']")public WebElement worktypedescr;
	@FindBy(xpath="//*[@id='caracoss_material_1']")public WebElement worktypematerial1;
	@FindBy(xpath="//*[@id='caracoss_finish_1']")public WebElement worktypefinish1;
	@FindBy(xpath="//*[@id='caracoss_description_1']")public WebElement worktypedescr1;
	@FindBy(xpath="//*[@id='rate']")public WebElement rate;
	@FindBy(xpath="//*[@id='profit']")public WebElement profit;
	@FindBy(xpath="//*[@id='discount']")public WebElement discount;
	//Bank
	@FindBy(xpath="//li//a[text()='Bank']")public WebElement bank;
	@FindBy(xpath="//a[text()='Add Bank']")public WebElement addbank;
	@FindBy(xpath="//*[@id='Bank_bank_name']")public WebElement bankname;
	@FindBy(xpath="//*[@id='Bank_company_id']")public WebElement bankcmpny;
	@FindBy(xpath="//*[@type='submit']")public WebElement bankcreatebtn;
	//cashbalance
	@FindBy(xpath="//li//a[text()='Cash Balance']")public WebElement cashbalance;
	//Pettycashuser
	@FindBy(xpath="//li//a[text()='Sales Executive']")public WebElement salesexecutivemstr;
	
	@FindBy(xpath="//*[text()='Import']")public WebElement Importpuritemsmaster;
	@FindBy(xpath="//*[text()='browse file']")public WebElement browsefile;
	
		
	public void clicksettingsmenu()
	{
		this.settingsmenu.click();
		logger.info("------------click settings menu-----------------------------");
	}
	public void clicksettingsquotcategory() 
	{
		this.settingsquotcategory.click();
		logger.info("---------click quotation category from master---------------");
	}
	public void clicksettingsquotitem() 
	{
		this.settingsquotitem.click();
	}
	public void clicksettingsquotfinish() 
	{
		this.settingsquotfinish.click();
	}
	public void clicksettingsquotworktype() 
	{
		this.settingsquotworktype.click();
		logger.info("----------click quotation worktype from master---------------");
	}
	public void clicksettingssalesexecutive() 
	{
		this.settingssalesexecutive.click();
	}
	//category
	public void typecategoryname(String Categoryname)
	{
		this.categoryname.sendKeys(Categoryname);
		logger.info("---------type quotation category ---------------");
	}
	public void clickcreatecategorybtn()
	{
		this.createcategorybtn.click();
		logger.info("---------click create button----------------");
	}
	//worktype
	
	public void typeworktype(String worktypename)
	{
		this.worktypename.sendKeys(worktypename);
		logger.info("------------type worktype name--------------");
	}
	public void selworktypetmplate(String worktypetmplate)
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingVisibleValue(selworktypetemplate, worktypetmplate);
	}
	public void selworktypestatus(String worktypestatus)
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingVisibleValue(selworktypestatus, worktypestatus);
	}
	public void clickworktypecreatebtn()
	{
		this.worktypecreatebtn.click();
	}
	//Quotation Finish
	public void typequotationfinish(String finishname)
	{
	this.quotationfinishname.sendKeys(finishname);	
	}
	public void clickcreatequotationfinish()
	{
		//this.quotationfinshcreatebtn.click();
		this.qfinishcreatebtn.click();
	}
	public void clickquotationitemcategory()
	{
		this.quotationitemcategory.click();
	}
	//item
	
	public void clickaddquotationitem()
	{
		this.addquotationitem.click();
	}
	public void selctgryforqitm(String ctgry)
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingVisibleText(this.selctgryforqitm, ctgry);
	}
	public void selworktypeforqitm(String worktype)
	{
		DropdownHelper dpselworktype=new DropdownHelper(driver);
		dpselworktype.SelectUsingVisibleText(selworktype, worktype);
	}
	public void clickQaddbtn()
	{
		this.AddQitmbtn.click();
	}
	public void typeworktypelabel(String worktypelabel)
	{
		this.worktypelabel.sendKeys(worktypelabel);
	}
	public void selworktypematerial2(String material)
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingVisibleText(this.worktypematerial, material);
		
	}
	public void selworktypematerial()
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingIndex(this.worktypematerial, 1);
		
	}
	public void selworktypefinish()
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingIndex(this.worktypefinish, 1);
	}
	public void typeworktypedescr(String worktypedescr) 
	{
		this.worktypedescr.sendKeys(worktypedescr);
	}
	public void selworktypematerial1()
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingIndex(this.worktypematerial1, 1);
		
	}
	public void selworktypefinish1()
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingIndex(this.worktypefinish1, 1);
	}
	public void typeworktypedescr1(String worktypedescr) 
	{
		this.worktypedescr1.sendKeys(worktypedescr);
	}
	public void typerate(String rate)
	{
		this.rate.sendKeys(rate);
	}
	public void typeprofit(String profit)
	{
		this.profit.sendKeys(profit);
	}
	public void typediscount(String discount)
	{
		this.discount.sendKeys(discount);
	}
	public void clicksettingsusers()
	{
		this.settingsusers.click();
	}
	public void clickgrdusername(String username) throws InterruptedException
	{
		JavascriptHelper js=new JavascriptHelper(driver);
		List<WebElement>users=driver.findElements(By.xpath("//table//tbody//tr//td[2]"));
		for(int i=1;i<=users.size();i++)
		{
			WebElement elem1=driver.findElement(By.xpath("//table//tbody//tr["+i+"]//td[3]"));
			js.scrollToElemet(elem1);
			Thread.sleep(2000);
			String user=driver.findElement(By.xpath("//table//tbody//tr["+i+"]//td[3]")).getText();
			Thread.sleep(2000);
			if(user.contains(username))
			{
				WebElement elem2=driver.findElement(By.xpath("//table//tbody//tr["+i+"]//td[10]//a"));
				js.scrollToElemet(elem2);
				Thread.sleep(2000);
				if(!elem2.isSelected())
				{
				driver.findElement(By.xpath("//table//tbody//tr["+i+"]//td[10]//a")).click();
				break;
				}
				Thread.sleep(2000);
				
			}
		}
	}
	//userpage
	public void clickcompany(String expcompanyname)//choosecompany
	{
		List<WebElement>companylist=driver.findElements(By.xpath("//*[@id='Users_company_id']//li//label"));
		for(int i=1;i<=companylist.size();i++)
		{
			String cmpname=driver.findElement(By.xpath("//*[@id='Users_company_id']//li["+i+"]//label")).getText();
			if(expcompanyname.equals(cmpname))
			{
				WebElement elem=driver.findElement(By.xpath("//*[@id='Users_company_id']//li["+i+"]//input"));
				if(!elem.isSelected())
				{
					elem.click();
				//driver.findElement(By.xpath("//*[@id='Users_company_id']//li["+i+"]//input")).click();
				}
			}
		}
	}
	public void clickuserpagesavebtn()
	{

	WebElement elem=this.userpagesavebtn;
	JavascriptExecutor e =(JavascriptExecutor)driver;
    e.executeScript("arguments[0].click();", elem);
	logger.info("------click company create button---------------");
		//this.userpagesavebtn.click();
	}
	//getbankname
	public String getbankname(String cmpname)
	{
		String bankname = null;
		List<WebElement> cmpnames=driver.findElements(By.xpath("//table[@id='banktab']//tbody//tr//td[3]"));
		int rowcnt=cmpnames.size();
		for(int i=1;i<=cmpnames.size();i++)
		{
			String cmpnme=driver.findElement(By.xpath("//table[@id='banktab']//tbody//tr["+i+"]//td[3]")).getText();
			if(cmpname.equals(cmpnme))
			{
				 bankname=driver.findElement(By.xpath("//table[@id='banktab']//tbody//tr["+rowcnt+"]//td[2]")).getText();
				 break;
			}
			
		}
		return bankname;
	}
	public void clickbankname()
	{
		this.bank.click();
	}
	public void clickaddbank()
	{
		this.addbank.click();
	}
	public void typebankname()
	{
		this.bankname.sendKeys("bnk01"+RandomStringUtils.randomNumeric(2));
	}
	public void selbankcompany(String cmpny)
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingVisibleText(this.bankcmpny, cmpny);
	}
	public void clickbankcreatebtn()
	{
		this.bankcreatebtn.click();
	}
	public void clickcashbalance()
	{
		this.cashbalance.click();
	}
	public String Getopeningbalance(String expbankname)
	{
		String openbalace=null;
		List<WebElement>elem=driver.findElements(By.xpath("//*[@id='expensetype']//div[5]//div//table//tbody//tr//td[6]"));
		for(int i=1;i<=elem.size();i++)
		{
			WebElement actbnkname=driver.findElement(By.xpath("//*[@id='expensetype']//div[5]//div//table//tbody//tr["+i+"]//td[4]"));
			String actbnk=actbnkname.getText();
			if(actbnk.equals(expbankname))
			{
			
			 openbalace=driver.findElement(By.xpath("//*[@id='expensetype']//div[5]//div//table//tbody//tr["+i+"]//td[6]")).getText();
			}
			
		}
		return openbalace;
	}
	public String Getclosingbalance(String expbankname)
	{
		String closebalace=null;
		List<WebElement>elem=driver.findElements(By.xpath("//*[@id='expensetype']//div[5]//div//table[1]//tbody//tr//td[8]"));
		for(int i=1;i<=elem.size();i++)
		{
			WebElement actbnkname=driver.findElement(By.xpath("//*[@id='expensetype']//div[5]//div//table//tbody//tr["+i+"]//td[4]"));
			String actbnk=actbnkname.getText();
			if(actbnk.equals(expbankname))
			{
			
				closebalace=driver.findElement(By.xpath("//*[@id='expensetype']//div[5]//div//table//tbody//tr["+i+"]//td[8]")).getText();
			}
			
		}
		return closebalace;
	}
	public String Getopeningbalance1(String expbankname,String expcmpnyname) throws InterruptedException
	{
		String openbalace=null;
		//String openingbalance=null;
		int opengbalance=0;
		//Double openbalace1=null;
		List<WebElement>elem=driver.findElements(By.xpath("//*[@id='expensetype']//div[5]//div//table[1]//tbody//tr//td[6]"));
		for(int i=1;i<=elem.size();i++)
		{
			
			WebElement actcmpname=driver.findElement(By.xpath("//*[@id='expensetype']//div[5]//div//table[1]//tbody//tr["+i+"]//td[2]"));
			String actcmpnme=actcmpname.getText();
			Thread.sleep(2000);
			WebElement actbnkname=driver.findElement(By.xpath("//*[@id='expensetype']//div[5]//div//table[1]//tbody//tr["+i+"]//td[4]"));
			String actbnk=actbnkname.getText();
			if(actbnk.equals(expbankname)&&actcmpnme.equals(expcmpnyname))
			{
			
			 openbalace=driver.findElement(By.xpath("//*[@id='expensetype']//div[5]//div//table[1]//tbody//tr["+i+"]//td[6]")).getText();
				
			}
			
		}
		return openbalace;
	}
	public String Getclosingbalance1(String expbankname,String expcmpnyname) throws InterruptedException
	{
		String closebalace=null;
		List<WebElement>elem=driver.findElements(By.xpath("//*[@id='expensetype']//div[5]//div//table[1]//tbody//tr//td[8]"));
		for(int i=1;i<=elem.size();i++)
		{
			WebElement actcmpname=driver.findElement(By.xpath("//*[@id='expensetype']//div[5]//div//table[1]//tbody//tr["+i+"]//td[2]"));
			String actcmpnme=actcmpname.getText();
			Thread.sleep(2000);
			WebElement actbnkname=driver.findElement(By.xpath("//*[@id='expensetype']//div[5]//div//table[1]//tbody//tr["+i+"]//td[4]"));
			String actbnk=actbnkname.getText();
			if(actbnk.equals(expbankname)&&actcmpnme.equals(expcmpnyname))
			{
				WebElement cashelem=driver.findElement(By.xpath("//*[@id='expensetype']//div[5]//div//table[1]//tbody//tr["+i+"]//td[9]"));
				
				JavascriptHelper js=new JavascriptHelper(driver);
				js.scrollToElemet(cashelem);
				closebalace=cashelem.getText();
			break;
			}
		}
		
		return closebalace;
	}
	public void clicksalesexecutive()
	{
		this.salesexecutivemstr.click();
	}
	public void clickimportmenu()
	{
		this.Importpuritemsmaster.click();
		logger.info("--click the import menu---");
	}
	public void clickbrowsefile()
	{
		this.browsefile.click();
		logger.info("--click the browse file option--");
	}
}
