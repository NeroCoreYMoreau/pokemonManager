package main.dal;

import main.bo.Pokemon;

import java.sql.*;

public class Connexion {
    public static Connection seConnecter() {
        String jdbc = "jdbc:sqlite:db.sqlite3";
        Connection cnx = null;
        try {
            cnx = DriverManager.getConnection(jdbc);
        } catch (SQLException e) {
            System.err.println("Erreur SQL " + e.getMessage());
        }
        return cnx;
    }
}
