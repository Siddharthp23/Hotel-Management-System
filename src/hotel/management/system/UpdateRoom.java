package hotel.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UpdateRoom extends JFrame implements ActionListener {

    Choice ccustomer; 
    JButton check,update,back;
    JTextField tfroom,tfavailable,tfstatus,tfpaid,tfpending;
UpdateRoom()
{
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);
     
    JLabel text = new JLabel("Update Room Status");
    text.setFont(new Font("Tahoma",Font.PLAIN,25));
    text.setBounds(30,20,250,30);
    add(text);
    
    JLabel lblid = new JLabel("Customer Id");
    lblid.setBounds(30,80,100,20);
    add(lblid);
    
    ccustomer= new Choice();
    ccustomer.setBounds(200,80,150,25);
    add(ccustomer);
    
    try
    {
        Conn c = new Conn();
        ResultSet rs = c.s.executeQuery("select * from customer");
        while(rs.next())
        {
            ccustomer.add(rs.getString("number"));
        }
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
    
    JLabel lblroom = new JLabel("Room Number");
    lblroom.setBounds(30,120,100,20);
    add(lblroom);
    
    tfroom = new JTextField();
    tfroom.setBounds(200,120,150,25);
    add(tfroom);
    
    JLabel lblavailable = new JLabel("Availablity");
    lblavailable.setBounds(30,160,100,20);
    add(lblavailable);
    
    tfavailable = new JTextField();
    tfavailable.setBounds(200,160,150,25);
    add(tfavailable);
    
    JLabel lblstatus = new JLabel("Cleaning Status");
    lblstatus.setBounds(30,200,100,20);
    add(lblstatus);
    
    tfstatus = new JTextField();
    tfstatus.setBounds(200,200,150,25);
    add(tfstatus);
   
    
    check = new JButton("Check");
    check.setBackground(Color.BLACK);
    check.setForeground(Color.WHITE);
    check.setBounds(30,300,120,30);
    check.addActionListener(this);
    add(check);
    
    update = new JButton("Update");
    update.setBackground(Color.BLACK);
    update.setForeground(Color.WHITE);
    update.setBounds(210,300,120,30);
    update.addActionListener(this);
    add(update);
    
    back = new JButton("Back");
    back.setBackground(Color.BLACK);
    back.setForeground(Color.WHITE);
    back.setBounds(105,360,150,30);
    back.addActionListener(this);
    add(back);
    
    ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
    Image i2=i1.getImage().getScaledInstance(550,400 ,Image.SCALE_DEFAULT);
    ImageIcon i3= new ImageIcon(i2); 
    JLabel image = new JLabel(i3);
    image.setBounds(400,50,500,380);
    add(image);
    
    setBounds(300,200,980,500);
    setVisible(true);
}

@Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== check)
        {
            try
            {
                Conn c = new Conn();
            String id = ccustomer.getSelectedItem();
            String qr = "select * from customer where number = '"+id+"'";
            ResultSet rs = c.s.executeQuery(qr);
            while(rs.next())
            {
                tfroom.setText(rs.getString("room"));
            }
            ResultSet rs2=c.s.executeQuery("select * from addroom where roomnumber = '"+tfroom.getText()+"'");//DDL command
            while(rs2.next())
            {
             tfavailable.setText(rs2.getString("availablity"));
             tfstatus.setText(rs2.getString("status"));
            }
            }
            catch(Exception ex)
            {
             ex.printStackTrace();
            }
        }
        else if(e.getSource()== update)
        {
          String number = ccustomer.getSelectedItem();
          String room = tfroom.getText();
          String available = tfavailable.getText();
          String status = tfstatus.getText();
          try 
          {
              Conn  c = new Conn();
              c.s.executeUpdate("update addroom set availablity = '"+available+"',status = '"+status+"' where roomnumber = '"+room+"'");//DML command
              
              JOptionPane.showMessageDialog(null, "Data Updated Successfully");
              
              setVisible(false);
              new Reception();
              
          }catch(Exception exe)
          {exe.printStackTrace();
          }
        }
        else if(e.getSource()==back)
        {
         setVisible(false);
         new Reception();
        }
        
        }
public static void main(String args[])
{
    new UpdateRoom();
}

    
  
}
