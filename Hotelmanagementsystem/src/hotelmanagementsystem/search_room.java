/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelmanagementsystem;
import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;


public class search_room extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    JButton submit;
    JComboBox bedtype;
    JCheckBox available;
    search_room(){
        getContentPane().setBackground(Color.white);
        setLayout(null);
        JLabel text = new JLabel("search for rooms ");
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        text.setBounds(400,30,200,30);
        add(text);

        JLabel lblbed = new JLabel("bed type ");
        lblbed.setBounds(50,100,100,20);
        add(lblbed);

        bedtype = new JComboBox(new String[]{"Single Bed","Double Bed"});
        bedtype.setBounds(150,100,150,25);
        bedtype.setBackground(Color.white);
        add(bedtype);
       
        available = new JCheckBox("only display available ");
        available.setBounds(650,100,150,25);
        available.setBackground(Color.white);
        add(available);
        

        JLabel l1 = new JLabel("room number");
        l1.setBounds(10,150,100,20);
        add(l1);
       
         JLabel l2 = new JLabel("availability");
        l2.setBounds(140,150,100,20);
        add(l2);
       
         JLabel l3 = new JLabel("cleaning status ");
        l3.setBounds(260,150,100,20);
        add(l3);
       
         JLabel l4 = new JLabel("price");
        l4.setBounds(400,150,100,20);
        add(l4);
       
         JLabel l5 = new JLabel("bed type ");
        l5.setBounds(530,150,100,20);
        add(l5);
        JLabel l6 = new JLabel("Room type ");
        l6.setBounds(660,150,100,20);
        add(l6);
        table = new JTable();
        table.setBounds(0,180,800,200);
       try {
            conn c=new conn();
            
          ResultSet rs = c.s.executeQuery("select * from rooms ");
          table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
         add(table);
        submit = new JButton("submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        submit.setBounds(0,500,120,30);
        add(submit);
       
        back = new JButton("back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.addActionListener(this);
        back.setBounds(150,500,120,30);
        add(back);
       
        
       
        
         setBounds(300,90,950,700);
         setVisible(true);

    }
     public void actionPerformed(ActionEvent ae) {
         if(ae.getSource()== submit){
            try{
                conn m=new conn();
             String query1;  
             ResultSet rs;
                query1 = "select * from rooms where bed_type ='"+bedtype.getSelectedItem()+"'";
              String  query2 = "select * from rooms where availability='available' AND bed_type ='"+(String)bedtype.getSelectedItem()+"'";
             if(available.isSelected()){
                 rs=m.s.executeQuery(query2);
                 
             }
             else{
                 rs=m.s.executeQuery(query1);
             }
             table.setModel(DbUtils.resultSetToTableModel(rs));
             

            } catch(Exception e){
                e.printStackTrace();
            }
         }else {
             setVisible(false);
    new reception();
         }
   
     }

 

   
    public static void main(String args[]){
        new search_room();
    }
}

