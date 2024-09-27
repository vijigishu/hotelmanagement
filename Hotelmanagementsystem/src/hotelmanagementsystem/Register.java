/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
/**
 *
 * @author piyus
 */
public class Register extends JFrame implements ActionListener{
    JButton Register,cancel;
    JTextField username,n;
    JPasswordField password,passw;
Register(){
       
        getContentPane().setBackground(Color.WHITE);
       
        setLayout(null);
       
        JLabel user = new JLabel("Enter Email:");
        user.setBounds(40, 20, 100, 30);
        add(user);
       
         username = new JTextField();
        username.setBounds(170, 20, 150, 30);
        add(username);
       
        JLabel number = new JLabel("Enter Number:");
        number.setBounds(40, 70, 100, 30);
        add(number);
       
         n = new JTextField();
        n.setBounds(170, 70, 150, 30);
        add(n);
       
        JLabel pass = new JLabel("Enter Password:");
        pass.setBounds(40, 120, 150, 30);
        add(pass);
       
         password = new JPasswordField();
        password.setBounds(170, 120, 150, 30);
        add(password);
       
        JLabel passwordw = new JLabel("Confirm Password:");
        passwordw.setBounds(40, 170, 150, 30);
        add(passwordw);
       
         passw = new JPasswordField();
        passw.setBounds(170, 170, 150, 30);
        add(passw);
       
       
         Register = new JButton("Register");
        Register.setBounds(40, 220, 120, 30);
        Register.setBackground(Color.BLACK);
        Register.setForeground(Color.WHITE);
        add(Register);
        Register.addActionListener(this);
         cancel = new JButton("Cancel");
        cancel.setBounds(180, 220, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        add(cancel);
                cancel.addActionListener(this);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(300, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 10, 200, 200);
        add(image);
       
       
        //ask user for image
       
       
       
        setBounds(450, 200, 600, 300);
        setVisible(true);
    }
public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==Register){
        String user=username.getText();
                String num=n.getText();
              String pass1=password.getText();
                 String pass2=passw.getText();
       int len=num.length();
          if(!pass1.equals(pass2)){
            JOptionPane.showMessageDialog(null, " password must match!");
           
          }
          else if(!num.matches("\\d+")){
               JOptionPane.showMessageDialog(null, " phone number can only be numeric!");

              
          }
          else if(len!=10){
              JOptionPane.showMessageDialog(null, " Enter 10 digit valid phone number!");
          }
          
          else {
              try{
                  float f=Float.parseFloat(num);
               String query="insert into register values('"+user+"','"+f+"','"+pass1+"')";  
               String query1="insert into cust_login values('"+user+"','"+pass1+"')";
               conn c=new conn();
               c.s.executeUpdate(query);
               c.s.executeUpdate(query1);
                JOptionPane.showMessageDialog(null, " succcesfully registered please login!");
                 setVisible(false);
                 new cust_login();
              }
              catch(Exception b){
                  b.printStackTrace();
              }
          }
       
    }
    else{
        setVisible(false);
        new Hotelmanagementsystem();
    }
}
public static void main(String[] args){
    new Register();
}


}
