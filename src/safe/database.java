package safe;
import java.io.File;
import java.sql.*;

/*
 * @author Dutta
 */

public class database {
    
    Connection link;
    Statement stt;
    ResultSet results; 
    database()
    {
        try
        {
          Class.forName("org.apache.derby.jdbc.ClientDriver");
           link=DriverManager.getConnection("jdbc:derby://localhost:1527/editor","anindya","12345");
           stt=link.createStatement();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

    String checkpwd(File file,String pwd)
    {
       String filen=file.toString();
        System.out.println(filen);
       String actpwd,type;
        try {
            String query="SELECT * FROM safe WHERE filename='"+filen+"'";
            
            results=stt.executeQuery(query);            
            while(results.next())
            {
                actpwd=results.getString("pwd");
                type=results.getString("type");
                 if(actpwd.equals(pwd))
                return type;
            }
            link.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }
    
    void add(String file,String pwd, String lev)
    {
         String query="INSERT INTO safe VALUES ('"+file+"','"+pwd+"','"+lev+"')";
         try {
           stt.execute(query);
           link.commit();
           link.close();
        } catch (SQLException ex) {
             System.out.println(ex);
        }     
    }
}