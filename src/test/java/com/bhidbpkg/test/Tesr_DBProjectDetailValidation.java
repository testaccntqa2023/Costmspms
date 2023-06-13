package com.bhidbpkg.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.BHIAW.Helper.LoggerHelper;
import com.bhiawpkg.Config.Config;
import com.bhiawpkg.Pages.LoginPage;
import com.bhiawpkg.Pages.ProjectPage;
import com.bhiawpkg.TestBase.TestBase;
//import com.bhiawpkg.Tests.TimeEntryTest;

import junit.framework.Assert;

public class Tesr_DBProjectDetailValidation extends TestBase{
	private static Logger logger=LoggerHelper.getLogger(Tesr_DBProjectDetailValidation.class);
	//protected static WebDriver driver;
	protected static Connection conn= null;
	protected static Statement stmt = null;
	protected static ResultSetMetaData rsmd= null;
	protected static ResultSet rs1= null;
	protected static ResultSet rs2= null;
	protected static String query_Total_Row= "SELECT COUNT(*) AS TOTAL_ROW FROM details_pjt" ;
	protected static String query_ALL_RECORDS= "SELECT * FROM details_pjt";
	protected static int columnNumber ;
	protected static int rowNumber ;
	protected static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	 LoginPage  bhilogin;
	 Config  con;
	 ProjectPage prpg;
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
	
	@BeforeClass
	public static void setUp() 
	{
		System.out.println("********************************************************");
		System.out.println("Run started at :"+df.format(new Date()));
		System.out.println("Chrome Browser Test Environment created");
		//System.setProperty("webdriver.chrome.driver", "D:/BrowserDriver/ChromeDriver/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
	    options.addArguments("--start-maximized");
	    options.addArguments("--disable-web-security");
	    options.addArguments("--no-proxy-server");
	    
	    Map<String, Object> prefs = new HashMap<String, Object>();
	    prefs.put("credentials_enable_service", false);
	    prefs.put("profile.password_manager_enabled", false);
	    prefs.put("profile.default_content_setting_values.notifications", 2);
	    options.setExperimentalOption("prefs", prefs);
		//driver = new ChromeDriver(options);
		//driver.navigate().to("file:///E:/Eclipse_selenium/country.html");
		//driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test
	public void webTableVerify() throws SQLException, InterruptedException
	{
		prpg.clickProjectsMenu();
		logger.info("-------Clik Project Menu-------");	
		prpg.clickProjectscr();
		logger.info("-------Going to project section-------");
	    prpg.typepjtnamegrd(con.Getactionproject());
	    Thread.sleep(2000);
		int totalColumn = driver.findElements(By.xpath("//*[@id='projects-grid']//table//tr//th")).size();
		for(int i=1;i<=totalColumn;i++)
		{
			String columnName = driver.findElement(By.xpath("//*[@id='projects-grid']//table//tr//th["+i+"]")).getText();
			System.out.print(columnName+"   \t");////*[@id='t01']/tbody/tr[1]/th
		}
		
		System.out.println("\n---------------------------------------------------------------------------");
		int totalRow = driver.findElements(By.xpath("//*[@id='projects-grid']//table//tr")).size();
		for(int j=1;j<=totalRow-2;j++)
		{		
			String column1_data = driver.findElement(By.xpath("//*[@id='projects-grid']//table//tr["+j+"]//td[3]")).getText();
			String column2_data = driver.findElement(By.xpath("//*[@id='projects-grid']//table//tr["+j+"]//td[4]")).getText();
			String column3_data = driver.findElement(By.xpath("//*[@id='projects-grid']//table//tr["+j+"]//td[6]")).getText();
			System.out.println(column1_data+"\t\t    |   \t"+column2_data+"   \t|  \t "  +column3_data);
		}
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("Total Column Displayed in WebPage :"+totalColumn);
		System.out.println("Total Data Row Displayed in WebPage(skipping header):"+(totalRow-2));
		

/*collecting all data from webtable into ArrayList for later Comparison with DB arraylist, total row 6 and column 3
 * row index j = 1 (for column header row) so started from j = 2
 * Column index starts from i=1
 * //*[@id='t01']/tbody/tr["+j+"]/td["+i+"]") this Dynamic Xpath take parameter and count and store value for 
 * total 18(3*6) table cell available
 */

		List<String> webPage_data = new ArrayList<String>();
		//for(int j=2;j<=totalRow-2;j++) 
		
		for(int j=1;j<=totalRow-2;j++) 
		{
			for(int i=1;i<=totalColumn-4;i++)
			{
				String row_data= driver.findElement(By.xpath("//*[@id='projects-grid']//table//tr["+j+"]/td["+i+"]")).getText();
				webPage_data.add(row_data);
			}			
		}
		
//doing database connection
		try
		{
			System.out.println("Connecting to Database..."+"\n"+df.format(new Date())+""
					+ "\n----------------------------------------------------------------------------------------");
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/seleniumdb","root","Mysqlbhi@7");	
			Thread.sleep(2000);
			System.out.println("Connected to Mysql Database");
			
		}
		catch(SQLException|ClassNotFoundException ex)
		{
			System.err.println("Failed to connect to DB/ Check properties file");
			ex.printStackTrace();
		}
		List<String> dataBase_data = new ArrayList<String>();
		stmt = conn.createStatement();
		rs1 = stmt.executeQuery(query_ALL_RECORDS);
		rsmd = rs1.getMetaData();
		columnNumber = rsmd.getColumnCount();
		while(rs1.next())
		{
			for(int i=1; i<=columnNumber-4; i++)
			{
				dataBase_data.add(rs1.getString(i));
			}
		}
		rs2 = stmt.executeQuery(query_Total_Row);
		while(rs2.next())
		{
			rowNumber = rs2.getInt("TOTAL_ROW");
		}
// To focus back to rsmd rs1 resultset else it will show only one column for rs2
		rs1 = stmt.executeQuery(query_ALL_RECORDS);
		rsmd = rs1.getMetaData(); 
// Asserting webtable content vs DataBase table Content
		Assert.assertEquals("Failed to Match", dataBase_data, webPage_data);
		Assert.assertEquals(0, 0);
// Asserting webtable total row and columns against database	
		
		Assert.assertEquals("Row Mismatch", rowNumber, (totalRow-2));
		Assert.assertEquals("Column Mismatch", totalColumn, columnNumber);

		
		String columnName1 = driver.findElement(By.xpath("//*[@id='projects-grid']//table//tr//th[1]")).getText();
		String columnName2 = driver.findElement(By.xpath("//*[@id='projects-grid']//table//tr//th[2]")).getText();
		String columnName3 = driver.findElement(By.xpath("//*[@id='projects-grid']//table//tr//th[6]")).getText();
		
// Asserting all webpage column name against database column heading
		Assert.assertEquals("1st Column Name Mismatch",columnName1,rsmd.getColumnName(1));
		Assert.assertEquals("2nd Column Name Mismatch",columnName2,rsmd.getColumnName(2));
		Assert.assertEquals("3rd Column Name Mismatch",columnName3,rsmd.getColumnName(6));
		

// Closing DB connection
		if(conn!=null)
		{
			//conn.commit();
			conn.close();
			System.out.println("\n----------------------------------------------------------------------------------------"+""
					+ "\n"+df.format(new Date()));
			System.out.println("Disconnected from Oracle11g Database");
		}
	}
	
	@AfterClass

	public static void tearDown() throws Exception
	{
		if(driver!=null)
		{
			System.out.println("Closing the Browser");
			System.out.println("Run ended at :"+df.format(new Date()));
			System.out.println("********************************************************");
			driver.quit();
		}
	}
}
