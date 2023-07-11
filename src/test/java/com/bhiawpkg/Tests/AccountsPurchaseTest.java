package com.bhiawpkg.Tests;

import org.testng.annotations.Test;

import java.awt.Robot;
import com.bhiawpkg.Config.Config;
import com.bhiawpkg.Pages.CompanyPage;
import com.bhiawpkg.Pages.LogoutPage;
import com.bhiawpkg.Pages.Masterpage;
import com.bhiawpkg.Pages.ProjectcreationPage;
import com.bhiawpkg.Pages.PurchaseItemMasterPage;
import com.bhiawpkg.Pages.PurchasePage;
import com.bhiawpkg.Pages.UserPage;
import com.bhiawpkg.Pages.VendorPage;
import com.bhiawpkg.Pages.WarehousePage;
import com.bhiawpkg.TestBase.TestBase2;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Properties;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.BHIAW.Helper.AlertHelper;
import com.BHIAW.Helper.JavascriptHelper;
import com.BHIAW.Helper.LoggerHelper;
import com.bhiawpkg.Pages.LoginPage;
public class AccountsPurchaseTest extends TestBase2{
	PurchaseItemMasterPage purchasemstr;
	 CompanyPage cmpnypge;
	 Masterpage mstr;
	 Robot robo;
	 LogoutPage logout;
	 UserPage userpge;
	 PurchasePage puchpge;
	 JavascriptHelper js;
	 WarehousePage whse;
	 VendorPage vndrpage;
	private static Logger logger=LoggerHelper.getLogger(AccountsPurchaseTest.class);
	
