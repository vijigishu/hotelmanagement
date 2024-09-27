/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.*;

/**
 *
 * @author PCP
 */


/**
 *
 * @author PCP
 */
public class employee_info extends JFrame implements ActionListener {
    JTable table;
    JButton cancel;
   employee_info(){
        setBounds(230,100,950,600);
        getContentPane().setBackground(Color.white);
         setLayout(null);
        table=new JTable();
        table.setBounds(0,50,800,400);
        table.setFont(new Font("Tahoma",Font.PLAIN,12));
        add(table);
        try {
            conn c=new conn();
            
          ResultSet rs = c.s.executeQuery("select * from employee");
          table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        JLabel lblroom=new JLabel("name");
        lblroom.setBounds(0,30,70,20);
        add(lblroom);
        
        JLabel lblavailable=new JLabel("Age");
        lblavailable.setBounds(130,30,70,20);
        add(lblavailable);
        JLabel lblstatus=new JLabel("Gender");
        lblstatus.setBounds(230,30,60,20);
        add(lblstatus);
        JLabel lblprice=new JLabel("Job");
        lblprice.setBounds(350,30,80,20);
        add(lblprice);
        
        JLabel lbltype=new JLabel("Salary");
        lbltype.setBounds(460,30,80,20);
        add(lbltype);
        JLabel lblphone=new JLabel("phone");
        lblphone.setBounds(570,30,80,20);
        add(lblphone);
        JLabel lblmail=new JLabel("E-mail");
        lblmail.setBounds(710,30,80,20);
        add(lblmail);
        
         cancel=new JButton("<|=");
    cancel.setBackground(Color.BLACK);
    cancel.setForeground(Color.WHITE);
    cancel.setFont(new Font("serif",Font.BOLD,20));
    cancel.setBounds(0,10,60,20);
    cancel.addActionListener(this);
    add(cancel);
        
       
        setVisible(true);
        
    }
   public void  actionPerformed(ActionEvent k){
       if(k.getSource()==cancel){
           setVisible(false);
           new reception();
       }
   }
   public static void main(String args[]){
       new employee_info();
   }
    
}
