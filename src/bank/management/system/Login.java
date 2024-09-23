package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    //we need to use these buttons in constructor and the function def of actionPerformed also
    //thus declaring globally
    JButton signIn, clear, signUp;
    JTextField cardTextField;
    JPasswordField pinTextField;
    Login()
    {
        setTitle("Automated Teller Machine"); 

        getContentPane().setBackground(Color.WHITE);
 
        //Top Bank Icon
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label1 = new JLabel(i3); //pass image into JLabel
        label1.setBounds(100,10,100,100);
        add(label1);
        
        //Title next to Icon
        JLabel titleText = new JLabel("Welcome to ATM");
        titleText.setFont(new Font("Osward", Font.BOLD, 36));
        titleText.setBounds(240,40,350,40);
        add(titleText);
        
        //Card no        
        JLabel cardNo = new JLabel("Card No. :");
        cardNo.setFont(new Font("Raleway", Font.BOLD, 26));
        cardNo.setBounds(180,170, 150, 30 );
        add(cardNo);
        
        //Card no Text field
        cardTextField = new JTextField();
        cardTextField.setBounds(360, 170, 210, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTextField);
        
        //PIN
        JLabel pin = new JLabel("PIN :");
        pin.setFont(new Font("Raleway", Font.BOLD, 26));
        pin.setBounds(180,230, 150, 30 );
        add(pin);
        
        //PIN Textfield
        pinTextField = new JPasswordField();
        pinTextField.setBounds(360, 235, 210, 30);
        add(pinTextField);
        
        //Button SignIn
        signIn = new JButton("SignIn");
        signIn.setBounds(360, 300, 100, 30);
        signIn.setBackground(Color.BLACK);
        signIn.setForeground(Color.WHITE);
        signIn.addActionListener(this);
        add(signIn);
        
        //Button Clear
        clear = new JButton("Clear");
        clear.setBounds(470,300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        //Button SignUp
        signUp = new JButton("SignUp");
        signUp.setBounds(360,360, 210, 30);
        signUp.setBackground(Color.BLACK);
        signUp.setForeground(Color.WHITE);
        signUp.addActionListener(this);
        add(signUp);
        
       
        setLayout(null);
        setSize(800,600);
        setLocation(350, 150); 
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        //to check which button exactly was clicked
            if(ae.getSource() == clear)
            {
                cardTextField.setText("");
                pinTextField.setText("");
            }else if(ae.getSource() == signUp)
            {   
                setVisible(false); //5040936065029003
                new SignupOne().setVisible(true);
            }else if(ae.getSource() == signIn)
            {
                Conn c = new Conn();
                String cardNum = cardTextField.getText();
                String pinNum = pinTextField.getText();
                
                String query1 = "SELECT * FROM LOGIN WHERE cardNo='"+cardNum+"' and pinNo='"+pinNum+"';";
                try{
                    ResultSet rs = c.s.executeQuery(query1);  //for DQL command executeQuery
                    if(rs.next())
                    {
                        setVisible(false);
                        new Transactions(pinNum).setVisible(true);
                    }else
                    {
                        //5040936065029003    11281000
//                       
                        JOptionPane.showMessageDialog(null, "Incorrect credentials.");
                    }                    
                }catch(Exception e)
                {
                    System.out.println(e);
                }
            }           
    }
    public static void main(String[] args) 
    {
        new Login();
    }
    
}
