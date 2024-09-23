
package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class BalanceEnquiry extends JFrame implements ActionListener{
    
    String pinNo;    
    JButton back;
    
    BalanceEnquiry(String pinNo)
    {
        this.pinNo = pinNo;
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel prompt = new JLabel("Current balance :");
        prompt.setFont(new Font("System", Font.BOLD, 16));
        prompt.setForeground(Color.white);
        prompt.setBounds(160,320,200,35);
        image.add(prompt);
int balance=10;
        try{
            Conn c = new Conn();
            String query1 = "SELECT * FROM BANK WHERE pinNo='"+pinNo+"'";
            ResultSet rs = c.s.executeQuery(query1);
            
            while(rs.next())
            {
                if(rs.getString("type").equals("Deposit"))
                {
                    balance+=Integer.parseInt(rs.getString("amount"));  //Youll get a string value which you convetr into Integer to add in balance
                }
                else
                {
                    balance-=Integer.parseInt(rs.getString("amount")); 
                }
            }
            
            
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
        
        String str = ""+balance;
            JLabel balanceDisplay = new JLabel("Rs."+str);
            balanceDisplay.setFont(new Font("System", Font.BOLD, 16));
            balanceDisplay.setBounds(300,320,300,35);
            balanceDisplay.setForeground(Color.white);
            image.add(balanceDisplay);
        
        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
        
        
        
        setLayout(null);
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);  //The top white box with the title disappears
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        setVisible(false);
        new Transactions(pinNo).setVisible(true);
             
    }
    
    public static void main(String args[])
    {
        new BalanceEnquiry("");
    }
}

