package MYSQLPRAC.mynewcasestudy;
import java.sql.*;


public class mynewpracsql {
	
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
		String query="create table Package1(packageid int primary key,packagename varchar(20),packagerate int,total_days varchar(20))";
		
	
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
	public void executeStatements1()
	{  
		String query="create table Customer(customerid int primary key,firstname varchar(20),lastname varchar(20),phoneno varchar(20),bill_amount int,customer_address varchar(20),packageid int, foreign key(packageid) references Package1(packageid))";
		
	
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
	
	public void batchQuery()
	{
		try
		{
			con.setAutoCommit(false);
			stat.addBatch("insert into Customer values(1,'Peter','John','987564123',30,'dhanori',)");
			stat.addBatch("insert into Customer values(2,'Sam','Mohn','987564123',20,'Kharadi',)");
		
			int [] results=stat.executeBatch();
			con.commit();
			for(int i:results)
			{
				System.out.println(i);
			}
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	
}
