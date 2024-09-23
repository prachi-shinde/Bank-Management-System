package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.text.SimpleDateFormat;

//import java.Math;

public class SignupOne extends JFrame implements ActionListener{ 
    
    long random;
    JTextField nameField, fnameField, emailField, addressField, cityField, stateField, pincodeField;
    JDateChooser dateField;
    JRadioButton female, male, other, married, unmarried, otherMarital;
    JButton next;
    
    SignupOne()
    {
        setTitle("NEW APPLICATION FORM - PAGE 1"); 
        
        Random ran = new Random();
        random = Math.abs((ran.nextLong()%9000L) + 1000L);  
        
        JLabel formNo = new JLabel("APPLICATION FORM NO.: "+random);
        formNo.setFont(new Font("Raleway", Font.BOLD, 34));
        formNo.setBounds(150,20,600,40);
        add(formNo);

        JLabel personDetails = new JLabel("Page 1: Personal Details");
        personDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personDetails.setBounds(290,80,400,30);
        add(personDetails);
        
        JLabel name = new JLabel("Name :");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100,140,100,30);
        add(name);
        
        nameField = new JTextField();
        nameField.setFont(new Font("Raleway", Font.BOLD, 14));
        nameField.setBounds(300,140,400,30);
        add(nameField);
        
        JLabel fname = new JLabel("Father's Name :");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100,190,200,30);
        add(fname);
        
        fnameField = new JTextField();
        fnameField.setFont(new Font("Raleway", Font.BOLD, 14));
        fnameField.setBounds(300,190,400,30);
        add(fnameField);
        
        JLabel dob = new JLabel("Date of Birth :");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100,240,200,30);
        add(dob);
        
        dateField = new JDateChooser();
        dateField.setBounds(300,240,400,30);
        //dateField.setForeground(new Color(105,105,105));
        add(dateField);        

        JLabel gender = new JLabel("Gender :");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100,290,200,30);
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(300,290,80,30);
        male.setBackground(Color.WHITE);
        add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(450,290,80,30);
        female.setBackground(Color.WHITE);
        add(female);
        
        other = new JRadioButton("Other");
        other.setBounds(600,290,80,30);
        other.setBackground(Color.WHITE);
        add(other);
        
        //You have to explicitly handle for just one radio button to be selected
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(other);
        
        JLabel email = new JLabel("Email address :");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100,340,200,30);
        add(email);
        
        emailField = new JTextField();
        emailField.setFont(new Font("Raleway", Font.BOLD, 14));
        emailField.setBounds(300,340,400,30);
        add(emailField);
        
        JLabel marital = new JLabel("Marital Status:");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100,390,200,30);
        add(marital);
        
        married = new JRadioButton("Married");
        married.setBounds(300,390,80,30);
        married.setBackground(Color.WHITE);
        add(married);
        
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450,390,90,30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        
        otherMarital = new JRadioButton("Other");
        otherMarital.setBounds(600,390,80,30);
        otherMarital.setBackground(Color.WHITE);
        add(otherMarital);
        
        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unmarried);
        maritalGroup.add(otherMarital);
        
        JLabel address = new JLabel("Address :");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100,440,200,30);
        add(address);
        
        addressField = new JTextField();
        addressField.setFont(new Font("Raleway", Font.BOLD, 14));
        addressField.setBounds(300,440,400,30);
        add(addressField);
        
        JLabel city = new JLabel("City :");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100,490,200,30);
        add(city);
        
        cityField = new JTextField();
        cityField.setFont(new Font("Raleway", Font.BOLD, 14));
        cityField.setBounds(300,490,400,30);
        add(cityField);
        
        JLabel state = new JLabel("State :");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100,540,200,30);
        add(state);
        
        stateField = new JTextField();
        stateField.setFont(new Font("Raleway", Font.BOLD, 14));
        stateField.setBounds(300,540,400,30);
        add(stateField);
        
        
        JLabel pincode = new JLabel("Pincode :");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100,590,200,30);
        add(pincode);
        
        pincodeField = new JTextField();
        pincodeField.setFont(new Font("Raleway", Font.BOLD, 14));
        pincodeField.setBounds(300,590,400,30);
        add(pincodeField);
        
        next  = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(600,640, 100, 30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(850,800);
        setLocation(350, 10); 
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        
        //Insert all string values in SQL database
        String formno = "" + random;       //toString conversion
        //nameField, fnameField, 
        String name = nameField.getText();
        String fname = fnameField.getText();
        
        //String dob = ((JTextField) dateField.getDateEditor().getUIComponent()).getText();
        Date selectedDate = dateField.getDate();
        // Define the date format you want
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        // Format the date to a string
        String dob = dateFormat.format(selectedDate);
        
        String gender = null;
        if(male.isSelected())
            gender = "male";
        else if(female.isSelected())
            gender = "female";
        else if(other.isSelected())
            gender = "other";
        
        String marital = null;
        if(married.isSelected())
            marital = "married";
        else if(unmarried.isSelected())
            marital = "unmarried";
        else if(otherMarital.isSelected())
            marital = "otherMarital";
        
        String email = emailField.getText();
        String address = addressField.getText();
        String city = cityField.getText();
        String state = stateField.getText();
        String pincode  = pincodeField.getText();
        //hit the database
        //Because database is an external entity , runtime errors may occur
        try{
            //Put validation error message
            //Just one put here, you can put it for all variables
            if(name.equals(""))
                JOptionPane.showMessageDialog(null, "Name field is required");
            else
            {
            //establish connection using Conn class
                Conn c = new Conn();
            //#3
            // insert into signup table query -> //values('1223', '')
            
                String  query = "INSERT into signup values( '" +formno + "', '"+ name + "', '" + fname + "', '"+dob + "', '"+ gender + "', '"+marital+ "', '"+email+ "', '"+address+ "', '"+city + "', '"+pincode+ "', '"+state+"')";
                c.s.executeUpdate(query); //run DML query
                
                //After execution open Page 2
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
            
            
                
        }catch(Exception e)
        {
            System.out.println(e);
        }

    }
    public static void main(String args[])
    {
        new SignupOne();
    }
}
