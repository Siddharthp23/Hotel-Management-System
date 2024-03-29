package hotel.management.system;

import java.awt.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class HotelManagementSystem extends JFrame implements ActionListener {
       HotelManagementSystem()
       {
//           setSize(1366,565);
//           setLocation(100,100);
           setBounds(0,0,1550,1000);
           setLayout(null);
           
           ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/hotelms1.jpg"));
           Image i2 = i1.getImage().getScaledInstance(1570,850, Image.SCALE_DEFAULT);
           ImageIcon i3 = new ImageIcon(i2);
           JLabel image= new JLabel(i3);
           image.setBounds(0,0,1570 ,850 );//location wrt to frame
           add(image);
           
           JLabel text = new JLabel("THE GRAND HOTEL");
           text.setBounds(20,510, 1000,90);
           text.setForeground(Color.BLACK);
           text.setFont(new Font("serif",Font.BOLD,50));
           image.add(text);
           
           JLabel text1 = new JLabel("Since 1957");
           text1.setBounds(20,560, 1000,90);
           text1.setForeground(Color.BLACK);
           text1.setFont(new Font("serif",Font.ITALIC,50));
           image.add(text1);
           
           
           JButton next = new JButton("Next");
           next.setBounds(1300,670,150,50);
           next.setBackground(Color.WHITE );
           next.setForeground(Color.BLACK );
           next.addActionListener(this);
           next.setFont(new Font("serif",Font.PLAIN,24)); 
           add(next);
           
           setVisible(true);
           
//           while(true)
//           { text.setVisible(false);
//               try{
//                   Thread.sleep(500);
//               }catch(Exception e)
//               {
//               e.printStackTrace();
//               }
//               text.setVisible(true);
//               try{
//                   Thread.sleep(500);
//               }catch(Exception e)
//               {
//               e.printStackTrace();
//               }
//           }
       }
       @Override
       public void actionPerformed(ActionEvent ae)
       {
           setVisible(false);
           try {
               new Login();
           } catch (IOException ex) {
               Logger.getLogger(HotelManagementSystem.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
    public static void main(String[] args)
    {
      new HotelManagementSystem();
    }
 
}
