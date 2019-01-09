/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Sakibul
 */
public class DatabaseHelper {
    public static Connection getDBConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myproject", "root", "123");
            return con;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        
    }
}
