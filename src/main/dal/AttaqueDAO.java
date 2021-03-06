package main.dal;

import main.bo.Attaque;
import main.dal.interfaceDAO.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AttaqueDAO implements DAO<Attaque> {
    final static String SQL_INSERT = "INSERT INTO attaque (nom, force) values(?, ?)";
    final static String SQL_SELECT_ALL = "SELECT id, nom, force FROM attaque";
    final static String SQL_SELECT_1 = "SELECT id, nom, force FROM attaque WHERE id=?";
    final static String SQL_DELETE = "DELETE FROM attaque WHERE id=?";
    final static String SQL_UPDATE = "UPDATE attaque SET nom=?, force=? WHERE id=?";

    @Override
    public Attaque get(int id) {
        Attaque a = new Attaque();
        try (Connection cnx = Connexion.seConnecter(); PreparedStatement pstmt = cnx.prepareStatement(SQL_SELECT_1)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                a.setId(rs.getInt("id"));
                a.setNom(rs.getString("nom"));
                a.setForce(rs.getInt("force"));
            }
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getMessage());
        }
        return a;
    }

    @Override
    public List<Attaque> getAll() {
        // Retourne la liste des Pokémons en base
        List<Attaque> listeDesAttaques = new ArrayList<Attaque>();
        try (Connection cnx = Connexion.seConnecter(); Statement stmt = cnx.createStatement()) {
            ResultSet rs = stmt.executeQuery(SQL_SELECT_ALL);
            while (rs.next()) {
                Attaque attaqueCourante = new Attaque(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getInt("force")
                );
                listeDesAttaques.add(attaqueCourante);
            }
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getMessage());
        }
        return listeDesAttaques;
    }

    @Override
    public void update(Attaque attaqueAmodifier) {
        try (Connection cnx = Connexion.seConnecter(); PreparedStatement pstmt = cnx.prepareStatement(SQL_UPDATE)) {
            pstmt.setString(1, attaqueAmodifier.getNom());
            pstmt.setInt(2, attaqueAmodifier.getForce());
            pstmt.setInt(3, attaqueAmodifier.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getMessage());
        }
    }

    @Override
    public void delete(int idDeLattaqueASupprimmer) {
        try (Connection cnx = Connexion.seConnecter();
             PreparedStatement pstmt = cnx.prepareStatement(SQL_DELETE)
        ) {
            pstmt.setInt(1, idDeLattaqueASupprimmer);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getMessage());
        }
    }

    @Override
    public Attaque insert(Attaque attaqueAinserer) {
        int idGenere = 0;
        try (Connection cnx = Connexion.seConnecter();
             PreparedStatement pstmt = cnx.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)
        ) {
            pstmt.setString(1, attaqueAinserer.getNom());
            pstmt.setInt(2, attaqueAinserer.getForce());
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                idGenere = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getMessage());
        }
        attaqueAinserer.setId(idGenere);
        return attaqueAinserer;
    }
}