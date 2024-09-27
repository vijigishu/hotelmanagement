/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelmanagementsystem;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class reception extends JFrame implements ActionListener {
    
    JButton newcustomer,rooms,department,all_employees,customerinfo,checkout,confirm,update_status,update_room_status,search_room,logout;
    reception(){
        setBounds(320,10,780,750);
       getContentPane().setBackground(Color.white);
        setLayout(null);
        newcustomer=new JButton("New Customer Form");
        newcustomer.setFont(new Font("Tahoma",Font.PLAIN,20));
        newcustomer.setBounds(50,30,260,30);
        newcustomer.setForeground(Color.WHITE);
        newcustomer.setBackground(Color.BLACK);
        add(newcustomer);
        newcustomer.addActionListener(this);
        rooms=new JButton("Rooms");
        rooms.setFont(new Font("Tahoma",Font.PLAIN,20));
        rooms.setBounds(50,90,260,30);
        rooms.setForeground(Color.WHITE);
        rooms.setBackground(Color.BLACK);
        add(rooms);
        rooms.addActionListener(this);
         department=new JButton("Department");
        department.setFont(new Font("Tahoma",Font.PLAIN,20));
        department.setBounds(50,150,260,30);
        department.setForeground(Color.WHITE);
        department.setBackground(Color.BLACK);
        add(department);
                department.addActionListener(this);

        all_employees=new JButton("Employee Information");
        all_employees.setFont(new Font("Tahoma",Font.PLAIN,20));
        all_employees.setBounds(50,210,260,30);
        all_employees.setForeground(Color.WHITE);
        all_employees.setBackground(Color.BLACK);
        add(all_employees);
                     all_employees.addActionListener(this);
   
        customerinfo=new JButton("Customer Information");
        customerinfo.setFont(new Font("Tahoma",Font.PLAIN,20));
        customerinfo.setBounds(50,270,260,30);
        customerinfo.setForeground(Color.WHITE);
        customerinfo.setBackground(Color.BLACK);
        add(customerinfo);
         customerinfo.addActionListener(this);

       
        
         checkout=new JButton("Checkout");
        checkout.setFont(new Font("Tahoma",Font.PLAIN,20));
        checkout.setBounds(50,330,260,30);
        checkout.setForeground(Color.WHITE);
        checkout.setBackground(Color.BLACK);
        add(checkout);
        checkout.addActionListener(this);
        
         update_status=new JButton("Update Status");
        update_status.setFont(new Font("Tahoma",Font.PLAIN,20));
        update_status.setBounds(50,390,260,30);
        update_status.setForeground(Color.WHITE);
        update_status.setBackground(Color.BLACK);
        add(update_status);
        update_status.addActionListener(this);
        
        
        update_room_status=new JButton("Update Room Status");
        update_room_status.setFont(new Font("Tahoma",Font.PLAIN,20));
        update_room_status.setBounds(50,450,260,30);
        update_room_status.setForeground(Color.WHITE);
        update_room_status.setBackground(Color.BLACK);
        add(update_room_status);
        update_room_status.addActionListener(this);
        
         search_room=new JButton("Search Room");
        search_room.setFont(new Font("Tahoma",Font.PLAIN,20));
        search_room.setBounds(50,510,260,30);
        search_room.setForeground(Color.WHITE);
        search_room.setBackground(Color.BLACK);
        add(search_room);
         search_room.addActionListener(this);
         
         confirm=new JButton("Confirm Booking");
        confirm.setFont(new Font("Tahoma",Font.PLAIN,20));
        confirm.setBounds(50,570,260,30);
        confirm.setForeground(Color.WHITE);
        confirm.setBackground(Color.BLACK);
        add(confirm);
         confirm.addActionListener(this);
         
        
         logout=new JButton("Log out");
        logout.setFont(new Font("Tahoma",Font.PLAIN,20));
        logout.setBounds(50,630,260,30);
        logout.setForeground(Color.WHITE);
        logout.setBackground(Color.BLACK);
        add(logout);
                 logout.addActionListener(this);
                 
                 
      ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400,700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(320,30,400,630);
        add(image);          

        setVisible(true);
    }
    public void actionPerformed(ActionEvent p){
        if (p.getSource()==newcustomer){
            setVisible(false);
           new new_customer_form();
        }
        else if(p.getSource()==rooms){
            setVisible(false);
           new room_info();
        }
        else if(p.getSource()==department){
            setVisible(false);
           new Department();
        }
        else if(p.getSource()==all_employees){
            setVisible(false);
          new employee_info();
        }
        else if(p.getSource()==customerinfo){
            setVisible(false);
           new customer_info();
        }
        else if(p.getSource()==logout){
            setVisible(false);
           new Dashboard();
        }
        else if(p.getSource()==checkout){
            setVisible(false);
           new checkout();
        } 
        else if(p.getSource()==update_status){
            setVisible(false);
           new update_check_frame();
        }
         else if(p.getSource()==update_room_status){
            setVisible(false);
           new update_room();
        }
        else if(p.getSource()==search_room){
            setVisible(false);
           new search_room();
        }
        else if(p.getSource()==confirm){
            setVisible(false);
           new confirm_online_booking();
        }
        
    }
    public static void main(String args[]){
        new reception();
    }
}