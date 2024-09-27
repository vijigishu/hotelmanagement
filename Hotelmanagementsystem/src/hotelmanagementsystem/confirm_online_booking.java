/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelmanagementsystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author PCP
 */
public class confirm_online_booking extends JFrame implements ActionListener {
    Choice customer;
    JTextField transaction;
    JButton back,confirm;
    confirm_online_booking(){
    setLayout(null);
        getContentPane().setBackground(Color.white);
        JLabel text = new JLabel("Confirm Online Booking");
        text.setForeground(Color.blue);
        text.setBounds(20,10,300,50);
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(text);
        JLabel lblid = new JLabel("customer id");
        lblid.setBounds(30,60,70,30);
        add(lblid);
       
        customer = new Choice();
        customer.setBounds(120,60,120,30);
        
        
         try{
        conn v=new conn();
        String query="select * from online_booking where status='Not_confirmed'";
        ResultSet rs=v.s.executeQuery(query);
        while(rs.next()){
            customer.add(rs.getString("number"));
            
        }
    }
        catch(Exception e){
                e.printStackTrace();
                }
       add(customer);
          JLabel lbltr = new JLabel("Transaction ID");
        lbltr.setBounds(30,100,120,30);
        add(lbltr);
       
        transaction = new JTextField();
        transaction.setBounds(120,100,120,30);
        add(transaction);
        confirm = new JButton("Confirm");
       confirm.setBackground(Color.black);
       confirm.setForeground(Color.white);
       confirm.setBounds(30,150,100,30);
       confirm.addActionListener(this);
       add(confirm);
       
       
       
       back = new JButton("Back");
       back.setBackground(Color.black);
       back.setForeground(Color.white);
       back.setBounds(160,150,100,30);
       back.addActionListener(this);
       add(back);
         setBounds(500,250,600,300);
        setVisible(true);
        
}
    public void actionPerformed(ActionEvent p){
        if(p.getSource()==confirm){
            try{
                    conn c=new conn();
                    String query="select * from online_booking where  number='"+ (String)customer.getSelectedItem() +"' and trans='"+ transaction.getText()+"'";
                   ResultSet rs= c.s.executeQuery(query);
                   if(rs.next()){
                      String room_no=rs.getString("room_no");
                      String id=rs.getString("id");
                      String name=rs.getString("name");
                      String gender=rs.getString("gender");
                      String country=rs.getString("country");
                      String date=rs.getString("date");
                      String depo=rs.getString("deposit");
                      String roomt=rs.getString("room_type");
                      
                      float room_n=Float.parseFloat(room_no);
                      float deposit=Float.parseFloat(depo);
                      String statu="confirmed";
                     
                      String query1="insert into customers_info values('"+ id +"','"+ (String)customer.getSelectedItem() +"','"+ name +"' ,'"+ gender +"','"+ country +"','"+ room_n +"','"+ date +"','"+ deposit +"','"+ roomt +"' )";
                      String query2="Update online_booking set status='"+ statu +"' where number='"+ (String)customer.getSelectedItem() +"'" ;
                      
                      c.s.executeUpdate(query1);
                      c.s.executeUpdate(query2);
                      
                      JOptionPane.showMessageDialog(null,"Booking confirmed successfully");
                       setVisible(false);
                       new reception();
                       
                   }
                   
                   else{
                       JOptionPane.showMessageDialog(null,"invalid info");
                       
                   }
                }
                catch(Exception ac){
                    ac.printStackTrace();
                }
        }
        
        else if(p.getSource()==back){
            setVisible(false);
            new reception();
        }
    }
    public static void main (String args[]){
        new confirm_online_booking();
    }
}
