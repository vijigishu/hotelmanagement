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
 * @author PCP
 */
public class login extends JFrame implements ActionListener {
    JTextField u;
    JPasswordField v;
    JButton log,cancel;
    login(){
        getContentPane().setBackground(Color.white);
        
        setLayout(null);
        
        JLabel user=new JLabel("Username");
        user.setBounds(45,40,80,30);
        add(user);
        
        JLabel pass=new JLabel("Password");
        pass.setBounds(45,100,80,30);
        add(pass);
        
         u=new JTextField();
        u.setBounds(150,40,120,30);
        add(u);
        
          v=new JPasswordField();
        v.setBounds(150,100,120,30);
        add(v);
        
        log=new JButton("login");
        log.setBounds(45,160,100,30);
        log.setBackground(Color.BLACK);
        log.setForeground(Color.white);
       log.addActionListener(this);
        add(log);
        
         cancel=new JButton("cancel");
        cancel.setBounds(170,160,100,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);
        
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second_1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(300, 10, 200, 200);
        add(image);

            
    setBounds(400,260,560,300);
    setVisible(true);
    
    }
        public void actionPerformed(ActionEvent ae){
            if(ae.getSource()==log){
                String user=u.getText();
                String pass=v.getText();
                try{
                    conn c=new conn();
                    String query="select * from admin where username ='"+ user +"' and password='"+ pass+"'";
                   ResultSet rs= c.s.executeQuery(query);
                   if(rs.next()){
                       setVisible(false);
                       new Dashboard();
                   }
                   
                   else{
                       JOptionPane.showMessageDialog(null,"invalid username and password");
                       setVisible(false);
                       new Hotelmanagementsystem();
                   }
                }
                catch(Exception ac){
                    ac.printStackTrace();
                }
            }
            else if(ae.getSource()==cancel) {
               new Hotelmanagementsystem();
            }
        }
    
    public static void main(String[] args){
        new login();
    }
}
