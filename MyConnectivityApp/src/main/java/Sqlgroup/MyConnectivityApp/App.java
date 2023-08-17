package Sqlgroup.MyConnectivityApp;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       MySqlConnector obj=new MySqlConnector();
       obj.dbConnect();
      // obj.executeStatements();
       //obj.insertRecords();
       //obj.getRecords();
       obj.showRecords(2);
    }
}
