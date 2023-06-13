package com.bhidbpkg.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BHIAW.Helper.LoggerHelper;
import com.bhiawpkg.Config.Config;
import com.bhiawpkg.Pages.LoginPage;
import com.bhiawpkg.Pages.LogoutPage;
import com.bhiawpkg.Pages.ProjectPage;
import com.bhiawpkg.TestBase.TestBase;
import com.bhiawpkg.Tests.NewTestDD;

public class DatabaseTestingDemo  {//extends TestBase
	private static Logger logger=LoggerHelper.getLogger(DatabaseTestingDemo.class);
	ProjectPage prpg;
	Config con;
	 // Connection object
    static Connection condb = null;
    // Statement object
    private static Statement stmt;
    // Constant for Database URL
    public static String DB_URL = "jdbc:mysql://localhost:3306/seleniumdb";   
    // Constant for Database Username
    public static String DB_USER = "root";
    // Constant for Database Password
    public static String DB_PASSWORD = "Mysqlbhi@7";
    
   /* @BeforeMethod()
    public void Login() {
		  		LoginPage bhilogin=new LoginPage(driver);
		        con=new Config(pr);
			    // bhilogin.Login(con.Getusername(), con.Getpassword());
		        bhilogin.Login(con.Getusername(), con.Getpassword());
			    // Thread.sleep(4000);
			    logger.info("--------Login is doing------------");
			    bhilogin.Clickbox();
			    logger.info("==============login is sucessful=========================");	
			 
		 } */
    
   @Test(dataProvider="dbs")
    public void getdbvalue(String uname,String pwd)
    {
    	System.out.println("Db valiue is "+uname);
    	System.out.println("Db value is "+pwd);
    }
   

  @DataProvider(name="dbs")
    public String[][] test() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException
  {
    	  String dbClass = "com.mysql.jdbc.Driver";
          Class.forName(dbClass).newInstance();
          // Get connection to DB
          Connection condb = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
          // Statement object to send the SQL statement to the Database
          Statement stmt=condb.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
          // stmt = con.createStatement();
           
           String query = "select * from seleniumtable";
           // Get the contents of seleniumtable table from DB
           ResultSet res = stmt.executeQuery(query);
           res.last();
           // Print the result untill all the records are printed
           // res.next() returns true if there is any next record else returns false
           int rowcnt=res.getRow();
           ResultSetMetaData rsmd = res.getMetaData();
           int colcnt=rsmd.getColumnCount();
           String[][] dbdata=new String[rowcnt][colcnt];
           int i=0;
           res.beforeFirst();
           while(res.next())
  	     {
  	    	 for(int j=0;j<colcnt;j++)
        	    	{
        	    		res.getString(j+1);
        	    		dbdata[i][j]=res.getString(j+1);
        	    		System.out.println("data is "+res.getString(j+1));
        	    		//System.out.print(res.getString(1));
        	    		//System.out.print("\t" + res.getString(2));
        	    	}
  	    	  		i++;
  	     }	    
      return dbdata;            
    }	    
    
    @AfterMethod
    public void tearDown() throws Exception {
           // Close DB connection
           if (condb != null) {
           condb.close();
           }
           /*LogoutPage logout=new LogoutPage(driver);
      	  logout.clickusericon();
      	  logout.clickLogout();*/
    }

}
