package travelmanagementsystem;
import java.sql.*;
/**
 *
 * @author mathewthomas
 */
public class Conn {
    Connection c;
    Statement s;
    Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelmanagementsystem","root","12345678");
            s = c.createStatement();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
