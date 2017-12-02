package main.com.demo.testdb;

import org.slf4j.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Copyright 2017 by Filip Kusztelak
 * Created by f.kusztelak@gmail.com on 2017-12-02.
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(TestDbServlet.class);
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String USER = "demo";
    private static final String PASS = "demo";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // get connection to database
        try {
            PrintWriter out = response.getWriter();

            out.println("Connecting to database: " + JDBC_URL);

            Class.forName(DRIVER);

            Connection myConn = DriverManager.getConnection(JDBC_URL, USER, PASS);

            out.println("SUCCESS!");

            myConn.close();

        } catch (IOException | ClassNotFoundException | SQLException e) {
            LOGGER.error(e.getMessage());
        }
    }
}
