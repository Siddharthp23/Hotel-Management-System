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
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Checkout extends JFrame implements ActionListener {
    Choice ccustomer;
    JLabel lblroomnumber,lblcheckintime,lblcheckout;
    JButton checkoutbutton,back;
    
    Checkout()
{
 getContentPane().setBackground(Color.WHITE);
 setLayout(null);
 
 JLabel text = new JLabel("Checkout");
 text.setBounds(100,20,100,30);
 text.setForeground(Color.BLACK);
 text.setFont(new Font("Tahoma",Font.PLAIN,20));
 add(text);
 
 JLabel lblid = new JLabel("Customer ID");
 lblid.setBounds(30,78,100,30);
 add(lblid);
 
 ccustomer= new Choice();
    ccustomer.setBounds(150,80,150,25);
    add(ccustomer);
    
    try
    {
        Conn c = new Conn();
        ResultSet rs = c.s.executeQuery("select * from customer");
        while(rs.next())
        {
            ccustomer.add(rs.getString("number"));
            lblroomnumber.setText(rs.getString("room"));
            lblcheckintime.setText(rs.getString("checkintime"));
        }
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
    
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
    Image i2= i1.getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH);
    ImageIcon i3= new ImageIcon(i2);
    JLabel tick = new JLabel(i3);
    tick.setBounds(310,80,20,20);
    add(tick);
    
 JLabel lblroom = new JLabel("Room Number");
 lblroom.setBounds(30,130,100,30);
 add(lblroom);
 
 lblroomnumber = new JLabel();
 lblroomnumber.setBounds(150,130,100,30);
 add(lblroomnumber);  
 
 JLabel checkintime = new JLabel("Checkin Time");
 checkintime.setBounds(30,180,100,30);
 add(checkintime);
 
 lblcheckintime = new JLabel();
 lblcheckintime.setBounds(150,180,100,30);
 add(lblcheckintime);  
 
 JLabel checkout = new JLabel("Checkout Time");
 checkout.setBounds(30,230,100,30);
 add(checkout);
 
 Date date = new Date();
 lblcheckout = new JLabel();
 lblcheckout = new JLabel("" + date);
 lblcheckout.setBounds(150,230,150,30);
 add(lblcheckout);  
 
 checkoutbutton = new JButton("Checkout");
 checkoutbutton.setBackground(Color.BLACK);
 checkoutbutton.setForeground(Color.WHITE);
 checkoutbutton.setBounds(30,280,120,30);
 checkoutbutton.addActionListener(this);
 add(checkoutbutton);
 
 back = new JButton("Back");
 back.setBackground(Color.BLACK);
 back.setForeground(Color.WHITE);
 back.setBounds(170,280,120,30);
 back.addActionListener(this);
 add(back);
 
  try
    {
        Conn c = new Conn();
        ResultSet rs = c.s.executeQuery("select * from customer");
        while(rs.next())
        {
            ccustomer.add(rs.getString("number"));
            lblroomnumber.setText(rs.getString("room"));
            lblcheckintime.setText(rs.getString("checkintime"));
        }
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
 
    ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
    Image i5= i4.getImage().getScaledInstance(400,250,Image.SCALE_SMOOTH);
    ImageIcon i6= new ImageIcon(i5);
    JLabel image = new JLabel(i6);
    image.setBounds(350,50,400,250);
    add(image);
 
 setBounds(300,200,800,400);
 setVisible(true);

}
    @Override
    public void actionPerformed(ActionEvent e)
    {
     if(e.getSource()==checkoutbutton)
     {
         String qr1 = "delete from customer where number ='"+ccustomer.getSelectedItem()+"'";//DML command
         String qr2 ="update addroom set availablity = 'Available' where roomnumber = '"+lblroomnumber.getText()+"'";//DML command
         try
         {
             Conn c = new Conn();
             c.s.executeUpdate(qr1);
             c.s.executeUpdate(qr2);
             JOptionPane.showMessageDialog(null,"Checkout Done");
             
             setVisible(false);
             new Reception();
         }
         catch(Exception ae)
         {
             ae.printStackTrace();
         }
         
     }
     else if(e.getSource()== back)
     {
         setVisible(false);
         new Reception();
     }
    }
public static void main(String args[])
{
    new Checkout();
}

    
}
