/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelmanagementsystem;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.*;
/**
 *
 * @author PCP
 */
public class Department extends JFrame implements ActionListener{
    JTable t;
    JButton cancel;
    Department(){
        setBounds(200,150,750,600);
         getContentPane().setBackground(Color.white);
        setLayout(null);
        t=new JTable();
       t.setBounds(0,50,600,400);
       add(t);
       try{
           conn c=new conn();
            
          ResultSet rs = c.s.executeQuery("select * from department");
          t.setModel(DbUtils.resultSetToTableModel(rs));
       }
       catch(Exception e){
           e.printStackTrace();
       }
       
       JLabel job =new JLabel("Job");
       job.setBounds(2,30,100,20);
       add(job);
       JLabel Budget =new JLabel("Budget");
       Budget.setBounds(300,30,100,20);
       add(Budget);
        cancel=new JButton("<|=");
    cancel.setBackground(Color.BLACK);
    cancel.setForeground(Color.WHITE);
    cancel.setFont(new Font("serif",Font.BOLD,20));
    cancel.setBounds(0,10,60,20);
    cancel.addActionListener(this);
    add(cancel);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==cancel){
            setVisible(false);
            new reception();
        }
    }
    
    public static void main(String args[]){
        new Department();
    }
}
