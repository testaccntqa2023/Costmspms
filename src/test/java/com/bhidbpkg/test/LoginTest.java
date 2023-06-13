package com.bhidbpkg.test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BHIAW.Helper.LoggerHelper;
import com.bhiawpkg.Config.Config;
import com.bhiawpkg.Pages.LoginPage;
import com.bhiawpkg.TestBase.TestBase;
import com.bhiawpkg.Utility.XLUTILS;

public class LoginTest {//extends TestBase
	

 private static Logger loger=LoggerHelper.getLogger(LoginTest.class);	
  @Test(dataProvider ="getdbsvalue")
  public void Login(String uname,String pwd) throws InterruptedException, IOException {
	  
	  System.out.println("DB values"+uname);
		System.out.println("DB values"+pwd);
	//  bhilogin.Login(con.Getusername(), con.Getpassword());
	
		/*LoginPage bhilogin=new LoginPage(driver);
		  Config con=new Config(pr);
	  bhilogin.Login(uname,pwd);
	  Thread.sleep(4000);
	  loger.info("--------Login is doing------------");
	  boolean status=bhilogin.verifysuccessfull();
	  	  if(status==true){
			Assert.assertTrue(true);
			Thread.sleep(2000);
			bhilogin.Clickbox();
			loger.info("==============login is sucessful=========================");
			
		}
		else{
			captureScreen(driver,"loginTest");
			 // Assert.assertTrue(false);
			Assert.assertTrue(false, "==============login is not sucessful=========================");
		}*/
		
	  	//con.Geturl();
	 }
  //================================================================*/
	/*@Test(dataProvider ="DP")
	public void validatelogin(String uname,String pwd)
	{
	System.out.println("DB values"+uname);
	System.out.println("DB values"+pwd);
	}*/
 /* @DataProvider(name="DP")
  public String[][] feeddp() throws ClassNotFoundException, SQLException
  {
	  String data[][]=Getdbvalues();
	  return data;
  }*/
  @DataProvider(name="getdbsvalue")
    public String[][] Getdbvalues() throws ClassNotFoundException, SQLException, InterruptedException
  {
	  
	
	 Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/seleniumdb";
	 String username="root";
	 String password="Mysqlbhi@7";
	// Connection con=DriverManager.getConnection(url,username,password);
	 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/seleniumdb","root","Mysqlbhi@7");
	 Thread.sleep(3000);
	// Statement stmt=con.createStatement();
	
	Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	// int value=stmt.executeUpdate("INSERT INTO 'testdb'.'Login' VALUES ('java','java123#')");
	// System.out.println("The rows are updated"+value);
	// ResultSet s=stmt.executeQuery("insert into seleniumdb.seleniumtable values('arun','ammu456')");
	 
	  ResultSet rs=stmt.executeQuery("Select *from seleniumtable");
	  rs.last();
	  int rows=rs.getRow();
	  System.out.println("Number of rows"+rows);
	  ResultSetMetaData rsmd = rs.getMetaData();
	     int colum= rsmd.getColumnCount();
	     //boolean b = rsmd.isSearchable(1);
	     System.out.println("Number of columns"+colum);
	       
	    String[][] data=new String[rows][colum];
	     int i=0;
	     rs.beforeFirst();
	     while(rs.next())
	     {
	     for(int j=0;j<colum;j++)
	     {
	    	 rs.getString(j+1);
	    	 System.out.println(data[i][j]);
	     }
	     i++;
	     }
		return data;
  }
}
