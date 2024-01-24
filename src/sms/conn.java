package sms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class conn {
    Connection c;
    Statement s;

    conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/garibacha_wada", "root", "Yourpassword");
            s = c.createStatement();

        } catch (Exception e) {
            System.out.println(e);

        }
    }
}