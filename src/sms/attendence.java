package sms;

import javax.swing.*;
import java.awt.*;

public class attendence extends JFrame {

    Font font = new Font("Tahoma", Font.BOLD|Font.ITALIC,40);

    attendence()
    {
      setSize(700,500);
      setLayout(null);

      getContentPane().setBackground(new Color(0x525151));

      JLabel v = new JLabel("Attendence Section");
      v.setFont(font);
      v.setBounds(160,20,500,40);
      v.setForeground(Color.WHITE);
      add(v);

      setLocationRelativeTo(null);
      setVisible(true);
    }
    public static void main(String[] args) {
        new attendence();
    }
}
