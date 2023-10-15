
package hotel.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;


public class Department extends JFrame implements ActionListener{
    JTable table;
    JButton cancel;
    
    
    Department(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
//        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
//        Image i2=i1.getImage().getScaledInstance(600,600,Image.SCALE_DEFAULT);
//        ImageIcon i3=new ImageIcon(i2);
//        JLabel image=new JLabel(i3);
//        image.setBounds(500, 0, 600, 600);
//        add(image);
        
        JLabel l1=new JLabel("Department");
        l1.setBounds(10, 10, 100, 20);
        add(l1);
        
         JLabel l2=new JLabel("Budget");
        l2.setBounds(400, 10, 100, 20);
        add(l2);
      
        
        table=new JTable();
        table.setBounds(0, 40, 700, 350);
        add(table);
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from department");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        
        }
        catch(Exception e){
            e.printStackTrace();
            
        }
        
        
        
       
       cancel=new JButton("Cancel");
       cancel.setBounds(250,390,200,30);
       cancel.setBackground(Color.BLACK);
       cancel.setForeground(Color.WHITE);
       cancel.addActionListener(this);
       add(cancel);
        
        
        setBounds(300,200,700,480);
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
        new Department();
    }

   
}
