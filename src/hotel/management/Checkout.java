
package hotel.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class Checkout extends JFrame implements ActionListener{
     JButton submit,cancel;
   Choice customer;
    JLabel lblroomnumber,lblcheckinTime,lblcheckoutTime ;
     
    Checkout(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text=new JLabel("Checkout");
        text.setBounds(100, 20, 100, 30);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(text);
        
        JLabel id=new JLabel("Customer ID");
        id.setBounds(30, 75, 100, 30);
        add(id);
        
        customer=new Choice();
        customer.setBounds(200,80,150,25);
        add(customer);   
        
        
        submit=new JButton("Checkout");
       submit.setBounds(100,300,100,30);
       submit.setBackground(Color.BLACK);
       submit.setForeground(Color.WHITE);
       submit.addActionListener(this);
       add(submit);
       
       cancel=new JButton("Cancel");
       cancel.setBounds(500,300,100,30);
       cancel.setBackground(Color.BLACK);
       cancel.setForeground(Color.WHITE);
       cancel.addActionListener(this);
       add(cancel);
       
           ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image i2=i1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(350, 80, 20, 20);
        add(image);
        
        
         ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image i5=i4.getImage().getScaledInstance(300,150,Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel image2=new JLabel(i6);
        image2.setBounds(400, 50, 300, 150);
        add(image2);
       
          JLabel lblroom=new JLabel("Room number");
        lblroom.setBounds(30, 130, 100, 30);
        add(lblroom);
        
         lblroomnumber=new JLabel();
        lblroomnumber.setBounds(200, 130, 100, 30);
        add(lblroomnumber);
        
        JLabel lblcheckin=new JLabel("Checkin Time");
        lblcheckin.setBounds(30, 180, 100, 30);
        add(lblcheckin);
        
         lblcheckinTime=new JLabel();
        lblcheckinTime.setBounds(200, 180, 100, 30);
        add(lblcheckinTime);
        
        JLabel lblcheckout=new JLabel("Checkout Time");
        lblcheckout.setBounds(30, 230, 100, 30);
        add(lblcheckout);
        
        Date date=new Date();
         lblcheckoutTime=new JLabel(""+date);
        lblcheckoutTime.setBounds(200, 230, 200, 30);
        add(lblcheckoutTime);
        
        
        try{
            
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from customer");
            while(rs.next()){
            customer.add(rs.getString("number"));
            lblroomnumber.setText(rs.getString("room"));
            lblcheckinTime.setText(rs.getString("checkintime"));
            }
            if(customer.isFocusable()){
                ResultSet rs2=c.s.executeQuery("select * from customer where number='"+customer.getSelectedItem()+"'");
                while(rs2.next()){
                    customer.add(rs.getString("number"));
                    lblroomnumber.setText(rs.getString("room"));
                    lblcheckinTime.setText(rs.getString("checkintime"));
                }
            }
            
           
            
        }catch(Exception e){
            e.printStackTrace();
        }
        setBounds(300,200,800,400);
        setVisible(true);
    }
    
     @Override
    public void actionPerformed(ActionEvent ae) {
   
        if(ae.getSource()==submit){
            String query="delete from customer where number='"+customer.getSelectedItem()+"'";
            String query2="update room set availability='Available' where roomnumber='"+lblroomnumber.getText()+"'";
        try{
            Conn c=new Conn();
            c.s.executeUpdate(query);
            c.s.executeUpdate(query2);
            
            JOptionPane.showMessageDialog(null,"Checkout done");
            setVisible(false);
            new Reception();
            }catch(Exception e){
            e.printStackTrace();
        }
        }
        else{
            
            setVisible(false);
            new Reception();
        }
    
    }
    public static void main(String[] args) {
        new Checkout();
    }

   
 
}
