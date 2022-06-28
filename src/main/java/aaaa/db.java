/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aaaa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

/**
 *
 * @author Ajith reddy
 */
public class db {
    public static Connection mycon()
    { Connection con =null;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hosdb", "root", "Ajith@123"); }
        
    catch (ClassNotFoundException | SQLException e)
    { System.out.println(e.getMessage());
    }
    return con;
    }
    
}