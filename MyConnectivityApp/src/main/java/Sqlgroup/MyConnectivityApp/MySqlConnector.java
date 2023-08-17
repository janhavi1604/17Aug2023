package Sqlgroup.MyConnectivityApp;
import java.sql.*;
public class MySqlConnector {
	public static final String URL="jdbc:mysql://localhost:3306/test";
	public static final String USERNAME="root";
	public static final String PASSWORD="Jan@16042001";
	Connection con;
	Statement stat;
	public void dbConnect()
	{
		try {
			con=DriverManager.getConnection(URL,USERNAME,PASSWORD);
			System.out.println("Connection established");
			System.out.println(con.getMetaData().getDatabaseProductName());
			System.out.println(con.getClientInfo());
		}
		
		
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void executeStatements()
	{  
		String query="create table items(itemid int primary key,itemname varchar(20),itemprice float,itemquantity int)";
	
		try {
			stat =con.createStatement();
			boolean result=stat.execute(query);
			if(result)
			{
				System.out.println("table not created");
			}
			else
			{
				System.out.println("table created");
				
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

}
	
	public void insertRecords()
	{
		String insertCommand ="insert into items values(3,'Coffee',25,35)";
		try
		{
			int recordsaffected=stat.executeUpdate(insertCommand);
			System.out.println("record inserted "+recordsaffected);
			
			}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	public void getRecords()
	{
		String query="select * from items";
		try
		{
			ResultSet result=stat.executeQuery(query);
			while(result.next()) {
				int itemid=result.getInt(1);
				String itemName=result.getString(2);
				float price=result.getFloat(3);
				int quantity=result.getInt(3);
				
				System.out.println("ItemId"+itemid);
				System.out.println("ItemNmae"+itemName);
				System.out.println("Item Price"+price);
				System.out.println("ItemQuantity"+quantity);
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void showRecords(int itemid)
	{
		String qury="select * from items where itemid=?";
		try
		{
			PreparedStatement stst=con.prepareStatement(qury);
			((PreparedStatement) stat).setInt(1,itemid);
			ResultSet result=stat.executeQuery(qury);
			while(result.next()) {
				int item_id=result.getInt(1);
				String itemName=result.getString(2);
				float price=result.getFloat(3);
				int quantity=result.getInt(3);
				
				System.out.println("ItemId"+itemid);
				System.out.println("ItemNmae"+itemName);
				System.out.println("Item Price"+price);
				System.out.println("ItemQuantity"+quantity);
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
			
		}
	}



