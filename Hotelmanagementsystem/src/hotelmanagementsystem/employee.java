/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelmanagementsystem;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.lang.*;
/**
 *
 * @author PCP
 */
public class employee extends JFrame implements ActionListener {
    JButton submit,cancel;
    JTextField name,age,salary,phone,mail;
    JRadioButton gendermale,genderfemale;
    JComboBox job;
    employee(){
        setBounds(350,180,850,540);
        setBackground(Color.white);
        setLayout(null);
        
        JLabel lblname=new JLabel("NAME");
        lblname.setFont(new Font("serif",Font.PLAIN,20));
        lblname.setBounds(50,50,80,20);
        add(lblname);
        
        name=new JTextField();
        name.setBounds(160,50,120,20);
        add(name);
        
         JLabel lblage=new JLabel("AGE");
        lblage.setFont(new Font("serif",Font.PLAIN,20));
        lblage.setBounds(50,100,80,20);
        add(lblage);
        
         age=new JTextField();
        age.setBounds(160,100,120,20);
        add(age);
        
        JLabel lblgender=new JLabel("GENDER");
        lblgender.setFont(new Font("serif",Font.PLAIN,20));
        lblgender.setBounds(50,150,80,20);
        add(lblgender);
        
        
         gendermale=new JRadioButton("MALE");
        gendermale.setBounds(160,150,60,10);
        add(gendermale);
        
          genderfemale=new JRadioButton("FEMALE");
        genderfemale.setBounds(250,150,90,10);
        add(genderfemale);
        
        ButtonGroup b=new ButtonGroup();
        b.add(gendermale);
        b.add(genderfemale);
        
        JLabel lbljob=new JLabel("JOB");
        lbljob.setFont(new Font("serif",Font.PLAIN,20));
        lbljob.setBounds(50,200,50,20);
        add(lbljob);
       
        String str[]={"cleaning","chef","accountant","nurse","room_service","security"};
         job=new JComboBox(str);
        job.setBounds(160,200,80,20);
        job.setForeground(Color.black);
        job.setBackground(Color.white);
        add(job);
        
        JLabel lblsalary=new JLabel("SALARY");
        lblsalary.setFont(new Font("serif",Font.PLAIN,20));
        lblsalary.setBounds(50,250,80,20);
        add(lblsalary);
        
         salary=new JTextField();
       salary.setBounds(160,250,120,20);
        add(salary);
        
         JLabel lblphone=new JLabel("PHONE");
        lblphone.setFont(new Font("serif",Font.PLAIN,20));
        lblphone.setBounds(50,300,80,20);
        add(lblphone);
        
         phone=new JTextField();
       phone.setBounds(160,300,120,20);
        add(phone);
        
         JLabel lblmail=new JLabel("EMAIL");
        lblmail.setFont(new Font("serif",Font.PLAIN,20));
        lblmail.setBounds(50,350,80,20);
        add(lblmail);
        
         mail=new JTextField();
       mail.setBounds(160,350,120,20);
        add(mail);
        
         submit=new JButton("SUBMIT");
         submit.setBounds(50,400,80,30);
         submit.setForeground(Color.white);
         submit.setBackground(Color.BLACK);
         submit.addActionListener(this);
         add(submit);
         
           cancel=new JButton("CANCEL");
         cancel.setBounds(160,400,100,30);
         cancel.setBackground(Color.BLACK);
         cancel.setForeground(Color.WHITE);
                  cancel.addActionListener(this);

         add(cancel); 
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i2 = i1.getImage().getScaledInstance(400,350,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(330,5,400,400);
        add(image);      
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent l){
        if(l.getSource()==submit){
        String n=name.getText();
                String a=age.getText();
        
        String g=null;
        String s=salary.getText();
        
        
        String p=phone.getText();
       
        String m=mail.getText();
        int len=p.length();
        if(len!=10){
            JOptionPane.showMessageDialog(null,"Enter valid 10 digit phone no");
        }
      else  if(p.matches("\\d+")&&n.matches("\\D+")&&s.matches("\\d+")){
            float so=Float.parseFloat(s);
             float i=Float.parseFloat(p);
        /*we can put various condition here and constraint such as dont keep boxes empty,phone number should be only in number or email should include @ and .com*/
        if(gendermale.isSelected()){
            g="male";
        }
        else if(genderfemale.isSelected()){
            g="female";
        }
        String co=(String) job.getSelectedItem();
                try{
                    conn k=new conn();
                    String query="insert into employee values('"+ n +"','"+ a +"','"+ g +"','"+ co +"','"+ so +"','"+ (int)i +"','"+ m +"')";
                   k.s.executeUpdate(query);
                   JOptionPane.showMessageDialog(null,"Employee registered successfully");
                   
                
                }
                catch(Exception no){
                    JOptionPane.showMessageDialog(null,"Please ensure that the phone number/salary/name is valid ");
                    no.getStackTrace();
                }
        }
        else{
         JOptionPane.showMessageDialog(null,"Please ensure that the phone number/salary is valid ");

        }
        }
        else if(l.getSource()==cancel){
            setVisible(false);
            new Dashboard();
        }
    }
    public static void main(String[] args){
        new employee();
        
    }
}
