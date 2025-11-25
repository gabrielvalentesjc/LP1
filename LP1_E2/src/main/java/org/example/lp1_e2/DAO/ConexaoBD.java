package org.example.lp1_e2.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
    // Ajuste usuário e senha conforme sua instalação do MySQL
    private static final String URL = "jdbc:mysql://localhost:3307/lp1_e2";
    private static final String USER = "root";
    private static final String PASS = "Fatec@2025";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}