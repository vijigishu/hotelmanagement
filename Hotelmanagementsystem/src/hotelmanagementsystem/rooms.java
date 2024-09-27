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
public class rooms extends JFrame  implements ActionListener{
    JTextField tfrooms,tfprice;
    JComboBox cbavailable,cbcleaning,cbtype,roomt;
    JButton submit,cancel;
     
    rooms(){
        setBounds(330,200,700,470);
               getContentPane().setBackground(Color.white);
        setLayout(null);
        JLabel lbladdrooms=new JLabel("ADD ROOMS");
        lbladdrooms.setFont(new Font("Tahoma",Font.BOLD,15));
        lbladdrooms.setBounds(30,30,150,20);
        add(lbladdrooms);
        
        JLabel lblroomno=new JLabel("Room No");
        lblroomno.setFont(new Font("Tahoma",Font.PLAIN,15));
        lblroomno.setBounds(30,90,100,20);
        add(lblroomno);
        
        
         tfrooms=new JTextField();
         tfrooms.setBounds(150,90,100,20);
          add(tfrooms);
          
          JLabel lblavailable=new JLabel("Availablity");
        lblavailable.setFont(new Font("Tahoma",Font.PLAIN,15));
        lblavailable.setBounds(30,140,100,20);
        add(lblavailable);
        
        String str[]={"available","not available"};
        cbavailable=new  JComboBox(str);
                        cbavailable.setBackground(Color.white);

        cbavailable.setBounds(150,140,100,20);
         add(cbavailable);
        
         JLabel lblcleaning=new JLabel("Cleaning Status");
        lblcleaning.setFont(new Font("Tahoma",Font.PLAIN,15));
        lblcleaning.setBounds(30,180,100,20);
        add(lblcleaning);
        
          String str1[]={"Cleaned ","Dirty"};
        cbcleaning=new  JComboBox(str1);
                cbcleaning.setBackground(Color.white);

        cbcleaning.setBounds(150,180,100,20);
         add(cbcleaning);
         
         JLabel lblprice=new JLabel("Price");
        lblprice.setFont(new Font("Tahoma",Font.PLAIN,15));
        lblprice.setBounds(30,220,100,20);
        add(lblprice);
          
        tfprice=new JTextField();
         tfprice.setBounds(150,220,100,20);
          add(tfprice);
         
          JLabel lblbedtype=new JLabel("Bed Type");
        lblbedtype.setFont(new Font("Tahoma",Font.PLAIN,15));
        lblbedtype.setBounds(30,260,100,20);
        add(lblbedtype);
        
        String str2[]={"Single Bed","Double Bed"};
        cbtype=new  JComboBox(str2);
        cbtype.setBackground(Color.white);
        cbtype.setBounds(150,260,100,20);
         add(cbtype);
        
          JLabel lblroomtype=new JLabel("Room Type");
        lblroomtype.setFont(new Font("Tahoma",Font.PLAIN,15));
        lblroomtype.setBounds(30,300,100,20);
        add(lblroomtype);
        
        String st[]={"Royal","Deluxe","Economy"}; 
        roomt =new JComboBox(st);
        roomt.setBackground(Color.white);
        roomt.setBounds(150,300,100,20);
         add(roomt);
         
         
         submit=new JButton("SUBMIT");
         submit.setBounds(30,350,100,30);
         submit.setBackground(Color.BLACK);
         submit.setForeground(Color.WHITE);
         submit.addActionListener(this);
         add(submit);  
         
          cancel=new JButton("CANCEL");
         cancel.setBounds(160,350,100,30);
         cancel.setBackground(Color.BLACK);
         cancel.setForeground(Color.WHITE);
                  cancel.addActionListener(this);

         add(cancel); 
         
           ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/new.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,350,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(280,5,400,400);
        add(image);
         
         
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent k){
       if(k.getSource()==submit){
           String room_no=tfrooms.getText();
           String availability=(String)cbavailable.getSelectedItem();
           String cleaning= (String)cbcleaning.getSelectedItem();
           String price=tfprice.getText();
           String bedtype=(String)cbtype.getSelectedItem();
           String roomtype=(String)roomt.getSelectedItem();
           if(room_no.matches("\\d+")&&price.matches("\\d+")){
               float room_n=Float.parseFloat(room_no);
               float price_n=Float.parseFloat(price);
              
              
           try{
               conn j=new conn();
                String query3="select * from rooms where room_no='"+room_n+"'";
                 ResultSet ms=j.s.executeQuery(query3);
                 if(ms.next()){
                     JOptionPane.showMessageDialog(null,"Room already exist");
                 }
                 else{
                    String query="insert into rooms values('"+ (int)room_n +"','"+ availability +"','"+ cleaning +"','"+ price_n +"','"+bedtype  +"','"+roomtype  +"')";
                   j.s.executeUpdate(query);
                   JOptionPane.showMessageDialog(null,"Rooms added successfully");
                 }
                 
             }
           catch(Exception lo){
               lo.getStackTrace();
           }
           
           }
           else{
              JOptionPane.showMessageDialog(null,"enter valid details");

           }
       }
       else if(k.getSource()==cancel){
           
           setVisible(false);
           new Dashboard();
       }
    }
    public static void main(String args[]){
        
        new rooms();
    }
    
}
