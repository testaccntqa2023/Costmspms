package com.bhidbpkg.test;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.BHIAW.Helper.LoggerHelper;
import com.bhiawdatabasepkg.Database.DataBase;
import com.bhiawpkg.Config.Config;
import com.bhiawpkg.Pages.LoginPage;
import com.bhiawpkg.Pages.LogoutPage;
import com.bhiawpkg.Pages.ProjectPage;
import com.bhiawpkg.TestBase.TestBase;

public class DBTest extends TestBase{
	private static Logger logger=LoggerHelper.getLogger(DBTest.class);
	LoginPage  bhilogin;
	 Config  con;
	 ProjectPage prpg;
	 DataBase dataBase;
	 
	@BeforeMethod
	public void GetAddTask() throws InterruptedException 
	{
		con=new Config(pr); 
		bhilogin=new LoginPage(driver);
	    bhilogin.Login(con.Getusername(),con.Getpassword());
	    logger.info("--------Login is doing------------");
	    bhilogin.Clickbox();
	    logger.info("==============login is sucessful=========================");
	    prpg=new ProjectPage(driver);
	}
	
	@Test
	public void selectDBdata() throws ClassNotFoundException, SQLException, InterruptedException{
		prpg.clickProjectsMenu();
		logger.info("-------Clik Project Menu-------");	
		prpg.clickProjectscr();
		logger.info("-------Going to project section-------");
	    prpg.typepjtnamegrd(con.Getactionproject());
	    Thread.sleep(2000);
		String textData = driver.findElement(By.xpath("//*[@id='projects-grid']//table//tbody//tr//td[3]")).getText();
		logger.info("*************Getting data from the UI***********");
		//driver.findElement(By.xpath("//*[@id='projects-grid']//table//tr["+j+"]//td[4]")).getText();
		String query = "SELECT * FROM projectdetails";
		String query1 = "SELECT ProjectName FROM projectdetails where Projectid=4";
		 dataBase = new DataBase();
		ResultSet data = dataBase.getData(query1);
		Thread.sleep(2000);
		System.out.println(data);
		while(data.next()){
			System.out.println(data.getString(1));
			//System.out.println(data.getString(1)+" "+data.getString(2)+" "+data.getString(3));
		
		
		if(textData.contains(data.getString(1))){
			logger.info("-------select the data from the database successfully----------");
			Assert.assertTrue(true);
			}
		else
		{
			Assert.assertTrue(false, "---select query procedure is failed---");
		}
		}
	}
	
	@Test
	public void insertDBdata() throws ClassNotFoundException, SQLException, InterruptedException{
		//String query = "insert into projectdetails values('2','bhnau12','testing123')";
		prpg.clickProjectsMenu();
		logger.info("-------Clik Project Menu-------");	
		prpg.clickProjectscr();
		logger.info("-------Going to project section-------");
	    prpg.typepjtnamegrd(con.Getactionproject());
	    Thread.sleep(2000);
		String textData = driver.findElement(By.xpath("//*[@id='projects-grid']//table//tbody//tr//td[3]")).getText();
		String query="insert into projectdetails (Projectid,ProjectName,Pjtclientname) values(4,'"+textData+"','KPR')";
		 dataBase = new DataBase();
		dataBase.insertData(query);	
		logger.info("-------Insert into database successfully----------");
		Assert.assertTrue(true);
	}
	
	@Test
	public void updateDBdata() throws ClassNotFoundException, SQLException{
		String query = "update projectdetails set ProjectName='ASHLYBHI2' where Projectid='5'";
		 dataBase = new DataBase();
		dataBase.updateData(query);
		logger.info("-------update data from the database successfully done----------");
		Assert.assertTrue(true);
	}
	
	@AfterMethod
	public void Logout()
	{
	LogoutPage logout=new LogoutPage(driver);
	logout.clickusericon();
	logout.clickLogout();
	}
}
