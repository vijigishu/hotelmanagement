/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelmanagementsystem;
import java.awt.*;
import java.sql.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Date;
/**
 *
 * @author PCP
 */
public class new_customer_form extends JFrame implements ActionListener{
    
    JComboBox jbid,roomt;
    Choice chroom;
    
    JTextField jtnumber,jtname,jtcountry,jtdeposit;
    JRadioButton jrmale,jrfemale;
    JButton submit ,cancel,check;
    JLabel checkintime;
    
     new_customer_form(){
    setLayout(null);
            getContentPane().setBackground(Color.white);

    setBounds(300,100,800,700);
    
    JLabel lblid=new JLabel("ID");
    lblid.setFont(new Font("Tahoma",Font.PLAIN,20));
    lblid.setBounds(50,30,40,20);
    add(lblid);
    
    String options[]={"Aadhaar","Pan-card","voter-id","Driving License"};
    jbid=new JComboBox(options);
    jbid.setBackground(Color.white);
    jbid.setForeground(Color.BLACK);
    
    jbid.setBounds(180,30,150,20);
    add(jbid);
    
    
    
    
     JLabel lblnumber=new JLabel("Number");
    lblnumber.setFont(new Font("Tahoma",Font.PLAIN,20));
    lblnumber.setBounds(50,90,100,20);
    add(lblnumber);
    
    jtnumber=new JTextField();
    jtnumber.setBackground(Color.white);
    jtnumber.setForeground(Color.BLACK);
    
    jtnumber.setBounds(180,90,150,20);
    add(jtnumber);
    
     JLabel lblname =new JLabel("Name");
    lblname.setFont(new Font("Tahoma",Font.PLAIN,20));
    lblname.setBounds(50,140,100,20);
    add(lblname);
    
    
    jtname=new JTextField();
    jtname.setBackground(Color.white);
    jtname.setForeground(Color.BLACK);
    
    jtname.setBounds(180,140,150,20);
    add(jtname);
    
     JLabel lblgender=new JLabel("Gender");
    lblgender.setFont(new Font("Tahoma",Font.PLAIN,20));
    lblgender.setBounds(50,190,100,20);
    add(lblgender);
    
    jrmale =new JRadioButton("Male");
   
    
    jrmale.setBounds(180,190,60,20);
    add(jrmale);
    
    jrfemale =new JRadioButton("Female");
   
    
    jrfemale.setBounds(270,190,100,20);
    add(jrfemale);
    ButtonGroup b=new ButtonGroup();
    b.add(jrfemale);
   b.add(jrmale);
    
    
     JLabel lblcountry=new JLabel("Country");
    lblcountry.setFont(new Font("Tahoma",Font.PLAIN,20));
    lblcountry.setBounds(50,240,100,20);
    add(lblcountry);
    
    jtcountry=new JTextField();
    jtcountry.setBackground(Color.white);
    jtcountry.setForeground(Color.BLACK);
    
    jtcountry.setBounds(180,240,150,20);
    add(jtcountry);
    
     JLabel lblRoom_no=new JLabel("Room No");
    lblRoom_no.setFont(new Font("Tahoma",Font.PLAIN,20));
    lblRoom_no.setBounds(50,290,100,20);
    add(lblRoom_no);
    
    chroom=new Choice();
    chroom.setBounds(180,290,100,20);
   
    add(chroom);
    
    JLabel lbldate=new JLabel("Date");
    lbldate.setFont(new Font("Tahoma",Font.PLAIN,20));
    lbldate.setBounds(50,340,100,20);
    add(lbldate);
    Date d=new Date();
      checkintime=new JLabel(""+d);
    checkintime.setFont(new Font("Tahoma",Font.PLAIN,15));
    checkintime.setBounds(180,340,120,20);
    add(checkintime);
    
    JLabel lbldeposit=new JLabel("Deposit");
    lbldeposit.setFont(new Font("Tahoma",Font.PLAIN,20));
    lbldeposit.setBounds(50,390,100,20);
    add(lbldeposit);
    
     jtdeposit=new JTextField();
    jtdeposit.setBackground(Color.white);
    jtdeposit.setForeground(Color.BLACK);
    
    jtdeposit.setBounds(180,390,150,20);
    add(jtdeposit);

    JLabel lblRoom_type=new JLabel("Room type");
    lblRoom_type.setFont(new Font("Tahoma",Font.PLAIN,20));
    lblRoom_type.setBounds(50,440,100,20);
    add(lblRoom_type);
    
    String g[]={"Royal","Deluxe","Economy"};
    roomt=new JComboBox(g);
  
    roomt.setBackground(Color.white);
    roomt.setForeground(Color.BLACK);
    roomt.setBounds(180,440,100,20);
    add(roomt);
    
    check=new JButton("Check");
    check.setBackground(Color.BLACK);
    check.setForeground(Color.white);
    check.setFont(new Font("Tahoma",Font.PLAIN,20));
    check.setBounds(50,500,100,30);
    add(check);
    check.addActionListener(this);
    submit=new JButton("Submit");
    submit.setBackground(Color.BLACK);
    submit.setForeground(Color.white);
    submit.setFont(new Font("Tahoma",Font.PLAIN,20));
    submit.setBounds(180,500,100,30);
    submit.addActionListener(this);
    add(submit);
    
    cancel=new JButton("Cancel");
    cancel.setBackground(Color.BLACK);
    cancel.setForeground(Color.white);
    cancel.setFont(new Font("Tahoma",Font.PLAIN,20));
    cancel.setBounds(310,500,100,30);
    cancel.addActionListener(this);
    add(cancel);
     ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second_1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400,450,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(360,30,400,400);
        add(image);
     
      setVisible(true);
     }
     
