/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelmanagementsystem;

import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class customer_dashboard extends JFrame implements ActionListener {
          JButton book;
          JMenuItem btnlogout;
            JMenuItem Upd;
    public customer_dashboard() {
        setBounds(0, 0, 1550, 1000);
       
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/hotel2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550, 1000, Image.SCALE_DEFAULT);
       
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1550, 1000);
        add(image);
       
        JLabel text = new JLabel("BOOK OUR EXCLUSIVE ROOMS");
        text.setBounds(450, 60, 1000, 50);
        text.setFont(new Font("Tahoma", Font.BOLD, 46));
        text.setForeground(Color.BLACK);
        image.add(text);
       
        JMenuBar mb = new JMenuBar();
        mb.setBounds(0, 0, 1550, 30);
        image.add(mb);
       
        JMenu account = new JMenu("Account");
        account.setForeground(Color.BLACK);
        mb.add(account);
       
       

        /*JMenuItem Booking = new JMenuItem("View Bookings");
        account.add(Booking);
       
        JMenuItem info = new JMenuItem("My Info");
        account.add(info);*/
       
         Upd = new JMenuItem("Update Info");
         Upd.addActionListener(this);
        account.add(Upd);
       
        btnlogout = new JMenuItem("Logout");
        btnlogout.addActionListener(this);
        account.add(btnlogout);
       
        ImageIcon x1 = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        Image x2 = x1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon x3 = new ImageIcon(x2);
        JLabel img = new JLabel(x3);
        img.setBounds(10, 250, 500, 300);
        image.add(img);
       
        ImageIcon y1 = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
        Image y2 = y1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon y3 = new ImageIcon(y2);
        JLabel imag = new JLabel(y3);
        imag.setBounds(450, 250, 500, 300);
        image.add(imag);
       
        ImageIcon z1 = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        Image z2 = z1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon z3 = new ImageIcon(z2);
        JLabel im = new JLabel(z3);
        im.setBounds(900, 250, 500, 300);
        image.add(im);
       
        book = new JButton("BOOK NOW");
        book.setFont(new Font("Tahoma", Font.BOLD, 20));
        book.setBounds(625, 600, 150, 40);
        book.setBackground(Color.BLACK);
        book.setForeground(Color.WHITE);
        book.addActionListener(this);
        image.add(book);
       
        setVisible(true);

       
    }
   

   
 
public void actionPerformed(ActionEvent e){
        if(e.getSource()== btnlogout){
        setVisible(false);
        new Hotelmanagementsystem();
    }
        else if(e.getSource()==book){
            setVisible(false);
            new booknow();
        }
        else if(e.getSource()==Upd){
            setVisible(false);
            new MyInfo();
        }
    }

 
       
   

    public static void main(String[] args) {
        new customer_dashboard();
    }
}


