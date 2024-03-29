package hotel.management.system;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AddDriver extends JFrame implements ActionListener{
JButton add , cancel,Back;    
JTextField tfname,tfmodel,tfage,tflocation;
JComboBox carcombo,divercombo;
JRadioButton rbmale,rbfemale;
          
AddDriver()
{
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);
    
    JLabel heading = new JLabel("Add Driver");
    heading.setFont(new Font("Tahoma",Font.BOLD,18));
    heading.setBounds(150,20,200,20);
    add(heading);
    
    JLabel lblname = new JLabel("Name");
    lblname.setFont(new Font("Tahoma",Font.PLAIN,16));
    lblname.setBounds(60,80,120,30);
    add(lblname);
    
    tfname = new JTextField();
    tfname.setBounds(200,80,150,30);
    add(tfname);
    
    JLabel lblage = new JLabel("Age");
    lblage.setFont(new Font("Tahoma",Font.PLAIN,16));
    lblage.setBounds( 60,130,120,30);
    add(lblage);
    
    tfage = new JTextField();
    tfage.setBounds(200,130,150,30);
    add(tfage);
    
    JLabel lblgender = new JLabel("Gender");
    lblgender.setFont(new Font("Tahoma",Font.PLAIN,16));
    lblgender.setBounds(60,180,120,30);
    add(lblgender);
    
    rbmale = new JRadioButton("Male");
    rbmale.setBounds(200,180 ,70 ,30 );
    rbmale.setBackground(Color.WHITE);
    rbmale.setFont(new Font("Tahoma",Font.PLAIN,14));
    add(rbmale);
        
    rbfemale = new JRadioButton("Female");
    rbfemale.setBounds(270,180 ,70 ,30 );
    rbfemale.setBackground(Color.WHITE);
    rbfemale.setFont(new Font("Tahoma",Font.PLAIN,14));
    add(rbfemale);
        
    ButtonGroup bg= new ButtonGroup();
    bg.add(rbmale);
    bg.add(rbfemale);
        
    
    JLabel lblcompany = new JLabel("Car Company");
    lblcompany.setFont(new Font("Tahoma",Font.PLAIN,16));
    lblcompany.setBounds(60,230,120,30);
    add(lblcompany);

    String caroption[]={"BMW","Ford","Toyota","Hyundai","Nissan","Maruti Suzuki","Tata","Mahindra","Porche","Renault","Kia","Jeep"};
    carcombo = new JComboBox(caroption);
    carcombo.setBounds(200,230,150,30);
    carcombo.setBackground(Color.WHITE);
    add(carcombo); 

    JLabel lblcartype = new JLabel("Car Model");
    lblcartype.setFont(new Font("Tahoma",Font.PLAIN,16));
    lblcartype.setBounds(60,280,120,30);
    add(lblcartype);
    
    tfmodel= new JTextField();
    tfmodel.setBounds(200,280,150,30);
    add(tfmodel);
 
    JLabel lblavailable = new JLabel("Available");
    lblavailable.setFont(new Font("Tahoma",Font.PLAIN,16));
    lblavailable.setBounds(60,330,120,30);
    add(lblavailable);
    
    String driveroption[]={"Available","Busy"};
    divercombo = new JComboBox(driveroption);
    divercombo.setBounds(200,330,150,30);
    divercombo.setBackground(Color.WHITE);
    add(divercombo); 
   
    JLabel lbllocation = new JLabel("Location");
    lbllocation.setFont(new Font("Tahoma",Font.PLAIN,16));
    lbllocation.setBounds(60,380,120,30);
    add(lbllocation);
    
    tflocation= new JTextField();
    tflocation.setBounds(200,380,150,30);
    add(tflocation);
  
    add = new JButton("Add Driver");
    add.setForeground(Color.WHITE);
    add.setBackground(Color.BLACK);
    add.setBounds(60,440,130,30);
    add.addActionListener(this);
    add(add);
    
    cancel = new JButton("Cancel");
    cancel.setForeground(Color.WHITE);
    cancel.setBackground(Color.BLACK);
    cancel.setBounds(220,440,130,30);
    cancel.addActionListener(this);
    add(cancel);
    
    Back = new JButton("Back");
    Back.setForeground(Color.WHITE);
    Back.setBackground(Color.BLACK);
    Back.setBounds(400,440,130,30);
    Back.addActionListener(this);
    add(Back);
    
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/download1.jpeg"));
    Image i2 = i1.getImage().getScaledInstance(500,300 ,Image.SCALE_SMOOTH );
    ImageIcon i3= new  ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(400,90,500,300);
    add(image);
    
    
    setBounds(300,150,980,550);
    setVisible(true);
    
}

public void actionPerformed(ActionEvent ae)
{
    if(ae.getSource()==add)
    {
         String name = tfname.getText();
         String age = tfage.getText();
         String company = (String)carcombo.getSelectedItem();
         String cartype = tfmodel.getText();
         String availability = (String)divercombo.getSelectedItem();
         String location = tflocation.getText();

         if(name.equals("")){
         JOptionPane.showMessageDialog(null,"Please enter Name" );
         }
         if(availability.equals("")){
         JOptionPane.showMessageDialog(null,"Please select Availability" );
         }
         if(age.equals("")){
         JOptionPane.showMessageDialog(null,"Please enter Age " );
         }
         if(company.equals("")){
         JOptionPane.showMessageDialog(null,"Please select Company" );
         }    
         if(cartype.equals("")){
         JOptionPane.showMessageDialog(null,"Please enter Car-Model" );
         }
         if(location.equals("")){
         JOptionPane.showMessageDialog(null,"Please enter Location" );
         }
  
          String gender = null;
      if(rbmale.isSelected())
      {
          gender = "Male";
      }else if(rbfemale.isSelected())
      {
          gender = "female";
      }
      if(gender.equals("")){
     JOptionPane.showMessageDialog(null,"Enter Gender" );
     }

         try
         {
             Conn conn = new Conn();
             String qr ="insert into driver values('"+name+"','"+age+"','"+company+"','"+cartype+"','"+availability+"','"+location+"','"+gender+"')";
             conn.s.executeUpdate(qr);
             JOptionPane.showMessageDialog(null,"New Driver Added Successfully");
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
    new AddDriver()  ;
}
}
