package sms;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.sql.ResultSet;

public class viewMarks extends JFrame {
    JTabbedPane tabs;
    JScrollPane sp1, sp2;
    JTable sem1, sem2;
    viewMarks(){
        setSize(1366,768);

        getContentPane().setBackground(new Color(0x6183C0));
        tabs = new JTabbedPane();
        tabs.setBounds(33, 34,1300,600);
        tabs.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(tabs);

        sem1 = new JTable();
        sem2 = new JTable();

        sp1 = new JScrollPane();
        sem1= new JTable();
        sem1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        sem1.setRowHeight(26);
        sp1.setViewportView(sem1);

        JTableHeader tb1 = sem1.getTableHeader();
        tb1.setFont(new Font("Tahoma", Font.BOLD, 22));
        tb1.setBackground(Color.cyan);

        sp2 = new JScrollPane();
        sp2.setViewportView(sem2);

        sem2= new JTable();
        sem2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        sem2.setRowHeight(26);
        sp2.setViewportView(sem2);

        JTableHeader tb2 = sem2.getTableHeader();
        tb2.setFont(new Font("Tahoma", Font.BOLD, 22));
        tb2.setBackground(Color.cyan);

        getDetails();

        tabs.addTab("SEM 1", sp1);
        tabs.addTab("SEM 2", sp2);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    void getDetails(){
        conn c = new conn();

//        sem1 marks fetching code
        String query1 = "select  name , english , maths , science from garibacha_wada.details;";
        try{
            ResultSet rs1 = c.s.executeQuery(query1);
            sem1.setModel(DbUtils.resultSetToTableModel(rs1));
        }catch (Exception e){
            System.out.println(e);
        }

//        sem 2 marks fetching code
        String query2 = "select  name, marathi , history, geography from garibacha_wada.details;";
        try{
            ResultSet rs2 = c.s.executeQuery(query2);
            sem2.setModel(DbUtils.resultSetToTableModel(rs2));
        }
        catch (Exception e){
            System.out.println(e);
        }
    }


    public static void main(String[] args) {
        new viewMarks();
    }
}