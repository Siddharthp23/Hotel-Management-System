package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.ResultSet;
public class PickupService extends JFrame implements ActionListener {
    JTable table;
    JButton back,submit;
    Choice typeofcar;
    JCheckBox available;
    PickupService()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
       
        JLabel text= new JLabel("Pickup Service");
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        text.setBounds(400,30,200,30);
        add(text);
        
        JLabel lblbed= new JLabel("Type of Car");
        lblbed.setBounds(50,100,100,20);
        add(lblbed);
        
        typeofcar = new Choice();
        typeofcar.setBounds(150,100,200,25);
        add(typeofcar);
                
        try
        {
        Conn c = new Conn();
        ResultSet rs= c.s.executeQuery("select * from driver");
        while(rs.next())
        {
        typeofcar.add(rs.getString("cartype"));
        }   
        }
        catch(Exception e)
        {e.printStackTrace();
        }
        
        JLabel l1= new JLabel("Name");
        l1.setBounds(50,160,100,20);
        add(l1);
        
        JLabel l2= new JLabel("Age");
        l2.setBounds(200,160,100,20);
        add(l2);
        
        JLabel l3= new JLabel("Car Company");
        l3.setBounds(330,160,100,20);
        add(l3);
        
        JLabel l4= new JLabel("Car Model");
        l4.setBounds(470,160,100,20);
        add(l4);
        
        JLabel l5= new JLabel("Availablity");
        l5.setBounds(610,160,100,20);
        add(l5);
        
        JLabel l6= new JLabel("Location");
        l6.setBounds(755,160,100,20);
        add(l6);
        
        JLabel l7= new JLabel("Gender");
        l7.setBounds(880,160,100,20);
        add(l7);
        
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(300,520,130,30);
        submit.addActionListener(this);
        add(submit);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(500,520,130,30);
        back.addActionListener(this);
        add(back);
        
        table = new JTable();
        table.setBounds(0,200,1000,300);
        add(table);
 
         try
        {
            Conn c = new Conn();
            String qr = "select * from driver";
            ResultSet rs = c.s.executeQuery(qr);
            //table.setModel(DbUtils.resultSetToTableModel(rs));
        
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        setBounds(300,200,1000,600);
        setVisible(true);
        
    }
    public static void main(String args[])
    {
        new PickupService();
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==submit)
        {
            try
            {
                String qr1 = "select * from driver where cartype ='"+typeofcar.getSelectedItem()+"'";
                Conn conn = new Conn();
               ResultSet rs;
               rs = conn.s.executeQuery(qr1);
              // table.setModel(DbUtils.resultSetToTableModel((java.sql.ResultSet) rs));
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
                
        }
        else if(e.getSource()==back)
     {
         new Reception();
         setVisible(false);
     }
    }
} 
