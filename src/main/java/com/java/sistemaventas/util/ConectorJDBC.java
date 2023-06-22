package com.java.sistemaventas.util;

/**
 *
 * @author MarckTK
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectorJDBC {
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/bd_ventas?user=root&password=";
        return DriverManager.getConnection(url);
    }
}
