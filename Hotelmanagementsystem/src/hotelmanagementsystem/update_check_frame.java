/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelmanagementsystem;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
public class update_check_frame extends JFrame implements ActionListener{
    Choice customer;
    JTextField tfroom;
    JTextField tfname;
    JTextField checkin;
    JTextField lbpaid;
    JTextField lbpending;
    JButton check,update,back;
    update_check_frame(){
        setBounds(350,100,900,500);
        getContentPane().setBackground(Color.WHITE);
        JLabel text = new JLabel("update status ");
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        text.setBounds(20,30,200,30);
        add(text);
       
        JLabel lblid = new JLabel("customer id");
        lblid.setBounds(20,100,100,20);
        add(lblid);
       
         customer = new Choice();
        customer.setBounds(120,100,150,25);
        add(customer);
       
       try{
        conn v=new conn();
        String query="select * from customers_info";
        ResultSet rs=v.s.executeQuery(query);
        while(rs.next()){
            customer.add(rs.getString("number"));
        }
    }
        catch(Exception e){
                e.printStackTrace();
                }
         JLabel lblroom = new JLabel("room number");
        lblroom.setBounds(20,140,100,20);
        add(lblroom);
       
        tfroom = new JTextField();
        tfroom.setBounds(120,140,150,25);
        add(tfroom);
       
        JLabel name = new JLabel("name");
        name.setBounds(20,180,100,20);
        add(name);
       
        tfname =  new JTextField();
        tfname.setBounds(120,180,150,25);
        add(tfname);
       
        JLabel checking = new JLabel("checking time ");
        checking.setBounds(20,220,100,20);
        add(checking);
       
        checkin = new JTextField();
        checkin.setBounds(120,220,150,25);
        add(checkin);
       
        JLabel lblpaid = new JLabel("amount paid ");
        lblpaid.setBounds(20,260,100,20);
        add(lblpaid);
       
        lbpaid = new JTextField();
        lbpaid.setBounds(120,260,150,25);
        add(lbpaid);
       
        JLabel lblpending = new JLabel("pending paid ");
        lblpending.setBounds(20,300,100,20);
        add(lblpending);
       
        lbpending = new JTextField();
        lbpending.setBounds(120,300,150,25);
        add(lbpending);
       
        check = new JButton("check");
        check.setBackground(Color.black);
        check.setForeground(Color.white);
        check.setBounds(20,360,100,30);
        check.addActionListener(this);
        add(check);
       
        update = new JButton("update");
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        update.setBounds(140,360,100,30);
        update.addActionListener(this);
        add(update);
       
        back = new JButton("back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(260,360,100,30);
        back.addActionListener(this);
        add(back);
       
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(330,50,500,300);
        add(image);
       
        setLayout(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==check){
            
            String str=(String)customer.getSelectedItem();
            String query1="select * from customers_info where number='"+str+"'";
           try{
            
        conn v=new conn();
        ResultSet rs=v.s.executeQuery(query1);
        while(rs.next()){
            tfroom.setText(rs.getString("room_no"));
            tfname.setText(rs.getString("name"));
            checkin.setText(rs.getString("date"));
            lbpaid.setText(rs.getString("deposit"));
  
            }
        float r=Float.parseFloat(tfroom.getText());
        
        ResultSet rs2=v.s.executeQuery("select * from rooms where room_no='"+r+"'");
         while(rs2.next()){
            String price=rs2.getString("price");
            float amount_paid=Float.parseFloat(price)-Float.parseFloat(lbpaid.getText());
            lbpending.setText(""+amount_paid);
         }
        }
        catch(Exception e){
                e.printStackTrace();
                }
        }else if(ae.getSource()==update){
           String number=customer.getSelectedItem();
           String room=tfroom.getText();
           String name=tfname.getText();
           String checkin_=checkin.getText();
           String deposit=lbpaid.getText();
           float depo=Float.parseFloat(deposit);
            float room_n=Float.parseFloat(room);

            try{
                conn j=new conn();
                j.s.executeUpdate("update customers_info set room_no='"+room_n+"',name='"+name+"',deposit='"+depo+"',date='"+checkin_+"' where number='"+number+"'");
                    JOptionPane.showMessageDialog(null,"data updated successfully");
            
                    
                    
            }
            catch(Exception r){
                r.printStackTrace();
            }
        }else{
            setVisible(false);
            new reception();
        }
    }
    public static void main(String args[]){
        new update_check_frame();
    }
}
