package hotel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.sql.*;
import java.util.Date;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class AddCustomer extends JFrame implements ActionListener
{
    JComboBox comboid;
    JTextField tfnumber,tfname,tfcountry,tfdeposite;
    JRadioButton rmale,rfemale;
    JButton add,back;
    Choice croom;
    JLabel checkintime;
AddCustomer()
{
    
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);
    
   JLabel text = new JLabel("New Customer Form"); 
   text.setBounds(100,20,300,30);
   text.setFont(new Font("Railway",Font.PLAIN,20));
   add(text);
    
   JLabel lblid = new JLabel("ID"); 
   lblid.setBounds(35,80,100,20);
   lblid.setFont(new Font("Railway",Font.PLAIN,20));
   add(lblid);
   
   String option[]={"Aadhar Card","Driving Licence","Passport","Voter Id Card","Ration Card"};
   comboid = new JComboBox(option);
   comboid.setBounds(200,80,150,25);
   comboid.setBackground(Color.WHITE);
   add(comboid);
   
   JLabel lblnumber = new JLabel("Number"); 
   lblnumber.setBounds(35,120,100,20);
   lblnumber.setFont(new Font("Railway",Font.PLAIN,20));
   add(lblnumber);
   
   tfnumber= new JTextField();
   tfnumber.setBounds(200,120,150,25);
   add(tfnumber);
   
   JLabel lblname = new JLabel("Name"); 
   lblname.setBounds(35,160,100,20);
   lblname.setFont(new Font("Railway",Font.PLAIN,20));
   add(lblname);
   
   tfname= new JTextField();
   tfname.setBounds(200,160,150,25);
   add(tfname);
   
   JLabel lblgender = new JLabel("Gender"); 
   lblgender.setBounds(35,200,100,20);
   lblgender.setFont(new Font("Railway",Font.PLAIN,20));
   add(lblgender);
   
   
   rmale= new JRadioButton("Male");
   rmale.setBackground(Color.WHITE);
   rmale.setBounds(200,200,60 ,25);
   add(rmale);
   
   rfemale= new JRadioButton("Female");
   rfemale.setBackground(Color.WHITE);
   rfemale.setBounds(270,200,100,25);
   add(rfemale);
   
   ButtonGroup bg= new ButtonGroup();
   bg.add(rmale);
   bg.add(rfemale);
        
   
   JLabel lblcountry = new JLabel("Country"); 
   lblcountry.setBounds(35,240,100,25);
   lblcountry.setFont(new Font("Railway",Font.PLAIN,20));
   add(lblcountry);
   
   tfcountry= new JTextField();
   tfcountry.setBounds(200,240,150,25);
   add(tfcountry);
   
   JLabel lblroom = new JLabel("Allocated Room "); 
   lblroom.setBounds(35,280,150,20);
   lblroom.setFont(new Font("Railway",Font.PLAIN,20));
   add(lblroom);
     
   croom = new Choice();
   try
   { 
       Conn conn= new Conn();
       String qr="Select * from addroom";
       ResultSet rs = conn.s.executeQuery(qr);
       while(rs.next())
       {
           croom.add(rs.getString("roomnumber"));
       }
   }
   catch(Exception e)
   {
       e.printStackTrace();
   }
   croom.setBounds(200,280,150,25);
   add(croom);
   
   JLabel lbltime = new JLabel("Checkin Time"); 
   lbltime.setBounds(35,320,120,20);
   lbltime.setFont(new Font("Railway",Font.PLAIN,20));
   add(lbltime);
   
   Date date= new Date();
   
   checkintime = new JLabel("" + date); 
   checkintime.setBounds(200,320,120,20);
   checkintime.setFont(new Font("Railway",Font.PLAIN,16));
   add(checkintime);
   
   
   JLabel lbldeposite = new JLabel("Deposite"); 
   lbldeposite.setBounds(35,360,100,25);
   lbldeposite.setFont(new Font("Railway",Font.PLAIN,20));
   add(lbldeposite);
   
   tfdeposite= new JTextField();
   tfdeposite.setBounds(200,360,150,25);
   add(tfdeposite);
   
   add = new JButton("Add");
   add.setBackground(Color.BLACK);
   add.setForeground(Color.WHITE);
   add.setBounds(50,410,120,30);
   add.addActionListener(this);
   add(add);
   
   back = new JButton("Back");
   back.setBackground(Color.BLACK);
   back.setForeground(Color.WHITE);
   back.setBounds(200,410,120,30);
   back.addActionListener(this);
   add(back);
   
   ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/customer.png"));
   Image i2 = i1.getImage().getScaledInstance(300,350, Image.SCALE_DEFAULT);
   ImageIcon i3= new ImageIcon(i2);
   JLabel image = new JLabel(i3);
   image.setBounds(400,50,300,350);
   add(image);
   
   
   setBounds(350,200,800,500);
    setVisible(true);
}

    
    public void actionPerformed(ActionEvent e)
    {
     if((e.getSource()== add))
     {
      String id = (String)comboid.getSelectedItem();
      String number = tfnumber.getText();
      String name = tfname.getText();
      String country = tfcountry.getText();
      String gender = null;
      if(rmale.isSelected())
      {
          gender = "Male";
      }else if(rfemale.isSelected())
      {
          gender = "female";
      }
      String room = croom.getSelectedItem();
      String time = checkintime.getText();
      String deposite = tfdeposite.getText();
      try
      {
          String qr = "insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+time+"','"+deposite+"')";
          String qr1= "update addroom set availablity = 'Occupied' where roomnumber = '"+room+"'";
          
          Conn conn = new Conn();
          
          conn.s.executeUpdate(qr);
          conn.s.executeUpdate(qr1);
          
          JOptionPane.showMessageDialog((null),"New Customer Added Successfully");
          setVisible(false);
          new Reception();      
      }  
      catch(Exception ex)
              {
                  ex.printStackTrace();
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
    new AddCustomer();
}
}
