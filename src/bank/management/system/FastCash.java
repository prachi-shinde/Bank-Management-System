package bank.management.system;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    
    JButton b1,b2,b3,b4,b5,b6,b7;
    String pinNo;
    FastCash(String pinNo)
    {
        this.pinNo = pinNo;
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
    
        JLabel prompt = new JLabel("Select withdrawal amount :");
        prompt.setFont(new Font("System", Font.BOLD, 20));
        prompt.setForeground(Color.white);
        prompt.setBounds(205,285,400,25);
        image.add(prompt);   //adding prompt ON image or else image will hide prompt 
        
        b1 = new JButton("Rs. 100");
        b1.setFont(new Font("System", Font.BOLD, 14));
        b1.setForeground(Color.black);
        b1.setBackground(Color.white);
        b1.setBounds(180,350, 160,25);
        b1.addActionListener(this);
        image.add(b1);
        
        b2 = new JButton("Rs. 500");
        b2.setFont(new Font("System", Font.BOLD, 14));
        b2.setForeground(Color.black);
        b2.setBackground(Color.white);
        b2.setBounds(350,350, 160,25);b2.addActionListener(this);
        image.add(b2);
        
        b3 = new JButton("Rs. 1000");
        b3.setFont(new Font("System", Font.BOLD, 14));
        b3.setForeground(Color.black);
        b3.setBackground(Color.white);
        b3.setBounds(180,390, 160,25);
        b3.addActionListener(this);
        image.add(b3);
        
        b4 = new JButton("Rs. 2000");
        b4.setFont(new Font("System", Font.BOLD, 14));
        b4.setForeground(Color.black);
        b4.setBackground(Color.white);
        b4.setBounds(350,390, 160,25);
        b4.addActionListener(this);
        image.add(b4);
        
        b5 = new JButton("Rs. 5000");
        b5.setFont(new Font("System", Font.BOLD, 14));
        b5.setForeground(Color.black);
        b5.setBackground(Color.white);
        b5.setBounds(180,430, 160,25);
        b5.addActionListener(this);
        image.add(b5);
        
        b6 = new JButton("Rs. 10000");
        b6.setFont(new Font("System", Font.BOLD, 14));
        b6.setForeground(Color.black);
        b6.setBackground(Color.white);
        b6.setBounds(350,430, 160,25);
        b6.addActionListener(this);
        image.add(b6);
       
        b7 = new JButton("Back");
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
        if(ae.getSource()==b7)
        {
            setVisible(false);
            new Transactions(pinNo).setVisible(true);
        }
        else{
            String amo = ((JButton)ae.getSource()).getText();
            String amount = amo.substring(4);
            
            Conn c = new Conn();
            try{
                String query1 = "SELECT * FROM BANK WHERE pinNo='"+pinNo+"'";
                ResultSet rs = c.s.executeQuery(query1);
                int balance=0;
                
                while(rs.next())
                {
                    if(rs.getString("type").equals("Deposit"))
                    {
                        balance+=Integer.parseInt(rs.getString("amount"));  //Youll get a string value which you convetr into Integer to add in balance
                    }else{
                        balance-=Integer.parseInt(rs.getString("amount")); 
                    }
                }
                //b7(back button)
                if(ae.getSource()!=b7 && balance<Integer.parseInt(amount))
                {
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }
                
                Date date = new Date();
                String query2 =  "INSERT INTO BANK VALUES('"+pinNo+"','"+date +"', 'Withdrawal' ,'"+amount+"')";
                c.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null,"Rs."+amount+" Debited successfully.");
                
            }catch(Exception e)
            {
                System.out.println(e);
            }
                    
        }
                
         
    }
    
    public static void main(String args[])
    {
        new FastCash("");
    }
}
