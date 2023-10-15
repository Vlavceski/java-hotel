package hotel.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;


public class Pickup extends JFrame implements ActionListener{
    JTable table;
    JButton submit,cancel;
    Choice typeofcar;
    JCheckBox available;
    Pickup(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text=new JLabel("Pickup Service");
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        text.setBounds(400,30,200,30);
        add(text);
        
        JLabel lblbed=new JLabel("Type Of car");
        lblbed.setBounds(50,100,100,20);
        add(lblbed);
        
        typeofcar=new Choice();
        typeofcar.setBounds(150,100,200,25);
        add(typeofcar);
        
        try{
            
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from driver");
            while(rs.next()){
                typeofcar.add(rs.getString("brand"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
       
                
        JLabel l1=new JLabel("Name");
        l1.setBounds(10, 180, 100, 20);
        add(l1);
        
         JLabel l2=new JLabel("Age");
        l2.setBounds(150, 180, 100, 20);
        add(l2);
        
        JLabel l3=new JLabel("Gender");
        l3.setBounds(300, 180, 100, 20);
        add(l3);
        
        JLabel l4=new JLabel("Company");
        l4.setBounds(450, 180, 100, 20);
        add(l4);
        
        JLabel l5=new JLabel("Brand");
        l5.setBounds(600, 180, 100, 20);
        add(l5);
        
         JLabel l6=new JLabel("Available");
        l6.setBounds(750, 180, 100, 20);
        add(l6);
        JLabel l7=new JLabel("Location");
        l7.setBounds(900, 180, 100, 20);
        add(l7);
        
        
        table=new JTable();
        table.setBounds(0, 200, 1000, 300);
        add(table);
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from driver");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        
        }
        catch(Exception e){
            e.printStackTrace();
            
        }
        
        
        submit=new JButton("Submit");
       submit.setBounds(100,500,200,30);
       submit.setBackground(Color.BLACK);
       submit.setForeground(Color.WHITE);
       submit.addActionListener(this);
       add(submit);
       
       cancel=new JButton("Cancel");
       cancel.setBounds(500,500,200,30);
       cancel.setBackground(Color.BLACK);
       cancel.setForeground(Color.WHITE);
       
       cancel.addActionListener(this);
       add(cancel);
        
        
        setBounds(300,300,1000,600);
        setVisible(true);
    }

     @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource()==submit)
        {
           try{
               String query="select * from driver where brand='"+typeofcar.getSelectedItem()+"'";
               Conn c=new Conn();
               ResultSet rs;
               rs=c.s.executeQuery(query);
               table.setModel(DbUtils.resultSetToTableModel(rs));
           
           } 
            catch(Exception e){
                
            }
        }else{
          setVisible(false);
          new Reception();
        }
       
    
    }
    
    public static void main(String[] args) {
        new Pickup();
    }

   
}