package hotel.management.system;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
public class Reception extends JFrame implements ActionListener {
    JButton newCustomer,rooms,department,allemployee,managerinfo,customerinfo,searchroom,update,roomstatus,pickup,checkout,logout , back;
    Reception()
    { 
        setLayout(null);
       getContentPane().setBackground(Color.WHITE);
        
       newCustomer = new JButton("New Customer Form");
       newCustomer.setBounds(10,30, 200, 30);
       newCustomer.setBackground(Color.BLACK);
       newCustomer.setForeground(Color.WHITE);
       newCustomer.addActionListener(this);
       add(newCustomer);
       
       rooms = new JButton("Rooms");
       rooms.setBounds(10,70, 200, 30);
       rooms.setBackground(Color.BLACK);
       rooms.setForeground(Color.WHITE);
       rooms.addActionListener(this);
       add(rooms);
       
       department = new JButton("Department");
       department.setBounds(10,110, 200, 30);
       department.setBackground(Color.BLACK);
       department.setForeground(Color.WHITE);
       department.addActionListener(this);
       add(department);
       
       allemployee = new JButton("All Employee");
       allemployee.setBounds(10,150, 200, 30);
       allemployee.setBackground(Color.BLACK);
       allemployee.setForeground(Color.WHITE);
       allemployee.addActionListener(this);
       add(allemployee);
       
       customerinfo = new JButton("Customer Info");
       customerinfo.setBounds(10,190, 200, 30);
       customerinfo.setBackground(Color.BLACK);
       customerinfo.setForeground(Color.WHITE);
       customerinfo.addActionListener(this);
       add(customerinfo);
       
       managerinfo = new JButton("Manager Info");
       managerinfo.setBounds(10,230, 200, 30);
       managerinfo.setBackground(Color.BLACK);
       managerinfo.setForeground(Color.WHITE);
       managerinfo.addActionListener(this);
       add(managerinfo);
       
       checkout = new JButton("Checkout");
       checkout.setBounds(10,270, 200, 30);
       checkout.setBackground(Color.BLACK);
       checkout.setForeground(Color.WHITE);
       checkout.addActionListener(this);
       add(checkout);
       
       update = new JButton("Update Status");
       update.setBounds(10,310, 200, 30);
       update.setBackground(Color.BLACK);
       update.setForeground(Color.WHITE);
       update.addActionListener(this);
       add(update);
       
       roomstatus = new JButton("Update Room Status");
       roomstatus.setBounds(10,350, 200, 30);
       roomstatus.setBackground(Color.BLACK);
       roomstatus.setForeground(Color.WHITE);
       roomstatus.addActionListener(this);
       add(roomstatus);
       
       pickup = new JButton("Pickup Service");
       pickup.setBounds(10,390, 200, 30);
       pickup.setBackground(Color.BLACK);
       pickup.setForeground(Color.WHITE);
       pickup.addActionListener(this);
       add(pickup);
       
       searchroom = new JButton(" Search Room");
       searchroom.setBounds(10,430, 200, 30);
       searchroom.setBackground(Color.BLACK);
       searchroom.setForeground(Color.WHITE);
       searchroom.addActionListener(this);
       add(searchroom);
       
       logout = new JButton("Logout");
       logout.setBounds(10,470, 200, 30);
       logout.setBackground(Color.BLACK);
       logout.setForeground(Color.WHITE);
       logout.addActionListener(this);
       add(logout);
       
       back = new JButton("Back");
       back.setBounds(10,510, 200, 30);
       back.setBackground(Color.BLACK);
       back.setForeground(Color.WHITE);
       back.addActionListener(this);
       add(back);
        
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
       JLabel image = new JLabel(i1);
       image.setBounds(250,30,500,470);
       add(image);
               
       
       
       setBounds(350,150,800,570);
        setVisible(true);
        
    }
     @Override
    public void actionPerformed(ActionEvent e)
    {
     if(e.getSource()== newCustomer)
     {
         setVisible(false);
         new AddCustomer();
     }
     else if(e.getSource()== rooms)
     {
         setVisible(false);
         new Room();
     }
     else if(e.getSource()== department)
     {
         setVisible(false);
         new Department();
     }
     else if(e.getSource()== allemployee)
     {
         setVisible(false);
         new Empinfo();
     }
     else if(e.getSource()== managerinfo)
     {
         setVisible(false);
         new ManagerInfo();
     }
     else if(e.getSource()== customerinfo)
     {
         setVisible(false);
         new CustomerInfo();
     }
      else if(e.getSource()== searchroom)
     {
         setVisible(false);
         new SearchRoom();
     }
      else if(e.getSource()== update)
     {
         setVisible(false);
         new UpdateCheck();
     }
     else if(e.getSource()== roomstatus)
     {
         setVisible(false);
         new UpdateRoom();
     }
     else if(e.getSource()== pickup)
     {
         setVisible(false);
         new PickupService();
     }
     else if(e.getSource()== checkout)
     {
         setVisible(false);
         new Checkout();
     }
     else if(e.getSource()== logout)
     {
         setVisible(false);
         System.exit(0);
         
     }
     else if(e.getSource()== back)
     {
         setVisible(false);
         new Dashboard();
    }
    }
    public static void main(String args[])
    {
        new Reception();
    }
}
