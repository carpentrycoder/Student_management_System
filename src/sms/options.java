package sms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class options extends JFrame implements ActionListener {

    JButton Attendance , marks , profile;
    options(){
        setSize(1000,300);

        profile = new JButton("Profile");
        profile.setBounds(180,100,200, 80);
        profile.addActionListener(this);
        add(profile);

        Attendance = new JButton("Attendance");
        Attendance.setBounds(400,100,200,80);
        Attendance.addActionListener(this);
        add(Attendance);

        marks = new JButton("Marks");
        marks.setBounds(620,100,200,80);
        marks.addActionListener(this);
        add(marks);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==Attendance){
            new attendence();
            this.setVisible(false);
        }
        if(ae.getSource()==marks){
            new viewMarks();
            this.setVisible(false);
        }
        if(ae.getSource()==profile){
            new viewDetails();
            this.setVisible(false);
        }

    }

    public static void main(String[] args) {
        new options();
    }
}