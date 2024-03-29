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

public class UpdateCheck extends JFrame implements ActionListener {

    Choice ccustomer; 
    JButton check,update,back,delete;
    JTextField tfroom,tfname,tfcheckin,tfpaid,tfpending;
UpdateCheck()
{
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);
     
    JLabel text = new JLabel("Update Status");
    text.setFont(new Font("Tahoma",Font.PLAIN,20));
    text.setBounds(90,20,200,30);
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
    
    JLabel lblname = new JLabel("Name");
    lblname.setBounds(30,160,100,20);
    add(lblname);
    
    tfname = new JTextField();
    tfname.setBounds(200,160,150,25);
    add(tfname);
    
    JLabel lblcheckin = new JLabel("Checkin Time");
    lblcheckin.setBounds(30,200,100,20);
    add(lblcheckin);
    
    tfcheckin = new JTextField();
    tfcheckin.setBounds(200,200,150,25);
    add(tfcheckin);
   
    JLabel lblpaid = new JLabel("Amount Paid");
    lblpaid.setBounds(30,240,100,20);
    add(lblpaid);
    
    tfpaid = new JTextField();
    tfpaid.setBounds(200,240,150,25);
    add(tfpaid);
    
    JLabel lblpending = new JLabel("Pending Amount");
    lblpending.setBounds(30,280,100,20);
    add(lblpending);
    
    tfpending = new JTextField();
    tfpending.setBounds(200,280,150,25);
    add(tfpending);
    
    check = new JButton("Check");
    check.setBackground(Color.BLACK);
    check.setForeground(Color.WHITE);
    check.setBounds(30,340,120,30);
    check.addActionListener(this);
    add(check);
    
    update = new JButton("Update");
    update.setBackground(Color.BLACK);
    update.setForeground(Color.WHITE);
    update.setBounds(210,340,120,30);
    update.addActionListener(this);
    add(update);
    
//    delete = new JButton("Delete");
//    delete.setBackground(Color.BLACK);
//    delete.setForeground(Color.WHITE);
//    delete.setBounds(30,390,120,30);
//    delete.addActionListener(this);
//    add(delete);
    
    back = new JButton("Back");
    back.setBackground(Color.BLACK);
    back.setForeground(Color.WHITE);
    back.setBounds(125,390,120,30);
    back.addActionListener(this);
    add(back);
    
    ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/checkout.jpg"));
    Image i2=i1.getImage().getScaledInstance(400,500 ,Image.SCALE_DEFAULT);
    ImageIcon i3= new ImageIcon(i2); 
    JLabel image = new JLabel(i3);
    image.setBounds(400,50,500,380);
    add(image);
    
//    ImageIcon i2= new ImageIcon(ClassLoader.getSystemResource("icons/checkout.jpg"));
//    JLabel image2 = new JLabel(i2);
//    image2.setBounds(650,100,200,350);
//    add(image2);

//    ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("icons/checkout.jpg"));
//    Image i3=i2.getImage().getScaledInstance(200,100,Image.SCALE_DEFAULT);
//    ImageIcon i4=new ImageIcon(i3);
//    JLabel image2 = new JLabel(i4);
//    image.setBounds(800,250,250,300);
//    add(image2);


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
                tfname.setText(rs.getString("name"));
                tfcheckin.setText(rs.getString("checkintime"));
                tfpaid.setText(rs.getString("deposite"));
            }
            ResultSet rs2=c.s.executeQuery("select * from addroom where roomnumber = '"+tfroom.getText()+"'");//DDL command
            while(rs2.next())
            {
                String price = rs2.getString("price");
                if(Integer.parseInt(price)>=Integer.parseInt(tfpaid.getText()))
                {
                int amountpaid = Integer.parseInt(price) - Integer.parseInt(tfpaid.getText());
                tfpending.setText("" + amountpaid);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, " Amount Already Paid");
                }
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
          String name = tfname.getText();
          String checkin = tfcheckin.getText();
          String deposite = tfpaid.getText();
          try 
          {
              Conn  c = new Conn();
              c.s.executeUpdate("update customer set room = '"+room+"',name = '"+name+"',checkintime = '"+checkin+"',deposite= '"+deposite+"' where number = '"+number+"'");//DML command
              
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
//        else if(e.getSource()==delete)
//        {
//            
//        }
        }
public static void main(String args[])
{
    new UpdateCheck();
}

    
  
}
