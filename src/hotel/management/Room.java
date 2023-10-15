package hotel.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;


public class Room extends JFrame implements ActionListener{
    JTable table;
    JButton add,cancel;
    
    
    Room(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        Image i2=i1.getImage().getScaledInstance(600,600,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(500, 0, 600, 600);
        add(image);
        
        JLabel l1=new JLabel("Room Number");
        l1.setBounds(10, 10, 100, 20);
        add(l1);
        
         JLabel l2=new JLabel("Availability");
        l2.setBounds(120, 10, 100, 20);
        add(l2);
        
        JLabel l3=new JLabel("Status");
        l3.setBounds(220, 10, 100, 20);
        add(l3);
        
        JLabel l4=new JLabel("Price");
        l4.setBounds(320, 10, 100, 20);
        add(l4);
        
        JLabel l5=new JLabel("Bed Type");
        l5.setBounds(400, 10, 100, 20);
        add(l5);
        
        table=new JTable();
        table.setBounds(0, 40, 500, 400);
        add(table);
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from room");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        
        }
        catch(Exception e){
            e.printStackTrace();
            
        }
        
        
        
       
       cancel=new JButton("Cancel");
       cancel.setBounds(100,500,200,30);
       cancel.setBackground(Color.BLACK);
       cancel.setForeground(Color.WHITE);
       
       cancel.addActionListener(this);
       add(cancel);
        
        
        setBounds(300,200,1050,600);
        setVisible(true);
    }

     @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource()==cancel)
        {
            setVisible(false);
            new Reception();
        }
    
    }
    
    public static void main(String[] args) {
        new Room();
    }

   
}
