/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package glavnaforma;

import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Sreja
 */
public class FXMLGlavnaFormaController {

    @FXML
    public Menu igra; 
    @FXML
    public Menu rezultati;
    @FXML
    public Menu izlaz;
                
              
    @FXML
    public MenuItem zapocniIgru;
    @FXML
    public MenuItem pogledajRangListu;
    @FXML
    public MenuItem izlazIzIgre;
    
    /**
     * Initializes the controller class.
     */
    @FXML
    public void initialize() {
        KointrolerGuiGlavnaForma kngui = new KointrolerGuiGlavnaForma(this);
    }    
    
    public Stage stage;

    void setStage(Stage stage) {
        this.stage = stage;
    }

    public void closeStage() {
        stage.close();
    }  
    
}
