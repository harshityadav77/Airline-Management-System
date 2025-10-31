package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Statement;

public class AddCustomer extends JFrame implements ActionListener {

    JTextField tfname, tfaadhar, tfnation, tfaddress, tfphone;
    JRadioButton rbmale, rbfemale;

    public AddCustomer() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Add Customer Details");
        heading.setBounds(220, 20, 500, 35);
        heading.setFont(new Font("Arial", Font.BOLD, 32));
        heading.setForeground(Color.darkGray);
        add(heading);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60, 80, 150, 25);
        lblname.setFont(new Font("Arial", Font.BOLD, 16));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(220, 80, 150, 25);
        add(tfname);

        JLabel lblnation = new JLabel("Nationality");
        lblnation.setBounds(60, 130, 150, 25);
        lblnation.setFont(new Font("Arial", Font.BOLD, 16));
        add(lblnation);

        tfnation = new JTextField();
        tfnation.setBounds(220, 130, 150, 25);
        add(tfnation);

        JLabel lblaadhar = new JLabel("Aadhar Number");
        lblaadhar.setBounds(60, 180, 150, 25);
        lblaadhar.setFont(new Font("Arial", Font.BOLD, 16));
        add(lblaadhar);

        tfaadhar = new JTextField();
        tfaadhar.setBounds(220, 180, 150, 25);
        add(tfaadhar);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(60, 230, 150, 25);
        lbladdress.setFont(new Font("Arial", Font.BOLD, 16));
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(220, 230, 150, 25);
        add(tfaddress);

        ButtonGroup groupbutton = new ButtonGroup();

        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(60, 280, 150, 25);
        lblgender.setFont(new Font("Arial", Font.BOLD, 16));
        add(lblgender);

        rbmale = new JRadioButton("Male");
        rbmale.setBounds(220, 280, 70, 25);
        rbmale.setBackground(Color.WHITE);
        add(rbmale);

        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(300, 280, 70, 25);
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);

        groupbutton.add(rbmale);
        groupbutton.add(rbfemale);

        JLabel lblphone = new JLabel("Phone Number");
        lblphone.setBounds(60, 330, 150, 25);
        lblphone.setFont(new Font("Arial", Font.BOLD, 16));
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(220, 330, 150, 25);
        add(tfphone);

        JButton save = new JButton("SAVE");
        save.setBackground(Color.BLACK);
        save.setForeground(Color.WHITE);
        save.setBounds(220, 380, 150, 25);
        add(save);

        // Add ActionListener to SAVE button
        save.addActionListener(this);

        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/person.png"));
        Image img = image.getImage().getScaledInstance(280, 400, Image.SCALE_SMOOTH);
        ImageIcon scaledImage = new ImageIcon(img);
        JLabel lblimg = new JLabel(scaledImage);
        lblimg.setBounds(450, 80, 280, 400);
        add(lblimg);

        setSize(900, 600);
        setLocation(300, 150);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        String name = tfname.getText();
        String aadhar = tfaadhar.getText();
        String nationality = tfnation.getText();
        String address = tfaddress.getText();
        String phone = tfphone.getText();
        String gender = null;
        if (rbmale.isSelected()) {
            gender = "Male";
        } else if (rbfemale.isSelected()) {
            gender = "Female";
        } else {
            gender = ""; // or handle as needed for no selection
        }
        try {
            Conn conn = new Conn();
            String query = "INSERT INTO passenger (name, nationality, phone, address, aadhar, gender) VALUES ('" + name + "', '" + nationality + "', '" + phone + "', '" + address + "', '" + aadhar + "', '" + gender + "')";
            Statement stmt = conn.getStatement();
            stmt.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
            setVisible(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new AddCustomer();
    }

}
