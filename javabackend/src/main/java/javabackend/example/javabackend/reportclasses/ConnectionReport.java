package javabackend.example.javabackend;

import com.javabackend.example.javabackend.models.Products;
import com.javabackend.example.javabackend.repositories.ProductsRepository;
import com.javabackend.example.javabackend.service.ProductsService;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



private class ConnectionReport {

    private final String URLConnection;

    private static ConnectionReport instance;

    private ConnectionReport() {
        URLConnection = "jdbc:mysql://localhost:3306/websitedb19";
    }


    public Connection getConnection() {
        try {
            return DriverManager.getConnection(URLConnection);
        } catch (SQLException e) {
            System.err.println("failed to connect to the database: " + e.getMessage());
        }
        return null;
    }
    public static ConnectionReport getInstance() {
        if (instance == null) {
            instance = new ConnectionReport();
        }
        return instance;

//    // Create a connection to the database
//    Connection conc = DriverManager.getConnection("jdbc:mysql://localhost:3306/websited19");
//
//
//    // Close the database connection
//    conc.close();


}