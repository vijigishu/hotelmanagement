/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelmanagementsystem;



/**
 *
 * @author piyus
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class MyInfo extends JFrame implements ActionListener  {
    JButton upd,Back;
    JPasswordField oldps,newps;
    JTextField oldun,newun;
   
MyInfo(){
       setBounds(400,220,600,500);
       getContentPane().setBackground(Color.WHITE);
       setLayout(null);
       
       JLabel update = new JLabel("Change Password or Username");
       update.setFont(new Font("Tahoma",Font.BOLD,20));
        update.setBounds(10, 10, 500, 30);
        add(update);
       
        JLabel line = new JLabel("-------------------------------------------------------------------------------------------");
       line.setFont(new Font("Tahoma",Font.BOLD,15));
        line.setBounds(10, 50, 800, 10);
        add(line);
        
        JLabel old=new JLabel("Old Username");
        old.setFont(new Font("Tahoma",Font.BOLD,15));
        old.setBounds(10, 80, 200, 20);
        add(old);
        
        oldun = new JTextField();
        oldun.setBounds(170, 80, 150, 30);
        add(oldun);
        
        
         JLabel oldp=new JLabel("Old Password");
        oldp.setFont(new Font("Tahoma",Font.BOLD,15));
        oldp.setBounds(10, 150, 200, 20);
        add(oldp);
        
        oldps = new JPasswordField();
        oldps.setBounds(170, 150, 150, 30);
        add(oldps);
        
         JLabel line1 = new JLabel("-------------------------------------------------------------------------------------------");
       line1.setFont(new Font("Tahoma",Font.BOLD,15));
        line1.setBounds(10, 200, 800, 10);
        add(line1);
        
        JLabel newu=new JLabel("New Username");
        newu.setFont(new Font("Tahoma",Font.BOLD,15));
        newu.setBounds(10, 230, 200, 20);
        add(newu);
         newun = new JTextField();
        newun.setBounds(170, 230, 150, 30);
        add(newun);
        
         JLabel newp=new JLabel("New Password");
        newp.setFont(new Font("Tahoma",Font.BOLD,15));
        newp.setBounds(10, 300, 200, 20);
        add(newp);
         newps = new JPasswordField();
        newps.setBounds(170, 300, 150, 30);
        add(newps);
        
        upd=new JButton("Update");
        upd.setBounds(10,380,120,30);
        upd.setBackground(Color.BLACK);
        upd.setForeground(Color.WHITE);
        upd.addActionListener(this);
        add(upd);
        
        Back=new JButton("Back");
        Back.setBounds(150,380,120,30);
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.WHITE);
         Back.addActionListener(this);
        add(Back);
       setVisible(true);
}

public void actionPerformed(ActionEvent t){
    if(t.getSource()==upd){
        String ou=oldun.getText();
        String op=oldps.getText();
        String nu=newun.getText();
        String np=newps.getText();
        
        try{
            conn v=new conn();
           String query="select * from cust_login where user='"+ou+"' and pass='"+op+"'";
            String query1="update cust_login set user='"+nu+"', pass='"+np+"' where user='"+ou+"' and pass='"+op+"'";
            String query2="update Register set user='"+nu+"', pass='"+np+"' where user='"+ou+"' and pass='"+op+"'";
            
            ResultSet rs=v.s.executeQuery(query);
            if(rs.next()){
            v.s.executeUpdate(query1);
            v.s.executeUpdate(query2);
           JOptionPane.showMessageDialog(null, " password changed successfully!");
           setVisible(false);
           new customer_dashboard();
            }
            else{
                 JOptionPane.showMessageDialog(null, " Data not found!");
            }
        }
        catch(Exception m){
            JOptionPane.showMessageDialog(null, " Data not found!");
            m.printStackTrace();
        }
    }
    else if (t.getSource()==Back){
        setVisible(false);
        new customer_dashboard();
    }
}
public static void main(String args[]){
    new MyInfo();
}

}