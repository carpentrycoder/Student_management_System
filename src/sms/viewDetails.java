package sms;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.sql.ResultSet;

public class viewDetails extends JFrame {

    JScrollPane sp1;
    JTable details;
    viewDetails(){
        setSize(1000,700);
        sp1 = new JScrollPane();
        sp1.setBounds(50,100,900,400);
        add(sp1);

        details = new JTable();
        details.setFont(new Font("Tahoma", Font.PLAIN, 18));
        details.setRowHeight(26);

        sp1.setViewportView(details);

        JTableHeader tb1 = details.getTableHeader();
        tb1.setFont(new Font("Tahoma", Font.BOLD, 22));
        tb1.setBackground(Color.CYAN);

        getDetails();

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    void getDetails(){
        // code to fetch the data from MySQL
        conn c = new conn();
        String query = "select name, gr, bldgrp, dob, address, aadhar, gender, contact from garibacha_wada.details;";
        try {
            ResultSet rs =  c.s.executeQuery(query);

            if (rs.next()) {  // Check if there are rows in the result set
                details.setModel(DbUtils.resultSetToTableModel(rs));
                // Set preferred widths after setting the model
                details.getColumnModel().getColumn(0).setPreferredWidth(100);
                details.getColumnModel().getColumn(1).setPreferredWidth(15);
                details.getColumnModel().getColumn(2).setPreferredWidth(50);
                details.getColumnModel().getColumn(3).setPreferredWidth(100);
                details.getColumnModel().getColumn(4).setPreferredWidth(250);
                details.getColumnModel().getColumn(5).setPreferredWidth(100);
                details.getColumnModel().getColumn(6).setPreferredWidth(50);
                details.getColumnModel().getColumn(7).setPreferredWidth(70);
            } else {
                // Handle the case where there are no rows in the result set
                System.out.println("No data found in the result set.");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public static void main(String[] args) {
        new viewDetails();
    }
}