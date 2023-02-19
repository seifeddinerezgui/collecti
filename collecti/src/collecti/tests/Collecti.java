/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collecti.tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import collecti.entity.pieces;
import collecti.entity.Categories;
import collecti.services.PiecesServices;
import collecti.tools.Maconnection;
import collecti.services.CategoriesServices;
/**
 *
 * @author acer
 */
public class Collecti {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PiecesServices ps = new PiecesServices();
        CategoriesServices cs = new CategoriesServices();
    
   // Categories c1 = new Categories(1,"numismatique");
    Categories c2 = new Categories(2,"livres");
    Categories c3 = new Categories(3,"tableaux");
    
   //cs.ajouter(c1);
    cs.ajouter(c2);
    cs.ajouter(c3);
    
    
   // pieces p1 = new pieces (2,"dinar","dinar tounsi",2,1000,c1);
    // Ajouter la nouvelle instance à la base de données
   // ps.ajouter(p1);
    //System.out.println("La categorie a été ajoutée avec succès !");
    //ps.supprimer(p1);
    // ps.modifier(, p1);
        System.out.println(cs.getAll());
        System.out.println(ps.getAll());
    }
    
    
}
