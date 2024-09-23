package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.text.SimpleDateFormat;

//import java.Math;

public class SignupTwo extends JFrame implements ActionListener{ 
    
    
    JTextField aadharField, panField;
    JRadioButton yesSenior, noSenior, yesExist, noExist;
    JComboBox religion,category, income, education, occupation;
    JButton next1;
    String formno;
    
    SignupTwo(String formno)
    {
        this.formno = formno;
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2"); 

        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);
        
        JLabel religionLabel = new JLabel("Religion :");
        religionLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        religionLabel.setBounds(100,140,100,30);
        add(religionLabel);
        
        String arrReligion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religion = new JComboBox(arrReligion);
        religion.setBackground(Color.white);
        religion.setBounds(300,140,400,30);
        add(religion);
        
    
        JLabel categoryLabel = new JLabel("Category :");
        categoryLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        categoryLabel.setBounds(100,190,200,30);
        add(categoryLabel);
        
        String arrCategory[] = {"General","OBC","SC", "ST", "Other"};
        category = new JComboBox(arrCategory);
        category.setBackground(Color.white);
        category.setBounds(300,190,400,30);
        add(category);

        
        JLabel incomeLabel = new JLabel("Income :");
        incomeLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        incomeLabel.setBounds(100,240,200,30);
        add(incomeLabel);
        
        String arrIncome[] = {"NULL", "< 1,50,000", "< 2,50,000", "< 5,00,000", "Upto 10,00,000"};
        income = new JComboBox(arrIncome);
        income.setBackground(Color.white);
        income.setBounds(300,240,400,30);
        add(income);

        JLabel educationLabel = new JLabel("Educational");
        educationLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        educationLabel.setBounds(100,290,200,30);
        add(educationLabel);
        
        JLabel qualification = new JLabel("Qualification :");
        qualification.setFont(new Font("Raleway", Font.BOLD, 20));
        qualification.setBounds(100,320,200,30);
        add(qualification);
        
        String arrEducation[]  = {"Non-Graduate", "Graduate", "Post-Graduate", "Doctrate", "Other"};
        education = new JComboBox(arrEducation);
        education.setBackground(Color.white);
        education.setBounds(300,290,400,30);
        add(education);   
        
        JLabel occupationLabel = new JLabel("Occupation :");
        occupationLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        occupationLabel.setBounds(100,390,200,30);
        add(occupationLabel);
        
        String arrOccupation[]  = {"Salaried", "Self-employed", "Business", "Student", "Other"};
        occupation = new JComboBox(arrOccupation);
        occupation.setBackground(Color.white);
        occupation.setBounds(300,390,400,30);
        add(occupation);

        
        JLabel panLabel = new JLabel("PAN No. :");
        panLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        panLabel.setBounds(100,440,200,30);
        add(panLabel);
        
        panField = new JTextField();
        panField.setFont(new Font("Raleway", Font.BOLD, 14));
        panField.setBounds(300,440,400,30);
        add(panField);
        
        JLabel aadhar = new JLabel("Aadhar No. :");
        aadhar.setFont(new Font("Raleway", Font.BOLD, 20));
        aadhar.setBounds(100,490,200,30);
        add(aadhar);
        
        aadharField = new JTextField();
        aadharField.setFont(new Font("Raleway", Font.BOLD, 14));
        aadharField.setBounds(300,490,400,30);
        add(aadharField);
        
        JLabel senior = new JLabel("Senior Citizen :");
        senior.setFont(new Font("Raleway", Font.BOLD, 20));
        senior.setBounds(100,540,200,30);
        add(senior);
        
        yesSenior = new JRadioButton("Yes");
        yesSenior.setBackground(Color.white);
        yesSenior.setBounds(300,540,50,30);
        add(yesSenior);
        
        noSenior = new JRadioButton("No");
        noSenior.setBackground(Color.white);
        noSenior.setBounds(400,540,50,30);
        add(noSenior);
        
        ButtonGroup seniorGroup = new ButtonGroup();
        seniorGroup.add(yesSenior);
        seniorGroup.add(noSenior);
        
        
        JLabel existing = new JLabel("Existing Account :");
        existing.setFont(new Font("Raleway", Font.BOLD, 20));
        existing.setBounds(100,590,200,30);
        add(existing);
        
        yesExist = new JRadioButton("Yes");
        yesExist.setBackground(Color.white);
        yesExist.setBounds(300,590,50,30);
        add(yesExist);
        
        noExist = new JRadioButton("No");
        noExist.setBackground(Color.white);
        noExist.setBounds(400,590,50,30);
        add(noExist);
        
        ButtonGroup exist = new ButtonGroup();
        exist.add(yesExist);
        exist.add(noExist);
   
        
        next1  = new JButton("Next");
        next1.setBackground(Color.BLACK);
        next1.setForeground(Color.WHITE);
        next1.setBounds(600,640, 100, 30);
        next1.addActionListener(this);     
        add(next1);
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(850,800);
        setLocation(350, 10); 
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        String religionVal = (String)religion.getSelectedItem();  
        String categoryVal = (String) category.getSelectedItem();  
        String incomeVal = (String) income.getSelectedItem();  
        String educationVal = (String) education.getSelectedItem();  
        String occupationVal = (String) occupation.getSelectedItem();  
        
        String panNo = panField.getText();
        String aadharNo = aadharField.getText();
       
        String seniorVal = null;
        if(yesSenior.isSelected())
            seniorVal = "Yes";
        else if(noSenior.isSelected())
            seniorVal = "No";
        
        
        String existingVal = null;
        if(yesExist.isSelected())
            existingVal = "Yes";
        else if(noExist.isSelected())
            existingVal = "No";
       
        //hit the database
        //Because database is an external entity , runtime errors may occur
        try{
            //Put validation error message
            //Just one put here, you can put it for all variables
            if(aadharNo.equals(""))
                JOptionPane.showMessageDialog(null, "Name field is required");
            else
            {
            //establish connection using Conn class
                Conn c = new Conn();
            //signupTwo table
            
                String  query = "INSERT into signuptwo values( '" +formno + "', '"+ religionVal + "', '" + categoryVal + "', '"+ incomeVal + "', '"+ educationVal + "', '"+ occupationVal+ "', '"+ panNo+ "', '"+aadharNo+ "', '"+existingVal+ "', '"+seniorVal+"')";
                
                c.s.executeUpdate(query); //run DML query
                
                setVisible(false);
                new SignupThree(formno).setVisible(true);
                
            }
                
        }catch(Exception e)
        {
            System.out.println(e);
        }

    }
    public static void main(String args[])
    {
        new SignupTwo("");
    }
}
