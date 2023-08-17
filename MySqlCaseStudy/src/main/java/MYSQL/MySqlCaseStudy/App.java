package MYSQL.MySqlCaseStudy;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       MysqlConnection obj=new MysqlConnection();
       obj.dbConnect();
       //obj.executeStatements();
       //obj.insertRecords();
       obj.getRecords();
    }
}
