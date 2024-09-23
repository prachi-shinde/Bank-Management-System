package bank.management.system;
//Make JDBC connectivity

//Register the driver
//Create connection
//Create Statement
//Execute Query
//Close connection

import java.sql.*;
//import java.Exception;

public class Conn {
    
    Connection c;
    Statement s;
    public Conn()
    {
        
        try{
            //Class.forName(com.mysql.ch.jdbc.Driver); Now Java register the driver by itself           //#1
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "root123");  //#2         
            s = c.createStatement();
            
        }catch(Exception e){
            System.out.println(e);
        }
            
        
    }
}
