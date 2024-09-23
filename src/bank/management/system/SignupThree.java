package bank.management.system;
import java.util.*;
import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;

public class SignupThree extends JFrame implements ActionListener{
    
    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit, cancel;
    String formno;
    SignupThree(String formno)
    {
        this.formno = formno;
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");
        setLayout(null);
        
        JLabel l1 = new JLabel("Page 3 : Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));   // in AWT package
        l1.setBounds(300,50,300,30);
        add(l1);
        
        JLabel type = new JLabel("Account Type ");
        type.setFont(new Font("Raleway", Font.BOLD, 22));  
        type.setBounds(100,140,200,30);
        add(type);
        
        r1 = new JRadioButton("Savings Account");
        r1.setBackground(Color.white);
        r1.setFont(new Font("Raleway", Font.BOLD, 16));  
        r1.setBounds(100, 180, 200, 25);
        add(r1);
        
        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setBackground(Color.white);
        r2.setFont(new Font("Raleway", Font.BOLD, 16));  
        r2.setBounds(350, 180, 200, 25);
        add(r2);
        
        r3 = new JRadioButton("Current Account");
        r3.setBackground(Color.white);
        r3.setFont(new Font("Raleway", Font.BOLD, 16));  
        r3.setBounds(100, 220, 200, 25);
        add(r3);
        
        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setBackground(Color.white);
        r4.setFont(new Font("Raleway", Font.BOLD, 16));  
        r4.setBounds(350, 220,250, 25);
        add(r4);
        
        ButtonGroup accountTypeGroup = new ButtonGroup();
        accountTypeGroup.add(r1);
        accountTypeGroup.add(r2);
        accountTypeGroup.add(r3);
        accountTypeGroup.add(r4);
        
        JLabel card = new JLabel("Card Number :");
        card.setFont(new Font("Raleway", Font.BOLD, 22));  
        card.setBounds(100, 300,200, 30);
        add(card);
        
        JLabel cNumber = new JLabel("XXXX-XXXX-XXXX-4184");
        cNumber.setFont(new Font("Raleway", Font.BOLD, 22));  
        cNumber.setBounds(350, 300,300, 30);
        add(cNumber);
        
        JLabel disclaim1 = new JLabel("This is your 16-digit card number.");
        disclaim1.setFont(new Font("Raleway", Font.ITALIC, 12));  
        disclaim1.setBounds(100, 330,300, 25);
        add(disclaim1);
        
        JLabel pin = new JLabel("PIN :");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));  
        pin.setBounds(100, 370,200, 30);
        add(pin);
        
        JLabel pinNumber = new JLabel("XXXX");
        pinNumber.setFont(new Font("Raleway", Font.BOLD, 22));  
        pinNumber.setBounds(350, 370,300, 30);
        add(pinNumber);
        
        JLabel disclaim2 = new JLabel("Your 4-digit password.");
        disclaim2.setFont(new Font("Raleway", Font.ITALIC, 12));  
        disclaim2.setBounds(100, 400,300, 25);
        add(disclaim2);
        
        JLabel services = new JLabel("Services Required :");
        services.setFont(new Font("Raleway", Font.BOLD, 22));  
        services.setBounds(100, 440,300, 30);
        add(services);
        
        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.white);
        c1.setFont(new Font("Raleway", Font.BOLD, 16));  
        c1.setBounds(100, 480, 200, 25);
        add(c1);
        
        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.white);
        c2.setFont(new Font("Raleway", Font.BOLD, 16));  
        c2.setBounds(350, 480, 200, 25);
        add(c2);
        
        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.white);
        c3.setFont(new Font("Raleway", Font.BOLD, 16));  
        c3.setBounds(100, 520, 200, 25);
        add(c3);
        
        c4 = new JCheckBox("Email & SMS Alerts");
        c4.setBackground(Color.white);
        c4.setFont(new Font("Raleway", Font.BOLD, 16));  
        c4.setBounds(350, 520, 200, 25);
        add(c4);
        
        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.white);
        c5.setFont(new Font("Raleway", Font.BOLD, 16));  
        c5.setBounds(100, 560, 200, 25);
        add(c5);
        
        c6 = new JCheckBox("E-statement");
        c6.setBackground(Color.white);
        c6.setFont(new Font("Raleway", Font.BOLD, 16));  
        c6.setBounds(350, 560, 200, 25);
        add(c6);
        
        c7 = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge.");
        c7.setBackground(Color.white);
        c7.setFont(new Font("Raleway", Font.BOLD, 12));  
        c7.setBounds(100, 640, 750, 20);
        add(c7);
        
        submit = new JButton("Submit");
        submit.setFont(new Font("Raleway", Font.BOLD, 16));
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setBounds(250, 690, 150, 30 );
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Raleway", Font.BOLD, 16));
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setBounds(440, 690, 150, 30);
        cancel.addActionListener(this);
        add(cancel);
        
        

        getContentPane().setBackground(Color.WHITE);
        setSize(850, 820);
        setLocation(350,0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==submit)
        {
            String accType = "";
            if(r1.isSelected())
            {
                accType = "Savings Account";
            }
            else if(r2.isSelected())
            {
                accType = "Fixed Deposit Account";
            }
            else if(r3.isSelected())
            {
                accType = "Current Account";
            }
            else if(r4.isSelected())
            {
                accType = "Recurring Deposit Account";
            }
            
            Random random = new Random();
            String cardNumber =  "" + Math.abs((random.nextLong()%90000000L)+5040936000000000L);
            
            String pinNumber = "" + Math.abs((random.nextLong()%9000L)+1000L);
            
            String facility = "";
            //
            
            if(c1.isSelected())
            {
                facility+=" ATM CARD";
            }
            else if(c2.isSelected())
            {
                facility+=" Internet Banking";
            }
            else if(c3.isSelected())
            {
                facility+=" Mobile Banking";
            }
            else if(c4.isSelected())
            {
                facility+=" Email & SMS Alerts";
            }
            else if(c5.isSelected())
            {
                facility+=" Cheque Book";
            }
            else if(c6.isSelected())
            {
                facility+=" E-statement";
            }
            
            
            
            try{
                if(accType.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Account Type is Required");
                }
                else
                {
                    Conn c = new Conn();
                    String query1 = "INSERT INTO signupThree values('" +formno + "','" + accType+ "','" +cardNumber+ "','" +pinNumber+ "','" +facility+ "')";
                    String query2 = "INSERT INTO login VALUES('"+formno+ "', '"+ cardNumber+ "','" +pinNumber+"')";
                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null, "Card Number : "+cardNumber+"\nPin : "+pinNumber);
                    setVisible(false);
                }
            }catch(Exception e)
            {
                System.out.println(e);
                
            }

        }
        else if(ae.getSource()==cancel){
            setVisible(false);
        }
        
            
    }
    public static void main(String args[])
    {
        new SignupThree("");
    }
}
