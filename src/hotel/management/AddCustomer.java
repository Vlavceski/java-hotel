
package hotel.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class AddCustomer extends JFrame implements ActionListener {
    
    JComboBox comboid;
    JTextField tfnumber,tfname,tfcountry,tfdeposit;
    JRadioButton rbmale,rbfemale;
    Choice croom;
    JLabel lblcheckintime;
    JButton add,cancel;
    AddCustomer(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text=new JLabel("NEW CUSTOMER FORM");
        text.setBounds(100, 30, 300, 30);
        text.setFont(new Font("Raleway",Font.PLAIN,20));
        add(text);
        
        JLabel id=new JLabel("ID");
        id.setBounds(35, 80, 100, 20);
        id.setFont(new Font("Raleway",Font.PLAIN,20));
        add(id);
        
        String options[]={"Aadhar Card","Passport","Driving License","Voter-id card","Ration card"};
        comboid=new JComboBox(options);
        comboid.setBounds(200,80,150,25);
        comboid.setBackground(Color.WHITE);
        add(comboid);
        
        JLabel lblnumber=new JLabel("Number");
        lblnumber.setBounds(35, 130, 100, 20);
        lblnumber.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblnumber);
        
        tfnumber=new JTextField();
        tfnumber.setBounds(200, 130, 150, 25);
        add(tfnumber);
        
        JLabel lblname=new JLabel("Name");
        lblname.setBounds(35, 180, 100, 20);
        lblname.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblname);
        
        tfname=new JTextField();
        tfname.setBounds(200, 180, 150, 25);
        add(tfname);
        
        JLabel lblgender=new JLabel("Gender");
        lblgender.setBounds(35, 230, 100, 20);
        lblgender.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblgender);
        
      
        
        
          rbmale= new JRadioButton("Male");
        rbmale.setBounds(200,230,80,30);
        rbmale.setFont(new Font("Tahoma",Font.PLAIN,14));
        rbmale.setBackground(Color.WHITE);
        add(rbmale);
        
         rbfemale= new JRadioButton("Female");
       rbfemale.setBounds(280,230,80,30);
         rbfemale.setFont(new Font("Tahoma",Font.PLAIN,14));
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);
        
        ButtonGroup bg=new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);
        
         JLabel lblcountry=new JLabel("Country");
        lblcountry.setBounds(35, 280, 100, 20);
        lblcountry.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblcountry);
        
        tfcountry=new JTextField();
        tfcountry.setBounds(200, 280, 150, 25);
        add(tfcountry);
        
        JLabel lblroom=new JLabel("Room number");
        lblroom.setBounds(35, 330, 150, 20);
        lblroom.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblroom);
        
        croom=new Choice();
        try{
            Conn conn=new Conn();
            String query="select * from room where availability='Available' ";
            ResultSet rs=conn.s.executeQuery(query);
            while(rs.next()){
               croom.add(rs.getString("roomnumber")); 
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        croom.setBounds(200,330, 150, 25);
        add(croom);
        
        
         JLabel lbltime=new JLabel("Checkin time");
        lbltime.setBounds(35, 380, 150, 20);
        lbltime.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lbltime);
        
        Date date=new Date();
        
        
        
        lblcheckintime=new JLabel(""+date);
        lblcheckintime.setBounds(200, 380, 300, 20);
        lblcheckintime.setFont(new Font("Raleway",Font.PLAIN,14));
        add(lblcheckintime);
        
        
        JLabel lbldeposit=new JLabel("Deposit");
        lbldeposit.setBounds(35, 430, 100, 20);
        lbldeposit.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lbldeposit);
        
        tfdeposit=new JTextField();
        tfdeposit.setBounds(200, 430, 150, 25);
        add(tfdeposit);
        
        
        
       add=new JButton("Add");
       add.setBounds(10,480,200,30);
       add.setBackground(Color.BLACK);
       add.setForeground(Color.WHITE);
       add.addActionListener(this);
       add(add);
       
       cancel=new JButton("Cancel");
       cancel.setBounds(300,480,200,30);
       cancel.setBackground(Color.BLACK);
       cancel.setForeground(Color.WHITE);
       
       cancel.addActionListener(this);
       add(cancel);
        
       
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
       Image i2=i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
       JLabel image=new JLabel(i3);
       image.setBounds(400, 100, 500, 300);
       add(image);
        
        setBounds(350,200,960,580);
        setVisible(true);
    };
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==add){
            
            String id=(String) comboid.getSelectedItem();
            String number =tfnumber.getText();
            String name=tfname.getText();
            String gender=null;
            if(rbmale.isSelected()){
                gender="Male";
            }else{
                gender="Female";
            }
            String country=tfcountry.getText();
            String room=croom.getSelectedItem();
            String time=lblcheckintime.getText();
            String deposit=tfdeposit.getText();
            
            try{
                
                String query="insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+time+"','"+deposit+"')";
                
                String query2="update room set availability = 'Occupied' where roomnumber='"+room+"'";
                
                Conn conn=new Conn();
                conn.s.executeUpdate(query);
                conn.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null, "New Customer Added Successfully");
                setVisible(false);
                new Reception();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        
        if(ae.getSource()==cancel)
        {
            setVisible(false);
            new Reception();
        }
    
    }
    public static void main(String[] args) {
        new AddCustomer();
    }

    
    
}
