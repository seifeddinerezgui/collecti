/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collecti.gui;

import collecti.entity.Categories;
import collecti.entity.pieces;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import collecti.services.CategoriesServices;
import collecti.services.PiecesServices;
import static java.awt.SystemColor.control;

/**
 * FXML Controller class
 *
 * @author acer
 */
public class AjouterCatController implements Initializable {

    @FXML
    private TextField tfidcat;
    @FXML
    private TextField tfnomcat;
    @FXML
    private Button ajouterbtn;
    
    CategoriesServices cs = new CategoriesServices();
    @FXML
    private Button display;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AjouterCat(ActionEvent event) {
        if (tfnomcat.getText().isEmpty()|| tfidcat.getText().isEmpty()){
        control.setText("field is empty");
        }else{
        
        Categories p = new Categories();
        p.setIdCat(Integer.parseInt(tfidcat.getText()));
        p.setNomCat(tfnomcat.getText());
        try {
            cs.ajouter(p);
            reset();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }}

    private void reset() {
        tfidcat.setText("");
        tfnomcat.setText("");
        
    }

    @FXML
    private void displayAction(ActionEvent event) {
    }
    }
    
}
