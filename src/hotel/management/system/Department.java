package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Department extends JFrame implements ActionListener {
    JTable table;
    JButton back; 
    Department()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel l1= new JLabel("Department");
        l1.setBounds(180,10,100,20);
        add(l1);
        
        JLabel l2= new JLabel("Budget");
        l2.setBounds(420,10,100,20);
        add(l2);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(280,400,130,30);
        back.addActionListener(this);
        add(back);
        
        table = new JTable();
        table.setBounds(0,50,700,350);
        add(table);
        
        try
        {
            Conn c = new Conn();
            String qr = "select * from department";
            java.sql.ResultSet rs = c.s.executeQuery(qr);
//            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e)
        {
           e.printStackTrace();
        }
        
        setBounds(400,200,700,480);
        setVisible(true);
    }
    
    public static void main(String args[])
    {
        new Department();
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
