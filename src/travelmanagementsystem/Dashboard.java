package travelmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author mathewthomas
 */
public class Dashboard extends JFrame implements ActionListener{
    
    String username;
    JButton addpersonaldetails,updatepersonaldetails,viewpersonaldetails,deletepersonaldetails,checkpackages,bookpackage,viewpackage,viewhotels,bookhotel,viewbookedhotel,destinations,payments,calculator,notepad,about;
    

    Dashboard(String username) {
        this.username = username;
        //setBounds(0,0,1700,1200);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0, 0, 102));
        p1.setBounds(0, 0, 1700, 65);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
        Image i2 = i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(5, 0, 70, 70);
        p1.add(image);

        JLabel heading = new JLabel("Dashboard");
        heading.setBounds(80, 10, 300, 40);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        p1.add(heading);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0, 0, 102));
        p2.setBounds(0, 65, 300, 1000);
        add(p2);

        addpersonaldetails = new JButton("Add Personal Details");
        addpersonaldetails.setBounds(0, 0, 300, 50);
        addpersonaldetails.setBackground(new Color(0, 0, 102));
        addpersonaldetails.setForeground(Color.BLACK);
        addpersonaldetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        addpersonaldetails.setMargin(new Insets(0, 0, 0, 60));
        addpersonaldetails.addActionListener(this);
        p2.add(addpersonaldetails);

        updatepersonaldetails = new JButton("Update Personal Details");
        updatepersonaldetails.setBounds(0, 50, 300, 50);
        updatepersonaldetails.setBackground(new Color(0, 0, 102));
        updatepersonaldetails.setForeground(Color.BLACK);
        updatepersonaldetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        updatepersonaldetails.addActionListener(this);
        updatepersonaldetails.setMargin(new Insets(0, 0, 0, 30));
        
        p2.add(updatepersonaldetails);

        viewpersonaldetails = new JButton("View Details");
        viewpersonaldetails.setBounds(0, 100, 300, 50);
        viewpersonaldetails.setBackground(new Color(0, 0, 102));
        viewpersonaldetails.setForeground(Color.BLACK);
        viewpersonaldetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewpersonaldetails.setMargin(new Insets(0, 0, 0, 125));
        viewpersonaldetails.addActionListener(this);
        p2.add(viewpersonaldetails);

        deletepersonaldetails = new JButton("Delete Personal Details");
        deletepersonaldetails.setBounds(0, 150, 300, 50);
        deletepersonaldetails.setBackground(new Color(0, 0, 102));
        deletepersonaldetails.setForeground(Color.BLACK);
        deletepersonaldetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        deletepersonaldetails.addActionListener(this);
        deletepersonaldetails.setMargin(new Insets(0, 0, 0, 30));
        
        p2.add(deletepersonaldetails);

        checkpackages = new JButton("Check Packages");
        checkpackages.setBounds(0, 200, 300, 50);
        checkpackages.setBackground(new Color(0, 0, 102));
        checkpackages.setForeground(Color.BLACK);
        checkpackages.setFont(new Font("Tahoma", Font.PLAIN, 20));
        checkpackages.setMargin(new Insets(0, 0, 0, 95));
        checkpackages.addActionListener(this);
        p2.add(checkpackages);

        bookpackage = new JButton("Book Package");
        bookpackage.setBounds(0, 250, 300, 50);
        bookpackage.setBackground(new Color(0, 0, 102));
        bookpackage.setForeground(Color.BLACK);
        bookpackage.setFont(new Font("Tahoma", Font.PLAIN, 20));
        bookpackage.setMargin(new Insets(0, 0, 0, 110));
        bookpackage.addActionListener(this);
        p2.add(bookpackage);

        viewpackage = new JButton("View Package");
        viewpackage.setBounds(0, 300, 300, 50);
        viewpackage.setBackground(new Color(0, 0, 102));
        viewpackage.setForeground(Color.BLACK);
        viewpackage.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewpackage.setMargin(new Insets(0, 0, 0, 110));
        viewpackage.addActionListener(this);
        p2.add(viewpackage);

        viewhotels = new JButton("View Hotels");
        viewhotels.setBounds(0, 350, 300, 50);
        viewhotels.setBackground(new Color(0, 0, 102));
        viewhotels.setForeground(Color.BLACK);
        viewhotels.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewhotels.setMargin(new Insets(0, 0, 0, 120));
        viewhotels.addActionListener(this);
        p2.add(viewhotels);

        bookhotel = new JButton("Book Hotel");
        bookhotel.setBounds(0, 400, 300, 50);
        bookhotel.setBackground(new Color(0, 0, 102));
        bookhotel.setForeground(Color.BLACK);
        bookhotel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        bookhotel.setMargin(new Insets(0, 0, 0, 125));
        bookhotel.addActionListener(this);
        p2.add(bookhotel);

        viewbookedhotel = new JButton("View Booked Hotel");
        viewbookedhotel.setBounds(0, 450, 300, 50);
        viewbookedhotel.setBackground(new Color(0, 0, 102));
        viewbookedhotel.setForeground(Color.BLACK);
        viewbookedhotel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewbookedhotel.setMargin(new Insets(0, 0, 0, 55));
        viewbookedhotel.addActionListener(this);
        p2.add(viewbookedhotel);

        destinations = new JButton("Destinations");
        destinations.setBounds(0, 500, 300, 50);
        destinations.setBackground(new Color(0, 0, 102));
        destinations.setForeground(Color.BLACK);
        destinations.setFont(new Font("Tahoma", Font.PLAIN, 20));
        destinations.setMargin(new Insets(0, 0, 0, 115));
        destinations.addActionListener(this);
        p2.add(destinations);

        about = new JButton("About");
        about.setBounds(0, 550, 300, 50);
        about.setBackground(new Color(0, 0, 102));
        about.setForeground(Color.BLACK);
        about.setFont(new Font("Tahoma", Font.PLAIN, 20));
        about.setMargin(new Insets(0, 0, 0, 160));
        about.addActionListener(this);
        p2.add(about);

        JLabel version = new JLabel("Version : 1.008.2024");
        version.setBounds(0, 850, 300, 40);
        version.setForeground(Color.WHITE);
        version.setFont(new Font("Tahoma", Font.BOLD, 15));
        p2.add(version);
        
        JLabel copyright = new JLabel("Copyrighted to Christ University");
        copyright.setBounds(0, 870, 300, 40);
        copyright.setForeground(Color.WHITE);
        copyright.setFont(new Font("Tahoma", Font.BOLD, 15));
        p2.add(copyright);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i5 = i4.getImage().getScaledInstance(1700, 1000, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel home = new JLabel(i6);
        home.setBounds(0, 0, 1700, 1000);
        add(home);
        
        JLabel text = new JLabel("Welcome to Christ Travels");
        text.setBounds(700, 70, 1000, 70);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway", Font.PLAIN, 40));
        home.add(text);

        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == addpersonaldetails){
            new AddCustomer(username);
        } else if (ae.getSource() == viewpersonaldetails){
            new ViewCustomer(username);
        } else if (ae.getSource() == updatepersonaldetails){
            new UpdateCustomer(username);
        } else if (ae.getSource() == checkpackages){
            new CheckPackage();
        } else if(ae.getSource() == bookpackage){
            new BookPackage(username);
        } else if(ae.getSource() == viewpackage){
            new ViewPackage(username);
        } else if(ae.getSource() == viewhotels){
            new CheckHotels();
        } else if(ae.getSource() == destinations){
            new Destinations();
        } else if(ae.getSource() == bookhotel){
            new BookHotel(username);
        } else if(ae.getSource() == viewbookedhotel){
            new ViewHotel(username);
        } else if(ae.getSource() == about){
            new About();
        } else if(ae.getSource() == deletepersonaldetails){
            new DeleteDetails(username);
        }
    }

    public static void main(String[] args) {
        new Dashboard("");
    }
}
