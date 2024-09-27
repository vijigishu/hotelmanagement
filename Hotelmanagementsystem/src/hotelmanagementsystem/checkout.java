/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.awt.event.*;
import java.sql.ResultSet;

public class checkout extends JFrame implements ActionListener{
    Choice customer;
    JLabel lblroomnumber,checkintime,lblcheckouttime;
    JButton checkout,back,check;

    checkout(){
        setLayout(null);
        getContentPane().setBackground(Color.white);
        JLabel text = new JLabel("CHECKOUT");
        text.setForeground(Color.blue);
        text.setBounds(20,10,100,50);
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(text);
       
        JLabel lblid = new JLabel("customer id");
        lblid.setBounds(30,60,70,30);
        add(lblid);
       
        customer = new Choice();
        customer.setBounds(120,60,120,30);
        add(customer);
        
        
       JLabel lblroom = new JLabel("room number");
       lblroom.setBounds(30,120,80,30);
       add(lblroom);
       
       lblroomnumber = new JLabel();
       lblroomnumber.setBounds(150,120,120,30);
       add(lblroomnumber);
       
       JLabel lblcheckin = new JLabel("checking  time ");
       lblcheckin.setBounds(30,180,100,30);
       add(lblcheckin);
       
       checkintime = new JLabel();
       checkintime.setBounds(140,180,200,30);
       add(checkintime);
       
       JLabel lblcheckout = new JLabel("checkout time ");
       lblcheckout.setBounds(30,240,100,30);
       add(lblcheckout);
       
       Date date = new Date();
       lblcheckouttime = new JLabel(" "+date);
       lblcheckouttime.setBounds(130,240,200,30);
       add(lblcheckouttime);
       
       back = new JButton("Back");
       back.setBackground(Color.black);
       back.setForeground(Color.white);
       back.setBounds(290,280,100,30);
       back.addActionListener(this);
       add(back);
       
       
       
       check = new JButton("Check");
       check.setBackground(Color.black);
       check.setForeground(Color.white);
       check.setBounds(30,280,100,30);
       check.addActionListener(this);
       add(check);
       
       checkout = new JButton("Checkout");
       checkout.setBackground(Color.black);
       checkout.setForeground(Color.white);
       checkout.setBounds(160,280,100,30);
       checkout.addActionListener(this);
       add(checkout);
       
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image i2 = i1.getImage().getScaledInstance(300,250,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(300,30,250,200);
        add(image);
       
        try{
        conn v=new conn();
        String query="select * from customers_info";
        ResultSet rs=v.s.executeQuery(query);
        while(rs.next()){
            customer.add(rs.getString("number"));
            
        }
    }
        catch(Exception e){
                e.printStackTrace();
                }
       
       
        setBounds(500,250,600,400);
        setVisible(true);
    }
   
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==checkout){
            String query="delete from customers_info where number='"+customer.getSelectedItem()+"'";
            String query1="update rooms set availability='available' where room_no='"+lblroomnumber.getText()+"'";
       try{
           conn n=new conn();
           n.s.executeUpdate(query);
                      n.s.executeUpdate(query1);
            JOptionPane.showMessageDialog(null,"data updated successfully");
            setVisible(false);
            new reception();
       }   
       
       catch(Exception t){
           t.printStackTrace();
       }
            
        }
        else if(ae.getSource()==check){
         try{
             conn v=new conn();
        ResultSet rs2=v.s.executeQuery("select * from customers_info where number='"+customer.getSelectedItem()+"'");


         while(rs2.next()){
            
         lblroomnumber.setText(rs2.getString("room_no"));    
         checkintime.setText(rs2.getString("date"));
         
            

             
            }
         
         
        }
        catch(Exception e){
                e.printStackTrace();
                }
        
        }
        
        
        else{
            setVisible(false);
            new reception();
                   
        }
    }
   
    public static void main(String args[]){
        new checkout();
    }
}