	 @BeforeMethod
	  public void Login() throws InterruptedException, IOException {
		  LoginPage bhilogin=new LoginPage(driver);
		  Config con=new Config(pr);
		  bhilogin.CMSLogin(con.Getusername(), con.Getpassword());
		  //bhilogin.cmsLogin();
		  impliciteWait(40);
		  logger.info("--------Login is doing------------");
		/*  
		 boolean status=bhilogin.verifysuccessfull();
		  	  if(status==true){
				
				impliciteWait(30);
				logger.info("==============login is sucessful=========================");
				Assert.assertTrue(true);
			}
			else{
				captureScreen(driver,"loginTest");
				 // Assert.assertTrue(false);
				Assert.assertTrue(false, "==============login is not sucessful=========================");
			}
		 */ 	  
		  }
	//*--------------------------------------------------------
	 @Test
	 public void PurchaseOrderCreation() throws InterruptedException
	 {
		 
			/*
			 * mstr.clicksettingsmenu();
			 * logger.info("----------user click settings-----------"); cmpnypge=new
			 * CompanyPage(driver); cmpnypge.clickcompany();
			 * logger.info("----------user click company-----------"); String
			 * cmpnyname=cmpnypge.getlastcmpnyname();
			 */
		
		 
		//------------17-02-2023--------------------
		 /*
			 * impliciteWait(30); mstr=new Masterpage(driver); mstr.clicksettingsmenu();
			 * impliciteWait(30); ProjectcreationPage pjtpge=new
			 * ProjectcreationPage(driver); impliciteWait(30); pjtpge.clicksettingspjt();
			 * impliciteWait(30); String pjtnme=pjtpge.getlastprojectname();
			 * impliciteWait(30); js=new JavascriptHelper(driver); js.scrollDownByPixel();
			 * impliciteWait(30); pjtpge.clickeditpjtname(); impliciteWait(30);
			 * //js.scrollDownByPixel(); impliciteWait(30); pjtpge.clickcompany(cmpnyname);
			 * impliciteWait(30); // js=new JavascriptHelper(driver); //
			 * js.scrollDownByPixel(); impliciteWait(30); pjtpge.clicksavepjtbtn();
			 * impliciteWait(30);
			 */
	 ///*----
		 mstr=new Masterpage(driver);
		 Config  con=new Config(pr);
		  String cmpnyname=con.GetCompanyname();
		 
		 impliciteWait(30);
		 System.out.println("company name "+cmpnyname);
		 String pjtnme=con.Getactionproject();
		 VendorPage vendpge=new VendorPage(driver);
			vendpge.clickvendorsmenu();
			vendpge.clickvendorslist();
			impliciteWait(30);
			 String vendorname=Getlastvendorname();
			 impliciteWait(30);
		 puchpge=new PurchasePage(driver);
		 puchpge.clickpurchasemenu();
		 impliciteWait(30);
		 logger.info("------click purchase Menu-----------");
		 puchpge.clickpurchaseorders();
		 impliciteWait(30);
		 logger.info("------click purchase Orders--------------------------");
		 puchpge.clickaddPoByQuantity();
		 impliciteWait(30);
		 logger.info("------user click addPO By Quantity-------------------------");
		 puchpge.selpurcompany();
		 impliciteWait(30);
		 logger.info("------user select the company--------------------------");
		 puchpge.typevalue(cmpnyname);
		 impliciteWait(30);
		 puchpge.selpjt(pjtnme);
		// puchpge.selpurproject();
		// impliciteWait(30);
		// puchpge.typevalue(pjtnme);
		// impliciteWait(30);
		 logger.info("------user select the project--------------------------");
		 //puchpge. selpowithoutpoexphead2();
		puchpge.selpowithoutpoexphead1("Painting");
		// puchpge.selpurchexpehead();
		 impliciteWait(30);
		//puchpge.selpurchexpehead();
		// impliciteWait(30);
		 //  String expensehead=driver.findElement(By.xpath("//*[@id='select2-expense_head-container']")).getText();
		  //puchpge.typevalue(expensehead);
		 //impliciteWait(30);
		 logger.info("------user select the expense head--------------------------");
		 puchpge.selpurvendor();
		 impliciteWait(30);
		 puchpge.typevalue(vendorname);
		 impliciteWait(30);
		 logger.info("------user select the vendor--------------------------");
		 String puno="Pno"+RandomStringUtils.randomAlphabetic(2)+RandomStringUtils.randomNumeric(2);
		 puchpge.typepurchaseno(puno);
		 logger.info("------user type the purchase number--------------------------");
		 puchpge.typecontno("89"+RandomStringUtils.randomNumeric(8));
		 puchpge.typedelivrydate();
		 impliciteWait(30);
		 puchpge.typeaddr(" Hospital junction 0987");
		 impliciteWait(30);
		 logger.info("-----user type the address--------------------------");
		 impliciteWait(30);
		    js=new JavascriptHelper(driver);
			js.scrollDownByPixel();
			impliciteWait(30);
			puchpge.selectpoitm();
			impliciteWait(30);
			puchpge.typepuitmquantity("1");
			impliciteWait(30);
			puchpge.typerate("100");
			impliciteWait(30);
			puchpge.typediscount("2");
			impliciteWait(30);
			puchpge.typediscount("1");
			impliciteWait(30);
			puchpge.clickpuitmsavebtn();
			impliciteWait(30);
		 
	 }
	 private void Getpurchaseno(String puno) throws InterruptedException {
		String newpno=driver.findElement(By.xpath("//*[@id='fixtable']/tbody[1]/tr/td[2]/div")).getText();
		impliciteWait(30);
		if(puno.equals(newpno))
		{
			logger.info("--------purchase order created successfully!!------");
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("----------purchase order creaed failed-------------");
			Assert.assertTrue(false, "----------something went wrong!Purchase order created failed!--------------------");
		}
		
	}
	
