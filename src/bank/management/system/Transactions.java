
package bank.management.system;
import javax.swing.*;
//import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener{
    
    JButton b1,b2,b3,b4,b5,b6,b7;
    String pinNo;
    Transactions(String pinNo)
    {
        this.pinNo = pinNo;
        setTitle("ATM Simulation");
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
    
        JLabel prompt = new JLabel("Please select your transaction");
        prompt.setFont(new Font("System", Font.BOLD, 20));
        prompt.setForeground(Color.white);
        prompt.setBounds(205,285,400,25);
        image.add(prompt);   //adding prompt ON image or else image will hide prompt 
        
        b1 = new JButton("Deposit");
        b1.setFont(new Font("System", Font.BOLD, 14));
        b1.setForeground(Color.black);
        b1.setBackground(Color.white);
        b1.setBounds(180,350, 160,25);
        b1.addActionListener(this);
        image.add(b1);
        
        b2 = new JButton("Cash Withdrawal");
        b2.setFont(new Font("System", Font.BOLD, 14));
        b2.setForeground(Color.black);
        b2.setBackground(Color.white);
        b2.setBounds(350,350, 160,25);b2.addActionListener(this);
        image.add(b2);
        
        b3 = new JButton("Fast Cash");
        b3.setFont(new Font("System", Font.BOLD, 14));
        b3.setForeground(Color.black);
        b3.setBackground(Color.white);
        b3.setBounds(180,390, 160,25);
        b3.addActionListener(this);
        image.add(b3);
        
        b4 = new JButton("Mini Statement");
        b4.setFont(new Font("System", Font.BOLD, 14));
        b4.setForeground(Color.black);
        b4.setBackground(Color.white);
        b4.setBounds(350,390, 160,25);
        b4.addActionListener(this);
        image.add(b4);
        
        b5 = new JButton("Pin Change");
        b5.setFont(new Font("System", Font.BOLD, 14));
        b5.setForeground(Color.black);
        b5.setBackground(Color.white);
        b5.setBounds(180,430, 160,25);
        b5.addActionListener(this);
        image.add(b5);
        
        b6 = new JButton("Balance Enquiry");
        b6.setFont(new Font("System", Font.BOLD, 14));
        b6.setForeground(Color.black);
        b6.setBackground(Color.white);
        b6.setBounds(350,430, 160,25);
        b6.addActionListener(this);
        image.add(b6);
       
        b7 = new JButton("Exit");
        b7.setFont(new Font("System", Font.BOLD, 14));
        b7.setForeground(Color.black);
        b7.setBackground(Color.white);
        b7.setBounds(350,470, 160,25);
        b7.addActionListener(this);
        image.add(b7);
        
        setLayout(null);
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);  //The top white box with the title disappears
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)//Deposit
        {
            setVisible(false);
            new Deposit(pinNo).setVisible(true);
        }
        else if(ae.getSource()==b2)  //Cash Withdrawal
        {
            setVisible(false);
            new Withdrawal(pinNo).setVisible(true);
        }
        else if(ae.getSource()==b3) //Fast Cash
        {
            setVisible(false);
            new FastCash(pinNo).setVisible(true);
        }
        else if(ae.getSource()==b4)  //Mini Statement
        {
            setVisible(false);
            new MiniStatement(pinNo).setVisible(true);
        }
        else if(ae.getSource()==b5)  //PIN change
        {
            setVisible(false);
            new PinChange(pinNo).setVisible(true);
        }
        else if(ae.getSource()==b6)
        {
            setVisible(false);
            new BalanceEnquiry(pinNo).setVisible(true);
        }
        else if(ae.getSource()==b7)  //Exit
        {
            System.exit(0);
        }
        
         
    }
            
    public static void main(String args[])
    {
        new Transactions("");
    }
}
