package sms;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class start extends JFrame implements ActionListener {

    JButton login,signin;

    start(){
        setSize(800,600);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("img/first.png"));
        Image editedimg1 = i1.getImage().getScaledInstance(800,600,Image.SCALE_DEFAULT);
        i1 = new ImageIcon(editedimg1);
        JLabel lb1 = new JLabel(i1);
        lb1.setBounds(0,0,800,600);
        add(lb1);

        login = new JButton("LOGIN");
        login.setFont(new Font("tahoma",Font.BOLD,22));
        login.setBounds(600,490,150,80);
        login.setBackground(Color.WHITE);
        login.addActionListener(this);
        lb1.add(login);

        signin = new JButton("REGISTER");
        signin.setBounds(380, 490, 160, 80);
        signin.setFont(new Font("Tahoma", Font.BOLD, 22));
        signin.setBackground(Color.white);
        signin.addActionListener(this);
        lb1.add(signin);

        setUndecorated(true);
        setLayout(null);
        setLocationRelativeTo(null);//takes the frame to center
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==login){
            setVisible(false);
            new login();
        } else if (ae.getSource()==signin) {
            setVisible(false);
            new reg();
        }
    }

    public static void main(String[] args) {
        new start();
    }
}