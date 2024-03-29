package hotel.management.system;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AddRooms extends JFrame implements ActionListener{
JButton add , cancel,Back;    
JTextField tfroom,tfprice;
JComboBox availablecombo,cleancombo,bedcombo;
          
AddRooms()
{
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);
    
    JLabel heading = new JLabel("Add Rooms");
    heading.setFont(new Font("Tahoma",Font.BOLD,18));
    heading.setBounds(150,20,200,20);
    add(heading);
    
    JLabel lblroomno = new JLabel("Room Number");
    lblroomno.setFont(new Font("Tahoma",Font.PLAIN,16));
    lblroomno.setBounds(60,80,120,30);
    add(lblroomno);
    
    tfroom= new JTextField();
    tfroom.setBounds(200,80,150,30);
    add(tfroom);
    
    JLabel lblavailable = new JLabel("Available");
    lblavailable.setFont(new Font("Tahoma",Font.PLAIN,16));
    lblavailable.setBounds(60,130,120,30);
    add(lblavailable);
    
    String availableoption[]={"Available","Occuied"};
    availablecombo = new JComboBox(availableoption);
    availablecombo.setBounds(200,130,150,30);
    availablecombo.setBackground(Color.WHITE);
    add(availablecombo); 
    
    JLabel lblclean = new JLabel("Cleaning Status");
    lblclean.setFont(new Font("Tahoma",Font.PLAIN,16));
    lblclean.setBounds(60,180,120,30);
    add(lblclean);
    
    String cleanoption[]={"Cleaned","Not Cleaned"};
    cleancombo = new JComboBox(cleanoption);
    cleancombo.setBounds(200,180,150,30);
    cleancombo.setBackground(Color.WHITE);
    add(cleancombo); 
    
    JLabel lblprice = new JLabel("Price");
    lblprice.setFont(new Font("Tahoma",Font.PLAIN,16));
    lblprice.setBounds(60,230,120,30);
    add(lblprice);
    
    tfprice= new JTextField();
    tfprice.setBounds(200,230,150,30);
    add(tfprice);
 
    JLabel lblbedtype = new JLabel("Bed Type");
    lblbedtype.setFont(new Font("Tahoma",Font.PLAIN,16));
    lblbedtype.setBounds(60,280,120,30);
    add(lblbedtype);
    
    String bedoption[]={"Single Bed","Double Bed"};
    bedcombo = new JComboBox(bedoption);
    bedcombo.setBounds(200,280,150,30);
    bedcombo.setBackground(Color.WHITE);
    add(bedcombo); 

    add = new JButton("Add Room");
    add.setForeground(Color.WHITE);
    add.setBackground(Color.BLACK);
    add.setBounds(60,350,130,30);
    add.addActionListener(this);
    add(add);
    
    cancel = new JButton("Cancel");
    cancel.setForeground(Color.WHITE);
    cancel.setBackground(Color.BLACK);
    cancel.setBounds(220,350,130,30);
    cancel.addActionListener(this);
    add(cancel);
    
    Back = new JButton("Back");
    Back.setForeground(Color.WHITE);
    Back.setBackground(Color.BLACK);
    Back.setBounds(400,350,130,30);
    Back.addActionListener(this);
    add(Back);
    
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/room.jpg"));
    Image i2 = i1.getImage().getScaledInstance(500,300 ,Image.SCALE_SMOOTH );
    ImageIcon i3= new  ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(400,30,500,300);
    add(image);
    
    
    setBounds(330,200,940,470);
    setVisible(true);
    
}

public void actionPerformed(ActionEvent ae)
{
    if(ae.getSource()==add)
    {
         String roomnumber = tfroom.getText();
         String availability = (String)availablecombo.getSelectedItem();
         String status = (String)cleancombo.getSelectedItem();
         String price = tfprice.getText();
         String bedtype = (String)bedcombo.getSelectedItem();
         if(roomnumber.equals("")){
         JOptionPane.showMessageDialog(null,"Please enter Room Number" );
         }
         if(availability.equals("")){
         JOptionPane.showMessageDialog(null,"Please select Availability" );
         }
         if(status.equals("")){
         JOptionPane.showMessageDialog(null,"Please select Room Status" );
         }
         if(price.equals("")){
         JOptionPane.showMessageDialog(null,"Please enter Price" );
         }    
         if(bedtype.equals("")){
         JOptionPane.showMessageDialog(null,"Please select Bed-Type" );
         }
     
         try
         {
             Conn conn = new Conn();
             String qr ="insert into addroom values('"+roomnumber+"','"+availability+"','"+status+"','"+price+"','"+bedtype+"')";
             conn.s.executeUpdate(qr);
             JOptionPane.showMessageDialog(null,"New Room Added Successfully");
         }catch(Exception e)
         {
             e.printStackTrace();
         }
         
         
    }
    else if(ae.getSource()==cancel)
    {
        setVisible(false);
    }
    else if(ae.getSource()==Back)
    {
        setVisible(false);
        new Dashboard();
    }
}
public static void main(String args[])
{
    new AddRooms()  ;
}
}
