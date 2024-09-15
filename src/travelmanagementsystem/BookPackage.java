package travelmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
/**
 *
 * @author mathewthomas
 */
public class BookPackage extends JFrame implements ActionListener{
    
    Choice cpackage;
    JTextField tfperson;
    String username;
    JLabel labelusername,labelnumber,labelphone,labeltotal, labelid;
    JButton checkprice,bookpackage,back;
    
    BookPackage(String username){
        this.username = username;
        setBounds(350,200,1100,500);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text = new JLabel("BOOK PACKAGE");
        text.setBounds(100,10,200,30);
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        add(text);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40,70,100,20);
        lblusername.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblusername);
        
        labelusername = new JLabel();
        labelusername.setBounds(250,70,200,20);
        labelusername.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labelusername);
        
        JLabel lblpackage = new JLabel("Select Package");
        lblpackage.setBounds(40,110,140,20);
        lblpackage.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblpackage);
        
        cpackage = new Choice();
        cpackage.add("Bronze Package");
        cpackage.add("Silver Package");
        cpackage.add("Gold Package");
        cpackage.setBounds(250,115,200,20);
        add(cpackage);
        
        JLabel lblnumber = new JLabel("Total Persons");
        lblnumber.setBounds(40,150,150,25);
        lblnumber.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblnumber);
        
        tfperson = new JTextField("1");
        tfperson.setBounds(250,150,200,20);
        add(tfperson);
        
        
        JLabel lblid = new JLabel("ID");
        lblid.setBounds(40,190,150,20);
        lblid.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblid);
        
        labelid = new JLabel();
        labelid.setBounds(250,190,150,25);
        add(labelid);
        
        JLabel lbnumber = new JLabel("Number");
        lbnumber.setBounds(40,230,150,25);
        lbnumber.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbnumber);
        
        labelnumber = new JLabel();
        labelnumber.setBounds(250,230,150,25);
        add(labelnumber);
        
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(40,270,150,20);
        lblphone.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblphone);
        
        labelphone = new JLabel();
        labelphone.setBounds(250,270,200,25);
        add(labelphone);
        
        JLabel lbltotal = new JLabel("Total Price");
        lbltotal.setBounds(40,310,150,25);
        lbltotal.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbltotal);
        
        labeltotal = new JLabel();
        labeltotal.setBounds(250,310,150,25);
        add(labeltotal);
        
        try {
            Conn c = new Conn();
            String query = "Select * from customer where username = '"+username+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelphone.setText(rs.getString("phone"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        
        checkprice = new JButton("Check Price");
        //checkprice.setBackground(Color.BLACK);
        //checkprice.setForeground(Color.WHITE);
        checkprice.setBounds(60,380,120,25);
        checkprice.addActionListener(this);
        add(checkprice);
        
        bookpackage = new JButton("Book Package");
        //bookpackage.setBackground(Color.BLACK);
        //bookpackage.setForeground(Color.WHITE);
        bookpackage.setBounds(200,380,120,25);
        bookpackage.addActionListener(this);
        add(bookpackage);
        
        back = new JButton("Back");
        //back.setBackground(Color.BLACK);
        //back.setForeground(Color.WHITE);
        back.setBounds(340,380,120,25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(550, 50, 500, 300);
        add(image);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == checkprice){
            String pack = cpackage.getSelectedItem();
            int cost = 0;
            if(pack.equals("Bronze Package")){
                cost += 12000;
            } else if (pack.equals("Silver Package")){
                cost += 24000;
            } else {
                cost += 32000;
            }
            
            int persons = Integer.parseInt(tfperson.getText());
            cost *= persons;
            labeltotal.setText("Rs "+cost);
        } else if(ae.getSource() == bookpackage){
            try{
                Conn c = new Conn();
                c.s.executeUpdate("insert into bookpackage values ('"+labelusername.getText()+"','"+cpackage.getSelectedItem()+"','"+tfperson.getText()+"','"+labelid.getText()+"','"+labelnumber.getText()+"','"+labelphone.getText()+"','"+labeltotal.getText()+"')");
                
                JOptionPane.showMessageDialog(null, "Package Booked Successfully");
                setVisible(false);
            } catch (Exception e){
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new BookPackage("");
    }
}
