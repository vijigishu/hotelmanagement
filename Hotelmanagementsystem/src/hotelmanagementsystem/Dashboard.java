/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
        
/**
 *
 * @author PCP
 */
public class Dashboard extends JFrame implements ActionListener{
    JMenuItem rooms,employees,reception,log;
    Dashboard(){
        setBounds(0,0,1550,1000);
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2=i1.getImage().getScaledInstance(1550, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel Image=new JLabel(i3);
        Image.setBounds(0,0,1550,1000);
        add(Image);
        JLabel text=new JLabel("Welcome To The Prestige");
        text.setBounds(400,50,700,60);
        text.setFont(new Font("Tahoma",Font.BOLD,50));
        text.setForeground(Color.WHITE);
        Image.add(text);
        JMenuBar p=new JMenuBar();
        p.setBounds(0,0,1550,30);
        Image.add(p);
        
        JMenu hotel=new JMenu("Hotel Management");
        hotel.setForeground(Color.green);
        p.add(hotel);
        
        JMenu admin=new JMenu("ADMIN");
        hotel.setForeground(Color.BLUE);
        p.add(admin);
        
        JMenu logout=new JMenu("Logout");
        logout.setForeground(Color.green);
        p.add(logout);
        
         reception=new JMenuItem("Reception");
        hotel.add(reception);
        reception.addActionListener(this);
         rooms=new JMenuItem("Add Rooms");
        admin.add(rooms);
        rooms.addActionListener(this);
         employees=new JMenuItem("Add Employees");
        admin.add(employees);
          employees.addActionListener(this);
          log=new JMenuItem("logout");
      
        log.addActionListener(this);
          logout.add(log);
        
        
        
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent b){
        if(b.getSource()==rooms){
            setVisible(false);
            new rooms();
        }
        else if(b.getSource()==employees){
            setVisible(false);
            new employee();
        }
        else if(b.getSource()==reception){
            setVisible(false);
            new reception();
        }
         else if(b.getSource()==log){
            setVisible(false);
            new Hotelmanagementsystem();
        }
    }
    public static void main(String[] args){
        new Dashboard();
    }
}