	public String Getlastvendorname() throws InterruptedException
		{
			List<WebElement>vndrlst=driver.findElements(By.xpath("//table[@id='vendortable']//tbody//tr//td[2]"));
			
			impliciteWait(30);
			int vndrlstcnt=vndrlst.size();
			WebElement elem=driver.findElement(By.xpath("//table[@id='vendortable']/tbody//tr["+vndrlstcnt+"]//td[2]"));
			String vendorname=elem.getText();
			return vendorname;
		}
		
		
@Test
public void PurchaseOrder_Approval() throws InterruptedException
{
	int j=0;
	puchpge=new PurchasePage(driver);
	 puchpge.clickpurchasemenu();																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																									
	 logger.info("------click purchase Menu-----------");
	 puchpge.clickpurchaseorders();
	 logger.info("------click purchase Orders--------------------------");
	String editpno=Getlastcreatedpuno();
	impliciteWait(30);
	try {
	if(puchpge.Getpostatus().equals("Approval needed")||puchpge.Getelementstatus() == true)
	{
	puchpge.clickpoactionmenu();
	impliciteWait(30);
	puchpge.Clickrateapprove();
	impliciteWait(30);
	}
	 if(puchpge.Getelementstatus() == true)
	{
		logger.info("------status is Draft -------------");
		puchpge.clickdraftstatus();
		impliciteWait(30);
		AlertHelper alrt=new AlertHelper(driver);
		alrt.AcceptAlertIfPresent();
		logger.info("------status changed to saved -------------");
	}
	else
	{
		logger.info("------status is saved. -------------");
	}
	}
	catch(Exception ex)
	{
		logger.info("-------Status is saved.--------------");
	}
}
	 //*/
@Test
public void PurchaseOrder_Bill() throws InterruptedException
{
	mstr=new Masterpage(driver);
	/*
	 * mstr.clicksettingsmenu(); impliciteWait(30);
	 * logger.info("----------user click settings-----------"); cmpnypge=new
	 * CompanyPage(driver); cmpnypge.clickcompany(); impliciteWait(30);
	 * logger.info("----------user click company-----------");
	 * String cmpnyname=cmpnypge.getlastcmpnyname();
	 */
	 
	 Config con=new Config(pr);
	  String cmpnyname=con.GetCompanyname();
	 impliciteWait(30);
	 
	 whse=new WarehousePage(driver);
	 whse.clickwarehousemenu();
	 impliciteWait(30);
	 whse.clickwarehouseoption();
	 impliciteWait(30);
	String whsename=whse.getwarehousename();
	/*-- con=new Config(pr);
	 
	 String whsename=con.getwarehousename();--*/
	 logger.info("Getting warehouse name "+whsename);
	impliciteWait(30);
	
	//--whse.whassignee("annbhi");
	//--impliciteWait(30);
	puchpge=new PurchasePage(driver);
	 puchpge.clickpurchasemenu();
	 impliciteWait(30);
	 logger.info("------click purchase Menu-----------");
	 puchpge.clickpurchaseorders();
	 impliciteWait(30);
	 logger.info("------click purchase Orders--------------------------");
	String editpno=Getlastcreatedpuno();
	impliciteWait(30);
	try
	{
	if(puchpge.Getposavedstatus().equals("Saved"))
	{
		 puchpge.clickpurchasemenu();
		 impliciteWait(30);
		 logger.info("------click purchase Menu-----------");
		 puchpge.clickpurchasebill();
		 impliciteWait(30);
		 logger.info("------click purchase Bill--------------------------");
		 puchpge.clickaddbill();
		 impliciteWait(30);
		 logger.info("-----click add bill-----------------");
		 puchpge.clickselcmpnybill();
		 impliciteWait(30);
		 logger.info("-------select company-----------");
		 puchpge.typevalue(cmpnyname);
		 impliciteWait(30);
		// puchpge.typeselcmpny(cmpnyname);
		 puchpge.clickpubill();
		 impliciteWait(30);
		 puchpge.typevalue(editpno);
		 impliciteWait(30);
		 String bilno="billno00"+RandomStringUtils.randomNumeric(3);
		 impliciteWait(30);
		 puchpge.typebillno(bilno);
		 impliciteWait(30);
		 puchpge.clickselwarehouse();
		 impliciteWait(30);
		 puchpge.typevalue(whsename);
		 impliciteWait(30);
		 puchpge.typequantity("1");
		 impliciteWait(30);
		 js=new JavascriptHelper(driver);
		 js.scrollDownByPixel();
		 impliciteWait(40);
		 puchpge.clickpubillcreatebutton();
		 impliciteWait(30);
		 AlertHelper alert=new AlertHelper(driver);
		 alert.AcceptAlert();
		 impliciteWait(30);
	}
	}
catch (Exception e) {
	logger.info("--------Status is not saved, so you cannot bill--------");
}
}
/* con=new Config(pr);
	impliciteWait(30);
	//whse.whassignee(con.Getcompanyusername());
	String uname=con.Getusername();
	//whse.whassignee(uname);*/


@Test
public void Purchasebill_Edit() throws InterruptedException
{
	puchpge=new PurchasePage(driver);
	puchpge.clickpurchasemenu();
	impliciteWait(30);
	 logger.info("------click purchase Menu-----------");
	 puchpge.clickpurchasebill();
	 impliciteWait(30);
	 logger.info("------click purchase Bill--------------------------");
	 puchpge.clickpubillaction();
	 impliciteWait(30);
	 puchpge.clickpubilledit();
	 impliciteWait(30);
	 js=new JavascriptHelper(driver);
	 js.scrollDownByPixel();
	 Thread.sleep(3000);
	 puchpge.clickpoeditsavebtn();
	 impliciteWait(30);
	/* String validmsg=puchpge.Getsucessmsg();
	 Thread.sleep(3000);
	 if(validmsg.equals("Billed details added successfully!"))
	 {
		 impliciteWait(30);
		 logger.info("-------Billed details edited successfully!-------------");
		 Assert.assertTrue(true);
	 }
	 else
	 {
		 impliciteWait(30);
		 logger.info("-------Billed details edited failed!!!-------------");
		 Assert.assertTrue(false,"---something went wrong!, Billed details edited failed!!!"); 
	 }*/
}

public String Getlastcreatedpuno()
{
	return driver.findElement(By.xpath("//*[@id='fixtable']/tbody[1]/tr/td[3]/div")).getText();
}

@Test
public void Purchase_Return() throws InterruptedException
{
	puchpge=new PurchasePage(driver);
	puchpge.clickpurchasemenu();
	impliciteWait(30);
	 logger.info("------click purchase Menu-----------");
	 puchpge.clickpurchasebill();
	 impliciteWait(30);
	 logger.info("------click purchase Bill--------------------------");
	 String billno=puchpge.Getpurretbillno();
	 impliciteWait(30);
	 puchpge.clickpurchasemenu();
	 impliciteWait(30);
	 puchpge.clickpurchasereturn();
	 impliciteWait(30);
	 puchpge.clickpurchaseaddreturn();
	 impliciteWait(30);
	 puchpge.selpurchaseretbill(billno);
	 impliciteWait(30);
	 puchpge.typreturnno();
	 impliciteWait(30);
	 puchpge.typepurretdate();
	 impliciteWait(30);
	 puchpge.typreturnqnty();
	 puchpge.typreturnrate();
	 js=new JavascriptHelper(driver);
	 js.scrollDownByPixel();
	 impliciteWait(30);
	 puchpge.clickpurreturncreatebtn();
	 impliciteWait(30);
	 
}
@Test
public void Purchasebill_View() throws InterruptedException
{
	puchpge=new PurchasePage(driver);
	puchpge.clickpurchasemenu();																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																									
	 logger.info("------click purchase Menu-----------");
	 puchpge.clickpurchasebill();
	 logger.info("------click purchase Bill--------------------------");
	 puchpge.clickpubillaction();
	 puchpge.clickpubillview();
	 impliciteWait(30);
	 logger.info("------click View on purchase Bill--------------------------");
	 logger.info("------Purchase bill view done successfully!!--------------------------");
	 }
@Test
public void Purchasebill_Viewreport() throws InterruptedException
{
	puchpge=new PurchasePage(driver);
	puchpge.clickpurchasemenu();																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																									
	 logger.info("------click purchase Menu-----------");
	 puchpge.clickpurchasebill();
	 logger.info("------click purchase Bill--------------------------");
	 puchpge.clickpubillaction();
	 puchpge.clickpubillview();
	 impliciteWait(30);
	 logger.info("------click View on purchase Bill--------------------------");
	 puchpge.clickpubillsavepdf();
	 impliciteWait(30);
	 logger.info("------click save as pdf--------------------------");
	 puchpge.clickpubillsaveexcel();
	 impliciteWait(30);
	 logger.info("------click save as Excel--------------------------");
	 logger.info("------Files downloaded successfully!!!--------------------------");
	 }

@Test
public void previousPurchase() throws InterruptedException
{
	vndrpage=new VendorPage(driver);
	  vndrpage.clickvendorsmenu();
	  impliciteWait(30);
	  vndrpage.clickvendorslist();
	  impliciteWait(30);
	  String createdvndrname=vndrpage.Getlastvendorname();
	  impliciteWait(30);
	puchpge=new PurchasePage(driver);
	puchpge.clickpurchasemenu();
	impliciteWait(30);
	logger.info("------click purchase Menu-----------");
	puchpge.clickpreviouspurchase();
	 impliciteWait(30);
	puchpge.seitemprevpurchse();
	 impliciteWait(30);
	 	puchpge.selprevpurchsevendor(createdvndrname);
	 impliciteWait(30);
	puchpge.typedatefrm();
	 impliciteWait(30);
	puchpge.typedateto();
	 impliciteWait(30);
	puchpge.clickgobtn();
	 impliciteWait(30);
	 puchpge.clicksaveasexcel();
	 impliciteWait(30);
	puchpge.clicksaveaspdf();
	impliciteWait(30);
	driver.navigate().back();
	impliciteWait(30);
}

@AfterMethod
public void Logout() throws InterruptedException
{
	  LogoutPage logout=new LogoutPage(driver);
	  logout.clickusericon();
	  logout.clickLogout();
	  impliciteWait(30);
}
}