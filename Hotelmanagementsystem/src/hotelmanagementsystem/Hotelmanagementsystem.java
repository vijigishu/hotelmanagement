/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hotelmanagementsystem;
/*import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Hotelmanagementsystem extends JFrame implements ActionListener{
    Hotelmanagementsystem(){
       
        setBounds(100,100,1028,586);
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        JLabel image=new JLabel(i1);
        add(image);
        image.setBounds(0,0,1028,586);
        JLabel text=new JLabel("Welcome "); 
        text.setBounds(10,430,800,70);
        text.setForeground(Color.white);
        text.setFont(new Font("serif",Font.ITALIC,70));
        image.add(text);
        JButton b=new JButton("NEXT");
        b.setFont(new Font("serif",Font.PLAIN,50));
        b.setBackground(Color.black);
        b.setForeground(Color.white);
        b.setBounds(620,360,200,60);
        b.addActionListener(this);
        add(b);
       setVisible(true); 
       
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
       new login();
       
        
    }

   
    public static void main(String[] args) {
        new Hotelmanagementsystem();
    }
    
}
*/


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//for action listener that is event listener u need to override (if any interface is implemented  in ur class then all the methods in that class need to be overriden otherwise error, class shoukld be made abstract then.


public class Hotelmanagementsystem extends JFrame implements ActionListener{
     JButton next, Register;
     JMenuItem adminlogin;
    Hotelmanagementsystem(){
        //setSize(1366, 565);
        //setLocation(100, 100);
       
        setBounds(10, 10, 1366, 800);
        setLayout(null);
       
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/homepage.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1366, 800);  //takes locationx, locationy, length, breadth piyush
               
        add(image);
       
        JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM");
        text.setBounds(290, 100, 1000, 90);
       
        text.setForeground(Color.BLACK);
        text.setFont(new Font("serif", Font.BOLD, 50));
        image.add(text);
       
        JMenuBar mb = new JMenuBar();
        mb.setBounds(0, 0, 1550, 30);
        image.add(mb);
       
        JMenu admin = new JMenu("ADMIN");
        admin.setForeground(Color.BLACK);
        mb.add(admin);
       
       

         adminlogin = new JMenuItem("Admin login");
        admin.add(adminlogin);
          adminlogin.addActionListener(this);
       
        JLabel cust = new JLabel("CUSTOMER");
        cust.setBounds(570, 500, 1000, 90);
        cust.setFont(new Font("Serif", Font.BOLD, 40));
        cust.setForeground(Color.WHITE);
        image.add(cust);
       
       
       
       
        next = new JButton("Login");
        next.setFont(new Font("serif", Font.BOLD, 20));
        next.setBounds(500, 600, 150, 40);
        next.setBackground(Color.WHITE);
        next.setForeground(Color.BLACK);
        next.addActionListener(this);
        image.add(next);
       
        Register = new JButton("Register");
        Register.setFont(new Font("serif", Font.BOLD, 20));
        Register.setBounds(710, 600, 150, 40);
        Register.setBackground(Color.WHITE);
        Register.setForeground(Color.BLACK);
        Register.addActionListener(this);
        image.add(Register);
       
        setVisible(true);
       
                 
       
    }
    //to override the methods and make it actionlistener
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==next){
        setVisible(false);
        new cust_login();
    }
        else if(ae.getSource()==Register){
            setVisible(false);
            new Register();
        }
        else if(ae.getSource()==adminlogin){
            setVisible(false);
            new login();
        }
    }
   
    public static void main(String[] args) {
       
        new Hotelmanagementsystem();
       
       
    }
   
}