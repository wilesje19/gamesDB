/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamesdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Jeremy Wiles
 */
public class GamesDatabase {

    public static void main(String[] args) {
        final String QUERY = " select id, title, developer, "
                + "rating from games";
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/s2emp", "katie", "mucis");
                PreparedStatement stmt = con.prepareStatement(QUERY)) {
            System.out.println(stmt.toString());
            ResultSet rs = stmt.executeQuery(QUERY);
            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + ", "
                            + rs.getString("title") + ", "
                            + rs.getString("developer") + ", "
                            + rs.getDouble("rating"));
            }
        } catch (SQLException ex) {
            System.out.println("Retrieve SQLException: " + ex.getMessage());
        }
    }
    
}
