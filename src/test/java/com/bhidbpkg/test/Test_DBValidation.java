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
import java.util.List;

public class Test_DBValidation {

	public	static Connection condb = null;
    // Statement object
	protected  static Statement stmt=null;
	protected static ResultSetMetaData rsmd=null;
	protected static ResultSet res1 =null;
	protected  static ResultSet res2 =null;
	protected static String query_total_row="SELECT COUNT(*) AS TOTAL_ROW FROM projectdetails";
	protected static String query_all_records="SELECT * FROM projectdetails";
	protected static int rownumber;//SELENIUMTABLE
	protected static int columnnumber;
	protected static SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
    // Constant for Database URL
    public static String DB_URL = "jdbc:mysql://localhost:3306/seleniumdb";   
    // Constant for Database Username
    public static String DB_USER = "root";
    // Constant for Database Password
    public static String DB_PASSWORD = "Mysqlbhi@7";
    
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		try 
		{
			System.out.println("Connecting to the database"+"\n"+df.format(new Date())+"\n"+"----------------------------------------");
			 Class.forName("com.mysql.jdbc.Driver");
			 condb=DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			 System.out.println("Connecting to mysql database");
			 
		}
		catch(ClassNotFoundException | SQLException ex)
		{
			System.err.println("Failed to connect to DB/check properties file");
			ex.printStackTrace();
		}
		List<String>data=new ArrayList<String>();
		stmt=condb.createStatement();
		res1=stmt.executeQuery(query_all_records);
		rsmd=res1.getMetaData();
		columnnumber=rsmd.getColumnCount();
		while (res1.next()) {
			for(int i=1;i<=columnnumber;i++)
			{
				data.add(res1.getString(i));
			}
			
		}
		System.out.println("\t"+rsmd.getColumnName(1)  +"        "+rsmd.getColumnName(2)  +"\t\t"+rsmd.getColumnName(3)  +
				"  "+rsmd.getColumnName(4)  +"     "+rsmd.getColumnName(5)  +"    "+rsmd.getColumnName(6)  +"        "+rsmd.getColumnName(7)  +"        "
				+rsmd.getColumnName(8)  +"    "+rsmd.getColumnName(9)  +"        "	);
		System.out.println("\t-------------------------------------------------------------------------------------------------------------------------------------------------");
		res2=stmt.executeQuery(query_total_row);
		while (res2.next())
		{
			rownumber=res2.getInt("Total_ROw");
		}
		
		for(int m=0;m<=rownumber*columnnumber;m++)
		{
			for(int i=1;i<=rownumber;i++)
			{
			System.out.println(i+" row : "+data.get(m)+"\t\t|" +data.get(m+1)+"\t\t|" +data.get(m+2)+"\t\t|   " 
						+data.get(m+3)+"\t\t| " +data.get(m+4)+"\t\t| " +data.get(m+5)+"\t\t|" +data.get(m+6)+"\t\t| " 
						+data.get(m+7)+"\t\t|"+data.get(m+8)+"\t\t|" );
			++m;++m;++m;++m;++m;++m;++m;++m; ++m;
			
			}
			System.out.println("\t-----------------------------------------------------------------------------------------------------------------");
		}
		System.out.println("Total row number: "+rownumber);
		System.out.println("Total column number: "+columnnumber);
		
		if (condb != null) {
				//condb.commit();
	           condb.close();
	           }

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
