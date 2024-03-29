package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import net.proteanit.sql.*;
public class CustomerInfo extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    CustomerInfo()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel l1= new JLabel("Document Type");
        l1.setBounds(10,10,100,20);
        add(l1);
        
        JLabel l2= new JLabel("Number");
        l2.setBounds(160,10,100,20);
        add(l2);
        
        JLabel l3= new JLabel("Name");
        l3.setBounds(290,10,100,20);
        add(l3);
        
        JLabel l4= new JLabel("Gender");
        l4.setBounds(410,10,100,20);
        add(l4);
        
        JLabel l5= new JLabel("Country");
        l5.setBounds(540,10,100,20);
        add(l5);
        
        JLabel l6= new JLabel("Room Number");
        l6.setBounds(640,10,100,20);
        add(l6);
        
        JLabel l7= new JLabel("Checkin Time");
        l7.setBounds(760,10,100,20);
        add(l7);
        
        JLabel l8= new JLabel("Deposite");
        l8.setBounds(900,10,100,20);
        add(l8);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(420,500,130,30);
        back.addActionListener(this);
        add(back);
        
        table = new JTable();
        table.setBounds(0,40,1000,400);
        add(table);
        
        try
        {
            Conn c = new Conn();
            String qr = "select * from customer";
            java.sql.ResultSet rs = c.s.executeQuery(qr);
            //table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e)
        {
           e.printStackTrace();
        }
        setBounds(300,200,1000,600);
        setVisible(true);
    }
    public static void main(String args[])
    {
        new CustomerInfo();
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
     if(e.getSource()==back)
     {
         new Reception();
         setVisible(false);
     }
    }

    private static class ResultSet {

        public ResultSet() {
        }
    }

    
} 

