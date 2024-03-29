package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Dashboard extends JFrame implements ActionListener
{
    JMenuItem reception,addemployee,addrooms,email,contact,adddrivers;
Dashboard(){
    setBounds(0,0,1550,1000);
    setLayout(null);
    
    
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard2.jpg"));
    Image i2=i1.getImage().getScaledInstance(1550,1000,Image.SCALE_SMOOTH);
    ImageIcon i3=new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(0,0,1550,900);
    add(image);
    
    JLabel text = new JLabel("THE GRAND HOTEL & RESORT WELCOMES YOU");
    text.setBounds(520,700 ,1000 ,50 );
    text.setFont(new Font("Tahoma",Font.ITALIC,46));
    text.setForeground(Color.WHITE);
    image.add(text);
    
    JMenuBar mb=new JMenuBar();
    mb.setBounds(0,0,1550,30);
    image.add(mb);
    
    JMenu hotel = new JMenu("Hotel Management");
    hotel.setForeground(Color.BLACK);
    mb.add(hotel);
    
    reception = new JMenuItem("Reception");
    reception.addActionListener(this);
    hotel.add(reception);
    
    email = new JMenuItem("Email");
    hotel.add(email);
    
    contact = new JMenuItem("Contact");
    hotel.add(contact);
    
    
    JMenu admin = new JMenu("Admin");
    admin.setForeground(Color.BLACK);
    mb.add(admin);
    
    addemployee = new JMenuItem("Add Employee");
    addemployee.addActionListener(this);
    admin.add(addemployee);
    
    addrooms = new JMenuItem("Add Rooms");
    addrooms.addActionListener(this);
    admin.add(addrooms);
    
    adddrivers = new JMenuItem("Add Driver");
    adddrivers.addActionListener(this);
    admin.add(adddrivers);
    
    
    JMenu aboutus = new JMenu("About Us");
    hotel.setForeground(Color.BLACK);
    mb.add(aboutus);
    
    
    setVisible(true);
}
 public void actionPerformed(ActionEvent ae)
{
    if(ae.getSource()==addemployee)
    {
        setVisible(false);
        new AddEmployee();
    }
    else if(ae.getSource()==addrooms)
    {
        setVisible(false);
        new AddRooms();
    }
    else if(ae.getSource()==adddrivers)
    {
        setVisible(false);
        new AddDriver();
    }
    else if(ae.getSource()==reception)
    {
        setVisible(false);
        new Reception();
    }

}
public static void main(String args[])
{
    new Dashboard();
}

   
}
