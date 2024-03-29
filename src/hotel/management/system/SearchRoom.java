package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.ResultSet;
public class SearchRoom extends JFrame implements ActionListener {
    JTable table;
    JButton back,submit;
    JComboBox bedtype;
    JCheckBox available;
    SearchRoom()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
       
        JLabel text= new JLabel("Search For Room");
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        text.setBounds(400,30,200,30);
        add(text);
        
        JLabel lblbed= new JLabel("Bed Type");
        lblbed.setBounds(50,100,100,20);
        add(lblbed);
        
        bedtype = new JComboBox(new String[]{"Single Bed","Double Bed"});
        bedtype.setBounds(150,100,150,25);
        bedtype.setBackground(Color.WHITE);
        add(bedtype);
        
        available = new JCheckBox("Only display available");
        available.setBounds(650,100,150,25);
        available.setBackground(Color.WHITE);
        add(available);
        
        JLabel l1= new JLabel("Room Number");
        l1.setBounds(50,160,100,20);
        add(l1);
        
        JLabel l2= new JLabel("Avaliblity");
        l2.setBounds(270,160,100,20);
        add(l2);
        
        JLabel l3= new JLabel("Status");
        l3.setBounds(450,160,100,20);
        add(l3);
        
        JLabel l4= new JLabel("Price");
        l4.setBounds(670,160,100,20);
        add(l4);
        
        JLabel l5= new JLabel("Bed Type");
        l5.setBounds(870,160,100,20);
        add(l5);
        
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
            String qr = "select * from addroom";
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
        new SearchRoom();
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==submit)
        {
            try
            {
                String qr1 = "select * from addroom where bedtype='"+bedtype.getSelectedItem()+"'";
                String qr2 ="select * from addroom where availablity = 'Available' AND bedtype='"+bedtype.getSelectedItem()+"'";
               Conn conn = new Conn();
               ResultSet rs;
               if(available.isSelected())
               {
                  rs = conn.s.executeQuery(qr2);
              }
               else 
               {
                  rs = conn.s.executeQuery(qr1);
               }
               //table.setModel(DbUtils.resultSetToTableModel((java.sql.ResultSet) rs));
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
