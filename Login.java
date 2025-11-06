
package airlinemanagementsystem;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JButton reset, submit,close;
     JPasswordField tfpass ;
     JTextField tfuser;
    
    public Login(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel lblusername = new JLabel("Username");
        add(lblusername);
        lblusername.setBounds(20,20,100,20);
        
         tfuser = new JTextField();
         tfuser.setBounds(130,20,200,20);
         add(tfuser);
         
         tfpass = new JPasswordField();
         tfpass.setBounds(130,60,200,20);
         add(tfpass);
         
         JLabel lblpass = new JLabel("Password");
        add(lblpass);
        lblpass.setBounds(20,60,100,20);
        
       reset = new JButton("Reset");
        add(reset);
        reset.setBounds(40,120,120,20);
        reset.addActionListener(this);
        
         submit = new JButton("Submit");
        add(submit);
        submit.setBounds(190,120,120,20);
        submit.addActionListener(this);
        
         close = new JButton("Close");
        add(close);
        close.setBounds(120,160,120,20);
        close.addActionListener(this);
        
        setSize(400,250);
        setLocation(600,250);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String username = tfuser.getText();
            String password = tfpass.getText();
            
            try {
                Conn c = new Conn();
                String query = "select * from login where username ='"+username+"' and password = '"+password+"'";
              
                 ResultSet rs = c.s.executeQuery(query);
                
                if(rs.next()){
                     new Home();
                    System.out.print("Valid");
                }
                else {
                    JOptionPane.showMessageDialog(null,"Invalid Username or Password");
                    setVisible(false);
                }
                
        } catch(Exception e){
            new Home();
            setVisible(false);
        }
            
        }
        if(ae.getSource() == reset){
           tfuser.setText("");
           tfpass.setText("");
        }
        if(ae.getSource() == close){
            setVisible(false);
        }
            
    }
    
    public static void main(String[]args){
        new Login();
    }
}
