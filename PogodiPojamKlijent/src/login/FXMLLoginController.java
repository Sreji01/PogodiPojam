/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package login;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Sreja
 */
public class FXMLLoginController {

    @FXML
    public TextField korisnickoIme;

    @FXML
    public TextField sifra;

    @FXML
    public Button prijavaBtn;
    
    @FXML
    public MenuItem registrujSe;

    /**
     * Initializes the controller class.
     */
    @FXML
    public void initialize() throws IllegalArgumentException, NoSuchFieldException, IllegalAccessException {
        KontrolerGUILogin kngui = new KontrolerGUILogin(this);
    }

    public Stage stage;

    void setStage(Stage stage) {
        this.stage = stage;
    }

    public void closeStage() {
        stage.close();
    }

}
