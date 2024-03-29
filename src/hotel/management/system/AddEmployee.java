package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AddEmployee extends JFrame  implements ActionListener
{
   JTextField tfname,tfage,tfsalary,tfphone,tfemail,tfaadhar;
   JLabel lblname,lblage,lblsalary,lblphone,lblemail,lblgender,lbljob,lblaadhar; 
   JRadioButton rbmale,rbfemale;
   JButton submit,Back;
   JComboBox cbjob;
   AddEmployee()
    {
        setLayout(null);
        
        lblname = new JLabel("Name");
        lblname.setBounds(60,30,120,30);
        lblname.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(200,80,150,30);
        add(tfname);
        
        lblage = new JLabel("Age");
        lblage.setBounds(60,80,120,30);
        lblage.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblage);
        
        tfage = new JTextField();
        tfage.setBounds(200,30,150,30);
        add(tfage);
        
        lblgender = new JLabel("Gender");
        lblgender.setBounds(60,130,120,30);
        lblgender.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblgender);
        
        rbmale = new JRadioButton("Male");
        rbmale.setBounds(200,130 ,70 ,30 );
        rbmale.setBackground(Color.WHITE);
        rbmale.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(rbmale);
        
        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(280,130 ,70 ,30 );
        rbfemale.setBackground(Color.WHITE);
        rbfemale.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(rbfemale);
        
        ButtonGroup bg= new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);
        
        lbljob = new JLabel("Job");
        lbljob.setBounds(60,180,120,30);
        lbljob.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lbljob);
        
        
        String str[]={"Front Desk Clerks","Porters","HouserKeepin","Kitchen Staff","Room Service","Chef","Waiter/Waitress","Manager","Accountant"};
        cbjob = new JComboBox(str);
        cbjob.setBounds(200,180,150,30);
        cbjob.setBackground(Color.WHITE);
        add(cbjob); 
        
        lblsalary = new JLabel("Salary");
        lblsalary.setBounds(60,230,120,30);
        lblsalary.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblsalary);
        
        tfsalary = new JTextField();
        tfsalary.setBounds(200,230,150,30);
        add(tfsalary);
        
        lblphone = new JLabel("Phone");
        lblphone.setBounds(60,280,120,30);
        lblphone.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(200,280,150,30);
        add(tfphone);
        
        lblemail = new JLabel("Email");
        lblemail.setBounds(60,330,120,30);
        lblemail.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200,330,150,30);
        add(tfemail);
        
        lblaadhar = new JLabel("Aadhar No.");
        lblaadhar.setBounds(60,380,120,30);
        lblaadhar.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblaadhar);
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(200,380,150,30);
        add(tfaadhar);
        
        
        
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(200,430,150,30);
        submit.addActionListener(this);
        add(submit);
        
        Back = new JButton("Back");
        Back.setForeground(Color.WHITE);
        Back.setBackground(Color.BLACK);
        Back.setBounds(500,430,150,30);
        Back.addActionListener(this);
        add(Back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/employee.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400,400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(380,40,450,370);
        add(image);
        
        
        
        
        getContentPane().setBackground(Color.WHITE); 
        setBounds(350,200,850,540);
        setVisible(true);
        
    }
     @Override
    public void actionPerformed(ActionEvent e) 
    {
     String name = tfname.getText();
     String age = tfage.getText();
     String salary =tfsalary.getText();
     String phone = tfphone.getText();
     String email = tfemail.getText();
     String aadhar = tfaadhar.getText();
     if(e.getSource()==submit)
     {
     if(name.equals("")){
     JOptionPane.showMessageDialog(null,"Name is Empty" );
     }
     if(age.equals("")){
     JOptionPane.showMessageDialog(null,"Age is Empty" );
     }
     if(salary.equals("")){
     JOptionPane.showMessageDialog(null,"Salary is Empty" );
     }
     if(phone.equals("")){
     JOptionPane.showMessageDialog(null,"Phone is Empty" );
     }
     if(email.contains("@")&&equals("")){
     JOptionPane.showMessageDialog(null,"Invalid Email" );
     }
     if(aadhar.equals("")){
     JOptionPane.showMessageDialog(null,"Invalid Aadhar" );
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
     JOptionPane.showMessageDialog(null,"Gender is Empty" );
     }
      String job = (String)cbjob.getSelectedItem();
      try {
          Conn c= new Conn();
          String qr="insert into employee values('"+age+"','"+name+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+email+"','"+aadhar+"')";
          c.s.executeUpdate(qr);
          
          JOptionPane.showMessageDialog(null,"Employee added successfully");
          setVisible(false);
          new Reception();
      } 
      catch(Exception x)
      {
      x.printStackTrace();
      }
     }
     else if(e.getSource()==Back)
      {
          setVisible(false);
          new Dashboard();
      }
    }

    public static void main(String args[])
    {
        new AddEmployee();
    }

   }
