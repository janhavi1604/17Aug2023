package MYSQL.MySqlCaseStudy;
import java.sql.*;


public class MysqlConnection {
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
		String query="create table CallQuality(callid int primary key,phoneno varchar(20),callfeedback varchar(20),callrating int,customername varchar(20),calldrop varchar(20))";
		
	
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
		String insertCommand ="insert into CallQuality values(4,'887334526','calldropshampering',3,'Mathew Mands','32%')";
		
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
				int call_id=result.getInt(1);
				String phoneno=result.getString("phoneno");
				String callfeedback=result.getString("callfeedback");
				int callrating=result.getInt("callrating");
				String customername=result.getString("customername");
				String calldroprate=result.getString("calldrop");
				
				System.out.println("callid"+call_id);
				System.out.println("phoneno"+phoneno);
				System.out.println("callfeedback"+callfeedback);
				System.out.println("callrating"+callrating);
				System.out.println("customername"+customername);
				System.out.println("calldroprate"+calldroprate);
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
