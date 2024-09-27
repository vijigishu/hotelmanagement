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
public class customer_info extends JFrame implements ActionListener{
   JTable t;
   JButton cancel;
    customer_info(){
        setBounds(200,100,850,600);
        getContentPane().setBackground(Color.white);
         setLayout(null);
       t=new JTable();
       t.setBounds(0,50,800,500);
       add(t);
       try {
            conn c=new conn();
            
          ResultSet rs = c.s.executeQuery("select * from customers_info");
          t.setModel(DbUtils.resultSetToTableModel(rs));
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
       JLabel id =new JLabel("ID Form");
       id.setBounds(2,25,100,20);
       add(id);
       JLabel number =new JLabel("ID Number");
       number.setBounds(90,25,100,20);
       add(number);
       JLabel name =new JLabel("Name");
       name.setBounds(180,25,100,20);
       add(name);
       JLabel gender =new JLabel("Gender");
       gender.setBounds(270,25,100,20);
       add(gender);
       JLabel country =new JLabel("Country");
       country.setBounds(350,25,100,20);
       add(country);
        JLabel room_n =new JLabel("Room No");
       room_n.setBounds(450,25,100,20);
       add(room_n);
       JLabel Date =new JLabel("checkin date");
       Date.setBounds(530,25,100,20);
       add(Date);
       JLabel deposit=new JLabel("Deposit");
       deposit.setBounds(620,25,100,20);
       add(deposit);
       JLabel roomtype=new JLabel("Room type");
       roomtype.setBounds(720,25,100,20);
       add(roomtype);
       cancel=new JButton("<|=");
    cancel.setBackground(Color.BLACK);
    cancel.setForeground(Color.WHITE);
    cancel.setFont(new Font("serif",Font.BOLD,20));
    cancel.setBounds(0,10,60,20);
    cancel.addActionListener(this);
    add(cancel);
       setVisible(true);
       
   }   
   public void actionPerformed(ActionEvent s){
       if(s.getSource()==cancel){
           setVisible(false);
           new reception();
       }
   }
   public static void main(String args[]){
       new customer_info();
   }
}