     public void actionPerformed(ActionEvent o){
         if(o.getSource()==submit){
             String roomno=(String)chroom.getSelectedItem();
           String number=(String)jtnumber.getText();
           String name= (String)jtname.getText();
           String country=jtcountry.getText();
           String id=(String)jbid.getSelectedItem();
           
           String date=(String)checkintime.getText();
           String deposit=jtdeposit.getText();
           String go=null;
          
         if(roomno.matches("\\d+")&&deposit.matches("\\d+")&&name.matches("\\D+")&&country.matches("\\D+")){
             
          float room_n=Float.parseFloat(roomno);
          float deposit_n=Float.parseFloat(deposit);
             if(jrmale.isSelected()){
            go="male";
        }
        else if(jrfemale.isSelected()){
            go="female";
        }
             try{
                 conn c=new conn();
                 String query="insert into customers_info values('"+ id +"','"+ number +"','"+ name +"','"+ go +"','"+ country +"','"+(int)room_n+"','"+date+"','"+deposit_n+"','"+(String)roomt.getSelectedItem()+"')";
                 String query2="update rooms set availability='unavailable' where room_no='"+(int)room_n+"'";
                 c.s.executeUpdate(query);
                                 c.s.executeUpdate(query2);
                 

                   JOptionPane.showMessageDialog(null,"customer info saved successfully");
                   setVisible(false);
                   new reception();
             
                 }
             catch(Exception j){
                 j.printStackTrace();
                 
             }
             
             
         
     }
         else{
             JOptionPane.showMessageDialog(null,"Ensure the details you filled are valid");
         }
         }
         else if(o.getSource()==cancel){
             setVisible(false);
             new reception();
         }
         else if(o.getSource()==check){
             String r=(String)roomt.getSelectedItem();
           
             String query="select * from rooms where availability='available' and room_type='"+ r +"'";
             
             try{
                 conn c=new conn();
               ResultSet cs= c.s.executeQuery(query);
                
        while(cs.next()){
            chroom.add(cs.getString("room_no"));
            
        }
             }
             catch(Exception y){
                 
                 y.printStackTrace();
             }
             
         }
     }
     
     public static void main(String args[]){
         new new_customer_form();
     }
}


