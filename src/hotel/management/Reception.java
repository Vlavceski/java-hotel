
package hotel.management;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Reception extends JFrame implements ActionListener {
   JButton n,rooms,department,allEmployee,checkout,customers,managerInfo,searchRoom,update,roomstatus,pickup,logout;
    Reception(){
       
       getContentPane().setBackground(Color.WHITE);
       setLayout(null);
       
       n=new JButton("New Customer Form");
       n.setBounds(10,30,200,30);
       n.setBackground(Color.BLACK);
       n.setForeground(Color.WHITE);
       n.addActionListener(this);
       add(n);
       
        rooms=new JButton("Rooms");
       rooms.setBounds(10,80,200,30);
       rooms.setBackground(Color.BLACK);
       rooms.setForeground(Color.WHITE);
        rooms.addActionListener(this);
       add(rooms);
       
        department=new JButton("Department");
       department.setBounds(10,130,200,30);
       department.setBackground(Color.BLACK);
       department.setForeground(Color.WHITE);
        department.addActionListener(this);
      add(department);
       
       allEmployee=new JButton("All Employees");
       allEmployee.setBounds(10,180,200,30);
       allEmployee.setBackground(Color.BLACK);
       allEmployee.setForeground(Color.WHITE);
       allEmployee.addActionListener(this);
       add(allEmployee);
       
       customers=new JButton("Customer info");
       customers.setBounds(10,230,200,30);
       customers.setBackground(Color.BLACK);
       customers.setForeground(Color.WHITE);
       customers.addActionListener(this);
       add(customers);
       
       managerInfo=new JButton("Manager Info");
       managerInfo.setBounds(10,280,200,30);
       managerInfo.setBackground(Color.BLACK);
       managerInfo.setForeground(Color.WHITE);
       managerInfo.addActionListener(this);
        add(managerInfo);
       
        checkout=new JButton("Checkout");
       checkout.setBounds(10,330,200,30);
       checkout.setBackground(Color.BLACK);
       checkout.setForeground(Color.WHITE);
       checkout.addActionListener(this);
       add(checkout);
       
        update=new JButton("Update status");
       update.setBounds(10,380,200,30);
       update.setBackground(Color.BLACK);
       update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);
       
      roomstatus=new JButton("Update Room Status");
       roomstatus.setBounds(10,430,200,30);
       roomstatus.setBackground(Color.BLACK);
       roomstatus.setForeground(Color.WHITE);
        roomstatus.addActionListener(this);
        add(roomstatus);
        
       
       pickup=new JButton("Pickup Serivce");
       pickup.setBounds(10,480,200,30);
       pickup.setBackground(Color.BLACK);
       pickup.setForeground(Color.WHITE);
       pickup.addActionListener(this);
       add(pickup);
       
       searchRoom=new JButton("Search Room");
       searchRoom.setBounds(10,530,200,30);
       searchRoom.setBackground(Color.BLACK);
       searchRoom.setForeground(Color.WHITE);
       searchRoom.addActionListener(this);
       add(searchRoom);
       
        logout=new JButton("Logout");
       logout.setBounds(10,590,200,30);
       logout.setBackground(Color.BLACK);
       logout.setForeground(Color.WHITE);
       logout.addActionListener(this);
       add(logout);
       
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
       JLabel image=new JLabel(i1);
       image.setBounds(250, 30, 500, 470);
       add(image);
       
       setBounds(350,100,800,700);
       setVisible(true);
   }
   @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==n){
            setVisible(false);
            new AddCustomer();
        }
        else if(ae.getSource()==rooms){
            setVisible(false);
            new Room();
        }
        else if(ae.getSource()==department){
            setVisible(false);
            new Department();
            
        }else if(ae.getSource()==allEmployee){
            setVisible(false);
            new EmployeeInfo();
        }
        
        else if(ae.getSource()==allEmployee){
            setVisible(false);
            new ManagerInfo();
        }
        else if(ae.getSource()==customers){
            setVisible(false);
            new CustomerInfo();
        } else if(ae.getSource()==searchRoom){
            setVisible(false);
            new SearchRoom();
        }else if(ae.getSource()==update){
            setVisible(false);
            new UpdateCheck();
        }else if(ae.getSource()==roomstatus){
            setVisible(false);
            new UpdateRoom();
        }
        else if(ae.getSource()==pickup){
            setVisible(false);
            new Pickup();
        }else if(ae.getSource()==checkout){
            setVisible(false);
            new Checkout();
        }else if(ae.getSource()==logout){
            setVisible(false);
            System.exit(0);
        }
    
    }
    public static void main(String[] args) {
        new Reception();
    }

    
}
