package MYSQLPRAC.mynewcasestudy;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       mynewpracsql obj=new mynewpracsql();
       obj.dbConnect();
       obj.executeStatements();
    
       obj.executeStatements1();
       obj.batchQuery();
    }
}
