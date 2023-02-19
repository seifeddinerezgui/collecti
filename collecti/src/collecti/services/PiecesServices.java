/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collecti.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import collecti.services.InterfaceServices;
import collecti.entity.pieces;
import collecti.entity.Categories;
import collecti.tools.Maconnection;
/**
 *
 * @author acer
 */

    public class PiecesServices implements InterfaceServices<pieces> {

    Connection cnx;

    public PiecesServices() {
        cnx = Maconnection.getInstance().getCnx();
    }

    @Override
    public void ajouter(pieces p) {
        try {
            String sql = "insert into pieces(id_piece,nom_piece, description, id_maison, prix_depart,cat) values (?, ?, ?, ?, ?,?)";
            PreparedStatement ps = cnx.prepareStatement(sql);
            ps.setInt(1, p.getId_piece());
            ps.setString(2, p.getNom_piece());
            ps.setString(3, p.getDescription());
            ps.setInt(4, p.getId_maison());
            ps.setInt(5, p.getPrix_depart());
            ps.setInt(6, p.getCat().getIdCat());
            ps.executeUpdate();
            System.out.println("La pièce " + p.getNom_piece() + " a été ajoutée avec succès !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<pieces> getAll() {
        List<pieces> pieces = new ArrayList<>();
        try {
            String sql = "select * from pieces";
            Statement stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                pieces p = new pieces(
                        rs.getInt("id_piece"),
                        rs.getString("nom_piece"),
                        rs.getString("description"),
                        rs.getInt("id_maison"),
                        rs.getInt("prix_depart"),
                        new Categories(rs.getInt("id_cat"), rs.getString("nom_cat"))
                );
                pieces.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return pieces;
    }

    @Override
    public List<pieces> findById(int id) {
        List<pieces> pieces = new ArrayList<>();
        try {
            String sql = "select * from pieces where id_piece=?";
            PreparedStatement ps = cnx.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                pieces p = new pieces(
                        rs.getInt("id_piece"),
                        rs.getString("nom_piece"),
                        rs.getString("description"),
                        rs.getInt("id_maison"),
                        rs.getInt("prix_depart"),
                        new Categories(rs.getInt("id_cat"), rs.getString("nom_cat"))
                );
                pieces.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return pieces;
    }

    public void supprimer(pieces p) {
        try {
            String sql = "delete from pieces where id_piece=?";
            PreparedStatement ps = cnx.prepareStatement(sql);
            ps.setInt(1, p.getId_piece());
            ps.executeUpdate();
            System.out.println("La pièce " + p.getNom_piece() + " a été supprimée avec succès !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void modifier(pieces p) {
        String sql = "update pieces set nom_piece=?, description=?, id_maison=?, prix_depart=?, cat=? where id_piece=?";
        try {
            PreparedStatement ste = cnx.prepareStatement(sql);
            ste.setString(1, p.getNom_piece());
            ste.setString(2, p.getDescription());
            ste.setInt(3, p.getId_maison());
            ste.setInt(4, p.getPrix_depart());
            ste.setString(5,String.valueOf(p.getCat().getIdCat()));
            ste.setInt(6, p.getId_piece());
            ste.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    }