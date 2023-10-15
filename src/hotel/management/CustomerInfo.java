
package hotel.management;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;


public class CustomerInfo extends JFrame implements ActionListener{
    JTable table;
    JButton add,cancel;
    
    
    CustomerInfo(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel l1=new JLabel("Document");
        l1.setBounds(10, 10, 100, 20);
        add(l1);
        
         JLabel l2=new JLabel("Number");
        l2.setBounds(120, 10, 100, 20);
        add(l2);
        
        JLabel l3=new JLabel("Name");
        l3.setBounds(220, 10, 100, 20);
        add(l3);
        
        JLabel l4=new JLabel("Gender");
        l4.setBounds(320, 10, 100, 20);
        add(l4);
        
        JLabel l5=new JLabel("Country");
        l5.setBounds(400, 10, 100, 20);
        add(l5);
        

        
        JLabel l7=new JLabel("Room");
        l7.setBounds(510, 10, 100, 20);
        add(l7);
        
        JLabel l8=new JLabel("Checkintime");
        l8.setBounds(620, 10, 100, 20);
        add(l8);
        JLabel l9=new JLabel("Deposit");
        l9.setBounds(700, 10, 100, 20);
        add(l9);
        
        table=new JTable();
        table.setBounds(0, 40, 800, 400);
        add(table);
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from customer ");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        
        }
        catch(Exception e){
            e.printStackTrace();
            
        }
        
        
        
       
       cancel=new JButton("Cancel");
       cancel.setBounds(420,500,120,30);
       cancel.setBackground(Color.BLACK);
       cancel.setForeground(Color.WHITE);
       cancel.addActionListener(this);
       add(cancel);
        
        
        setBounds(300,200,1000,600);
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
        new CustomerInfo();
    }

   
}

