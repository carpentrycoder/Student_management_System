package sms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class reg extends JFrame implements ActionListener {
    JButton signin, cancel ;
    JTextField username;
    JPasswordField password;

    reg() {
        setSize(600, 400);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("img/reg.png"));
        Image editedimg1 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        i1 = new ImageIcon(editedimg1);
        JLabel img = new JLabel(i1);
        img.setBounds(0, 0, 600, 400);
        add(img);

        JLabel l1 = new JLabel("Username");
        l1.setBounds(60, 80, 150, 50);
        l1.setFont(new Font("Tahoma", Font.BOLD, 20));
        l1.setForeground(Color.WHITE);
        img.add(l1);

        JLabel l2 = new JLabel("Password");
        l2.setBounds(60, 160, 150, 50);
        l2.setFont(new Font("Tahoma", Font.BOLD, 20));
        l2.setForeground(Color.white);
        img.add(l2);

        username = new JTextField();
        username.setBounds(250, 80, 200, 40);
        username.setFont(new Font("Segeo", Font.PLAIN, 24));
        img.add(username);

        password = new JPasswordField();
        password.setBounds(250, 160, 200, 40);
        img.add(password);

        signin = new JButton("Register");
        signin.setBounds(390, 280, 160, 50);
        signin.setFont(new Font("Tahoma", Font.BOLD, 17));
        signin.setBackground(Color.white);
        signin.addActionListener(this);
        img.add(signin);

        cancel = new JButton("Cancel");
        cancel.setBounds(40, 280, 100, 50);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 16));
        cancel.setBackground(Color.RED);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        img.add(cancel);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==signin){
            String username = this.username.getText();
            String password = String.valueOf(this.password.getPassword());

            conn c = new conn();
            try{
                String query = "insert into garibacha_wada.login ( username,password ) values ('"+username+"','"+password+"');";
//                c.s.executeQuery(query);
                  c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Registration Successfull!");
                    setVisible(false);
                    new addDetails();

            }catch (Exception e){
                JOptionPane.showMessageDialog(null,"enter as a guest");
                System.out.println(e);
                new addDetails();
            }
        }

        if(ae.getSource()== cancel){
            setVisible(false);
            new start();
        }


    }
    public static void main(String[] args) {
        new reg();
    }
}

