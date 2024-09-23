
package bank.management.system;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener{
    String pinNo;
    JPasswordField changedPin, rePin;
    JButton change, back;
    PinChange(String pinNo)
    {
        this.pinNo = pinNo;
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel prompt = new JLabel("Change your pin");
        prompt.setFont(new Font("System", Font.BOLD, 20));
        prompt.setForeground(Color.white);
        prompt.setBounds(250,280,500,35);
        image.add(prompt);
        
        JLabel prompt1 = new JLabel("New Pin :");
        prompt1.setFont(new Font("System", Font.BOLD, 16));
        prompt1.setForeground(Color.white);
        prompt1.setBounds(165,320,180,25);
        image.add(prompt1);
        
        changedPin = new JPasswordField();
        changedPin.setFont(new Font("Raleway", Font.BOLD, 22));
        changedPin.setBounds(330,320,180,30);
        image.add(changedPin);
        
        JLabel prompt2 = new JLabel("Re-enter new Pin :");
        prompt2.setFont(new Font("System", Font.BOLD, 16));
        prompt2.setForeground(Color.white);
        prompt2.setBounds(165,360,180,25);
        image.add(prompt2);
        
        rePin = new JPasswordField();
        rePin.setFont(new Font("Raleway", Font.BOLD, 22));
        rePin.setBounds(330,360,180,30);
        image.add(rePin);
        
        change = new JButton("Change");
        change.setBounds(355,520,150,30);
        change.addActionListener(this);
        image.add(change);
        
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
        if(ae.getSource()==change)
        {
            try{
                String pin1 = changedPin.getText();
                String pin2 = rePin.getText();
            
                if(!pin1.equals(pin2))
                {
                    JOptionPane.showMessageDialog(null,"The PINs you entered do not match."); 
                    return;
                }  
                
                if(pin1.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Please enter PIN");
                    return;
                }
                Conn c = new Conn();
                String query1 = "UPDATE bank SET pinNo='"+pin1+"' where pinNo='"+pinNo+"'";
                String query2 = "UPDATE login SET pinNo='"+pin1+"' where pinNo='"+pinNo+"'";
                String query3 = "UPDATE signupThree SET pinNo='"+pin1+"' where pinNo='"+pinNo+"'";
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);
                JOptionPane.showMessageDialog(null,"PIN changed successfully.");
                
                setVisible(false);
                new Transactions(pin1).setVisible(true);
            
            }catch(Exception e)
            {
                System.out.println(e);
            }
            
        }else if (ae.getSource()==back)
        {
            setVisible(false);
            new Transactions(pinNo).setVisible(true);
        }
             
    }
    
    public static void main(String args[])
    {
        new PinChange("");
    }
}
