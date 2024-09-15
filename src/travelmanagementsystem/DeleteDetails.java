package travelmanagementsystem;
import javax.swing.*;
/**
 *
 * @author mathewthomas
 */
public class DeleteDetails extends JFrame{
    
    String username;
    
    DeleteDetails(String username){
        this.username = username;
        int returnValue = 0;
    	returnValue = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete personel details?", "Are you sure?", JOptionPane.YES_NO_OPTION);
    		
    	if (returnValue == JOptionPane.YES_OPTION){
            try {
                Conn c = new Conn();
                String query = "delete from customer where username = '"+username+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Deleted Personel Details");
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args){
        new DeleteDetails("matt");
    }
}
