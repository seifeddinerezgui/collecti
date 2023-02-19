/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package collecti.entity;
import collecti.entity.Categories;

/**
 *
 * @author acer
 */
public class pieces {
    private int id_piece;
    private String nom_piece;
    private String description;
    private int id_maison;
    private int prix_depart;
    private Categories cat;

    public pieces(int id_piece, String nom_piece, String description, int id_maison, int prix_depart, Categories cat) {
        this.id_piece = id_piece;
        this.nom_piece = nom_piece;
        this.description = description;
        this.id_maison = id_maison;
        this.prix_depart = prix_depart;
        this.cat = cat;
    }

    public int getId_piece() {
        return id_piece;
    }

    public void setId_piece(int id_piece) {
        this.id_piece = id_piece;
    }

    public String getNom_piece() {
        return nom_piece;
    }

    public void setNom_piece(String nom_piece) {
        this.nom_piece = nom_piece;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId_maison() {
        return id_maison;
    }

    public void setId_maison(int id_maison) {
        this.id_maison = id_maison;
    }

    public int getPrix_depart() {
        return prix_depart;
    }

    public void setPrix_depart(int prix_depart) {
        this.prix_depart = prix_depart;
    }

    public Categories getCat() {
        return cat;
    }

    public void setCat(Categories cat) {
        this.cat = cat;
    }

    @Override
    public String toString() {
        return "Pieces{" +
                "id_piece=" + id_piece +
                ", nom_piece='" + nom_piece + '\'' +
                ", description='" + description + '\'' +
                ", id_maison=" + id_maison +
                ", prix_depart=" + prix_depart +
                ", cat=" + cat +
                '}';
    }
}

