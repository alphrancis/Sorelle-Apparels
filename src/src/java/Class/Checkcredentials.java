package src.java.Class;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Checkcredentials {

    public boolean isCredentialCorrect(String username, String password) {
        
        String sUrl = "jdbc:mysql://localhost:3306/sofdes";
        String sUser = "root";
        String sPass = "";

        String query = "SELECT password FROM sofdes_admin WHERE username = ?";

        try (Connection con = DriverManager.getConnection(sUrl, sUser, sPass);
             PreparedStatement ps = con.prepareStatement(query)) {

            
            ps.setString(1, username);

            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                   
                    String passDb = rs.getString("password");

                    if (password != null && passDb != null) {
                        return password.equals(passDb);
                    } else {
                        System.out.println("One of the passwords is null.");
                    }
                } else {
                    System.out.println("Username not found in the database.");
                }
            }
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }
}
