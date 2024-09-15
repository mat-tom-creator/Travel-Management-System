package travelmanagementsystem;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author mathewthomas
 */
public class Loading extends JFrame implements Runnable{
    
    Thread t;
    JProgressBar bar;
    String username;
    
    Loading(String username){
        this.username = username;
        t = new Thread(this);
        setBounds(550,350,650,400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("Travel and Tourism");
        text.setBounds(145,20,600,40);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Raleway", Font.BOLD, 35));
        add(text);
        
        bar = new JProgressBar();
        bar.setBounds(175,100,300,80);
        bar.setStringPainted(true);
        add(bar);
        
        JLabel loading = new JLabel("Loading, please wait.....");
        loading.setBounds(180,160,300,30);
        loading.setForeground(Color.BLACK);
        loading.setFont(new Font("Raleway", Font.BOLD, 25));
        add(loading);
        
        JLabel lblusername = new JLabel("Welcome, "+username);
        lblusername.setBounds(260,310,400,40);
        lblusername.setForeground(Color.BLACK);
        lblusername.setFont(new Font("Raleway", Font.BOLD, 16));
        add(lblusername);
        
        t.start();
        setVisible(true);
    }
    
    public void run(){
        try{
            for(int i = 1; i<=101; i++){
                int max = bar.getMaximum();
                int value = bar.getValue();
                
                if(value < max){
                    bar.setValue(bar.getValue() + 1);
                } else {
                    setVisible(false);
                    new Dashboard(username);
                }
                Thread.sleep(50);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args){
        new Loading("");
    }
}
