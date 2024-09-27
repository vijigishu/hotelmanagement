/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelmanagementsystem;
import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author PCP
 */
public class conn {
    Connection c;
    Statement s;
    
    
    conn(){
       try{ Class.forName("com.mysql.cj.jdbc.Driver");
       c=DriverManager.getConnection("jdbc:mysql://localhost:3306/Hotelmanagementsystem","root","Vijigishu@04");
       s=c.createStatement();
       }
       catch(Exception e){
           JOptionPane.showMessageDialog(null,"please enter valid information");
           e.printStackTrace();
       }
        
    }
    public static void main(String[] args){
        
    }
}
