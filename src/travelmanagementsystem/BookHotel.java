package travelmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
/**
 *
 * @author mathewthomas
 */
public class BookHotel extends JFrame implements ActionListener{
    
    Choice chotel, cac, cfood;
    JTextField tfperson, tfdays;
    String username;
    JLabel labelusername,labelnumber,labelphone,labeltotal, labelid;
    JButton checkprice,bookhotel,back;
    
    BookHotel(String username){
        this.username = username;
        setBounds(350,200,1100,600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text = new JLabel("BOOK HOTEL");
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
        
        JLabel lblpackage = new JLabel("Select Hotel");
        lblpackage.setBounds(40,110,140,20);
        lblpackage.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblpackage);
        
        chotel = new Choice();
        chotel.setBounds(250,115,200,20);
        add(chotel);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from hotel");
            while(rs.next()){
                chotel.add(rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JLabel lblnumber = new JLabel("Total Persons");
        lblnumber.setBounds(40,150,150,25);
        lblnumber.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblnumber);
        
        tfperson = new JTextField("1");
        tfperson.setBounds(250,150,200,20);
        add(tfperson);
        
        JLabel lblday = new JLabel("No.of Days");
        lblday.setBounds(40,190,150,25);
        lblday.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblday);
        
        tfdays = new JTextField("");
        tfdays.setBounds(250,190,200,20);
        add(tfdays);
       
        
        JLabel lbac = new JLabel("AC / Non-AC");
        lbac.setBounds(40,230,150,25);
        lbac.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbac);
        
        cac = new Choice();
        cac.add("AC");
        cac.add("Non-AC");
        cac.setBounds(250,230,200,20);
        add(cac);
        
        JLabel lblfood = new JLabel("Food Included");
        lblfood.setBounds(40,270,150,20);
        lblfood.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblfood);
        
        cfood = new Choice();
        cfood.add("Yes");
        cfood.add("No");
        cfood.setBounds(250,270,200,20);
        add(cfood);
        
        JLabel lblid = new JLabel("ID");
        lblid.setBounds(40,310,150,20);
        lblid.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblid);
        
        labelid = new JLabel();
        labelid.setBounds(250,310,150,25);
        add(labelid);
        
        JLabel lbnumber = new JLabel("Number");
        lbnumber.setBounds(40,350,150,25);
        lbnumber.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbnumber);
        
        labelnumber = new JLabel();
        labelnumber.setBounds(250,350,150,25);
        add(labelnumber);
        
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(40,390,150,20);
        lblphone.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblphone);
        
        labelphone = new JLabel();
        labelphone.setBounds(250,390,200,25);
        add(labelphone);
        
        JLabel lbltotal = new JLabel("Total Price");
        lbltotal.setBounds(40,430,150,25);
        lbltotal.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbltotal);
        
        labeltotal = new JLabel();
        labeltotal.setBounds(250,430,150,25);
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
        checkprice.setBounds(60,490,120,25);
        checkprice.addActionListener(this);
        add(checkprice);
        
        bookhotel = new JButton("Book Package");
        //bookhotel.setBackground(Color.BLACK);
        //bookhotel.setForeground(Color.WHITE);
        bookhotel.setBounds(200,490,120,25);
        bookhotel.addActionListener(this);
        add(bookhotel);
        
        back = new JButton("Back");
        //back.setBackground(Color.BLACK);
        //back.setForeground(Color.WHITE);
        back.setBounds(340,490,120,25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500, 50, 600, 300);
        add(image);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == checkprice){
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("Select * from hotel where name ='"+chotel.getSelectedItem()+"'");
                while(rs.next()){
                    int cost = Integer.parseInt(rs.getString("costperperson"));
                    int food = Integer.parseInt(rs.getString("foodincluded"));
                    int ac = Integer.parseInt(rs.getString("acroom"));
                    
                    int persons = Integer.parseInt(tfperson.getText());
                    int days = Integer.parseInt(tfdays.getText());
                    
                    String acselected = cac.getSelectedItem();
                    String foodselected = cfood.getSelectedItem();
                    
                    if (persons * days > 0){
                        int total = 0;
                        total += acselected.equals("AC") ? ac : 0;
                        total += foodselected.equals("Yes") ? food : 0;
                        total += cost;
                        total = total * persons * days;
                        labeltotal.setText("Rs "+total);
                    } else {
                        JOptionPane.showMessageDialog(null, "Please Enter a Valid number");
                    }
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        } else if(ae.getSource() ==  bookhotel){
            try{
                Conn c = new Conn();
                c.s.executeUpdate("insert into bookhotel values ('"+labelusername.getText()+"','"+chotel.getSelectedItem()+"','"+tfperson.getText()+"','"+tfdays.getText()+"','"+cac.getSelectedItem()+"','"+cfood.getSelectedItem()+"','"+labelid.getText()+"','"+labelnumber.getText()+"','"+labelphone.getText()+"','"+labeltotal.getText()+"')");
                
                JOptionPane.showMessageDialog(null, "Hotel Booked Successfully");
                setVisible(false);
            } catch (Exception e){
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new BookHotel("");
    }
}
