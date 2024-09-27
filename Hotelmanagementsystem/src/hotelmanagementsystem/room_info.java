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
public class room_info extends JFrame implements ActionListener {
    JTable table;
    JButton cancel;
   room_info(){
        setBounds(230,100,1050,600);
        getContentPane().setBackground(Color.white);
        
        table=new JTable();
        table.setBounds(0,50,450,400);
        add(table);
        try {
            conn c=new conn();
            
          ResultSet rs = c.s.executeQuery("select * from rooms");
          table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        JLabel lblroom=new JLabel("Room_no");
        lblroom.setBounds(0,30,70,20);
        add(lblroom);
        
        JLabel lblavailable=new JLabel("Availability");
        lblavailable.setBounds(80,30,70,20);
        add(lblavailable);
        JLabel lblstatus=new JLabel("Status");
        lblstatus.setBounds(150,30,60,20);
        add(lblstatus);
        JLabel lblprice=new JLabel("Price");
        lblprice.setBounds(230,30,80,20);
        add(lblprice);
        
        JLabel lbltype=new JLabel("Bed Type");
        lbltype.setBounds(300,30,80,20);
        add(lbltype);
        
        
         JLabel lblroomtype=new JLabel("Room Type");
        lblroomtype.setBounds(380,30,80,20);
        add(lblroomtype);
        
         cancel=new JButton("<|=");
    cancel.setBackground(Color.BLACK);
    cancel.setForeground(Color.WHITE);
    cancel.setFont(new Font("serif",Font.BOLD,20));
    cancel.setBounds(0,10,60,20);
    cancel.addActionListener(this);
    add(cancel);
        
     ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,750,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(480,30,500,500);
        add(image);
    
        setLayout(null);
        setVisible(true);
        
    }
   public void actionPerformed(ActionEvent e){
       if(e.getSource()==cancel){
           setVisible(false);
        new reception();
       }
   }
   public static void main(String args[]){
       new room_info();
   }
    
}
