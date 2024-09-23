
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MiniStatement extends JFrame{
    
    String pinNo;
    MiniStatement(String pinNo)
    {
        this.pinNo = pinNo;
        
        setLayout(null);
        setTitle("Mini Statement");
        
        JLabel bank  = new JLabel("INDIAN BANK");
        bank.setBounds(150,20,100,20);
        add(bank);
        
        JLabel card  = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);
        
        JLabel balanceText  = new JLabel();
        balanceText.setBounds(20,400,300,20);
        add(balanceText);
        
        JLabel mini = new JLabel();
        mini.setBounds(20,140,400,200);
        add(mini);
        
        //Query in login table
        try{
            Conn c = new Conn();
            //String query1="SELECT * FROM LOGIN WHERE pinNo='"+pinNo+"'";
            String query1="SELECT * FROM LOGIN WHERE pinNo='1234'";
            ResultSet rs1 = c.s.executeQuery(query1);
            
            while(rs1.next())
            {
                String cardFirst4 = rs1.getString("cardNo").substring(0,4);
                String cardLast4 = rs1.getString("cardNo").substring(12,16);
                
                card.setText("Card Number : " + cardFirst4+"-XXXX-XXXX-" + cardLast4 );  
            }                    
        }catch(Exception e){
            System.out.println(e);
        }
        
        //Query in login table

        try {
            Conn c = new Conn();
            String query2 = "SELECT * FROM BANK WHERE pinNo='" + pinNo + "'";
            //String query2 = "SELECT * FROM BANK WHERE pinNo='1234'";
            ResultSet rs2 = c.s.executeQuery(query2);
            mini.setText("<html>" + "Date" + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "Type" + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "Amount" + "<br><br>");
            String transactions = "";
            int balance = 0;
            
            while (rs2.next()) {
                transactions += rs2.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs2.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs2.getString("amount") + "<br><br>";
                
                if(rs2.getString("type").equals("Deposit"))
                balance+= Integer.parseInt(rs2.getString("amount"));
                else if(rs2.getString("type").equals("Withdraw"))
                balance-= Integer.parseInt(rs2.getString("amount"));
            }  
            balanceText.setText("Current account balance : Rs." + balance);
            mini.setText(mini.getText() + transactions + "</html>");
        } catch (Exception e) {
            System.out.println(e);
        }
        
        
        setSize(400,600);
        
        setLocation(20,20);
        //setUndecorated(true);
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }
public static void main(String args[])    
{
    new MiniStatement("");
}
}
